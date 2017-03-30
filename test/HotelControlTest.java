import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HotelControlTest {
	private ArrayList<Hotel> hotels;

	@Before
	public void setUp() throws Exception {
		hotels = new HotelConnectionMock();
	}

	@After
	public void tearDown() throws Exception {
		hotels = null;
	}

	@Test
	public void testOrderByRating() {
		assertEquals(10, HotelControl.orderByRating(hotels));
		fail("Skellur");
	}

}
