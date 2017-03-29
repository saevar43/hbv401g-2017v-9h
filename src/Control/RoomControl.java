package Control;

import java.util.ArrayList;

import Model.Room;
import Storage.RoomConnection;

public class RoomControl {
	
	public static void addRoom(int hotelId, int roomNo, String type, double price) {
		RoomConnection.addRoom(hotelId, roomNo, type, price);
	}
	
	public static void removeRoom(int hotelId, int roomNo) {
		RoomConnection.removeRoom(hotelId, roomNo);
	}
	
	public static ArrayList<Room> getRooms() {
		return RoomConnection.getRooms();
	}
	
	public static Room getRoomByKey(int hotelId, int roomNo) {
		return RoomConnection.getRoomByKey(hotelId, roomNo);
	}
	
	public static ArrayList<Room> getRoomsByHotel(int hotelId) {
		return RoomConnection.getRoomsByHotel(hotelId);
	}
	
	public static ArrayList<Room> getRoomsByType(String type) {
		return RoomConnection.getRoomsByType(type);
	}
	
	public static ArrayList<Room> getRoomsByPriceRange(double minPrice, double maxPrice) {
		return RoomConnection.getRoomsByPriceRange(minPrice, maxPrice);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
