package pku.deviceInformationAccess.driverManager;

import pku.deviceInformationAccess.weatherProvider.WeatherProvider;
import pku.deviceInformationAccess.weatherProvider.WebxmlWeatherProvider;

public class WebxmlWeatherDriver extends WeatherDriver
{
	static 
	{
	    try 
	    {
	    	DriverManager.registerWeatherDriver(new WebxmlWeatherDriver());
	    } 
	    catch (Exception E)
	    {
	         throw new RuntimeException("Can't register driver!");
	    }
	}
	@Override
	WeatherProvider getWeatherProvider(String arg)
	{
		// TODO Auto-generated method stub
		return new WebxmlWeatherProvider(arg);
	}

	@Override
	WeatherProvider getWeatherProvider(String url, String userName,
			String password)
	{
		// TODO Auto-generated method stub
		return new WebxmlWeatherProvider(url,userName,password);
	}

}
