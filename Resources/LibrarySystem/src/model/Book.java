package model;

import java.util.Observable;

public class Book{
	// Book Atributes
	private int bookID;
	private String bookName;
	private String bookGenre;
	private String bookAuthor;
	private int bookAmountAvailable;
	private int bookAmount;
	//
	// Book object constructor
	public Book(int bookID, String bookName, String bookGenre, String bookAuthor, int bookAmountAvailable,int bookAmount) 
	{
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookGenre = bookGenre;
		this.bookAuthor = bookAuthor;
		this.bookAmountAvailable = bookAmountAvailable;
		this.bookAmount = bookAmount;
	}
	//
	//Getters and Setters
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookAmountAvailable() {
		return bookAmountAvailable;
	}
	public void setBookAmountAvailable(int bookAmountAvailable) {
		this.bookAmountAvailable = bookAmountAvailable;
	}
	public int getBookAmount() {
		return bookAmount;
	}
	public void setBookAmount(int bookAmount) {
		this.bookAmount = bookAmount;
	}	
	//
}
