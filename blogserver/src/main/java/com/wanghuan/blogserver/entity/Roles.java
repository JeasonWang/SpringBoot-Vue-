package com.wanghuan.blogserver.entity;

import java.io.Serializable;

/**
 * (Roles)实体类
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public class Roles implements Serializable {
    private static final long serialVersionUID = -48875498270986592L;
    
    private Integer id;
    
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}