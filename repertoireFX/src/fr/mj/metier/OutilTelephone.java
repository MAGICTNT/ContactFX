package fr.mj.metier;
import java.util.regex.Pattern;

public class OutilTelephone {
    private OutilTelephone(){}

    public static String miseEnFormeTelephone(String numero) {
        StringBuilder stringBuilder = new StringBuilder();
        String numeroMiseEnForme = "";
        if(numero.length() == 10){
            int taille = numero.length();
            stringBuilder.append(numero.substring(0, 2));
            stringBuilder.append(" ");
            stringBuilder.append(numero.substring(2, 4));
            stringBuilder.append(" ");
            stringBuilder.append(numero.substring(4, 6));
            stringBuilder.append(" ");
            stringBuilder.append(numero.substring(6, 8));
            stringBuilder.append(" ");
            stringBuilder.append(numero.substring(8, taille));
        }else {
            int taille = numero.length();
            stringBuilder.append(numero.substring(0, 3));
            stringBuilder.append(" ");
            stringBuilder.append(numero.charAt(3));
            stringBuilder.append(" ");
            stringBuilder.append(numero.substring(4, 6));
            stringBuilder.append(" ");
            stringBuilder.append(numero.substring(6, 8));
            stringBuilder.append(" ");
            stringBuilder.append(numero.substring(8, 10));
            stringBuilder.append(" ");
            stringBuilder.append(numero.substring(10, taille));
        }
        numeroMiseEnForme += stringBuilder;
        return numeroMiseEnForme;

    }

    public static boolean isTelephone(String telephone) {
        return (Pattern.matches("0[3|6|7][0-9]+", telephone) && telephone.length() == 10 || Pattern.matches("[+][3][3][3|6|7][0-9]+", telephone) && telephone.length() == 12);

    }

}
