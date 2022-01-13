package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import model.Book;
import model.Librarian;
import model.Library;
import model.Loan;
import model.Student;
import view.LibririanMenuView;
import view.LoginView;
import view.UserMenuView;

public class LoginPageController {
	//Controllers Attributes
	private LoginView appFrame;
	private Library library;
	private UserMenuView userMenuView;
	private LibririanMenuView libririanMenuView;
	private Student activeStudent=null;
	private Librarian activeLibrarian=null;
	private Object[][] row= new Object[100][4];
	private boolean callListeners=true;
	//
	
	//Constructor and start method
	public LoginPageController()
	{
		library=Library.getInstance();
	}
	public void start()
	{
		appFrame = new LoginView(this);
	}
	//

	//Getters and Setters
	public Student getActiveStudent() {
		return activeStudent;
	}
	public void setActiveStudent() {
		this.activeStudent = null;
	}
	public Librarian getActiveLibrarian() {
		return activeLibrarian;
	}
	public void setActiveLibrarian() {
		this.activeLibrarian = null;
	}
	public boolean isCallListeners() {
		return callListeners;
	}
	public void setCallListeners(boolean callListeners) {
		this.callListeners = callListeners;
	}
	public LoginView getAppFrame()
	{
		return appFrame;
	}
	public Student getStudent()
	{
		return activeStudent;
	}
	public Library getLibrary() {
		return library;
	}
	public Librarian getLibririan()
	{
		return activeLibrarian;
	}
	//
	
	//Controller Methods
	//As MVC design sets, the controller holds method who connect between the view and the model.
	public  Object[][] createBookArray()//Creates the book array.
	{
		return library.createBookArray();
	}
	public  Object[][] createLoanArray()//Creates the loan array.
	{
		return library.createLoanArray();
	}
	public Object[][] createReturnBookArray()//Creates the potential return book array.
	{
		return library.createReturnBookArray(this.activeStudent.getStudentID());
	}
	public Object[][] createUsersArray()//Creates the users array.
	{
		return library.createUsersArray();
	}
	public Object[][] createHistoryLoansArray()//Creates the history loans array of a user.
	{
		return library.createHistoryLoansArray(this.activeStudent.getStudentID());
	}
	public Object[][] updateSearchTable(String text,int column,Object[][] row)//Updates the books search table.
	{
		return library.updateSearchTable(text, column, row);
	}
	public Object[][] updateUserSearchTable(String text,int column,Object[][] row)//Updates the users search table.
	{
		return library.updateUserSearchTable(text, column, row);
	}
	public Object[][] updateLoanTable(String text,int column,Object[][] row)//updates the loans search table.
	{
		return library.updateLoanTable(text, column, row);
	}
	public void makeLoan(int bookID)//making a loan to the appropriate user.
	{
		int i =activeStudent.getStudentID();
		library.makeLoan(bookID, i);
	}

	public void returnALoan(int bookID)//cancels out a loan for the appropriate user.
	{
		library.returnALoan(activeStudent.getStudentID(), bookID);
	}
	public void checkReservedSeat(int i)//Checks if the seat is reserved
	{
		library.checkReservedSeat(i);
	}
	public boolean cancelReservedSeat(int i)//Cancels out a reserved seat.
	{
		return library.cancelkReservedSeat(i);
	}
	public void reserveSeat(int i)//Reserves the seat for the user.
	{
		library.getLibraryMap().reserveSeat(i,activeStudent.getStudentID());
	}
	public boolean signIn(String userName, String password)//Performs a check of inputted credentials and signs in the user.
	{
		if(library.checkStudent(userName,password)==true)
		{
			JOptionPane.showMessageDialog(null, "You logged in succesfully as a Student.");
			this.activeStudent=library.getStudentCreds(userName, password);
			this.activeStudent.setIsLogged(1);
			this.activeStudent.showLatestBook();
			userMenuView = new UserMenuView(this);
			return true;
		}
		else if (library.checkLibriran(userName,password)==true)
		{
			JOptionPane.showMessageDialog(null, "You logged in succesfully as a Libririan.");
			this.activeLibrarian=library.getLibrarianCreds(userName, password);
			libririanMenuView = new LibririanMenuView(this);
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Your credentials are incorrect");
			return false;
		}
	}
		
	public boolean addNewBook(int bookID, String bookName, String bookAuthor, String bookGenre, int bookAmout)//Adds new Book to the book array.
	{
		return library.addNewBook(bookID, bookName, bookAuthor, bookGenre, bookAmout);
	}
		
}
