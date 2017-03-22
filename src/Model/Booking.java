package Model;
import java.util.Date;

/*
 * Class for the booking model. Contains a constructor, getters and setters for Booking.
 * @author Sævar Ingi Sigurðsson, sis108@hi.is
 */
public class Booking {

	private int BOOKING_ID;
	private String KENNITALA;
	private Hotel hotel;
	private Room room;
	private Date startDate;
	private Date endDate;
	private boolean lateCheckout;
	
	/*
	 * Constructor for Booking.
	 */
	public Booking(int id, String kt, Hotel bookedHotel, Room bookedRoom, Date sDate, Date eDate, boolean checkout) {
		BOOKING_ID = id;
		KENNITALA = kt;
		hotel = bookedHotel;
		room = bookedRoom;
		startDate = sDate;
		endDate = eDate;
		lateCheckout = checkout;
	}
	
	/*
	 * Getter for Booking ID.
	 * @return BOOKING_ID - ID of booking.
	 */
	public int getBookingId() {
		return BOOKING_ID;
	}
	
	/*
	 * Getter for Kennitala.
	 * @return KENNITALA - Kennitala on Booking.
	 */
	public String getKennitala() {
		return KENNITALA;
	}
	
	/*
	 * Setter for Hotel booked.
	 * @param hotel - Hotel to be booked.
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	/*
	 * Getter for Hotel booked.
	 * @return hotel - Hotel booked.
	 */
	public Hotel getHotel() {
		return hotel;
	}
	
	/*
	 * Setter for Room booked.
	 * @param room - Room to be booked.
	 */
	public void setRoom(Room room) {
		this.room = room;
	}
	
	/*
	 * Getter for Room booked.
	 * @return room - Room booked.
	 */
	public Room getRoom() {
		return room;
	}
	
	/*
	 * Setter for starting date of booking.
	 * @param startDate - starting date of booking.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/*
	 * Getter for starting date of booking.
	 * @return startDate - starting date of booking.
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/*
	 * Setter for end date of booking.
	 * @param endDate - end date of booking.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/*
	 * Getter for end date of booking.
	 * @return endDate - end date of booking.
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/*
	 * Setter for late checkout.
	 * @param lateCheckout - boolean value, TRUE if late checkout wanted, FALSE if not.
	 */
	public void setLateCheckout(boolean lateCheckout) {
		this.lateCheckout = lateCheckout;
	}
	
	/*
	 * Getter for late checkout.
	 * @return lateCheckout - TRUE/FALSE depending on if late checkout wanted.
	 */
	public boolean getLateCheckout() {
		return lateCheckout;
	}
}
