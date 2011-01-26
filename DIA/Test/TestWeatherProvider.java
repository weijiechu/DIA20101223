package Test;

import pku.deviceInformationAccess.driverManager.DriverManager;
import pku.deviceInformationAccess.weather.Weather;
import pku.deviceInformationAccess.weatherProvider.WeatherProvider;

public class TestWeatherProvider
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName("pku.deviceInformationAccess.driverManager.WebxmlWeatherDriver");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WeatherProvider wp = DriverManager.getWeathernProvider("aaa");
		Weather w = wp.getWeather("±±¾©");
		System.out.println(w.getState());
		
	}

}
