package sn.edu.ugb.student.web.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sn.edu.ugb.student.repository.HistoriqueAcademiqueRepository;
import sn.edu.ugb.student.service.HistoriqueAcademiqueService;
import sn.edu.ugb.student.service.dto.HistoriqueAcademiqueDTO;
import sn.edu.ugb.student.client.CursusServiceClient;
import sn.edu.ugb.student.service.dto.SemestreDTO;
import sn.edu.ugb.student.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api/historique-academiques")
public class HistoriqueAcademiqueResource {

    private static final Logger LOG = LoggerFactory.getLogger(HistoriqueAcademiqueResource.class);

    private static final String ENTITY_NAME = "studentServiceHistoriqueAcademique";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final HistoriqueAcademiqueService historiqueAcademiqueService;
    private final HistoriqueAcademiqueRepository historiqueAcademiqueRepository;
    private final CursusServiceClient cursusServiceClient;

    public HistoriqueAcademiqueResource(
        HistoriqueAcademiqueService historiqueAcademiqueService,
        HistoriqueAcademiqueRepository historiqueAcademiqueRepository,
        CursusServiceClient cursusServiceClient
    ) {
        this.historiqueAcademiqueService = historiqueAcademiqueService;
        this.historiqueAcademiqueRepository = historiqueAcademiqueRepository;
        this.cursusServiceClient = cursusServiceClient;
    }

    @PostMapping("")
    public ResponseEntity<HistoriqueAcademiqueDTO> createHistoriqueAcademique(
        @Valid @RequestBody HistoriqueAcademiqueDTO historiqueAcademiqueDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to save HistoriqueAcademique : {}", historiqueAcademiqueDTO);
        if (historiqueAcademiqueDTO.getId() != null) {
            throw new BadRequestAlertException("A new historiqueAcademique cannot already have an ID", ENTITY_NAME, "idexists");
        }
        historiqueAcademiqueDTO = historiqueAcademiqueService.save(historiqueAcademiqueDTO);
        return ResponseEntity.created(new URI("/api/historique-academiques/" + historiqueAcademiqueDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, historiqueAcademiqueDTO.getId().toString()))
            .body(historiqueAcademiqueDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriqueAcademiqueDTO> updateHistoriqueAcademique(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody HistoriqueAcademiqueDTO historiqueAcademiqueDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update HistoriqueAcademique : {}, {}", id, historiqueAcademiqueDTO);
        if (historiqueAcademiqueDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, historiqueAcademiqueDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!historiqueAcademiqueRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        historiqueAcademiqueDTO = historiqueAcademiqueService.update(historiqueAcademiqueDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, historiqueAcademiqueDTO.getId().toString()))
            .body(historiqueAcademiqueDTO);
    }

    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<HistoriqueAcademiqueDTO> partialUpdateHistoriqueAcademique(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody HistoriqueAcademiqueDTO historiqueAcademiqueDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update HistoriqueAcademique partially : {}, {}", id, historiqueAcademiqueDTO);
        if (historiqueAcademiqueDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, historiqueAcademiqueDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!historiqueAcademiqueRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<HistoriqueAcademiqueDTO> result = historiqueAcademiqueService.partialUpdate(historiqueAcademiqueDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, historiqueAcademiqueDTO.getId().toString())
        );
    }

    @GetMapping("")
    public ResponseEntity<List<HistoriqueAcademiqueDTO>> getAllHistoriqueAcademiques(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of HistoriqueAcademiques");
        Page<HistoriqueAcademiqueDTO> page = historiqueAcademiqueService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueAcademiqueDTO> getHistoriqueAcademique(@PathVariable("id") Long id) {
        LOG.debug("REST request to get HistoriqueAcademique : {}", id);
        Optional<HistoriqueAcademiqueDTO> historiqueAcademiqueDTO = historiqueAcademiqueService.findOne(id);

        historiqueAcademiqueDTO.ifPresent(dto -> {
            if (dto.getSemestreId() != null) {
                try {
                    SemestreDTO semestreDTO = cursusServiceClient.getSemestre(dto.getSemestreId());
                    dto.setSemestre(semestreDTO);
                } catch (Exception e) {
                    LOG.error("Error fetching semestre details", e);
                }
            }
        });

        return ResponseUtil.wrapOrNotFound(historiqueAcademiqueDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoriqueAcademique(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete HistoriqueAcademique : {}", id);
        historiqueAcademiqueService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
