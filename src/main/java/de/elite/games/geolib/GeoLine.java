package de.elite.games.geolib;

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
		int x0 =  start.getX();
		int y0 =  start.getY();		
		int x1 = target.getX();
		int y1 = target.getY();		
		int sx = 0;
		int sy = 0;		
		int dx =  Math.abs(x1-x0);
		sx = x0 < x1 ? 1 : -1;
		int dy = -1 * Math.abs(y1-y0);
		sy = y0 < y1 ? 1 : -1; 
		int err = dx+dy;
		int e2; /* error value e_xy */		 
		while(true){ 
			ret.add( new GeoPoint(x0,y0) );
			if (x0==x1 && y0==y1) {
				break;
			}
			e2 = 2*err;
			if (e2 >= dy) { err += dy; x0 += sx; } /* e_xy+e_x > 0 */
			if (e2 <= dx) { err += dx; y0 += sy; } /* e_xy+e_y < 0 */
		}		
		return ret;
	}
	
	/**
	 * distance between two points (length of line)
	 * (length as double-precise by pythagoras algorithm)
	 * @param from
	 * @param to 
	 * @return length of line
	 */
	public static double distance(GeoPoint from, GeoPoint to){
		return distance(from.getX(), from.getY(), to.getX(),to.getY());
	}
	
	/**
	 * distance between two points (length of line)
	 * (length as double-precise by pythagoras algorithm)
	 * @param fromx x of point p1
	 * @param fromy y of point p1
	 * @param tox x of point p2
	 * @param toy y of point p2
	 * @return length of line
	 */
	public static double distance (int fromx, int fromy, int tox, int toy){
        int dx = tox - fromx;
        int dy = toy - fromy;
		return Math.sqrt((dx*dx)+(dy*dy));
	}
}
