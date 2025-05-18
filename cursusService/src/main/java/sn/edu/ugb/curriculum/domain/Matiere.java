package sn.edu.ugb.curriculum.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Matiere.
 */
@Entity
@Table(name = "matiere")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Matiere implements Serializable {

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
    @Column(name = "heures", nullable = false)
    private Integer heures;

    @NotNull
    @Column(name = "credits", nullable = false)
    private Integer credits;

    @NotNull
    @Column(name = "unite_id", nullable = false)
    private Long uniteId;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "matieres", "filiere" }, allowSetters = true)
    private UniteEnseignement unite;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Matiere id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public Matiere nom(String nom) {
        this.setNom(nom);
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getHeures() {
        return this.heures;
    }

    public Matiere heures(Integer heures) {
        this.setHeures(heures);
        return this;
    }

    public void setHeures(Integer heures) {
        this.heures = heures;
    }

    public Integer getCredits() {
        return this.credits;
    }

    public Matiere credits(Integer credits) {
        this.setCredits(credits);
        return this;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Long getUniteId() {
        return this.uniteId;
    }

    public Matiere uniteId(Long uniteId) {
        this.setUniteId(uniteId);
        return this;
    }

    public void setUniteId(Long uniteId) {
        this.uniteId = uniteId;
    }

    public UniteEnseignement getUnite() {
        return this.unite;
    }

    public void setUnite(UniteEnseignement uniteEnseignement) {
        this.unite = uniteEnseignement;
    }

    public Matiere unite(UniteEnseignement uniteEnseignement) {
        this.setUnite(uniteEnseignement);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Matiere)) {
            return false;
        }
        return getId() != null && getId().equals(((Matiere) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Matiere{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", heures=" + getHeures() +
            ", credits=" + getCredits() +
            ", uniteId=" + getUniteId() +
            "}";
    }
}
