package com.ningbo.garbage.po;

import javax.persistence.*;

/**
 * Created by qiuch on 2017/8/9.
 */

@Entity
@Table(name = "t_classification")
public class ClassificationPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "classification_name")
    private String cName;

    @Column(name = "parent_name")
    private String pName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
}
