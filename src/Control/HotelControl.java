package Control;

import java.util.ArrayList;
import java.util.Comparator;

import Model.Hotel;
import Storage.HotelConnection;
import Storage.HotelConnectionMock;

public class HotelControl {
	
	private HotelConnectionMock hcm = new HotelConnectionMock();
	
	public HotelControl() {
		
	}

	public void addHotel(int id, String name, double rating, String location) {
		HotelConnection.addHotel(id, name, rating, location);
	}
	
	public void removeHotel(int id) {
		HotelConnection.removeHotel(id);
	}
	
	public Hotel getHotelById(int id) {
		return hcm.getHotelById(id);
	}
	
	public ArrayList<Hotel> getHotelByName(String name) {
		return hcm.getHotelByName(name);
	}
	
	public ArrayList<Hotel> getHotelByRatingRange(double minRating, double maxRating) {
		return hcm.getHotelByRatingRange(minRating, maxRating);
	}
	
	public ArrayList<Hotel> getHotelByLocation(String location) {
		return hcm.getHotelByLocation(location);
	}
	
	public ArrayList<Hotel> orderByRating(ArrayList<Hotel> hotels) {
		hotels.sort(Comparator.comparing(Hotel::getRating));
		return hotels;
	}
	
	public ArrayList<Hotel> orderByName(ArrayList<Hotel> hotels) {
		hotels.sort(Comparator.comparing(Hotel::getName));
		return hotels;
	}
	
	public ArrayList<Hotel> orderByLocation(ArrayList<Hotel> hotels) {
		hotels.sort(Comparator.comparing(Hotel::getLocation));
		return hotels;
	}
	
	public static void main(String [] args) {
		HotelControl hc = new HotelControl();
		ArrayList<Hotel> hotels = hc.getHotelByRatingRange(1, 4);
		
		ArrayList<Hotel> rankingHotels = hc.orderByRating(hotels);
		
		for (int i = 0; i < rankingHotels.size(); i++) {
			System.out.println(rankingHotels.get(i).getID() + ", " + rankingHotels.get(i).getName() + ", " 
					+ rankingHotels.get(i).getRating() + ", " + rankingHotels.get(i).getLocation());
		}
		
	}
}
