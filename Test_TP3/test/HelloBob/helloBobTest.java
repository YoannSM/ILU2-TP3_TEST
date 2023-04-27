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
		assertEquals(helloBob.hello("amy,bob"),"Hello, Amy and Bob.");
	}
	
	@Test
	void gestionDeuxNomsSpace() {
		assertEquals(helloBob.hello("  amy   ,  bob"),"Hello, Amy and Bob.");
	}
	
	@Test
	void gestionPlusieursNoms() {
		assertEquals(helloBob.hello("amy,bob,jerry"),"Hello, Amy, Bob and Jerry.");
	}
	@Test
	void gestionPlusieursNomsSpace() {
		assertEquals(helloBob.hello("a my,bob,jer ry"),"Hello, Amy, Bob and Jerry.");
	}
	@Test
	void gestionPlusieursNomsMajAndSpace() {
		assertEquals(helloBob.hello("Amy,bob   ,jer ry"),"Hello, Amy, Bob and Jerry.");
	}
	
	@Test
	void gestionSplitCri() {
		assertEquals(helloBob.hello("Amy,BOB,Jerry"),"Hello, Amy and Jerry. AND HELLO,BOB !");
	}
	
	@Test
	void gestionSplitCriSpace() {
		assertEquals(helloBob.hello(" A my  ,B  OB,J  er ry"),"Hello, Amy and Jerry. AND HELLO,BOB !");
	}
	
	@Test
	void gestionSplitCriSpace3() {
		assertEquals(helloBob.hello("Amy,BOB,Jerry,Adam"),"Hello, Amy, Jerry and Adam. AND HELLO,BOB !");
	}
	
	@Test
	void verifAnd() {
		assertEquals(helloBob.hello("Amy,BOB,Jerry,ADAM"),"Hello, Amy and Jerry. AND HELLO,BOB AND ADAM !");
	}
	
	@Test
	void verifListAndSpace() {
		assertEquals(helloBob.hello("Am    y,BO  B,    Je    rry,ADAM"),"Hello, Amy and Jerry. AND HELLO,BOB AND ADAM !");
	}
	
	@Test
	void verifAndSpace() {
		assertEquals(helloBob.hello("am   y ,     bob"),"Hello, Amy and Bob.");
	}
	
	@Test
	void cptNbFois(){
		assertEquals(helloBob.hello("bob,JERRY,amy,bob,JERRY,PAUL,bob"),"Hello, Bob(x3) and Amy. AND HELLO,,JERRY(X2) AND PAUL !");
	}
	
	@Test
	void cptNbFoisv2() {
		assertEquals(helloBob.hello("bob,B o b , b   o b ,JERRY , J E R R Y , PAUL, P A U L,e l e a"),"Hello, Bob(x3) and Elea. AND HELLO,,JERRY(X2) AND PAUL(X2) !");
	}
	
	@Test
	void cpt() {
		assertEquals(helloBob.hello("  ,  "),"Hello, my friend");
	}
	
	

}
