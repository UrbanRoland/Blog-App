package com.blog.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name="categories" )
public class Category {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String category;
	
	@JsonBackReference(value = "users")
	@ManyToMany( mappedBy = "categories")
	private Set<BlogPost> users = new HashSet<BlogPost>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<BlogPost> getUsers() {
		return users;
	}

	public void setUsers(Set<BlogPost> users) {
		this.users = users;
	}


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", category='" + getCategory() + "'" +
            ", users='" + getUsers() + "'" +
            "}";
    }

	
	
}
