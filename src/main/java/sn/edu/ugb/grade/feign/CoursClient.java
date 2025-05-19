package sn.edu.ugb.grade.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import sn.edu.ugb.grade.feign.CoursDTO;

@FeignClient(name = "cursusService")
public interface CoursClient {

    @GetMapping("/api/cours/{id}")
    CoursDTO getCoursById(@PathVariable("id") Long id);
}
