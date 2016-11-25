package entity.ui;

import java.awt.Font;
import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import game.Game;

public class FontLibrary {

	public static String standard = "lunchds.ttf";

	// Prepare a static "cache" mapping font names to Font objects.
	private static String[] names = { "lunchds.ttf" };

	private static Map<String, Font> cache = new ConcurrentHashMap<String, Font>(names.length);
	static {
		for (String name : names) {
			cache.put(name, getFont(name));
		}
	}

	public static Font getFont(String name) {
		Font font = null;
		if (cache != null) {
			if ((font = cache.get(name)) != null) {
				return font;
			}
		}
		String path = "/Res/Fonts/" + name;
		try {
			URL location = Game.class.getProtectionDomain().getCodeSource().getLocation();
			File file = new File(location.getFile());
			font = Font.createFont(Font.TRUETYPE_FONT, new File(file.getParentFile() + path));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println(path + " not loaded.  Using serif font.");
			font = new Font("serif", Font.PLAIN, 24);
		}
		return font;
	}
}
