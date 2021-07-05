package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")//このコントローラーを訪れるURLの指定
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;

	@GetMapping("/")
	public String form(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "/NewMemberForm";
	}

	@PostMapping("/newMemberRegistration")
	public String registration(@Validated MemberForm memberForm,
			BindingResult result,
			Model model
			) {

		if(result.hasErrors()) {
			model.addAttribute("memberForm", new MemberForm());
			return "/NewMemberForm";
		}

		//確認のため
		model.addAttribute("title", "登録完了");

		MemberBean newMember = new MemberBean();
		newMember.setUsername(memberForm.getUsername());
		newMember.setPassword(memberForm.getPassword());
		newMember.setPassword_again(memberForm.getPassword_again());
		newMember.setLast_name(memberForm.getLast_name());
		newMember.setFirst_name(memberForm.getFirst_name());
		newMember.setZip_code(memberForm.getZip_code());
		newMember.setAddress(memberForm.getAddress());
		newMember.setPhone_no(memberForm.getPhone_no());
		newMember.setBank_name(memberForm.getBank_name());
		newMember.setBank_branch_name(memberForm.getBank_branch_name());
		newMember.setBank_account_holder(memberForm.getBank_account_holder());
		newMember.setBank_account_no(memberForm.getBank_account_no());

		memberRepository.insertMember(newMember);
		return "redirect:/MemberConfirm";
	}


}
