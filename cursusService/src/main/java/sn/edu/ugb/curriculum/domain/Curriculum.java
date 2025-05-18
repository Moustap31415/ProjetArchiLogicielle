package sn.edu.ugb.curriculum.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Curriculum.
 */
@Entity
@Table(name = "curriculum")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Curriculum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "annee_academique", nullable = false)
    private String anneeAcademique;

    @NotNull
    @Column(name = "filiere_id", nullable = false)
    private Long filiereId;

    @NotNull
    @Column(name = "unite_id", nullable = false)
    private Long uniteId;

    @NotNull
    @Column(name = "semestre_id", nullable = false)
    private Long semestreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "unites" }, allowSetters = true)
    private Filiere filiere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "matieres", "filiere" }, allowSetters = true)
    private UniteEnseignement unite;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "curriculums" }, allowSetters = true)
    private Semestre semestre;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Curriculum id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnneeAcademique() {
        return this.anneeAcademique;
    }

    public Curriculum anneeAcademique(String anneeAcademique) {
        this.setAnneeAcademique(anneeAcademique);
        return this;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public Long getFiliereId() {
        return this.filiereId;
    }

    public Curriculum filiereId(Long filiereId) {
        this.setFiliereId(filiereId);
        return this;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }

    public Long getUniteId() {
        return this.uniteId;
    }

    public Curriculum uniteId(Long uniteId) {
        this.setUniteId(uniteId);
        return this;
    }

    public void setUniteId(Long uniteId) {
        this.uniteId = uniteId;
    }

    public Long getSemestreId() {
        return this.semestreId;
    }

    public Curriculum semestreId(Long semestreId) {
        this.setSemestreId(semestreId);
        return this;
    }

    public void setSemestreId(Long semestreId) {
        this.semestreId = semestreId;
    }

    public Filiere getFiliere() {
        return this.filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Curriculum filiere(Filiere filiere) {
        this.setFiliere(filiere);
        return this;
    }

    public UniteEnseignement getUnite() {
        return this.unite;
    }

    public void setUnite(UniteEnseignement uniteEnseignement) {
        this.unite = uniteEnseignement;
    }

    public Curriculum unite(UniteEnseignement uniteEnseignement) {
        this.setUnite(uniteEnseignement);
        return this;
    }

    public Semestre getSemestre() {
        return this.semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Curriculum semestre(Semestre semestre) {
        this.setSemestre(semestre);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Curriculum)) {
            return false;
        }
        return getId() != null && getId().equals(((Curriculum) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Curriculum{" +
            "id=" + getId() +
            ", anneeAcademique='" + getAnneeAcademique() + "'" +
            ", filiereId=" + getFiliereId() +
            ", uniteId=" + getUniteId() +
            ", semestreId=" + getSemestreId() +
            "}";
    }
}
