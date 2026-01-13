package com.taxibookingsystem;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
	private List<Taxi> taxis;
	BookingSystem(int taxiCount)
	{
		taxis=new ArrayList<>();
		for(int i=1;i<=taxiCount;i++)
		{
			taxis.add(new Taxi(i));
		}
	}
	private int calculateCharges(char pickup,char drop)
	{
		int distance=Math.abs(drop-pickup)*15;
		int charges=100;
		distance-=5;
		charges+=distance*10;
		return charges;
	}
	Taxi findTaxi(char pickup,int pickupTime)
	{
		List<Taxi> freeTaxis=new ArrayList<>();
		for(Taxi t:taxis)
		{
			if(t.isFree(pickup, pickupTime))
			{
				freeTaxis.add(t);
			}
		}
		
	
	int minDistance=Integer.MAX_VALUE;
	for(Taxi t:taxis)
	{
		
		int distance=Math.abs(pickup-t.getCurrentSpot());
		if(distance<minDistance)
		{
			minDistance=distance;
		}
	}
}
}
