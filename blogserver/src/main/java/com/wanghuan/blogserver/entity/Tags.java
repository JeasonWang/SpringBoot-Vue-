package com.wanghuan.blogserver.entity;

import java.io.Serializable;

/**
 * (Tags)实体类
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public class Tags implements Serializable {
    private static final long serialVersionUID = 358399061650552271L;
    
    private Integer id;
    
    private String tagname;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

}