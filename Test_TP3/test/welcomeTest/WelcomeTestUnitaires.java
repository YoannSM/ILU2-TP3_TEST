package welcomeTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import welcome.Welcome;

class WelcomeTestUnitaires {

	@Test
	void testHello1() {
		assertEquals(Welcome.welcome("bob"),"Hello, Bob");
	}
	
	@Test
	void testHello2() {
		assertEquals(Welcome.welcome("yoann"),"Hello, Yoann");
	}
	
	@Test
	void gestionNullandSpace() {
		assertEquals(Welcome.welcome(""),"Hello, my friend");
	}
	@Test
	void gestionNullandSpace2() {
		assertEquals(Welcome.welcome("  "),"Hello, my friend");
	}
	@Test
	void gestionNullandSpace3() {
		assertEquals(Welcome.welcome("         "),"Hello, my friend");
	}
	
	@Test
	void gestionNullandSpace4() {
		assertEquals(Welcome.welcome("    bob     "),"Hello, Bob");
	}
	
	@Test
	void gestionCri() {
		assertEquals(Welcome.welcome("JERRY"),"HELLO,JERRY !");
	}
	
	@Test
	void gestionDeuxNoms() {
		assertEquals(Welcome.welcome("amy,bob"),"Hello, Amy and Bob.");
	}
	
	@Test
	void gestionDeuxNomsCri() {
		assertEquals(Welcome.welcome("JERRY,MAX"),"HELLO,JERRY AND MAX !");
	}
	
	@Test
	void gestionDeuxNomsSpace() {
		assertEquals(Welcome.welcome("  amy   ,  bob"),"Hello, Amy and Bob.");
	}
	
	@Test
	void gestionDeuxNomsCriSpace() {
		assertEquals(Welcome.welcome("J E R R Y       , M    A       X"),"HELLO,JERRY AND MAX !");
	}
	
	@Test
	void gestionPlusieursNoms() {
		assertEquals(Welcome.welcome("amy,bob,jerry"),"Hello, Amy, Bob and Jerry.");
	}
	@Test
	void gestionPlusieursNomsSpace() {
		assertEquals(Welcome.welcome("a my,bob,jer ry"),"Hello, Amy, Bob and Jerry.");
	}
	@Test
	void gestionPlusieursNomsMajAndSpace() {
		assertEquals(Welcome.welcome("Amy,bob   ,jer ry"),"Hello, Amy, Bob and Jerry.");
	}
	
	@Test
	void gestionSplitCri() {
		assertEquals(Welcome.welcome("Amy,BOB,Jerry"),"Hello, Amy and Jerry. AND HELLO,BOB !");
	}
	
	@Test
	void gestionSplitCriSpace() {
		assertEquals(Welcome.welcome(" A my  ,B  OB,J  er ry"),"Hello, Amy and Jerry. AND HELLO,BOB !");
	}
	
	@Test
	void gestionSplitCriSpace3() {
		assertEquals(Welcome.welcome("Amy,BOB,Jerry,Adam"),"Hello, Amy, Jerry and Adam. AND HELLO,BOB !");
	}
	
	@Test
	void verifAnd() {
		assertEquals(Welcome.welcome("Amy,BOB,Jerry,ADAM"),"Hello, Amy and Jerry. AND HELLO,BOB AND ADAM !");
	}
	
	@Test
	void verifListAndSpace() { 
		assertEquals(Welcome.welcome("Am    y,BO  B,    Je    rry,ADAM"),"Hello, Amy and Jerry. AND HELLO,BOB AND ADAM !");
	}
	
	@Test
	void verifAndSpace() {
		assertEquals(Welcome.welcome("am   y ,     bob"),"Hello, Amy and Bob.");
	}
	
	@Test
	void cptNbFois(){
		assertEquals(Welcome.welcome("bob,JERRY,amy,bob,JERRY,PAUL,bob"),"Hello, Bob(x3) and Amy. AND HELLO,,JERRY(X2) AND PAUL !");
	}
	
	@Test
	void cptNbFoisv2() {
		assertEquals(Welcome.welcome("bob,B o b , b   o b ,JERRY , J E R R Y , PAUL, P A U L,e l e a"),"Hello, Bob(x3) and Elea. AND HELLO,,JERRY(X2) AND PAUL(X2) !");
	}
	
	@Test
	void helloYoda() {
		assertEquals(Welcome.welcome("bob, yoda, amy, JERRY"),"Bob, Yoda and Amy,Hello. AND HELLO,JERRY !");
	}
	
	@Test
	void helloYoda2() {
		assertEquals(Welcome.welcome("bob, YODA, amy, JERRY, YODA"),"Hello, Bob and Amy. AND ,YODA(X2) AND JERRY,HELLO !");
	}
	
	@Test
	void helloYoda3() {
		assertEquals(Welcome.welcome("bob , yoda , bob , amy, JERRY, amy , YODA, MIZ , JERRY"),"Bob(x2), Yoda and Amy(x2),Hello. AND ,JERRY(X2),YODA AND MIZ,HELLO !");
	}
	
	@Test
	void helloYoda4() {
		assertEquals(Welcome.welcome("b o b , y o d a , b o b  , aM y, J E R R Y, a m y    , YODA, MIZ , JERRY"),"Bob(x2), Yoda and Amy(x2),Hello. AND ,JERRY(X2),YODA AND MIZ,HELLO !");
	}
	
	@Test
	void helloYoda5() {
		assertEquals(Welcome.welcome("bob , yoda ,Yoda, amy , elea , elea , YODA , JERRY, bob , MAX , FABRICE , MArtin"),"Bob(x2), Yoda(x2), Amy, Elea(x2) and Martin,Hello. AND ,YODA,JERRY,MAX AND FABRICE,HELLO !");
	}
	

}
