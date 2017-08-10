import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Screen {
	
	public static void mainScreen() {
		try { 
		    AppGameContainer container = new AppGameContainer(new TileMap("Maps/fr.tmx",0,0));  //reads and presents tilemap
		    container.setDisplayMode(640,480,false); 
		    container.setAlwaysRender(true);
		    container.setTargetFrameRate(60);
		    container.isShowingFPS();
		    container.start();
		} catch (SlickException e) { 
		    e.printStackTrace(); 
		}
	}
}
