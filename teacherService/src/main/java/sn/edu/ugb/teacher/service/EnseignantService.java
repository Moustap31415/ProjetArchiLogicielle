package sn.edu.ugb.teacher.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.teacher.domain.Enseignant;
import sn.edu.ugb.teacher.repository.EnseignantRepository;
import sn.edu.ugb.teacher.service.dto.EnseignantDTO;
import sn.edu.ugb.teacher.service.mapper.EnseignantMapper;

/**
 * Service Implementation for managing {@link sn.edu.ugb.teacher.domain.Enseignant}.
 */
@Service
@Transactional
public class EnseignantService {

    private static final Logger LOG = LoggerFactory.getLogger(EnseignantService.class);

    private final EnseignantRepository enseignantRepository;

    private final EnseignantMapper enseignantMapper;

    public EnseignantService(EnseignantRepository enseignantRepository, EnseignantMapper enseignantMapper) {
        this.enseignantRepository = enseignantRepository;
        this.enseignantMapper = enseignantMapper;
    }

    /**
     * Save a enseignant.
     *
     * @param enseignantDTO the entity to save.
     * @return the persisted entity.
     */
    public EnseignantDTO save(EnseignantDTO enseignantDTO) {
        LOG.debug("Request to save Enseignant : {}", enseignantDTO);
        Enseignant enseignant = enseignantMapper.toEntity(enseignantDTO);
        enseignant = enseignantRepository.save(enseignant);
        return enseignantMapper.toDto(enseignant);
    }

    /**
     * Update a enseignant.
     *
     * @param enseignantDTO the entity to save.
     * @return the persisted entity.
     */
    public EnseignantDTO update(EnseignantDTO enseignantDTO) {
        LOG.debug("Request to update Enseignant : {}", enseignantDTO);
        Enseignant enseignant = enseignantMapper.toEntity(enseignantDTO);
        enseignant = enseignantRepository.save(enseignant);
        return enseignantMapper.toDto(enseignant);
    }

    /**
     * Partially update a enseignant.
     *
     * @param enseignantDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<EnseignantDTO> partialUpdate(EnseignantDTO enseignantDTO) {
        LOG.debug("Request to partially update Enseignant : {}", enseignantDTO);

        return enseignantRepository
            .findById(enseignantDTO.getId())
            .map(existingEnseignant -> {
                enseignantMapper.partialUpdate(existingEnseignant, enseignantDTO);

                return existingEnseignant;
            })
            .map(enseignantRepository::save)
            .map(enseignantMapper::toDto);
    }

    /**
     * Get all the enseignants.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<EnseignantDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Enseignants");
        return enseignantRepository.findAll(pageable).map(enseignantMapper::toDto);
    }

    /**
     * Get one enseignant by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EnseignantDTO> findOne(Long id) {
        LOG.debug("Request to get Enseignant : {}", id);
        return enseignantRepository.findById(id).map(enseignantMapper::toDto);
    }

    /**
     * Delete the enseignant by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        LOG.debug("Request to delete Enseignant : {}", id);
        enseignantRepository.deleteById(id);
    }
}
