package sn.edu.ugb.student.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link sn.edu.ugb.student.domain.Inscription} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class InscriptionDTO implements Serializable {

    private Long id;

    @NotNull
    private Boolean enCours;

    @NotNull
    private Instant dateInscription;

    private Long filiereId;

    private Long semestreId;

    @NotNull
    private EtudiantDTO etudiant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEnCours() {
        return enCours;
    }

    public void setEnCours(Boolean enCours) {
        this.enCours = enCours;
    }

    public Instant getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Instant dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Long getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }

    public Long getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Long semestreId) {
        this.semestreId = semestreId;
    }

    public EtudiantDTO getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(EtudiantDTO etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InscriptionDTO)) {
            return false;
        }

        InscriptionDTO inscriptionDTO = (InscriptionDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, inscriptionDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InscriptionDTO{" +
            "id=" + getId() +
            ", enCours='" + getEnCours() + "'" +
            ", dateInscription='" + getDateInscription() + "'" +
            ", filiereId=" + getFiliereId() +
            ", semestreId=" + getSemestreId() +
            ", etudiant=" + getEtudiant() +
            "}";
    }
}
