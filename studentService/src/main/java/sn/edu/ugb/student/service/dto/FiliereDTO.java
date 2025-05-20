package sn.edu.ugb.student.service.dto;

import java.io.Serializable;
import java.util.Objects;

public class FiliereDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nom;
    private String code;
    private Integer creditsTotaux;

    // Getters and Setters
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCreditsTotaux() {
        return creditsTotaux;
    }

    public void setCreditsTotaux(Integer creditsTotaux) {
        this.creditsTotaux = creditsTotaux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiliereDTO that = (FiliereDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FiliereDTO{" +
            "id=" + id +
            ", nom='" + nom + '\'' +
            ", code='" + code + '\'' +
            ", creditsTotaux=" + creditsTotaux +
            '}';
    }
}
