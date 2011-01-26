package pku.deviceInformationAccess.driverManager;

import pku.deviceInformationAccess.locationProvider.LocationProvider;
import pku.deviceInformationAccess.locationProvider.UnifiedLocationProvider;
import pku.deviceInformationAccess.locationProvider.WiFiLocaitonProvider;

public class UnifiedLocationDriver extends LocationDriver
{
	static 
	{
	    try 
	    {
	    	DriverManager.registerLocationDriver(new UnifiedLocationDriver());
	    } 
	    catch (Exception E)
	    {
	         throw new RuntimeException("Can't register driver!");
	    }
	}
	@Override
	LocationProvider getLocationProvider(String arg)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	LocationProvider getLocationProvider(String url, String userName,
			String password)
	{
		locationProvider = new UnifiedLocationProvider(url,userName,password);
		return locationProvider;
	}

}
