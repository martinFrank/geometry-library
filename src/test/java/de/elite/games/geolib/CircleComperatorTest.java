package de.elite.games.geolib;

import org.junit.Assert;
import org.junit.Test;

public class CircleComperatorTest {

    @Test
    public void testComperator() {
        GeoPoint p1 = new GeoPoint(1, 1);
        GeoPoint p2 = new GeoPoint(2, 2);

        CirclePointComperator cc = new CirclePointComperator();
        Assert.assertEquals(1, cc.compare(p1, p2));
    }

    @Test
    public void testPolarPoints() {
        GeoPoint p1 = new GeoPoint(1, 1);
        GeoPoint p2 = new GeoPoint(2, 2);
        GeoPoint center = new GeoPoint();
        CirclePointComperator.GlPolarPoint pp1 = new CirclePointComperator().new GlPolarPoint(p1, center);
        CirclePointComperator.GlPolarPoint pp2 = new CirclePointComperator().new GlPolarPoint(p2, center);

        Assert.assertNotEquals(pp1, pp2);
        Assert.assertNotEquals(pp1, null);
        Assert.assertNotEquals(pp1, "hello");
        Assert.assertNotEquals(pp1.hashCode(), pp2.hashCode());
        Assert.assertEquals(pp1, pp1);

    }
}
