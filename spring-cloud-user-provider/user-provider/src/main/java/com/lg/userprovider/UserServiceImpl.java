package com.lg.userprovider;

import com.lg.IUserService;
import com.lg.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class UserServiceImpl implements IUserService
{
    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public String insertUser(User user) {
        logger.info("receive request:"+user);
        return "Save User Success";
    }

    @Override
    public String queryUser() {
        System.out.println("come in");
        /*try
        {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }*/
        return "QueryUserInfo:Hello Gupao";
    }
}
