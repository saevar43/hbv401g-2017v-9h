package Model;

/*
 * Class for the Hotel model. Contains a constructor, getters and setters for Hotel.
 * @author Sævar Ingi Sigurðsson, sis108@hi.is
 */
public class Hotel {
	
	private int ID;
	private String NAME;
	private double rating;
	private String LOCATION;
	
	/*
	 * Constructor for Hotel.
	 */
	public Hotel(int hotelId, String hotelName, double hotelRating, String hotelLocation) {
		ID = hotelId;
		NAME = hotelName;
		rating = hotelRating;
		LOCATION = hotelLocation;
	}

	/*
	 * Getter for Hotel ID.
	 * @return ID - ID of Hotel.
	 */
	public int getID() {
		return ID;
	}
	
	/*
	 * Getter for Hotel name.
	 * @return name - Name of Hotel.
	 */
	public String getName() {
		return NAME;
	}
	
	/*
	 * Setter for Hotel rating.
	 * @param rating - Rating to be assigned to Hotel.
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	/*
	 * Getter for Hotel rating.
	 * @return rating - Rating of Hotel.
	 */
	public double getRating() {
		return rating;
	}
	
	/*
	 * Getter for Hotel location.
	 * @return LOCATION - Location of Hotel.
	 */
	public String getLocation() {
		return LOCATION;
	}
}
