package com.example.demo.entity;

import lombok.Data;

@Data
public class UserEntity {

	public Long userId;
	public String username;
	public String password;
	public String password_again;
	public String last_name;
	public String first_name;
	public int zip_code;
	public String address;
	public int phone_no;
	public String bank_name;
	public String bank_branch_name;
	public String bank_account_holder;
	public String bank_account_no;

}
