package entity;

import java.sql.Time;
import java.util.Date;

public class Event {
    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private int venueId;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private String eventType;
    private int bookingId;

    public Event(int eventId, String eventName, String eventDate2, String eventTime,
                 int venueId, int totalSeats, int availableSeats, double ticketPrice,
                 String eventType, int bookingId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate2;
        this.eventTime = eventTime;
        this.venueId = venueId;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
        this.bookingId = bookingId;
    }

    public Event(int eventId, String eventName, String eventDate, String eventTime,
            int venueId, int totalSeats, int availableSeats, double ticketPrice,
            String eventType) {
		// TODO Auto-generated constructor stub
    	this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venueId = venueId;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
        this.bookingId = bookingId;
	}

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime='" + eventTime + '\'' +
                ", venueId=" + venueId +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                ", ticketPrice=" + ticketPrice +
                ", eventType='" + eventType + '\'' +
                ", bookingId=" + bookingId +
                '}';
    }
}
