import java.util.ArrayList;
import java.util.Random;

public class Mixer 
{
	private final ArrayList<Move> moves;
	private final Random rand;
	
	public Mixer() 
	{
		rand = new Random();
		moves = new ArrayList<>();
		
		for(int i = 0; i < 1000; i ++)
		{
			moves.add(new Move(Side.values()[rand.nextInt(6)], rand.nextInt(3) == 0 ? "'" : "", rand.nextInt(3) == 0 ? 2 : 1));
		}
		looper:
		while(true)
		{
			for(Move move : moves)
			{
				int index = moves.indexOf(move);
				if(index != moves.size() -1 && moves.get(index + 1).getSide().equals(move.getSide()))
				{
					merge(index);
					continue looper;
				}
			}
			break;
		}
		
		for(int i = 0; i < moves.size(); i++)
		{
			System.out.print(moves.get(i) + " ");
			if(i%28 == 0 && i != 0) System.out.println();
		}
	}

	
	private void merge(int index)
	{
		Move first = moves.get(index);
		Move second = moves.get(index + 1);
		int firstRotations = first.getRotations() * (first.getDirection().equals("'") ? -1 : 1);
		int secondRotations = second.getRotations() * (second.getDirection().equals("'") ? -1 : 1);
		int totalRotations = firstRotations + secondRotations;
		
		totalRotations %= 4;
		if(totalRotations == 0) totalRotations = (rand.nextInt(2) + 1) * (rand.nextInt(2) == 0 ? -1 : 1);
		
		
		Move move = new Move(moves.get(index).getSide(), totalRotations < 0 ? "'" : "", Math.abs(totalRotations));
		moves.remove(index);
		moves.remove(index);
		
		moves.add(index, move);
	}
	
	public static void main(String[] args) 
	{
		new Mixer();
	}
}