

public class Weapon extends Item{
	private int damage;
	private int durability;
	public Weapon (int damage, int durability) {
		super();
		this.damage = damage;
		this.durability = durability;
	}
	public Weapon () {
		super();
	}
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	
}
