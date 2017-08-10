import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Screen {
	
	public static void mainScreen() {
		try { 
		    AppGameContainer container = new AppGameContainer(new TileMap("Maps/fr.tmx",5,5));  //reads and presents tilemap
		    container.setDisplayMode(1000,1000,false); 
		    container.setAlwaysRender(true);
		    container.setTargetFrameRate(60);
		    container.isShowingFPS();
		    container.start();
		} catch (SlickException e) { 
		    e.printStackTrace(); 
		}
	}
}
