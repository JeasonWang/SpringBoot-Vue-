package com.wanghuan.blogserver.entity;

import java.io.Serializable;

/**
 * (RolesUser)实体类
 *
 * @author makejava
 * @since 2020-04-12 21:16:24
 */
public class RolesUser implements Serializable {
    private static final long serialVersionUID = 410128727017604491L;
    
    private Integer id;
    
    private Integer rid;
    
    private Integer uid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

}