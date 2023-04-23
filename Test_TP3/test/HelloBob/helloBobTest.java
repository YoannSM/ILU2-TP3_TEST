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
	void gestionNullandSpace4() {
		assertEquals(helloBob.hello("    bob     "),"Hello, Bob");
	}
	
	@Test
	void gestionCri() {
		assertEquals(helloBob.hello("JERRY"),"HELLO, JERRY !");
	}
	
	@Test
	void gestionDeuxNoms() {
		assertEquals(helloBob.hello("amy,bob"),"Hello, Amy, Bob");
	}
	
	@Test
	void gestionDeuxNomsSpace() {
		assertEquals(helloBob.hello("  amy   ,  bob"),"Hello, Amy, Bob");
	}
	
	@Test
	void gestionPlusieursNoms() {
		assertEquals(helloBob.hello("amy,bob,jerry"),"Hello, Amy, Bob, Jerry");
	}
	void gestionPlusieursNomsSpace() {
		assertEquals(helloBob.hello("a my,bob,jer ry"),"Hello, Amy, Bob, Jerry");
	}
	void gestionPlusieursNomsMajAndSpace() {
		assertEquals(helloBob.hello("Amy,bob   ,jer ry"),"Hello, Amy, Bob, Jerry");
	}
	

}
