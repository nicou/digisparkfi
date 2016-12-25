package me.nicou.digisparkfi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
	
	// This simple program converts a string to executable
	// DigiSpark Keyboard code for Finnish keyboard layout
	
	// DigiSpark Keyboard key names:
	// https://github.com/digistump/DigisparkArduinoIntegration/blob/master/libraries/DigisparkKeyboard/DigiKeyboard.h

	private final static String SHIFT = "MOD_SHIFT_LEFT";
	private final static String ALTGR = "MOD_ALT_RIGHT";
	private final static String NORMALKEYS = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ0123456789 ";
	
	public static void main(String[] args) {
		
		// Require only one argument
		if (args.length != 1) {
			System.out.println("Enter one argument");
			System.exit(0);
		}
		
		// Get input string and split each character into array
		String[] input = args[0].split("");
		
		// Get maps of special character and keycodes
		Map<String, SpecialCharacter> specialCharacterMap = getSpecialCharacterMap();
		Map<String, Integer> keycodes = getKeyCodes();
		
		
		// List of final code lines
		List<String> code = new ArrayList<String>();
		
		// Temporary variable for text to be printed with DigiKeyboard.print()
		String printable = "";
		
		// Loop through each input character and add to code list
		for (String character : input) {
			if (NORMALKEYS.indexOf(character) >= 0) {
				printable += character;
			} else if (specialCharacterMap.containsKey(character)) {
				if (printable.length() > 0) {
					code.add(printNormalCharacters(printable));
					printable = "";
				}
				code.add(printSpecialCharacter(specialCharacterMap.get(character)));
			} else if (keycodes.containsKey(character)) {
				if (printable.length() > 0) {
					code.add(printNormalCharacters(printable));
					printable = "";
				}
				code.add(printKeyCode(keycodes.get(character)));
			} else {
				code.add("// Unknown character: " + character);
			}
		}
		
		// Add remaining buffer to code list
		if (printable.length() > 0) {
			code.add(printNormalCharacters(printable));
		}
		
		// Print the code
		for (String line : code) {
			System.out.println(line);
		}

	}
	
	public static String printNormalCharacters(String printable) {
		return "DigiKeyboard.print('" + printable + "');";
	}
	
	public static String printSpecialCharacter(SpecialCharacter character) {
		return "DigiKeyboard.sendKeyStroke(" + character.getKey() + ", " + character.getModifier() + ");";
	}
	
	public static String printKeyCode(int keycode) {
		return "DigiKeyboard.sendKeyStroke(" + keycode + ");";
	}
	
	public static Map<String, SpecialCharacter> getSpecialCharacterMap() {
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
	
	public static Map<String, Integer> getKeyCodes() {
		Map<String, Integer> keycodes = new HashMap<String, Integer>();
		keycodes.put("'", 50);
		keycodes.put("+", 48);
		keycodes.put(",", 54);
		keycodes.put(".", 55);
		keycodes.put("-", 56);
		return keycodes;
	}

}
