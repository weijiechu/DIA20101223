package pku.deviceInformationAccess.locationProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pku.deviceInformationAccess.location.Coordinates;
import pku.deviceInformationAccess.location.Location;
import pku.deviceInformationAccess.location.StayInZone;
import pku.deviceInformationAccess.location.Zone;
import pku.deviceInformationAccess.terminal.Bluetooth;
import pku.deviceInformationAccess.terminal.Terminal;
import pku.deviceInformationAccess.terminal.WiFiEquipment;

public class WiFiLocaitonProvider implements LocationProvider
{
	String url;
	String userName;
	String password;
	Connection conn;
	Map<Zone,TerminalsInZone> terminalsOfAllZones = new ConcurrentHashMap<Zone,TerminalsInZone>();
	
	public Terminal getTerminalByMAC(String mac)
	{
		//Set<Terminal> result = new HashSet<Terminal>();
		PreparedStatement select;
		Terminal t=null;
		String sql ="Select ID,FriendlyName,MAC from EquipmentTerminal where MAC = '"+mac+"'";
		try
		{
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("ID");
				String friendlyName = rs.getString("FriendlyName");
				//String mac = rs.getString("MAC");
				 t = new Terminal(friendlyName,id,mac);
				//result.add(t);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return t;
	}
	public WiFiLocaitonProvider(String url, String userName, String password) 
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
	public WiFiLocaitonProvider(String arg)
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


	public Set<Terminal> getAllTerminals(Zone zone)
	{
		PreparedStatement select;
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		//���ȣ���̬���ɱ���
		String tableName =  "WEFound"+date;
		//��ѯ���µ�BatchNum
		int BatchNum = -2;
		String sql0 = "SELECT MAX(BatchNum) as max FROM "+tableName;
		//System.out.println(sql0);
		try
		{
			select = conn.prepareStatement(sql0);
			ResultSet rs= select.executeQuery();
			if(rs.next())
			{
				BatchNum= rs.getInt("max");
				//System.out.println("Now BatchNum = "+BatchNum);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		if(!terminalsOfAllZones.containsKey(zone))//������Ǹ�Zone�ĵ�һ�β�ѯ
		{
			//System.out.println("first");
			TerminalsInZone tiz = new TerminalsInZone();
			tiz.batchNum = BatchNum;
			terminalsOfAllZones.put(zone,tiz);//�����¼�в����µļ�¼
		}
		else//���ǵ�һ�β�ѯ
		{
			TerminalsInZone tiz = terminalsOfAllZones.get(zone);
			//System.out.println("tiz.batchNum = "+tiz.batchNum);
			if(BatchNum>tiz.batchNum)//�²�������Ϣ
			{
				tiz.batchNum = BatchNum;
				String sql = "Select WiFiID,FriendlyName,MAC,Time FROM "+tableName+",WiFiEquipment"
				+" WHERE "+tableName+".ZoneID = "+zone.getZoneID()
				+" AND WiFiID = WiFiEquipment.ID"
				+ " AND BatchNum = "+ BatchNum;//���serverû�������������豸���򲻻᷵����Ϣ
				//System.out.println(sql);
				try
				{
					select = conn.prepareStatement(sql);
					ResultSet rs= select.executeQuery();
					
					tiz.terminals = new HashSet<Terminal>();//ʹ���µ�Set
					while(rs.next())
					{
						int id = rs.getInt("WiFiID");
						String friendlyName = rs.getString("FriendlyName");
						//System.out.println(friendlyName);
						String mac = rs.getString("MAC");
						Terminal bt = new WiFiEquipment(friendlyName,id,mac);
						//System.out.println(friendlyName);
						tiz.terminals.add(bt);//һ����ӱ��εļ�¼
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
		TerminalsInZone tiz = terminalsOfAllZones.get(zone);
		return tiz.terminals;
	}



	public Set<Zone> getAllZone()
	{
		String sql = "SELECT ID FROM ZoneInformation";
		Set<Zone> set = new HashSet<Zone>();
		try
		{
			PreparedStatement select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("ID");
				
				Zone z = this.getZone(id);
				set.add(z);
				
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}



	public Location getLocation(Terminal terminal)
	{
		PreparedStatement select;
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		//���ȣ���̬���ɱ���
		String tableName =  "WEFound"+date;
		//��ѯ���µ�BatchNum
		int BatchNum = -1;
		String sql = "SELECT MAX(BatchNum) as max FROM "+tableName;
		//System.out.println(sql0);
		try
		{
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			if(rs.next())
			{
				BatchNum= rs.getInt("max");
				//System.out.println("Now BatchNum = "+BatchNum);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		sql = "SELECT Time,ZoneID,X,Y FROM "+tableName+
		" WHERE BatchNum ="+BatchNum+" AND WiFiID = "+terminal.getId();;
		//System.out.println(sql);
		try
		{
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				Date time = rs.getDate("Time");
				int zoneID = rs.getInt("ZoneID");
				double x = rs.getFloat("X");
				double y = rs.getFloat("Y");
				Coordinates c = new Coordinates(x,y);
				Zone z = this.getZone(zoneID);
				Location l = new Location(z,c,time);
				return l;
				
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	public Set<Terminal> getTerminalByName(String name)
	{
		Set<Terminal> result = new HashSet<Terminal>();
		PreparedStatement select;
		String sql ="Select ID,FriendlyName,MAC from WiFiEquipment where FriendlyName = '"+name+"'";
		//System.out.println(sql);
		try
		{
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("ID");
				String friendlyName = rs.getString("FriendlyName");
				String mac = rs.getString("MAC");
				Terminal t = new WiFiEquipment(friendlyName,id,mac);
				result.add(t);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}



	public List<StayInZone> getTerminalPath(Terminal terminal)
	{
		List<StayInZone> path = new LinkedList();
		WiFiEquipment we =(WiFiEquipment)terminal;
		PreparedStatement select;
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		//���ȣ���̬���ɱ���
		String tableName =  "WEFound"+date;
		String sql = "Select ZoneID,ZoneDescription,Time,X,Y from "+tableName+",ZoneInformation where WiFIID ="
					+we.getId()+" and ZoneInformation.ID = "+tableName+".ZoneID";
		try
		{
			select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("ZoneID");
				Date time = rs.getDate("Time");
				double x = rs.getFloat("X");
				double y = rs.getFloat("Y");
				String zoneDescription = rs.getString("ZoneDescription");
				Zone z = this.getZone(id);
				Coordinates c = new Coordinates(x,y);
				Location l = new Location(z,c,time);
				if(path.isEmpty())//����ǿ�
				{
					StayInZone siz = new StayInZone();
					siz.setEnterLocation(l);
					siz.setLeaveLoaction(l);
					path.add(siz);
					continue;
				}
				else//�������
				{
					int last = path.size()-1;//���һ��
					StayInZone lastStayInZone = path.get(last);
					Location lastZone = (Location) lastStayInZone.getEnterLocation();
					if(lastZone.getZone().getZoneID() == id)
					{
						lastStayInZone.setLeaveLoaction(l);
						continue;
					}
					else
					{
						StayInZone siz = new StayInZone();
						siz.setEnterLocation(l);
						siz.setLeaveLoaction(l);
						path.add(siz);
						continue;
					}
				}
			}
		}
		catch(Exception e)
		{
			e.toString();
		}
		/*try
		{
			conn.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return path;
	}



	public Zone getZone(int id)
	{
		String sql = "SELECT ID,SuperZoneID,ZoneDescription FROM ZoneInformation WHERE ID = "+id;
		int superZoneID=0;
		Zone z=null;
		try
		{
			PreparedStatement select = conn.prepareStatement(sql);
			ResultSet rs= select.executeQuery();
			while(rs.next())
			{
				String zoneDescription = rs.getString("ZoneDescription");
				superZoneID = rs.getInt("SuperZoneID");
				z = new Zone(id,zoneDescription);
				
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(superZoneID>0&&z!=null)
		{
			Zone superZone = this.getZone(superZoneID);
			z.setSuperZone(superZone);
		}
		return z;
	}
	public Zone getZone(String zoneDescrpition)
	{
		// TODO Auto-generated method stub
		return null;
	}


}
