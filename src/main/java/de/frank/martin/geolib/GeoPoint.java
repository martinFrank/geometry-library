package de.frank.martin.geolib;

/**
 * this class is a simple Integer.2D-Point
 * 
 * @author martinFrank
 *
 */
public final class GeoPoint {

	/**
	 * ordinate
	 */
	private final int x;
	
	/**
	 * abscissa
	 */
	private final int y;
	
	/**
	 * constructor with x/y
	 * @param x ordinate
	 * @param y abscissa
	 */
	public GeoPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}	
	
	/**
	 * default constructor uses Origin (0/0) as x/y-coordinates
	 */
	public GeoPoint() {
		this(0,0);
	}
	
	/**
	 * @return the x-value of this point
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * @return the y-value of this point
	 */
	public int getY(){
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/**
	 * points are equal if x and y are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoPoint other = (GeoPoint) obj;
		if (x != other.x)
			return false;
		return (y == other.y);
	}

	@Override
	public String toString() {
		return "GeoPoint [x=" + x + ", y=" + y + "]";
	}
	
}
