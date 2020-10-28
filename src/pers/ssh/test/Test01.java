package pers.ssh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.ssh.domain.User;
import pers.ssh.service.UserService;

import javax.annotation.Resource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class Test01 {
    @Resource
    private UserService userService;
    @Test
    public void test01(){
        User user =new User("123","123");
        System.out.println(userService.login(user));
    }
}
