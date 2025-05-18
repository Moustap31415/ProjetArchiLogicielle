package sn.edu.ugb.curriculum.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.curriculum.domain.CurriculumTestSamples.*;
import static sn.edu.ugb.curriculum.domain.FiliereTestSamples.*;
import static sn.edu.ugb.curriculum.domain.SemestreTestSamples.*;
import static sn.edu.ugb.curriculum.domain.UniteEnseignementTestSamples.*;

import org.junit.jupiter.api.Test;
import sn.edu.ugb.curriculum.web.rest.TestUtil;

class CurriculumTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Curriculum.class);
        Curriculum curriculum1 = getCurriculumSample1();
        Curriculum curriculum2 = new Curriculum();
        assertThat(curriculum1).isNotEqualTo(curriculum2);

        curriculum2.setId(curriculum1.getId());
        assertThat(curriculum1).isEqualTo(curriculum2);

        curriculum2 = getCurriculumSample2();
        assertThat(curriculum1).isNotEqualTo(curriculum2);
    }

    @Test
    void filiereTest() {
        Curriculum curriculum = getCurriculumRandomSampleGenerator();
        Filiere filiereBack = getFiliereRandomSampleGenerator();

        curriculum.setFiliere(filiereBack);
        assertThat(curriculum.getFiliere()).isEqualTo(filiereBack);

        curriculum.filiere(null);
        assertThat(curriculum.getFiliere()).isNull();
    }

    @Test
    void uniteTest() {
        Curriculum curriculum = getCurriculumRandomSampleGenerator();
        UniteEnseignement uniteEnseignementBack = getUniteEnseignementRandomSampleGenerator();

        curriculum.setUnite(uniteEnseignementBack);
        assertThat(curriculum.getUnite()).isEqualTo(uniteEnseignementBack);

        curriculum.unite(null);
        assertThat(curriculum.getUnite()).isNull();
    }

    @Test
    void semestreTest() {
        Curriculum curriculum = getCurriculumRandomSampleGenerator();
        Semestre semestreBack = getSemestreRandomSampleGenerator();

        curriculum.setSemestre(semestreBack);
        assertThat(curriculum.getSemestre()).isEqualTo(semestreBack);

        curriculum.semestre(null);
        assertThat(curriculum.getSemestre()).isNull();
    }
}
