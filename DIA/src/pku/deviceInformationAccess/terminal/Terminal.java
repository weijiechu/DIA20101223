package pku.deviceInformationAccess.terminal;

public class Terminal
{
	String friendlyName;
	int id=-1;
	String mac;
	String ownerName;
	public Terminal()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Terminal(String friendlyName, int id, String mac, String ownerName)
	{
		super();
		this.friendlyName = friendlyName;
		this.id = id;
		this.mac = mac;
		this.ownerName = ownerName;
	}

	public Terminal(String friendlyName, int id, String mac)
	{
		super();
		this.friendlyName = friendlyName;
		this.id = id;
		this.mac = mac;
		this.ownerName = friendlyName;
	}
	/**
	 * @return the friendlyName
	 */
	public String getFriendlyName()
	{
		return friendlyName;
	}
	/**
	 * @param friendlyName the friendlyName to set
	 */
	public void setFriendlyName(String friendlyName)
	{
		this.friendlyName = friendlyName;
	}
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	/**
	 * @return the mac
	 */
	public String getMac()
	{
		return mac;
	}
	/**
	 * @param mac the mac to set
	 */
	public void setMac(String mac)
	{
		this.mac = mac;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Terminal))
			return false;
		Terminal other = (Terminal) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName()
	{
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}
	
	
	
}
