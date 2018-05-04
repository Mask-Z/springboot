package com.doodle.web.springjpa;

import javax.persistence.*;
import java.util.List;

/**
 * 用户和权限的多对多关系,一个用户可以有多个权限,一个权限也可以被很多用户拥有
 * @author 周云龙
 * @date 2018/5/4 16:28
 */
@Entity
public class Authority {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;//权限名
    @ManyToMany(mappedBy = "authorityList")
    private List<People> peopleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }
}
