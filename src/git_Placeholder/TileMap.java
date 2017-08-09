package git_Placeholder;
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TileMap extends BasicGame {
	public Image down,up,right,left,uWalk1,uWalk2,dWalk1,dWalk2,rWalk1,rWalk2,lWalk1,lWalk2;
	private TiledMap map;
	private String t;
	private int mapX,mapY;
	private int x,y;
	private int tileSize = 32;
	private int direction;
	private Animation upWalk,downWalk,rightWalk,leftWalk;
	private boolean movement;

	
	public TileMap(String t) throws SlickException {
		super("Game");
		this.t = t;
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
	
		map.render(x-32,y-32,mapX,mapY,arg0.getWidth()/tileSize+32,arg0.getHeight()/tileSize+32);

		if(direction == 1) {
			if(movement == true) {
				downWalk.draw(arg0.getWidth()/2+tileSize/2,arg0.getHeight()/2+tileSize/2);
			}
			else {
				down.draw(arg0.getWidth()/2+tileSize/2,arg0.getHeight()/2+tileSize/2);
			}
		}
		else if(direction == 2) {
			if(movement == true) {
				upWalk.draw(arg0.getWidth()/2+tileSize/2,arg0.getHeight()/2+tileSize/2);
			}
			else {
				up.draw(arg0.getWidth()/2+tileSize/2,arg0.getHeight()/2+tileSize/2);
			}
		}
		else if(direction == 3) {
			if(movement == true) {
				leftWalk.draw(arg0.getWidth()/2+tileSize/2,arg0.getHeight()/2+tileSize/2);
			}
			else {
				left.draw(arg0.getWidth()/2+tileSize/2,arg0.getHeight()/2+tileSize/2);
			}
		}
		else if(direction == 4) {
			if(movement == true) {
				rightWalk.draw(arg0.getWidth()/2+tileSize/2,arg0.getHeight()/2+tileSize/2);
			}
			else {
				right.draw(arg0.getWidth()/2+tileSize/2,arg0.getHeight()/2+tileSize/2);
			}
		}
	}
	
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
	    Input input = arg0.getInput();
	    
	    if(input.isKeyDown(Input.KEY_DOWN)) {
	    	movement = true;
	    	if(direction != 1) {
	    		direction = 1;
	    	}
	    	else {
	    		y-= arg1 * 0.2f;
	    	}
	    }
	    else if(input.isKeyDown(Input.KEY_UP)) {
	    	movement = true;
	    	if(direction != 2) {
	    		direction = 2;
	    	}
	    	else {
	    		y+= arg1 * 0.2f;
	    	}
	    }
	    else if(input.isKeyDown(Input.KEY_LEFT)) {
	    	movement = true;
	    	if(direction != 3) {
	    		direction = 3;
	    	}
	    	else {
	    		x+= arg1 * 0.2f;
	    	}
	    }
	    else if(input.isKeyDown(Input.KEY_RIGHT)) {
	    	movement = true;
	    	if(direction != 4) {
	    		direction = 4;
	    	}
	    	else {
	    		x-= arg1 * 0.2f;
	    	}
	    }
	    
	    if (input.isKeyDown(Input.KEY_DOWN) == false && direction == 1 ||
	    	input.isKeyDown(Input.KEY_UP) == false && direction == 2 ||
	    	input.isKeyDown(Input.KEY_LEFT) == false && direction == 3 ||
	    	input.isKeyDown(Input.KEY_RIGHT) == false && direction == 4) {
	    		movement = false;
	    }
	    
	    if(x<0) {
	    	mapX++;
	    	x = 32;
	    }
	    
	    else if(x>32) {
	    	mapX--;
	    	x = 0;
	    }
	    else if(y<0) {
	    	mapY++;
	    	y = 32;
	    }
	    
	    else if(y>32) {
	    	mapY--;
	    	y = 0;
	    }
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		map = new TiledMap(t);
		direction = 1;
		
		down = new Image("Game Assets/pandafront.png");
		up = new Image("Game Assets/pandaback.png");
		right = new Image("Game Assets/pandaright.png");
		left = new Image("Game Assets/pandaleft.png");
		
		uWalk1 = new Image("Game Assets/PandaUPWalk1.png");
		uWalk2 = new Image("Game Assets/PandaUPWalk2.png");
		dWalk1 = new Image("Game Assets/PandaDOWNWalk1.png");
		dWalk2 = new Image("Game Assets/PandaDOWNWalk2.png");
		rWalk1 = new Image("Game Assets/PandaRIGHTWalk1.png");
		rWalk2 = new Image("Game Assets/PandaRIGHTWalk2.png");
		lWalk1 = new Image("Game Assets/PandaLEFTWalk1.png");
		lWalk2 = new Image("Game Assets/PandaLEFTWalk2.png");
		
		upWalk = new Animation();
		upWalk.addFrame(uWalk1, 150);
		upWalk.addFrame(uWalk2, 150);
		
		downWalk = new Animation();
		downWalk.addFrame(dWalk1, 150);
		downWalk.addFrame(dWalk2, 150);
		
		rightWalk = new Animation();
		rightWalk.addFrame(rWalk1, 150);
		rightWalk.addFrame(rWalk2, 150);
		
		leftWalk = new Animation();
		leftWalk.addFrame(lWalk1, 150);
		leftWalk.addFrame(lWalk2, 150);
	}
}
	

