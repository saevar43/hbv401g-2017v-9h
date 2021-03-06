package Control;

import java.util.ArrayList;
import java.util.Comparator;

import Model.Hotel;
import Storage.HotelConnection;

/**
 * A class that contains functions used to control the Hotel type and its lists.
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 */
public class HotelControl {
	
	/**
         * Instance variables.
         */
	private HotelConnection hconn = new HotelConnection();
	
	/**
	 * A constructor for HotelControl.
	 */
	public HotelControl() {
		
	}

	/**
	 * A function that adds a Hotel to the database.
	 * Simply calls the corresponding function from HotelConnection.
	 */
	public void addHotel(int id, String name, double rating, String location) {
		hconn.addHotel(id, name, rating, location);
	}
	
	/**
	 * A function that removes a hotel from the database.
	 * Simply calls the corresponding function from HotelConnection.
	 */
	public void removeHotel(int id) {
		hconn.removeHotel(id);
	}
	
	/**
	 * A function that gets a hotel by its ID.
	 * Simply calls the corresponding function from HotelConnection (or HotelConnectionMock).
	 */
	public Hotel getHotelById(int id) {
		return hconn.getHotelById(id);
	}
	
	/**
	 * A function that gets hotels by their name.
	 * Simply calls the corresponding function from HotelConnection (or HotelConnectionMock).
	 */
	public ArrayList<Hotel> getHotelByName(String name) {
		return hconn.getHotelByName(name);
	}
	
	/**
	 * A function that gets hotels with a rating within a specified rating range.
	 * Simply calls the corresponding function from HotelConnection (or HotelConnectionMock).
	 */
	public ArrayList<Hotel> getHotelByRatingRange(double minRating, double maxRating) {
		return hconn.getHotelByRatingRange(minRating, maxRating);
	}
	
	/**
	 * A function that gets hotels by their location.
	 * Simply calls the corresponding function from HotelConnection (or HotelConnectionMock).
	 */
	public ArrayList<Hotel> getHotelByLocation(String location) {
		return hconn.getHotelByLocation(location);
	}
        
        
        /**
         * 
         */
        public ArrayList<Hotel> getHotelByRatingRangeFromList(ArrayList<Hotel> list, double minRating, double maxRating) {
            ArrayList<Hotel> hotels = new ArrayList<Hotel>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getRating() <= maxRating && list.get(i).getRating() >= minRating) {
                    hotels.add(list.get(i));
                }
            }
            return hotels;
        }
	
	/**
	 * A function that orders an ArrayList of hotels by their rating.
	 */
	public ArrayList<Hotel> orderByRating(ArrayList<Hotel> hotels) {
		hotels.sort(Comparator.comparing(Hotel::getRating));
		return hotels;
	}
	
	/**
	 * A function that orders an ArrayList of hotels by their name.
	 */
	public ArrayList<Hotel> orderByName(ArrayList<Hotel> hotels) {
		hotels.sort(Comparator.comparing(Hotel::getName));
		return hotels;
	}
	
	/**
	 * A function that orders an ArrayList of hotels by their location.
	 */
	public ArrayList<Hotel> orderByLocation(ArrayList<Hotel> hotels) {
		hotels.sort(Comparator.comparing(Hotel::getLocation));
		return hotels;
	}
}