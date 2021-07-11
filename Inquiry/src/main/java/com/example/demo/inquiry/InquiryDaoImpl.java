package com.example.demo.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InquiryDaoImpl implements InquiryDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(Inquiry inquiry) {
		jdbcTemplate.update("INSERT INTO inquiry(name, email, contents) VALUES(?, ?, ?)",
		inquiry.getName(), inquiry.getEmail(), inquiry.getContents());
	}

}

/*JdbcTemplateクラスは、Java Data JDBCでデータベースにアクセスするためのクラス。
 * 不必要にインスタンsを生成されないように、InqiryDaoImplのコンストラクタでのみインスタンスを生成するようにします（シングルトン）
 * コンストラクタに@Autowiredとする事で、引数のJdbcTemplateのインスタンスを自動で生成してくれるようになる。
 * 実際の登録の処理は、JdbcTemplateのupdateメソッドによって実装している。第一引数にクエリ(SQL文)をPreparedStatementの形式で指定。
 * PreparedStatementは、SQLインジェクションを防ぐための仕組みです。クエリの「？」はプレースホルダーと呼ばれ、一般的には「？」の位置に該当するデータとその型を指定。
 * JdbcTemplateでは、第二引数以降でプレースホルダーを設定していきます。今回はname、email、contentsの値を登録したいので、第二引数以降にinquiryに格納されたそれぞれの値を順番通りに設定する。
*/