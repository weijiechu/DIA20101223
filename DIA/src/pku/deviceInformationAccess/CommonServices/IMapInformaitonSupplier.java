package pku.deviceInformationAccess.CommonServices;

import java.util.List;

import pku.deviceInformationAccess.location.Zone;

public interface IMapInformaitonSupplier
{
	double getShortestDistance(Zone from,Zone to) ;
	List<Zone> pathgetShortestPath(Zone from,Zone to) ;

}
