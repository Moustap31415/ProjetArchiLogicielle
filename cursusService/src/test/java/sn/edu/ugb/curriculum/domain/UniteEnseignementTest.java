package sn.edu.ugb.curriculum.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.curriculum.domain.FiliereTestSamples.*;
import static sn.edu.ugb.curriculum.domain.MatiereTestSamples.*;
import static sn.edu.ugb.curriculum.domain.UniteEnseignementTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import sn.edu.ugb.curriculum.web.rest.TestUtil;

class UniteEnseignementTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UniteEnseignement.class);
        UniteEnseignement uniteEnseignement1 = getUniteEnseignementSample1();
        UniteEnseignement uniteEnseignement2 = new UniteEnseignement();
        assertThat(uniteEnseignement1).isNotEqualTo(uniteEnseignement2);

        uniteEnseignement2.setId(uniteEnseignement1.getId());
        assertThat(uniteEnseignement1).isEqualTo(uniteEnseignement2);

        uniteEnseignement2 = getUniteEnseignementSample2();
        assertThat(uniteEnseignement1).isNotEqualTo(uniteEnseignement2);
    }

    @Test
    void matieresTest() {
        UniteEnseignement uniteEnseignement = getUniteEnseignementRandomSampleGenerator();
        Matiere matiereBack = getMatiereRandomSampleGenerator();

        uniteEnseignement.addMatieres(matiereBack);
        assertThat(uniteEnseignement.getMatieres()).containsOnly(matiereBack);
        assertThat(matiereBack.getUnite()).isEqualTo(uniteEnseignement);

        uniteEnseignement.removeMatieres(matiereBack);
        assertThat(uniteEnseignement.getMatieres()).doesNotContain(matiereBack);
        assertThat(matiereBack.getUnite()).isNull();

        uniteEnseignement.matieres(new HashSet<>(Set.of(matiereBack)));
        assertThat(uniteEnseignement.getMatieres()).containsOnly(matiereBack);
        assertThat(matiereBack.getUnite()).isEqualTo(uniteEnseignement);

        uniteEnseignement.setMatieres(new HashSet<>());
        assertThat(uniteEnseignement.getMatieres()).doesNotContain(matiereBack);
        assertThat(matiereBack.getUnite()).isNull();
    }

    @Test
    void filiereTest() {
        UniteEnseignement uniteEnseignement = getUniteEnseignementRandomSampleGenerator();
        Filiere filiereBack = getFiliereRandomSampleGenerator();

        uniteEnseignement.setFiliere(filiereBack);
        assertThat(uniteEnseignement.getFiliere()).isEqualTo(filiereBack);

        uniteEnseignement.filiere(null);
        assertThat(uniteEnseignement.getFiliere()).isNull();
    }
}
