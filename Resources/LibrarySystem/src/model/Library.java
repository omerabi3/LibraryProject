package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Observable;

import javax.swing.JOptionPane;

public class Library {
	//Library Attributes
	private static Inventory libraryInventory; // holds the libraries inventory data
	private LibraryMap libraryMap; // holds the libraries map info
	private Loan[] libraryLoans= new Loan[1000]; // holds all the libraries loans
	private int loanAmount=0; //value of the amount of loans made.
	private static Student[] studentList=new Student[3]; // holds the libraries students credentials.
	private static Librarian[] libriranList=new Librarian[3]; // holds the libraries libririans credentials.
	private Object[][] row= new Object[100][4]; // an object array which holds the books data for grid views.
	private static Library instance=null;
	//
	//Singleton object, hence the private constructor, can only be called internally and is called once.
	private Library()
	{
		createInventory();
		generateStudents();
		generateLibrirans();
		libraryMap = new LibraryMap();
	}
	//
	//Singleton object, can get called and created by this static method.
	public static Library getInstance()
	{
		if(instance==null)
		{
			instance = new Library();
		}
		return instance;
	}
	//
	//Getters and Setters
	public LibraryMap getLibraryMap() {
		return libraryMap;
	}

	public void setLibraryMap(LibraryMap libraryMap) {
		this.libraryMap = libraryMap;
	}

	public void setLoanAmount(int loanAmount)
	{
		this.loanAmount=loanAmount;
	}
	public int getLoanAmount()
	{
		return loanAmount;
	}
	public static Student[] getStudentList() {
		return studentList;
	}
	public static void setStudentList(Student[] studentList) {
		Library.studentList = studentList;
	}
	public static Librarian[] getLibriranList() {
		return libriranList;
	}
	public static void setLibriranList(Librarian[] libriranList) {
		Library.libriranList = libriranList;
	}
	public Inventory getLibraryInventory() {
		return libraryInventory;
	}
		public void setLibraryInventory(Inventory libraryInventory) {
		this.libraryInventory = libraryInventory;
	}
		public Loan[] getLibraryLoans() {
		return libraryLoans;
	}
		public void setLibraryLoans(Loan[] libraryLoans) {
		this.libraryLoans = libraryLoans;
	}
	//
		
	//Library objects method.
	public boolean signIn(String userName, String password) // Checks credentials for signing in.
	{
		if(checkStudent(userName,password)==true)
		{
			JOptionPane.showMessageDialog(null, "You logged in succesfully as a Student.");
		}
		else if (checkLibriran(userName,password)==true)
		{
			JOptionPane.showMessageDialog(null, "You logged in succesfully as a Libririan.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Your credentials are incorrect");
		}
		return false;
	}
	public static void generateStudents()//Generates the list of students and inputs them into the array.

