package dao;

import entity.Venue;
import entity.Event;
import entity.Booking;
import entity.Customer;
import exception.CustomException;

import java.util.Date;
import java.util.List;

public interface IBookingSystemRepository {

    Event createEvent(String eventName, Date eventDate, String eventTime,
                      int totalSeats, double ticketPrice, String eventType, Venue venue) throws CustomException;

    List<Event> getEventDetails();

    int getAvailableNoOfTickets();

    void calculateBookingCost(int numTickets);

    void bookTickets(String eventName, int numTickets, List<Customer> listOfCustomers) throws CustomException;

    void cancelBooking(int bookingId) throws CustomException;

    Booking getBookingDetails(int bookingId) throws CustomException;
}
