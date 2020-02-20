package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.capgemini.bean.BookBean;

public class BookDAO 
{
public int addBook1(BookBean bookBean)
{
	Connection con=null;
	PreparedStatement pst=null;
	try
	{
		con=BookDB.getConnection1();
		pst=con.prepareStatement("insert into book values(?,?,?,?)");
		pst.setInt(1, bookBean.getBookId());
		pst.setString(2, bookBean.getTitle());
		pst.setFloat(3, bookBean.getPrice());
		pst.setString(4, bookBean.getGrade());
		int updateCount=pst.executeUpdate();
		return updateCount;
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return 0;
	
}
}
