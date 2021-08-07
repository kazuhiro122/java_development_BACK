package com.example.demo.inquiry;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

	@ExceptionHandler
	public String handleException(Exception e) {
		return "inquiry/index";
	}

	/*
	 * 全てのコントローラーに共通する例外処理を設定することができる。
	 * そのためのクラスを作成
	 */

}
