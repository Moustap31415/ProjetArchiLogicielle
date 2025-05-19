package sn.edu.ugb.student.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.student.client.UserServiceClient;
import sn.edu.ugb.student.domain.Etudiant;
import sn.edu.ugb.student.repository.EtudiantRepository;
import sn.edu.ugb.student.service.dto.EtudiantDTO;
import sn.edu.ugb.student.service.dto.ProfilUtilisateurDTO;
import sn.edu.ugb.student.service.mapper.EtudiantMapper;

@Service
@Transactional
public class EtudiantService {

    private final Logger log = LoggerFactory.getLogger(EtudiantService.class);

    private final EtudiantRepository etudiantRepository;

    private final EtudiantMapper etudiantMapper;

    private final UserServiceClient userServiceClient;

    public EtudiantService(
        EtudiantRepository etudiantRepository,
        EtudiantMapper etudiantMapper,
        UserServiceClient userServiceClient
    ) {
        this.etudiantRepository = etudiantRepository;
        this.etudiantMapper = etudiantMapper;
        this.userServiceClient = userServiceClient;
    }

    public EtudiantDTO save(EtudiantDTO etudiantDTO) {
        log.debug("Request to save Etudiant : {}", etudiantDTO);
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDTO);
        etudiant = etudiantRepository.save(etudiant);
        return etudiantMapper.toDto(etudiant);
    }

    public EtudiantDTO update(EtudiantDTO etudiantDTO) {
        log.debug("Request to update Etudiant : {}", etudiantDTO);
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDTO);
        etudiant = etudiantRepository.save(etudiant);
        return etudiantMapper.toDto(etudiant);
    }

    public Optional<EtudiantDTO> partialUpdate(EtudiantDTO etudiantDTO) {
        log.debug("Request to partially update Etudiant : {}", etudiantDTO);

        return etudiantRepository
            .findById(etudiantDTO.getId())
            .map(existingEtudiant -> {
                etudiantMapper.partialUpdate(existingEtudiant, etudiantDTO);

                return existingEtudiant;
            })
            .map(etudiantRepository::save)
            .map(etudiantMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<EtudiantDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Etudiants");
        return etudiantRepository.findAll(pageable).map(etudiantMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<EtudiantDTO> findOne(Long id) {
        log.debug("Request to get Etudiant : {}", id);
        return etudiantRepository.findById(id).map(etudiantMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Etudiant : {}", id);
        etudiantRepository.deleteById(id);
    }

    public ProfilUtilisateurDTO getProfilUtilisateurForEtudiant(Long etudiantId) {
        return etudiantRepository.findById(etudiantId)
            .map(Etudiant::getUtilisateurId)
            .map(userServiceClient::getProfilUtilisateur)
            .orElse(null);
    }
}
