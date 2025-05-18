package sn.edu.ugb.curriculum.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A UniteEnseignement.
 */
@Entity
@Table(name = "unite_enseignement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UniteEnseignement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "credits")
    private Integer credits;

    @NotNull
    @Column(name = "filiere_id", nullable = false)
    private Long filiereId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unite")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "unite" }, allowSetters = true)
    private Set<Matiere> matieres = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "unites" }, allowSetters = true)
    private Filiere filiere;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public UniteEnseignement id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public UniteEnseignement nom(String nom) {
        this.setNom(nom);
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return this.code;
    }

    public UniteEnseignement code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCredits() {
        return this.credits;
    }

    public UniteEnseignement credits(Integer credits) {
        this.setCredits(credits);
        return this;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Long getFiliereId() {
        return this.filiereId;
    }

    public UniteEnseignement filiereId(Long filiereId) {
        this.setFiliereId(filiereId);
        return this;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }

    public Set<Matiere> getMatieres() {
        return this.matieres;
    }

    public void setMatieres(Set<Matiere> matieres) {
        if (this.matieres != null) {
            this.matieres.forEach(i -> i.setUnite(null));
        }
        if (matieres != null) {
            matieres.forEach(i -> i.setUnite(this));
        }
        this.matieres = matieres;
    }

    public UniteEnseignement matieres(Set<Matiere> matieres) {
        this.setMatieres(matieres);
        return this;
    }

    public UniteEnseignement addMatieres(Matiere matiere) {
        this.matieres.add(matiere);
        matiere.setUnite(this);
        return this;
    }

    public UniteEnseignement removeMatieres(Matiere matiere) {
        this.matieres.remove(matiere);
        matiere.setUnite(null);
        return this;
    }

    public Filiere getFiliere() {
        return this.filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public UniteEnseignement filiere(Filiere filiere) {
        this.setFiliere(filiere);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniteEnseignement)) {
            return false;
        }
        return getId() != null && getId().equals(((UniteEnseignement) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UniteEnseignement{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", code='" + getCode() + "'" +
            ", credits=" + getCredits() +
            ", filiereId=" + getFiliereId() +
            "}";
    }
}
