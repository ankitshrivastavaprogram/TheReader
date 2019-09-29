package com.ankit.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.reader.model.Blog;
import com.ankit.reader.payload.ActivityCheckPayload;
import com.ankit.reader.payload.ApiResponse;
import com.ankit.reader.payload.BlogActivityPayload;
import com.ankit.reader.payload.BlogCreationPayload;
import com.ankit.reader.security.CurrentUser;
import com.ankit.reader.security.UserPrincipal;
import com.ankit.reader.service.BlogService;


@RestController
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> create(@RequestBody BlogCreationPayload blogCreationPayload){
		
		try {
			blogService.create(blogCreationPayload);
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(e.getMessage(), false),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Blog is created", false),HttpStatus.OK);
	}
	
	@GetMapping("/bloger/get")
	public ResponseEntity<List<Blog>> getAllMyBlog(@CurrentUser UserPrincipal currentUser){
		Long userId = currentUser.getId();
		List<Blog> blogs = blogService.getAllMyBlog(userId);
		
		return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
	}
	
	@PostMapping("/activity")
    public ResponseEntity<Object> activity(@CurrentUser UserPrincipal currentUser, @RequestBody ActivityCheckPayload activityCheckPayload){
		Long userId = currentUser.getId();
		try {
			BlogActivityPayload blogActivityPayload = blogService.blogActivityCheck(userId, activityCheckPayload);
			return new ResponseEntity<Object>(blogActivityPayload,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new ApiResponse(e.getMessage(), false),HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	

}
