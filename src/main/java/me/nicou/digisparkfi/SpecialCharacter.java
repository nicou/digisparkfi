package me.nicou.digisparkfi;

public class SpecialCharacter {

	private String key;
	private String modifier;

	public SpecialCharacter() {
		super();
	}

	public SpecialCharacter(String key, String modifier) {
		super();
		this.key = key;
		this.modifier = modifier;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

}
