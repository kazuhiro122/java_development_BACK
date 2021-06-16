package bean;

/*
 * メンバー情報データ(モデル)
 */
public class MemberBean {
	private String Username;
	private String Password;
	private String Password_again;
	private String Last_name;
	private String First_name;
	private String Zip_code;
	private String Address;
	private String Phone_no;
	private String Bank_name;
	private String Bank_branch_name;
	private String Bank_account_holder;
	private String Bank_account_no;

	/*setter&getter*/

	/*
	 * username
	 */
	public void setUsername(String Username) {
		this.Username = Username;
	}
	public String getUsername() {
		return Username;
	}

	/*
	 * password
	 */
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getPassword() {
		return Password;
	}

	/*
	 * password_again
	 */
	public void setPassword_again(String Password_again) {
		this.Password_again = Password_again;
	}
	public String getPassword_again() {
		return Password_again;
	}

	/*
	 * last_name
	 */
	public void setLast_name(String Last_name) {
		this.Last_name = Last_name;
	}
	public String getLast_name() {
		return Last_name;
	}

	/*
	 * first_name
	 */
	public void setFirst_name(String First_name) {
		this.First_name = First_name;
	}
	public String getFirst_name() {
		return First_name;
	}

	/*
	 * zip_code
	 */
	public void setZip_code(String Zip_code) {
		this.Zip_code = Zip_code;
	}
	public String getZip_code() {
		return Zip_code;
	}

	/*
	 * address
	 */
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getAddress() {
		return Address;
	}

	/*
	 * phone_no
	 */
	public void setPhone_no(String Phone_no) {
		this.Phone_no = Phone_no;
	}
	public String getPhone_no() {
		return Phone_no;
	}

	/*
	 * bank_name
	 */
	public void setBank_name(String Bank_name) {
		this.Bank_name = Bank_name;
	}
	public String getBank_name() {
		return Bank_name;
	}

	/*
	 * bank_branch_name
	 */
	public void setBank_branch_name(String Bank_branch_name) {
		this.Bank_branch_name = Bank_branch_name;
	}
	public String getBank_branch_name() {
		return Bank_branch_name;
	}

	/*
	 * bank_account_holder
	 */
	public void setBank_account_holder(String Bank_account_holder) {
		this.Bank_account_holder = Bank_account_holder;
	}
	public String getBank_account_holder() {
		return Bank_account_holder;
	}

	/*
	 * bank_account_no
	 */
	public void setBank_account_no(String Bank_account_no) {
		this.Bank_account_no = Bank_account_no;
	}
	public String getBank_account_no() {
		return Bank_account_no;
	}


}
