package sn.edu.ugb.curriculum.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link sn.edu.ugb.curriculum.domain.Matiere} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MatiereDTO implements Serializable {

    private Long id;

    @NotNull
    private String nom;

    @NotNull
    private Integer heures;

    @NotNull
    private Integer credits;

    @NotNull
    private Long uniteId;

    @NotNull
    private UniteEnseignementDTO unite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getHeures() {
        return heures;
    }

    public void setHeures(Integer heures) {
        this.heures = heures;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Long getUniteId() {
        return uniteId;
    }

    public void setUniteId(Long uniteId) {
        this.uniteId = uniteId;
    }

    public UniteEnseignementDTO getUnite() {
        return unite;
    }

    public void setUnite(UniteEnseignementDTO unite) {
        this.unite = unite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MatiereDTO)) {
            return false;
        }

        MatiereDTO matiereDTO = (MatiereDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, matiereDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MatiereDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", heures=" + getHeures() +
            ", credits=" + getCredits() +
            ", uniteId=" + getUniteId() +
            ", unite=" + getUnite() +
            "}";
    }
}
