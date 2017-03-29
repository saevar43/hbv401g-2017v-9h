package Storage;

import java.util.ArrayList;

import Model.Hotel;

public class HotelConnectionMock {
	ArrayList<Hotel> hotels;
	
	public HotelConnectionMock() {
		
		hotels = new ArrayList<Hotel>();
		
		Hotel hotel = new Hotel(1, "Radison", 3.5, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		hotel = new Hotel(2, "Icelandair", 4.0, "Reykjavik");
		hotels.add(hotel);
		
		
	}
	
	public Hotel getHotelById(int id) {
		for( int i = 0; i < hotels.size(); i++) {
			if(hotels.get(i).getID() == id) {
				return hotels.get(i);
			}
		}
		return null;
	}
}
