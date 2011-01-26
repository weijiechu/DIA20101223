package Test;

import java.util.Iterator;
import java.util.Set;

import pku.deviceInformationAccess.driverManager.DriverManager;
import pku.deviceInformationAccess.eventListener.TerminalDepartEventListener;
import pku.deviceInformationAccess.eventListener.TerminalDetectedEventListener;
import pku.deviceInformationAccess.eventsSource.BlipZoneEventSource;
import pku.deviceInformationAccess.eventsSource.WiFiZoneEventSource;
import pku.deviceInformationAccess.eventsSource.ZoneEventSource;
import pku.deviceInformationAccess.location.Zone;
import pku.deviceInformationAccess.locationProvider.LocationProvider;
import pku.deviceInformationAccess.terminal.Terminal;

public class TestBlipDIA
{
	public static void main(String[] args) throws InterruptedException
	{
		try
		{
			Class.forName("pku.deviceInformationAccess.driverManager.BlipLocationDriver");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocationProvider locationProvider = DriverManager.getLocationProvider
		("jdbc:sqlserver://192.168.23.126:1433;DatabaseName=BluetoothSystem", "sa", "1234");
		Zone z = locationProvider.getZone(3);
		System.out.println(z.getZoneDescription());
		Set<Zone> s = locationProvider.getAllZone();
		System.out.println(s.size());
		
		Set<Terminal> ts = locationProvider.getTerminalByName("#mobile1");
		Iterator it = ts.iterator();
		Terminal t=null;
		while(it.hasNext())
		{
			t = (Terminal)it.next();
			System.out.println(t.getFriendlyName());
			
		}
		System.out.println(locationProvider.getLocation(t));
		locationProvider.getTerminalPath(t);
		ZoneEventSource zes = new BlipZoneEventSource(locationProvider, z);
		TerminalDepartEventListener l1 = new TerminalDepartEventListener();
		TerminalDetectedEventListener l2 = new TerminalDetectedEventListener();
		zes.addListener(l1);
		zes.addListener(l2);
		zes.activateEventSource();
	
		
	}
}
