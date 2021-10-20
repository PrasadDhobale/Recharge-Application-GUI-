package shop.model;
public class Customer {

	private int cid;
	private String fName;
	private String lName;
	private int age;
	private String email;
	private String uName;
	private String passwd;
	public Customer(int cid, String fName, String lName, int age, String email, String uName, String passwd) {
		super();
		this.cid = cid;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.email = email;
		this.uName = uName;
		this.passwd = passwd;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}	
}