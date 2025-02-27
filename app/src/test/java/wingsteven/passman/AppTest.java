package wingsteven.passman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
	@Test
	void appHasAGreeting() {
		App classUnderTest = new App();
		String greeting = classUnderTest.getGreeting();
		assertNotNull(greeting, "app should have a greeting");
		assertEquals(App.GREETING, greeting, "Greeting does not match");
	}

}