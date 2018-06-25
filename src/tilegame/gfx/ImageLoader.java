package tilegame.gfx;

import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import tilegame.debug.Debug;
/**
 * This class is responsible for loading in images
 * @author Kenneth Lange
 *
 */
public class ImageLoader {
	/**
	 * This method tries to load in the selected image from the path and type given.
	 * @param path
	 * @return
	 */
	public static Texture loadImage(String path, String fileType){
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1); //If the image cannot be loaded, the window closes
			Debug.LogError(path + " was not loaded.");
		}
		return tex;
	}
	
	/**
	 * This method tries to load in the selected image from the path given and assumes it is a PNG.
	 * @param path
	 * @return
	 */
	public static Texture loadImage(String path){
		return loadImage(path, "PNG");
	}
}
