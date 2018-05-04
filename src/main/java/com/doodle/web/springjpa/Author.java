package com.doodle.web.springjpa;

import javax.persistence.*;
import java.util.List;

/**
 * Author 和 Article 是一对多关系(双向)。那么在JPA中，如何表示一对多的双向关联呢？
 * JPA使用@OneToMany和@ManyToOne来标识一对多的双向关联。一端(Author)使用@OneToMany,多端(Article)使用@ManyToOne
 * @author 周云龙
 * @date 2018/5/4 11:32
 */
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;

    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="author"中的author是Article中的author属性
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Article> articleList;

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

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
