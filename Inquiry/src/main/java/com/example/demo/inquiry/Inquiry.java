package com.example.demo.inquiry;

import java.time.LocalDate;

public class Inquiry {

	private int id;
	private String subject;
	private String userId;
	private String email;
	private String name;
	private String tellNum;
	private String contents;
	private LocalDate created;


	public Inquiry(String subject, String userId,  String email, String name, String tellNum, String contents) {
		this.subject  = subject;
		this.userId   = userId;
		this.email    = email;
		this.name     = name;
		this.tellNum  = tellNum;
		this.contents = contents;
	}


	public Inquiry() {
		// TODO 自動生成されたコンストラクター・スタブ
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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


	public String getTellNum() {
		return tellNum;
	}
	public void setTellNum(String tellNum) {
		this.tellNum = tellNum;
	}


	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}


	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}



}
