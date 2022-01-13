package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Book;
import model.Inventory;

public class InventoryTest {
//	private Inventory inventoryTest = new Inventory();

	@Test
	public void testEditBookByID() { //Tests if the edit is succesfull.
		Inventory inventoryTest = new Inventory();
		int bookID=1;
		String bookName="TestName";
		String bookGenre="TestGenre";
		String bookAuthor="TestAuthor";
		int bookAmountAvailable=10;
		int bookAmount=10;
		inventoryTest.editBookByID(bookID, bookName, bookGenre, bookAuthor, bookAmountAvailable, bookAmount);
		assertEquals("Checking if book name was updated.",bookName,inventoryTest.getBookByID(1).getBookName());
		assertEquals("Checking if book genere was updated.",bookGenre,inventoryTest.getBookByID(1).getBookGenre());
		assertEquals("Checking if book author was updated.",bookAuthor,inventoryTest.getBookByID(1).getBookAuthor());
		assertEquals("Checking if book amount available was updated.",bookAmountAvailable,inventoryTest.getBookByID(1).getBookAmountAvailable());
		assertEquals("Checking if book amount was updated.",bookAmount,inventoryTest.getBookByID(1).getBookAmount());
	}
	
	@Test
	public void testSetNotInStock() {//Tests wither a book not in stock is indeed has values of amount set to zero.
		Inventory inventoryTest = new Inventory();
		inventoryTest.setToNotInStock(1);
		assertEquals("Checking if amount set to 0",0,inventoryTest.getBookByID(1).getBookAmount());
		assertEquals("Checking if available amount set ot 0",0,inventoryTest.getBookByID(1).getBookAmountAvailable());
	}
	@Test
	public void testGetBookByID() // Tests if the books requested is given.
	{
		Inventory inventoryTest = new Inventory();
		Book newBook =new Book(1,"Peter pen","Fantasy","David Schummer",10,10);
		assertEquals("Checking if book name is equal.",newBook.getBookName(),inventoryTest.getBookByID(1).getBookName());
		assertEquals("Checking if book genere is equal.",newBook.getBookGenre(),inventoryTest.getBookByID(1).getBookGenre());
		assertEquals("Checking if book author is equal.",newBook.getBookAuthor(),inventoryTest.getBookByID(1).getBookAuthor());
		assertEquals("Checking if book amount available is equal.",newBook.getBookAmountAvailable(),inventoryTest.getBookByID(1).getBookAmountAvailable());
		assertEquals("Checking if book amount is equal.",newBook.getBookAmount(),inventoryTest.getBookByID(1).getBookAmount());
	}
	@Test
	public void testAddBook()//Tests an addition of book to the book array.
	{
		Inventory inventoryTest = new Inventory();
		Book newBook= new Book(11,"TestName","TestGenre","TestAuthor",10,10);
		inventoryTest.addBook(newBook);
		assertEquals("Checking if book name is equal.",newBook.getBookName(),inventoryTest.getBookByID(11).getBookName());
		assertEquals("Checking if book genere is equal.",newBook.getBookGenre(),inventoryTest.getBookByID(11).getBookGenre());
		assertEquals("Checking if book author is equal.",newBook.getBookAuthor(),inventoryTest.getBookByID(11).getBookAuthor());
		assertEquals("Checking if book amount available is equal.",newBook.getBookAmountAvailable(),inventoryTest.getBookByID(11).getBookAmountAvailable());
		assertEquals("Checking if book amount is equal.",newBook.getBookAmount(),inventoryTest.getBookByID(11).getBookAmount());
	}

}
