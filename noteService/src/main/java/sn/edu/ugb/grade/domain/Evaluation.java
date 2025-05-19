package sn.edu.ugb.grade.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import sn.edu.ugb.grade.domain.enumeration.TypeEvaluation;

@Entity
@Table(name = "evaluation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeEvaluation type;

    @NotNull
    @Column(name = "note_maximale", nullable = false)
    private Float noteMaximale;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @Column(name = "coefficient", nullable = false)
    private Float coefficient;

    @Column(name = "cours_id", insertable = false, updatable = false)
    private Long coursId;

    @Column(name = "session_id", insertable = false, updatable = false)
    private Long sessionId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evaluation")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "evaluation" }, allowSetters = true)
    private Set<Note> notes = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "session_id")
    @JsonIgnoreProperties(value = { "evaluations" }, allowSetters = true)
    private SessionExamen session;

    public Long getId() {
        return this.id;
    }

    public Evaluation id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeEvaluation getType() {
        return this.type;
    }

    public Evaluation type(TypeEvaluation type) {
        this.setType(type);
        return this;
    }

    public void setType(TypeEvaluation type) {
        this.type = type;
    }

    public Float getNoteMaximale() {
        return this.noteMaximale;
    }

    public Evaluation noteMaximale(Float noteMaximale) {
        this.setNoteMaximale(noteMaximale);
        return this;
    }

    public void setNoteMaximale(Float noteMaximale) {
        this.noteMaximale = noteMaximale;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public Evaluation date(LocalDate date) {
        this.setDate(date);
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getCoefficient() {
        return this.coefficient;
    }

    public Evaluation coefficient(Float coefficient) {
        this.setCoefficient(coefficient);
        return this;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public Long getCoursId() {
        return this.coursId;
    }

    public Evaluation coursId(Long coursId) {
        this.setCoursId(coursId);
        return this;
    }

    public void setCoursId(Long coursId) {
        this.coursId = coursId;
    }

    public Long getSessionId() {
        return this.sessionId;
    }

    public Evaluation sessionId(Long sessionId) {
        this.setSessionId(sessionId);
        return this;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Set<Note> getNotes() {
        return this.notes;
    }

    public void setNotes(Set<Note> notes) {
        if (this.notes != null) {
            this.notes.forEach(i -> i.setEvaluation(null));
        }
        if (notes != null) {
            notes.forEach(i -> i.setEvaluation(this));
        }
        this.notes = notes;
    }

    public Evaluation notes(Set<Note> notes) {
        this.setNotes(notes);
        return this;
    }

    public Evaluation addNotes(Note note) {
        this.notes.add(note);
        note.setEvaluation(this);
        return this;
    }

    public Evaluation removeNotes(Note note) {
        this.notes.remove(note);
        note.setEvaluation(null);
        return this;
    }

    public SessionExamen getSession() {
        return this.session;
    }

    public void setSession(SessionExamen sessionExamen) {
        this.session = sessionExamen;
    }

    public Evaluation session(SessionExamen sessionExamen) {
        this.setSession(sessionExamen);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Evaluation)) {
            return false;
        }
        return getId() != null && getId().equals(((Evaluation) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Evaluation{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", noteMaximale=" + getNoteMaximale() +
            ", date='" + getDate() + "'" +
            ", coefficient=" + getCoefficient() +
            ", coursId=" + getCoursId() +
            ", sessionId=" + getSessionId() +
            "}";
    }
}
