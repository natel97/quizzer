package com.nathaniallubitz.quizzer.entity;

import com.nathaniallubitz.quizzer.pojo.UserPOJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"User\"")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String pwHash;
	private String email;
	
	public User() { }

    public User(UserPOJO user) {
	    this.id = user.getId();
	    this.name = user.getName();
	    this.email = user.getEmail();
	    this.pwHash = user.getPwHash();
    }

    public Integer getId() { return id; }
	public String getName() { return name; }
	public String getPwHash() { return pwHash; }
	public String getEmail() { return email; }
	
	
	public User setId(Integer id) { this.id = id; return this; }
	public User setName(String name) { this.name = name; return this; }
	public User setPwHash(String pwHash) { this.pwHash = pwHash; return this; }
	public User setEmail(String email) { this.email = email; return this; }
}
