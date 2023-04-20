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
	@Test
	void gestionNullandSpace2() {
		assertEquals(helloBob.hello("  "),"Hello, my friend");
	}
	@Test
	void gestionNullandSpace3() {
		assertEquals(helloBob.hello("         "),"Hello, my friend");
	}
	
	@Test
	void gestionCri() {
		assertEquals(helloBob.hello("JERRY"),"HELLO, JERRY !");
	}
	
	@Test
	void gestionDeuxNoms() {
		assertEquals(helloBob.hello("amy,bob"),"Hello, Amy,Bob");
	}
	

}
