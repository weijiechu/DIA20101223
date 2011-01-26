package Test;

import pku.deviceInformationAccess.driverManager.DriverManager;
import pku.deviceInformationAccess.location.Zone;
import pku.deviceInformationAccess.sensorProvider.SensorProvider;

public class TestSensor {
	public static void main(String[]args)
	{
		try
		{
			Class.forName("pku.deviceInformationAccess.driverManager.SensorDriver");
			SensorProvider s = (SensorProvider) DriverManager.getSensorProvider
			("jdbc:sqlserver://192.168.213.112:1433;DatabaseName=DevicesData", "sa", "1234");
			Zone z = new Zone(2,"10 building");
			//s.getGasStatue(z);
			//s.getHumidity(z);
			//s.getTemperature(z);
			//System.out.println(s.getTemperature(z));
			//System.out.println(s.getHumidity(z));
			//System.out.println(s.getGasStatue(z));
			s.sendLightCommand(z, "off");
			
			//s.sendCommand(z, "on", "fan");
			//s.sendLightCommand(z, "on");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
