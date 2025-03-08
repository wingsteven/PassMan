package wingsteven.passman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceRollertTest {

	@Test
	void testRollSingleDie() {
		int one = 1;
		assertTrue(isDiceRollInRange(DiceRoller.roll1d2(), one, 2));
		assertTrue(isDiceRollInRange(DiceRoller.roll1d3(), one, 3));
		assertTrue(isDiceRollInRange(DiceRoller.roll1d4(), one, 4));
		assertTrue(isDiceRollInRange(DiceRoller.roll1d6(), one, 6));
		assertTrue(isDiceRollInRange(DiceRoller.roll1d8(), one, 8));
		assertTrue(isDiceRollInRange(DiceRoller.roll1d10(), one, 10));
		assertTrue(isDiceRollInRange(DiceRoller.roll1d12(), one, 12));
		assertTrue(isDiceRollInRange(DiceRoller.roll1d20(), one, 20));
	}

	@Test
	void testRollMultipleDiceTotal() {
		assertTrue(isDiceRollInRange(DiceRoller.rollXd2(4), 4, 8));
		assertTrue(isDiceRollInRange(DiceRoller.rollXd3(3), 3, 9));
		assertTrue(isDiceRollInRange(DiceRoller.rollXd4(5), 5, 20));
		assertTrue(isDiceRollInRange(DiceRoller.rollXd6(2), 2, 12));
		assertTrue(isDiceRollInRange(DiceRoller.rollXd8(1), 1, 8));
		assertTrue(isDiceRollInRange(DiceRoller.rollXd10(6), 6, 60));
		assertTrue(isDiceRollInRange(DiceRoller.rollXd12(4), 4, 48));
		assertTrue(isDiceRollInRange(DiceRoller.rollXd20(5), 5, 100));
	}

	private boolean isDiceRollInRange(int diceRoll, int min, int max) {
		return min <= diceRoll && max >= diceRoll;
	}

	@Test
	void testRollMultipleDiceIndividual() {
		int numberOfRolls = 5;
		int[] rolls = DiceRoller.rollXd6Individual(numberOfRolls);
		assertNotNull(rolls);
		assertEquals(numberOfRolls, rolls.length);
		for (int roll : rolls) {
			assertTrue(isDiceRollInRange(roll, 1, 6));
		}
	}
}
