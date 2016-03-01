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
	AI.MonteCarlo AMC = new AI.MonteCarlo();
	Calculations C = new Calculations();
	Choices CH = new Choices();
	
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

		while(FightModel.getInstance().isPlayable() == true){
			FightModel.getInstance().setMainScreen(true);
			FightModel.getInstance().setSpeech(false);
			playerTurn();
			enemyTurn();
		}
		return FightModel.getInstance().getPlayerParty();
	}

	public void enemyTurn() {
		FightModel.getInstance().setChoice(0);
		FightModel.getInstance().setStruggle(C.isStruggle(FightModel.getInstance().getEnemyParty(), FightModel.getInstance().getEnemyCurrent()));
		boolean change = C.changeablePokemon(FightModel.getInstance().getEnemyParty());
		while(FightModel.getInstance().isPlayerTurn() != true && FightModel.getInstance().isPlayable() == true)
		{
			System.out.println("LUGIA TURN");
//			FightModel.getInstance().setChoice(AIR.generateRandomChoice(FightModel.getInstance().getStruggle(), change));
			FightModel.getInstance().setChoice(AMC.generateMonteCarloChoice(FightModel.getInstance().getPlayerCurrent(), 
					FightModel.getInstance().getEnemyCurrent(), FightModel.getInstance().getPlayerParty(), FightModel.getInstance().getEnemyParty()));
			CH.choices();
		}
	}

	public void playerTurn(){
		

		FightModel.getInstance().setStruggle(C.isStruggle(FightModel.getInstance().getPlayerParty(), FightModel.getInstance().getPlayerCurrent()));
		while(FightModel.getInstance().isPlayerTurn() == true && FightModel.getInstance().isPlayable() == true)
		{
			FV.Pause(10);
			//if move has been selected
			if(FightModel.getInstance().getSpeech() == true && FightModel.getInstance().getPokemonChanged() == false)
			{
				if(FightModel.getInstance().getxPos() == 7 && FightModel.getInstance().getyPos() == 76)
				{
					FightModel.getInstance().setChoice(1);
				}
				if(FightModel.getInstance().getxPos() == 52 && FightModel.getInstance().getyPos() == 76)
				{
					FightModel.getInstance().setChoice(2);
				}
				if(FightModel.getInstance().getxPos() == 7 && FightModel.getInstance().getyPos() == 86)
				{
					FightModel.getInstance().setChoice(3);
				}
				if(FightModel.getInstance().getxPos() == 52 && FightModel.getInstance().getyPos() == 86)
				{
					FightModel.getInstance().setChoice(4);
				}
				if(FightModel.getInstance().getStruggle() == true)
				{
					FightModel.getInstance().setChoice(5);
				}
				
				CH.choices();
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
				FightModel.getInstance().setPlayerTurn(false);
			}
		}
	}
}