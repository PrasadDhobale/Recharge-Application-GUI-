package shop.model;

public class Account {
	private String uname;
	private int accno;
	private double accbal;
		
	public Account(String uname, int accno, double accbal) {
		super();
		this.uname = uname;
		this.accno = accno;
		this.accbal = accbal;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public double getAccbal() {
		return accbal;
	}
	public void setAccbal(double accbal) {
		this.accbal = accbal;
	}		
}
