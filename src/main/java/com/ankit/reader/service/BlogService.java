package com.ankit.reader.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.reader.exception.BlogAlreadyExsitsException;
import com.ankit.reader.exception.InvalidBlogIdException;
import com.ankit.reader.exception.InvalidReactionIdException;
import com.ankit.reader.exception.UnAuthorizedActivityCheckerException;
import com.ankit.reader.model.Blog;
import com.ankit.reader.model.BlogActivity;
import com.ankit.reader.model.Reaction;
import com.ankit.reader.model.User;
import com.ankit.reader.payload.ActivityCheckPayload;
import com.ankit.reader.payload.BlogActivityPayload;
import com.ankit.reader.payload.BlogCreationPayload;
import com.ankit.reader.payload.BlogIndex;
import com.ankit.reader.payload.CommentOnBlogPayload;
import com.ankit.reader.payload.ReactOnBlogPayload;
import com.ankit.reader.repository.BlogActivityRepository;
import com.ankit.reader.repository.BlogRepository;
import com.ankit.reader.repository.ReactionRepository;
import com.ankit.reader.repository.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	BlogActivityRepository blogActivityRepository;
	
	@Autowired
	ReactionRepository reactionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void create(BlogCreationPayload blogCreationPayload ){
		
		String title = blogCreationPayload.getTitle();
		if(blogRepository.existsByTitle(title)) {
			throw new BlogAlreadyExsitsException();
		}
		
		String content = blogCreationPayload.getContent();
		
		Blog b = new Blog(title, content);
		blogRepository.save(b);
		
	}

	public List<Blog> getAllMyBlog(Long userId) {
		
		return blogRepository.findByCreateBy(userId);
		
	}

	public List<BlogIndex> getBlogIndex() {
		// TODO Auto-generated method stub
		return blogRepository.findAllBlogs();
	}

	public Blog getBlog(Long userId,Long blogId) {
		
		Blog blog =  blogRepository.findById(blogId).orElseThrow(()->new InvalidBlogIdException());
		if(blog.getCreateBy() != userId) {
			Reaction reaction = reactionRepository.findById(3L).orElseThrow(()->new InvalidReactionIdException());
			BlogActivity blogActivity = new BlogActivity(blog,null, reaction);
			blogActivityRepository.save(blogActivity);
		}
		return blog;
	}

	public void commentOnBlog(Long userId, CommentOnBlogPayload commentOnBlogPayload) {
		Long blogId = commentOnBlogPayload.getBlogId();
		
		Blog blog =  blogRepository.findById(blogId).orElseThrow(()->new InvalidBlogIdException());
		Reaction reaction = reactionRepository.findById(3L).orElseThrow(()->new InvalidReactionIdException());
		
		BlogActivity blogActivity = new BlogActivity(blog,commentOnBlogPayload.getComment(), reaction);
		blogActivityRepository.save(blogActivity);
		
		
	}
	
	public void reactOnBlog(Long userId, ReactOnBlogPayload reactOnBlogPayload) {
		Long blogId = reactOnBlogPayload.getBlogId();
		
		Blog blog =  blogRepository.findById(blogId).orElseThrow(()->new InvalidBlogIdException());
		Reaction reaction = reactionRepository.findById(reactOnBlogPayload.getReaction()).orElseThrow(()->new InvalidReactionIdException());
		BlogActivity blogActivity = new BlogActivity(blog,null, reaction);
		blogActivityRepository.save(blogActivity);
		
		
	}
	
	public BlogActivityPayload blogActivityCheck(Long userId, ActivityCheckPayload activityCheckPayload ) {
		
		
		Long blogId = activityCheckPayload.getBlogId();
		
		Blog blog =  blogRepository.findById(blogId).orElseThrow(()->new InvalidBlogIdException());
		
		if(userId !=blog.getCreateBy()) {
			throw new UnAuthorizedActivityCheckerException();
		}
		
		Date fromDateTime = activityCheckPayload.getFromDate();
		Date toDateTime = activityCheckPayload.getToDAte();
		
		
		  List<BlogActivity> blogActivity = blogActivityRepository
		  .getActivityDateTimeBetween(fromDateTime, toDateTime, blog.getId());
		  
		  Set<String> emailOfAllReaders = new HashSet<String>();
		  Set<String> emailOfLikers = new HashSet<String>();
		  Set<String> emailOfDisLikers = new HashSet<String>();
		  List<String> comments = new ArrayList<String>();
		  String blogTitle = blog.getTitle();
		  String blogContaint = blog.getContent();
		  Long likesCount = 0L;
		  Long disLikeCount = 0L;
		  Long readCount = (long) blogActivity.size(); 
		  String blogerEmail = userRepository.findById(blog.getCreateBy()).get().getEmail();
		  
		  for(BlogActivity b :blogActivity) {
			  
			  String comment = b.getReaction().getReaction();
			 
			  User user = userRepository.findById(b.getReadBy()).get();
			  emailOfAllReaders.add(user.getEmail());
			  
			  if(b.getReaction().getReaction().equals("LIKE")) {
				  likesCount++;
				  emailOfLikers.add(user.getEmail());
			  }
			  if(b.getReaction().getReaction().equals("DISLIKE")) {
				  disLikeCount++;
				  emailOfDisLikers.add(user.getEmail());
			  }
			  if(comment!="NOTHING") {
				  comments.add(comment);
			  }
			 
			  
		  }
		  
		 
		 
		return new BlogActivityPayload(blogId, blogTitle, blogerEmail, emailOfAllReaders, emailOfLikers, emailOfDisLikers, comments, likesCount, disLikeCount, readCount, blogContaint);
	
		
	}
	
	

}
