package Control;
import java.util.ArrayList;

import Model.Booking;
import Storage.BookingConnection;
import static java.util.Arrays.sort;

/**
 * A class that contains functions that control the Booking type and its lists.
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 */
public class BookingControl {
	
        /**
         * Instance variables.
         */
	private BookingConnection bconn = new BookingConnection();
        private int[] bookingIds;
	
	/**
	 * Constructor for BookingControl.
	 */
	public BookingControl() {
		
	}
	
	/**
	 * A function that books a room, i.e. adds a booking to the database.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public void bookRoom(int id, String kt, int hotelId, int roomNo, String sDate, String eDate, boolean checkout) {
		bconn.bookRoom(id, kt, hotelId, roomNo, sDate, eDate, checkout);
	}
	
	/**
	 * A function that deletes a booking from the database.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public void deleteBooking(int id) {
		bconn.deleteBooking(id);
	}
	
	/**
	 * A function that gets all bookings from the database.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public ArrayList<Booking> getBookings() {
		return bconn.getBookings();
	}

	/**
	 * A function that gets a booking by its ID.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public Booking getBookingById(int id) {
		return bconn.getBookingById(id);
	}
	
	/**
	 * A function that gets booking by their attached kennitala.
	 * Simply calls the corresponding function from BookingConnection.
	 */
	public ArrayList<Booking> getBookingsByKt(String kt) {
		return bconn.getBookingsByKt(kt);
	}
        
        /**
         * A function that creates an array of all bookingId already in db. 
         */
        public void createSortedBookingIdArray() {
            ArrayList<Booking> bookings = this.getBookings();
            bookingIds = new int[bookings.size()];
            
            for (int i = 0; i < bookings.size(); i++) {
                bookingIds[i] = bookings.get(i).getBookingId();
            }
            sort(bookingIds);
        }
        
        /**
         * Getter for array of bookingIds.
         * @return 
         */
        public int[] getBookingIds() {
            return bookingIds;
        }
        
        /**
         * A function that finds the first missing number of an array.
         * @param array - the array to search.
         * @param start - index of the array to start search.
         * @param end - index of the array to end search.
         * @return 
         */
        public int findFirstMissingNumber(int[] array, int start, int end) {
            if (start > end) 
                return end + 1;
            
            if (start != array[start]) 
                return start;
            
            
            int middle = (start + end)/2;
            
            if (array[middle] == middle) 
                return findFirstMissingNumber(array, middle + 1, end);
            
            return findFirstMissingNumber(array, start, middle);
        }
        
}
