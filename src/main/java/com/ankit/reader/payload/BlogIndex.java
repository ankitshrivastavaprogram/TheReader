package com.ankit.reader.payload;

public class BlogIndex {
	
	private Long blogId;
	private String title;
	private Long blogerId;
	public BlogIndex() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlogIndex(Long blogId, String title, Long blogerId) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.blogerId = blogerId;
	}
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getBlogerId() {
		return blogerId;
	}
	public void setBlogerId(Long blogerId) {
		this.blogerId = blogerId;
	}
	
	
	

}
