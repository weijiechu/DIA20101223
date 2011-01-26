package pku.deviceInformationAccess.webServices;

import java.net.URL;
import java.rmi.RemoteException;

import cn.com.WebXml.WeatherWSSoapStub;

public class WeatherReport implements IWeatherReport
{
	WeatherWSSoapStub wwss;
	
	public WeatherReport()
	{
		super();
		try
		{
			URL url = new URL("http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx");
			wwss =new WeatherWSSoapStub(url,
					new org.apache.axis.client.Service());
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] getWeather(String City)
	{
		// TODO Auto-generated method stub
		String[] result;
		try
		{
			result = wwss.getWeather(City, "");
			return result;
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

