package sn.edu.ugb.student.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import sn.edu.ugb.student.domain.enumeration.StatutAcademique;

public class HistoriqueAcademiqueDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private StatutAcademique statut;
    private Instant dateInscription;
    private Long etudiantId;
    private Long semestreId;
    private SemestreDTO semestre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutAcademique getStatut() {
        return statut;
    }

    public void setStatut(StatutAcademique statut) {
        this.statut = statut;
    }

    public Instant getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Instant dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public Long getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Long semestreId) {
        this.semestreId = semestreId;
    }

    public SemestreDTO getSemestre() {
        return semestre;
    }

    public void setSemestre(SemestreDTO semestre) {
        this.semestre = semestre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriqueAcademiqueDTO that = (HistoriqueAcademiqueDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HistoriqueAcademiqueDTO{" +
            "id=" + id +
            ", statut=" + statut +
            ", dateInscription=" + dateInscription +
            ", etudiantId=" + etudiantId +
            ", semestreId=" + semestreId +
            ", semestre=" + semestre +
            '}';
    }
}
