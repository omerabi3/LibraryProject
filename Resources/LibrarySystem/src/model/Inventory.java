package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;

public class Inventory extends Observable{
	//Inventory Attributes
	private List<Observer> observers = new ArrayList<Observer>();
	private int amountOfBooks=10;
	private Book recentBook;
	private Book[] Books= new Book[100];	// holds maximum 100 books as described in project assesment.
	//
	// Observer Design Pattern methods.
	// Updates the logged in students about the most recent book added. 
	public Book getState() 
	{
		return recentBook;
	}

	public void setState(Book bookState) {
	 this.recentBook = bookState;
	 notifyAllObservers();
	 }
	public void attach(Observer observer)
	{
		observers.add(observer);		
	}
	public void notifyAllObservers(){
		for (Observer observer : observers) {			
		         observer.update();
		      }
		   } 
	//
	// Inventory object constructor.
	public Inventory()
	{
		createBooks();// Creates the books array.
	}
	// Getters and Setters
	public Book getBookByID(int bookID)
	{
		return Books[bookID-1];
	}
	public int getAmountOfBooks()
	{
		return this.amountOfBooks;
	}
	public void setAmountOfBooks(int number)
	{
		this.amountOfBooks=this.amountOfBooks+number;
	}
	public void setBooks(Book[] books) {
		Books = books;
	}
	public Book[] getBooks() {
		return Books;
	}
	//
	// Inventory Methods.
	public void addBook(Book newBook) // Adds a new book into the book array.
	{
		if(amountOfBooks>100)
		{
			JOptionPane.showMessageDialog(null, "Can't add anymore books, max capacity.");
		}
		else
		{
			Books[amountOfBooks]=newBook;
			amountOfBooks++; // updates the amount of given books.
			setState(newBook);
		}
	}
	private void createBooks() // Creates the book array.
	{
		Books[0]=new Book(1,"Peter pen","Fantasy","David Schummer",10,10);
		Books[1]=new Book(2,"Micky Mouse","Comics","Sara Parker",20,20);
		Books[2]=new Book(3,"Ninja Turtles","Action","Tommy Doop",30,30);
		Books[3]=new Book(4,"Tall Grim","Fantasy","Jonna Yale",40,40);
		Books[4]=new Book(5,"D&D","Fantasy","Jessica Parker",10,10);
		Books[5]=new Book(6,"Chernobyl","Drama","Amy Gershon",5,5);
		Books[6]=new Book(7,"Human Centipede","Horror","Peter Parker",10,10);
		Books[7]=new Book(8,"Anna Frank","Drama","Tony Stark",20,20);
		Books[8]=new Book(9,"Pick A Number","Action","Pepper Potts",30,30);
		Books[9]=new Book(10,"The One","Fantasy","Steve Rogers",7,7);
		recentBook=Books[9];//Set most recenetly added book.
	}
	public void editBookByID(int bookID,String bookName,String bookGenre,String bookAuthor,int bookAmountAvailable,int bookAmount) // Edits the given book by id's properties.
	{
		if(bookAmount<bookAmountAvailable) // Checks for data integrity.
		{
			JOptionPane.showMessageDialog(null, "The book amount must be higer or equal to the amount available.");
		}
		else
		{
			getBookByID(bookID).setBookAmount(bookAmount);
			getBookByID(bookID).setBookAmountAvailable(bookAmountAvailable);
			getBookByID(bookID).setBookAuthor(bookAuthor);
			getBookByID(bookID).setBookGenre(bookGenre);
			getBookByID(bookID).setBookName(bookName);
			JOptionPane.showMessageDialog(null, "Book is succesfully updated.");
		}
	}
	public void setToNotInStock(int bookID) // Lowers the amount available to zero thus making it not in stock.
	{
		getBookByID(bookID).setBookAmount(0);
		getBookByID(bookID).setBookAmountAvailable(0);
		amountOfBooks--;
		JOptionPane.showMessageDialog(null, "Book is no longer in stock.");
	}

}
