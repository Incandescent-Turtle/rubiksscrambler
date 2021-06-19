
public enum Side 
{
	L('L'),
	R('R'),
	U('U'),
	D('D'),
	B('B'),
	F('F');
	
	private char sign;
	
	private Side(char sign)
	{
		this.sign = sign;
	}
	
	@Override
	public String toString() 
	{
		return "" + sign;
	}
}