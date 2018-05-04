package com.doodle.web.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 周云龙
 * @date 2018/4/28 16:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationBlog.class)
public class BlogTest {

    @Autowired
    private Blog blog;

    @Test
    public void blogMethodTest(){
        System.out.println(blog.getDesc());
        System.out.println(String.format("%s: %s",blog.getName(),blog.getTitle()));
        assert "陆小凤".equals(blog.getName());
        assert "剑神一笑".equals(blog.getTitle());

    }
}
