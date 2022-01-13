package model;

import java.util.Observable;

public class Librarian extends User
{
	//Attributes
	private int librarianID;
	private String LibrarianFirstName;
	private String LibrarianLastName;
	private String LibrarianPassword;
	//	
	//Constructor
	public Librarian(int librarianID, String librarianFirstName, String librarianLastName, String librarianPassword)
	{
		this.librarianID = librarianID;
		this.LibrarianFirstName = librarianFirstName;
		this.LibrarianLastName = librarianLastName;
		this.LibrarianPassword = librarianPassword;
		this.username=Integer.toString(librarianID);
		this.password=librarianPassword;
	}
	//
	//Getters and setters
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public int getLibrarianID()
	{
		return librarianID;
	}
	public void setLibrarianID(int librarianID)
	{
		this.librarianID = librarianID;
	}
	public String getLibrarianFirstName()
	{
		return LibrarianFirstName;
	}
	public void setLibrarianFirstName(String librarianFirstName)
	{
		LibrarianFirstName = librarianFirstName;
	}
	public String getLibrarianLastName()
	{
		return LibrarianLastName;
	}
	public void setLibrarianLastName(String librarianLastName)
	{
		LibrarianLastName = librarianLastName;
	}
	public String getLibrarianPassword()
	{
		return LibrarianPassword;
	}
	public void setLibrarianPassword(String librarianPassword)
	{
		LibrarianPassword = librarianPassword;
	}
	//
}
