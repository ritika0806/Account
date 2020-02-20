package com.capgemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.capgemini.bean.BankBean;
public class BankDAO implements IBankDao
{
	public void openConnection() 
	{
		try
		{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 String url="jdbc:oracle:thin:@localhost:1521:xe";
			@SuppressWarnings("unused")
			Connection connection = DriverManager.getConnection(url,"ritika","123456");
	    } catch(ClassNotFoundException | SQLException e)
		{
	    	e.printStackTrace();
		}
	}
	
	public void close()
	{
		try 
		{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection connection = DriverManager.getConnection(url,"ritika","123456");
						connection.close();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}

	
	public BankBean CreateAccount(BankBean bean) 
	{
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection connection = DriverManager.getConnection(url,"ritika","123456");
                       
			PreparedStatement p = connection.prepareStatement("insert into BankAccount values(?,?,?,?,?,?,?,?)");
			p.setInt(1,bean.getAccount_id());
			p.setString(2, bean.getName());
			p.setString(3, bean.getContactno());
			p.setString(4, bean.getAadhar());
			p.setString(5, bean.getPan());
			p.setString(6, bean.getDob());
			p.setString(7, bean.getGender());
			p.setString(8, bean.getAddress());
			p.executeUpdate();

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bean;
	}

	public BankBean UpdateCustomerName(int account_id,String name) {
		BankBean b = new BankBean();
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection connection = DriverManager.getConnection(url,"ritika","123456");
			PreparedStatement s = connection.prepareStatement("update BankAccount set name=? where account_id=?");
				s.setString(1,name);
				s.setInt(2,account_id);
				s.executeUpdate();
		} 
	catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public BankBean UpdateContactNo(int account_id, String contactno) {
		BankBean b = new BankBean();
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection connection = DriverManager.getConnection(url,"ritika","123456");
			PreparedStatement s = connection.prepareStatement("update BankAccount set contactno=? where account_id=?");
			s.setString(1,contactno);
			s.setInt(2,account_id);
			s.executeUpdate();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}
	
	public BankBean UpdateAddress(int account_id,String address) {
		BankBean b = new BankBean();
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection connection = DriverManager.getConnection(url,"ritika","123456");
			PreparedStatement s = connection.prepareStatement("update BankAccount set address=? where account_id=?");
			s.setString(1,address);
			s.setInt(2,account_id);
			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	public BankBean DeleteAccount(int account_id) {
		@SuppressWarnings("unused")
		BankBean b = new BankBean();
		//Connection conn = DBConnect.getConnection1();
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection connection = DriverManager.getConnection(url,"ritika","123456");
			PreparedStatement s = connection.prepareStatement("delete from BankAccount where account_id=?");
			s.setInt(1,account_id);
			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	} 
	@SuppressWarnings("rawtypes")
	public ArrayList printDetails(int account_id) {
		ArrayList<String> a = new ArrayList<String>();
		String str = "";
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection connection = DriverManager.getConnection(url,"ritika","123456");
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("select * from BankAccount where account_id=" + account_id);
			while (rs.next()) {
				str = String.valueOf(rs.getInt(1))+"\t\t";
				str+=rs.getString(2)+"\t\t";
				str+=rs.getString(3)+"\t\t";
				str+=rs.getString(4)+"\t\t";
				str+=rs.getString(5)+"\t\t";
				str+=rs.getString(6)+"\t\t";
				str+=rs.getString(7)+"\t\t";
				str+=rs.getString(8);
				a.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;

	}
	public boolean checkAcccountId(int account_id) throws SQLException {
		  boolean flag=false;
		  try {
			  String url="jdbc:oracle:thin:@localhost:1521:xe";
				Connection connection = DriverManager.getConnection(url,"ritika","123456");
				PreparedStatement pst=connection.prepareStatement("select * from BankAccount where account_id=?");
				pst.setInt(1,account_id);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				flag=true;
				
				else
				flag=false;
				
			} 
		  catch(Exception e)
		  {
			  System.out.println(e);
				//e.printStackTrace();
		  }
		  
		  return flag;
	}

	@Override
	public boolean checkAccountId(int account_id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

