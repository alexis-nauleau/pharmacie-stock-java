# Pharmacie Stock (Java)

Projet d'apprentissage Java : gestion de stock de médicaments, avec à terme plusieurs
utilisateurs et des rôles (un administrateur qui gère tout, des lecteurs en consultation seule).

> Données fictives uniquement. Ce projet n'est pas un logiciel de gestion officinale.

## État du projet

- [x] Classe `Medicament` (nom, quantité) avec règles : pas de stock négatif, sorties limitées au stock
- [ ] Liste de médicaments et menu dans le terminal
- [ ] Tests JUnit et Maven
- [ ] Sauvegarde (fichier, puis base de données)
- [ ] Utilisateurs et rôles (ADMIN / LECTEUR), mots de passe hachés
- [ ] Interface web

## Prérequis

- JDK 17 ou plus récent (développé avec JDK 25, distribution Temurin)
- Git

Vérifier l'installation :

```powershell
java -version
javac -version
```

## Installation

```powershell
git clone https://github.com/alexis-nauleau/pharmacie-stock-java.git
cd pharmacie-stock-java
```

## Lancer le programme

Depuis la racine du projet :

```powershell
javac -d out src/main/java/pharmacie/*.java
java -cp out pharmacie.Main
```

- `javac -d out ...` compile les fichiers `.java` vers le dossier `out/`
- `java -cp out pharmacie.Main` lance la classe `Main` du package `pharmacie`

Sortie attendue :

```
Doliprane 1000mg : 50 en stock
Doliprane 1000mg : 40 en stock
Refusé : Stock insuffisant : 40 disponible(s), 100 demandé(s).
```

## Structure du projet

```
pharmacie-stock-java/
├── .vscode/settings.json        configuration de VS Code (voir plus bas)
├── src/
│   ├── main/java/pharmacie/     code de l'application
│   │   ├── Main.java
│   │   └── Medicament.java
│   └── test/java/pharmacie/     tests (à venir)
├── .gitignore
└── README.md
```

La structure `src/main/java` et `src/test/java` est la convention standard de Maven :
elle sera réutilisée telle quelle quand Maven sera ajouté.

## Problème connu avec VS Code

Avec l'extension Java, VS Code peut afficher une erreur du type :

```
The declared package "pharmacie" does not match the expected package "java.pharmacie"
```

Le code est correct : sans fichier de configuration (comme un `pom.xml`), l'extension
ne sait pas que `src/main/java` est la racine des sources. Le dossier `.vscode/settings.json`
du dépôt règle le problème :

```json
{
  "java.project.sourcePaths": ["src/main/java", "src/test/java"],
  "java.project.outputPath": "out"
}
```

Si l'erreur persiste après un clonage ou une modification :

1. `Ctrl+Shift+P`
2. Lancer **Java: Clean Java Language Server Workspace**
3. Cliquer sur **Restart and delete**

Ce fichier deviendra inutile quand le projet utilisera Maven.

## Workflow Git

- `main` : version stable
- `dev` : intégration
- `feat/...` : une branche par fonctionnalité, créée depuis `dev`, fusionnée par Pull Request vers `dev`

```powershell
git switch dev
git pull
git switch -c feat/nom-de-la-fonctionnalite
```

## Conventions de code

- Classes en `PascalCase`, méthodes et variables en `camelCase`, constantes en `MAJUSCULES`
- Une classe publique par fichier, du même nom que le fichier
- Les règles métier (stock, droits) sont vérifiées dans le code qui agit, jamais seulement dans l'interface