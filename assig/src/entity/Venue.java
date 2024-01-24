package entity;

public class Venue {
    private int venueId;
    private String venueName;
    private String address;

    public void Venu(int venueId, String venueName, String address) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.address = address;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Venu{" +
                "venueId=" + venueId +
                ", venueName='" + venueName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
