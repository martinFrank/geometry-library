package de.frank.martin.geolib;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.frank.martin.geolib.GeoPoint;

public class PointTest {

	@Test
	public void test() {
		GeoPoint origin = new GeoPoint();
		GeoPoint origin2 = new GeoPoint(0,0);		
		assertTrue(origin.equals(origin2));
	}

}
