package com.capgemini.bean;

import com.capgemini.dao.BookDAO;

public class BookBean {
private int bookId;
public String title;
private float price;
private String grade;
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
/*BookDAO bookDAO=new BookDAO();
BookBean bookBean=new BookBean();*/
}
