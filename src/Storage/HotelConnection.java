package Storage;
import java.sql.*;
import java.util.ArrayList;

import Model.Hotel;

public class HotelConnection {
	
	/*
	 * Function that INSERTS a hotel into the database.
	 * @param id, name, rating, location - Parameters necessary to INSERT into the database. 
	 */
	public static void addHotel(int id, String name, double rating, String location) {
		Connection c = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "INSERT INTO Hotels VALUES (" + id + ", '" + name + "', "
					+ rating + ", '" + location + "');";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully added hotel to database.");
	}
	
	/*
	 * Function that DELETES a hotel from the database.
	 * @param id - The ID of the hotel to be removed.
	 */
	public static void removeHotel(int id) {
		Connection c = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "DELETE FROM Hotels WHERE ID = " + id + ";";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully removed hotel from database.");
	}
	
	/*
	 * Function that returns a hotel specified by it's ID.
	 * @param id - The ID of the hotel to be returned.
	 * @return hotel - The hotel corresponding to the given ID.
	 */
	public static Hotel getHotelById(int id) {
		Connection c = null;
		Statement stmt = null;
		Hotel hotel = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Hotels WHERE ID = " + id + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				hotel = new Hotel(rs.getInt("ID"), rs.getString("Name"), rs.getFloat("Rating"),
						rs.getString("Location"));
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched hotel from database.");
		return hotel;
	}
	
	/*
	 * Function that returns a list of hotels by name.
	 * @param name - Name specified.
	 * @return hotels - ArrayList of hotels with the specified name.
	 */
	public static ArrayList<Hotel> getHotelByName(String name) {
		Connection c = null;
		Statement stmt = null;
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Hotels WHERE Name = '" + name + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Hotel hotel = new Hotel(rs.getInt("ID"), rs.getString("Name"), rs.getFloat("Rating"),
						rs.getString("Location"));
				hotels.add(hotel);
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched hotels from database.");
		return hotels;
	}
	
	/*
	 * Function that returns a list of hotels by rating.
	 * @param rating - Rating specified.
	 * @return hotels - ArrayList of hotels with specified rating.
	 */
	public static ArrayList<Hotel> getHotelByRating(double rating) {
		Connection c = null;
		Statement stmt = null;
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Hotels WHERE Rating = " + rating + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Hotel hotel = new Hotel(rs.getInt("ID"), rs.getString("Name"), rs.getFloat("Rating"),
						rs.getString("Location"));
				hotels.add(hotel);
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched hotels from database.");
		return hotels;
	}
	
	/* 
	 * Function that returns a list of hotels by location.
	 * @param location - Name of city searched for.
	 * @return hotels - ArrayList of hotels located in specified city.
	 */
	public static ArrayList<Hotel> getHotelByLocation(String location) {
		Connection c = null;
		Statement stmt = null;
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:hotelbooking.db");
			c.setAutoCommit(false);
			System.out.println("Opened database sucessfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM Hotels WHERE location = '" + location + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Hotel hotel = new Hotel(rs.getInt("ID"), rs.getString("Name"), rs.getFloat("Rating"),
						rs.getString("Location"));
				hotels.add(hotel);
			}
			
			stmt.close();
			c.commit();
			c.close();
		} catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Successfully fetched hotels from database.");
		return hotels;
	}
	
	/* Main function for testing purposes */
	public static void main(String[] args) {
	
		ArrayList<Hotel> al = getHotelByRating(1.5);
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println("ID: " + al.get(i).getID());
			System.out.println("Name: " + al.get(i).getName());
			System.out.println("Rating: " + al.get(i).getRating() + " stars.");
			System.out.println("Location: " + al.get(i).getLocation());
		}
	}
}
