package sn.edu.ugb.grade.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.grade.domain.EvaluationTestSamples.*;
import static sn.edu.ugb.grade.domain.NoteTestSamples.*;
import static sn.edu.ugb.grade.domain.SessionExamenTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import sn.edu.ugb.grade.web.rest.TestUtil;

class EvaluationTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Evaluation.class);
        Evaluation evaluation1 = getEvaluationSample1();
        Evaluation evaluation2 = new Evaluation();
        assertThat(evaluation1).isNotEqualTo(evaluation2);

        evaluation2.setId(evaluation1.getId());
        assertThat(evaluation1).isEqualTo(evaluation2);

        evaluation2 = getEvaluationSample2();
        assertThat(evaluation1).isNotEqualTo(evaluation2);
    }

    @Test
    void notesTest() {
        Evaluation evaluation = getEvaluationRandomSampleGenerator();
        Note noteBack = getNoteRandomSampleGenerator();

        evaluation.addNotes(noteBack);
        assertThat(evaluation.getNotes()).containsOnly(noteBack);
        assertThat(noteBack.getEvaluation()).isEqualTo(evaluation);

        evaluation.removeNotes(noteBack);
        assertThat(evaluation.getNotes()).doesNotContain(noteBack);
        assertThat(noteBack.getEvaluation()).isNull();

        evaluation.notes(new HashSet<>(Set.of(noteBack)));
        assertThat(evaluation.getNotes()).containsOnly(noteBack);
        assertThat(noteBack.getEvaluation()).isEqualTo(evaluation);

        evaluation.setNotes(new HashSet<>());
        assertThat(evaluation.getNotes()).doesNotContain(noteBack);
        assertThat(noteBack.getEvaluation()).isNull();
    }

    @Test
    void sessionTest() {
        Evaluation evaluation = getEvaluationRandomSampleGenerator();
        SessionExamen sessionExamenBack = getSessionExamenRandomSampleGenerator();

        evaluation.setSession(sessionExamenBack);
        assertThat(evaluation.getSession()).isEqualTo(sessionExamenBack);

        evaluation.session(null);
        assertThat(evaluation.getSession()).isNull();
    }
}
