package com.nathaniallubitz.quizzer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Token {
    @GeneratedValue
    @Id
    Integer id;
    @OneToOne
    private User user;
    private String token;
    private Long expires;

    public Token() { }


    public User getUser() { return user; }
    public String getToken() { return token; }
    public Long getExpiration() { return expires; }

    public Token setUser(User user) {
        this.user = user;
        return this;
    }

    public Token setToken(String token){
        this.token = token;
        return this;
    }

    public Token setExpiration(Long expires){
        this.expires = expires;
        return this;
    }

}
