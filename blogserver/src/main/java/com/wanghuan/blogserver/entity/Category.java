package com.wanghuan.blogserver.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * (Category)实体类
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -63068744572613211L;

    private Long id;
    private String cateName;
    private Timestamp date;

    public Category() {
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
