package com.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comment {
        @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
		@Column(columnDefinition = "TEXT")
	    private String reply;
		
		private int likeCounter;
		
		private int dislikeCounter;
	 
		@JsonBackReference(value = "blogPost")
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn
	    private BlogPost blogPost;
	 
	    @JsonBackReference(value = "user")
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn
	    private User user;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getReply() {
			return reply;
		}

		public void setReply(String reply) {
			this.reply = reply;
		}

		public BlogPost getPost() {
			return blogPost;
		}

		public void setPost(BlogPost post) {
			this.blogPost = post;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public int getLikeCounter() {
			return likeCounter;
		}

		public void setLikeCounter(int likeCounter) {
			this.likeCounter = likeCounter;
		}

		public int getDislikeCounter() {
			return dislikeCounter;
		}

		public void setDislikeCounter(int dislikeCounter) {
			this.dislikeCounter = dislikeCounter;
		}
}
