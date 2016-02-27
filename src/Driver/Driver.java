package Driver;

import java.io.IOException;
import java.util.ArrayList;

import Controller.FightController;
import Model.FightModel;
import Model.PlayerCreate;
import Model.PokemonState;

public class Driver {

	public static void main(String[] args) throws IOException {
		PlayerCreate PC = new PlayerCreate();
		FightController FC = new FightController();
		FightModel.getInstance().setxPos(7);
		FightModel.getInstance().setyPos(76);
		
		ArrayList<PokemonState> currentPokemon = new ArrayList<PokemonState>();
		ArrayList<PokemonState> enemyPokemon = new ArrayList<PokemonState>();
		
		currentPokemon = PC.createPlayer("Player1.xlsx");
		enemyPokemon = PC.createPlayer("Enemy1.xlsx");
		currentPokemon = FC.runBattle(currentPokemon, enemyPokemon);
	}	

}