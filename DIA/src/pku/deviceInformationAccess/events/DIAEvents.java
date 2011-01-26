package pku.deviceInformationAccess.events;

import pku.deviceInformationAccess.location.Zone;
import pku.deviceInformationAccess.terminal.Terminal;

public abstract class DIAEvents 
{
	
	Terminal terminal;
	Zone zone;
	DIAEvents event;
	
	public DIAEvents getEvent() {
		return this;  // 返回对象自身，便于EPL语句获得事件本身
	}
	public void setEvent(DIAEvents event) {
		this.event = event;
	}
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public Terminal getTerminal()
	{
		return terminal;
	}
	/**
	 * @return the zone
	 */
	public Zone getZone()
	{
		return zone;
	}
}
