package sn.edu.ugb.curriculum.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.curriculum.domain.Matiere;
import sn.edu.ugb.curriculum.repository.MatiereRepository;
import sn.edu.ugb.curriculum.service.dto.MatiereDTO;
import sn.edu.ugb.curriculum.service.mapper.MatiereMapper;

/**
 * Service Implementation for managing {@link sn.edu.ugb.curriculum.domain.Matiere}.
 */
@Service
@Transactional
public class MatiereService {

    private static final Logger LOG = LoggerFactory.getLogger(MatiereService.class);

    private final MatiereRepository matiereRepository;

    private final MatiereMapper matiereMapper;

    public MatiereService(MatiereRepository matiereRepository, MatiereMapper matiereMapper) {
        this.matiereRepository = matiereRepository;
        this.matiereMapper = matiereMapper;
    }

    /**
     * Save a matiere.
     *
     * @param matiereDTO the entity to save.
     * @return the persisted entity.
     */
    public MatiereDTO save(MatiereDTO matiereDTO) {
        LOG.debug("Request to save Matiere : {}", matiereDTO);
        Matiere matiere = matiereMapper.toEntity(matiereDTO);
        matiere = matiereRepository.save(matiere);
        return matiereMapper.toDto(matiere);
    }

    /**
     * Update a matiere.
     *
     * @param matiereDTO the entity to save.
     * @return the persisted entity.
     */
    public MatiereDTO update(MatiereDTO matiereDTO) {
        LOG.debug("Request to update Matiere : {}", matiereDTO);
        Matiere matiere = matiereMapper.toEntity(matiereDTO);
        matiere = matiereRepository.save(matiere);
        return matiereMapper.toDto(matiere);
    }

    /**
     * Partially update a matiere.
     *
     * @param matiereDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MatiereDTO> partialUpdate(MatiereDTO matiereDTO) {
        LOG.debug("Request to partially update Matiere : {}", matiereDTO);

        return matiereRepository
            .findById(matiereDTO.getId())
            .map(existingMatiere -> {
                matiereMapper.partialUpdate(existingMatiere, matiereDTO);

                return existingMatiere;
            })
            .map(matiereRepository::save)
            .map(matiereMapper::toDto);
    }

    /**
     * Get all the matieres.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MatiereDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Matieres");
        return matiereRepository.findAll(pageable).map(matiereMapper::toDto);
    }

    /**
     * Get one matiere by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MatiereDTO> findOne(Long id) {
        LOG.debug("Request to get Matiere : {}", id);
        return matiereRepository.findById(id).map(matiereMapper::toDto);
    }

    /**
     * Delete the matiere by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        LOG.debug("Request to delete Matiere : {}", id);
        matiereRepository.deleteById(id);
    }
}
