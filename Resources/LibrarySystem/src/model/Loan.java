package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;


public class Loan{
	//Attributes
	private int bookID;
	private int studentID;
	private LocalDate loanDate;
	private boolean activeLoan;
	//
	
	//Constructor
	public Loan(int bookID, int studentID, LocalDate recievedDate) {
		this.bookID = bookID;
		this.studentID = studentID;
		this.loanDate=recievedDate;
		this.activeLoan=true;
	}
	//
	
	//Getters and Setters
	public int getBookID() {
		return bookID;
	}
	
	public boolean isActiveLoan() {
		return activeLoan;
	}
	public void setActiveLoan(boolean activeLoan) {
		this.activeLoan = activeLoan;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public LocalDate getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(LocalDate localDate) {
		this.loanDate = localDate;
	}
	//
}
