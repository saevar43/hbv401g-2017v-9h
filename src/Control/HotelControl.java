package Control;

import java.util.ArrayList;
import java.util.Comparator;

import Model.Hotel;
import Storage.HotelConnection;
import Storage.HotelConnectionMock;

public class HotelControl {

	public static void addHotel(int id, String name, double rating, String location) {
		HotelConnection.addHotel(id, name, rating, location);
	}
	
	public static void removeHotel(int id) {
		HotelConnection.removeHotel(id);
	}
	
	public static Hotel getHotelById(int id) {
		return HotelConnectionMock.getHotelById(id);
	}
	
	public static ArrayList<Hotel> getHotelByName(String name) {
		return HotelConnectionMock.getHotelByName(name);
	}
	
	public static ArrayList<Hotel> getHotelByRatingRange(double minRating, double maxRating) {
		return HotelConnectionMock.getHotelByRatingRange(minRating, maxRating);
	}
	
	public static  ArrayList<Hotel> getHotelByLocation(String location) {
		return HotelConnectionMock.getHotelByLocation(location);
	}
	
	public static ArrayList<Hotel> orderByRating(ArrayList<Hotel> hotels) {
		hotels.sort(Comparator.comparing(Hotel::getRating));
		return hotels;
	}
	
	public static ArrayList<Hotel> orderByName(ArrayList<Hotel> hotels) {
		hotels.sort(Comparator.comparing(Hotel::getName));
		return hotels;
	}
	
	public static ArrayList<Hotel> orderByLocation(ArrayList<Hotel> hotels) {
		hotels.sort(Comparator.comparing(Hotel::getLocation));
		return hotels;
	}
	
	public static void main(String [] args) {
		
		ArrayList<Hotel> hotels = getHotelByRatingRange(0, 5);
		
		ArrayList<Hotel> sortedHotels = orderByRating(hotels);
		
		for (int i = 0; i < sortedHotels.size(); i++) {
			System.out.println(sortedHotels.get(i));
		}
	}
}
