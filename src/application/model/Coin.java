package application.model;

public class Coin 
{
	private int xLocation, yLocation, width, length, value;
	
	public Coin(int x, int y, int w, int l)
	{
		this.xLocation = x;
		this.yLocation = y;
		this.width = w;
		this.length = l;
		this.setValue();
	}
	
	private void setValue()
	{
		this.value = (int) Math.ceil(Math.random() * 5);
	}
	
	public int getValue()
	{
		return this.value;
	}
}
