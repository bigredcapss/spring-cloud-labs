package com.lg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserService {

    @PostMapping("/user")
    String insertUser (@RequestBody User user);

    @GetMapping("/user")
    String queryUser ();

}
