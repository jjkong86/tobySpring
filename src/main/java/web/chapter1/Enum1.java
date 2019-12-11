package web.chapter1;

public enum Enum1 {
	number(1);
	int value;

	Enum1(int number) {
		this.value = number;
	}

	public int getValue() {
		return value;
	}
}
