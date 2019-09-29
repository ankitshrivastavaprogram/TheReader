package com.ankit.reader.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ankit.reader.model.Blog;
import com.ankit.reader.payload.BlogIndex;


@Repository
public interface BlogRepository extends JpaRepository<Blog,Long>{
	
	boolean existsByTitle(String title);
	List<Blog> findByCreateBy(Long id);
	
	@Query("select NEW com.ankit.reader.payload.BlogIndex(b.id,b.title,b.createBy) from Blog b ")
	List<BlogIndex> findAllBlogs();
	
	@Query("select b from Blog b where b.id=:blogId")
	Optional<Blog> findById(@Param("blogId") Long blogId);
	
	boolean existsById(Long blogId);

}
