package model;

public abstract class Artifacts {
	protected String name;
	protected String type;
	protected int attack;
	protected int damage;

	public Artifacts(String name, String type, int attack,int damage) {
		super();
		this.name = name;
		this.type = type;
		this.attack = attack;
		this.damage = damage;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
}
