
public class Move 
{
	private Side side;
	private String direction;
	private int rotations;
	
	public Move(Side side, String direction, int rotations) 
	{
		this.side = side;
		this.direction = direction;
		this.rotations = rotations;
	}
	
	public Side getSide()
	{
		return side;
	}
	
	public String getDirection()
	{
		return direction;
	}
	
	public int getRotations()
	{
		return rotations;
	}
	
	@Override
	public String toString() 
	{
		return (rotations == 2 ? 2 : "") + side.toString() + direction;
	}
}