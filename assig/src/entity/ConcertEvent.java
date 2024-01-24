package entity;

import java.util.Date;

public class ConcertEvent extends Event {
    private String artist;
    private String genre;

    public ConcertEvent(int eventId, String eventName, String eventDate, String eventTime,
                        int venueId, int totalSeats, int availableSeats, double ticketPrice,
                        int bookingId, String artist, String genre) {
        super(eventId, eventName, eventDate, eventTime, venueId, totalSeats, availableSeats, ticketPrice, "Concert", bookingId);
        this.artist = artist;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "ConcertEvent{" +
                "eventId=" + getEventId() +
                ", eventName='" + getEventName() + '\'' +
                ", eventDate=" + getEventDate() +
                ", eventTime='" + getEventTime() + '\'' +
                ", venueId=" + getVenueId() +
                ", totalSeats=" + getTotalSeats() +
                ", availableSeats=" + getAvailableSeats() +
                ", ticketPrice=" + getTicketPrice() +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", bookingId=" + getBookingId() +
                '}';
    }
}
