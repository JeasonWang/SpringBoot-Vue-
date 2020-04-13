package com.wanghuan.blogserver.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Pv)实体类
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public class Pv implements Serializable {
    private static final long serialVersionUID = 863759872994864233L;
    
    private Integer id;
    
    private Date countdate;
    
    private Integer pv;
    
    private Integer uid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCountdate() {
        return countdate;
    }

    public void setCountdate(Date countdate) {
        this.countdate = countdate;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

}