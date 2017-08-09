package git_Placeholder;

import java.lang.reflect.Array;

public class Player extends Character{
	private static Player player;
	private Weapon equippedWeapon = null;
	private final int INVENTORY_SIZE = 5;
	private Item[] inventory = new Item[INVENTORY_SIZE];
	private Player() {
		super();
	}
	
	public static Player getInstance() {
		if (player == null) {
			player = new Player();
		}
		return player;
	}
	
	public void setEquippedWeapon(Weapon weapon) {
		this.equippedWeapon = weapon;
	}
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	
	public Item[] getInventory() {
		return inventory;
	}
	
	public void setInventorySlot(int slot, Item item) {
		inventory[slot] = item;
	}
}
