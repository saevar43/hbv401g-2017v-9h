package Storage;

import java.util.ArrayList;

import Model.Hotel;

/*
 * Mock class for HotelConnection which includes hardcoded data for hotels.
 */
public class HotelConnectionMock {
	
	private ArrayList<Hotel> hotels;
	
	/*
	 * Constructor for HotelConnectionMock. Creates a hardcoded list of Hotels.
	 */
	public HotelConnectionMock() {
		
		hotels = new ArrayList<Hotel>();
		
		// Add 20 hotels to the list hotels, ordered by their ID.
		Hotel hotel = new Hotel(1, "Radison", 3.5, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(3, "Edda", 2.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(4, "Hotel Fron", 3.5, "Akureyri");
		hotels.add(hotel);
		
		hotel = new Hotel(5, "Bad Hostel", 1.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(6, "Radison", 2.5, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(7, "Ibis", 3.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(8, "Saga", 5.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(9, "Icelandair", 4.5, "Akureyri");
		hotels.add(hotel);
		
		hotel = new Hotel(10, "Edda", 4.0, "Isafjordur");
		hotels.add(hotel);
		
		hotel = new Hotel(11, "Ibis", 3.0, "Akureyri");
		hotels.add(hotel);
		
		hotel = new Hotel(12, "Radison", 2.5, "Akranes");
		hotels.add(hotel);
		
		hotel = new Hotel(13, "Icelandair", 1.5, "Egilsstadir");
		hotels.add(hotel);
		
		hotel = new Hotel(14, "Kex Hostel", 3.5, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(15, "Edda", 4.5, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(16, "Ibis", 3.0, "Egilsstadir");
		hotels.add(hotel);
		
		hotel = new Hotel(17, "Radison", 4.5, "Selfoss");
		hotels.add(hotel);
		
		hotel = new Hotel(18, "Grand Hostel", 4.0, "Hveragerði");
		hotels.add(hotel);
		
		hotel = new Hotel(19, "Bla Hostel", 2.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(20, "Bla Hostel", 2.0, "Reykjavik");
		hotels.add(hotel);
		
	}

	/*
	 * A function that gets a hotel form the list by its ID.
	 * If no hotel is found it return null.
	 */
	public Hotel getHotelById(int id) {
		
		for (int i = 0; i < hotels.size(); i++) {
			if (hotels.get(i).getID() == id) {
				return hotels.get(i);
			}
		}
		return null;
	}
	
	/*
	 * A function that gets hotels from the list by their name.
	 * If no hotel is found return null.
	 */
	public ArrayList<Hotel> getHotelByName(String name) {
		ArrayList<Hotel> nameHotels = new ArrayList<Hotel>();
		
		for (int i = 0; i < hotels.size(); i++) {
			if (hotels.get(i).getName() == name) {
				nameHotels.add(hotels.get(i));
			}
		}
		if (nameHotels.isEmpty()) {
			return null;
		} else {
			return nameHotels;
		}
	}
	
	/*
	 * A function that gets hotels from the list with a rating within a specified range.
	 * If no hotel is found return null.
	 */
	public ArrayList<Hotel> getHotelByRatingRange(double minRating, double maxRating) {
		
		ArrayList<Hotel> ratingHotels = new ArrayList<Hotel>();
		
		for (int i = 0; i < hotels.size(); i++) {
			if (hotels.get(i).getRating() > minRating && hotels.get(i).getRating() < maxRating) {
				ratingHotels.add(hotels.get(i));
			}
		}
		if (ratingHotels.isEmpty()) {
			return null;
		} else {
			return ratingHotels;
		}
	}
	
	/*
	 * A function that gets hotels from the list by their location.
	 * If no hotel is found return null.
	 */
	public ArrayList<Hotel> getHotelByLocation(String location) {
		ArrayList<Hotel> locationHotels = new ArrayList<Hotel>();
		
		for (int i = 0; i < hotels.size(); i++) {
			if (hotels.get(i).getLocation() == location) {
				locationHotels.add(hotels.get(i));
			}
		}
		if (locationHotels.isEmpty()) {
			return null;
		} else {
			return locationHotels;
		}
	}
}

