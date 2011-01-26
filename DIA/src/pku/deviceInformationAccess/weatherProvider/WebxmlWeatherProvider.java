package pku.deviceInformationAccess.weatherProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pku.deviceInformationAccess.weather.Weather;
import pku.deviceInformationAccess.webServices.IWeatherReport;
import pku.deviceInformationAccess.webServices.WeatherReport;

public class WebxmlWeatherProvider implements WeatherProvider
{
	String url;
	String userName;
	String password;
	Connection conn;
	
	public WebxmlWeatherProvider(String url, String userName, String password) 
	{
		super();
		this.url = url;
		this.userName = userName;
		this.password = password;
		try
		{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			this.conn=DriverManager.getConnection(url, userName, password);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public WebxmlWeatherProvider(String arg)
	{
		super();
		DataSource ds;
		Context ctx;
		try
		{
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup(arg);
			
			this.conn = ds.getConnection();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		
		
	}
	/*
	Get the weather of given city.
	*/
	public Weather getWeather(String cityName)
	{
		IWeatherReport ir = new WeatherReport();
		String[] ss = ir.getWeather(cityName);
		String state = ss[7];
		String temperature = ss[8];
		String description= ss[6];
		Weather w = new Weather(state,temperature,description);
		return w;
		
	}

	/*
	Get all the provices the web service provider support.
	*/
	public Set <String> getSupportProvice()
	{
		return null;
		
	}
	/*
	Get all the cities the web service provider support. 
	*/
	public Set <String> getSupportCity ()
	{
		return null;
		
	}

}
