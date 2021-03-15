package com.blog.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "blogposts")
public class BlogPost {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column( nullable=false)
	private String title;
	
	@Column(columnDefinition = "TEXT",nullable=false)
	private String content;
	
	private int likesCounter;
	
	private int dislikesCounter;
	
	private boolean image;
	
	@JsonBackReference(value = "user")
	@ManyToOne
	private User user;
	
	@JsonBackReference(value = "comments")
	@OneToMany(mappedBy = "blogPost")
	private List<Comment> comments = new ArrayList<>();
	
	@JsonBackReference(value = "blogposts_categories")
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable( 
		name = "blogposts_categories", 
		joinColumns = {@JoinColumn(name="blogposts_id")}, 
		inverseJoinColumns = {@JoinColumn(name="categories_id")}  
	)
	private Set<Category> categories = new HashSet<Category>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Category> getCategories() {
		return categories;
	}


	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}


	public int getLikesCounter() {
		return likesCounter;
	}


	public void setLikesCounter(int likesCounter) {
		this.likesCounter = likesCounter;
	}


	public int getDislikesCounter() {
		return dislikesCounter;
	}


	public void setDislikesCounter(int dislikesCounter) {
		this.dislikesCounter = dislikesCounter;
	}


	public boolean isImage() {
		return image;
	}


	public void setImage(boolean image) {
		this.image = image;
	}

}
