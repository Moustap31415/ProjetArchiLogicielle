package sn.edu.ugb.grade.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import sn.edu.ugb.grade.feign.EtudiantDTO;

@FeignClient(name = "studentService")
public interface EtudiantClient {

    @GetMapping("/api/etudiants/{id}")
    EtudiantDTO getEtudiantById(@PathVariable("id") Long id);
}

