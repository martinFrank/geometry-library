package de.elite.games.geolib;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LineTest {

    @Test
    public void lineTest() {
        GeoPoint a = new GeoPoint(0, 0);
        GeoPoint b = new GeoPoint(3, 3);

        List<GeoPoint> line = GeoLine.getLine(a, b);
        Assert.assertEquals(4, line.size());

        Assert.assertTrue(line.contains(new GeoPoint(0, 0)));
        Assert.assertTrue(line.contains(new GeoPoint(1, 1)));
        Assert.assertTrue(line.contains(new GeoPoint(2, 2)));
        Assert.assertTrue(line.contains(new GeoPoint(3, 3)));
    }

    @Test
    public void lineTest2() {
        GeoPoint a = new GeoPoint(0, 0);
        GeoPoint b = new GeoPoint(5, 2);

        List<GeoPoint> line = GeoLine.getLine(a, b);
        Assert.assertEquals(6, line.size());

        Assert.assertTrue(line.contains(new GeoPoint(0, 0)));
        Assert.assertTrue(line.contains(new GeoPoint(1, 0)));
        Assert.assertTrue(line.contains(new GeoPoint(2, 1)));
        Assert.assertTrue(line.contains(new GeoPoint(3, 1)));
        Assert.assertTrue(line.contains(new GeoPoint(4, 2)));
        Assert.assertTrue(line.contains(new GeoPoint(5, 2)));
    }
}
