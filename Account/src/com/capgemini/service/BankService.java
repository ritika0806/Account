package com.capgemini.service;
import com.capgemini.dao.BankDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.capgemini.bean.BankBean;
public class BankService implements IBankService 
{
  BankDAO bdi=new BankDAO();

public BankBean CreateAccount(BankBean bean) 
{
	// TODO Auto-generated method stub
	return bdi.CreateAccount(bean);
}

public BankBean UpdateCustomerName(int account_id, String name) {
	// TODO Auto-generated method stub
	return bdi.UpdateCustomerName(account_id,name);
}

public BankBean UpdateContactNo(int account_id, String contactno) {
	// TODO Auto-generated method stub
	return bdi.UpdateContactNo(account_id,contactno);
}

public BankBean UpdateAddress(int account_id, String address) {
	// TODO Auto-generated method stub
	return bdi.UpdateAddress(account_id,address);
}

public BankBean DeleteAccount(int account_id) {
	// TODO Auto-generated method stub
	return bdi.DeleteAccount(account_id);
}

@SuppressWarnings("rawtypes")
public ArrayList printDetails(int account_id) {
	// TODO Auto-generated method stub
	return bdi.printDetails(account_id);
}

public boolean checkAccountId(int account_id) throws SQLException
{
	// TODO Auto-generated method stub
	return bdi.checkAcccountId(account_id);
}



}
