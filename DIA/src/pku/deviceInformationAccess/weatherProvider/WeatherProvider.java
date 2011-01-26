package pku.deviceInformationAccess.weatherProvider;

import java.util.Set;

import pku.deviceInformationAccess.weather.Weather;

public interface WeatherProvider
{
	public Weather getWeather(String cityName);
	/*
	Get the weather of given city.
	*/
	public Set <String> getSupportProvice();
	/*
	Get all the provices the web service provider support.
	*/
	public Set <String> getSupportCity ();
	/*
	Get all the cities the web service provider support. 
	*/

}
