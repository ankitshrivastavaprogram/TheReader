package com.ankit.reader.payload;

public class ReactOnBlogPayload {
	
	private Long blogId;
	private Long reaction;
	public ReactOnBlogPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReactOnBlogPayload(Long blogId, Long reaction) {
		super();
		this.blogId = blogId;
		this.reaction=reaction;
	}
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public Long getReaction() {
		return reaction;
	}
	public void setReaction(Long reaction) {
		this.reaction = reaction;
	}
	
	
	

}
