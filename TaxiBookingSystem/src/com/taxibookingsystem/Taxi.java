package com.taxibookingsystem;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
	private int taxiId;
	private char currentSpot;
	private int freeTime;
	private int earnings;
	private List<Booking> bookings;
	Taxi(int taxiId)
	{
		this.taxiId=taxiId;
		this.currentSpot='A';
		this.freeTime=0;
		this.earnings=0;
		bookings=new ArrayList<>();
	}
	public boolean isFree(char pickup,int pickupTime)
	{
		int travelTime=Math.abs(currentSpot-pickup);
		if(freeTime+travelTime<=pickupTime)
		{
			return true;
		}
		return false;
	}
	public void assignBookings(Booking b)
	{
		bookings.add(b);
	}
	public int getTaxiId() {
		return taxiId;
	}
	public char getCurrentSpot() {
		return currentSpot;
	}
	public int getFreeTime() {
		return freeTime;
	}
	public int getEarnings() {
		return earnings;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
}
