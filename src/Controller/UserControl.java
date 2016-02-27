package Controller;

import java.awt.event.KeyEvent;

import Model.FightModel;

public class UserControl{
/*
 * Class for dealing with all button presses, originally in view
 * has no business being in the view class though so i made it a user control method
 */
	public static void keyPress(int key)
	{
		if(key ==KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
		{
			System.out.println("LEFT");
			FightModel.getInstance().setxPos(7);
		}
		
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
		{
			System.out.println("RIGHT");
			FightModel.getInstance().setxPos(52);
		}
		
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
		{
			System.out.println("UP");
			if(FightModel.getInstance().getChange() == false && FightModel.getInstance().getPack() == false)
			{
				FightModel.getInstance().setyPos(76);
			}
			else if(FightModel.getInstance().getChange() == true)
			{
				if(FightModel.getInstance().getyPos() == (int)(75.5) && FightModel.getInstance().getPlayerParty().size() == 5)
				{
					FightModel.getInstance().setyPos((int)55.5);
				}
				else if(FightModel.getInstance().getyPos() == (int)(75.5) && FightModel.getInstance().getPlayerParty().size() == 4)
				{
					FightModel.getInstance().setyPos((int)45.5);
				}
				else if(FightModel.getInstance().getyPos() == (int)(75.5) && FightModel.getInstance().getPlayerParty().size() == 3)
				{
					FightModel.getInstance().setyPos((int)35.5);
				}
				else if(FightModel.getInstance().getyPos() == (int)(75.5) && FightModel.getInstance().getPlayerParty().size() == 2)
				{
					FightModel.getInstance().setyPos((int)25.5);
				}
				else if(FightModel.getInstance().getyPos() == (int)(75.5) && FightModel.getInstance().getPlayerParty().size() == 1)
				{
					FightModel.getInstance().setyPos((int)15.5);
				}
				else if(FightModel.getInstance().getyPos() == (int)(75.5))
				{
					FightModel.getInstance().setyPos(FightModel.getInstance().getyPos() - 10);
				}
				else if(FightModel.getInstance().getyPos() != (int)(15.5))
				{
					FightModel.getInstance().setyPos(FightModel.getInstance().getyPos() - 10);
				}
			}
		}
		
		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
		{
			System.out.println("DOWN");
			if(FightModel.getInstance().getChange() == false && FightModel.getInstance().getPack() == false)
			{
				FightModel.getInstance().setyPos(86);
			}
			else if(FightModel.getInstance().getChange() == true)
			{
				if(FightModel.getInstance().getyPos() == (int)(15.5) && FightModel.getInstance().getPlayerParty().size() > 1)
				{
					FightModel.getInstance().setyPos(FightModel.getInstance().getyPos() + 10);
				}
				else if(FightModel.getInstance().getyPos() == (int)(25.5)&& FightModel.getInstance().getPlayerParty().size() > 2)
				{
					FightModel.getInstance().setyPos(FightModel.getInstance().getyPos() + 10);
				}
				else if(FightModel.getInstance().getyPos() == (int)(35.5)&& FightModel.getInstance().getPlayerParty().size() > 3)
				{
					FightModel.getInstance().setyPos(FightModel.getInstance().getyPos() + 10);
				}
				else if(FightModel.getInstance().getyPos() == (int)(45.5)&& FightModel.getInstance().getPlayerParty().size() > 4)
				{
					FightModel.getInstance().setyPos(FightModel.getInstance().getyPos() + 10);
				}
				else if(FightModel.getInstance().getyPos() == (int)(55.5) && FightModel.getInstance().getPlayerParty().size() > 5)
				{
					FightModel.getInstance().setyPos(FightModel.getInstance().getyPos() + 10);
				}
				else if(FightModel.getInstance().getyPos() == (int)(65.5))
				{
					FightModel.getInstance().setyPos(FightModel.getInstance().getyPos() + 10);	
				}
				else
				{
					FightModel.getInstance().setyPos((int)(75.5));
				}
			}
		}
		//A BUTTON
		if (key == KeyEvent.VK_L)
		{
			System.out.println("A");
			//on main screen
			if(FightModel.getInstance().getMainScreen() ==true)
			{
				//selecting moves
//				Struggle(FightModel.getInstance().getPlayerParty(), FightModel.getInstance().getPlayerCurrent());
				if(FightModel.getInstance().getxPos() == 7 && FightModel.getInstance().getyPos() == 76 && FightModel.getInstance().getStruggle() == false)
				{
					FightModel.getInstance().setMainScreen(false);
					FightModel.getInstance().setMoves(true);
				}
				if(FightModel.getInstance().getxPos() == 7  && FightModel.getInstance().getyPos() == 76 && FightModel.getInstance().getStruggle() == true)
				{
					FightModel.getInstance().setMainScreen(false);
					FightModel.getInstance().setSpeech(true);
				}
				if(FightModel.getInstance().getxPos() == 52 && FightModel.getInstance().getyPos() == 76)
				{
					FightModel.getInstance().setMainScreen(false);
					FightModel.getInstance().setChange(true);
					FightModel.getInstance().setyPos((int)(15.5));
				}
				if(FightModel.getInstance().getxPos() == 52  && FightModel.getInstance().getyPos() == 86)
				{
					System.exit(0);
				}
			}
			//on move screen
			else if(FightModel.getInstance().getMoves() == true)
			{
				FightModel.getInstance().setMoves(false);
				FightModel.getInstance().setSpeech(true);

			}
			//on pokemon screen
			else if(FightModel.getInstance().getChange() == true)
			{
				if(FightModel.getInstance().getyPos() == (int)(15.5) && FightModel.getInstance().getPlayerCurrent() !=0 && FightModel.getInstance().getPlayerParty().size() > 0 && FightModel.getInstance().getPlayerParty().get(0).getHP() > 0)
				{
					FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " THATS ENOUGH!");
					FightModel.getInstance().setPokemonChanged(true);
					FightModel.getInstance().setPlayerCurrent(0);
				}
				if(FightModel.getInstance().getyPos() == (int)(25.5) && FightModel.getInstance().getPlayerCurrent() !=1 && FightModel.getInstance().getPlayerParty().size() > 1 && FightModel.getInstance().getPlayerParty().get(1).getHP() > 0)
				{
					FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " THATS ENOUGH!");
					FightModel.getInstance().setPokemonChanged(true);
					FightModel.getInstance().setPlayerCurrent(1);
				}
				if(FightModel.getInstance().getyPos() == (int)(35.5) && FightModel.getInstance().getPlayerCurrent() !=2 && FightModel.getInstance().getPlayerParty().size() > 2 && FightModel.getInstance().getPlayerParty().get(2).getHP() > 0)
				{
					FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " THATS ENOUGH!");
					FightModel.getInstance().setPokemonChanged(true);
					FightModel.getInstance().setPlayerCurrent(2);
				}
				if(FightModel.getInstance().getyPos() == (int)(45.5) && FightModel.getInstance().getPlayerCurrent() !=3 && FightModel.getInstance().getPlayerParty().size() > 3 && FightModel.getInstance().getPlayerParty().get(3).getHP() > 0)
				{
					FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " THATS ENOUGH!");
					FightModel.getInstance().setPokemonChanged(true);
					FightModel.getInstance().setPlayerCurrent(3);
				}
				if(FightModel.getInstance().getyPos() == (int)(55.5) && FightModel.getInstance().getPlayerCurrent() !=4 && FightModel.getInstance().getPlayerParty().size() > 4 && FightModel.getInstance().getPlayerParty().get(4).getHP() > 0)
				{
					FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " THATS ENOUGH!");
					FightModel.getInstance().setPokemonChanged(true);
					FightModel.getInstance().setPlayerCurrent(4);
				}
				if(FightModel.getInstance().getyPos() == (int)(65.5) && FightModel.getInstance().getPlayerCurrent() !=5 && FightModel.getInstance().getPlayerParty().size() > 5 && FightModel.getInstance().getPlayerParty().get(5).getHP() > 0)
				{
					FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " THATS ENOUGH!");
					FightModel.getInstance().setPokemonChanged(true);
					FightModel.getInstance().setPlayerCurrent(5);
				}
				
			}
			

		}
		//B BUTTON
		if (key == KeyEvent.VK_K)
		{
			System.out.println("B");
			if(FightModel.getInstance().getMoves() == true || FightModel.getInstance().getChange() == true)
			{

				FightModel.getInstance().setMainScreen(true);
				FightModel.getInstance().setChange(false);
				FightModel.getInstance().setMoves(false);
				FightModel.getInstance().setxPos(7);
				FightModel.getInstance().setyPos(76);

			}
		}
		
		if (key == KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}
	}
	
	
}
