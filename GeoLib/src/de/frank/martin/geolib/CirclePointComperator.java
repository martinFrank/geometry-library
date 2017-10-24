package de.frank.martin.geolib;

import java.util.Comparator;

public class CirclePointComperator implements Comparator<GeoPoint>{

	private final GeoPoint center;

	public CirclePointComperator(GeoPoint center){
		this.center = center;
	}
	
	public CirclePointComperator(int cx, int cy){
		this(new GeoPoint(cx, cy) );
	}
	public CirclePointComperator(){
		this(new GeoPoint(0,0) );
	}
	
	@Override
	public int compare(GeoPoint o1, GeoPoint o2) {
		
		GlPolarPoint p1 =  new GlPolarPoint(o1, center);
		GlPolarPoint p2 =  new GlPolarPoint(o2, center);
		return p1.compareTo(p2);
	}
	
	private class GlPolarPoint implements Comparable<GlPolarPoint>{
		private double tetha;
		public GlPolarPoint(GeoPoint point, GeoPoint center) {
			int dx = point.x() - center.x();
			int dy = point.y() - center.y();			
			tetha = Math.atan2(dy, dx);			
		}

		@Override
		public int compareTo(GlPolarPoint o) {
			return Double.compare(tetha, o.tetha);
		}
		
	}
}