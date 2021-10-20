package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import shop.model.Customer;

public class CustomerDao {
	Connection con = null;
	Database db = new Database();
	PreparedStatement ps;

	public int RegisterCust(Customer cust) {
		con = db.getConnection();
		int flag = 0;
		try{
			ps=con.prepareStatement("insert into gbCustomer values(?,?,?,?,?,?,?,systimestamp)");
			ps.setInt(1,cust.getCid());
			ps.setString(2,cust.getfName());
			ps.setString(3,cust.getlName());
			ps.setInt(4,cust.getAge());
			ps.setString(5,cust.getEmail());
			ps.setString(6,cust.getuName());
			ps.setString(7,cust.getPasswd());
			int i=ps.executeUpdate();
			if(i>0){
				flag = 1;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public Customer Login(String uname,String pass) {
		con=db.getConnection();
		Customer c = null;
		try{
			PreparedStatement ps = con.prepareStatement("Select * from gbcustomer where username = ? and password= ?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	public Customer Search(String uname) {
		boolean b = false;
		Customer c = null;		
		con=db.getConnection();
		
		try{			
			PreparedStatement ps = con.prepareStatement("Select * from gbcustomer where username = ?");
			ps.setString(1, uname);		
			ResultSet rs = ps.executeQuery();
			if(rs.next() == false) {
				c = null;
			}else {				
				c = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5),rs.getString(6),rs.getString(7));				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}		
		return c;
	}
	public boolean Delete(String uname) {
		boolean b = false;
		con=db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Delete From gbCustomer Where username = ?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public LinkedList<Customer> AllCustomer() {
		LinkedList<Customer> cust=new LinkedList<Customer>();
		
		con=db.getConnection();		
		try{
			String str="select * from gbCustomer";
			PreparedStatement ps = con.prepareStatement(str);
			ResultSet result = ps.executeQuery();
			if (result.next() == false) { 
				//System.out.println("ResultSet in empty in Java");
				cust = null;				
			} else { 
				do { 
					Customer c1 = new Customer(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4), result.getString(5),result.getString(6), result.getString(7));
					cust.add(c1);
				}while (result.next()); 
			}			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cust;
	}
	public boolean checkuser(int cid,String uname) {
		boolean b = false;
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select cid,username from gbcustomer where cid = ? or username = ?");
			ps.setInt(1, cid);
			ps.setString(2, uname);
			int i = ps.executeUpdate();
			if(i>0) {
				b = true;
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public int changePass(String uname,String pass) {		
		int f = 0;
		con = db.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update gbcustomer set password = ? where username = ?");
			ps.setString(1, pass);
			ps.setString(2, uname);
			int i = ps.executeUpdate();
			if(i > 0) {
				f = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
}
