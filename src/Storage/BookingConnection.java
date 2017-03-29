package Storage;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import Model.Booking;
import Model.Hotel;
import Model.Room;

/*
 * Class that contains functions that interact mostly with the Bookings table in the database.
 * @author Sævar Ingi Sigurðsson, sis108@hi.is
 */
public class BookingConnection {
	
	private static Connection c = null;
	private static Statement stmt = null;
	
	/*
	 * Function that adds a booking to the database.
	 * @params id, kt, hotelId, roomNo, sDate, eDate, checkout - Variables to create new booking.
	 */
	public static void bookRoom(int id, String kt, int hotelId, int roomNo, Date sDate, Date eDate, boolean checkout) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "INSERT INTO Bookings VALUES (" + id + ", '" + kt + "', " + hotelId + ", " + roomNo + ", '"
					+ sDate + "', '" + eDate + "', " + checkout + ");";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully added booking to database.");
	}
	
	/*
	 * Function that deletes/cancels a booking from the database.
	 * @param id - Booking ID that is unique.
	 */
	public static void deleteBooking(int id) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "DELETE FROM Bookings WHERE ID = " + id + ";";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully removed booking from database.");
	}
	
	/*
	 * Function that returns a list of all bookings in the database.
	 * @return bookings - ArrayList of bookings.
	 */
	public static ArrayList<Booking> getBookings() {
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Bookings;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Hotel bookedHotel = HotelConnection.getHotelById(rs.getInt("HotelID"));
				Room bookedRoom = RoomConnection.getRoomByKey(rs.getInt("HotelID"), rs.getInt("RoomNo"));
				
				//Error parsing dates!!
				Booking booking = new Booking(rs.getInt("ID"), rs.getString("Kennitala"), bookedHotel,
						bookedRoom, rs.getDate("StartDate"), rs.getDate("EndDate"), rs.getBoolean("LateCheckout"));
				
				bookings.add(booking);
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched all bookings from database.");
		return bookings;
	}
	
	/*
	 * Function that returns a booking identified by its ID.
	 * @param id - Booking ID that is unique.
	 * @return booking - Booking with specified ID.
	 */
	public static Booking getBookingById(int id) {
		Booking booking = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Bookings WHERE ID = " + id + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Hotel bookedHotel = HotelConnection.getHotelById(rs.getInt("HotelID"));
				Room bookedRoom = RoomConnection.getRoomByKey(rs.getInt("HotelID"), rs.getInt("RoomNo"));
				
				booking = new Booking(rs.getInt("ID"), rs.getString("Kennitala"), bookedHotel,
						bookedRoom, rs.getDate("StartDate"), rs.getDate("EndDate"), rs.getBoolean("LateCheckout"));
				
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched booking from database.");
		return booking;
	}
	
	/*
	 * Function that returns a list of bookings identified by their kennitala.
	 * @param kt - Kennitala of person who made booking/s.
	 * @return bookings - ArrayList of bookings containing specified kennitala.
	 */
	public static ArrayList<Booking> getBookingsByKt(String kt) {
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Bookings WHERE Kennitala = '" + kt + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Hotel bookedHotel = HotelConnection.getHotelById(rs.getInt("HotelID"));
				Room bookedRoom = RoomConnection.getRoomByKey(rs.getInt("HotelID"), rs.getInt("RoomNo"));
				
				Booking booking = new Booking(rs.getInt("ID"), rs.getString("Kennitala"), bookedHotel,
						bookedRoom, rs.getDate("StartDate"), rs.getDate("EndDate"), rs.getBoolean("LateCheckout"));
				
				bookings.add(booking);
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched bookings from database.");
		return bookings;
	}
	
	
	/* Main function for testing purposes */
	public static void main(String[] args) {
		ArrayList<Booking> al = getBookings();
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println("Booking ID: " + al.get(i).getBookingId());
			System.out.println("Kennitala: " + al.get(i).getKennitala());
			System.out.println("Hotel name: " + al.get(i).getHotel().getName());
			System.out.println("Room number: " + al.get(i).getRoom().getRoomNo());
			System.out.println("Start date: " + al.get(i).getStartDate());
			System.out.println("End date: " + al.get(i).getEndDate());
			System.out.println("Late checkout: " + al.get(i).getLateCheckout());
		}

	}

}
