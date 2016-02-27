package Model;
public class MoveEffects {
	private String name; 
	private String type; 
	private int strength; 
	private int accuracy; 
	private int pp;
	private double healthRegeneration;
	private int attackerAttack;
	private int defenderAttack;
	private int attackerDefense;
	private int defenderDefense;
	private int attackerSpeed;
	private int defenderSpeed;
	private int attackerSPAttack;
	private int defenderSPAttack;
	private int attackerSPDefense;
	private int defenderSPDefense;
	private double criticalMultiplier;
	private double poison;
	private double frozen;
	private double paralysed;
	private double confusion;
	private double burned;
	private double attackerSleep; 
	private double defenderSleep;
	private double attackerSpeedRatio;
	private int exceptionsOdds;
	
	public MoveEffects(String name, String type, int strength, int accuracy, int pp,
			double healthRegeneration, int attackerAttack, int defenderAttack,
			int attackerDefense, int defenderDefense,
			int attackerSpeed, int defenderSpeed,
			int attackerSPAttack, int defenderSPAttack,
			int attackerSPDefense, int defenderSPDefense,
			double criticalMultiplier, double poison, double frozen,
			double paralysed, double confusion, double burned,
			double attackerSleep, double defenderSleep,
			double attackerSpeedRatio, int exceptionsOdds)
	{
		this.name = name;
		this.type = type;
		this.strength = strength;
		this.accuracy = accuracy;
		this.pp = pp;
		this.healthRegeneration = healthRegeneration;
		this.attackerAttack = attackerAttack;
		this.defenderAttack = defenderAttack;
		this.attackerDefense = attackerDefense;
		this.defenderDefense = defenderDefense;
		this.attackerSpeed = attackerSpeed;
		this.defenderSpeed = defenderSpeed;
		this.attackerSPAttack = attackerSPAttack;
		this.defenderSPAttack = defenderSPAttack;
		this.attackerSPDefense= attackerSPDefense;
		this.defenderSPDefense = attackerSPDefense;
		this.criticalMultiplier = criticalMultiplier;
		this.poison = poison;
		this.frozen = frozen;
		this.paralysed = paralysed;
		this.confusion = confusion;
		this.burned = burned;
		this.attackerSleep = attackerSleep; 
		this.defenderSleep = defenderSleep;
		this.attackerSpeedRatio = attackerSpeedRatio;
		this.exceptionsOdds = exceptionsOdds;
	}
	
	public String moveToString()
	{
		return name + "\t" + type + "\t" + strength + "\t" + accuracy + "\t" + pp + "\t" + healthRegeneration + "\t" + attackerAttack + "\t" + defenderAttack + "\t" + attackerDefense + "\t" + defenderDefense + "\t" + 
		 attackerSpeed + "\t" + defenderSpeed + "\t" + attackerSPAttack + "\t" + defenderSPAttack + "\t" + attackerSPDefense + "\t" + defenderSPDefense + "\t" + criticalMultiplier + "\t" +
		 poison + "\t" + frozen + "\t" + paralysed + "\t" + confusion + "\t" + burned + "\t" + attackerSleep + "\t" + defenderSleep + "\t" + attackerSpeedRatio + "\t" + exceptionsOdds;
		
	}
	public String getName()
	{ 
		return name;
	}
	
	public String getType()
	{ 
		return type;
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public int getAccuracy()
	{
		return accuracy;
	}
	
	public int getExceptionsOdds()
	{
		return exceptionsOdds;
	}
	public double getHealthRegeneration()
	{
		return healthRegeneration;
	}
	public int getPP()
	{
		return pp;
	}
	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getAttackerAttack() {
		return attackerAttack;
	}

	public void setAttackerAttack(int attackerAttack) {
		this.attackerAttack = attackerAttack;
	}

	public int getDefenderAttack() {
		return defenderAttack;
	}

	public void setDefenderAttack(int defenderAttack) {
		this.defenderAttack = defenderAttack;
	}

	public int getAttackerDefense() {
		return attackerDefense;
	}

	public void setAttackerDefense(int attackerDefense) {
		this.attackerDefense = attackerDefense;
	}

	public int getDefenderDefense() {
		return defenderDefense;
	}

	public void setDefenderDefense(int defenderDefense) {
		this.defenderDefense = defenderDefense;
	}

	public int getAttackerSpeed() {
		return attackerSpeed;
	}

	public void setAttackerSpeed(int attackerSpeed) {
		this.attackerSpeed = attackerSpeed;
	}

	public int getDefenderSpeed() {
		return defenderSpeed;
	}

	public void setDefenderSpeed(int defenderSpeed) {
		this.defenderSpeed = defenderSpeed;
	}

	public int getAttackerSPAttack() {
		return attackerSPAttack;
	}

	public void setAttackerSPAttack(int attackerSPAttack) {
		this.attackerSPAttack = attackerSPAttack;
	}

	public int getDefenderSPAttack() {
		return defenderSPAttack;
	}

	public void setDefenderSPAttack(int defenderSPAttack) {
		this.defenderSPAttack = defenderSPAttack;
	}

	public int getAttackerSPDefense() {
		return attackerSPDefense;
	}

	public void setAttackerSPDefense(int attackerSPDefense) {
		this.attackerSPDefense = attackerSPDefense;
	}

	public int getDefenderSPDefense() {
		return defenderSPDefense;
	}

	public void setDefenderSPDefense(int defenderSPDefense) {
		this.defenderSPDefense = defenderSPDefense;
	}

	public double getCriticalMultiplier() {
		return criticalMultiplier;
	}

	public void setCriticalMultiplier(double criticalMultiplier) {
		this.criticalMultiplier = criticalMultiplier;
	}

	public double getPoison() {
		return poison;
	}

	public void setPoison(double poison) {
		this.poison = poison;
	}

	public double getFrozen() {
		return frozen;
	}

	public void setFrozen(double frozen) {
		this.frozen = frozen;
	}

	public double getParalysed() {
		return paralysed;
	}

	public void setParalysed(double paralysed) {
		this.paralysed = paralysed;
	}

	public double getConfusion() {
		return confusion;
	}

	public void setConfusion(double confusion) {
		this.confusion = confusion;
	}

	public double getBurned() {
		return burned;
	}

	public void setBurned(double burned) {
		this.burned = burned;
	}

	public double getAttackerSleep() {
		return attackerSleep;
	}

	public void setAttackerSleep(double attackerSleep) {
		this.attackerSleep = attackerSleep;
	}

	public double getDefenderSleep() {
		return defenderSleep;
	}

	public void setDefenderSleep(double defenderSleep) {
		this.defenderSleep = defenderSleep;
	}

	public double getAttackerSpeedRatio() {
		return attackerSpeedRatio;
	}

	public void setAttackerSpeedRatio(double attackerSpeedRatio) {
		this.attackerSpeedRatio = attackerSpeedRatio;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public void setHealthRegeneration(double healthRegeneration) {
		this.healthRegeneration = healthRegeneration;
	}

	public void setExceptionsOdds(int exceptionsOdds) {
		this.exceptionsOdds = exceptionsOdds;
	}
}
