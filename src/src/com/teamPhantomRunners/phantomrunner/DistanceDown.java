package com.teamPhantomRunners.phantomrunner;

/**
 * This class instance object is loaded with a preset distance and as the user
 * travels the distance is subtracted until it reaches zero and notifies the
 * system
 * 
 * @author Ian
 *
 */
public class DistanceDown {

	/**
	 * distanceLeft represents how far the user has run and will be
	 * displayed on the map
	 * 
	 * distanceTotal represents how far the has run
	 */
	private double distanceLeft;
	private double distanceTotal;
	
	/**
	 * Class constructor initializes currentDistance according to the parameter
	 */
	public DistanceDown(double goal){
		distanceLeft = goal;
		distanceTotal = 0;
	}
	
	/**
	 * Accessor for distanceLeft
	 * @return distanceLeft
	 */
	public double getDistance(){
		return distanceLeft;
	}
	
	/**
	 * Accessor for distanceTotal
	 * @return distanceTotal
	 */
	public double getDistanceTotal(){
		return distanceTotal;
	}
	
	/**
	 * Calculates how far the user has left to go every time the GPS returns the
	 * users current coordinates.
	 * 
	 * Uses the haversin formula
	 * 
	 *  @param route locale
	 */
	public void removeDistance(Route locale){
		
		int R = 6371; // km
		
		double lat1, lat2, lon1, lon2;
		
		lat1 = locale.getPreviousLat();
		lat2 = locale.getCurrentLat();
		lon1 = locale.getPreviousLong();
		lon2 = locale.getCurrentLong();
		
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
				   Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		double d = R*c;
		
		distanceLeft = distanceLeft - d;
		distanceTotal = distanceTotal + d;
	}
}