package com.ankit.reader.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ankit.reader.model.BlogActivity;

public interface BlogActivityRepository extends JpaRepository<BlogActivity, Long> {

	
	
	
	  @Query("select a from BlogActivity a where a.lastReadDate >= :fromDateTime or  a.lastReadDate <= :toDateTime AND a.blog.id =:blogId")
	  List<BlogActivity> getActivityDateTimeBetween(@Param("fromDateTime") Date
	  fromDateTime,@Param("toDateTime") Date toDateTime,
	  @Param("blogId") Long blogId
			  );
	 
		
}
