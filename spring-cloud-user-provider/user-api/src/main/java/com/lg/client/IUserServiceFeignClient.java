package com.lg.client;

import com.lg.IUserService;
import com.lg.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name="spring-cloud-user-provider",fallback = IUserServiceFeignClient.UserServiceDefaultFallback.class)
public interface IUserServiceFeignClient extends IUserService {

    @Component
    class UserServiceDefaultFallback implements IUserServiceFeignClient{

        @Override
        public String insertUser(User user) {
            return "Feign 中触发降级";
        }

        @Override
        public String queryUser() {
            return "Feign 中触发降级";
        }
    }
}
