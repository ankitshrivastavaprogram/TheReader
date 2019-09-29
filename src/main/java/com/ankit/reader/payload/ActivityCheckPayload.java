package com.ankit.reader.payload;

import java.util.Date;

public class ActivityCheckPayload {
	
	private Long blogId;
	private Date fromDate;
	private Date toDAte;
	public ActivityCheckPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActivityCheckPayload(Long blogId, Date fromDate, Date toDAte) {
		super();
		this.blogId = blogId;
		this.fromDate = fromDate;
		this.toDAte = toDAte;
	}
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDAte() {
		return toDAte;
	}
	public void setToDAte(Date toDAte) {
		this.toDAte = toDAte;
	}
	
	
	

}
