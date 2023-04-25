package HelloBob;

public class helloBob {

	public static Object hello(String name) {
		name = name.replaceAll("\\s", "");
		name = name.trim();
		if (name.equals(""))
			return "Hello, my friend";
		if (name.toUpperCase().equals(name))
			return "HELLO, " + name + " !";
		if (name.contains(",")) {
			if(!containMajName(name)) 
				return bonjourMin(name);
			if(!containMinName(name)) 
				return bonjourMaj(name);
			return bonjourMin(name)+" AND " +bonjourMaj(name);
		}
		String nomMaj = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		return "Hello, " + nomMaj;
	}


	
	private static boolean containMajName(String name) {
		if(cptTailleMaj(name)>0) {
			return true;
		}
		return false;
	}
	
	private static boolean containMinName(String name) {
		if(cptTailleMin(name)>0) {
			return true;
		}
		return false;
	}

	
	private static int cptTailleMin(String name) {
		int cpt = 0;
		String[] split = name.split(",");
		for(String word : split) 
			if (!(word.toUpperCase().equals(word)))
					cpt++;
		
		return cpt;
	}

	private static int cptTailleMaj(String name) {
		int cpt = 0;
		String[] split = name.split(",");
		for (String word : split) {
			if (word.toUpperCase().equals(word)) {
				cpt++;
			}
		}
		return cpt;
	}

	private static String bonjourMaj(String name) {
		String retour = "HELLO";
		String[] tabMaj = createMaj(name);
		int cpt = cptTailleMaj(name);
		if(tabMaj.length>1) {
			for (int i = 0; i < cpt-1; i++) {
				retour+= ","+tabMaj[i];
			}
			retour +=" AND "+tabMaj[cpt-1]+" !";
			return retour;
		}
		else
			return retour+","+tabMaj[0]+" !";
	}
		
	
	private static String[] createMaj(String name) {
		String[] split = name.split(",");
		int cptTaille = cptTailleMaj(name);
		int cpt = 0;
		String[] tabMaj = new String[cptTaille];
		for(String word : split) {
			if((word.toUpperCase().equals(word))) {
				tabMaj[cpt] = word;
				cpt ++;
			}

		}
		return tabMaj;
	}
	
	private static String[] createMin(String name) {
		String[] split = name.split(",");
		int cptTaille = cptTailleMin(name);
		int cpt = 0;
		String[] tabMin = new String[cptTaille];
		for(String word : split) {
			if(!(word.toUpperCase().equals(word))) {
				tabMin[cpt] =word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
				cpt ++;
			}

		}
		return tabMin;
		
	}
	
	
	private static String bonjourMin(String name) {
		String retour = "Hello";
		String[] tabMin = createMin(name);
		int cpt = cptTailleMin(name);
		if(tabMin.length>1) {
			for (int i = 0; i < cpt-1; i++) {
				retour+=", "+ tabMin[i];
			}
			retour +=" and "+tabMin[cpt-1]+".";
			return retour;
		}
		else
			return retour+tabMin[0]+".";
	}
	
}
