package Java_Mini_Projects;

import java.util.*;

public class CompteVoyelles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez un mot : ");
        String mot = sc.nextLine().toLowerCase();

        int countA = 0;
        int countE = 0;
        int countI = 0;
        int countO = 0;
        int countU = 0;
        int countY = 0;

        for (int i = 0; i < mot.length(); i++) {
            char lettre = mot.charAt(i);
            switch (lettre) {
                case 'a':
                    countA++;
                    break;
                case 'e':
                    countE++;
                    break;
                case 'i':
                    countI++;
                    break;
                case 'o':
                    countO++;
                    break;
                case 'u':
                    countU++;
                    break;
                case 'y':
                    countY++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Le mot comporte :");
        System.out.println(countA + " fois la lettre a");
        System.out.println(countE + " fois la lettre e");
        System.out.println(countI + " fois la lettre i");
        System.out.println(countO + " fois la lettre o");
        System.out.println(countU + " fois la lettre u");
        System.out.println(countY + " fois la lettre y");

        sc.close();
    }
}