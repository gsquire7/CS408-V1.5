package Controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import Model.FightModel;
import Model.PokemonState;
import View.FightView;

public class FightController {
	MoveController FM = new MoveController();
	RandomGen RM = new RandomGen();
	FightView FV = new FightView();
	AI.Random AIR = new AI.Random();
	
	
	private int accuracy, base, damage, choice;
	public static boolean playerTurn = true, playable = true;
	static int temppercent;

	public ArrayList<PokemonState> runBattle(ArrayList<PokemonState> currentPokemon, ArrayList<PokemonState> enemyPokemon){	
		FightModel.getInstance().setPlayerCurrent(0);
		FightModel.getInstance().setEnemyCurrent(0);
		FightModel.getInstance().setPlayerParty(currentPokemon);
		FightModel.getInstance().setEnemyParty(enemyPokemon);
		JFrame jf = new JFrame();
		jf.setSize(100 * (FightModel.getInstance().getL()), 100* FightModel.getInstance().getL());
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(FV);
		FightModel.getInstance().setSpoken("A wild " + FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getName() + " appeared");
		FV.Pause(1000);
		FightModel.getInstance().setSpoken("Wild " + FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getName() + " attacked");
		FV.Pause(1000);
		FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " GO!");
		FV.Pause(1000);
		System.out.println("Here");

		while(playable == true){
			FightModel.getInstance().setMainScreen(true);
			FightModel.getInstance().setSpeech(false);
			playerTurn();
			enemyTurn();
		}

