package com.example.demo.inquiry;

import java.time.LocalDateTime;

public class Inquiry {

	private int id;
	private String name;
	private String email;
	private String contents;
	private LocalDateTime created;


	public Inquiry(String name, String email, String contents) {
		this.name = name;
		this.email = email;
		this.contents = contents;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}


	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}



}
