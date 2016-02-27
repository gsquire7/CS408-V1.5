package Model;

import java.util.ArrayList;

public class FightModel {

	private static final FightModel INSTANCE = new FightModel();
	private boolean mainScreen = false, speech = true, moves = false, moveUsed = false, change = false,
			pack = false, playerControl = true, enemyHit = false, pokemonChanged = false, run = false, 
			changeablePokemon, playerAttackable = true, enemyAttackable = true, struggle = false;
	
	private int L = 10, xPos = 7 * L, yPos = 76 * L, totalWidth = 1000, totalHeight = 1000, ballLeft = 7 * L,
			ballRight = 52 * L, writingLeft = 10 * L, writingRight = 55 * L, ppWidth = 30 * L, 
			upperWriting = 78 * L, lowerWriting = 88 * L, expPercent, EnemyHPPercent, PlayerHPPercent,
			playerCurrent = 0, enemyCurrent = 0;
	
	private String spoken;
	
	private ArrayList<PokemonState> playerParty = new ArrayList<PokemonState>();
	private ArrayList<PokemonState> enemyParty = new ArrayList<PokemonState>();
	
	
	private FightModel(){
	}
	
	public static FightModel getInstance(){
		return INSTANCE;
	}
	
	public boolean getMainScreen() {
		return mainScreen;
	}
	public void setMainScreen(boolean mainScreen) {
		this.mainScreen = mainScreen;
	}
	public boolean getSpeech() {
		return speech;
	}
	public void setSpeech(boolean speech) {
		this.speech = speech;
	}
	public boolean getMoves() {
		return moves;
	}
	public void setMoves(boolean moves) {
		this.moves = moves;
	}
	public boolean getMoveUsed() {
		return moveUsed;
	}
	public void setMoveUsed(boolean moveUsed) {
		this.moveUsed = moveUsed;
	}
	public boolean getChange() {
		return change;
	}
	public void setChange(boolean change) {
		this.change = change;
	}
	public boolean getPack() {
		return pack;
	}
	public void setPack(boolean pack) {
		this.pack = pack;
	}
	public boolean getPlayerControl() {
		return playerControl;
	}
	public void setPlayerControl(boolean playerControl) {
		this.playerControl = playerControl;
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
	public boolean getRun() {
		return run;
	}
	public void setRun(boolean run) {
		this.run = run;
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
	public int getL() {
		return L;
	}
	public void setL(int l) {
		L = l;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public int getTotalWidth() {
		return totalWidth;
	}
	public void setTotalWidth(int totalWidth) {
		this.totalWidth = totalWidth;
	}
	public int getTotalHeight() {
		return totalHeight;
	}
	public void setTotalHeight(int totalHeight) {
		this.totalHeight = totalHeight;
	}
	public int getBallLeft() {
		return ballLeft;
	}
	public void setBallLeft(int ballLeft) {
		this.ballLeft = ballLeft;
	}
	public int getBallRight() {
		return ballRight;
	}
	public void setBallRight(int ballRight) {
		this.ballRight = ballRight;
	}
	public int getWritingLeft() {
		return writingLeft;
	}
	public void setWritingLeft(int writingLeft) {
		this.writingLeft = writingLeft;
	}
	public int getWritingRight() {
		return writingRight;
	}
	public void setWritingRight(int writingRight) {
		this.writingRight = writingRight;
	}
	public int getPpWidth() {
		return ppWidth;
	}
	public void setPpWidth(int ppWidth) {
		this.ppWidth = ppWidth;
	}
	public int getUpperWriting() {
		return upperWriting;
	}
	public void setUpperWriting(int upperWriting) {
		this.upperWriting = upperWriting;
	}
	public int getLowerWriting() {
		return lowerWriting;
	}
	public void setLowerWriting(int lowerWriting) {
		this.lowerWriting = lowerWriting;
	}
	public int getExpPercent() {
		return expPercent;
	}
	public void setExpPercent(int expPercent) {
		this.expPercent = expPercent;
	}
	public int getEnemyHPPercent() {
		return EnemyHPPercent;
	}
	public void setEnemyHPPercent(int enemyHPPercent) {
		EnemyHPPercent = enemyHPPercent;
	}
	public int getPlayerHPPercent() {
		return PlayerHPPercent;
	}
	public void setPlayerHPPercent(int playerHPPercent) {
		PlayerHPPercent = playerHPPercent;
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
	public String getSpoken() {
		return spoken;
	}
	public void setSpoken(String spoken) {
		this.spoken = spoken;
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