	{
			studentList[0]=new Student(1,"Alex","Wazana","1","alex@gmail.com",libraryInventory);
			studentList[1]=new Student(2,"Snir","Zarchi","2","snir@gmail.com",libraryInventory);
			studentList[2]=new Student(3,"Omer","Rabi","3","omer@gmail.com",libraryInventory);
	}
	public static void generateLibrirans()//Generates the list of libririans and inputs them into the array.
	{
		libriranList[0]=new Librarian(4,"Eugene","Kanziper","4");
		libriranList[1]=new Librarian(5,"Anat","Gordon","5");
		libriranList[2]=new Librarian(6,"Michael","Mashu","6");
		
	}
	public boolean addNewBook(int bookID, String bookName, String bookAuthor, String bookGenre, int bookAmout) //Adds a new book into the book array.
	{
		if(libraryInventory.getAmountOfBooks() < 100)//Checks if the amount of books hasn't gone past the array size.
		{
			Book b = new Book(bookID, bookName, bookGenre, bookAuthor, bookAmout, bookAmout);
			libraryInventory.addBook(b);
			JOptionPane.showMessageDialog(null, "You added a new book succesfully.");
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The library has reached it's limit.");
			return false;
		}
	}
	@Override
	public int hashCode() // Used for JUnit testing.
	{ 
		final int prime = 31;
		int result = 1;
		result = prime * result + ((libraryInventory == null) ? 0 : libraryInventory.hashCode());
		result = prime * result + Arrays.hashCode(libraryLoans);
		result = prime * result + ((libraryMap == null) ? 0 : libraryMap.hashCode());
		result = prime * result + loanAmount;
		result = prime * result + Arrays.deepHashCode(row);
		return result;
	}
	@Override
	public boolean equals(Object obj) // Used for JUnit testing.
	{
		if(studentList==obj)
			return true;
		if(libraryInventory==obj)
			return true;
		if(studentList[0]==obj)
			return true;
		if(libriranList==obj)
			return true;
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (libraryInventory == null) {
			if (other.libraryInventory != null)
				return false;
		} else if (!libraryInventory.equals(other.libraryInventory))
			return false;
		if (!Arrays.equals(libraryLoans, other.libraryLoans))
			return false;
		if (libraryMap == null) {
			if (other.libraryMap != null)
				return false;
		} else if (!libraryMap.equals(other.libraryMap))
			return false;
		if (loanAmount != other.loanAmount)
			return false;
		if (!Arrays.deepEquals(row, other.row))
			return false;
		return true;
	}
	public Object[][] createUsersArray() // Creates an object matrix for grid view to show in the VIEW of all users.
	{
		Object[][] tempData= new Object[100][4];
		int i;
		for(i=0;i<studentList.length;i++)
		{
			tempData[i][0]=studentList[i].getStudentID();
			tempData[i][1]=studentList[i].getStudentFirstName();
			tempData[i][2]=studentList[i].getStudentLastName();
			tempData[i][3]=studentList[i].getStudentEmail();
		}
		return tempData;
		
	}
	public Object[][] createLoanArray()// Creates an object matrix for grid view to show in the VIEW of all loans.
	{
		Object[][] tempData= new Object[100][4];
		int i;
		for(i=0;i<loanAmount;i++)
		{
			tempData[i][0]=libraryLoans[i].getBookID();
			tempData[i][1]=libraryLoans[i].getStudentID();
			tempData[i][2]=libraryLoans[i].getLoanDate();
			tempData[i][3]=libraryLoans[i].isActiveLoan();	
		}
		return tempData;
	}
	public Object[][] createReturnBookArray(int studentID)// Creates an object matrix for grid view to show in the VIEW of all loaned books of a user.
	{
		Object[][] tempData= new Object[100][4];
		int i;
		int j=0;
		int k=0;
		int temp;
		for(i=0;i<loanAmount;i++)
		{
			if(libraryLoans[i].isActiveLoan())
			{
				if(libraryLoans[i].getStudentID()==studentID)
				{
					for(j=0;j<libraryInventory.getAmountOfBooks();j++)
					{
						temp=libraryInventory.getBooks()[j].getBookID();
						if(temp==libraryLoans[i].getBookID())
						{
							tempData[k][0]=libraryInventory.getBooks()[j].getBookID();
							tempData[k][1]=libraryInventory.getBooks()[j].getBookName();
							tempData[k][2]=libraryInventory.getBooks()[j].getBookGenre();
							tempData[k][3]=libraryInventory.getBooks()[j].getBookAuthor();
							k++;
						}
					}
				}
			}
		}
		return tempData;
	}
	public Object[][] createBookArray()// Creates an object matrix for grid view to show in the VIEW of all books.
	{
		row= new Object[100][4];
		int i;
		int j=0;
		for(i=0;i<libraryInventory.getAmountOfBooks();i++)
		{
			if(libraryInventory.getBooks()[i].getBookAmount()!=0)
			{
				row[j][0]=libraryInventory.getBooks()[i].getBookID();
				row[j][1]=libraryInventory.getBooks()[i].getBookName();
				row[j][2]=libraryInventory.getBooks()[i].getBookGenre();
				row[j][3]=libraryInventory.getBooks()[i].getBookAuthor();	
				j++;
			}

		}
		return row;
	}
	public Object[][] createHistoryLoansArray(int studentID)// Creates an object matrix for grid view to show in the VIEW of all history loans of a user.
	{	
		Object[][] tempData= new Object[100][5];
		int i;
		int j=0;
		int k=0;
		int temp;
		for(i=0;i<loanAmount;i++)
		{
			if(libraryLoans[i].isActiveLoan()==false)
			{
				if(libraryLoans[i].getStudentID()==studentID)
				{
					for(j=0;j<libraryInventory.getAmountOfBooks();j++)
					{
						temp=libraryInventory.getBooks()[j].getBookID();
						if(temp==libraryLoans[i].getBookID())
						{
							tempData[k][0]=libraryInventory.getBooks()[j].getBookID();
							tempData[k][1]=libraryInventory.getBooks()[j].getBookName();
							tempData[k][2]=libraryInventory.getBooks()[j].getBookGenre();
							tempData[k][3]=libraryInventory.getBooks()[j].getBookAuthor();
							tempData[k][4]=libraryLoans[i].getLoanDate();
							k++;
						}
					}
				}
			}
		}
		return tempData;
	}
	public Object[][] updateLoanTable(String text,int column,Object[][] row)// Creates an object matrix for grid view to show in the VIEW for an updated search of the loan table.
	{
		Object[][] tempData = new Object[100][4];
		int i;
		int j=0;
		String temp;
		for(i=0;i<loanAmount;i++)
		{
			temp=row[i][column].toString();
			if(text.equals(temp))
			{
				tempData[j]=row[i];
				j++;
			}
		}
		return tempData;
	}
	public Object[][] updateUserSearchTable(String text,int column,Object[][] row)// Creates an object matrix for grid view to show in the VIEW for an updated search of the user table.
	{
		int i;
		int j=0;
		Object[][] tempData = new Object[100][4];
		String temp;
		for(i=0;i<studentList.length;i++)
		{
			temp=row[i][column].toString();
			if(text.equals(temp))
			{
				tempData[j]=row[i];
				j++;
			}
		}
		return tempData;
	}
	public Object[][] updateSearchTable(String text,int column,Object[][] row)// Creates an object matrix for grid view to show in the VIEW for an updated search of the book table.
	{
		int i;
		int j=0;
		Object[][] tempData = new Object[100][4];
		String temp;
		for(i=0;i<libraryInventory.getAmountOfBooks();i++)
		{
			temp=row[i][column].toString();
			if(text.equals(temp))
			{
				tempData[j]=row[i];
				j++;
			}
		}
		return tempData;
	}
	public Loan getLoan(int studentID,int bookID,String loanDate)//Gets Loan object depending on the inputed student it and bookid.
	{
		int i,j;
		for(i=0;i<loanAmount;i++)
		{
			if(libraryLoans[i].getBookID()==bookID && libraryLoans[i].getStudentID()==studentID && loanDate.equals(libraryLoans[i].getLoanDate().toString()))
			{
				return libraryLoans[i];
			}
			
		}
		return null;
	}
	public boolean returnALoan(int studentID, int bookID)// Returns the loan and updates the required attributes.
	{
		int i;
		for(i=0;i<loanAmount;i++)
		{
			if(libraryLoans[i].getBookID()==bookID && libraryLoans[i].getStudentID()==studentID)
			{
				if(libraryLoans[i].isActiveLoan()==true)
				{
					libraryLoans[i].setActiveLoan(false);
					libraryInventory.getBooks()[bookID-1].setBookAmountAvailable(libraryInventory.getBooks()[bookID-1].getBookAmountAvailable()+1);
					JOptionPane.showMessageDialog(null, "The Book is succesfully returned to library.");
					return true;
				}
			}
		}
		return false;
	}
	public void updateStudentCredentials(int studentID,String firstName,String lastName,String email,String password)//updates the inputted credentials of a student.
	{
		studentList[studentID-1].setStudentFirstName(firstName);
		studentList[studentID-1].setStudentEmail(email);
		studentList[studentID-1].setStudentLastName(lastName);
		studentList[studentID-1].setStudentPassword(password);
		JOptionPane.showMessageDialog(null, "Student's information succesfully changed.");
	}
	public boolean checkStudent(String userName,String password)//Checks if an inputted credentials belongs to a student.
	{
		int i;
		for(i=0;i<3;i++)
		{
			if(userName.equals(studentList[i].getUsername()) && password.equals(studentList[i].getPassword()))
				{
					return true;
				}
		}
		return false;
	}
	public Student getStudentCreds(String userName,String password)//Gets the student OBJECT and its credentials by username and password.
	{
		int i;
		for(i=0;i<3;i++)
		{
			if(userName.equals(studentList[i].getUsername()) && password.equals(studentList[i].getPassword()))
				{
					return studentList[i];
				}
		}
		return null;
	}
	public boolean checkLibriran(String userName,String password)//Checks if theres an existing librarian with inputted credentials.
	{
		int i;
		for(i=0;i<3;i++)
		{
			if(userName.equals(libriranList[i].getUsername()) && password.equals(libriranList[i].getPassword()))
				{
					return true;
				}
		}
		return false;
	}
	public Librarian getLibrarianCreds(String userName,String password)//Gets the Librarian object of inputted username and password.
	{
		int i;
		for(i=0;i<3;i++)
		{
			if(userName.equals(libriranList[i].getUsername()) && password.equals(libriranList[i].getPassword()))
				{
					return libriranList[i];
				}
		}
		return null;
	}
	public void makeLoan(int bookID,int studentID)//Makes a loan of inputted book and belongs it to the appropriate student by ID.
	{
		int i;
		for(i=0;i<libraryInventory.getAmountOfBooks();i++)
		{
			if(libraryInventory.getBooks()[i].getBookID()==bookID)
			{
				if(libraryInventory.getBooks()[i].getBookAmountAvailable()>0)
				{
					String date=LocalDate.now().toString();
					LocalDate localDate;
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					localDate = LocalDate.parse(date, formatter);
					libraryInventory.getBooks()[i].setBookAmountAvailable(libraryInventory.getBooks()[i].getBookAmountAvailable() - 1);
					libraryLoans[loanAmount]= new Loan(bookID,studentID,localDate);
					loanAmount++;
					JOptionPane.showMessageDialog(null, "The Book is succesfully loaned.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The Book is out of stock.");
				}
			}
		}
	}
	public void checkReservedSeat(int i)//Checks wiether a clicked seat is reserved, and if so, points out who reserved it.
	{
		if(libraryMap.checkReservedSeat(i)==false)
		{
			String text = "Chair is reserved by "+studentList[libraryMap.getLibrarySeats()[i].getStudentID()-1].getStudentFirstName()+" "+studentList[libraryMap.getLibrarySeats()[i].getStudentID()-1].getStudentLastName();
			JOptionPane.showMessageDialog(null,text);
		}
	}
	public boolean cancelkReservedSeat(int i)//Cancel's reserved seat.
	{
		if(libraryMap.checkReservedSeat(i)==false)
		{
			 if (JOptionPane.showConfirmDialog(null, "Would you like to cancel reservation?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
			 {
				 libraryMap.cancelReservedSeat(i);
				 return true;
			 } 
		}
		return false;
	}
	
	private void createInventory()//Creates the inventory of the library.
	{
		libraryInventory = new Inventory();
	}

}
