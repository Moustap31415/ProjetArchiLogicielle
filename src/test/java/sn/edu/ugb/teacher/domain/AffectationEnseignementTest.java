package sn.edu.ugb.teacher.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.teacher.domain.AffectationEnseignementTestSamples.*;
import static sn.edu.ugb.teacher.domain.EnseignantTestSamples.*;

import org.junit.jupiter.api.Test;
import sn.edu.ugb.teacher.web.rest.TestUtil;

class AffectationEnseignementTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AffectationEnseignement.class);
        AffectationEnseignement affectationEnseignement1 = getAffectationEnseignementSample1();
        AffectationEnseignement affectationEnseignement2 = new AffectationEnseignement();
        assertThat(affectationEnseignement1).isNotEqualTo(affectationEnseignement2);

        affectationEnseignement2.setId(affectationEnseignement1.getId());
        assertThat(affectationEnseignement1).isEqualTo(affectationEnseignement2);

        affectationEnseignement2 = getAffectationEnseignementSample2();
        assertThat(affectationEnseignement1).isNotEqualTo(affectationEnseignement2);
    }

    @Test
    void enseignantTest() {
        AffectationEnseignement affectationEnseignement = getAffectationEnseignementRandomSampleGenerator();
        Enseignant enseignantBack = getEnseignantRandomSampleGenerator();

        affectationEnseignement.setEnseignant(enseignantBack);
        assertThat(affectationEnseignement.getEnseignant()).isEqualTo(enseignantBack);

        affectationEnseignement.enseignant(null);
        assertThat(affectationEnseignement.getEnseignant()).isNull();
    }
}
