package model;

import java.time.LocalTime;
import java.util.Observable;

public class LibrarySeat{
	//Attributes.
	private int StudentID;
	private boolean Available;
	private int chairID;
	private LocalTime TimeSaved;
	//
	
	//Constructor
	public LibrarySeat(int chairID)
	{
		Available=true;
		this.chairID=chairID;
	}
	//
	
	//Getters and Setters
	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public boolean isAvailable() {
		return Available;
	}

	public void setAvailable(boolean available) {
		Available = available;
	}

	public int getChairID() {
		return chairID;
	}

	public void setChairID(int chairID) {
		this.chairID = chairID;
	}

	public LocalTime getTimeSaved() {
		return TimeSaved;
	}

	public void setTimeSaved(LocalTime localTime) {
		TimeSaved = localTime;
	}
	//
}

	
		
	

