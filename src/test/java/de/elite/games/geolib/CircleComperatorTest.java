package de.elite.games.geolib;

import org.junit.Assert;
import org.junit.Test;

public class CircleComperatorTest {

    @Test
    public void testComperator() {
        GeoPoint p0 = new GeoPoint(0, 2);
        GeoPoint p1 = new GeoPoint(1, 1);

        CirclePointComperator cc = new CirclePointComperator();
        Assert.assertEquals(1, cc.compare(p0, p1));
    }

    @Test
    public void testPolarPoints() {
        GeoPoint p0 = new GeoPoint(0, 2);
        GeoPoint p1 = new GeoPoint(1, 1);
        GeoPoint center = new GeoPoint();
        CirclePointComperator.GlPolarPoint pp0 = new CirclePointComperator.GlPolarPoint(p0, center);
        CirclePointComperator.GlPolarPoint pp1 = new CirclePointComperator.GlPolarPoint(p1, center);
        Assert.assertNotEquals(pp0, pp1);
        Assert.assertNotEquals(pp0.hashCode(), pp1.hashCode());
    }
}
