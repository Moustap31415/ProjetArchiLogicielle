package sn.edu.ugb.curriculum.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.curriculum.domain.CurriculumTestSamples.*;
import static sn.edu.ugb.curriculum.domain.SemestreTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import sn.edu.ugb.curriculum.web.rest.TestUtil;

class SemestreTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Semestre.class);
        Semestre semestre1 = getSemestreSample1();
        Semestre semestre2 = new Semestre();
        assertThat(semestre1).isNotEqualTo(semestre2);

        semestre2.setId(semestre1.getId());
        assertThat(semestre1).isEqualTo(semestre2);

        semestre2 = getSemestreSample2();
        assertThat(semestre1).isNotEqualTo(semestre2);
    }

    @Test
    void curriculumsTest() {
        Semestre semestre = getSemestreRandomSampleGenerator();
        Curriculum curriculumBack = getCurriculumRandomSampleGenerator();

        semestre.addCurriculums(curriculumBack);
        assertThat(semestre.getCurriculums()).containsOnly(curriculumBack);
        assertThat(curriculumBack.getSemestre()).isEqualTo(semestre);

        semestre.removeCurriculums(curriculumBack);
        assertThat(semestre.getCurriculums()).doesNotContain(curriculumBack);
        assertThat(curriculumBack.getSemestre()).isNull();

        semestre.curriculums(new HashSet<>(Set.of(curriculumBack)));
        assertThat(semestre.getCurriculums()).containsOnly(curriculumBack);
        assertThat(curriculumBack.getSemestre()).isEqualTo(semestre);

        semestre.setCurriculums(new HashSet<>());
        assertThat(semestre.getCurriculums()).doesNotContain(curriculumBack);
        assertThat(curriculumBack.getSemestre()).isNull();
    }
}
