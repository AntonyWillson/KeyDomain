package model;

public class Golden extends Artifacts {
	public double multi;
	public Golden(String name, String type, int attack, int damage,double multi) {
		super(name, type, attack,damage);
		this.multi = multi;
	}

}
