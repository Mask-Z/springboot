package com.doodle.web.springjpa;

import javax.persistence.*;

/**
 * Author 和 Article 是一对多关系(双向)。那么在JPA中，如何表示一对多的双向关联呢？
 * JPA使用@OneToMany和@ManyToOne来标识一对多的双向关联。一端(Author)使用@OneToMany,多端(Article)使用@ManyToOne
 * @author 周云龙
 * @date 2018/5/4 11:33
 */
@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "author_id")
    private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
