package pharmacie;
public class Main {
    public static void main(String[] args) {
        Medicament doliprane = new Medicament("Doliprane 1000mg", 50);
        System.out.println(doliprane);

        doliprane.retirer(10);
        System.out.println(doliprane);   // 40 attendu

        try {
            doliprane.retirer(100);      // plus que le stock
        } catch (IllegalArgumentException e) {
            System.out.println("Refusé : " + e.getMessage());
        }
    }
}