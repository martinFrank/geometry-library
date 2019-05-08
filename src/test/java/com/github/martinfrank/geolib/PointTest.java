package com.github.martinfrank.geolib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

	@Test
    public void testEqualLocation() {
		GeoPoint origin = new GeoPoint();
		GeoPoint origin2 = new GeoPoint(0, 0);
		assertEquals(origin, origin2);

        GeoPoint p1 = new GeoPoint(2, 2);
        GeoPoint p2 = new GeoPoint(2, 2);
        assertEquals(p1, p2);
	}

}
