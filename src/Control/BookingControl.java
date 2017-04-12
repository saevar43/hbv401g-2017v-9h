package Control;
import java.util.ArrayList;
import java.util.Date;

import Model.Booking;
import Storage.BookingConnection;

public class BookingControl {
	
	private BookingConnection bconn = new BookingConnection();
	
	/*
	 * Constructor for BookingControl.
	 */
	public BookingControl() {
		
	}
	
	/*
	 * A function that books a room, i.e. adds a booking to the database.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public void bookRoom(int id, String kt, int hotelId, int roomNo, Date sDate, Date eDate, boolean checkout) {
		bconn.bookRoom(id, kt, hotelId, roomNo, sDate, eDate, checkout);
	}
	
	/*
	 * A function that deletes a booking from the database.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public void deleteBooking(int id) {
		bconn.deleteBooking(id);
	}
	
	/*
	 * A function that gets all bookings from the database.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public ArrayList<Booking> getBookings() {
		return bconn.getBookings();
	}

	/*
	 * A function that gets a booking by its ID.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public Booking getBookingById(int id) {
		return bconn.getBookingById(id);
	}
	
	/*
	 * A function that gets booking by their attached kennitala.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public ArrayList<Booking> getBookingsByKt(String kt) {
		return bconn.getBookingsByKt(kt);
	}
}
