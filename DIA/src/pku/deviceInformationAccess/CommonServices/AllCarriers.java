package pku.deviceInformationAccess.CommonServices;

import java.util.LinkedList;
import java.util.List;

import pku.deviceInformationAccess.terminal.Terminal;

public class AllCarriers
{
	List<Carrier> allCarriers = new LinkedList<Carrier>();
	
	public AllCarriers(List<Carrier> allCarriers)
	{
		super();
		this.allCarriers = allCarriers;
	}
	public void addCarrie(Carrier c)
	{
		allCarriers.add(c);
	}
	public void removeCarrie(Carrier c)
	{
		allCarriers.remove(c);
	}
	public Carrier getCarrier(Terminal t)
	{

		for(int i = 0 ;i<allCarriers.size();i++)
		{
			Carrier c = (Carrier)allCarriers.get(i);
			if(c.isHisTerminal(t))
			{
				return c;
			}
		}
		return null;
	}
}
