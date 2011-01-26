package pku.deviceInformationAccess.esper;

import java.util.*;

import pku.deviceInformationAccess.events.TerminalDepartEvent;
import pku.deviceInformationAccess.location.Coordinates;
import pku.deviceInformationAccess.location.Zone;
import pku.deviceInformationAccess.terminal.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Coordinates cd1 = new Coordinates(1.0, 2.0);
		Coordinates cd2 = new Coordinates(3.0, 4.0);
		List<Coordinates> cds = new ArrayList<Coordinates>();
		cds.add(cd1);
		cds.add(cd2);
		
		Zone zone = new Zone(3201, "开会教室", null, cds);
		
		Bluetooth bt = new Bluetooth("蓝牙设备001", -1, "12-34-56");
		Terminal tm = bt;
		
		TerminalDepartEvent tde = new TerminalDepartEvent(zone, bt);
		
		DIAEventsProcessor.getUniqueDIAEventsProcessor().sendEvent(tde);
	}

}
