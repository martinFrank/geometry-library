package de.elite.games.geolib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

	@Test
	public void test() {
		GeoPoint origin = new GeoPoint();
		GeoPoint origin2 = new GeoPoint(0, 0);
		assertEquals(origin, origin2);
	}

}
