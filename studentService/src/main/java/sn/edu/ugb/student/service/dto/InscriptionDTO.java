package sn.edu.ugb.student.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class InscriptionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Boolean enCours;
    private Instant dateInscription;
    private Long etudiantId;
    private Long filiereId;
    private Long semestreId;
    private FiliereDTO filiere;
    private SemestreDTO semestre;

    // Getters and Setters
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

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
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

    public FiliereDTO getFiliere() {
        return filiere;
    }

    public void setFiliere(FiliereDTO filiere) {
        this.filiere = filiere;
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
        InscriptionDTO that = (InscriptionDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "InscriptionDTO{" +
            "id=" + id +
            ", enCours=" + enCours +
            ", dateInscription=" + dateInscription +
            ", etudiantId=" + etudiantId +
            ", filiereId=" + filiereId +
            ", semestreId=" + semestreId +
            '}';
    }
}
