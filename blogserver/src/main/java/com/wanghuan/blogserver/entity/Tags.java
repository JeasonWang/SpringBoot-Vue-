package com.wanghuan.blogserver.entity;

import java.io.Serializable;

/**
 * (Tags)实体类
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public class Tags {
    private Long id;
    private String tagName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}