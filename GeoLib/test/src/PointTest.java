import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.frank.martin.geolib.GeoPoint;

class PointTest {

	@Test
	void test() {
		GeoPoint origin = new GeoPoint();
		GeoPoint origin2 = new GeoPoint(0,0);
		
		assertTrue(origin.equals(origin2));
				
//		fail("Not yet implemented");
	}

}
