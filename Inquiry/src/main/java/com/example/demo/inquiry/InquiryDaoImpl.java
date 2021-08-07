package com.example.demo.inquiry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	//登録INSERT文
	@Override
	public void create(Inquiry inquiry) {
		jdbcTemplate.update("INSERT INTO inquiry(name, email, contents) VALUES(?, ?, ?, ?, ?, ?)",
		inquiry.getSubject(), inquiry.getUserId(), inquiry.getEmail(), inquiry.getName(), inquiry.getTellNum(), inquiry.getContents());
	}
	//削除DELETE文
	@Override
	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM inquiry WHERE id = ?", id);
	}
	//更新UPDATE文
	public void update(Inquiry inquiry) {
		jdbcTemplate.update("UPDATE  inquiry SET subject = ?, userId = ?, email = ?, name = ?, tellNum = ?, contents = ? WHERE id = ?",
		inquiry.getSubject(), inquiry.getUserId(), inquiry.getEmail(), inquiry.getName(), inquiry.getTellNum(), inquiry.getContents(), inquiry.getId());
	}

	//Id指定による取得
	@Override
	public Inquiry findById(int id) {

		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM inquiry WHERE id = ?", id);
		Inquiry inquiry = new Inquiry();
		inquiry.setId((int) map.get("id"));
		inquiry.setSubject((String) map.get("subject"));
		inquiry.setUserId((String) map.get("userId"));
		inquiry.setEmail((String) map.get("email"));
		inquiry.setName((String) map.get("name"));
		inquiry.setTellNum((String) map.get("tellNum"));
		inquiry.setContents((String) map.get("contents"));
		inquiry.setCreated(((LocalDateTime) map.get("created")).toLocalDate());
		return inquiry;
	}

	//全取得
	@Override
	public List<Inquiry> getAll() {

		List<Inquiry> inquirys = new ArrayList<>();

		for (Map<String, Object> row : jdbcTemplate.queryForList("SELECT * FROM inquiry ORDER BY id")) {
			Inquiry inquiry = new Inquiry();
			inquiry.setId((int) row.get("id"));
			inquiry.setSubject((String) row.get("subject"));
			inquiry.setUserId((String) row.get("userId"));
			inquiry.setEmail((String) row.get("email"));
			inquiry.setName((String) row.get("name"));
			inquiry.setTellNum((String) row.get("tellNum"));
			inquiry.setContents((String) row.get("contents"));
			inquiry.setCreated(((LocalDateTime) row.get("created")).toLocalDate());
			inquirys.add(inquiry);
		}

		return inquirys;

	}

}

/*JdbcTemplateクラスは、Java Data JDBCでデータベースにアクセスするためのクラス。
 * 不必要にインスタンsを生成されないように、InqiryDaoImplのコンストラクタでのみインスタンスを生成するようにします（シングルトン）
 * コンストラクタに@Autowiredとする事で、引数のJdbcTemplateのインスタンスを自動で生成してくれるようになる。
 * 実際の登録の処理は、JdbcTemplateのupdateメソッドによって実装している。第一引数にクエリ(SQL文)をPreparedStatementの形式で指定。
 * PreparedStatementは、SQLインジェクションを防ぐための仕組みです。クエリの「？」はプレースホルダーと呼ばれ、一般的には「？」の位置に該当するデータとその型を指定。
 * JdbcTemplateでは、第二引数以降でプレースホルダーを設定していきます。今回はname、email、contentsの値を登録したいので、第二引数以降にinquiryに格納されたそれぞれの値を順番通りに設定する。
*/