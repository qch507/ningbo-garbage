package com.ningbo.garbage.po;

import javax.persistence.*;

/**
 * Created by qiuch on 2017/8/9.
 */

@Entity
@Table(name = "t_garbage")
public class GarbagePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "garbage_name")
    private String gName;

    @Column(name = "parent_name")
    private String pName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }


}
