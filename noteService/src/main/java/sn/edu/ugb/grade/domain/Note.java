package sn.edu.ugb.grade.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "note")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "valeur", nullable = false)
    private Float valeur;

    @Column(name = "commentaires")
    private String commentaires;

    @NotNull
    @Column(name = "date_saisie", nullable = false)
    private Instant dateSaisie;

    @Column(name = "etudiant_id", insertable = false, updatable = false)
    private Long etudiantId;

    @Column(name = "evaluation_id", insertable = false, updatable = false)
    private Long evaluationId;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "evaluation_id")
    @JsonIgnoreProperties(value = { "notes", "session" }, allowSetters = true)
    private Evaluation evaluation;

    public Long getId() {
        return this.id;
    }

    public Note id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValeur() {
        return this.valeur;
    }

    public Note valeur(Float valeur) {
        this.setValeur(valeur);
        return this;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public String getCommentaires() {
        return this.commentaires;
    }

    public Note commentaires(String commentaires) {
        this.setCommentaires(commentaires);
        return this;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public Instant getDateSaisie() {
        return this.dateSaisie;
    }

    public Note dateSaisie(Instant dateSaisie) {
        this.setDateSaisie(dateSaisie);
        return this;
    }

    public void setDateSaisie(Instant dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public Long getEtudiantId() {
        return this.etudiantId;
    }

    public Note etudiantId(Long etudiantId) {
        this.setEtudiantId(etudiantId);
        return this;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public Long getEvaluationId() {
        return this.evaluationId;
    }

    public Note evaluationId(Long evaluationId) {
        this.setEvaluationId(evaluationId);
        return this;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Evaluation getEvaluation() {
        return this.evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Note evaluation(Evaluation evaluation) {
        this.setEvaluation(evaluation);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Note)) {
            return false;
        }
        return getId() != null && getId().equals(((Note) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Note{" +
            "id=" + getId() +
            ", valeur=" + getValeur() +
            ", commentaires='" + getCommentaires() + "'" +
            ", dateSaisie='" + getDateSaisie() + "'" +
            ", etudiantId=" + getEtudiantId() +
            ", evaluationId=" + getEvaluationId() +
            "}";
    }
}
