package com.example.demo.inquiry;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InquiryForm {

	//ーーー　フィールド変数　ーーー
	//エラーメッセージでフォームに入力した際にエラーがあればmessageが出力される
	@NotBlank(message = "件名を登録してください")
	@Size(max = 128, message = "件名は128文字以内で入力してください")
	private String subject;

	@NotBlank(message = "ユーザーIDを入力してください")
	@Size(max = 128, message = "ユーザーIDは128文字以内で入力してください")
	private String userId;

	@NotBlank(message = "メールアドレスを入力してください")
	@Size(max = 128, message = "メールアドレスは128文字以内で入力してください")
	@Email(message = "メールアドレスを正しく入力してください")
	private String email;

	@NotBlank(message = "お名前を入力してください")
	@Size(max = 64, message = "お名前は64文字以内で入力してください")
	private String name;

	@NotBlank(message = "電話番号を入力してください")
	@Size(max = 11, message = "電話番号は11文字以内です")
	private String tellNum;

	@NotBlank(message = "お問い合わせ内容を入力してください")
	@Size(max = 512, message = "お問い合わせ内容は512文字以内で入力してください")
	private String contents;


	//ーーー　コンストラクター　ーーー
	public InquiryForm(String subject, String userId,  String email, String name, String tellNum, String contents) {
		this.subject  = subject;
		this.userId   = userId;
		this.email 	  = email;
		this.name     = name;
		this.tellNum  = tellNum;
		this.contents = contents;
	}


	//ーーー　メソッド　ーーー
//	public InquiryForm() {
//		this("", "", "");
//	}


	//ーーー　getter&setter
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


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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




}
