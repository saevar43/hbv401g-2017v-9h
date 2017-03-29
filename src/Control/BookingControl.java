package Control;
import java.util.ArrayList;
import java.util.Date;

import Model.Booking;
import Storage.BookingConnection;

public class BookingControl {
	
	public static void bookRoom(int id, String kt, int hotelId, int roomNo, Date sDate, Date eDate, boolean checkout) {
		BookingConnection.bookRoom(id, kt, hotelId, roomNo, sDate, eDate, checkout);
	}
	
	public static void deleteBooking(int id) {
		BookingConnection.deleteBooking(id);
	}
	
	public static ArrayList<Booking> getBookings() {
		return BookingConnection.getBookings();
	}

	public static Booking getBookingById(int id) {
		return BookingConnection.getBookingById(id);
	}
	
	public static ArrayList<Booking> getBookingsByKt(String kt) {
		return BookingConnection.getBookingsByKt(kt);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
