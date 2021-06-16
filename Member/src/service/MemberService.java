package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import bean.MemberBean;

/**
 * ・メンバー情報サービス
 */

public class MemberService {

 /** ドライバーのクラス名 */
 private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
 /** ・JDMC接続先情報 */
 private static final String JDBC_CONNECTION = "";
 /** ・ユーザー名 */
 private static final String USER = "postgres";
 /** ・パスワード */
 private static final String PASS = "postgres";

 /** ・SQL INSERT文 */
 private static final String SQL_INSERT = "INSERT INTO member (username, password, password_again, last_name, first_name, zip_code, address, phone_no, bank_name, bank_branch_name, bank_account_holder, bank_account_no) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

 public void insert(MemberBean memberBean) {

	 Connection connection = null;
	 Statement statement = null;
	 PreparedStatement preparedStatement = null;

	 try {

		 // データベースに接続
		 Class.forName(POSTGRES_DRIVER);
		 connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
		 statement = connection.createStatement();

		 // preparedStatementに実行したいSQLを格納
		 preparedStatement = connection.prepareStatement(SQL_INSERT);
		 // preparedStatementを使って、入力フォームの値を格納
		 preparedStatement.setString(1, memberBean.getUsername());
		 preparedStatement.setString(2, memberBean.getPassword());
		 preparedStatement.setString(3, memberBean.getPassword_again());
		 preparedStatement.setString(4, memberBean.getLast_name());
		 preparedStatement.setString(5, memberBean.getFirst_name());
		 preparedStatement.setString(6, memberBean.getZip_code());
		 preparedStatement.setString(7, memberBean.getAddress());
		 preparedStatement.setString(8, memberBean.getPhone_no());
		 preparedStatement.setString(9, memberBean.getBank_name());
		 preparedStatement.setString(10, memberBean.getBank_branch_name());
		 preparedStatement.setString(11, memberBean.getBank_account_holder());
		 preparedStatement.setString(12, memberBean.getBank_account_no());

		 // INSERTを実行する文を記述
		 preparedStatement.executeUpdate();

		 // forName()で例外発生
	 } catch (ClassNotFoundException e) {
		 e.printStackTrace();

		 // getConnection()、createStatement()で例外発生
	 } catch (SQLException e) {
		 e.printStackTrace();
	 } finally {
		 try {
			 if (statement != null) {
				 statement.close();
			 }
			 if (connection != null) {
				 // データベースを切断
				 connection.close();
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
 }
}
