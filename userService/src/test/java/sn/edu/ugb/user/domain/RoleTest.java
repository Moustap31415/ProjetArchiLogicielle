package sn.edu.ugb.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static sn.edu.ugb.user.domain.ProfilUtilisateurTestSamples.*;
import static sn.edu.ugb.user.domain.RoleTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import sn.edu.ugb.user.web.rest.TestUtil;

class RoleTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Role.class);
        Role role1 = getRoleSample1();
        Role role2 = new Role();
        assertThat(role1).isNotEqualTo(role2);

        role2.setId(role1.getId());
        assertThat(role1).isEqualTo(role2);

        role2 = getRoleSample2();
        assertThat(role1).isNotEqualTo(role2);
    }

    @Test
    void utilisateursTest() {
        Role role = getRoleRandomSampleGenerator();
        ProfilUtilisateur profilUtilisateurBack = getProfilUtilisateurRandomSampleGenerator();

        role.addUtilisateurs(profilUtilisateurBack);
        assertThat(role.getUtilisateurs()).containsOnly(profilUtilisateurBack);
        assertThat(profilUtilisateurBack.getRole()).isEqualTo(role);

        role.removeUtilisateurs(profilUtilisateurBack);
        assertThat(role.getUtilisateurs()).doesNotContain(profilUtilisateurBack);
        assertThat(profilUtilisateurBack.getRole()).isNull();

        role.utilisateurs(new HashSet<>(Set.of(profilUtilisateurBack)));
        assertThat(role.getUtilisateurs()).containsOnly(profilUtilisateurBack);
        assertThat(profilUtilisateurBack.getRole()).isEqualTo(role);

        role.setUtilisateurs(new HashSet<>());
        assertThat(role.getUtilisateurs()).doesNotContain(profilUtilisateurBack);
        assertThat(profilUtilisateurBack.getRole()).isNull();
    }
}
