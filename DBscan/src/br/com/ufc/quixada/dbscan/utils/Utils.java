package br.com.ufc.quixada.dbscan.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.ufc.quixada.dbscan.model.Point;

public class Utils {

	public Timestamp getTime(String time){
		Timestamp timestamp = null;
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    Date parsedDate = dateFormat.parse(time);
		    timestamp = new java.sql.Timestamp(parsedDate.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return timestamp;
	}
	
	public List<Point> regionQuery(double eps, Point point, List<Point> dataSet){
		
		for (Point p : dataSet) {
			double result = getEuclidean(point.getLongitude(), point.getLatitude(), p.getLongitude(), p.getLatitude());
			System.out.println(result);
		}
		
		return null;
	}
	
	public double getEuclidean(double longitudePoint, double latitudePoint, double longitudeOther, double latitudeOther){
		double euclidean = 0.0;
		double  xDiff = longitudePoint - longitudeOther;
	    double  xSqr  = Math.pow(xDiff, 2);

		double yDiff = latitudePoint - latitudeOther;
		double ySqr = Math.pow(yDiff, 2);

		euclidean  = Math.sqrt(xSqr + ySqr);
		return euclidean;
	}
	
}
