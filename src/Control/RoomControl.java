package Control;

import java.util.ArrayList;

import Model.Room;
import Storage.RoomConnection;

/**
 * A class that contains functions used to control the Room type and its lists.
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 */
public class RoomControl {
	
        /**
         * Instance variables.
         */
	private RoomConnection rconn = new RoomConnection();
	
	/**
	 * Constructor for RoomControl.
	 */
	public RoomControl() {
		
	}
	
	/**
	 * A function that adds a room to the database.
	 * Simply calls the corresponding function from RoomConnection.
	 */
	public void addRoom(int hotelId, int roomNo, String type, double price) {
		rconn.addRoom(hotelId, roomNo, type, price);
	}
	
	/**
	 * A function that removes a room from the database.
	 * Simply calls the corresponding function from RoomConnection.
	 */
	public void removeRoom(int hotelId, int roomNo) {
		rconn.removeRoom(hotelId, roomNo);
	}
	
	/**
	 * A function that gets all rooms from the database.
	 * Simply calls the corresponding function from RoomConnection.
	 */
	public ArrayList<Room> getRooms() {
		return rconn.getRooms();
	}
	
	/**
	 * A function that gets a room by its key.
	 * Simply calls the corresponding function from RoomConnection.
	 */
	public Room getRoomByKey(int hotelId, int roomNo) {
		return rconn.getRoomByKey(hotelId, roomNo);
	}
	
	/**
	 * A function that gets rooms by hotel.
	 * Simply calls the corresponding function from RoomConnection.
	 */
	public ArrayList<Room> getRoomsByHotel(int hotelId) {
		return rconn.getRoomsByHotel(hotelId);
	}
	
	/**
	 * A function that gets rooms by type.
	 * Simply calls the corresponding function from RoomConnection.
	 */
	public ArrayList<Room> getRoomsByType(String type) {
		return rconn.getRoomsByType(type);
	}
	
	/**
	 * A function that gets rooms by price range.
	 * Simply calls teh corresponding function from RoomConnection.
	 */
	public ArrayList<Room> getRoomsByPriceRange(double minPrice, double maxPrice) {
		return rconn.getRoomsByPriceRange(minPrice, maxPrice);
	}
}
