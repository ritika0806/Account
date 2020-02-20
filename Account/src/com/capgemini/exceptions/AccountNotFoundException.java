package com.capgemini.exceptions;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String msg) {
		super(msg);
		System.out.println(msg);
	}
}
