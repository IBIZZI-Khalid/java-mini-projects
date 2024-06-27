package Java_Mini_Projects;
import java.util.Scanner;

public class chainescaracteres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères : ");
        String chaine = sc.nextLine();

        // Affichage d'un caractère sur deux
        System.out.print("Caractère sur deux : ");
        for (int i = 0; i < chaine.length(); i += 2) {
            System.out.print(chaine.charAt(i));
        }
        System.out.println();

        // Affichage du premier et du dernier caractère
        if (chaine.length() > 0) {
            char premierCaractere = chaine.charAt(0);
            char dernierCaractere = chaine.charAt(chaine.length() - 1);
            System.out.println("Premier caractère : " + premierCaractere);
            System.out.println("Dernier caractère : " + dernierCaractere);
        }

        sc.close();
    }
}