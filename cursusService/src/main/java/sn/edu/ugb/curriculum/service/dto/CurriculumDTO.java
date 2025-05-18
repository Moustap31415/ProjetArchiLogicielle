package sn.edu.ugb.curriculum.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link sn.edu.ugb.curriculum.domain.Curriculum} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CurriculumDTO implements Serializable {

    private Long id;

    @NotNull
    private String anneeAcademique;

    @NotNull
    private Long filiereId;

    @NotNull
    private Long uniteId;

    @NotNull
    private Long semestreId;

    private FiliereDTO filiere;

    private UniteEnseignementDTO unite;

    @NotNull
    private SemestreDTO semestre;

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

    public Long getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }

    public Long getUniteId() {
        return uniteId;
    }

    public void setUniteId(Long uniteId) {
        this.uniteId = uniteId;
    }

    public Long getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Long semestreId) {
        this.semestreId = semestreId;
    }

    public FiliereDTO getFiliere() {
        return filiere;
    }

    public void setFiliere(FiliereDTO filiere) {
        this.filiere = filiere;
    }

    public UniteEnseignementDTO getUnite() {
        return unite;
    }

    public void setUnite(UniteEnseignementDTO unite) {
        this.unite = unite;
    }

    public SemestreDTO getSemestre() {
        return semestre;
    }

    public void setSemestre(SemestreDTO semestre) {
        this.semestre = semestre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CurriculumDTO)) {
            return false;
        }

        CurriculumDTO curriculumDTO = (CurriculumDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, curriculumDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CurriculumDTO{" +
            "id=" + getId() +
            ", anneeAcademique='" + getAnneeAcademique() + "'" +
            ", filiereId=" + getFiliereId() +
            ", uniteId=" + getUniteId() +
            ", semestreId=" + getSemestreId() +
            ", filiere=" + getFiliere() +
            ", unite=" + getUnite() +
            ", semestre=" + getSemestre() +
            "}";
    }
}
