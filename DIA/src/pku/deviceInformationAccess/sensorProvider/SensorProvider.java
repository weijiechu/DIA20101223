package pku.deviceInformationAccess.sensorProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pku.deviceInformationAccess.location.Zone;

public class SensorProvider implements ISensorProvider {
	String url;
	String userName;
	String password;
	Connection conn;

	public SensorProvider(String url, String userName, String password) 
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
	public SensorProvider(String arg)
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
	public String getGasStatus(Zone zone) {
		// TODO Auto-generated method stub
		PreparedStatement select;
		String state="";
		String sql = "SELECT state from GasStateInformation,Sensor where Sensor.sensor = GasStateInformation.sensorID " +
				" and Sensor.zoneID = "+zone.getZoneID();
		try {
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				state= rs.getString("state");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return state;
	}

	public String getGasStatus(String terminalID) {
		// TODO Auto-generated method stub
		PreparedStatement select;
		String state="";
		String sql = "SELECT state from GasStateInformation where GasStateInformation.sensorID="+terminalID;
		try {
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				state= rs.getString("state");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return state;
	}
	public String getHumidity(Zone zone) {
		// TODO Auto-generated method stub
		PreparedStatement select;
		String state="";
		String sql = "SELECT humidity from HumidityInformation,Sensor where Sensor.sensor = HumidityInformation.sensorID " +
				" and Sensor.zoneID = "+zone.getZoneID();
		try {
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				state= rs.getString("humidity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return state;
	}
	
	public String getHumidity(String terminalID) {
		PreparedStatement select;
		String state="";
		String sql = "SELECT humidity from HumidityInformation where HumidityInformation.sensorID= " +terminalID;

		try {
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				state= rs.getString("humidity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return state;
	}

	public String getTemperature(Zone zone) {
		// TODO Auto-generated method stub
		PreparedStatement select;
		String state="";
		String sql = "SELECT temperature from TemperatureInformation,Sensor where Sensor.sensor = TemperatureInformation.sensorID " +
				" and Sensor.zoneID = "+zone.getZoneID();
		System.out.println(sql);
		try {
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				state= rs.getString("temperature");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return state;
	}
	public String getTemperature(String terminalID) {
		PreparedStatement select;
		String state="";
		String sql = "SELECT temperature from TemperatureInformation  where TemperatureInformation.sensorID= " +terminalID;
				
		System.out.println(sql);
		try {
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				state= rs.getString("temperature");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return state;
	}
	public String getSensorValue(Zone zone, String device) {
		if(device.equals("GasStatus")){
			return this.getGasStatus(zone);
		}
		else if(device.equals("Humidity")){
			return this.getHumidity(zone);
		}
		else if(device.equals("Temperature")){
			return this.getTemperature(zone);
		}
		else return null;
	}
	
	public String getSensorValue(String terminalID, String device) {
		if(device.equals("GasStatus")){
			return this.getGasStatus(terminalID);
		}
		else if(device.equals("Humidity")){
			return this.getHumidity(terminalID);
		}
		else if(device.equals("Temperature")){
			return this.getTemperature(terminalID);
		}
		else return null;
	}
	
	
	public String sendLightCommand(Zone zone, String command) {
		// TODO Auto-generated method stub
		PreparedStatement select;
		String id="";
		String sql = "select sensor from Sensor where zoneID = "+zone.getZoneID() +" and sensorKind = 'light'";
		System.out.println(sql);
		try {
			select = conn.prepareStatement(sql);

			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				id= rs.getString("sensor");
			}
			String update = "insert into sc values('"+id+"',"
			+"'"+command+"'"+","+"0)";
			System.out.println(update);
			select = conn.prepareStatement(update);
			select.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "done";
	}
	
	public String sendFanCommand(Zone zone, String command) {
		// TODO Auto-generated method stub
		PreparedStatement select;
		String id="";
		String sql = "select sensor from Sensor where zoneID = "+zone.getZoneID() +" and sensorKind = 'fan'";
		System.out.println(sql);
		try {
			select = conn.prepareStatement(sql);

			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				id= rs.getString("sensor");
			}
			String update = "insert into sc values('"+id+"',"
			+"'"+command+"'"+","+"0)";
			System.out.println(update);
			select = conn.prepareStatement(update);
			select.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "done";
	}
	public String sendHumidityCommand(Zone zone, String command) {
		// TODO Auto-generated method stub
		PreparedStatement select;
		String id="";
		String sql = "select sensor from Sensor where zoneID = "+zone.getZoneID() +" and sensorKind = 'humidity'";
		System.out.println(sql);
		try {
			select = conn.prepareStatement(sql);

			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				id= rs.getString("sensor");
			}
			String update = "insert into sc values('"+id+"',"
			+"'"+command+"'"+","+"0)";
			System.out.println(update);
			select = conn.prepareStatement(update);
			select.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "done";
	}
	public String sendCommand(Zone z, String command, String device) {
		// TODO Auto-generated method stub
		PreparedStatement select;
		String id="";
		String sql = "select sensor from Sensor where zoneID = "+z.getZoneID() +" and sensorKind = '"+device+"'";
		System.out.println(sql);
		try {
			select = conn.prepareStatement(sql);

			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				id= rs.getString("sensor");
			}
			String update = "insert into sc values('"+id+"',"
			+"'"+command+"'"+","+"0)";
			System.out.println(update);
			select = conn.prepareStatement(update);
			select.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "done";
	}
	public String sendCommand(String terminalID, String command, String device) {
		// TODO Auto-generated method stub
		PreparedStatement select;
		try {
			
			String update = "insert into sc values('"+terminalID+"',"
			+"'"+command+"'"+","+"0)";
			System.out.println(update);
			select = conn.prepareStatement(update);
			select.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "done";
	}
	
	

	
	
	
	

}
