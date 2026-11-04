package pharmacie;
public class Medicament {


    private final String nom;
    private int quantite;

    // Constructeur : appelé par "new Medicament(...)". Il refuse les données invalides.
    public Medicament(String nom, int quantite) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire.");
        }
        if (quantite < 0) {
            throw new IllegalArgumentException("La quantité ne peut pas être négative.");
        }
        this.nom = nom.trim();      
        this.quantite = quantite;
    }

    // Getters : on peut lire, pas modifier directement
    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

  
    public void ajouter(int n) {
         if (n <= 0) {
            throw new IllegalArgumentException("La quantité à ajouter doit être positive.");
        }
        quantite += n;              
        
    }

 
    public void retirer(int n) {
         if (n <= 0) {
            throw new IllegalArgumentException("La quantité à retirer doit être positive.");
        }
        if (n > quantite) {
            throw new IllegalArgumentException("Stock insuffisant : " + quantite + " disponible(s), " + n + " demandé(s).");
        }
        quantite -= n;              
        
    }

    @Override
    public String toString() {
        return nom + " : " + quantite + " en stock";
    }
}