package Test;

import java.util.List;
import java.util.Set;

import pku.deviceInformationAccess.driverManager.DriverManager;
import pku.deviceInformationAccess.location.Location;
import pku.deviceInformationAccess.location.Zone;
import pku.deviceInformationAccess.locationProvider.LocationProvider;
import pku.deviceInformationAccess.terminal.Terminal;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("pku.deviceInformationAccess.driverManager.UnifiedLocationDriver");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocationProvider locationProvider = DriverManager.getLocationProvider
		("jdbc:sqlserver://192.168.213.112:1433;DatabaseName=DevicesData", "sa", "1234");
		Zone z = locationProvider.getZone(2);
		String mac = "5F:2A:AB:8C:66:01";
		Terminal t = locationProvider.getTerminalByMAC(mac);
		System.out.println(t.getId());
		while(true)
		{
				
				Location l = locationProvider.getLocation(t);
				//System.out.println(z.getZoneDescription());
				if(l == null)
				{
					System.out.println("leave");
					continue;
				}
				System.out.println(l.getZone().getZoneDescription());
		
		}
		
	}

}
