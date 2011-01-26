package pku.deviceInformationAccess.driverManager;

import pku.deviceInformationAccess.locationProvider.LocationProvider;
import pku.deviceInformationAccess.weatherProvider.WeatherProvider;

public abstract class WeatherDriver
{
	static WeatherProvider weatherProvider;
	abstract WeatherProvider getWeatherProvider(String arg);
	abstract WeatherProvider getWeatherProvider(String url,String userName,String password);
}
