package Model;

public class Hotel {
	
	private int ID;
	private String NAME;
	private double rating;
	private String LOCATION;
	
	public Hotel(int hotelId, String hotelName, double hotelRating, String hotelLocation) {
		ID = hotelId;
		NAME = hotelName;
		rating = hotelRating;
		LOCATION = hotelLocation;
	}

	public int getID() {
		return ID;
	}
	
	public String getName() {
		return NAME;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public double getRating() {
		return rating;
	}
	
	public  String getLocation() {
		return LOCATION;
	}
}
