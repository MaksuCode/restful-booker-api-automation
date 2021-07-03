package model;

public class Booking {

    private int bookingId ;
    private String firstname ;
    private String lastname ;
    private int totalPrice ;
    private boolean depositPaid ;
    private String checkInDate ;
    private String checkOutDate ;
    private String additionalNeeds ;

    public int getBookingId() {
        return bookingId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean getDepositPaid() {
        return depositPaid;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }
}
