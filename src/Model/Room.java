package Model;

public class Room {

	private int HOTEL_ID;
	private int ROOM_NO;
	private String TYPE;
	private double price;
	
	public Room(int roomHotelId, int roomNumber, String roomType, double roomPrice) {
		HOTEL_ID = roomHotelId;
		ROOM_NO = roomNumber;
		TYPE = roomType;
		price = roomPrice;
	}
	
	public int getHotelId() {
		return HOTEL_ID;
	}
	
	public int getRoomNo() {
		return ROOM_NO;
	}
	
	public String getType() {
		return TYPE;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
}
