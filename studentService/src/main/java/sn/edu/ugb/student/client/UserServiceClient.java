package sn.edu.ugb.student.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.edu.ugb.student.service.dto.ProfilUtilisateurDTO;

@FeignClient(name = "userService", url = "${application.user-service.url}")
public interface UserServiceClient {

    @GetMapping("/api/profil-utilisateurs/{id}")
    ProfilUtilisateurDTO getProfilUtilisateur(@PathVariable("id") Long id);
}
