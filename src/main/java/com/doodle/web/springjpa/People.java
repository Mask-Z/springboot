package com.doodle.web.springjpa;

import javax.persistence.*;
import java.util.List;

/**
 * 用户和权限的多对多关系,一个用户可以有多个权限,一个权限也可以被很多用户拥有
 * @author 周云龙
 * @date 2018/5/4 16:27
 */
@Entity
public class People {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String  username;

    @Column
    private String  password;

    @ManyToMany
    @JoinTable(name = "people_authority", joinColumns = @JoinColumn(name = "people_id"),
                inverseJoinColumns = @JoinColumn(name = "authority_id"))
    //1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Authority)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，即表名为people_authority
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即people_id
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即authority_id
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
    private List<Authority> authorityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
