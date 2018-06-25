package tilegame.gfx;

import java.awt.image.BufferedImage;

import org.newdawn.slick.opengl.Texture;
/**
 * This Class is responsible for splitting up sprite sheets into multiple images.
 * @author Kenneth Lange
 *
 */
public class SpriteSheet {
	
	private BufferedImage sheet;
	/**
	 * This constructor receives the image that needs to be modified.
	 * @param sheet
	 */
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	/**
	 * This crops a sprite sheet to get the subimage within the picture.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public Texture crop(int x, int y, int width, int height){
		return (Texture) sheet.getSubimage(x*width, y*height, width, height);
	}
}
