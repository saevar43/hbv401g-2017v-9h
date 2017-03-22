package Model;
import java.util.Date;

public class Booking {

	private int BOOKING_ID;
	private String KENNITALA;
	private Hotel hotel;
	private Room room;
	private Date startDate;
	private Date endDate;
	private boolean lateCheckout;
	
	public Booking(int id, String kt, Hotel bookedHotel, Room bookedRoom, Date sDate, Date eDate, boolean checkout) {
		BOOKING_ID = id;
		KENNITALA = kt;
		hotel = bookedHotel;
		room = bookedRoom;
		startDate = sDate;
		endDate = eDate;
		lateCheckout = checkout;
	}
	
	public int getBookingId() {
		return BOOKING_ID;
	}
	
	public String getKennitala() {
		return KENNITALA;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setLateCheckout(boolean lateCheckout) {
		this.lateCheckout = lateCheckout;
	}
	
	public boolean getLateCheckout() {
		return lateCheckout;
	}
}
