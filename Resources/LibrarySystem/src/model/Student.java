package model;

import java.util.Observable;

import javax.swing.JOptionPane;

public class Student extends User implements Observer
{
	//Attributes
	private int studentID;
	private String studentFirstName;
	private String studentLastName;
	private String studentPassword;
	private String studentEmail;
	private int isSeated;
	private Inventory libraryInventory;
	private int isNotified=1;
	private int isLogged=0;
	
	//Constructor
	public Student(int studentID, String studentFirstName, String studentLastName, String studentPassword, String studentEmail,Inventory libraryInventory)
	{
		this.studentID = studentID;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentPassword = studentPassword;
		this.studentEmail = studentEmail;
		this.isSeated = 0;
		this.password=studentPassword;
		this.username=Integer.toString(studentID);
		this.libraryInventory=libraryInventory;
		libraryInventory.attach(this);
	}
		
	//Getters and setters
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public int getStudentID()
	{
		return studentID;
	}
	public void setStudentID(int studentID)
	{
		this.studentID = studentID;
	}
	public String getStudentFirstName()
	{
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName)
	{
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName()
	{
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName)
	{
		this.studentLastName = studentLastName;
	}
	public String getStudentPassword()
	{
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword)
	{
		this.studentPassword = studentPassword;
		this.password=studentPassword;
	}
	public String getStudentEmail()
	{
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail)
	{
		this.studentEmail = studentEmail;
	}
	public int getIsSeated()
	{
		return isSeated;
	}
	public void setIsSeated(int isSeated)
	{
		this.isSeated = isSeated;
	}
	public void setNotified(int notified)
	{
		this.isNotified=notified;
	}
	public void setIsLogged(int logged)
	{
		this.isLogged=logged;
	}
	//
	//Observable implementation
	@Override
	public void update() {
		this.isNotified=0;	
	}
	public void showLatestBook()
	{
		if(isNotified==0 && isLogged==1) {
			this.isNotified=1;
			JOptionPane.showMessageDialog(null, "Theres a new book in the library! Its name is "+libraryInventory.getState().getBookName()+" and author name is "+libraryInventory.getState().getBookAuthor());
		}	
	}
	//
}