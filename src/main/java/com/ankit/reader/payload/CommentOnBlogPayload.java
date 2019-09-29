package com.ankit.reader.payload;

public class CommentOnBlogPayload {
	
	private Long blogId;
	private String comment;
	public CommentOnBlogPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentOnBlogPayload(Long blogId, String comment) {
		super();
		this.blogId = blogId;
		this.comment = comment;
	}
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
