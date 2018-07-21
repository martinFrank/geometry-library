package de.frank.martin.geolib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this class provides a method to calculate a circle from center and a radius
 * (bresenham algortihm)
 * 
 * see also https://en.wikipedia.org/wiki/Midpoint_circle_algorithm
 * 
 * @author martinFrank
 *
 */
public class GeoCircle {

	/**
	 * private Constructor - not required<br>
	 * use getCircle() instead
	 */
	private GeoCircle() {
	}

	/**
	 * creates a circle by given center and radius
	 * 
	 * @param x0 - x of center
	 * @param y0 - y of center
	 * @param radius
	 * @return a list of points representing a circle (sorted clockwise)
	 */
	public static List<GeoPoint> getCircle(int x0, int y0, int radius) {
		List<GeoPoint> circle = new ArrayList<>();
		int x = 0;
		int y = radius;
		int dp = 1 - radius;
		do {
			if (dp < 0) {
				dp = dp + 2 * (++x) + 3;
			} else {
				dp = dp + 2 * (++x) - 2 * (--y) + 5;
			}
			circle.add(new GeoPoint(x0 + x, y0 + y)); // For the 8 octants
			circle.add(new GeoPoint(x0 - x, y0 + y));
			circle.add(new GeoPoint(x0 + x, y0 - y));
			circle.add(new GeoPoint(x0 - x, y0 - y));
			circle.add(new GeoPoint(x0 + y, y0 + x));
			circle.add(new GeoPoint(x0 - y, y0 + x));
			circle.add(new GeoPoint(x0 + y, y0 - x));
			circle.add(new GeoPoint(x0 - y, y0 - x));
		} while (x < y);
		CirclePointComperator cc = new CirclePointComperator(x0, y0);
		Collections.sort(circle, cc);
		return circle;
	}

	/**
	 * creates a circle by given center and radius
	 * 
	 * @param center
	 * @param radius
	 * @return a list of points representing a circle (sorted clockwise)
	 */
	public static List<GeoPoint> getCircle(GeoPoint center, int radius) {
		return getCircle(center.getX(), center.getY(), radius);
	}

}
