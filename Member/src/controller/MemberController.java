package controller;

/**
 /* メンバー新規追加
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MemberBean;
import service.MemberService;

public class MemberController extends HttpServlet {

 public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {

 try {

	 MemberBean memberBean = new MemberBean();

	 memberBean.setUsername(request.getParameter("username"));
	 memberBean.setPassword(request.getParameter("password"));
	 memberBean.setPassword_again(request.getParameter("password_again"));
	 memberBean.setLast_name(request.getParameter("last_name"));
	 memberBean.setFirst_name(request.getParameter("first_name"));
	 memberBean.setZip_code(request.getParameter("zip_code"));
	 memberBean.setAddress(request.getParameter("address"));
	 memberBean.setPhone_no(request.getParameter("phone_no"));
	 memberBean.setBank_name(request.getParameter("bank_name"));
	 memberBean.setBank_branch_name(request.getParameter("bank_branch_name"));
	 memberBean.setBank_account_holder(request.getParameter("bank_account_holder"));
	 memberBean.setBank_account_no(request.getParameter("bank_account_no"));

	 MemberService memberService = new MemberService();
	 memberService.insert(memberBean);



 	} catch (Exception e) {
 		e.printStackTrace();
 	}
 }
}