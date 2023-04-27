package HelloBob;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class helloBob {

	public static Object hello(String name) {
		name = name.replaceAll("\\s", "");
		name = name.trim();
		if (name.equals(""))
			return "Hello, my friend";
		if(!containMinName(name))
			return bonjourMaj(name);
		if (name.toUpperCase().equals(name))
			return "HELLO, " + name + " !";
		if(hasYoda(name))
			return (HelloYoda(name));
		if (verifDoublons(name))
			return chaineRetour(retourDistincts(name));
		if (name.contains(",")) {
			return chaineRetour(name);
		}
		String nomMaj = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		return "Hello, " + nomMaj;
	}

	private static String chaineRetour(String name) {
		name = name.replaceAll("\\s", "");
		name = name.trim();
		assertTrue(name.contains(","));
		if (!containMajName(name))
			return bonjourMin(name);
		if (containMinName(name)==false)
			return bonjourMaj(name);
		return bonjourMin(name) + " AND " + bonjourMaj(name);
	}

	private static boolean containMajName(String name) {
		if(cptTailleMaj(name) == 0) {
			return false;
		}
		return true;
	}

	private static boolean containMinName(String name) {
		if (cptTailleMin(name) == 0) {
			return false;
		}
		return true;
	}

	private static int cptTailleMin(String name) {
		int cpt = 0;
		String[] split = name.split(",");
		for (String word : split) {
			System.out.println(word);
			if (!(word.toUpperCase().equals(word))) {
				System.out.println(word+"....");
				cpt++;
		}
		}

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
		if (tabMaj.length > 1) {
			for (int i = 0; i < cpt - 1; i++) {
				retour += "," + tabMaj[i];
			}
			retour += " AND " + tabMaj[cpt - 1] + " !";
			return retour;
		} else
			return retour + "," + tabMaj[0] + " !";
	}

	private static String[] createMaj(String name) {
		name = name.trim();
		name = name.replaceAll("\\s", "");
		String[] split = name.split(",");
		int cptTaille = cptTailleMaj(name);
		int cpt = 0;
		String[] tabMaj = new String[cptTaille];
		for (String word : split) {
			if ((word.toUpperCase().equals(word))) {
				tabMaj[cpt] = word;
				cpt++;
			}

		}
		return tabMaj;
	}

	private static String[] createMin(String name) {
		name = name.trim();
		name = name.replaceAll("\\s", "");
		String[] split = name.split(",");
		int cptTaille = cptTailleMin(name);
		int cpt = 0;
		String[] tabMin = new String[cptTaille];
		for (String word : split) {
			if (!(word.toUpperCase().equals(word))) {
				tabMin[cpt] = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
				cpt++;
			}
		}
		return tabMin;

	}

	private static String[] concatTab(String name) {
		String[] Maj = createMaj(name);
		String[] Min = createMin(name);
		int lenMaj = Maj.length;
		int lenMin = Min.length;

		String[] retour = new String[lenMaj + lenMin];

		int cpt = 0;

		for (int i = 0; i < lenMin; i++) {
			retour[cpt] = Min[i];
			cpt++;
		}

		for (int i = 0; i < lenMaj; i++) {
			retour[cpt] = Maj[i];
			cpt++;
		}

		return retour;
	}

	private static String bonjourMin(String name) {
		String retour = "Hello";
		String[] tabMin = createMin(name);
		int cpt = cptTailleMin(name);
		if (tabMin.length > 1) {
			for (int i = 0; i < cpt - 1; i++) {
				retour += ", " + tabMin[i];
			}
			retour += " and " + tabMin[cpt - 1] + ".";
			return retour;
		} else
			return retour + tabMin[0] + ".";
	}

	private static int cptNom(String[] tab, String nom) {
		int cpt = -1;
		for (String word : tab) {
			if (nom.equals(word))
				cpt++;
		}
		return cpt;
	}

	private static boolean verifDoublons(String name) {
		String[] split = concatTab(name); // Passage du string en tableau
		String[] second = split;
		int cpt = 0;
		for (String word : split)
			for (String secWord : second)
				if (secWord.equals(word))
					cpt++;
		if (cpt > split.length)// Verif que chaque nom est présent qu'une fois
			return true;
		return false;
	}

	private static String[] tabDistinct(String[] tableau) {
		for (int i = 0; i < tableau.length; i++)
			for (int j = i + 1; j < tableau.length; j++)
				if (tableau[i] != null && tableau[j] != null && tableau[i].equals(tableau[j]))
					tableau[j] = null;
		int taille = 0;
		for (int i = 0; i < tableau.length; i++)
			if (tableau[i] != null)
				taille++;
		String[] tableauSansDoublons = new String[taille];
		int index = 0;
		for (int i = 0; i < tableau.length; i++)
			if (tableau[i] != null) {
				tableauSansDoublons[index] = tableau[i];
				index++;
			}
		return tableauSansDoublons;
	}

	private static int nbFois(String[] name, String indiv) {// Entrée : tab avec doublons
		int cpt = 0;
		for (String word : name)
			if (word.equals(indiv))
				cpt++;
		return cpt;
	}

	private static String retourDistincts(String nom) {
		String retour = "";
		String[] name = concatTab(nom);
		String[] tableau = concatTab(nom);
		tableau = tabDistinct(tableau);
		for (String blaz : tableau) {
			if (nbFois(name, blaz) > 1)
				retour += ","+blaz+ "(X" + nbFois(name, blaz) + ")";
			else
				retour += "," + blaz;
		}
		return retour;
	}

	private static String reverseMin(String nom) {
		String[] min = createMin(nom);
		int j = min.length - 1;
		String temp;
		String minStr = "";
		for (String word : min)
			minStr += word + ",";
		minStr = bonjourMin(minStr);
		minStr = minStr.substring(7);
		minStr = minStr.substring(0, minStr.length() - 1);
		minStr += ",Hello.";
		return minStr;
	}

	private static String reverseMaj(String nom) {
		String[] maj = createMaj(nom);
		int j = maj.length - 1;
		String majStr = "";
		for (String word : maj) {
			majStr += word + ",";
		}
		majStr = bonjourMaj(majStr);
		majStr = majStr.substring(6);
		majStr = majStr.substring(0,majStr.length()-1);
		majStr+= ",HELLO.";
		return majStr;

	}
	
	
	private static boolean hasYoda(String nom) {
		nom = nom.trim();
		nom = nom.replaceAll("\\s","");
		String[] split = nom.split(",");
		String retour = "";
		for(String word : split) {
			word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
			if(word.equals("Yoda"))
				return true;
		}
			
		return false;

	}

	private static String HelloYoda(String nom) {
		String strMin = prepYodaMin(nom);
		String strMaj = prepYodaMaj(nom);
		String[] verifMin = strMin.split(",");
		String[] verifMaj = strMaj.split(",");
		
		if(nom.contains("yoda")|| !(nom.contains("YODA")) && (verifMin.length==1 || verifMaj.length==1)) {
			if (verifMin.length<2)
				return bonjourMin(nom)+" AND "+strMaj+",HELLO !";
			if(verifMaj.length<2)
				return strMin+",Hello. AND "+bonjourMaj((nom));
		}
		if(nom.contains("YODA")&&nom.contains("yoda")) {
			return strMin+",Hello. AND " +strMaj+",HELLO !";
		}
		if(nom.contains("YODA")&& !(nom.contains("yoda")))
			return bonjourMin(retourDistincts(nom))+" AND "+strMaj+",HELLO !";
		if(nom.contains("yoda")&& !(nom.contains("YODA")))
			return strMin+",Hello. AND "+bonjourMaj(retourDistincts(nom));
		return "";
		}	
		
	
	
	public static String prepYodaMaj(String nom) {
		String[] tabMaj = createMaj(nom);
		String strMaj ="";
		for(String word : tabMaj)
			strMaj += ","+word;
		strMaj = miseEnFormeYoda(strMaj, 6);
		strMaj = strMaj.substring(0, strMaj.length()-2);
		return strMaj;
		
	}
	
	public static String prepYodaMin(String nom) {
		String[] split = nom.split(",");
		String[] tabMin = createMin(nom);
		String strMin = "";
		// Compter nb presence chaque nom , mettre en forme , retirer le hello du début et le mettre à la fin
		// idem pour Maj , concaténer les deux suivant le cas : "Yoda" = slmt min , "YODA" = slmt maj , "Yoda,YODA" les deux
		for(String word : tabMin)
			strMin +=","+word;
		String strMaj ="";
		strMin = miseEnFormeYoda(strMin, 7);
		strMin = strMin.substring(0, strMin.length()-1);
		return strMin;
		
	}
	
	public static String miseEnFormeYoda(String str,int ind) {
		str = retourDistincts(str);
		str = str.substring(1);
		str = chaineRetour(str);
		str = str.substring(ind);
		return str;
		
	}

	public static void main(String[] args) {
		String cpt = "MAX,JERRY";
		System.out.println(hello(cpt));
	}
}
