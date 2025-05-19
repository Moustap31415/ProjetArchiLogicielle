package sn.edu.ugb.grade.feign;

public class EtudiantDTO {
    private Long id;
    private String numeroEtudiant;
    private String nom;
    private String prenom;
    private String formationActuelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFormationActuelle() {
        return formationActuelle;
    }

    public void setFormationActuelle(String formationActuelle) {
        this.formationActuelle = formationActuelle;
    }
}

