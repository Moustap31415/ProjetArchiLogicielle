package sn.edu.ugb.grade.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.grade.domain.SessionExamen;
import sn.edu.ugb.grade.repository.SessionExamenRepository;
import sn.edu.ugb.grade.service.dto.SessionExamenDTO;
import sn.edu.ugb.grade.service.mapper.SessionExamenMapper;

/**
 * Service Implementation for managing {@link sn.edu.ugb.grade.domain.SessionExamen}.
 */
@Service
@Transactional
public class SessionExamenService {

    private static final Logger LOG = LoggerFactory.getLogger(SessionExamenService.class);

    private final SessionExamenRepository sessionExamenRepository;

    private final SessionExamenMapper sessionExamenMapper;

    public SessionExamenService(SessionExamenRepository sessionExamenRepository, SessionExamenMapper sessionExamenMapper) {
        this.sessionExamenRepository = sessionExamenRepository;
        this.sessionExamenMapper = sessionExamenMapper;
    }

    /**
     * Save a sessionExamen.
     *
     * @param sessionExamenDTO the entity to save.
     * @return the persisted entity.
     */
    public SessionExamenDTO save(SessionExamenDTO sessionExamenDTO) {
        LOG.debug("Request to save SessionExamen : {}", sessionExamenDTO);
        SessionExamen sessionExamen = sessionExamenMapper.toEntity(sessionExamenDTO);
        sessionExamen = sessionExamenRepository.save(sessionExamen);
        return sessionExamenMapper.toDto(sessionExamen);
    }

    /**
     * Update a sessionExamen.
     *
     * @param sessionExamenDTO the entity to save.
     * @return the persisted entity.
     */
    public SessionExamenDTO update(SessionExamenDTO sessionExamenDTO) {
        LOG.debug("Request to update SessionExamen : {}", sessionExamenDTO);
        SessionExamen sessionExamen = sessionExamenMapper.toEntity(sessionExamenDTO);
        sessionExamen = sessionExamenRepository.save(sessionExamen);
        return sessionExamenMapper.toDto(sessionExamen);
    }

    /**
     * Partially update a sessionExamen.
     *
     * @param sessionExamenDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<SessionExamenDTO> partialUpdate(SessionExamenDTO sessionExamenDTO) {
        LOG.debug("Request to partially update SessionExamen : {}", sessionExamenDTO);

        return sessionExamenRepository
            .findById(sessionExamenDTO.getId())
            .map(existingSessionExamen -> {
                sessionExamenMapper.partialUpdate(existingSessionExamen, sessionExamenDTO);

                return existingSessionExamen;
            })
            .map(sessionExamenRepository::save)
            .map(sessionExamenMapper::toDto);
    }

    /**
     * Get all the sessionExamen.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<SessionExamenDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all SessionExamen");
        return sessionExamenRepository.findAll(pageable).map(sessionExamenMapper::toDto);
    }

    /**
     * Get one sessionExamen by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SessionExamenDTO> findOne(Long id) {
        LOG.debug("Request to get SessionExamen : {}", id);
        return sessionExamenRepository.findById(id).map(sessionExamenMapper::toDto);
    }

    /**
     * Delete the sessionExamen by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        LOG.debug("Request to delete SessionExamen : {}", id);
        sessionExamenRepository.deleteById(id);
    }
}
