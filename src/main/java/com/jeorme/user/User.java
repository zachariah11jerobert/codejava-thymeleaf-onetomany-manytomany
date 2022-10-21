package com.jeorme.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=45,nullable=false,unique=true)
	private String email;
	
	@Column(length=10,nullable=false,unique=true)
	private String password;
	
	@ManyToMany
	@JoinTable(
			name="user_role",
			joinColumns= @JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id")
			)
	private Set<Role> roles=new HashSet<>();
}
