package HelloBob;

public class helloBob {
	
	public static Object hello(String name) {
		if(name.equals(""))
			 return "Hello, my friend";
		 if(name.equals("  "))
			 return "Hello, my friend";
		String nomMaj = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
		return "Hello, "+nomMaj;
	}

}
