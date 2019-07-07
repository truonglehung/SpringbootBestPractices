package com.vsolu.restfuljpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsolu.restfuljpa.model.Blog;
import com.vsolu.restfuljpa.repository.BlogRepository;

@RestController
@RequestMapping(value="/blog")
public class BlogController {
	@Autowired
	private BlogRepository blogrepository ;
	 
	
	@GetMapping("/index")
	public List<Blog> index(){
		
		return blogrepository.findAll();
	}
	
}
