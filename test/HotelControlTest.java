import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Control.HotelControl;
import Model.Hotel;
import Storage.HotelConnectionMock;

public class HotelControlTest {
	
	private HotelControl hc;
	private HotelConnectionMock hcm;
	private ArrayList<Hotel> hotels;
	private ArrayList<Hotel> orderedHotels;
	private ArrayList<Hotel> expectedHotels;

	@Before
	public void setUp() {
		hc = new HotelControl();
		hcm = new HotelConnectionMock();
	}

	@After
	public void tearDown() {
		hc = null;
		hcm = null;
	}

	@Test
	public void testOrderByRating() {
		hotels = hcm.getHotelByRatingRange(1, 4);
		orderedHotels = hc.orderByRating(hotels);
		expectedHotels = new ArrayList<Hotel>();
		
		Hotel hotel = new Hotel(13, "Icelandair", 1.5, "Egilsstadir");
		expectedHotels.add(hotel);
		hotel = new Hotel(3, "Edda", 2.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(19, "Bla Hostel", 2.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(20, "Bla Hostel", 2.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(6, "Radison", 2.5, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(12, "Radison", 2.5, "Akranes");
		expectedHotels.add(hotel);
		hotel = new Hotel(7, "Ibis", 3.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(11, "Ibis", 3.0, "Akureyri");
		expectedHotels.add(hotel);
		hotel = new Hotel(16, "Ibis", 3.0, "Egilsstadir");
		expectedHotels.add(hotel);
		hotel = new Hotel(1, "Radison", 3.5, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(4, "Hotel Fron", 3.5, "Akureyri");
		expectedHotels.add(hotel);
		hotel = new Hotel(14, "Kex Hostel", 3.5, "Reykjavik");
		expectedHotels.add(hotel);
		
		for (int i = 0; i < orderedHotels.size(); i++) {
			assertEquals(expectedHotels.get(i).getID(), orderedHotels.get(i).getID());
			assertEquals(expectedHotels.get(i).getName(), orderedHotels.get(i).getName());
			assertEquals(expectedHotels.get(i).getRating(), orderedHotels.get(i).getRating(), 0);
			assertEquals(expectedHotels.get(i).getLocation(), orderedHotels.get(i).getLocation());
		}
	}
	
	@Test
	public void testOrderByName() {
		hotels = hcm.getHotelByRatingRange(1, 4);
		orderedHotels = hc.orderByName(hotels);
		expectedHotels = new ArrayList<Hotel>();
		
		Hotel hotel = new Hotel(19, "Bla Hostel", 2.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(20, "Bla Hostel", 2.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(3, "Edda", 2.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(4, "Hotel Fron", 3.5, "Akureyri");
		expectedHotels.add(hotel);
		hotel = new Hotel(7, "Ibis", 3.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(11, "Ibis", 3.0, "Akureyri");
		expectedHotels.add(hotel);
		hotel = new Hotel(16, "Ibis", 3.0, "Egilsstadir");
		expectedHotels.add(hotel);
		hotel = new Hotel(13, "Icelandair", 1.5, "Egilsstadir");
		expectedHotels.add(hotel);
		hotel = new Hotel(14, "Kex Hostel", 3.5, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(1, "Radison", 3.5, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(6, "Radison", 2.5, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(12, "Radison", 2.5, "Akranes");
		expectedHotels.add(hotel);
		
		for (int i = 0; i < orderedHotels.size(); i++) {
			assertEquals(expectedHotels.get(i).getID(), orderedHotels.get(i).getID());
			assertEquals(expectedHotels.get(i).getName(), orderedHotels.get(i).getName());
			assertEquals(expectedHotels.get(i).getRating(), orderedHotels.get(i).getRating(), 0);
			assertEquals(expectedHotels.get(i).getLocation(), orderedHotels.get(i).getLocation());
		}
	}
	
	@Test
	public void testOrderByLocation() {
		hotels = hcm.getHotelByRatingRange(1, 4);
		orderedHotels = hc.orderByLocation(hotels);
		expectedHotels = new ArrayList<Hotel>();
		
		Hotel hotel = new Hotel(12, "Radison", 2.5, "Akranes");
		expectedHotels.add(hotel);
		hotel = new Hotel(4, "Hotel Fron", 3.5, "Akureyri");
		expectedHotels.add(hotel);
		hotel = new Hotel(11, "Ibis", 3.0, "Akureyri");
		expectedHotels.add(hotel);
		hotel = new Hotel(13, "Icelandair", 1.5, "Egilsstadir");
		expectedHotels.add(hotel);
		hotel = new Hotel(16, "Ibis", 3.0, "Egilsstadir");
		expectedHotels.add(hotel);
		hotel = new Hotel(1, "Radison", 3.5, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(3, "Edda", 2.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(6, "Radison", 2.5, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(7, "Ibis", 3.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(14, "Kex Hostel", 3.5, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(19, "Bla Hostel", 2.0, "Reykjavik");
		expectedHotels.add(hotel);
		hotel = new Hotel(20, "Bla Hostel", 2.0, "Reykjavik");
		expectedHotels.add(hotel);
		
		for (int i = 0; i < orderedHotels.size(); i++) {
			assertEquals(expectedHotels.get(i).getID(), orderedHotels.get(i).getID());
			assertEquals(expectedHotels.get(i).getName(), orderedHotels.get(i).getName());
			assertEquals(expectedHotels.get(i).getRating(), orderedHotels.get(i).getRating(), 0);
			assertEquals(expectedHotels.get(i).getLocation(), orderedHotels.get(i).getLocation());
		}
	}
	

}
