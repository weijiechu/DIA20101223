package pku.deviceInformationAccess.CommonServices;

import java.util.List;


import lbs.api.InitMap;
import lbs.api.LocationInfoAccessImp;
import lbs.api.LocationUtil;
import lbs.entity.Region;

import pku.deviceInformationAccess.location.Zone;

public class MapInformationSupplier implements IMapInformaitonSupplier
{
	public static Region region;
	public static LocationUtil lu ;
	
	public MapInformationSupplier(String xmlPath)
	{
		region = new InitMap().initRegion(xmlPath);
		lu = new LocationUtil();
	}
	public double getShortestDistance(Zone from, Zone to)
	{
		// TODO Auto-generated method stub
		int zoneID1= lu.getZoneIDbyZoneName(region, from.getZoneDescription());
		int zoneID2= lu.getZoneIDbyZoneName(region, to.getZoneDescription());
		lbs.entity.Zone startZone = lu.getZoneById(region,zoneID1);//Æðµã
		lbs.entity.Zone destZone = lu.getZoneById(region,zoneID2);//ÖÕµã
		LocationInfoAccessImp la = new LocationInfoAccessImp();
		
		double distance = la.getDistanceBetweenZones(region, startZone, destZone);
		return distance;
	}

	public List<Zone> pathgetShortestPath(Zone from, Zone to)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
