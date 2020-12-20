package com.lg.springclouduserconsumer;

import com.lg.User;
import com.lg.client.IUserServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    IUserServiceFeignClient userServiceFeignClient;

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id")int id){
        User user=new User();
        user.setId(1);
        user.setName("Mic");
        return userServiceFeignClient.insertUser(user);
    }

}
