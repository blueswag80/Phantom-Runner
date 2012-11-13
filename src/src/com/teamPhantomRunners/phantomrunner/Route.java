package com.teamPhantomRunners.phantomrunner;

import java.util.LinkedList;


public class Route {
	private LinkedList<Location> route;
	private int lastLocationIndex;
	
	
	public Route()
	{
		route = new LinkedList<Location>();
		route.add(new Location());
		lastLocationIndex = 0;
	}
	
	public void updateRoute()
	{
		lastLocationIndex++;
		route.add(new Location());
	}
	
	public long getCurrentLat()
	{
		return route.get(lastLocationIndex).getLatitude();
	}
	public long getCurrentLong()
	{
		return route.get(lastLocationIndex).getLongitude();
	}
	public long getPreviousLat()
	{
		if (lastLocationIndex > 0)
			return route.get(lastLocationIndex-1).getLatitude();
		else
			return getCurrentLat();
	}
	public long getPreviousLong()
	{
		if (lastLocationIndex > 0)
			return route.get(lastLocationIndex-1).getLongitude();
		else
			return getCurrentLong();
	}
	
	public String getRoute()
	{
		//code for the route as a string
		return "not ready";
	}
	
}