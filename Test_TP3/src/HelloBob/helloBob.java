package HelloBob;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class helloBob {

	public static Object hello(String name) {
		name = name.replaceAll("\\s", "");
		name = name.trim();
		if (name.equals(""))
			return "Hello, my friend";
		if (name.toUpperCase().equals(name))
			return "HELLO, " + name + " !";
		if(verifDoublons(name))
			return retourDistincts(name);
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
		if (!containMinName(name))
			return bonjourMaj(name);
		return bonjourMin(name) + " AND " + bonjourMaj(name);
	}

	private static boolean containMajName(String name) {
		if (cptTailleMaj(name) > 0) {
			return true;
		}
		return false;
	}

	private static boolean containMinName(String name) {
		if (cptTailleMin(name) > 0) {
			return true;
		}
		return false;
	}

	private static int cptTailleMin(String name) {
		int cpt = 0;
		String[] split = name.split(",");
		for (String word : split)
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
		if (tabMaj.length > 1) {
			for (int i = 0; i < cpt - 1; i++) {
				retour += ","+tabMaj[i];
			}
			retour += " AND " + tabMaj[cpt - 1] + " !";
			return retour;
		} 
		else
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
		for(String word : tab) {
			if(nom.equals(word))
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

		
	
	private static int nbFois(String[] name,String indiv) {//Entrée : tab avec doublons
		int cpt = 0;
		for(String word : name)
			if(word.equals(indiv))
				cpt++;
		return cpt;
	}
	
	private static String retourDistincts(String nom) {
		String retour = "";
		String[] name = concatTab(nom);
		String[] tableau = concatTab(nom);
		tableau = tabDistinct(tableau);
		for(String word : tableau) {
			if(nbFois(name,word)>1)
				retour+= ","+word+"(X"+nbFois(name,word)+")";
			else 
				retour+= ","+word;
		}
		retour = chaineRetour(retour);
		return retour;
	}
	


	public static void main(String[] args) {
		String cpt = "bob,JERRY,amy,bob,JERRY,bob";
		String[] name = concatTab(cpt);
		String[] ver = concatTab(cpt);
		ver = tabDistinct(ver);
		
		System.out.println(retourDistincts(cpt));
		
		
		

	}
}
