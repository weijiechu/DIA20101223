package pku.deviceInformationAccess.driverManager;

import pku.deviceInformationAccess.locationProvider.LocationProvider;
import pku.deviceInformationAccess.sensorProvider.ISensorProvider;
import pku.deviceInformationAccess.weatherProvider.WeatherProvider;


public class DriverManager
{
	static LocationDriver locationDriver;
	static WeatherDriver weatherDriver;
	static SensorDriver sensorDriver;
	static void registerSensorProvider(SensorDriver sensorDriver)
	{
		DriverManager.sensorDriver =sensorDriver; 
		System.out.println("Register Driver.");
	}
	static void registerLocationDriver(LocationDriver locationDriver)
	{
		DriverManager.locationDriver =locationDriver; 
		System.out.println("Register Driver.");
	}
	public static LocationProvider getLocationProvider(String arg)
	{
		return locationDriver.getLocationProvider(arg);
	}
	public static ISensorProvider getSensorProvider(String url,String userName,String password)
	{
		return sensorDriver.getSensorProvider(url, userName, password);
	}
	public static LocationProvider getLocationProvider(String url,String userName,String password)
	{
		return locationDriver.getLocationProvider(url, userName, password);
	}
	static void registerWeatherDriver(WeatherDriver weatherDriver)
	{
		DriverManager.weatherDriver =weatherDriver; 
		System.out.println("Register Driver.");
	}
	public static WeatherProvider getWeathernProvider(String arg)
	{
		return weatherDriver.getWeatherProvider(arg);
	}
	public static WeatherProvider getWeathernProvider(String url,String userName,String password)
	{
		return weatherDriver.getWeatherProvider(url, userName, password);
	}
	
}
