package com.capgemini.bean;

public class BankBean {
	private int account_id;
	private String name;
	private String contactno;
	private String aadhar;
	private String pan;
	private String dob;
	private String gender;
	private String address;

	public BankBean(int account_id, String name, String contactno, String aadhar, String pan, String dob, String gender,String address)
	{
		super();
        this.account_id=account_id;
		this.name = name;
		this.contactno = contactno;
		this.aadhar = aadhar;
		this.pan = pan;
		this.dob = dob;
		this.gender=gender;
		this.address=address;
	}
	public BankBean() {
		super();
		
}
	@Override
	public String toString() {
		return "BankBean [account_id=" + account_id + ", name=" + name + ", contactno=" + contactno + ", aadhar="
				+ aadhar + ", pan=" + pan + ", dob=" + dob + ", gender=" + gender + ", address=" + address + "]";
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}