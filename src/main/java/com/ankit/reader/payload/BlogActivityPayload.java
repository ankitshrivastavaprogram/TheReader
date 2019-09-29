package com.ankit.reader.payload;

import java.util.List;
import java.util.Set;

public class BlogActivityPayload {
	
	private Long blogId;
	private String blogTitle;
	private String blogerEmail;
	private Set<String> emailOfAllReaders;
	private Set<String> emailOfLikers;
	private Set<String> emailOfDisLikers;
	private List<String> comments;	
	private Long likesCount;
	private Long disLikeCount;
	private Long readCount;	
	private String blogContaint;
	
	public BlogActivityPayload() {
		super();
		
	}

	public BlogActivityPayload(Long blogId, String blogTitle, String blogerEmail, Set<String> emailOfAllReaders,
			Set<String> emailOfLikers, Set<String> emailOfDisLikers, List<String> comments, Long likesCount,
			Long disLikeCount, Long readCount, String blogContaint) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogerEmail = blogerEmail;
		this.emailOfAllReaders = emailOfAllReaders;
		this.emailOfLikers = emailOfLikers;
		this.emailOfDisLikers = emailOfDisLikers;
		this.comments = comments;
		this.likesCount = likesCount;
		this.disLikeCount = disLikeCount;
		this.readCount = readCount;
		this.blogContaint = blogContaint;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogerEmail() {
		return blogerEmail;
	}

	public void setBlogerEmail(String blogerEmail) {
		this.blogerEmail = blogerEmail;
	}

	
	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public Long getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Long likesCount) {
		this.likesCount = likesCount;
	}

	public Long getDisLikeCount() {
		return disLikeCount;
	}

	public void setDisLikeCount(Long disLikeCount) {
		this.disLikeCount = disLikeCount;
	}

	public Long getReadCount() {
		return readCount;
	}

	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}

	public String getBlogContaint() {
		return blogContaint;
	}

	public void setBlogContaint(String blogContaint) {
		this.blogContaint = blogContaint;
	}

	public Set<String> getEmailOfAllReaders() {
		return emailOfAllReaders;
	}

	public void setEmailOfAllReaders(Set<String> emailOfAllReaders) {
		this.emailOfAllReaders = emailOfAllReaders;
	}

	public Set<String> getEmailOfLikers() {
		return emailOfLikers;
	}

	public void setEmailOfLikers(Set<String> emailOfLikers) {
		this.emailOfLikers = emailOfLikers;
	}

	public Set<String> getEmailOfDisLikers() {
		return emailOfDisLikers;
	}

	public void setEmailOfDisLikers(Set<String> emailOfDisLikers) {
		this.emailOfDisLikers = emailOfDisLikers;
	}
	
		
	

}
