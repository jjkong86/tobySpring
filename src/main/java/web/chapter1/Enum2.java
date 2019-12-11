package web.chapter1;

public enum Enum2 {
	str("string");
	String value;

	Enum2(String str) {
		this.value = str;
	}

	public String getValue() {
		return value;
	}
}
