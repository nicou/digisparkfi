package me.nicou.digisparkfi;

import java.util.HashMap;
import java.util.Map;

public class Application {
	
	// https://github.com/digistump/DigisparkArduinoIntegration/blob/master/libraries/DigisparkKeyboard/DigiKeyboard.h

	private final static String SHIFT = "MOD_SHIFT_LEFT";
	private final static String ALTGR = "MOD_ALT_RIGHT";
	private final static String NORMALKEYS = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ0123456789";
	
	public static void main(String[] args) {

	}
	
	public Map<String, SpecialCharacter> getSpecialCharacterMap() {
		Map<String, SpecialCharacter> map = new HashMap<String, SpecialCharacter>();
		map.put("!", new SpecialCharacter("KEY_1", SHIFT));
		map.put("\"", new SpecialCharacter("KEY_2", SHIFT));
		map.put("#", new SpecialCharacter("KEY_3", SHIFT));
		map.put("%", new SpecialCharacter("KEY_5", SHIFT));
		map.put("&", new SpecialCharacter("KEY_6", SHIFT));
		map.put("/", new SpecialCharacter("KEY_7", SHIFT));
		map.put("(", new SpecialCharacter("KEY_8", SHIFT));
		map.put(")", new SpecialCharacter("KEY_9", SHIFT));
		map.put("=", new SpecialCharacter("KEY_0", SHIFT));
		map.put("@", new SpecialCharacter("KEY_2", ALTGR));
		map.put("$", new SpecialCharacter("KEY_4", ALTGR));
		map.put("{", new SpecialCharacter("KEY_7", ALTGR));
		map.put("[", new SpecialCharacter("KEY_8", ALTGR));
		map.put("]", new SpecialCharacter("KEY_9", ALTGR));
		map.put("}", new SpecialCharacter("KEY_0", ALTGR));
		return map;
	}
	
	public Map<String, Integer> getKeyCodes() {
		Map<String, Integer> keycodes = new HashMap<String, Integer>();
		keycodes.put("'", 50);
		keycodes.put("+", 48);
		keycodes.put(",", 54);
		keycodes.put(".", 55);
		keycodes.put("-", 56);
		return keycodes;
	}

}
