package com.github.martinfrank.geolib;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CircleTest {

    @Test
    public void circleTest() {
        GeoPoint center = new GeoPoint();
        List<GeoPoint> circle = GeoCircle.getCircle(center, 2);

        for (GeoPoint point : circle) {
            System.out.println(point);
        }

        Assert.assertTrue(circle.contains(new GeoPoint(0, 2)));
        Assert.assertTrue(circle.contains(new GeoPoint(2, 0)));
        Assert.assertTrue(circle.contains(new GeoPoint(0, -2)));
        Assert.assertTrue(circle.contains(new GeoPoint(-2, 0)));

    }
}
