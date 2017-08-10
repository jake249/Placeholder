
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
	private int x,y;
	private int mapX,mapY;
	private int tileSize = 32;
	String collision;
	int ID;
	private int direction;
	private Animation upWalk,downWalk,rightWalk,leftWalk;
	private boolean movement;

	
	public TileMap(String t, int mapX, int mapY) throws SlickException {
		super("Game");
		this.t = t;
		this.mapX = mapX;
		this.mapY = mapY;
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		int test = arg0.getWidth()/tileSize;
		int test1 = arg0.getHeight()/tileSize;
		int test2 = test/2;
		int test3 = test1/2;
		
		map.render(x-32,y-32,mapX-test2-1,mapY-test3-2,arg0.getWidth(),arg0.getHeight());
		

		if(direction == 1) {
			if(movement == true) {
				downWalk.draw(arg0.getWidth()/2, arg0.getHeight()/2);
			}
			else {
				down.draw(arg0.getWidth()/2, arg0.getHeight()/2);
			}
		}
		else if(direction == 2) {
			if(movement == true) {
				upWalk.draw(arg0.getWidth()/2, arg0.getHeight()/2);
			}
			else {
				up.draw(arg0.getWidth()/2, arg0.getHeight()/2);
			}
		}
		else if(direction == 3) {
			if(movement == true) {
				leftWalk.draw(arg0.getWidth()/2, arg0.getHeight()/2);
			}
			else {
				left.draw(arg0.getWidth()/2, arg0.getHeight()/2);
			}
		}
		else if(direction == 4) {
			if(movement == true) {
				rightWalk.draw(arg0.getWidth()/2, arg0.getHeight()/2);
			}
			else {
				right.draw(arg0.getWidth()/2, arg0.getHeight()/2);
			}
		}
	}
	
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
	    Input input = arg0.getInput();
	    try {
		    if(input.isKeyDown(Input.KEY_DOWN)) {
		    	direction = 1;
		    	ID = map.getTileId(mapX, mapY+2, 1);
		    	collision = map.getTileProperty(ID, "t", "def");
		    	System.out.println(collision);
		    	
		    	
		    	if(collision.equalsIgnoreCase("true")) {
		    		movement = false;
		    	}
		    	else {
		    		movement = true;
			    	y-= arg1 * 0.2f;
		    	}
		    }
		    else if(input.isKeyDown(Input.KEY_UP)) {
		    	direction = 2;
		    	ID = map.getTileId(mapX, mapY-1, 1);
		    	collision = map.getTileProperty(ID, "t", "def");
		    	System.out.println(collision);
		    	
		    	if(collision.equalsIgnoreCase("true")) {
		    		movement = false;
		    	}
		    	else {
		    		movement = true;
			    		y+= arg1 * 0.2f;
		    	}
		    }
		    else if(input.isKeyDown(Input.KEY_LEFT)) {
		    	direction = 3;
		    	ID = map.getTileId(mapX-2, mapY, 1);
		    	collision = map.getTileProperty(ID, "t", "def");
		    	System.out.println(collision);
		    	
		    	if(collision.equalsIgnoreCase("true")) {
		    		movement = false;
		    	}
		    	else {
		    		movement = true;
			    		x+= arg1 * 0.2f;
			    }
		    }
		    else if(input.isKeyDown(Input.KEY_RIGHT)) {
		    	direction = 4;
		    	ID = map.getTileId(mapX, mapY, 1);
		    	collision = map.getTileProperty(ID, "t", "def");
		    	System.out.println(collision);
		    	
		    	if(collision.equalsIgnoreCase("true")) {
		    		movement = false;
		    	}
		    	else {
		    		movement = true;
			    		x-= arg1 * 0.15f;
			    }
		    }
		    System.out.println("X: " + x);
		    System.out.println("Y: " + y);
	    }
	    catch(Exception e) {
	    	
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
	    System.out.println(mapX);
	    System.out.println(mapY);
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
	

