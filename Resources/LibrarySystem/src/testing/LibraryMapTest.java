package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Library;

public class LibraryMapTest {
	private Library libraryTest;
	@Test
	public void testIsAllowedToReserve() {//Checks if allowed to reserve seat only to allowed seats.
		libraryTest=Library.getInstance();
		assertTrue(libraryTest.getLibraryMap().isAllowedToReserve(1));
	}
	@Test
	public void testReserveSeat()//Tests reservation if it updates the seat and is allowed to reserve a resereved seat.
	{
		libraryTest=Library.getInstance();
		libraryTest.getLibraryMap().reserveSeat(1, 1);
		assertFalse(libraryTest.getLibraryMap().isAllowedToReserve(1));
	}
	@Test
	public void testCancelReservedSeat()//Tests if a cancelled reservation is updating seat status.
	{
	    libraryTest=Library.getInstance();
	    libraryTest.getLibraryMap().cancelReservedSeat(1);
	    assertTrue(libraryTest.getLibraryMap().isAllowedToReserve(1));
	}
	@Test
	public void testCheckReservedSeat()//Tests if reserved seat is notified when it is.
	{
		libraryTest=Library.getInstance();
		assertTrue(libraryTest.getLibraryMap().checkReservedSeat(1));
	}

}
