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
import sn.edu.ugb.student.repository.EtudiantRepository;
import sn.edu.ugb.student.service.EtudiantService;
import sn.edu.ugb.student.service.dto.EtudiantDTO;
import sn.edu.ugb.student.service.dto.ProfilUtilisateurDTO;
import sn.edu.ugb.student.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantResource {

    private final Logger log = LoggerFactory.getLogger(EtudiantResource.class);

    private static final String ENTITY_NAME = "studentServiceEtudiant";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EtudiantService etudiantService;

    private final EtudiantRepository etudiantRepository;

    public EtudiantResource(EtudiantService etudiantService, EtudiantRepository etudiantRepository) {
        this.etudiantService = etudiantService;
        this.etudiantRepository = etudiantRepository;
    }

    @PostMapping("")
    public ResponseEntity<EtudiantDTO> createEtudiant(@Valid @RequestBody EtudiantDTO etudiantDTO) throws URISyntaxException {
        log.debug("REST request to save Etudiant : {}", etudiantDTO);
        if (etudiantDTO.getId() != null) {
            throw new BadRequestAlertException("A new etudiant cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EtudiantDTO result = etudiantService.save(etudiantDTO);
        return ResponseEntity.created(new URI("/api/etudiants/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudiantDTO> updateEtudiant(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody EtudiantDTO etudiantDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Etudiant : {}, {}", id, etudiantDTO);
        if (etudiantDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, etudiantDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!etudiantRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        EtudiantDTO result = etudiantService.update(etudiantDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, etudiantDTO.getId().toString()))
            .body(result);
    }

    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<EtudiantDTO> partialUpdateEtudiant(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody EtudiantDTO etudiantDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Etudiant partially : {}, {}", id, etudiantDTO);
        if (etudiantDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, etudiantDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!etudiantRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<EtudiantDTO> result = etudiantService.partialUpdate(etudiantDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, etudiantDTO.getId().toString())
        );
    }

    @GetMapping("")
    public ResponseEntity<List<EtudiantDTO>> getAllEtudiants(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of Etudiants");
        Page<EtudiantDTO> page = etudiantService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> getEtudiant(@PathVariable("id") Long id) {
        log.debug("REST request to get Etudiant : {}", id);
        Optional<EtudiantDTO> etudiantDTO = etudiantService.findOne(id);
        return ResponseUtil.wrapOrNotFound(etudiantDTO);
    }

    @GetMapping("/{id}/profil-utilisateur")
    public ResponseEntity<ProfilUtilisateurDTO> getProfilUtilisateurForEtudiant(@PathVariable("id") Long id) {
        log.debug("REST request to get ProfilUtilisateur for Etudiant : {}", id);
        ProfilUtilisateurDTO profilUtilisateurDTO = etudiantService.getProfilUtilisateurForEtudiant(id);
        return ResponseEntity.ok(profilUtilisateurDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable("id") Long id) {
        log.debug("REST request to delete Etudiant : {}", id);
        etudiantService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
