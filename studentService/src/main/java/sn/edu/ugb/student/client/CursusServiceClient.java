package sn.edu.ugb.student.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.edu.ugb.student.service.dto.FiliereDTO;
import sn.edu.ugb.student.service.dto.SemestreDTO;

@FeignClient(name = "cursusService", url = "${application.microservices.cursusServiceUrl}")
public interface CursusServiceClient {

    @GetMapping("/api/semestres/{id}")
    SemestreDTO getSemestre(@PathVariable("id") Long id);

    @GetMapping("/api/filieres/{id}")
    FiliereDTO getFiliere(@PathVariable("id") Long id);
}
