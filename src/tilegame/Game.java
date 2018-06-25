package tilegame;

import org.lwjgl.opengl.Display;

import tilegame.display.Graphics;
import tilegame.display.EngineDisplay;
import tilegame.gfx.Assets;
import tilegame.gfx.GameCamera;
import tilegame.input.Input;
import tilegame.input.Mouse;
import tilegame.state.GameState;
import tilegame.state.MenuState;
import tilegame.state.State;

/**
 * Holds all of the base code for the game.
 * @author Kenneth Lange
 *
 */
public class Game implements Runnable{ //Must implement Runnable in order for it to use a thread
	private EngineDisplay display;
	private int width, height;
	public String title;
	
	private static final int FPS = 60;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
	
	//Input
	private Input input;
	private Mouse mouse;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width){
		this.width = width;
		height = width / 16 * 9;
		this.title = title;
		input = new Input();
		mouse = new Mouse();
		
		g = new Graphics();
	}
	/**
	 * This method initializes the graphics for the game
	 */
	private void init(){
		display = new EngineDisplay(title, width, height);//creates new display
		//Inputs
//		display.getFrame().addKeyListener(input);
//		display.getFrame().addMouseListener(mouse);
//		display.getFrame().addMouseMotionListener(mouse);
//		display.getCanvas().addMouseListener(mouse);
//		display.getCanvas().addMouseMotionListener(mouse);
		//Pictures
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		//Initialize States
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);//Sets the initial state of the window upon starting the game
	}
	/**
	 * This method acts as an updater keeping track of objects' and window's new locations/
	 */
	private void update(){//updates positions etc.		
		if(State.getState() != null)
			State.getState().update();
	}
	/**
	 * This method takes the updated locations and draws them to the screen.
	 */
	private void render(){//draws updated positions to the screen
		if(State.getState() != null)
			State.getState().render(g);
	}
	/**
	 * This method runs the game and sets a base for how often it can update and render.
	 */
	public void run() {
		
		init();
		
		while (!Display.isCloseRequested()) {
			update();
			render();
			
			g.drawLine(0, 0, 100, 100);

			Display.update(); //updates
			Display.sync(FPS); //sets fps in sync mode
		}
		
		Display.destroy();
	}
	
	//Getters and Setters
	public Input getInput(){
		return input;
	}
	
	public Mouse getMouse() {
		return mouse;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
