
public class Room {

	private int hotelId;
	private int roomNo;
	private String type;
	private double price;
	
	public Room(int roomHotelId, int roomNumber, String roomType, double roomPrice) {
		hotelId = roomHotelId;
		roomNo = roomNumber;
		type = roomType;
		price = roomPrice;
	}
	
	public int getHotelId() {
		return hotelId;
	}
	
	public int getRoomNo() {
		return roomNo;
	}
	
	public String getType() {
		return type;
	}
	
	public double getPrice() {
		return price;
	}
}
