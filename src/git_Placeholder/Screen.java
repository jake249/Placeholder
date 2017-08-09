package git_Placeholder;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Screen {
	
	public static void mainScreen() {
		try { 
		    AppGameContainer container = new AppGameContainer(new TileMap("Maps/fr.tmx")); 
		    container.setDisplayMode(800,600,false); 
		    container.start(); 
		} catch (SlickException e) { 
		    e.printStackTrace(); 
		}
	}
}
