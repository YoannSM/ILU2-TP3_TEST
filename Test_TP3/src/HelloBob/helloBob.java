package HelloBob;

public class helloBob {
	
	public static Object hello(String name) {
		name = name.replaceAll("\\s","");
		if(name.trim().equals(""))
			return "Hello, my friend";
		if(name.toUpperCase().equals(name))
			return "HELLO, "+name+" !";
		if(name.contains(",")) {
			return verifVirg(name);
		}
		String nomMaj = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
		return "Hello, "+nomMaj;
	}
	
	
	private static String verifVirg(String name) {
		String maj = ". AND HELLO,";
		String retour ="Hello, ";
		String[] split = name.split(",");
		for(String word : split) {
			if(word.toUpperCase().equals(word)) {
				maj+=word;
			}
			else {
			word = word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase();
			retour+= word+", ";
			}
	}
	retour = retour.substring(0,retour.length()-2);
		if(maj.equals(". AND HELLO,")) 
	return retour;
		else
			maj+= " !";
			retour+= maj;
		return retour;
	}
	
	public static Object helloAnd(String name) {
		name = name.replaceAll("\\s","");
		if(name.trim().equals(""))
			return "Hello, my friend";
		if(name.toUpperCase().equals(name))
			return "HELLO, "+name+" !";
		if(name.contains(",")) {
			return verifVirgAnd(name);
		}
		String nomMaj = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
		return "Hello, "+nomMaj;
	}
	
	

	private static String verifVirgAnd(String name) {
		String maj = ". AND HELLO,";
		String retour ="Hello, ";
		String[] split = name.split(",");
		for(String word : split) {
			if(word.toUpperCase().equals(word))
				maj+=word + " AND ";
			else {	
			word = word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase();
			retour+= word+" and ";
			}
	}
	retour = retour.substring(0,retour.length()-5);
		if(maj.equals(". AND HELLO,")) 
	return retour;
			maj = maj.substring(0,maj.length()-4);
			maj+= "!";
			retour+= maj;
		return retour;
}
}
