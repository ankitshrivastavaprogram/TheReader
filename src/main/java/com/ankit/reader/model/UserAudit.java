package com.ankit.reader.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@MappedSuperclass
public class UserAudit  extends DateAudit{

	@CreatedBy
	@Column(name="created_by")
	private Long createBy;
	
	@LastModifiedBy
	@Column(name="updated_by")
    private Long updatedBy;

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	
	
	
	
}
