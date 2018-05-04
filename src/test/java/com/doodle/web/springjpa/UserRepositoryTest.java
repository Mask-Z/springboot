package com.doodle.web.springjpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 周云龙
 * @date 2018/5/3 15:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserRepositoryApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        userRepository.save(new User("AAA",10));
        userRepository.save(new User("BBB",11));
        userRepository.save(new User("CCC",12));
        userRepository.save(new User("DDD",13));
        userRepository.save(new User("EEE",14));
        userRepository.save(new User("FFF",15));
        userRepository.save(new User("GGG",16));
        userRepository.save(new User("HHH",17));
        userRepository.save(new User("III",18));
        userRepository.save(new User("JJJ",19));
        userRepository.save(new User("KKK",20));

        Assert.assertEquals(11,userRepository.findAll().size());

        Assert.assertEquals(20,userRepository.findByName("KKK").getAge().intValue());

        Assert.assertEquals(10,userRepository.findUser("AAA").getAge().intValue());

        Assert.assertEquals("EEE",userRepository.findByNameAndAge("EEE",14).getName());

        userRepository.delete(userRepository.findByName("BBB"));

        Assert.assertEquals(10,userRepository.findAll().size());
    }
}
