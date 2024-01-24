package entity;

import java.util.Date;

public class SportsEvent extends Event {
    private String sportType;

    public SportsEvent(int eventId, String eventName, String eventDate, String eventTime,
                       int venueId, int totalSeats, int availableSeats, double ticketPrice,
                       int bookingId, String sportType) {
        super(eventId, eventName, eventDate, eventTime, venueId, totalSeats, availableSeats, ticketPrice, "Sports", bookingId);
        this.sportType = sportType;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    @Override
    public String toString() {
        return "SportsEvent{" +
                "eventId=" + getEventId() +
                ", eventName='" + getEventName() + '\'' +
                ", eventDate=" + getEventDate() +
                ", eventTime='" + getEventTime() + '\'' +
                ", venueId=" + getVenueId() +
                ", totalSeats=" + getTotalSeats() +
                ", availableSeats=" + getAvailableSeats() +
                ", ticketPrice=" + getTicketPrice() +
                ", sportType='" + sportType + '\'' +
                ", bookingId=" + getBookingId() +
                '}';
    }
}
