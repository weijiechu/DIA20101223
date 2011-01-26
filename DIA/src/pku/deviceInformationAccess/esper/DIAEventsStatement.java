package pku.deviceInformationAccess.esper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;


public class DIAEventsStatement {

	private EPStatement statement;
 	private static Log log = LogFactory.getLog(DIAEventsStatement.class);
    public DIAEventsStatement(EPAdministrator admin)
    {
        String stmt = "select terminal, zone, event " +
                      "from DIAEvents ";

        statement = admin.createEPL(stmt);
    }

    public void addListener(UpdateListener listener)
    {
        statement.addListener(listener);
    }
}
