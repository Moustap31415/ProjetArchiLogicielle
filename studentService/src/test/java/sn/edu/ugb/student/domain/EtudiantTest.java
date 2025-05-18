package sn.edu.ugb.student.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.student.domain.EtudiantTestSamples.*;
import static sn.edu.ugb.student.domain.HistoriqueAcademiqueTestSamples.*;
import static sn.edu.ugb.student.domain.InscriptionTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import sn.edu.ugb.student.web.rest.TestUtil;

class EtudiantTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Etudiant.class);
        Etudiant etudiant1 = getEtudiantSample1();
        Etudiant etudiant2 = new Etudiant();
        assertThat(etudiant1).isNotEqualTo(etudiant2);

        etudiant2.setId(etudiant1.getId());
        assertThat(etudiant1).isEqualTo(etudiant2);

        etudiant2 = getEtudiantSample2();
        assertThat(etudiant1).isNotEqualTo(etudiant2);
    }

    @Test
    void historiquesTest() {
        Etudiant etudiant = getEtudiantRandomSampleGenerator();
        HistoriqueAcademique historiqueAcademiqueBack = getHistoriqueAcademiqueRandomSampleGenerator();

        etudiant.addHistoriques(historiqueAcademiqueBack);
        assertThat(etudiant.getHistoriques()).containsOnly(historiqueAcademiqueBack);
        assertThat(historiqueAcademiqueBack.getEtudiant()).isEqualTo(etudiant);

        etudiant.removeHistoriques(historiqueAcademiqueBack);
        assertThat(etudiant.getHistoriques()).doesNotContain(historiqueAcademiqueBack);
        assertThat(historiqueAcademiqueBack.getEtudiant()).isNull();

        etudiant.historiques(new HashSet<>(Set.of(historiqueAcademiqueBack)));
        assertThat(etudiant.getHistoriques()).containsOnly(historiqueAcademiqueBack);
        assertThat(historiqueAcademiqueBack.getEtudiant()).isEqualTo(etudiant);

        etudiant.setHistoriques(new HashSet<>());
        assertThat(etudiant.getHistoriques()).doesNotContain(historiqueAcademiqueBack);
        assertThat(historiqueAcademiqueBack.getEtudiant()).isNull();
    }

    @Test
    void inscriptionsTest() {
        Etudiant etudiant = getEtudiantRandomSampleGenerator();
        Inscription inscriptionBack = getInscriptionRandomSampleGenerator();

        etudiant.addInscriptions(inscriptionBack);
        assertThat(etudiant.getInscriptions()).containsOnly(inscriptionBack);
        assertThat(inscriptionBack.getEtudiant()).isEqualTo(etudiant);

        etudiant.removeInscriptions(inscriptionBack);
        assertThat(etudiant.getInscriptions()).doesNotContain(inscriptionBack);
        assertThat(inscriptionBack.getEtudiant()).isNull();

        etudiant.inscriptions(new HashSet<>(Set.of(inscriptionBack)));
        assertThat(etudiant.getInscriptions()).containsOnly(inscriptionBack);
        assertThat(inscriptionBack.getEtudiant()).isEqualTo(etudiant);

        etudiant.setInscriptions(new HashSet<>());
        assertThat(etudiant.getInscriptions()).doesNotContain(inscriptionBack);
        assertThat(inscriptionBack.getEtudiant()).isNull();
    }
}
