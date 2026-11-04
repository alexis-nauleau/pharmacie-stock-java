package pharmacie;

import java.util.ArrayList;
import java.util.List;

public class Stock {


    private final List<Medicament> medicaments = new ArrayList<>();


    public void ajouterMedicament(Medicament nouveau) {
        if (nouveau == null) {
            throw new IllegalArgumentException("Le médicament est obligatoire.");
        }
        if (trouver(nouveau.getNom()) != null) {
            throw new IllegalArgumentException("Ce médicament existe déjà : " + nouveau.getNom());
        }
        medicaments.add(nouveau);
    }

    
    public Medicament trouver(String nom) {
        for (Medicament m : medicaments) {
            if (m.getNom().equalsIgnoreCase(nom.trim())) {
                return m;
            }
        }
        return null;
    }

    public List<Medicament> lister() {
        return List.copyOf(medicaments);
    }
}