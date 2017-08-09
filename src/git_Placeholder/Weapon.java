package git_Placeholder;

public class Weapon extends Item{
	private int damage;
	private int durability;
	public void weapon (int damage, int durability) {
		this.damage = damage;
		this.durability = durability;
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
