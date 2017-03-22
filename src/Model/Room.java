package Model;

/*
 * Class for the Room model. Contains a constructor, getters and setters for Room.
 */
public class Room {

	private int HOTEL_ID;
	private int ROOM_NO;
	private String TYPE;
	private double price;
	
	/*
	 * Constructor for Room.
	 */
	public Room(int roomHotelId, int roomNumber, String roomType, double roomPrice) {
		HOTEL_ID = roomHotelId;
		ROOM_NO = roomNumber;
		TYPE = roomType;
		price = roomPrice;
	}
	
	/*
	 * Getter for Hotel ID.
	 * @return HOTEL_ID - ID of Hotel containing room.
	 */
	public int getHotelId() {
		return HOTEL_ID;
	}
	
	/*
	 * Getter for Room number.
	 * @return ROOM_NO - Number of Room.
	 */
	public int getRoomNo() {
		return ROOM_NO;
	}
	
	/*
	 * Getter for Room type.
	 * @return TYPE - Type of Room.
	 */
	public String getType() {
		return TYPE;
	}
	
	/*
	 * Setter for Room price.
	 * @param price - Price to be assigned to Room.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/*
	 * Getter for Room price.
	 * @return price - Price of room.
	 */
	public double getPrice() {
		return price;
	}
}
