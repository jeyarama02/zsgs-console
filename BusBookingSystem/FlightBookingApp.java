package com.flightbookingsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class FlightBookingApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Admin admin=new Admin("RAM");
		ArrayList<Passenger> passengers=new ArrayList<>();
		ArrayList<Flight> flights=new ArrayList<>();
		ArrayList<Booking>bookings=new ArrayList<>();
		flights.add(new Flight("AI101","chennai","delhi",3500));
		flights.add(new Flight("EK505","Mumbai","Dubai",8500));
		flights.add(new Flight("ING202","Pune","Kolkatha",4500));
		int passengerIdCounter=1;
		while(true)
		{
			admin.showMenu();
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter contact");
				String contact=sc.nextLine();
				System.out.println("Enter Your Name:");
				String pname=sc.nextLine();
				passengers.add(new Passenger(passengerIdCounter++,pname,contact));
				System.out.println("Passenger Registered");
				break;
			case 2:
				System.out.println("Available Flights");
				for(Flight f:flights)
				{
					System.out.println(f.getFlightNo()+":"+f.getSource()+"-->"+f.getDestination()+"RS:"+f.getPrice());
				}
				break;
			case 3://BOOK FLIGHTS
				if(passengers.isEmpty())
				{
					System.out.println("Register a Passenger first:");
					break;
				}
				System.out.println("Passengers List");
				for(Passenger p:passengers)
				{
					System.out.println(p.getId()+":"+p.getName());
				}
				System.out.println("Enter the Passenger Id:");
				int pid=sc.nextInt();
				sc.nextLine();
				Passenger selectedPassenger=null;
				for(Passenger p:passengers)
				{
					if(p.getId()==pid)
					{
						selectedPassenger=p;
						break;
					}
				}
				if(selectedPassenger==null)
				{
					System.out.println("Invalid id");
					break;
				}
				System.out.println("Flights");
				for(int i=0;i<flights.size();i++)
				{
					System.out.println((i+1)+"."+flights.get(i).getFlightNo());
				}
				System.out.println("Enter Flight Number");
				int fid=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Travel Date(dd-mm-yyyy) :");
				String date=sc.nextLine();
				bookings.add(new Booking(selectedPassenger,flights.get(fid-1),date));
				System.out.println("Flight booked");
				break;
			case 4:
				if(bookings.isEmpty())
				{
					System.out.println("No booking yet");
					break;
				}
				for(Booking b:bookings)
				{
					b.display();
				}
				break;
			case 5:
				System.out.println("Enter Source:");
				String src=sc.nextLine().toLowerCase();
				System.out.println("Enter Destination:");
				String dest=sc.nextLine().toLowerCase();
				boolean found=false;
				for(Flight f:flights)
				{
					if(f.getSource().toLowerCase().equals(src) && f.getDestination().toLowerCase().equals(dest))
					{
						System.out.print(f.getFlightNo()+":"+f.getSource()+"-->"+f.getDestination()+"-"+f.getPrice());
						found=true;
					}
				}
				if(!found)
				{
					System.out.println("no flights in this "); 
				}
				break;
			case 6:
				System.out.println("Exited successfully");
				sc.close();
				System.exit(0);
				break;
				default:
					System.out.println("Invalid choice");
				
			}
		}
	}

}
