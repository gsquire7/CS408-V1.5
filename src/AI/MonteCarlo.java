package AI;

import java.util.ArrayList;

import Controller.Calculations;
import Controller.MoveController;
import Controller.RandomGen;
import Model.MonteCarloTemp;
import Model.PokemonState;

public class MonteCarlo {
	
	int index = 1000;
	int firstChoice;
	int choice1 = 0; //move 1 won
	int choice2 = 0; //move 2 won
	int choice3 = 0; //move 3 won
	int choice4 = 0; //move 4 won
	int choice5 = 0; //struggle won
	int choice6 = 0; //changing pokemon won
	int opponent;
	int ai;
	int choice;
	boolean firstTurn;
	ArrayList<PokemonState> tempopponent = new ArrayList<PokemonState>();
	ArrayList<PokemonState> tempai = new ArrayList<PokemonState>();
	
	Random R = new Random();
	Calculations C = new Calculations();
	MoveController MC = new MoveController();
	RandomGen RM = new RandomGen();
	MonteCarloTemp MCT = new MonteCarloTemp();
	//take into account struggle
	//take into account PP
	
	
	/*
	 * This is a basic implementation of monte carlo
	 * the program plays x amount of games, keeping track of the first move
	 * both players are currently under the random AI
	 * if it wins the game using this move, then it adds it to that particular choice counter
	 * after x games, the move with the most wins is chosen
	 */
	
	
	public int generateMonteCarloChoice(int playerCurrent, int enemyCurrent, ArrayList<PokemonState> player, ArrayList<PokemonState> enemy) {
		
		index = 1000;
		choice1 = 0;
		choice2 = 0;
		choice3 = 0;
		choice4 = 0;
		choice5 = 0;
		choice6 = 0;
		while(index > 0)
		{
			
			System.out.println(index + "number of times");
			//player becomes enemy
			opponent = playerCurrent;
			ai = enemyCurrent;
			System.out.println(player.get(0).toString());
			System.out.println(player.get(1).toString());
			System.out.println(enemy.get(0).toString());
			System.out.println(enemy.get(1).toString());
			tempai.clear();
			tempopponent.clear();
			for(int i = 0; i < enemy.size(); i++)
			{
				tempopponent.add( new PokemonState(enemy.get(i).getId(), enemy.get(i).getPokemon(),
						enemy.get(i).getName(), enemy.get(i).getLevel(), enemy.get(i).getType(), 
						enemy.get(i).getXP(), enemy.get(i).getXPTotal(), enemy.get(i).getHP(), 
						enemy.get(i).getHPTotal(), enemy.get(i).getAttack(), enemy.get(i).getDefense(), 
						enemy.get(i).getSpeed(), enemy.get(i).getSpecialAttack(), enemy.get(i).getSpecialDefense(),
						enemy.get(i).getMove(0), enemy.get(i).getMove(1), enemy.get(i).getMove(2), 
						enemy.get(i).getMove(3), enemy.get(i).getMovePPMax(0), enemy.get(i).getMovePPMax(1),
						enemy.get(i).getMovePPMax(2), enemy.get(i).getMovePPMax(3),
						enemy.get(i).getMovePP(0), enemy.get(i).getMovePP(1), enemy.get(i).getMovePP(2), enemy.get(i).getMovePP(3),
						enemy.get(i).getPoison(), enemy.get(i).getFrozen(), enemy.get(i).getParalysed(), enemy.get(i).getConfused(),
						enemy.get(i).getBurned(), enemy.get(i).getSleeping(), enemy.get(i).getFrontPic(), enemy.get(i).getBackPic()));
			}
			for(int j = 0; j < player.size(); j++)
			{
				tempai.add( new PokemonState(player.get(j).getId(), player.get(j).getPokemon(),
						player.get(j).getName(), player.get(j).getLevel(), player.get(j).getType(), 
						player.get(j).getXP(), player.get(j).getXPTotal(), player.get(j).getHP(), 
						player.get(j).getHPTotal(), player.get(j).getAttack(), player.get(j).getDefense(), 
						player.get(j).getSpeed(), player.get(j).getSpecialAttack(), player.get(j).getSpecialDefense(),
						player.get(j).getMove(0), player.get(j).getMove(1), player.get(j).getMove(2), 
						player.get(j).getMove(3), player.get(j).getMovePPMax(0), player.get(j).getMovePPMax(1),
						player.get(j).getMovePPMax(2), player.get(j).getMovePPMax(3),
						player.get(j).getMovePP(0), player.get(j).getMovePP(1), player.get(j).getMovePP(2), player.get(j).getMovePP(3),
						player.get(j).getPoison(), player.get(j).getFrozen(), player.get(j).getParalysed(), player.get(j).getConfused(),
						player.get(j).getBurned(), player.get(j).getSleeping(), player.get(j).getFrontPic(), player.get(j).getBackPic()));
			}
			MCT.setPlayerParty(tempai);
			MCT.setEnemyParty(tempopponent);
			MCT.setEnemyCurrent(opponent);
			MCT.setPlayerCurrent(ai);
			MCT.setPlayable(true);
			MCT.setPlayerTurn(true);
			firstTurn = true;
			
			while(MCT.isPlayable() == true)
			{
				
				playerTurn();
				System.out.println(MCT.getPlayerParty().get(0).getName() + " _ " + MCT.getPlayerParty().get(0).getHP());
				System.out.println(MCT.getPlayerParty().get(1).getName() + " _ " + MCT.getPlayerParty().get(1).getHP());
				System.out.println(MCT.getEnemyParty().get(0).getName() + " _ " + MCT.getEnemyParty().get(0).getHP());
				System.out.println(MCT.getEnemyParty().get(1).getName() + " _ " + MCT.getEnemyParty().get(1).getHP());
				if(MCT.isPlayable() == true)
				{
				enemyTurn();
				System.out.println(MCT.getPlayerParty().get(0).getName() + " _ " + MCT.getPlayerParty().get(0).getHP());
				System.out.println(MCT.getPlayerParty().get(1).getName() + " _ " + MCT.getPlayerParty().get(1).getHP());
				System.out.println(MCT.getEnemyParty().get(0).getName() + " _ " + MCT.getEnemyParty().get(0).getHP());
				System.out.println(MCT.getEnemyParty().get(1).getName() + " _ " + MCT.getEnemyParty().get(1).getHP());
				}
			}
			
			index--;
			System.out.println("1 - " + choice1);
			System.out.println("2 - " + choice2);
			System.out.println("3 - " + choice3);
			System.out.println("4 - " + choice4);
			System.out.println("5 - " + choice5);
			System.out.println("6 - " + choice6);
			
		}
		
		if((choice1 >= choice2) && (choice1 >= choice3) && (choice1 >= choice4) && (choice1 >= choice5) && (choice1 >= choice6))
		{
			return 1;
		}
		else if((choice2 >= choice1) && (choice2 >= choice3) && (choice2 >= choice4) && (choice2 >= choice5) && (choice2 >= choice6))
		{
			return 2;
		}
		else if((choice3 >= choice1) && (choice3 >= choice2) && (choice3 >= choice4) && (choice3 >= choice5) && (choice3 >= choice6))
		{
			return 3;
		}
		else if((choice4 >= choice1) && (choice4 >= choice2) && (choice4 >= choice3) && (choice4 >= choice5) && (choice4 >= choice6))
		{
			return 4;
		}
		else if((choice5 >= choice1) && (choice5 >= choice2) && (choice5 >= choice3) && (choice5 >= choice4) && (choice5 >= choice6))
		{
			return 5;
		}
		else
		{
			return 6;
		}
		
		
		
	}
	
