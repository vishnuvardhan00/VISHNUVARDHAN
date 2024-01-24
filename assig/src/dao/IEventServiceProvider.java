package dao;

import entity.Booking;
import entity.Customer;
import entity.Event;
import entity.Venue;
import exception.CustomException;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IEventServiceProvider {

    
    Event getEventById(int event_id) throws SQLException;

    int getAvailableNoOfTickets();

    void calculateBookingCost(int numTickets);

    void bookTickets(String eventName, int numTickets, List<Customer> listOfCustomers) throws CustomException;

    boolean cancelBooking(int bookingId) throws CustomException, SQLException;

    Booking getBookingDetails(int bookingId) throws CustomException;




	Event createEvent(String eventName, String eventDate, String eventTime, int totalSeats, int availbleSeats,
			double ticketPrice, String eventType, Venue venue) throws SQLException;
}
