package com.doodle.web.home;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 周云龙
 * @date 2018/5/2 14:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HomeProperties.class)
public class HomeTest {

    @Autowired
    private HomeProperties homeProperties;

    @Test
    public void test(){
        System.out.println(homeProperties);
    }
}
