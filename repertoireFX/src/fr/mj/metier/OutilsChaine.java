package fr.mj.metier;

public class OutilsChaine {

	private OutilsChaine() {

	}

	/**
	 * 
	 * @param chaine � convertir
	 * @return Permet de retourner la premiere lettre des noms propre ou composer en majuscule
	 */
	
	public static String toNompPropre(String chaine) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(chaine.substring(0, 1).toUpperCase());
		for (int i = 1; i < chaine.length(); i++) {
			if (isIn(chaine.substring(i - 1, i), " -")) {
				stringBuilder.append(chaine.substring(i, i + 1).toUpperCase());
			} else {
				stringBuilder.append(chaine.substring(i, i + 1).toLowerCase());
			}
		}
		return stringBuilder.toString();
	}

	private static boolean isIn(String substring, String string) {

		return string.contains(substring);
	}

}
