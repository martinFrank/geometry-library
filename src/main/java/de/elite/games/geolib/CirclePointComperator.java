package de.elite.games.geolib;

import java.util.Comparator;

/**
 * Comparator to sort List<GeoPoint> clockwise (requires a center)
 * @author martinFrank
 *
 */
class CirclePointComperator implements Comparator<GeoPoint>{

	/**
	 * center to which the points are compared - default = 0/0
	 */
	private final GeoPoint center;

	/**
	 * comparator with non-default center (default would have been 0/0)
	 * @param center
	 */
    CirclePointComperator(GeoPoint center){
		this.center = center;
	}
	
	/**
	 * comparator with non-default center (default would have been 0/0)
	 * @param cx
	 * @param cy
	 */
	CirclePointComperator(int cx, int cy){
		this(new GeoPoint(cx, cy) );
	}
	
	/**
	 * comparator with default center (0/0)
	 */
	CirclePointComperator(){
		this(new GeoPoint(0,0) );
	}
	
	@Override
	public int compare(GeoPoint o1, GeoPoint o2) {		
		GlPolarPoint p1 =  new GlPolarPoint(o1, center);
		GlPolarPoint p2 =  new GlPolarPoint(o2, center);
		return p1.compareTo(p2);
	}
	
	/**
	 * polar points represent a point with angle/distance<br>
	 * they are equal to Cartesian points(x/y)
	 * @author martinFrank
	 *
	 */
	private class GlPolarPoint implements Comparable<GlPolarPoint>{
		private double tetha;
		private double length;
		public GlPolarPoint(GeoPoint point, GeoPoint center) {
			int dx = point.getX() - center.getX();
			int dy = point.getY() - center.getY();			
			tetha = Math.atan2(dy, dx);
			length = GeoLine.distance(point, center);
		}

		@Override
		public int compareTo(GlPolarPoint o) {
			int d = Double.compare(tetha, o.tetha);
			if(d == 0){
				return Double.compare(length, o.length);
			}else{
				return d;
			}
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			GlPolarPoint that = (GlPolarPoint) o;

			if (Double.compare(that.tetha, tetha) != 0) return false;
			return Double.compare(that.length, length) == 0;
		}

		@Override
		public int hashCode() {
			int result;
			long temp;
			temp = Double.doubleToLongBits(tetha);
			result = (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(length);
			result = 31 * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
	}
}