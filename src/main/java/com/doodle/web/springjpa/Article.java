package com.doodle.web.springjpa;

import javax.persistence.*;

/**
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
