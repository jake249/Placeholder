package git_Placeholder;

public class Player extends Character{
	private static Player player;
	private Weapon equippedWeapon = null;
	private Player() {
		
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
}
