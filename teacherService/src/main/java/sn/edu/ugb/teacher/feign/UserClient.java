package sn.edu.ugb.teacher.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.edu.ugb.teacher.feign.UserDTO;

@FeignClient(name = "userService")
public interface UserClient {

    @GetMapping("/api/utilisateurs/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);
}
