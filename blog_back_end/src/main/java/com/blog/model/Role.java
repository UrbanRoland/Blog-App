package com.blog.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "roles" )
@Getter
@Setter
@NoArgsConstructor
public class Role {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String role;
	
	@ManyToMany( mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
	
	public Role(String role){
		this.role=role;
	}
	
	@Override
	public String toString() {
		return role;
	}
	
	
	
}
