package Storage;

import java.sql.*;
import java.util.ArrayList;

import Model.Room;

/*
 * Class that contains functions that interact mostly with the Rooms table in the database.
 * @author Sævar Ingi Sigurðsson, sis108@hi.is
 */
public class RoomConnection {
	
	private static Connection c = null;
	private static Statement stmt = null;
	 
	/*
	 * Function that adds a room to the database.
	 * @param hotelId, roomNo, type, price - Variables necessary to create a new room.
	 */
	public static void addRoom(int hotelId, int roomNo, String type, double price) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "INSERT INTO Rooms VALUES (" + hotelId + ", " + roomNo + ", '"
					+ type + "', " + price + ");";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully added room to database.");
	}
	
	/*
	 * Function that removes a room from the database.
	 * @param hotelId, roomNo - ID of hotel containing the room and the room number. Is a key.
	 */
	public static void removeRoom(int hotelId, int roomNo) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "DELETE FROM Rooms WHERE HotelID = " + hotelId + " AND RoomNo = " + roomNo + ";";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully removed room from database.");
	}

	/*
	 * Function that return all rooms in the database.
	 * @return rooms - ArrayList of all rooms in the database.
	 */
	public static ArrayList<Room> getRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Rooms;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Room room = new Room(rs.getInt("HotelID"), rs.getInt("RoomNo"), rs.getString("Type"),
						rs.getDouble("Price"));
				
				rooms.add(room);
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched all rooms from database.");
		return rooms;
	}
	
	/*
	 * Function that returns a room by it's key.
	 * @param hotelId, roomNo - Key specific to the room.
	 * @return room - The room specified by the key.
	 */
	public static Room getRoomByKey(int hotelId, int roomNo) {
		Room room = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Rooms WHERE HotelID = " + hotelId + " AND RoomNo = " + roomNo + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				room = new Room(rs.getInt("HotelID"), rs.getInt("RoomNo"), rs.getString("Type"), rs.getDouble("Price"));
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched room from database.");
		return room;
	}

	/*
	 * Function that returns all rooms in a hotel.
	 * @param hotelId - ID of the hotel.
	 * @return rooms - ArrayList of rooms in the hotel.
	 */
	public static ArrayList<Room> getRoomsByHotel(int hotelId) {
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Rooms WHERE HotelID = " + hotelId + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Room room = new Room(rs.getInt("HotelID"), rs.getInt("RoomNo"), rs.getString("Type"),
						rs.getDouble("Price"));
				
				rooms.add(room);
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched rooms from database.");
		return rooms;
	}
	
	/*
	 * Function that returns all rooms of a specified type.
	 * @param type - Type of rooms wanted.
	 * @return - Rooms of specified type.
	 */
	public static ArrayList<Room> getRoomsByType(String type) {
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Rooms WHERE Type = " + type + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Room room = new Room(rs.getInt("HotelID"), rs.getInt("RoomNo"), rs.getString("Type"),
						rs.getDouble("Price"));
				
				rooms.add(room);
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched rooms from database.");
		return rooms;
	}
	
	/*
	 * Function that return all rooms within a certain price range.
	 * @param minPrice, maxPrice - Lower and upper ranges of price range.
	 * @return rooms - ArrayList of rooms within specified price range.
	 */
	public static ArrayList<Room> getRoomsByPriceRange(double minPrice, double maxPrice) {
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Bookings WHERE Price >= " + minPrice + "AND Price <= " + maxPrice + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Room room = new Room(rs.getInt("HotelID"), rs.getInt("RoomNo"), rs.getString("Type"),
						rs.getDouble("Price"));
				
				rooms.add(room);
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched rooms from database.");
		return rooms;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Room> al = getRooms();
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println("Hotel ID: " + al.get(i).getHotelId());
			System.out.println("Room No.: " + al.get(i).getRoomNo());
			System.out.println("Room type: " + al.get(i).getType());
			System.out.println("Price: " + al.get(i).getPrice() + " per night.");
		}

	}

}
