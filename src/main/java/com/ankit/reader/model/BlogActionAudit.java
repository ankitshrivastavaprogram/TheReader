package com.ankit.reader.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BlogActionAudit{

	@CreatedBy
	@Column(name="read_by")
	private Long readBy;
	
	
	@Column(name="read_at")
	@LastModifiedDate
	Date lastReadDate;


	public Long getReadBy() {
		return readBy;
	}


	public void setReadBy(Long readBy) {
		this.readBy = readBy;
	}


	public Date getLastReadDate() {
		return lastReadDate;
	}


	public void setLastReadDate(Date lastReadDate) {
		this.lastReadDate = lastReadDate;
	}
	
	
	
	
	
	
	
}
