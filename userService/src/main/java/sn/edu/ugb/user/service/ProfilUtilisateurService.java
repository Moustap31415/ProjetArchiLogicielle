package sn.edu.ugb.user.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.user.domain.ProfilUtilisateur;
import sn.edu.ugb.user.repository.ProfilUtilisateurRepository;
import sn.edu.ugb.user.service.dto.ProfilUtilisateurDTO;
import sn.edu.ugb.user.service.mapper.ProfilUtilisateurMapper;

/**
 * Service Implementation for managing {@link sn.edu.ugb.user.domain.ProfilUtilisateur}.
 */
@Service
@Transactional
public class ProfilUtilisateurService {

    private static final Logger LOG = LoggerFactory.getLogger(ProfilUtilisateurService.class);

    private final ProfilUtilisateurRepository profilUtilisateurRepository;

    private final ProfilUtilisateurMapper profilUtilisateurMapper;

    public ProfilUtilisateurService(
        ProfilUtilisateurRepository profilUtilisateurRepository,
        ProfilUtilisateurMapper profilUtilisateurMapper
    ) {
        this.profilUtilisateurRepository = profilUtilisateurRepository;
        this.profilUtilisateurMapper = profilUtilisateurMapper;
    }

    /**
     * Save a profilUtilisateur.
     *
     * @param profilUtilisateurDTO the entity to save.
     * @return the persisted entity.
     */
    public ProfilUtilisateurDTO save(ProfilUtilisateurDTO profilUtilisateurDTO) {
        LOG.debug("Request to save ProfilUtilisateur : {}", profilUtilisateurDTO);
        ProfilUtilisateur profilUtilisateur = profilUtilisateurMapper.toEntity(profilUtilisateurDTO);
        profilUtilisateur = profilUtilisateurRepository.save(profilUtilisateur);
        return profilUtilisateurMapper.toDto(profilUtilisateur);
    }

    /**
     * Update a profilUtilisateur.
     *
     * @param profilUtilisateurDTO the entity to save.
     * @return the persisted entity.
     */
    public ProfilUtilisateurDTO update(ProfilUtilisateurDTO profilUtilisateurDTO) {
        LOG.debug("Request to update ProfilUtilisateur : {}", profilUtilisateurDTO);
        ProfilUtilisateur profilUtilisateur = profilUtilisateurMapper.toEntity(profilUtilisateurDTO);
        profilUtilisateur = profilUtilisateurRepository.save(profilUtilisateur);
        return profilUtilisateurMapper.toDto(profilUtilisateur);
    }

    /**
     * Partially update a profilUtilisateur.
     *
     * @param profilUtilisateurDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ProfilUtilisateurDTO> partialUpdate(ProfilUtilisateurDTO profilUtilisateurDTO) {
        LOG.debug("Request to partially update ProfilUtilisateur : {}", profilUtilisateurDTO);

        return profilUtilisateurRepository
            .findById(profilUtilisateurDTO.getId())
            .map(existingProfilUtilisateur -> {
                profilUtilisateurMapper.partialUpdate(existingProfilUtilisateur, profilUtilisateurDTO);

                return existingProfilUtilisateur;
            })
            .map(profilUtilisateurRepository::save)
            .map(profilUtilisateurMapper::toDto);
    }

    /**
     * Get all the profilUtilisateurs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProfilUtilisateurDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all ProfilUtilisateurs");
        return profilUtilisateurRepository.findAll(pageable).map(profilUtilisateurMapper::toDto);
    }

    /**
     * Get one profilUtilisateur by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProfilUtilisateurDTO> findOne(Long id) {
        LOG.debug("Request to get ProfilUtilisateur : {}", id);
        return profilUtilisateurRepository.findById(id).map(profilUtilisateurMapper::toDto);
    }

    /**
     * Delete the profilUtilisateur by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        LOG.debug("Request to delete ProfilUtilisateur : {}", id);
        profilUtilisateurRepository.deleteById(id);
    }
}
