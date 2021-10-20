package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.model.Account;

public class AccountDao {

	Connection con = null;
	PreparedStatement ps = null;
	Database db = new Database();
	public int adAccount(Account a){
		int f = 0;		
		con = db.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into gbaccount (username,accno,accbal,add_time) values(?,?,?,systimestamp)");
			ps.setString(1, a.getUname());
			ps.setInt(2, a.getAccno());
			ps.setDouble(3, a.getAccbal());
			int i = ps.executeUpdate();
			if(i > 0) {
				f = 1;				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
		return f;
	}
	
	public double getbal(String uname) {		
		double accbal = 0;
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select accbal from gbaccount where username = ?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next() == false) {
				accbal = 0;
			}else {
				accbal = rs.getDouble(1);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return accbal;
	}
	
	public int recharge(String uname,double amt) {
		int f = 0;
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update gbaccount set accbal = ? where username = ?");
			ps.setDouble(1, amt);
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
	public int addMoney(String uname,double newbal) {
		int f = 0;
		con = db.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("update gbaccount set accbal = accbal + ? where username = ?");
			ps.setDouble(1, newbal);
			ps.setString(2, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				f = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return f;
	}
}
