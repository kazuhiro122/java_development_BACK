package com.example.demo.member;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;


@Entity
@Table(name="member")
public class MemberBean {

	@Id
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "半角英数字で設定してください")
	@Column(unique = true)
	private String  username;

	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "半角英数字で設定してください")
	@Column(unique = true)
	private String  password;

	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "確認のためもう一度パスワードを入力してください")
	@Column(unique = true)
	private String  password_again;

	@NotNull
	@Column
	private String  last_name;

	@NotNull
	@Column
	private String  first_name;

	@NotNull
	@Pattern(regexp = "[0-9]{3}[-]{0,1}[0-9]{4}", message = "郵便番号の形式で入力してください")
	@Column
	private Integer zip_code;

	@NotNull
	@Column
	private String  address;

	@NotNull
	@Column(unique = true)
	@Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式で入力してください")
	private Integer phone_no;

	@NotNull
	@Column
	private String  bank_name;

	@NotNull
	@Column
	private String  bank_branch_name;

	@NotNull
	@Column
	private String  bank_account_holder;

	@NotNull
	@Column(unique = true)
	private Integer bank_account_no;


	/*
	 * --------コンストラクター--------
	 */
	public MemberBean() {}


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
