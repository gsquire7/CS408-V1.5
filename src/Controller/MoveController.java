package Controller;

import Model.FightMoveDatabase;
import Model.MoveEffects;

public class MoveController {

	RandomGen random = new RandomGen();
//		moves.add(new MoveEffects("STRUGGLE", "N/A", 50, 100, 1, -0.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0));

	
	public int getStrength(String move)
	{
		int positionStrength  = getIndex(move);
		int strength = FightMoveDatabase.getInstance().getMoves().get(positionStrength).getStrength();
		return strength;
	}

	public int getAccuracy(String move)
	{
		int positionAccuracy = getIndex(move);
		int accuracy = FightMoveDatabase.getInstance().getMoves().get(positionAccuracy).getAccuracy();
		return accuracy;
	}

	public int getIndex(String moveName)
	{
		boolean found = false;
		int index = 0;
		while(found == false)
		{
			for(MoveEffects a: FightMoveDatabase.getInstance().getMoves())
			{
				String b = a.getName();
				if(b.equals(moveName))
				{
					int odds = a.getExceptionsOdds();
					if(odds > 0)
					{
						if(random.GenerateNumber(100) > odds)
						{
							return index;
						}
						else
						{
							index++;
							return index;
						}
					}
					return index;
				}
				else
				{
					index++;
				}
			}
		}
		return 0;	
	}
	
	public double getHealthRegeneration(String move)
	{
		int healthRegeneration = getIndex(move);
		double regeneration = FightMoveDatabase.getInstance().getMoves().get(healthRegeneration).getHealthRegeneration();
		return regeneration;
	}
	public int getMovePP(String move)
	{
		int moveLimit = getIndex(move);
		int pp = FightMoveDatabase.getInstance().getMoves().get(moveLimit).getPP();
		return pp;
	}
}