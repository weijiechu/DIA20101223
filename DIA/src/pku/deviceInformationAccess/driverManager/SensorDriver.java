package pku.deviceInformationAccess.driverManager;

import pku.deviceInformationAccess.locationProvider.BlipLocationProvider;
import pku.deviceInformationAccess.locationProvider.LocationProvider;
import pku.deviceInformationAccess.sensorProvider.ISensorProvider;
import pku.deviceInformationAccess.sensorProvider.SensorProvider;

public class SensorDriver {
	ISensorProvider sensorProvider;
	static 
	{
	    try 
	    {
	    	DriverManager.registerSensorProvider(new SensorDriver());
	    } 
	    catch (Exception E)
	    {
	         throw new RuntimeException("Can't register driver!");
	    }
	}

	public SensorDriver()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	ISensorProvider getSensorProvider(String arg)
	{
		sensorProvider = new SensorProvider(arg);
		return sensorProvider;
	}

	ISensorProvider getSensorProvider(String url, String userName,
			String password)
	{
		// TODO Auto-generated method stub
		sensorProvider = new SensorProvider(url,userName,password);
		return sensorProvider;
	}
	
}
