package application.model;

public abstract class PowerUp 
{
	private int xLocation, yLocation, width, length;
	
	private String powerType;

	public PowerUp(int x, int y, int w, int l)
	{
		this.xLocation = x;
		this.yLocation = y;
		this.width = w;
		this.length = l;
	}
	
	protected void setType(String type)
	{
		this.powerType = type;
	}
	
	public String getType()
	{
		if (this.powerType.equals(null))
			return "no power";
		return this.powerType;
	}
}
