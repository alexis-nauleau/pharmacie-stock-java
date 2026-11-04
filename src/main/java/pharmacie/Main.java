package pharmacie;

import java.util.List;
import java.util.Scanner;

public class Main {

    static int lireEntier(Scanner clavier, String question) {
        while (true) {
            System.out.print(question);
            try {
                return Integer.parseInt(clavier.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ce n'est pas un nombre entier, recommence.");
            }
        }
    }

    static void afficherMenu() {
        System.out.println();
        System.out.println("=== PHARMACIE : STOCK ===");
        System.out.println("1. Lister les médicaments");
        System.out.println("2. Ajouter un médicament");
        System.out.println("3. Entrée de stock");
        System.out.println("4. Sortie de stock");
        System.out.println("0. Quitter");
    }

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        Stock stock = new Stock();

        // Données fictives de départ
        stock.ajouterMedicament(new Medicament("Doliprane 1000mg", 50));
        stock.ajouterMedicament(new Medicament("Spasfon", 20));

        while (true) {
            afficherMenu();
            int choix = lireEntier(clavier, "Ton choix : ");

            // Un seul try/catch pour tous les refus venant de Medicament et Stock
            try {
                switch (choix) {
                    case 1 -> {
                        List<Medicament> liste = stock.lister();
                        if (liste.isEmpty()) {
                            System.out.println("Le stock est vide.");
                        } else {
                            for (Medicament m : liste) {
                                System.out.println("- " + m);
                            }
                        }
                    }
                    case 2 -> {
                        System.out.print("Nom du médicament : ");
                        String nom = clavier.nextLine();
                        int quantite = lireEntier(clavier, "Quantité initiale : ");
                        stock.ajouterMedicament(new Medicament(nom, quantite));
                        System.out.println("Ajouté : " + nom.trim());
                    }
                    case 3 -> {
                        System.out.print("Nom du médicament : ");
                        Medicament m = stock.trouver(clavier.nextLine());
                        if (m == null) {
                            System.out.println("Médicament introuvable.");
                        } else {
                            int quantite = lireEntier(clavier, "Quantité à ajouter : ");
                            m.ajouter(quantite);
                            System.out.println(m);
                        }
                    }
                    case 4 -> {
                        System.out.print("Nom du médicament : ");
                        Medicament m = stock.trouver(clavier.nextLine());
                        if (m == null) {
                            System.out.println("Médicament introuvable.");
                        } else {
                            int quantite = lireEntier(clavier, "Quantité à retirer : ");
                            m.retirer(quantite);
                            System.out.println(m);
                        }
                    }
                    case 0 -> {
                        System.out.println("Au revoir !");
                        return;
                    }
                    default -> System.out.println("Choix inconnu.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Refusé : " + e.getMessage());
            }
        }
    }
}