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
 * A Filiere.
 */
@Entity
@Table(name = "filiere")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Filiere implements Serializable {

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

    @Column(name = "credits_totaux")
    private Integer creditsTotaux;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filiere")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "matieres", "filiere" }, allowSetters = true)
    private Set<UniteEnseignement> unites = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Filiere id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public Filiere nom(String nom) {
        this.setNom(nom);
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return this.code;
    }

    public Filiere code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCreditsTotaux() {
        return this.creditsTotaux;
    }

    public Filiere creditsTotaux(Integer creditsTotaux) {
        this.setCreditsTotaux(creditsTotaux);
        return this;
    }

    public void setCreditsTotaux(Integer creditsTotaux) {
        this.creditsTotaux = creditsTotaux;
    }

    public Set<UniteEnseignement> getUnites() {
        return this.unites;
    }

    public void setUnites(Set<UniteEnseignement> uniteEnseignements) {
        if (this.unites != null) {
            this.unites.forEach(i -> i.setFiliere(null));
        }
        if (uniteEnseignements != null) {
            uniteEnseignements.forEach(i -> i.setFiliere(this));
        }
        this.unites = uniteEnseignements;
    }

    public Filiere unites(Set<UniteEnseignement> uniteEnseignements) {
        this.setUnites(uniteEnseignements);
        return this;
    }

    public Filiere addUnites(UniteEnseignement uniteEnseignement) {
        this.unites.add(uniteEnseignement);
        uniteEnseignement.setFiliere(this);
        return this;
    }

    public Filiere removeUnites(UniteEnseignement uniteEnseignement) {
        this.unites.remove(uniteEnseignement);
        uniteEnseignement.setFiliere(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Filiere)) {
            return false;
        }
        return getId() != null && getId().equals(((Filiere) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Filiere{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", code='" + getCode() + "'" +
            ", creditsTotaux=" + getCreditsTotaux() +
            "}";
    }
}