	public void enemyTurn() {
		MCT.setChoice(0);
		MCT.setStruggle(C.isStruggle(MCT.getEnemyParty(), MCT.getEnemyCurrent()));
		MCT.setChangeablePokemon(C.changeablePokemon(MCT.getEnemyParty()));
		System.out.println(MCT.getChangeablePokemon());
		while(MCT.isPlayerTurn() != true && MCT.isPlayable() == true)
		{
			System.out.println("ENEMY TURN");
			choice = (R.generateRandomChoice(MCT.getStruggle(), MCT.getChangeablePokemon()));
			choices(choice);
		}
	}
	
	public void playerTurn() {
		MCT.setChoice(0);
		MCT.setStruggle(C.isStruggle(MCT.getPlayerParty(), MCT.getPlayerCurrent()));
		MCT.setChangeablePokemon(C.changeablePokemon(MCT.getPlayerParty()));
		while(MCT.isPlayerTurn() == true && MCT.isPlayable() == true)
		{
			System.out.println("PLAYER TURN");
			choice = (R.generateRandomChoice(MCT.getStruggle(), MCT.getChangeablePokemon()));
			if(firstTurn == true)
			{
				firstChoice = choice;
				firstTurn = false;
			}
			choices(choice);
		}
	}

	public void choices(int choice)
	{
		int pos, oppPos;
		ArrayList<PokemonState> list, oppList;
		if(MCT.isPlayerTurn() == true)
		{
			pos = MCT.getPlayerCurrent();
			oppPos = MCT.getEnemyCurrent();
			list = MCT.getPlayerParty();
			oppList = MCT.getEnemyParty();
		}
		else
		{
			pos = MCT.getEnemyCurrent();
			oppPos = MCT.getPlayerCurrent();
			list = MCT.getEnemyParty();
			oppList = MCT.getPlayerParty();
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
				//					System.out.println("used " + list.get(pos).getMove(temp));
				MCT.setBase(C.getStrength(list.get(pos).getName(), list.get(pos).getMove(temp), true));
				list.get(pos).decrementMovePP(temp);
				healthChangeRatio = MC.getHealthRegeneration(list.get(pos).getMove(temp));
				if( healthChangeRatio != 0.0)
				{
					healthChange = true;
				}
			}
		}
		else if (choice == 5)
		{
			MCT.setBase(C.getStrength(list.get(pos).getName(), "STRUGGLE", true));
			healthChangeRatio = MC.getHealthRegeneration("STRUGGLE");
			healthChange = true;
		}

