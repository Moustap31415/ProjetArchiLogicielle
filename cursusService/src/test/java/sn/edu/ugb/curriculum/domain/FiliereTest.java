package sn.edu.ugb.curriculum.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.curriculum.domain.FiliereTestSamples.*;
import static sn.edu.ugb.curriculum.domain.UniteEnseignementTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import sn.edu.ugb.curriculum.web.rest.TestUtil;

class FiliereTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Filiere.class);
        Filiere filiere1 = getFiliereSample1();
        Filiere filiere2 = new Filiere();
        assertThat(filiere1).isNotEqualTo(filiere2);

        filiere2.setId(filiere1.getId());
        assertThat(filiere1).isEqualTo(filiere2);

        filiere2 = getFiliereSample2();
        assertThat(filiere1).isNotEqualTo(filiere2);
    }

    @Test
    void unitesTest() {
        Filiere filiere = getFiliereRandomSampleGenerator();
        UniteEnseignement uniteEnseignementBack = getUniteEnseignementRandomSampleGenerator();

        filiere.addUnites(uniteEnseignementBack);
        assertThat(filiere.getUnites()).containsOnly(uniteEnseignementBack);
        assertThat(uniteEnseignementBack.getFiliere()).isEqualTo(filiere);

        filiere.removeUnites(uniteEnseignementBack);
        assertThat(filiere.getUnites()).doesNotContain(uniteEnseignementBack);
        assertThat(uniteEnseignementBack.getFiliere()).isNull();

        filiere.unites(new HashSet<>(Set.of(uniteEnseignementBack)));
        assertThat(filiere.getUnites()).containsOnly(uniteEnseignementBack);
        assertThat(uniteEnseignementBack.getFiliere()).isEqualTo(filiere);

        filiere.setUnites(new HashSet<>());
        assertThat(filiere.getUnites()).doesNotContain(uniteEnseignementBack);
        assertThat(uniteEnseignementBack.getFiliere()).isNull();
    }
}
