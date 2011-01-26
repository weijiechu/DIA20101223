package pku.deviceInformationAccess.esper;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pku.deviceInformationAccess.events.TerminalDepartEvent;
import pku.deviceInformationAccess.events.TerminalDetectedEvent;
import pku.deviceInformationAccess.location.Coordinates;
import pku.deviceInformationAccess.location.Zone;
import pku.deviceInformationAccess.terminal.Bluetooth;
import pku.deviceInformationAccess.terminal.WiFiEquipment;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;



public class DIAEventsListener implements UpdateListener {

	private static Log log = LogFactory.getLog(DIAEventsStatement.class);

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		 if (newEvents != null) {
			 System.out.println("******pringInformation begin*******");
			 if(newEvents[0].get("event") instanceof TerminalDetectedEvent) {
				 System.out.println("事件类型:\t进入事件");
			 }
			 if(newEvents[0].get("event") instanceof TerminalDepartEvent) {
				 System.out.println("事件类型:\t离开事件");
			 }
			 if(newEvents[0].get("terminal") instanceof Bluetooth) {
				 Bluetooth bt = (Bluetooth)newEvents[0].get("terminal");
				 System.out.println("蓝牙名称：\t" + bt.getFriendlyName());
				 System.out.println("蓝牙Mac地址：\t" + bt.getMac());
			 } else if (newEvents[0].get("terminal") instanceof WiFiEquipment) {
				 WiFiEquipment we = (WiFiEquipment)newEvents[0].get("terminal");
				 System.out.println("蓝牙名称：" + we.getFriendlyName());
				 System.out.println("蓝牙Mac地址：" + we.getMac());

			 }
			 Zone zone = (Zone)newEvents[0].get("zone");
			 System.out.println("ZoneID:\t" + zone.getZoneID());
			 System.out.println("Description:\t" + zone.getZoneDescription());
			 Iterator it = zone.getCorrdinates().iterator();
			 int count = 1;
			 while(it.hasNext()) {
				 Coordinates cd = (Coordinates)it.next();
				 System.out.println("Coordinates-"+ (count++) + ": \t(" + cd.getX() + "," + cd.getY() + ")");
			 }
			 System.out.println("******printInformation end*******");
	     }
	}
}
