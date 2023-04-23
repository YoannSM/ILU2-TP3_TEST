package HelloBob;

public class helloBob {
	
	public static Object hello(String name) {
		name = name.replaceAll("\\s","");
		if(name.trim().equals(""))
			return "Hello, my friend";
		if(name.toUpperCase().equals(name))
			return "HELLO, "+name+" !";
		if(name.contains(",")) {
			String retour ="Hello, ";
			String[] split = name.split(",");
			for(String word : split) {
				word = word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase();
				retour+= word+", ";
		}
		retour = retour.substring(0,retour.length()-2);
		return retour;
		}
		
		String nomMaj = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
		return "Hello, "+nomMaj;
	}

}
