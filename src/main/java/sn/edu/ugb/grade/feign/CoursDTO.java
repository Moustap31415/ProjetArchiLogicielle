package sn.edu.ugb.grade.feign;

public class CoursDTO {
    private Long id;
    private String nom;
    private Integer credits;
    private Integer heures;

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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getHeures() {
        return heures;
    }

    public void setHeures(Integer heures) {
        this.heures = heures;
    }
}

