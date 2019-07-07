package com.vsolu.restfuljpa.model;

import javax.persistence.*;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title ;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Blog(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public Blog() {
		super();
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	
}
