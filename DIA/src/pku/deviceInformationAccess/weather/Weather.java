package pku.deviceInformationAccess.weather;

public class Weather
{
	String state;
//	The city¡¯s weather state (sun or cloudy).

	String temperature;
//	The city¡¯s centigrade temperature.

	String description;
//	The city¡¯s weather detailed description.

	public String getDescription()
	{
		return description;
	}

	public Weather(String state, String temperature, String description)
	{
		super();
		this.state = state;
		this.temperature = temperature;
		this.description = description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getTemperature()
	{
		return temperature;
	}

	public void setTemperature(String temperature)
	{
		this.temperature = temperature;
	}

}
