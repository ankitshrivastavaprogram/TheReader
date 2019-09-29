package com.ankit.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.reader.model.Blog;
import com.ankit.reader.payload.ApiResponse;
import com.ankit.reader.payload.BlogCreationPayload;
import com.ankit.reader.payload.BlogIndex;
import com.ankit.reader.payload.CommentOnBlogPayload;
import com.ankit.reader.payload.ReactOnBlogPayload;
import com.ankit.reader.security.CurrentUser;
import com.ankit.reader.security.UserPrincipal;
import com.ankit.reader.service.BlogService;


@RestController
@RequestMapping("/blog/reader")
public class ReaderController {
	
	@Autowired
	BlogService blogService;	
	
	@GetMapping("/get")
	public ResponseEntity<List<BlogIndex>> getBlogIndex(){
		
		List<BlogIndex> blogs = blogService.getBlogIndex();
		
		return new ResponseEntity<List<BlogIndex>>(blogs,HttpStatus.OK);
	}
	
	@GetMapping("/get/{blogId}")
	public ResponseEntity<Object> getBlog(@CurrentUser UserPrincipal currentUser,@PathVariable Long blogId){
		Long userId = currentUser.getId();
		try {
			Blog blog = blogService.getBlog(userId,blogId);
			
			return new ResponseEntity<Object>(blog,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new ApiResponse(e.getMessage(), false),HttpStatus.BAD_REQUEST);
		}
		
		
		
		
	}
	
	
	@PostMapping("/comment")
	public ResponseEntity<ApiResponse> commentOnBlog(@CurrentUser UserPrincipal currentUser,@RequestBody CommentOnBlogPayload commentOnBlogPayload){
		Long userId = currentUser.getId();
		try {
			blogService.commentOnBlog(userId,commentOnBlogPayload);
			
			return new ResponseEntity<ApiResponse>(new ApiResponse("comment got saved", true),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(e.getMessage(), false),HttpStatus.BAD_REQUEST);
		}		
		
	}
	
	@PostMapping("/react")
	public ResponseEntity<ApiResponse> reactOnBlog(@CurrentUser UserPrincipal currentUser,@RequestBody ReactOnBlogPayload reactOnBlogPayload){
		Long userId = currentUser.getId();
		try {
			blogService.reactOnBlog(userId,reactOnBlogPayload);
			
			return new ResponseEntity<ApiResponse>(new ApiResponse("reaction got saved", true),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(e.getMessage(), false),HttpStatus.BAD_REQUEST);
		}		
		
	}

}
