package tilegame.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
/**
 * This class loads in fonts.
 * @author Kenneth Lange
 * M: Engine
 */
public class FontLoader {

	/**
	 * Loading in new font using the path that was passed into the method.
	 * It then sets up that font style to be PLAIN style, as in basic form of that
	 * font and sets its size using the size that was passed into the method.
	 * @param path
	 * @param size
	 * @return
	 */
	public static Font loadFont(String path, float size) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
