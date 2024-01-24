package dao;

import entity.Event;
import entity.EventType;
import entity.Venue;
import entity.Customer;
import entity.Booking;
import exception.CustomException;
import util.DBConnUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EventServiceProviderImpl implements IEventServiceProvider {
	private static final int customer_id = 0;
	private Connection connection;

    public EventServiceProviderImpl() {
        this.connection = DBConnUtil.getDBConn();
    }
    private List<Event> events = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    



    @Override
    public int getAvailableNoOfTickets() {
        // In a real-world scenario, you would interact with the database to calculate available tickets.
        int totalAvailableSeats = 0;
        for (Event event : events) {
            totalAvailableSeats += event.getAvailableSeats();
        }
        return totalAvailableSeats;
    }

    @Override
    public void calculateBookingCost(int numTickets) {
        // In a real-world scenario, you might have logic to calculate the total cost based on the number of tickets.
    }

   /* @Override
   public void bookTickets(String eventName, int numTickets, List<Customer> listOfCustomers) throws CustomException {
    	String query = "INSERT INTO booking (customer_id,event_id,num_tickets,total_cost,booking_date) VALUES(?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			//preparedStatement.setInt(1, booking.getBookingId());
			preparedStatement.setInt(1, customer_id);
			preparedStatement.setInt(2,event_id);
			preparedStatement.setInt(3,num_Tickets );
			preparedStatement.setDouble(4, booking.getTotal_cost());
			preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));

			preparedStatement.executeUpdate();
   }*/
    
    @Override
    public void bookTickets(String eventName, int numTickets, List<Customer> listOfCustomers) throws CustomException {
        String query = "INSERT INTO booking (customer_id, event_id, num_tickets, total_cost, booking_date) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Customer customer : listOfCustomers) {
                // Assuming you have customer_id, event_id, num_Tickets, and booking variables available
          //      preparedStatement.setInt(1, customer.getCustomerId()); // Replace with actual customer_id
              //  preparedStatement.setInt(2, event_id); // Replace with actual event_id
                //preparedStatement.setInt(3, num_Tickets); // Replace with actual num_Tickets
               // preparedStatement.setDouble(4, booking.getTotal_cost()); // Replace with actual booking total_cost
              //  preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));

                preparedStatement.executeUpdate();

                // Update event and customer data
                Event eventToBook = getEventByName(eventName);
                eventToBook.setAvailableSeats(eventToBook.getAvailableSeats() - numTickets);
            }
        } catch (SQLException e) {
            throw new CustomException("Error booking tickets: " + e.getMessage());
        }
    }

    private Event getEventByName(String eventName) {
        for (Event event : events) {
            if (event.getEventName().equals(eventName)) {
                return event;
            }
        }
        return null;
    }


    
    @Override
	public
    boolean cancelBooking(int bookingId) throws SQLException {
    	String query = "DELETE FROM booking WHERE booking_id = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, bookingId);

			int rowsAffected = preparedStatement.executeUpdate();


			return rowsAffected > 0;

		} catch (SQLException e) {
			throw new RuntimeException(e);


		
        }
    

//        if (bookingToRemove == null) {
//            throw new CustomException("Booking not found.");
//        }
//
//        // Update event and customer data
//        Event eventOfBooking = getEventById(bookingToRemove.getEventId());
//        eventOfBooking.setAvailableSeats(eventOfBooking.getAvailableSeats() + bookingToRemove.getNumTickets());
//
//        bookings.remove(bookingToRemove);
    }

    @Override
    public Booking getBookingDetails(int bookingId) throws CustomException {
        // In a real-world scenario, you would interact with the database to retrieve booking details.
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }

        throw new CustomException("Booking not found.");
    }

    public Event getEventById(int eventId) throws SQLException {
    	Event event = null;
    	List<Event> event1 = new ArrayList<>();
    	String sql = "select * from event where event_id = ?";
    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setInt(1, eventId);
    	ResultSet resultSet = preparedStatement.executeQuery();
    	while(resultSet.next()) {
    		 event = new Event( eventId, resultSet.getString("event_name"),
                    resultSet.getString("event_date"),
                    resultSet.getString("event_time"),
                    resultSet.getInt("venue_id"),
                    resultSet.getInt("total_seats"),
                    resultSet.getInt("available_seats"),
                    resultSet.getDouble("ticket_price"),
                    resultSet.getString("event_type"));
       //     event.setEvent_id(resultSet.getInt("event_id"));
            event1.add(event);
    		return event;
    	}
//        for (Event event : events) {
//            if (event.getEventId() == eventId) {
//                return event;
//            }
//        }
        return event;
    }

	@Override
	public Event createEvent(String eventName, String eventDate, String eventTime, int totalSeats,
			int availbleSeats, double ticketPrice, String eventType, Venue venue) throws SQLException {

    	String query = "INSERT INTO event (event_id,event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement=connection.prepareStatement(query);

//			preparedStatement.setString(1,event.getEvent_name());
//			preparedStatement.setDate(2,event.getEvent_date());
//			preparedStatement.setTime(3, event.getEvent_time());
//			//
//
//			preparedStatement.setInt(4, event.getTotal_seats());
//			preparedStatement.setDouble(5, event.getTicket_price());
//			preparedStatement.setString(6, String.valueOf(event.getEvent_type()));
//			preparedStatement.setString(7, event.getVenue_name());

            if (eventName != null) {
                preparedStatement.setString(1,eventName);

            } else {

//				throw new IllegalArgumentException("Event name cannot be null");
            }
            //preparedStatement.setInt(1, event.getEvent_id());
            preparedStatement.setString(2, eventDate);
            preparedStatement.setString(3, eventTime);
            //
            preparedStatement.setInt(4, totalSeats);
            preparedStatement.setInt(5, availbleSeats);
            preparedStatement.setDouble(6, ticketPrice);
            preparedStatement.setString(7,eventType);
            preparedStatement.setString(8, String.valueOf(venue));
//			preparedStatement.setString(9, event.getVenue_name());
//			preparedStatement.setInt(9,event.getBookingId());



            preparedStatement.executeUpdate();
        // In a real-world scenario, you would interact with the database to store the event.
        Event newEvent = new Event(events.size() + 1, eventName, eventDate, eventTime,
                venue.getVenueId(), totalSeats, availbleSeats, ticketPrice, eventType);
        events.add(newEvent);
        return newEvent;
		
	}


}
