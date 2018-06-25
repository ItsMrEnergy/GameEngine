package tilegame.display;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.ARBTextureRectangle.GL_TEXTURE_RECTANGLE_ARB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.Color;
import org.lwjgl.util.ReadableColor;
import org.newdawn.slick.opengl.PNGDecoder;
import org.newdawn.slick.opengl.Texture;

import tilegame.debug.Debug;

public class Graphics {
	
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
		glEnd();
		glLoadIdentity();
	}
	
	//Still trying to fix
	//---------------------------------------------------------------------------------------------------------------
	public static int LoadTextureLinear(String location) {
		int texture = glGenTextures();
		glBindTexture(GL_TEXTURE_RECTANGLE_ARB, texture);
		InputStream in = null;
		try {
			in = new FileInputStream(location);
			PNGDecoder decoder = new PNGDecoder(in);
			ByteBuffer buffer = BufferUtils.createByteBuffer(4*decoder.getWidth()*decoder.getHeight());
			decoder.decode(buffer, decoder.getWidth(), PNGDecoder.RGBA);
			buffer.flip();
			in.close();
			glTexParameteri(GL_TEXTURE_RECTANGLE_ARB, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_RECTANGLE_ARB, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexImage2D(GL_TEXTURE_RECTANGLE_ARB, 0, GL_RGBA, decoder.getWidth(), decoder.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		} catch (FileNotFoundException e) {
			Debug.LogError("Texture in location :" + location + ": could not be found");
		} catch (IOException e) {
			Debug.LogError("Failed to load the texture file.");
			e.printStackTrace();
		}
		glBindTexture(GL_TEXTURE_RECTANGLE_ARB, 0);
		return texture;
	}
	
	
	
	//---------------------------------------------------------------------------------------------------------------
}
