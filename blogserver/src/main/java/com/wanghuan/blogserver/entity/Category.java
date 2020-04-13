package com.wanghuan.blogserver.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Category)实体类
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -63068744572613211L;
    
    private Integer id;
    
    private String catename;
    
    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}