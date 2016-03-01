package Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.FightModel;
import Model.PokemonState;
import View.FightView;

public class Calculations {
	RandomGen RM = new RandomGen();
	FightView FV = new FightView();
	MoveController MC = new MoveController();
	//dpes player need to use struggle
	public boolean isStruggle(ArrayList<PokemonState> x, int y)
	{
		if(x.get(y).getMovePP(0) + x.get(y).getMovePP(1) + x.get(y).getMovePP(2) + x.get(y).getMovePP(3) == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void noPP()
	{
		System.out.println("NO PP LEFT");
		FightModel.getInstance().setChoice(0);
		if(FightModel.getInstance().isPlayerTurn() == true)
		{
			FightModel.getInstance().setSpeech(true);
			FightModel.getInstance().setMainScreen (false);
			FightModel.getInstance().setSpoken("NO PP LEFT");
			FV.Pause(1000);
			FightModel.getInstance().setMainScreen (true);
			FightModel.getInstance().setSpeech(false);
		}
	}


	public int attackStrength(int healthpoints, int strength) {

		healthpoints = healthpoints - strength;
		if(healthpoints < 0)
		{
			healthpoints = 0;
		}
		return healthpoints;
	}

	public boolean accuracy(int x)
	{
		boolean hit;
		int accurate = RM.GenerateNumber(100);
//				System.out.println("Accuracy Number" + accurate);
		if(accurate <= x)
		{
//			System.out.println("hit");
			hit = true;
		}
		else
		{
//			System.out.println("missed");
			hit = false;

		}
		return hit;

	}


	public int calcDamage(int level, int attack, int defense, int base)
	{
		double x = Math.floor((((2 * (double)level + 10) / 250) * ((double)attack / 
				(double)defense) * (double)base) + 2);

		return ((int)x);
		//		System.out.println("Damage = " + damage);

	}
	public int getStrength(String name, String move, boolean ai)
	{
		if(ai != true)
		{
			FightModel.getInstance().setSpoken( name + " used " + move);
			FV.Pause(1000);
		}
//		System.out.println(name + " used " + move);
		int x = (MC.getStrength(move));
//		System.out.println(MC.getStrength(move));
		
		return x;
	}
	
	
	public boolean changeablePokemon(ArrayList<PokemonState> x)
	{
		/*
		 * Code to stop trying to change pokemon when only one is useable
		 * prevents infinite looping later
		 */
		int check = 0;
		for(int b = 0; b < x.size(); b++)
		{
			if(x.get(b).getHP() > 0)
			{
				check++;
			}
		}
		
		if(check == 1 || check == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
