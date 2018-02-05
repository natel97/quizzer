package com.nathaniallubitz.quizzer.pojo;

import com.nathaniallubitz.quizzer.entity.User;

public class UserPOJO {
    private Integer id;
    private String name;
    private String pwHash;
    private String email;

    public UserPOJO() { }

    public UserPOJO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.pwHash = user.getPwHash();
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getPwHash() { return pwHash; }
    public String getEmail() { return email; }


    public UserPOJO setId(Integer id) { this.id = id; return this; }
    public UserPOJO setName(String name) { this.name = name; return this; }
    public UserPOJO setPwHash(String pwHash) { this.pwHash = pwHash; return this; }
    public UserPOJO setEmail(String email) { this.email = email; return this; }
}
