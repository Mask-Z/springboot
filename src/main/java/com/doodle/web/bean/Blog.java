package com.doodle.web.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 周云龙
 * @date 2018/4/28 16:00
 */
@Component
public class Blog {

    @Value("${com.doodle.blog.name}")
    private String name;

    @Value("${com.doodle.blog.title}")
    private String title;
    @Value("${com.doodle.blog.desc}")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
