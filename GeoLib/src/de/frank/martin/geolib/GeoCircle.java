package de.frank.martin.geolib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeoCircle {
	
	//https://en.wikipedia.org/wiki/Midpoint_circle_algorithm
	
	public static List<GeoPoint> getCircle(int x0, int y0, int radius){
		List<GeoPoint> circle = new ArrayList<GeoPoint>();
		
		int x = 0;
		int y = radius;
		int dp = 1 - radius;
		do
		{
			if (dp < 0)
				dp = dp + 2 * (++x) + 3;
			else
				dp = dp + 2 * (++x) - 2 * (--y) + 5;
			circle.add(new GeoPoint(x0 + x, y0 + y));     //For the 8 octants
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

}
