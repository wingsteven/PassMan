package wingsteven.passman;

import java.security.SecureRandom;

public class DiceRoller {

	private static final SecureRandom random = new SecureRandom();

	public static int rollXd2(int x) {
		return rollXdY(x, 2);
	}

	public static int roll1d2() {
		return rollXd2(1);
	}

	public static int rollXd3(int x) {
		return rollXdY(x, 3);
	}

	public static int roll1d3() {
		return rollXd3(1);
	}

	public static int rollXd4(int x) {
		return rollXdY(x, 4);
	}

	public static int roll1d4(){
		return rollXd4(1);
	}

	public static int rollXd6(int x) {
		return rollXdY(x, 6);
	}

	public static int roll1d6() {
		return rollXd6(1);
	}

	public static int rollXd8(int x) {
		return rollXdY(x, 8);
	}

	public static int roll1d8() {
		return rollXd8(1);
	}

	public static int rollXd10(int x) {
		return rollXdY(x, 10);
	}

	public static int roll1d10() {
		return rollXd10(1);
	}

	public static int rollXd12(int x) {
		return rollXdY(x, 12);
	}

	public static int roll1d12() {
		return rollXd12(1);
	}

	public static int rollXd20(int x) {
		return rollXdY(x, 20);
	}

	public static int roll1d20() {
		return rollXd20(1);
	}

	private static int rollXdY(int x, int y) {
		return random.nextInt(y) + x;
	}

	public static int[] rollXd6Individual(int x) {
		int[] rolls = new int[x];
		for (int i = 0; i < x; i++) {
			rolls[i] = roll1d6();
		}
		return rolls;
	}

}
