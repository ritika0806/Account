package com.capgemini.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.capgemini.bean.BankBean;

public interface IBankService {
	BankBean CreateAccount(BankBean bean);
	BankBean UpdateCustomerName(int account_id,String name);
	BankBean UpdateContactNo(int account_id, String contactno);
	BankBean UpdateAddress(int account_id,String address);;
	BankBean DeleteAccount(int account_id);
	@SuppressWarnings("rawtypes")
	ArrayList printDetails(int account_id);
	 public boolean checkAccountId(int account_id) throws SQLException;

}
