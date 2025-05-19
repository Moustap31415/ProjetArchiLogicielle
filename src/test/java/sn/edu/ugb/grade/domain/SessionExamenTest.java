package sn.edu.ugb.grade.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.grade.domain.EvaluationTestSamples.*;
import static sn.edu.ugb.grade.domain.SessionExamenTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import sn.edu.ugb.grade.web.rest.TestUtil;

class SessionExamenTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SessionExamen.class);
        SessionExamen sessionExamen1 = getSessionExamenSample1();
        SessionExamen sessionExamen2 = new SessionExamen();
        assertThat(sessionExamen1).isNotEqualTo(sessionExamen2);

        sessionExamen2.setId(sessionExamen1.getId());
        assertThat(sessionExamen1).isEqualTo(sessionExamen2);

        sessionExamen2 = getSessionExamenSample2();
        assertThat(sessionExamen1).isNotEqualTo(sessionExamen2);
    }

    @Test
    void evaluationsTest() {
        SessionExamen sessionExamen = getSessionExamenRandomSampleGenerator();
        Evaluation evaluationBack = getEvaluationRandomSampleGenerator();

        sessionExamen.addEvaluations(evaluationBack);
        assertThat(sessionExamen.getEvaluations()).containsOnly(evaluationBack);
        assertThat(evaluationBack.getSession()).isEqualTo(sessionExamen);

        sessionExamen.removeEvaluations(evaluationBack);
        assertThat(sessionExamen.getEvaluations()).doesNotContain(evaluationBack);
        assertThat(evaluationBack.getSession()).isNull();

        sessionExamen.evaluations(new HashSet<>(Set.of(evaluationBack)));
        assertThat(sessionExamen.getEvaluations()).containsOnly(evaluationBack);
        assertThat(evaluationBack.getSession()).isEqualTo(sessionExamen);

        sessionExamen.setEvaluations(new HashSet<>());
        assertThat(sessionExamen.getEvaluations()).doesNotContain(evaluationBack);
        assertThat(evaluationBack.getSession()).isNull();
    }
}
