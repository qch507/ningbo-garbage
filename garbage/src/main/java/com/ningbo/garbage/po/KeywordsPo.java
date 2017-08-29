package com.ningbo.garbage.po;

import javax.persistence.*;

/**
 * Created by qiuch on 2017/8/9.
 */

@Entity
@Table(name = "t_keywords")
public class KeywordsPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "keywords")
    private String keywords;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
