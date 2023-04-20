package HelloBob;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class helloBobTest {

	@Test
	void testHello1() {
		assertEquals(helloBob.hello("bob"),"Hello, Bob");
	}
	
	@Test
	void testHello2() {
		assertEquals(helloBob.hello("yoann"),"Hello, Yoann");
	}
	
	@Test
	void gestionNullandSpace() {
		assertEquals(helloBob.hello(""),"Hello, my friend");
	}
	void gestionNullandSpace2() {
		assertEquals(helloBob.hello("  "),"Hello, my friend");
	}
	void gestionNullandSpace3() {
		assertEquals(helloBob.hello("       "),"Hello, my friend");
	}
	

}
