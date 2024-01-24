package entity;

import java.util.Date;

public class MovieEvent extends Event {
    private String movieGenre;

    public MovieEvent(int eventId, String eventName, String eventDate, String eventTime,
                      int venueId, int totalSeats, int availableSeats, double ticketPrice,
                      int bookingId, String movieGenre) {
        super(eventId, eventName, eventDate, eventTime, venueId, totalSeats, availableSeats, ticketPrice, "Movie", bookingId);
        this.movieGenre = movieGenre;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    @Override
    public String toString() {
        return "MovieEvent{" +
                "eventId=" + getEventId() +
                ", eventName='" + getEventName() + '\'' +
                ", eventDate=" + getEventDate() +
                ", eventTime='" + getEventTime() + '\'' +
                ", venueId=" + getVenueId() +
                ", totalSeats=" + getTotalSeats() +
                ", availableSeats=" + getAvailableSeats() +
                ", ticketPrice=" + getTicketPrice() +
                ", movieGenre='" + movieGenre + '\'' +
                ", bookingId=" + getBookingId() +
                '}';
    }
}
