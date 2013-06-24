package controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	
	private String id;
	private String author_firstname;
	private String author_lastname;
	private String ISBN;
	private String book_name;
	private double price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor_firstname() {
		return author_firstname;
	}
	public void setAuthor_firstname(String author_firstname) {
		this.author_firstname = author_firstname;
	}
	public String getAuthor_lastname() {
		return author_lastname;
	}
	public void setAuthor_lastname(String author_lastname) {
		this.author_lastname = author_lastname;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
