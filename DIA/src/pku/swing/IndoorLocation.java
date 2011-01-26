/*
 * IndoorLocation.java
 *
 * Created on __DATE__, __TIME__
 */

package pku.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import pku.deviceInformationAccess.location.*;
import pku.deviceInformationAccess.driverManager.DriverManager;
import pku.deviceInformationAccess.locationProvider.LocationProvider;
import pku.deviceInformationAccess.terminal.Terminal;

import lbs.api.InitMap;
import lbs.api.LocationInfoAccessImp;
import lbs.api.LocationUtil;
import lbs.entity.Region;
/**
 *
 * @author  __USER__
 */
class ContextLabel extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7218539741690786005L;
	String context;
	String zone;
	public ContextLabel()
	{
		super();
		// TODO Auto-generated constructor stub
	
	}

	public ContextLabel(Icon image, int horizontalAlignment)
	{
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public ContextLabel(Icon image)
	{
		super(image);
		// TODO Auto-generated constructor stub
	}

	public ContextLabel(String text, Icon icon, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public ContextLabel(String text, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public ContextLabel(Icon image,String text,String zone,int x,int y)
	{
		super(image);
		// TODO Auto-generated constructor stub
		this.context = text;
		this.zone =zone;
		this.setBounds(x, y, 5, 5);
	}
	public ContextLabel(Icon image,String text,int x,int y)
	{
		super(image);
		// TODO Auto-generated constructor stub
		this.context = text;
		
		this.setBounds(x, y, 5, 5);
	}
	/**
	 * @return the context
	 */
	public String getContext()
	{
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(String context)
	{
		this.context = context;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((zone == null) ? 0 : zone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContextLabel other = (ContextLabel) obj;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (zone == null) {
			if (other.zone != null)
				return false;
		} else if (!zone.equals(other.zone))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	
	/*public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ContextLabel))
			return false;
		ContextLabel other = (ContextLabel) obj;
		if (context == null)
		{
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		return true;
	}*/
	
	
}
public class IndoorLocation extends javax.swing.JFrame
{
	//
	public static status thisStatus = status.STOPM;
	JPanel p=new JPanel(); 
	JPanel p2=new JPanel();
	JLabel map;
	JLabel mouseEnterlabel;
	TextField tf1 = new TextField();
	TextField tf2 = new TextField();
	TextField tf3 = new TextField();
	public void drawLine(Point p1,Point p2)
	{
		
		//g.setColor(Color.GREEN);
		//Container   cp   =   getContentPane(); 
		map.getGraphics().drawLine(p1.x, p1.y, p2.x, p2.y);
		//cp.repaint(10);
	}
	public void drawPoint(ContextLabel label)
	{
		//ImageIcon imageIcon = new ImageIcon("map//point.jpg");
		//ContextLabel label = new ContextLabel(imageIcon);
		//label.setContext(context);
		label.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				LabelmouseEntered(evt);
			}
		});
		label.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseExited(java.awt.event.MouseEvent evt)
			{
				LabelmouseLeft(evt);
			}
		});
		//buttonStart.setLayout(null);
		/*label.setLocation(1, 1);
		label.setSize(600, 450);*/
		//label.setBounds(r);
		label.setVisible(true);
		/*System.out.println(label.getLocation().x+"   "+label.getLocation().y);
		System.out.println(label.getContext());*/
		map.add(label);
		label.repaint();
		
	}
	private void LabelmouseEntered(java.awt.event.MouseEvent evt)
	{
		ContextLabel cl = (ContextLabel)evt.getSource();
		Point p = cl.getLocation();
		System.out.println(cl.getContext());
		mouseEnterlabel = new JLabel();
		mouseEnterlabel.setText(cl.getContext());
		System.out.println(p.x);
		System.out.println(p.y);
		Rectangle rt = new Rectangle(p.x,p.y-10,200,20);
		mouseEnterlabel.setBounds(rt);
		mouseEnterlabel.setVisible(true);
		map.add(mouseEnterlabel);
		mouseEnterlabel.repaint();
	}
	private void LabelmouseLeft(java.awt.event.MouseEvent evt)
	{
		/*ContextLabel cl = (ContextLabel)evt.getSource();
		System.out.println(cl.getContext());
		mouseEnterlabel = new JLabel();
		mouseEnterlabel.setText(cl.getContext());
		Rectangle rt = new Rectangle(mouseEnterlabel.getLocation().x+50,mouseEnterlabel.getLocation().y,200,20);
		mouseEnterlabel.setBounds(rt);
		mouseEnterlabel.setVisible(true);
		map.add(mouseEnterlabel);
		map.repaint();*/
		if(mouseEnterlabel!=null)
		{
			System.out.println("Leave");
			map.remove(mouseEnterlabel);
			mouseEnterlabel.setText("");
			if(thisStatus == status.MONITOR)
				map.repaint();
			mouseEnterlabel= null;
		}
	}
	/** Creates new form IndoorLocation */
	public IndoorLocation()
	{
		initComponents();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		this.setTitle("PKU SSE Teaching Building");
		//frame.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon imageIcon = new ImageIcon("map//newmap.jpg");
		p.setLayout(null);
		p2.setLayout(null);
		map = new JLabel(imageIcon);
		
		//buttonStart.setLayout(null);
		map.setLocation(0, 0);
		map.setSize(412, 674);
		//label.setVisible(true);
		
		JButton buttonStart = new JButton("StartMonitor");
		buttonStart.setLocation(450, 1);
		buttonStart.setSize(150, 20);
		buttonStart.setVisible(true);
		
		buttonStart.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				buttonStartActionPerformed(evt);
			}
		});
		
		JButton buttonStop = new JButton("StopMonitor");
		buttonStop.setLocation(450, 25);
		buttonStop.setSize(150, 20);
		buttonStop.setVisible(true);
		buttonStop.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				buttonStopActionPerformed(evt);
			}
		});
		
		
		JLabel labelpath = new JLabel("FindHistoryPath");
		labelpath.setLocation(450, 50);
		labelpath.setSize(150, 20);
		labelpath.setVisible(true);
		//TextField tf1 = new TextField();
		tf1.setLocation(450, 75);
		tf1.setSize(150, 20);
		JButton buttonFindHistoryPath = new JButton("FindHistoryPath");
		buttonFindHistoryPath.setLocation(450, 95);
		buttonFindHistoryPath.setSize(150, 20);
		buttonFindHistoryPath.setVisible(true);
		buttonFindHistoryPath.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				buttonFindHistoryPathActionPerformed(evt);
			}
		});
		
		JLabel labelfrom = new JLabel("From");
		labelfrom.setLocation(450, 120);
		labelfrom.setSize(150, 20);
		labelfrom.setVisible(true);
		
		tf2.setLocation(450, 140);
		tf2.setSize(150, 20);
		JLabel labelto = new JLabel("To");
		labelto.setLocation(450, 160);
		labelto.setSize(150, 20);
		labelto.setVisible(true);
		//TextField tf3 = new TextField();
		tf3.setLocation(450, 180);
		tf3.setSize(150, 20);
		JButton buttonFindShortestPath = new JButton("FindShortestPath");
		buttonFindShortestPath.setLocation(450, 200);
		buttonFindShortestPath.setSize(150, 20);
		buttonFindShortestPath.setVisible(true);
		buttonFindShortestPath.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				buttonFindShortestPathActionPerformed(evt);
			}
		});
		JButton buttonClear = new JButton("ClearScreen");
		buttonClear.setLocation(450, 225);
		buttonClear.setSize(150, 20);
		buttonClear.setVisible(true);
		buttonClear.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				buttonStopActionPerformed(evt);
			}
		});
		
		JLabel labelfrom2 = new JLabel("From");
		labelfrom.setLocation(450, 120);
		labelfrom.setSize(150, 20);
		
		System.out.println(map.isOpaque());
		p.setOpaque(false);
		p2.setVisible(true);
		map.setOpaque(false);
		this.add(map);
		//this.add(label);
		this.add(buttonStart);
		this.add(buttonStop);
		this.add(labelpath);
		this.add(tf1);
		this.add(buttonFindHistoryPath);
		this.add(labelfrom);
		this.add(tf2);
		this.add(labelto);
		this.add(tf3);
		this.add(buttonFindShortestPath);
		this.add(buttonClear);
		this.add(labelfrom2);
		this.setVisible(true);
		
		
		p.setOpaque(false);
		p2.setOpaque(false);
		p2.setVisible(true);
		//p.add(p2);
		this.add(p);
		
		this.setSize(630, 750);
		this.setVisible(true);
		this.setResizable(false);
	}
	protected void buttonFindShortestPathActionPerformed(ActionEvent evt)
	{
		// TODO Auto-generated method stub
		//this.buttonStopActionPerformed(evt);
		String zoneName1 = this.tf2.getText();
		String zoneName2 = this.tf3.getText();
		/*Zone Zone1 = MonitorHelper.getLocationProvider().getZone(zoneName1);
		Zone Zone2 = MonitorHelper.getLocationProvider().getZone(zoneName2);*/
		int zoneID1 = MonitorHelper.getLocationUtil().getZoneIDbyZoneName
		(MonitorHelper.getRegion(), zoneName1);
		int zoneID2 = MonitorHelper.getLocationUtil().getZoneIDbyZoneName
		(MonitorHelper.getRegion(), zoneName2);
		lbs.entity.Zone startZone = MonitorHelper.getLocationUtil().getZoneById(MonitorHelper.getRegion(),zoneID1);//���
		lbs.entity.Zone destZone = MonitorHelper.getLocationUtil().getZoneById(MonitorHelper.getRegion(),zoneID2);//�յ�
		//���÷��ص���һ��zone��
		LocationInfoAccessImp la = new LocationInfoAccessImp();
		List<lbs.entity.Zone> zonelist = la.getPathByZones(MonitorHelper.getRegion(),startZone, destZone);
		List<Point> allPoint  =  new LinkedList<Point>();
		for(int i = 0;i<zonelist.size();i++)
		{
			lbs.entity.Point lp = MonitorHelper.getLocationUtil().getRandomPointInZone(MonitorHelper.getRegion(), zonelist.get(i).getId());
			Point p = new Point((int)lp.getX(),(int)lp.getY()); 
			allPoint.add(p);
		}
		ContextLabel cl = new 
		ContextLabel(MonitorHelper.getImageIcon(),"From",
				(int)allPoint.get(0).getX(),(int)allPoint.get(0).getY());
		this.drawPoint(cl);
		cl = new 
		ContextLabel(MonitorHelper.getImageIcon(),"to",
				(int)allPoint.get(allPoint.size()-1).getX(),(int)allPoint.get(allPoint.size()-1).getY());
		this.drawPoint(cl);
		for(int i =0;i<allPoint.size()-1;i++)
		{
			this.drawLine(allPoint.get(i),allPoint.get(i+1));
		}
	}
	public void clearMap()
	{
		map.removeAll();
		map.repaint();
	}
	public void refresh()
	{
		
	}
	private void buttonStartActionPerformed(java.awt.event.ActionEvent evt)
	{
		// TODO add your handling code here:
		if(thisStatus == status.MONITOR)
		{	
			System.out.println("Already started");
		}
		else
		{
			thisStatus = status.MONITOR;
			/*System.out.println("start");
			Rectangle r = new Rectangle(20,30,5,5);
			drawPoint(20,30,map,"1 hahahaha");
			drawPoint(300,400,map,"2 chiyangmei");*/
			System.out.println("Begin");
			new Thread(new Monitor()).start();
		}
	}
	private void buttonStopActionPerformed(java.awt.event.ActionEvent evt)
	{
		// TODO add your handling code here:
		System.out.println("stop");
		map.removeAll();
		map.repaint();
			thisStatus = status.STOPM;
			
	}
	private void buttonFindHistoryPathActionPerformed(java.awt.event.ActionEvent evt)
	{
		// TODO add your handling code here:
		/*SwingHelper.drawLine(null, null,this.getGraphics(), this);*/
		//refresh();
		/*clearMap();
		map.repaint();*/
		
		
		
		
		/*drawPoint(22,22,map,"hahahaha");
		drawPoint(100,200,map,"chiyangmei");*/
		///drawLine(22,22,100,200);
/*		drawLine(22,22,100,200);
		drawLine(22,22,100,200);
		drawLine(22,22,100,200);*/
		
		
		thisStatus = status.FHP;
		String terminalName = this.tf1.getText();
		
		Set<Terminal> ts = MonitorHelper.getLocationProvider().getTerminalByName(terminalName);
		Iterator itts = ts.iterator();
		while(itts.hasNext())
		{
			
			Terminal t = (Terminal) itts.next();
			System.out.println(t.getFriendlyName());
			List<StayInZone> path =  MonitorHelper.getLocationProvider().getTerminalPath(t);
			System.out.println(path.size());
			List<Point> allPoints = new  LinkedList<Point>();
			Iterator pathit = path.iterator();
			while(pathit.hasNext())
			{
				StayInZone siz = (StayInZone)pathit.next();
				System.out.println(siz.getEnterLocation().getZone().getZoneDescription());
				int zoneID = MonitorHelper.getLocationUtil().getZoneIDbyZoneName(MonitorHelper.getRegion(), siz.getEnterLocation().getZone().getZoneDescription());
				//System.out.println(z.getZoneDescription()+"  "+zoneID);
				//lbs.entity.Point lp = lu.getRandomPointInZone(region, zoneID);
				if(zoneID!=0)
				{
					lbs.entity.Point lp = MonitorHelper.getLocationUtil().getRandomPointInZone(MonitorHelper.getRegion(), zoneID);
					Point p = new Point((int)lp.getX(),(int)lp.getY()); 
					allPoints.add(p);
					ContextLabel cl = new 
					ContextLabel(MonitorHelper.getImageIcon(),t.getFriendlyName()
							+" enter:"+siz.getEnterLocation().getTime().toString()+" leave:"+siz.getLeaveLoaction().getTime().toString(),
							(int)p.getX(),(int)p.getY());
					this.drawPoint(cl);
				}
			}
			if(allPoints.size()>1)
			{
				for(int i=0;i<allPoints.size()-1;i++)
				{
					Point p1 = allPoints.get(i);
					Point p2 = allPoints.get(i+1);
					this.drawLine(p1, p2);
				}
			}
			
		}
		
	
		
	}
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{

		System.out.println("aa");
		//this.add(buttonStart);
		//this.pack();
		

	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		System.out.println("Begin");

				new IndoorLocation().setVisible(true);

	}
	
	class Monitor implements Runnable
	{
		////
		///
		//
		//
		//
	
		Set<Zone> allzones ;
		public Monitor()
		{
			super();
			
			allzones = MonitorHelper.getLocationProvider().getAllZone();
			System.out.println("init");
		}
		
		public void run()
		{
			Set<ContextLabel> lastalllables = new HashSet<ContextLabel>();
			Set<ContextLabel> alllables = new HashSet<ContextLabel>();
			int i = 0;
			// TODO Auto-generated method stub
			while(IndoorLocation.thisStatus == status.MONITOR)
			{
				//alllables = new HashSet<ContextLabel>();
				//System.out.println("find all zones");
				allzones = MonitorHelper.getLocationProvider().getAllZone();
				Iterator itZones =  allzones.iterator();
				//Set<Terminal> allTerminals = new HashSet<Terminal>();
				
				/*Point p = new Point(222,333);
				ContextLabel cl2 = new ContextLabel(new ImageIcon("map//point.jpg"),"aaa",(int)p.getX(),(int)p.getY());
				
				alllables.add(cl2);*/
				int y =0;
				while(itZones.hasNext())
				{
					//System.out.println("y="+y++);
					Zone z = (Zone)itZones.next();
					//System.out.println("find in zone"+z.getZoneDescription());
					Set<Terminal> setTerminal = MonitorHelper.getLocationProvider().getAllTerminals(z);
					//System.out.println("has "+setTerminal.size());
					/*allTerminals.addAll(setTerminal);*/
					Iterator itT = setTerminal.iterator();
					//
					//
					//
					//
					//
					
					int zoneID = MonitorHelper.getLocationUtil().getZoneIDbyZoneName(MonitorHelper.getRegion(), z.getZoneDescription());
					if(zoneID!=0)
					{
						
						
						
						while(itT.hasNext())
						{
							//System.out.println("draw point");
							lbs.entity.Point lp = MonitorHelper.getLocationUtil().getRandomPointInZone(MonitorHelper.getRegion(), zoneID);
							Point p = new Point((int)lp.getX(),(int)lp.getY()); 
							//System.out.println(z.getZoneDescription()+"  "+zoneID);
							//lbs.entity.Point lp = lu.getRandomPointInZone(region, zoneID);
							int locationx =0;
							int locationy =0;
							locationx = (int)(p.getX());
							locationy = (int)(p.getY());
							System.out.println(locationx+"   "+locationy);
							Terminal t = (Terminal)itT.next();
							System.out.println(t.getFriendlyName());
							ContextLabel cl = new ContextLabel(new ImageIcon("map//point.jpg"),t.getFriendlyName(),z.getZoneDescription(),locationx,locationy);
							alllables.add(cl);
						}
					}
					
					
					itT =null;
				}
				if(alllables ==null)
				{
					System.out.println("Nothing to draw");
					try
					{
						Thread.sleep(1000);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				else if(alllables.equals(lastalllables))
					{
					System.out.println("No Changed");
						try
						{
							Thread.sleep(1000);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						continue;
					}
				else
				{
					System.out.println("Changed !!! Draw");
					Iterator itlabel = alllables.iterator();
					map.removeAll();
					map.repaint();
					itlabel = alllables.iterator();
					while(itlabel.hasNext())
					{
						ContextLabel cl =(ContextLabel)itlabel.next();
						drawPoint(cl);
					}
					lastalllables = alllables;
					alllables = new HashSet<ContextLabel>();
				}
				
			}
		}
		
	}
	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	// End of variables declaration//GEN-END:variables

}
class MonitorHelper
{
	public static Region region = null;
	public static LocationProvider locationProvider = null;
	public static LocationUtil lu = null;
	public static ImageIcon imageIcon=null;
	
	public static ImageIcon getImageIcon()
	{
		if(imageIcon == null)
			{
			imageIcon = new ImageIcon("map//point.jpg");
			return imageIcon;
			}
		else
			return imageIcon;
	}
	public static Region getRegion()
	{
		if(region == null)
		{
			region = new InitMap().initRegion("map//teachingbuilding.xml");
			return region;
		}
		else
			return region;
	}
	public static LocationProvider getLocationProvider()
	{
		if(locationProvider == null)
		{
			try
			{
				Class.forName("pku.deviceInformationAccess.driverManager.BlipLocationDriver");
			} catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			locationProvider = DriverManager.getLocationProvider
			("jdbc:sqlserver://192.168.0.1:1433;DatabaseName=DevicesData", "sa", "1234");
			return locationProvider;
		}
		else return locationProvider;
	}
	public static LocationUtil getLocationUtil()
	{
		if(lu ==null)
		{
			lu = new LocationUtil();
			return lu;
		}
		else
			return lu;
	}
}
enum status {MONITOR,STOPM,FHP,FSP};