		if (choice < 6 && choice > 0)
		{
			//does the move hit due to accuracy
			MCT.setAccuracy(MC.getAccuracy(list.get(pos).getMove(choice - 1)));
			if(MCT.getAccuracy() < 100 && MCT.isPlayerTurn() == true)
			{
				MCT.setPlayerAttackable (C.accuracy(MCT.getAccuracy()));				
			}
			else if(MCT.getAccuracy() < 100 && MCT.isPlayerTurn() == false)
			{
				MCT.setEnemyAttackable (C.accuracy(MCT.getAccuracy()));				
			}
			//if the pokemon can attack then calculate damage
			if ((MCT.getPlayerAttackable() != false && MCT.isPlayerTurn() == true)
					|| (MCT.getEnemyAttackable() != false && MCT.isPlayerTurn() == false))
			{
				if(MCT.getBase() != 0)
				{
					MCT.setDamage(C.calcDamage(list.get(pos).getLevel(), list.get(pos).getAttack(), oppList.get(oppPos).getDefense(), MCT.getBase()));
					oppList.get(oppPos).setHP(C.attackStrength(oppList.get(oppPos).getHP(), MCT.getDamage()));
					//if move regenerates player hp, regenerate it
					if(healthChange == true)
					{
						int k = (int)(list.get(pos).getHP() + (healthChangeRatio * MCT.getDamage()));
						if(k > list.get(pos).getHPTotal())
						{
							list.get(pos).setHP(list.get(pos).getHPTotal());
						}
						else
						{
							list.get(pos).setHP((int) (list.get(pos).getHP() + (healthChangeRatio * MCT.getDamage())));
						}
					}
				}
				if(MCT.isPlayerTurn() == true)
				{
					MCT.setPlayerTurn(false);
				}
				else
				{
					MCT.setPlayerTurn(true);
				}

			}
			else
			{
				MCT.setPlayerAttackable(true);
				MCT.setEnemyAttackable(true);
				if(MCT.isPlayerTurn() == true)
				{
					MCT.setPlayerTurn(false);
				}
				else
				{
					MCT.setPlayerTurn(true);
				}
			}

			//Did the opponent faint
			//if yes
			if(oppList.get(oppPos).getHP() <= 0)
			{
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
					if(MCT.isPlayerTurn() == true)
					{
						if(firstChoice == 1)
						{
							choice1++;
						}
						else if(firstChoice == 2)
						{
							choice2++;
						}
						else if(firstChoice == 3)
						{
							choice3++;
						}
						else if(firstChoice == 4)
						{
							choice4++;
						}
						else if(firstChoice == 5)
						{
							choice5++;
						}
						else if(firstChoice == 6)
						{
							choice6++;
						}
						MCT.setPlayable(false);
					}
					else
					{
					MCT.setPlayable(false);
					}

				}
				//else determine which pokemon is selected
				else
				{
					if(MCT.isPlayerTurn() == false)
					{
						MCT.setEnemyCurrent(left.get(RM.GenerateNumber(left.size())));
						MCT.setPlayerTurn(true);
					}
					else
					{
						MCT.setPlayerCurrent(left.get(0));
						MCT.setPlayerTurn(false);
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

			if(MCT.isPlayerTurn() == false)
			{
				while(allowed == false)
				{
					int use = RM.GenerateNumber(MCT.getEnemyParty().size());
					if(use == MCT.getEnemyCurrent())
					{
						allowed = false;
					}
					else if(MCT.getEnemyParty().get(use).getHP() < 1)
					{
						allowed = false;
					}
					else
					{
						MCT.setEnemyCurrent(use);
						allowed = true;
						MCT.setPlayerTurn(true);
					}

				}
			}
			else
			{
				while(allowed == false)
				{
					int use = RM.GenerateNumber(MCT.getPlayerParty().size());
					if(use == MCT.getPlayerCurrent())
					{
						allowed = false;
					}
					else if(MCT.getPlayerParty().get(use).getHP() < 1)
					{
						allowed = false;
					}
					else
					{
						MCT.setPlayerCurrent(use);
						allowed = true;
						MCT.setPlayerTurn(false);
					}

				}
			}
		}
	}

}
