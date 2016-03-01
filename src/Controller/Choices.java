package Controller;

import java.util.ArrayList;

import Model.FightModel;
import Model.PokemonState;
import View.FightView;
public class Choices {


Calculations C = new Calculations();
FightView FV = new FightView();
MoveController MC = new MoveController();
RandomGen RM = new RandomGen();

	public void choices()
	{
		int choice = FightModel.getInstance().getChoice();

		int pos, oppPos;
		ArrayList<PokemonState> list, oppList;
		if(FightModel.getInstance().isPlayerTurn() == true)
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
				FightModel.getInstance().setBase(C.getStrength(list.get(pos).getName(), list.get(pos).getMove(temp), false) );
				list.get(pos).decrementMovePP(temp);
				healthChangeRatio = MC.getHealthRegeneration(list.get(pos).getMove(temp));
				if( healthChangeRatio != 0.0)
				{
					healthChange = true;
				}
			}
			else if(moveUsed == false)
			{
				C.noPP();	
			}
		}
		else if (choice == 5)
		{
			FightModel.getInstance().setBase(C.getStrength(list.get(pos).getName(), "STRUGGLE", false));
			healthChangeRatio = MC.getHealthRegeneration("STRUGGLE");
			healthChange = true;
		}

		if (choice < 6 && choice > 0)
		{
			//does the move hit due to accuracy
			FightModel.getInstance().setAccuracy(MC.getAccuracy(list.get(pos).getMove(choice - 1)));
			System.out.println("Accuracy = " + MC.getAccuracy(list.get(pos).getMove(choice - 1)));	
			if(FightModel.getInstance().getAccuracy() < 100 && FightModel.getInstance().isPlayerTurn() == true)
			{
				FightModel.getInstance().setPlayerAttackable (C.accuracy(FightModel.getInstance().getAccuracy()));				
			}
			else if(FightModel.getInstance().getAccuracy() < 100 && FightModel.getInstance().isPlayerTurn() == false)
			{
				FightModel.getInstance().setEnemyAttackable (C.accuracy(FightModel.getInstance().getAccuracy()));				
			}
			//if the pokemon can attack then calculate damage
			if ((FightModel.getInstance().getPlayerAttackable() != false && FightModel.getInstance().isPlayerTurn() == true)
					|| (FightModel.getInstance().getEnemyAttackable() != false && FightModel.getInstance().isPlayerTurn() == false))
			{
				System.out.println("Still slipped through");
				if(FightModel.getInstance().getBase() != 0)
				{
					FightModel.getInstance().setDamage(C.calcDamage(list.get(pos).getLevel(), list.get(pos).getAttack(), oppList.get(oppPos).getDefense(), FightModel.getInstance().getBase()));
					oppList.get(oppPos).setHP(C.attackStrength(oppList.get(oppPos).getHP(), FightModel.getInstance().getDamage()));
					System.out.println("Enemy " + oppList.get(oppPos).getName() + " hit.");
					//if move regenerates player hp, regenerate it
					if(healthChange == true)
					{
						int k = (int)(list.get(pos).getHP() + (healthChangeRatio * FightModel.getInstance().getDamage()));
						if(k > list.get(pos).getHPTotal())
						{
							list.get(pos).setHP(list.get(pos).getHPTotal());
						}
						else
						{
							list.get(pos).setHP((int) (list.get(pos).getHP() + (healthChangeRatio * FightModel.getInstance().getDamage())));
							System.out.println("Player regenerates health");
						}
					}
				}
				if(FightModel.getInstance().isPlayerTurn() == true)
				{
					FightModel.getInstance().setSpoken(list.get(pos).getName() + " hit!");
					FightModel.getInstance().setxPos(7);
					FightModel.getInstance().setyPos(76);
					FV.Pause(1000);
					System.out.println(oppList.get(oppPos).getName() + " health Points remaining " + oppList.get(oppPos).getHP());
					System.out.println(list.get(pos).getName() + " health Points remaining " + list.get(pos).getHP());
					FightModel.getInstance().setPlayerAttackable(true);
					FightModel.getInstance().setPlayerTurn(false);
				}
				else
				{
					FightModel.getInstance().setSpoken("Enemy " + FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getName() + " hit!");
					FV.Pause(1000);
					System.out.println(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " hit. Health Points remaining " + FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getHP());
					System.out.println(FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getName() + " Health Points remaining " + FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getHP());
					FightModel.getInstance().setEnemyAttackable(true);
					FightModel.getInstance().setPlayerTurn(true);
				}

			}
			else
			{
				FightModel.getInstance().setSpoken(list.get(pos).getName() + " missed!");
				FV.Pause(1000);
				FightModel.getInstance().setPlayerAttackable(true);
				FightModel.getInstance().setEnemyAttackable(true);
				if(FightModel.getInstance().isPlayerTurn() == true)
				{
					FightModel.getInstance().setPlayerTurn(false);
				}
				else
				{
					FightModel.getInstance().setPlayerTurn(true);
				}
			}

			//Did the opponent faint
			//if yes
			if(oppList.get(oppPos).getHP() <= 0)
			{
				//tell user opponent fainted
				if(FightModel.getInstance().isPlayerTurn() == false)
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
					FightModel.getInstance().setPlayable(false);
				}
				//else determine which pokemon is selected
				else
				{
					if(FightModel.getInstance().isPlayerTurn() == false)
					{
						FightModel.getInstance().setSpoken ("ENEMY: " + oppList.get(oppPos).getName() + " THATS ENOUGH");
						FV.Pause(1000);
						FightModel.getInstance().setEnemyCurrent(left.get(RM.GenerateNumber(left.size())));
						FightModel.getInstance().setSpoken("ENEMY: " + oppList.get(FightModel.getInstance().getEnemyCurrent()).getName() + " I CHOOSE YOU");
						FV.Pause(1000);
						FightModel.getInstance().setSpeech(false);
						FightModel.getInstance().setMainScreen(true);
						FightModel.getInstance().setPlayerTurn(true);
					}
					else
					{
						FightModel.getInstance().setPlayerCurrent(left.get(0));
						FightModel.getInstance().setPlayerTurn(false);
					}
				}

			}
		}
		else if (choice == 6)
		{
			
			/*
			 * Code for allowing the opponent to change pokemon
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
					FightModel.getInstance().setPlayerTurn(true);
					
				}
			}
		}
	}
}
