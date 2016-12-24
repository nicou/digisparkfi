package me.nicou.digisparkfi;

import java.util.HashMap;
import java.util.Map;

public class Application {
	
	// https://github.com/digistump/DigisparkArduinoIntegration/blob/master/libraries/DigisparkKeyboard/DigiKeyboard.h

	private final static String SHIFT = "MOD_SHIFT_LEFT";
	private final static String ALTGR = "MOD_ALT_RIGHT";
	
	public static void main(String[] args) {

	}
	
	public Map<String, SpecialCharacter> getSpecialCharacterMap() {
		Map<String, SpecialCharacter> map = new HashMap<String, SpecialCharacter>();
		
		return map;
	}

}
