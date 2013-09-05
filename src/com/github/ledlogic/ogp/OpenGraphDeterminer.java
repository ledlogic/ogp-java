package com.github.ledlogic.ogp;

public enum OpenGraphDeterminer {
	DEFAULT(""),
	A("a"),
	AN("an"),
	THE("the"),
	AUTO("auto");
	
	String value;
	
	public String getValue() {
		return value;
	}

	private OpenGraphDeterminer(String value) {
		this.value = value;
	}
}