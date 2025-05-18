package sn.edu.ugb.curriculum.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.curriculum.domain.UniteEnseignement;
import sn.edu.ugb.curriculum.repository.UniteEnseignementRepository;
import sn.edu.ugb.curriculum.service.dto.UniteEnseignementDTO;
import sn.edu.ugb.curriculum.service.mapper.UniteEnseignementMapper;

/**
 * Service Implementation for managing {@link sn.edu.ugb.curriculum.domain.UniteEnseignement}.
 */
@Service
@Transactional
public class UniteEnseignementService {

    private static final Logger LOG = LoggerFactory.getLogger(UniteEnseignementService.class);

    private final UniteEnseignementRepository uniteEnseignementRepository;

    private final UniteEnseignementMapper uniteEnseignementMapper;

    public UniteEnseignementService(
        UniteEnseignementRepository uniteEnseignementRepository,
        UniteEnseignementMapper uniteEnseignementMapper
    ) {
        this.uniteEnseignementRepository = uniteEnseignementRepository;
        this.uniteEnseignementMapper = uniteEnseignementMapper;
    }

    /**
     * Save a uniteEnseignement.
     *
     * @param uniteEnseignementDTO the entity to save.
     * @return the persisted entity.
     */
    public UniteEnseignementDTO save(UniteEnseignementDTO uniteEnseignementDTO) {
        LOG.debug("Request to save UniteEnseignement : {}", uniteEnseignementDTO);
        UniteEnseignement uniteEnseignement = uniteEnseignementMapper.toEntity(uniteEnseignementDTO);
        uniteEnseignement = uniteEnseignementRepository.save(uniteEnseignement);
        return uniteEnseignementMapper.toDto(uniteEnseignement);
    }

    /**
     * Update a uniteEnseignement.
     *
     * @param uniteEnseignementDTO the entity to save.
     * @return the persisted entity.
     */
    public UniteEnseignementDTO update(UniteEnseignementDTO uniteEnseignementDTO) {
        LOG.debug("Request to update UniteEnseignement : {}", uniteEnseignementDTO);
        UniteEnseignement uniteEnseignement = uniteEnseignementMapper.toEntity(uniteEnseignementDTO);
        uniteEnseignement = uniteEnseignementRepository.save(uniteEnseignement);
        return uniteEnseignementMapper.toDto(uniteEnseignement);
    }

    /**
     * Partially update a uniteEnseignement.
     *
     * @param uniteEnseignementDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<UniteEnseignementDTO> partialUpdate(UniteEnseignementDTO uniteEnseignementDTO) {
        LOG.debug("Request to partially update UniteEnseignement : {}", uniteEnseignementDTO);

        return uniteEnseignementRepository
            .findById(uniteEnseignementDTO.getId())
            .map(existingUniteEnseignement -> {
                uniteEnseignementMapper.partialUpdate(existingUniteEnseignement, uniteEnseignementDTO);

                return existingUniteEnseignement;
            })
            .map(uniteEnseignementRepository::save)
            .map(uniteEnseignementMapper::toDto);
    }

    /**
     * Get all the uniteEnseignements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UniteEnseignementDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all UniteEnseignements");
        return uniteEnseignementRepository.findAll(pageable).map(uniteEnseignementMapper::toDto);
    }

    /**
     * Get one uniteEnseignement by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UniteEnseignementDTO> findOne(Long id) {
        LOG.debug("Request to get UniteEnseignement : {}", id);
        return uniteEnseignementRepository.findById(id).map(uniteEnseignementMapper::toDto);
    }

    /**
     * Delete the uniteEnseignement by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        LOG.debug("Request to delete UniteEnseignement : {}", id);
        uniteEnseignementRepository.deleteById(id);
    }
}
