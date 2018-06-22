package tilegame.display;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Display is the window class
 * @author Energy
 *
 */
public class EngineDisplay {
	
	private String title;
	private int width, height;
	
	public EngineDisplay(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	/**
	 * This method creates the display window;
	 */
	private void createDisplay(){
		Display.setTitle("");
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
		} catch (LWJGLException e) {e.printStackTrace();}
	}
}
