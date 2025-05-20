package sn.edu.ugb.student.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import sn.edu.ugb.student.service.dto.FiliereDTO;
import sn.edu.ugb.student.service.dto.SemestreDTO;

@Entity
@Table(name = "inscription")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "en_cours", nullable = false)
    private Boolean enCours;

    @NotNull
    @Column(name = "date_inscription", nullable = false)
    private Instant dateInscription;

    @Column(name = "filiere_id")
    private Long filiereId;

    @Column(name = "semestre_id")
    private Long semestreId;

    @Transient
    private FiliereDTO filiere;

    @Transient
    private SemestreDTO semestre;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "historiques", "inscriptions" }, allowSetters = true)
    private Etudiant etudiant;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Inscription id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEnCours() {
        return this.enCours;
    }

    public Inscription enCours(Boolean enCours) {
        this.setEnCours(enCours);
        return this;
    }

    public void setEnCours(Boolean enCours) {
        this.enCours = enCours;
    }

    public Instant getDateInscription() {
        return this.dateInscription;
    }

    public Inscription dateInscription(Instant dateInscription) {
        this.setDateInscription(dateInscription);
        return this;
    }

    public void setDateInscription(Instant dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Long getFiliereId() {
        return this.filiereId;
    }

    public Inscription filiereId(Long filiereId) {
        this.setFiliereId(filiereId);
        return this;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }

    public Long getSemestreId() {
        return this.semestreId;
    }

    public Inscription semestreId(Long semestreId) {
        this.setSemestreId(semestreId);
        return this;
    }

    public void setSemestreId(Long semestreId) {
        this.semestreId = semestreId;
    }

    public FiliereDTO getFiliere() {
        return this.filiere;
    }

    public void setFiliere(FiliereDTO filiere) {
        this.filiere = filiere;
    }

    public SemestreDTO getSemestre() {
        return this.semestre;
    }

    public void setSemestre(SemestreDTO semestre) {
        this.semestre = semestre;
    }

    public Etudiant getEtudiant() {
        return this.etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Inscription etudiant(Etudiant etudiant) {
        this.setEtudiant(etudiant);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Inscription)) {
            return false;
        }
        return getId() != null && getId().equals(((Inscription) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Inscription{" +
            "id=" + getId() +
            ", enCours='" + getEnCours() + "'" +
            ", dateInscription='" + getDateInscription() + "'" +
            ", filiereId=" + getFiliereId() +
            ", semestreId=" + getSemestreId() +
            "}";
    }
}
