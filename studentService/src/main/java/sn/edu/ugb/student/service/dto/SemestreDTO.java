package sn.edu.ugb.student.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class SemestreDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nom;
    private LocalDate dateDebut;
    private LocalDate dateFin;

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

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "SemestreDTO{" +
            "id=" + id +
            ", nom='" + nom + '\'' +
            ", dateDebut=" + dateDebut +
            ", dateFin=" + dateFin +
            '}';
    }
}