		return FightModel.getInstance().getPlayerParty();
	}



	public void enemyTurn() {
		choice = 0;
		isStruggle(FightModel.getInstance().getEnemyParty(), FightModel.getInstance().getEnemyCurrent());
		changeablePokemon();
		while(playerTurn != true && playable == true)
		{
			System.out.println("LUGIA TURN");
			choice = AIR.generateRandomChoice(FightModel.getInstance().getStruggle(), FightModel.getInstance().getChangeablePokemon());
			choices();
		}
	}

	public void playerTurn(){
		

		isStruggle(FightModel.getInstance().getPlayerParty(), FightModel.getInstance().getPlayerCurrent());
		while(playerTurn == true && playable == true)
		{
			FV.Pause(10);
			//if move has been selected
			if(FightModel.getInstance().getSpeech() == true && FightModel.getInstance().getPokemonChanged() == false)
			{
				if(FightModel.getInstance().getxPos() == 7 && FightModel.getInstance().getyPos() == 76)
				{
					choice = 1;
				}
				if(FightModel.getInstance().getxPos() == 52 && FightModel.getInstance().getyPos() == 76)
				{
					choice = 2;
				}
				if(FightModel.getInstance().getxPos() == 7 && FightModel.getInstance().getyPos() == 86)
				{
					choice = 3;
				}
				if(FightModel.getInstance().getxPos() == 52 && FightModel.getInstance().getyPos() == 86)
				{
					choice = 4;
				}
				if(FightModel.getInstance().getStruggle() == true)
				{
					choice = 5;
				}
				
				choices();
			}
			//if pokemon has been changed
			else if(FightModel.getInstance().getSpeech() == false && FightModel.getInstance().getPokemonChanged() == true)
			{
				FightModel.getInstance().setChange(false);
				FightModel.getInstance().setSpeech(true);
				FV.Pause(1000);
				FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " I CHOOSE YOU!");
				FV.Pause(1000);
				FightModel.getInstance().setxPos(7);
				FightModel.getInstance().setyPos(76);
				FightModel.getInstance().setPokemonChanged(false);
				playerTurn = false;
			}
		}
	}
	//dpes player need to use struggle
	public void isStruggle(ArrayList<PokemonState> x, int y)
	{
		if(x.get(y).getMovePP(0) + x.get(y).getMovePP(1) + x.get(y).getMovePP(2) + x.get(y).getMovePP(3) == 0)
		{
			FightModel.getInstance().setStruggle(true);
		}
		else
		{
			FightModel.getInstance().setStruggle(false);
		}
	}

	public void choices()
	{
		int pos, oppPos;
		ArrayList<PokemonState> list, oppList;
		if(playerTurn == true)
		{
			pos = FightModel.getInstance().getPlayerCurrent();
			oppPos = FightModel.getInstance().getEnemyCurrent();
			list = FightModel.getInstance().getPlayerParty();
			oppList = FightModel.getInstance().getEnemyParty();


		}
		else
		{
			pos = FightModel.getInstance().getEnemyCurrent();
			oppPos = FightModel.getInstance().getPlayerCurrent();
			list = FightModel.getInstance().getEnemyParty();
			oppList = FightModel.getInstance().getPlayerParty();
		}
		boolean moveUsed = true;
		boolean healthChange = false;
		double healthChangeRatio = 0.0;

		if (choice < 5 && choice > 0)
		{
			int temp = choice - 1;
			if(list.get(pos).getMovePP(temp) == 0)
			{
				moveUsed = false;
			}
			
			if (moveUsed == true)
			{
				System.out.println("used " + list.get(pos).getMove(temp));
				getStats(list.get(pos).getName(), list.get(pos).getMove(temp), list.get(pos).getMovePP(temp));
				list.get(pos).decrementMovePP(temp);
				healthChangeRatio = FM.getHealthRegeneration(list.get(pos).getMove(temp));
				if( healthChangeRatio != 0.0)
				{
					healthChange = true;
				}
			}
			else if(moveUsed == false)
			{
				noPP();	
			}
		}
		else if (choice == 5)
		{
			getStats(list.get(pos).getName(), "STRUGGLE", 1);
			healthChangeRatio = FM.getHealthRegeneration("STRUGGLE");
			healthChange = true;
		}

		if (choice < 6 && choice > 0)
		{
			//does the move hit due to accuracy
			if(accuracy < 100)
			{
				FightModel.getInstance().setPlayerAttackable (accuracy(accuracy));				
			}
			//if the pokemon can attack then calculate damage
			if (FightModel.getInstance().getPlayerAttackable() != false || FightModel.getInstance().getEnemyAttackable() != false)
			{
				if(base != 0)
				{
					calcDamage(list.get(pos).getLevel(), list.get(pos).getAttack(), oppList.get(oppPos).getDefence(), base);
					oppList.get(oppPos).setHP(attackStrength(oppList.get(oppPos).getHP(), damage));
					System.out.println("Enemy " + oppList.get(oppPos).getName() + " hit.");
					//if move regenerates player hp, regenerate it
					if(healthChange == true)
					{
						int k = (int)(list.get(pos).getHP() + (healthChangeRatio * damage));
						if(k > list.get(pos).getHPTotal())
						{
							list.get(pos).setHP(list.get(pos).getHPTotal());
						}
						else
						{
							list.get(pos).setHP((int) (list.get(pos).getHP() + (healthChangeRatio * damage)));
							System.out.println("Player regenerates health");
						}
					}
				}
				if(playerTurn == true)
				{
					FightModel.getInstance().setSpoken(list.get(pos).getName() + " hit!");
					FightModel.getInstance().setxPos(7);
					FightModel.getInstance().setyPos(76);
					FV.Pause(1000);
					System.out.println(oppList.get(oppPos).getName() + " health Points remaining " + oppList.get(oppPos).getHP());
					System.out.println(list.get(pos).getName() + " health Points remaining " + list.get(pos).getHP());
					FightModel.getInstance().setPlayerAttackable(true);
					playerTurn = false;
				}
				else
				{
					FightModel.getInstance().setSpoken("Enemy " + FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getName() + " hit!");
					FV.Pause(1000);
					System.out.println(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " hit. Health Points remaining " + FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getHP());
					System.out.println(FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getName() + " Health Points remaining " + FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getHP());
					FightModel.getInstance().setPlayerAttackable(true);
					playerTurn = true;
				}

			}
			else
			{
				FightModel.getInstance().setSpoken(list.get(pos).getName() + " missed!");
				FV.Pause(1000);
				if(playerTurn == true)
				{
					playerTurn = false;
				}
				else
				{
					playerTurn = true;
				}
			}

			//Did the opponent faint
			//if yes
			if(oppList.get(oppPos).getHP() <= 0)
			{
				//tell user opponent fainted
				if(playerTurn == false)
				{
					FightModel.getInstance().setSpoken("Enemy " + oppList.get(oppPos).getName() + " fainted!");
					System.out.println("Enemy " + oppList.get(oppPos).getName() + " fainted.");
				}
				else
				{
					FightModel.getInstance().setSpoken(list.get(pos).getName() + " fainted.");
					System.out.println(list.get(pos).getName() + " fainted.");
				}
				FV.Pause(1000);
				//check to see if there are any other pokemon in the party
				//if not then fight won
				boolean out = true;
				ArrayList<Integer> left = new ArrayList<Integer>();

				for(int z = 0; z < oppList.size(); z++)
				{
					if(oppList.get(z).getHP() > 0)
					{

						left.add(z);
						out = false;
					}
				}

				if(out == true)
				{
					FightModel.getInstance().setSpoken(list.get(pos).getName() + " has won the fight");
					FV.Pause(1000);
					System.out.println(list.get(pos).getName() + " has won the fight");
					playable = false;
				}
				//else determine which pokemon is selected
				else
				{
					if(playerTurn == false)
					{
						FightModel.getInstance().setSpoken ("ENEMY: " + oppList.get(oppPos).getName() + " THATS ENOUGH");
						FV.Pause(1000);
						FightModel.getInstance().setEnemyCurrent(left.get(RM.GenerateNumber(left.size())));
						FightModel.getInstance().setSpoken("ENEMY: " + oppList.get(FightModel.getInstance().getEnemyCurrent()).getName() + " I CHOOSE YOU");
						FV.Pause(1000);
						FightModel.getInstance().setSpeech(false);
						FightModel.getInstance().setMainScreen(true);
						playerTurn = true;
					}
					else
					{
						FightModel.getInstance().setPlayerCurrent(left.get(0));
						playerTurn = false;
					}
				}

			}
		}
		else if (choice == 6)
		{
			
			/*
			 * Code for allowing the user to change pokemon
			 * move to AI as this should be an AI choice
			 */
			boolean allowed = false;
			
			while(allowed == false)
			{
				System.out.println("IN THE LOOP");
				int use = RM.GenerateNumber(FightModel.getInstance().getEnemyParty().size());
				if(use == FightModel.getInstance().getEnemyCurrent())
				{
					allowed = false;
				}
				else if(FightModel.getInstance().getEnemyParty().get(use).getHP() < 1)
				{
					allowed = false;
				}
				else
				{
					FightModel.getInstance().setSpoken("ENEMY: " + (FightModel.getInstance().getEnemyParty()).get(FightModel.getInstance().getEnemyCurrent()).getName() + " THATS ENOUGH!");
					FV.Pause(1000);
					System.out.println("Enemy: " + FightModel.getInstance().getEnemyParty().get(use).getName() + " I CHOOSE YOU!");
					FightModel.getInstance().setSpoken("Enemy: " + FightModel.getInstance().getEnemyParty().get(use).getName() + " I CHOOSE YOU!");
					FV.Pause(1000);
					FightModel.getInstance().setEnemyCurrent(use);
					allowed = true;
					FightModel.getInstance().setSpeech(false);
					FightModel.getInstance().setMainScreen(true);
					playerTurn = true;
					
				}
			}
		}
	}


	public void noPP()
	{
		System.out.println("NO PP LEFT");
		choice = 0;
		if(playerTurn == true)
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
		//		System.out.println("Accuracy Number" + accurate);
		if(accurate <= x)
		{
			hit = true;
		}
		else
		{
			hit = false;

		}
		return hit;

	}


	public void calcDamage(int level, int attack, int defense, int base)
	{
		double x = Math.floor((((2 * (double)level + 10) / 250) * ((double)attack / 
				(double)defense) * (double)base) + 2);

		damage = (int)x;
		//		System.out.println("Damage = " + damage);

	}
	public void getStats(String name, String move, int pp)
	{
		pp--;
		if(pp >= 0)
		{
			FightModel.getInstance().setSpoken( name + " used " + move);
			FV.Pause(1000);
			System.out.println(name + " used " + move);
			base = FM.getStrength(move);
			accuracy = FM.getAccuracy(move);
		}
	}
	
	public void changeablePokemon()
	{
		/*
		 * Code to stop trying to change pokemon when only one is useable
		 * prevents infinite looping later
		 */
		int check = 0;
		for(int b = 0; b < FightModel.getInstance().getEnemyParty().size(); b++)
		{
			if(FightModel.getInstance().getEnemyParty().get(b).getHP() > 0)
			{
				check++;
			}
		}
		
		if(check == 1)
		{
			FightModel.getInstance().setChangeablePokemon(false);
		}
		else
		{
			FightModel.getInstance().setChangeablePokemon(true);
		}
	}
}