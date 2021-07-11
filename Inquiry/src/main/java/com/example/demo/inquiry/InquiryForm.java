package com.example.demo.inquiry;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InquiryForm {

	//ーーー　フィールド変数　ーーー
	//エラーメッセージでフォームに入力した際にエラーがあればmessageが出力される
	@NotBlank(message = "お名前を入力してください")
	@Size(max = 64, message = "お名前は64文字以内で入力してください")
	private String name;

	@NotBlank(message = "メールアドレスを入力してください")
	@Size(max = 128, message = "メールアドレスは128文字以内で入力してください")
	@Email(message = "メールアドレスを正しく入力してください")
	private String email;

	@NotBlank(message = "お問い合わせ内容を入力してください")
	@Size(max = 512, message = "お問い合わせ内容は512文字以内で入力してください")
	private String contents;


	//ーーー　コンストラクター　ーーー
	public InquiryForm(String name, String email, String contents) {
		this.name = name;
		this.email = email;
		this.contents = contents;
	}


	//ーーー　メソッド　ーーー
//	public InquiryForm() {
//		this("", "", "");
//	}


	//ーーー　getter&setter　
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




}
