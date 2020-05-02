package com.wanghuan.blogserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (User)实体类
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public class User implements Serializable {
    private static final long serialVersionUID = 453771096662539041L;
    
    private Integer id;
    
    private String username;
    
    private String nickname;

    @JsonIgnore
    private String password;
    
    private Integer enabled;
    
    private String email;
    
    private String userface;
    
    private Date regTime;

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
}