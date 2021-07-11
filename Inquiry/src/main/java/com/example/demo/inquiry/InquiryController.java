package com.example.demo.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	@Autowired
	private InquiryService service;

	//「/inquiry」をコンテキストパスとしてフォームを画面(index.html)を表示する処理
	@GetMapping
	public String form(Model model, InquiryForm inquiryForm) {
		return "inquiry/index";
	}


	//「index.html」のフォームが送信された際に動作する
	//フォームから送信データを受け取るための引数「@RequestParam("フォームのname属性")」
//	@PostMapping("/confirm")
//	public String confirm(
//			@RequestParam("name")String name,
//			@RequestParam("email")String email,
//			@RequestParam("contents")String contents,
//			Model model) {
//		model.addAttribute("inquiryForm", new InquiryForm(name, email, contents));
//		return "inquiry/confirm.html";
//	}
	//⬇️上記を簡潔に記入する方法⬇
	//この書き方をすると自動でaddAttributeされた状態となる️
	/*POSTで受け取った時にバリデーションを実行するようにする
	 * 「@Validated」を引数に組み込む事でバリデーションが実行されるようになる。
	 * また、バリデーションの結果は「BindingResult」に反映されるようになっており、引数に追加する事で参照できる。
	 * 一つでもバリデーションに違反した場合は、if文の値が返される。
	 */
	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm, BindingResult result) {
		if(result.hasErrors()) {
			return "inquiry/index";
		}
		return "inquiry/confirm";
	}

	@PostMapping("/save")
	public String save(@Validated InquiryForm inquiryForm, BindingResult result) {
		if(result.hasErrors()) {
			//エラーの場合の処理。大抵はページに戻る
			return "inquiry/index";
		}
		Inquiry inquiry = new Inquiry(inquiryForm.getName(), inquiryForm.getEmail(), inquiryForm.getContents());
		service.save(inquiry);
		return "inquiry/complete";
	}
	/*@AutowiredによってServiceクラスのインスタンスを自動で生成されるようにする
	 * リクエスト部分では、受け取ったリクエストパラメータからEntityを生成し、Serviceクラスで実装したsaveメソッドを実行する。
	 * あとは完了画面を表示して終了。
	 */

}
