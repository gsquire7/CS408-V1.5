package Model;


import java.util.ArrayList;

public class MonteCarloTemp {

	private boolean enemyHit = false, pokemonChanged = false, 
			changeablePokemon, playerAttackable = true, enemyAttackable = true, struggle = false;
	
	private int playerCurrent = 0, enemyCurrent = 0;
	private boolean playerTurn = true, playable = true, moveUsed;
	private int accuracy, base, damage, temppercent, choice;

	
	private ArrayList<PokemonState> playerParty = new ArrayList<PokemonState>();
	private ArrayList<PokemonState> enemyParty = new ArrayList<PokemonState>();
	
	
	public MonteCarloTemp() {
		
	}
	public int getChoice(){
		return choice;
	}
	public void setChoice(int x){
		choice = x;
	}
	public boolean isPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}

	public boolean isPlayable() {
		return playable;
	}

	public void setPlayable(boolean playable) {
		this.playable = playable;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getTemppercent() {
		return temppercent;
	}

	public void setTemppercent(int temppercent) {
		this.temppercent = temppercent;
	}
	public boolean getMoveUsed() {
		return moveUsed;
	}
	public void setMoveUsed(boolean moveUsed) {
		this.moveUsed = moveUsed;
	}
	public boolean getEnemyHit() {
		return enemyHit;
	}
	public void setEnemyHit(boolean enemyHit) {
		this.enemyHit = enemyHit;
	}
	public boolean getPokemonChanged() {
		return pokemonChanged;
	}
	public void setPokemonChanged(boolean pokemonChanged) {
		this.pokemonChanged = pokemonChanged;
	}
	public boolean getChangeablePokemon() {
		return changeablePokemon;
	}
	public void setChangeablePokemon(boolean changeablePokemon) {
		this.changeablePokemon = changeablePokemon;
	}
	public boolean getPlayerAttackable() {
		return playerAttackable;
	}
	public void setPlayerAttackable(boolean playerAttackable) {
		this.playerAttackable = playerAttackable;
	}
	public boolean getEnemyAttackable() {
		return enemyAttackable;
	}
	public void setEnemyAttackable(boolean enemyAttackable) {
		this.enemyAttackable = enemyAttackable;
	}
	public boolean getStruggle() {
		return struggle;
	}
	public void setStruggle(boolean struggle) {
		this.struggle = struggle;
	}
	public int getPlayerCurrent() {
		return playerCurrent;
	}
	public void setPlayerCurrent(int playerCurrent) {
		this.playerCurrent = playerCurrent;
	}
	public int getEnemyCurrent() {
		return enemyCurrent;
	}
	public void setEnemyCurrent(int enemyCurrent) {
		this.enemyCurrent = enemyCurrent;
	}
	public ArrayList<PokemonState> getPlayerParty() {
		return playerParty;
	}
	public void setPlayerParty(ArrayList<PokemonState> playerParty) {
		this.playerParty = playerParty;
	}
	public ArrayList<PokemonState> getEnemyParty() {
		return enemyParty;
	}
	public void setEnemyParty(ArrayList<PokemonState> enemyParty) {
		this.enemyParty = enemyParty;
	}	
}
