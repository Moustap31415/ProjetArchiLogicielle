package sn.edu.ugb.teacher.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link sn.edu.ugb.teacher.domain.AffectationEnseignement} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AffectationEnseignementDTO implements Serializable {

    private Long id;

    @NotNull
    private String anneeAcademique;

    @NotNull
    private Integer chargeHoraire;

    private Long coursId;

    @NotNull
    private EnseignantDTO enseignant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public Integer getChargeHoraire() {
        return chargeHoraire;
    }

    public void setChargeHoraire(Integer chargeHoraire) {
        this.chargeHoraire = chargeHoraire;
    }

    public Long getCoursId() {
        return coursId;
    }

    public void setCoursId(Long coursId) {
        this.coursId = coursId;
    }

    public EnseignantDTO getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(EnseignantDTO enseignant) {
        this.enseignant = enseignant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AffectationEnseignementDTO)) {
            return false;
        }

        AffectationEnseignementDTO affectationEnseignementDTO = (AffectationEnseignementDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, affectationEnseignementDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AffectationEnseignementDTO{" +
            "id=" + getId() +
            ", anneeAcademique='" + getAnneeAcademique() + "'" +
            ", chargeHoraire=" + getChargeHoraire() +
            ", coursId=" + getCoursId() +
            ", enseignant=" + getEnseignant() +
            "}";
    }
}
