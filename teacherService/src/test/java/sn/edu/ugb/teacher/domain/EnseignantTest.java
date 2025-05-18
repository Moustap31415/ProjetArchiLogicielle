package sn.edu.ugb.teacher.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.teacher.domain.AffectationEnseignementTestSamples.*;
import static sn.edu.ugb.teacher.domain.EnseignantTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import sn.edu.ugb.teacher.web.rest.TestUtil;

class EnseignantTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Enseignant.class);
        Enseignant enseignant1 = getEnseignantSample1();
        Enseignant enseignant2 = new Enseignant();
        assertThat(enseignant1).isNotEqualTo(enseignant2);

        enseignant2.setId(enseignant1.getId());
        assertThat(enseignant1).isEqualTo(enseignant2);

        enseignant2 = getEnseignantSample2();
        assertThat(enseignant1).isNotEqualTo(enseignant2);
    }

    @Test
    void affectationsTest() {
        Enseignant enseignant = getEnseignantRandomSampleGenerator();
        AffectationEnseignement affectationEnseignementBack = getAffectationEnseignementRandomSampleGenerator();

        enseignant.addAffectations(affectationEnseignementBack);
        assertThat(enseignant.getAffectations()).containsOnly(affectationEnseignementBack);
        assertThat(affectationEnseignementBack.getEnseignant()).isEqualTo(enseignant);

        enseignant.removeAffectations(affectationEnseignementBack);
        assertThat(enseignant.getAffectations()).doesNotContain(affectationEnseignementBack);
        assertThat(affectationEnseignementBack.getEnseignant()).isNull();

        enseignant.affectations(new HashSet<>(Set.of(affectationEnseignementBack)));
        assertThat(enseignant.getAffectations()).containsOnly(affectationEnseignementBack);
        assertThat(affectationEnseignementBack.getEnseignant()).isEqualTo(enseignant);

        enseignant.setAffectations(new HashSet<>());
        assertThat(enseignant.getAffectations()).doesNotContain(affectationEnseignementBack);
        assertThat(affectationEnseignementBack.getEnseignant()).isNull();
    }
}
