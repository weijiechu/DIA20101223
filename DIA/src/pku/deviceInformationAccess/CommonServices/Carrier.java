package pku.deviceInformationAccess.CommonServices;

import java.util.List;

import pku.deviceInformationAccess.terminal.Terminal;

public class Carrier
{
	public List<Terminal> hisTerminals;
	public String name;
	public Carrier(List<Terminal> hisTerminals, String name)
	{
		super();
		this.hisTerminals = hisTerminals;
		this.name = name;
	}
	public boolean isHisTerminal(Terminal t)
	{
		for(int i=0;i<hisTerminals.size();i++)
		{
			Terminal tt = (Terminal)hisTerminals.get(i);
			if(t.getMac() ==tt.getMac())
				return true;
		}
		return false;
	}
	public void addTerminal(Terminal c)
	{
		hisTerminals.add(c);
	}
	public void removeTerminal(Terminal c)
	{
		hisTerminals.remove(c);
	}
	
}
