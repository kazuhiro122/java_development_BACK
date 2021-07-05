package com.example.demo.member;

//newMemberForm.htmlで入力した値をフィール変数に格納される
public class MemberForm {

	private String  username;
	private String  password;
	private String  password_again;
	private String  last_name;
	private String  first_name;
	private Integer zip_code;
	private String  address;
	private Integer phone_no;
	private String  bank_name;
	private String  bank_branch_name;
	private String  bank_account_holder;
	private Integer bank_account_no;


	/*
	 * --------getter&setter
	 */
	//
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getPassword_again() {
		return password_again;
	}
	public void setPassword_again(String password_again) {
		this.password_again = password_again;
	}


	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public Integer getZip_code() {
		return zip_code;
	}
	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(Integer phone_no) {
		this.phone_no = phone_no;
	}


	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}


	public String getBank_branch_name() {
		return bank_branch_name;
	}
	public void setBank_branch_name(String bank_branch_name) {
		this.bank_branch_name = bank_branch_name;
	}


	public String getBank_account_holder() {
		return bank_account_holder;
	}
	public void setBank_account_holder(String bank_account_holder) {
		this.bank_account_holder = bank_account_holder;
	}


	public Integer getBank_account_no() {
		return bank_account_no;
	}
	public void setBank_account_no(Integer bank_account_no) {
		this.bank_account_no = bank_account_no;
	}

}
