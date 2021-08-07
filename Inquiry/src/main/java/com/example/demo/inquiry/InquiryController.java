package com.example.demo.inquiry;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	@Autowired
	private InquiryService service;

	//「/inquiry」をコンテキストパスとしてフォーム画面(index.html)を表示する処理
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
	public String save(InquiryForm inquiryForm) {
		Inquiry inquiry = new Inquiry(inquiryForm.getSubject(), inquiryForm.getUserId(), inquiryForm.getEmail(), inquiryForm.getName(), inquiryForm.getTellNum(), inquiryForm.getContents());
		service.save(inquiry);
		return "inquiry/complete";
	}
	/*@AutowiredによってServiceクラスのインスタンスを自動で生成されるようにする
	 * リクエスト部分では、受け取ったリクエストパラメータからEntityを生成し、Serviceクラスで実装したsaveメソッドを実行する。
	 * あとは完了画面を表示して終了。
	 */

	//一覧表示
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("inquirys", service.getAll());
		return "inquiry/list";
	}

	//詳細の表示
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("inquiry", service.findById(id));
		} catch (EmptyResultDataAccessException e) {
			return "redirect:/inquiry/list";
		}
		return "inquiry/detail";
	}
	/*
	 * 詳細ページでは一覧ページで洗濯したIDに該当する情報を表示する。このIDを指定する方法にパスパラメータを使用する。
	 * パスパラメータはURLの一部をパラメータとして扱うことができる。
	 * 今回の場合「/inquiry/detail/1」であればID=1として扱う。
	 */

	//削除
	@PostMapping("/delete")
	public String detail(@RequestParam("id") int id) {
		service.delete(id);
		return "redirect:/inquiry/list";
	}
	/*
	 * 削除処理実行後、一覧ページに戻るようにする。ただし、今までのように「return "inquiry/list.html"」とページを表示してしまうと、
	 * listで実装したように全ての情報を取得する必要があるためリダイレクトします。
	 * リダイレクトは、指定したパスに転送することで、今回は「/inquiry/list」に転送するという意味になり、こうすることで「inquiry/list」に実装している処理が実行され、一覧ページが表示される。
	 */

	@ExceptionHandler({Exception.class})
	public String handleException(Exception e, HttpServletResponse response, Model model) {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return "inquiry/error";
	}
	/*
	 * 上記の場合、「InquiryController」で発生する全ての例外はここで処理される
	 * ただし、個別で対応しているtry-catchの分は対象外
	 * 引数にExceptionクラスを設定する事で、例外に内容を取得することができる。
	 * 特定の例外のみ処理したい場合は、アノテーションで指定しているExceptionクラスを指定のクラスに変更する。
	 */

}
