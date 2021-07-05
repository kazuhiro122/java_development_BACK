package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public MemberRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertMember(MemberBean memberBean) {
		jdbcTemplate.update("INSERT INTO member(username, password, password_again, last_name, first_name, zip_code, address, phone_no, bank_name, bank_branch_name, bank_account_holder, bank_account_no) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				memberBean.getUsername(), memberBean.getPassword(), memberBean.getPassword_again(), memberBean.getLast_name(), memberBean.getFirst_name(), memberBean.getZip_code(), memberBean.getAddress(), memberBean.getPhone_no(), memberBean.getBank_name(), memberBean.getBank_branch_name(), memberBean.getBank_account_holder(), memberBean.getBank_account_no());
	}

}
