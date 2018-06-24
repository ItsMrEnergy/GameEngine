package tilegame.display;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.Color;
import org.lwjgl.util.ReadableColor;
import org.newdawn.slick.opengl.Texture;

public class Graphics {
	
	public Graphics() {
		
	}
	
	public void setColor(Color c) {
		glColor4d(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	
	public void setColor(ReadableColor c) {
		glColor4d(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	
	public void drawLine(int x1, int y1, int x2, int y2) {
		glBegin(GL_LINES);
		glVertex2f(x1, y1);
		glVertex2f(x2, y2);			
		glEnd();
	}
	
	
	public void drawRect(int x, int y, int width, int height) {
		glBegin(GL_LINES);
		//Start to End
		glVertex2f(x, y);
		glVertex2f(x+width, y);
		//Start to End
		glVertex2f(x+width, y);
		glVertex2f(x+width, y+height);
		//Start to End
		glVertex2f(x+width, y+height);
		glVertex2f(x, y+height);
		//Start to End
		glVertex2f(x, y+height);
		glVertex2f(x, y);
		//Start to End
		glEnd();
	}
	
	public void fillRect(int x, int y, int width, int height) {
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x+width, y);
		glVertex2f(x+width, y+height);
		glVertex2f(x, y+height);
		glEnd();
	}

	public void drawImage(Texture texture, int x, int y, int width, int height) {
		texture.bind();
		glTranslatef((float) x, (float) y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glLoadIdentity();
		glEnd();
	}

}
