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
}
