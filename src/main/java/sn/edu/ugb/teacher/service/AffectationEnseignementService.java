package sn.edu.ugb.teacher.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.teacher.domain.AffectationEnseignement;
import sn.edu.ugb.teacher.repository.AffectationEnseignementRepository;
import sn.edu.ugb.teacher.service.dto.AffectationEnseignementDTO;
import sn.edu.ugb.teacher.service.mapper.AffectationEnseignementMapper;

/**
 * Service Implementation for managing {@link sn.edu.ugb.teacher.domain.AffectationEnseignement}.
 */
@Service
@Transactional
public class AffectationEnseignementService {

    private static final Logger LOG = LoggerFactory.getLogger(AffectationEnseignementService.class);

    private final AffectationEnseignementRepository affectationEnseignementRepository;

    private final AffectationEnseignementMapper affectationEnseignementMapper;

    public AffectationEnseignementService(
        AffectationEnseignementRepository affectationEnseignementRepository,
        AffectationEnseignementMapper affectationEnseignementMapper
    ) {
        this.affectationEnseignementRepository = affectationEnseignementRepository;
        this.affectationEnseignementMapper = affectationEnseignementMapper;
    }

    /**
     * Save a affectationEnseignement.
     *
     * @param affectationEnseignementDTO the entity to save.
     * @return the persisted entity.
     */
    public AffectationEnseignementDTO save(AffectationEnseignementDTO affectationEnseignementDTO) {
        LOG.debug("Request to save AffectationEnseignement : {}", affectationEnseignementDTO);
        AffectationEnseignement affectationEnseignement = affectationEnseignementMapper.toEntity(affectationEnseignementDTO);
        affectationEnseignement = affectationEnseignementRepository.save(affectationEnseignement);
        return affectationEnseignementMapper.toDto(affectationEnseignement);
    }

    /**
     * Update a affectationEnseignement.
     *
     * @param affectationEnseignementDTO the entity to save.
     * @return the persisted entity.
     */
    public AffectationEnseignementDTO update(AffectationEnseignementDTO affectationEnseignementDTO) {
        LOG.debug("Request to update AffectationEnseignement : {}", affectationEnseignementDTO);
        AffectationEnseignement affectationEnseignement = affectationEnseignementMapper.toEntity(affectationEnseignementDTO);
        affectationEnseignement = affectationEnseignementRepository.save(affectationEnseignement);
        return affectationEnseignementMapper.toDto(affectationEnseignement);
    }

    /**
     * Partially update a affectationEnseignement.
     *
     * @param affectationEnseignementDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<AffectationEnseignementDTO> partialUpdate(AffectationEnseignementDTO affectationEnseignementDTO) {
        LOG.debug("Request to partially update AffectationEnseignement : {}", affectationEnseignementDTO);

        return affectationEnseignementRepository
            .findById(affectationEnseignementDTO.getId())
            .map(existingAffectationEnseignement -> {
                affectationEnseignementMapper.partialUpdate(existingAffectationEnseignement, affectationEnseignementDTO);

                return existingAffectationEnseignement;
            })
            .map(affectationEnseignementRepository::save)
            .map(affectationEnseignementMapper::toDto);
    }

    /**
     * Get all the affectationEnseignements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AffectationEnseignementDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all AffectationEnseignements");
        return affectationEnseignementRepository.findAll(pageable).map(affectationEnseignementMapper::toDto);
    }

    /**
     * Get one affectationEnseignement by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AffectationEnseignementDTO> findOne(Long id) {
        LOG.debug("Request to get AffectationEnseignement : {}", id);
        return affectationEnseignementRepository.findById(id).map(affectationEnseignementMapper::toDto);
    }

    /**
     * Delete the affectationEnseignement by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        LOG.debug("Request to delete AffectationEnseignement : {}", id);
        affectationEnseignementRepository.deleteById(id);
    }
}
