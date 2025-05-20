package sn.edu.ugb.teacher.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.edu.ugb.teacher.feign.CoursDTO;

@FeignClient(name = "cursusservice")
public interface CoursClient {

    @GetMapping("/api/cours/{id}")
    CoursDTO getCoursById(@PathVariable("id") Long id);
}
