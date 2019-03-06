package de.elite.games.geolib;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PointTest {

	@Test
	public void test() {
		GeoPoint origin = new GeoPoint();
		GeoPoint origin2 = new GeoPoint(0,0);		
		assertTrue(origin.equals(origin2));
	}

}
