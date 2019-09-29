package com.ankit.reader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="blog_activites")
public class BlogActivity extends BlogActionAudit {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="comment")
	private String comment;
	
	@OneToOne
	@JoinColumn(name="reaction")
	Reaction reaction;
	
	@ManyToOne
	@JoinColumn(name="blog")
	private Blog blog;

	public BlogActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogActivity(Blog blog,String comment, Reaction reaction) {
		super();
		this.comment = comment;
		this.reaction = reaction;
		this.blog = blog;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Reaction getReaction() {
		return reaction;
	}

	public void setReaction(Reaction reaction) {
		this.reaction = reaction;
	}

	public Long getId() {
		return id;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	
	
	
	
	
}
