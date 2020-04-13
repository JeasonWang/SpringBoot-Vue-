package com.wanghuan.blogserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comments)实体类
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public class Comments implements Serializable {
    private static final long serialVersionUID = -99176305555001477L;
    
    private Integer id;
    
    private Integer aid;
    
    private String content;
    
    private Date publishdate;
    /**
    * -1表示正常回复，其他值表示是评论的回复
    */
    private Integer parentid;
    
    private Integer uid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

}