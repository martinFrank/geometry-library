package de.frank.martin.geolib;

import java.util.ArrayList;
import java.util.List;

public class GeoLine {

	public static List<GeoPoint> getLine(GeoPoint start, GeoPoint target) {
		ArrayList<GeoPoint> ret = new ArrayList<GeoPoint>();
		
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
		int err = dx+dy, e2; /* error value e_xy */
		 
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
	
	public static double distance(GeoPoint p1, GeoPoint p2){
		int dx = p2.x()-p1.x();
		int dy = p2.y()-p1.y();		
		int cSqu = (dx*dx)+(dy*dy);		
		double abs = Math.sqrt(cSqu);		
		return abs;
	}
	
	public static int distance (int x1, int y1, int x2, int y2){
		int dx = x2-x1;
		int dy = y2-y1;		
		int cSqu = (dx*dx)+(dy*dy);		
		int abs = (int)(Math.sqrt(cSqu));		
		return abs;
	}
}
