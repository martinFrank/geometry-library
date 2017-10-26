package de.frank.martin.geolib;

import java.util.ArrayList;
import java.util.List;

/**
 * this class provides a method to calculate a line from GeoPoint a to GeoPoint b 
 * (bresenham algorithm)
 * 
 * @author martinFrank
 *
 */
public final class GeoLine {	
	
	/**
	 * private Constructor - not required<br>
	 * use getLine() instead 
	 */
	private GeoLine() {
		//final construtor
	}

	/**
	 * calculates a line from start to end - if start.equals(end) the line is the 
	 * size of 1, otherwise it's longer.
	 * 
	 * @param start
	 * @param target
	 * @return the line as List
	 */	
	public static List<GeoPoint> getLine(GeoPoint start, GeoPoint target) {
		ArrayList<GeoPoint> ret = new ArrayList<>();		
		int x0 =  start.x();
		int y0 =  start.y();		
		int x1 = target.x();
		int y1 = target.y();		
		int sx = 0;
		int sy = 0;
		
		int dx =  Math.abs(x1-x0);
		sx = x0<x1 ? 1 : -1;
		int dy = -1*Math.abs(y1-y0);
		sy = y0<y1 ? 1 : -1; 
		int err = dx+dy;
		int e2; /* error value e_xy */
		 
		for(;;){  /* loop */
			ret.add( new GeoPoint(x0,y0) );
			if (x0==x1 && y0==y1) break;
			e2 = 2*err;
			if (e2 >= dy) { err += dy; x0 += sx; } /* e_xy+e_x > 0 */
			if (e2 <= dx) { err += dx; y0 += sy; } /* e_xy+e_y < 0 */
		}
		//this code line add the endpoint		
		return ret;
	}
	
	/**
	 * distance between two points (length of line)
	 * (length as double by pythagoras)
	 * @param p1
	 * @param p2 
	 * @return length of line
	 */
	public static double distance(GeoPoint p1, GeoPoint p2){
		return distance(p1.x(), p1.y(), p2.x(),p2.y());
	}
	
	/**
	 * distance between two points (length of line)
	 * (length as double by pythagoras)
	 * @param x1 x of point p1
	 * @param y1 y of point p1
	 * @param x2 x of point p2
	 * @param y2 y of point p2
	 * @return length of line
	 */
	public static int distance (int x1, int y1, int x2, int y2){
		int dx = x2-x1;
		int dy = y2-y1;		
		int cSqu = (dx*dx)+(dy*dy);		
		return (int)(Math.sqrt(cSqu));
	}
}
