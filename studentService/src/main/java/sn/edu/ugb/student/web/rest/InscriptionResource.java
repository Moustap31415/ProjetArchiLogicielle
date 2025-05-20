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
import sn.edu.ugb.student.client.CursusServiceClient;
import sn.edu.ugb.student.repository.InscriptionRepository;
import sn.edu.ugb.student.service.InscriptionService;
import sn.edu.ugb.student.service.dto.FiliereDTO;
import sn.edu.ugb.student.service.dto.InscriptionDTO;
import sn.edu.ugb.student.service.dto.SemestreDTO;
import sn.edu.ugb.student.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionResource {

    private static final Logger LOG = LoggerFactory.getLogger(InscriptionResource.class);

    private static final String ENTITY_NAME = "studentServiceInscription";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final InscriptionService inscriptionService;
    private final InscriptionRepository inscriptionRepository;
    private final CursusServiceClient cursusServiceClient;

    public InscriptionResource(
        InscriptionService inscriptionService,
        InscriptionRepository inscriptionRepository,
        CursusServiceClient cursusServiceClient
    ) {
        this.inscriptionService = inscriptionService;
        this.inscriptionRepository = inscriptionRepository;
        this.cursusServiceClient = cursusServiceClient;
    }

    @PostMapping("")
    public ResponseEntity<InscriptionDTO> createInscription(@Valid @RequestBody InscriptionDTO inscriptionDTO) throws URISyntaxException {
        LOG.debug("REST request to save Inscription : {}", inscriptionDTO);
        if (inscriptionDTO.getId() != null) {
            throw new BadRequestAlertException("A new inscription cannot already have an ID", ENTITY_NAME, "idexists");
        }
        inscriptionDTO = inscriptionService.save(inscriptionDTO);
        return ResponseEntity.created(new URI("/api/inscriptions/" + inscriptionDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, inscriptionDTO.getId().toString()))
            .body(inscriptionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscriptionDTO> updateInscription(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody InscriptionDTO inscriptionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update Inscription : {}, {}", id, inscriptionDTO);
        if (inscriptionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, inscriptionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!inscriptionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        inscriptionDTO = inscriptionService.update(inscriptionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, inscriptionDTO.getId().toString()))
            .body(inscriptionDTO);
    }

    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<InscriptionDTO> partialUpdateInscription(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody InscriptionDTO inscriptionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update Inscription partially : {}, {}", id, inscriptionDTO);
        if (inscriptionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, inscriptionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!inscriptionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<InscriptionDTO> result = inscriptionService.partialUpdate(inscriptionDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, inscriptionDTO.getId().toString())
        );
    }

    @GetMapping("")
    public ResponseEntity<List<InscriptionDTO>> getAllInscriptions(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of Inscriptions");
        Page<InscriptionDTO> page = inscriptionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionDTO> getInscription(@PathVariable("id") Long id) {
        LOG.debug("REST request to get Inscription : {}", id);
        Optional<InscriptionDTO> inscriptionDTO = inscriptionService.findOne(id);

        inscriptionDTO.ifPresent(dto -> {
            if (dto.getFiliereId() != null) {
                try {
                    FiliereDTO filiereDTO = cursusServiceClient.getFiliere(dto.getFiliereId());
                    dto.setFiliere(filiereDTO);
                } catch (Exception e) {
                    LOG.error("Error fetching filiere details", e);
                }
            }
            if (dto.getSemestreId() != null) {
                try {
                    SemestreDTO semestreDTO = cursusServiceClient.getSemestre(dto.getSemestreId());
                    dto.setSemestre(semestreDTO);
                } catch (Exception e) {
                    LOG.error("Error fetching semestre details", e);
                }
            }
        });

        return ResponseUtil.wrapOrNotFound(inscriptionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscription(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete Inscription : {}", id);
        inscriptionService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
