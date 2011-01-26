package pku.deviceInformationAccess.sensorProvider;

import pku.deviceInformationAccess.location.Zone;

public interface ISensorProvider {
	String getTemperature(Zone zone);
	String getTemperature(String terminalID);
	String getHumidity(Zone zone);
	String getHumidity(String terminalID);
	String getGasStatus(Zone zone);
	String getGasStatus(String terminalID);
	
	String getSensorValue(Zone zone, String device);
	String getSensorValue(String terminalID, String device);
	
	String sendLightCommand(Zone zone,String command);
	String sendFanCommand(Zone zone,String command);
	String sendHumidityCommand(Zone zone,String command);
	
	String sendCommand(Zone z,String command,String device);
	String sendCommand(String terminalID,String command,String device);
}
