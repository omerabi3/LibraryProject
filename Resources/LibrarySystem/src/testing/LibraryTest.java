package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Librarian;
import model.Library;
import model.Loan;
import model.Student;
import model.Library;
public class LibraryTest {
	private Library libraryTest;

	@Test
	public void testSignIn() //Checks if an approved credentials works for a sign in.
	{
		libraryTest=Library.getInstance();
		assertFalse(libraryTest.signIn("1", "1"));
	}
	@Test
	public void testAddNewBook()//Tests if a new book inserttion is working properly.
	{
		libraryTest=Library.getInstance();
		assertTrue(libraryTest.addNewBook(11, "bookName", "bookAuthor", "bookGenre", 10));
	}
	@Test
	public void testGenerateStudent()//Tests the students array is being generated properly.
	{
		libraryTest=Library.getInstance();
		Student[] studentList=new Student[3];
		studentList=libraryTest.getStudentList();
		assertTrue(libraryTest.equals(studentList));
	}
	@Test
	public void testGenerateLibrirans()//Tests the Librirans array is being generated properly.
	{
		libraryTest=Library.getInstance();
		Librarian[] libriranList=new Librarian[3];
		libriranList=libraryTest.getLibriranList();
		assertTrue(libraryTest.equals(libriranList));
	}
	@Test
	public void testGetLoan()//Tests if making a loan updates the appropriate values and assigns the loan to the user.
	{
		libraryTest=Library.getInstance();
		Loan testLoan=libraryTest.getLoan(1, 1, "");
		assertNull(testLoan);
	}
	@Test
	public void testReturnALoan()//Tests if returning the loan updates the values needed.
	{
		libraryTest=Library.getInstance();
		assertEquals(libraryTest.getLoanAmount(),1);
		libraryTest.makeLoan(1, 1);
		assertTrue(libraryTest.returnALoan(1, 1));
	}
	@Test
	public void testUpdateStudentCredentials()//Tests if the students credentials are updated after method is called.
	{
		libraryTest=Library.getInstance();
		int studentID=1;
		String firstName="testName";
		String lastName="testLastName";
		String email="testEmail";
		String password="testPassword";
		libraryTest.updateStudentCredentials(studentID, firstName, lastName, email, password);
		assertEquals(firstName,libraryTest.getStudentList()[studentID-1].getStudentFirstName());
		assertEquals(lastName,libraryTest.getStudentList()[studentID-1].getStudentLastName());
		assertEquals(email,libraryTest.getStudentList()[studentID-1].getStudentEmail());
		assertEquals(password,libraryTest.getStudentList()[studentID-1].getStudentPassword());
	}
	@Test
	public void testCheckStudent()//Test if method recognizes a known user.
	{
		libraryTest=Library.getInstance();
		assertTrue(libraryTest.checkStudent("1", "1"));
	}
	@Test
	public void testCheckLibririan()//Test if method recognizes a known user.
	{
		libraryTest=Library.getInstance();
		assertTrue(libraryTest.checkLibriran("4", "4"));
	}
	@Test
	public void testMakeLoan()//Tests making of a loan.
	{
		libraryTest=Library.getInstance();
		libraryTest.makeLoan(1, 1);
		assertEquals(libraryTest.getLoanAmount(),1);
	}
	@Test
	public void testCreateInventory()//Tests the inventory generator method.
	{
		libraryTest=Library.getInstance();
		assertTrue(libraryTest.equals(libraryTest.getLibraryInventory()));
	}


}
