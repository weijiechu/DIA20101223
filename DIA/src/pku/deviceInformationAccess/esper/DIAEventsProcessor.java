package pku.deviceInformationAccess.esper;

import pku.deviceInformationAccess.events.DIAEvents;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;



public class DIAEventsProcessor {

	private static DIAEventsProcessor processor;
	/**
	 * 应用singleton模式
	 * @return
	 */
	public static DIAEventsProcessor getUniqueDIAEventsProcessor() {
		if(processor == null) {
			synchronized(DIAEventsProcessor.class) {
				if(processor == null){
					processor = new DIAEventsProcessor();
				}
			}
		}
		return processor;
	}
	private static Configuration config = null;
	private static EPServiceProvider epService = null;
	private static DIAEventsStatement stmt = null;
	DIAEventsProcessor() {
		config = new Configuration();
		config.addEventType("DIAEvents", DIAEvents.class.getName());
		epService = EPServiceProviderManager.getDefaultProvider(config);
		stmt = new DIAEventsStatement(epService.getEPAdministrator());
		stmt.addListener(new DIAEventsListener());
	}
	
	public static void sendEvent(DIAEvents event) {
		epService.getEPRuntime().sendEvent(event);
	}

	
}
