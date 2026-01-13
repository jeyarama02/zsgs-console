package com.taxibookingsystem;

public class Booking {
	private int bookingId;
	private int dropTime;
	private int amount;
	private Customer customer;
	public Booking(int bookingId, int dropTime, int amount, Customer customer) {
		this.bookingId = bookingId;
		this.dropTime = dropTime;
		this.amount = amount;
		this.customer = customer;
	}
	public int getBookingId() {
		return bookingId;
	}		
	public int getDropTime() {
		return dropTime;
	}
	public int getAmount() {
		return amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	
}
