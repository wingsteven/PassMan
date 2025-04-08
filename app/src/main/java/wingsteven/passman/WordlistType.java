package wingsteven.passman;

public enum WordlistType {
	LARGE(5), SHORT1(4), SHORT2(4);

	int diceCount;

	WordlistType(int diceCount) {
		this.diceCount = diceCount;
	}

	int getDiceCount() {
		return diceCount;
	}

}
