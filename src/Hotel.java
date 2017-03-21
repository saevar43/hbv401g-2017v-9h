
public class Hotel {
	
	public int id;
	public String name;
	public double rating;
	public String location;
	
	public Hotel(int hotelId, String hotelName, double hotelRating, String hotelLocation) {
		id = hotelId;
		name = hotelName;
		rating = hotelRating;
		location = hotelLocation;
	}

	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getRating() {
		return rating;
	}
	
	public  String getLocation() {
		return location;
	}
}
