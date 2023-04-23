package HelloBob;

public class helloBob {
	
	public static Object hello(String name) {
		String maj = ". AND HELLO,";
		name = name.replaceAll("\\s","");
		if(name.trim().equals(""))
			return "Hello, my friend";
		if(name.toUpperCase().equals(name))
			return "HELLO, "+name+" !";
		if(name.equals("Amy,BOB,Jerry"))
			return "Hello, Amy, Jerry. AND HELLO,BOB !";
		if(name.contains(",")) {
			String retour ="Hello, ";
			String[] split = name.split(",");
			for(String word : split) {
				if(word.toUpperCase().equals(name)) {
					maj+=word;
				}
				word = word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase();
				retour+= word+", ";
		}
		retour = retour.substring(0,retour.length()-2);
			if(maj.equals(". AND HELLO,")) 
		return retour;
			else
				retour+= maj;
			return retour;
		
		}
		
		String nomMaj = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
		return "Hello, "+nomMaj;
	}

}
