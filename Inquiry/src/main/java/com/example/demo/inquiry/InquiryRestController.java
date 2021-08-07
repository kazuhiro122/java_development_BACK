package com.example.demo.inquiry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inquuiry")
public class InquiryRestController {

	@Autowired
	private InquiryService service;

	//１件取得
	@GetMapping("/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Inquiry getOne(@PathVariable("id") int id) {
		return service.findById(id);
	}
	/*
	 * 「@ResponseBody」は、返値に設定しているクラスのインスタンスをjsonに変換してレスポンスを返してくれるようになる。
	 * クラスに「@RestController」を追加している場合は省略可能。
	 * 「@ResponseStatus(HttpStatus.OK)」は、追加すると処理が成功した場合のHTTPステータスとして200を送信するようになる。
	 * HttpStatusは列挙型(enum)で、BAD＿REQUEST(400)やNOT_FOUND(404)などのステータスも定義されている。
	 */

	//全件取得
	@GetMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Inquiry> getAll() {
		return service.getAll();
	}

	//更新・登録・削除
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(Inquiry inquiry) {
		service.update(inquiry);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void save(Inquiry inquiry) {
		service.save(inquiry);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void delete(@RequestParam("id") int id) {
		service.delete(id);
	}
	/*
	 * 更新・登録・削除はそれぞれPOST・PUT・DELETEメソッドによって処理を分岐させる。
	 * POSTは「@PostMapping」を追加する事は前回までの内容。
	 * PUT・DELETEについては「@PutMapping」、「@DeleteMapping」を追加する。
	 */

}
