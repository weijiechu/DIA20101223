package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pku.deviceInformationAccess.driverManager.DriverManager;
import pku.deviceInformationAccess.eventListener.TerminalDepartEventListener;
import pku.deviceInformationAccess.eventListener.TerminalDetectedEventListener;
import pku.deviceInformationAccess.eventsSource.WiFiZoneEventSource;
import pku.deviceInformationAccess.eventsSource.ZoneEventSource;
import pku.deviceInformationAccess.location.Location;
import pku.deviceInformationAccess.location.StayInZone;
import pku.deviceInformationAccess.location.Zone;
import pku.deviceInformationAccess.locationProvider.LocationProvider;
import pku.deviceInformationAccess.terminal.Terminal;
import pku.deviceInformationAccess.terminal.WiFiEquipment;

public class TestWifiDIA
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName("pku.deviceInformationAccess.driverManager.WiFiLocationDriver");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocationProvider locationProvider = DriverManager.getLocationProvider
		("jdbc:sqlserver://192.168.23.165:1433;DatabaseName=WiFiBasedPositioningSystem", "sa", "1234");
		
		Zone z = locationProvider.getZone(2);
		System.out.println(z.getSuperZone().getZoneID());
		
		
		Set<Zone> zs = locationProvider.getAllZone();
		Iterator it = zs.iterator();
		while(it.hasNext())
		{
			z = (Zone)it.next();
			System.out.println(z.getZoneDescription());
		}
		Set<Terminal> ts = locationProvider.getTerminalByName("wilson");
		Location l = locationProvider.getLocation((Terminal)ts.toArray()[0]);
		System.out.println(l);
		System.out.println(l.getCoordinates().getX());
		List<StayInZone> path = locationProvider.getTerminalPath((Terminal)ts.toArray()[0]);
		for(int i = 0 ;i< path.size();i++)
		{
			System.out.println(path.get(i).getEnterLocation().getZone().getZoneDescription());
			System.out.println(path.get(i).getEnterLocation().getCoordinates().getX());
		}
		System.out.println("**********************"+z.getZoneID());
		ZoneEventSource zes = new WiFiZoneEventSource(locationProvider, z);
		TerminalDepartEventListener l1 = new TerminalDepartEventListener();
		TerminalDetectedEventListener l2 = new TerminalDetectedEventListener();
		zes.addListener(l1);
		zes.addListener(l2);
		zes.activateEventSource();
		
		/*while(true)
		{
			Set<Terminal> ts= locationProvider.getAllTerminals(z);
			it = ts.iterator();
			while(it.hasNext())
			{
				Terminal t = (Terminal) it.next();
				System.out.println(t.getFriendlyName());
			}
			try
			{
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

}
