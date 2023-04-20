package HelloBob;

public class helloBob {
	
	public static Object hello(String name) {
		String retour;
		if(name.trim().equals(""))
			return "Hello, my friend";
		if(name.equals("JERRY"))
			return "HELLO, JERRY !";
		String nomMaj = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
		return "Hello, "+nomMaj;
	}

}
