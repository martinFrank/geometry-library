package de.frank.martin.geolib;

import java.util.Comparator;

/**
 * Comparator to sort List<GeoPoint> clockwise (requires a center)
 * @author martinFrank
 *
 */
public class CirclePointComperator implements Comparator<GeoPoint>{

	/**
	 * center to which the points are compared - default = 0/0
	 */
	private final GeoPoint center;

	/**
	 * comparator with non-default center (default would have been 0/0)
	 * @param center
	 */
	public CirclePointComperator(GeoPoint center){
		this.center = center;
	}
	
	/**
	 * comparator with non-default center (default would have been 0/0)
	 * @param cx
	 * @param cy
	 */
	public CirclePointComperator(int cx, int cy){
		this(new GeoPoint(cx, cy) );
	}
	
	/**
	 * comparator with default center (0/0)
	 */
	public CirclePointComperator(){
		this(new GeoPoint(0,0) );
	}
	
	@Override
	public int compare(GeoPoint o1, GeoPoint o2) {		
		GlPolarPoint p1 =  new GlPolarPoint(o1, center);
		GlPolarPoint p2 =  new GlPolarPoint(o2, center);
		return p1.compareTo(p2);
	}
	
	/**
	 * polarpoints represent a point with angle/distance<br>
	 * they are equal to carthesian points(x/y)
	 * @author martinFrank
	 *
	 */
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			long temp;
			temp = Double.doubleToLongBits(tetha);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GlPolarPoint other = (GlPolarPoint) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			return (Double.doubleToLongBits(tetha) != Double.doubleToLongBits(other.tetha));
		}
		
		private CirclePointComperator getOuterType() {
			return CirclePointComperator.this;
		}
		
	}
}