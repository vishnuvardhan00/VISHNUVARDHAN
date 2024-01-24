package main;

import dao.EventServiceProviderImpl;
import dao.IEventServiceProvider;
import entity.Customer;
import entity.Event;
import entity.Venue;
import exception.CustomException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainModule {

    private static final Scanner scanner = new Scanner(System.in);
    private static final IEventServiceProvider eventServiceProvider = new EventServiceProviderImpl();
        public static void main(String[] args) throws CustomException {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n------ Ticket Booking System Menu ------");
            System.out.println("1. Create Event");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Get Event Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    bookTickets();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    getEventDetails();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("Exiting Ticket Booking System. Goodbye!");
        scanner.close();
    }

    private static void createEvent() throws CustomException {
        System.out.println("\n------ Create Event ------");
		System.out.print("Enter Event Name: ");
		String eventName = scanner.nextLine();

		System.out.print("Enter Event Date (yyyy-MM-dd): ");
		
		String eventDate = scanner.nextLine();

		System.out.print("Enter Event Time: ");
		String eventTime = scanner.nextLine();
		System.out.println("Enter venueid: ");
		int venueid = scanner.nextInt();

		System.out.print("Enter Total Seats: ");
		int totalSeats = scanner.nextInt();
		System.out.print("Enter available Seats: ");
		int availbleSeats = scanner.nextInt();
		System.out.print("Enter Ticket Price: ");
		double ticketPrice = scanner.nextDouble();
		scanner.nextLine(); // Consume newline character

		System.out.print("Enter Event Type (Movie/Sports/Concert): ");
		String eventType = scanner.nextLine();

		System.out.print("Enter Venue Name: ");
		String venueName = scanner.nextLine();
		
		
		

		// Assuming Venu class has constructor with parameters (String venueName, String address)
		Venue venue = new Venue();

		Event createdEvent=null;
		try {
			createdEvent = eventServiceProvider.createEvent(eventName, eventDate, eventTime,
			        totalSeats, availbleSeats, ticketPrice, eventType, venue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Event created successfully! Event ID: " + createdEvent.getEventId());
    }

    private static void bookTickets() {
        try {
            System.out.println("\n------ Book Tickets ------");
            System.out.print("Enter Event Name: ");
            String eventName = scanner.nextLine();

            System.out.print("Enter Number of Tickets to Book: ");
            int numTickets = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Assuming Customer class has constructor with parameters (String customerName, String email, String phoneNumber)
            System.out.println("Enter Customer Details:");
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();

            Customer customer = new Customer(0, customerName, email, phoneNumber, 0);
            List<Customer> listOfCustomers = List.of(customer);

            eventServiceProvider.bookTickets(eventName, numTickets, listOfCustomers);

            System.out.println("Tickets booked successfully!");
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static  void cancelBooking() {
        try {
            System.out.println("\n------ Cancel Booking ------");
            System.out.print("Enter Booking ID to Cancel: ");
            int bookingId = scanner.nextInt();
         

          //  bookingSystemRepository.cancelBooking(bookingId);
            try {
				eventServiceProvider.cancelBooking(bookingId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Booking canceled successfully!");
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getEventDetails() {
    	Event event = new Event();
        System.out.println("\n------ Event Details ------");
        System.out.print("Enter Event Id: ");
        int eventid = scanner.nextInt();
        
       // List<Event> eventDetails = eventServiceProvider.getEventDetails();
        try {
			 event = eventServiceProvider.getEventById(eventid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        System.out.println("Eventname "+event.getEventName());
        System.out.println(event.getAvailableSeats());
        System.out.println(event.getBookingId());
        System.out.println(event.getEventId());
        System.out.println(event.getEventName());
        System.out.println(event.getTicketPrice());
        System.out.println(event.getEventTime());
        System.out.println(event.getEventType());
        System.out.println(event.getTotalSeats());
        System.out.println(event.getVenueId());
        System.out.println(event.getEventDate());
//        if (event == null) {
//            System.out.println("No events found.");
//        } else {
//            for (Event event1 : event) {
//                System.out.println(event);
//            }
    //    }
    }
}