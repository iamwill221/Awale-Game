package awale;

import java.util.Arrays;
import java.util.Scanner;

/**
 * La classe Plateau permet de créer et gérer le plateau de jeu pour le jeu
 * d'Awale. Il contient un tableau à deux dimensions représentant les trous du
 * plateau, ainsi qu'un attribut de classe constant qui contient le nombre de
 * graines qui seront mis dans les trous au début du jeu.
 * 
 * @author Ousmane William Kebe
 * @author Moussa Kanouté
 */
public class Plateau {

	/** Tableau à deux dimensions représentant les trous du plateau **/
	private int[][] cellules = new int[2][6];

	/** Nombre de graines au départ dans chaque trou **/
	public static final int nbGrainesInitial = 4;

	/** Tableau contenant le nombre de graines dans les greniers des joueurs **/
	public int greniers[] = new int[2];

	/**
	 * Constructeur par défaut qui initialise les valeurs du tableau cellules à
	 * nbGrainesInitial.
	 */
	public Plateau() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				cellules[i][j] = nbGrainesInitial;
			}
		}
	}

	/**
	 * Méthode pour modifier la valeur d'une cellule (un trou) du tableau cellules.
	 * 
	 * @param ligne   La ligne de la cellule à modifier.
	 * @param colonne La colonne de la cellule à modifier.
	 * @param value   La valeur à affecter à la cellule.
	 */
	public void setCellule(int ligne, int colonne, int value) {
		cellules[ligne][colonne] = value;
	}

	/**
	 * Méthode pour récupérer la valeur d'une cellule (un trou) du tableau cellules.
	 * 
	 * @param ligne   La ligne de la cellule à récupérer.
	 * @param colonne La colonne de la cellule à récupérer.
	 * @return La valeur de la cellule.
	 */
	public int getCellule(int ligne, int colonne) {
		return cellules[ligne][colonne];
	}

	/**
	 * Méthode pour ajouter une graine dans une cellule (un trou) du tableau
	 * cellules.
	 * 
	 * @param ligne   La ligne de la cellule où ajouter une graine.
	 * @param colonne La colonne de la cellule où ajouter une graine.
	 */
	public void ajoutGraine(int ligne, int colonne) {
		cellules[ligne][colonne]++;
	}

	/**
	 * Méthode pour calculer et retourner le nombre de graines restant dans les
	 * cellules du plateau.
	 * 
	 * @return Le nombre de graines restant dans les cellules du plateau.
	 */
	public int nbGraines() {
		int graines = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				graines += cellules[i][j];
			}
		}
		return graines;
	}

	/**
	 * Méthode pour calculer et retourner le nombre de graines restant dans les
	 * cellules (trous) d'un côté donné.
	 * 
	 * @param cote Le côté pour lequel calculer le nombre de graines.
	 * @return Le nombre de graines restant dans les cellules (trous) du côté donné.
	 */
	public int nbGraines(String cote) {
		int graines = 0;
		int nbCote = (cote == "c1" ? 0 : 1);
		for (int i = 0; i < 6; i++) {
			graines += cellules[nbCote][i];
		}
		return graines;
	}

	/**
	 * Redéfinition de la méthode toString pour afficher la configuration du
	 * plateau.
	 * 
	 * @return Une chaîne de caractères décrivant la configuration du plateau.
	 */
	@Override
	public String toString() {
		String toString = "";
		toString += "   [";
		for (int i = 5; i >= 0; i--) {
			toString += cellules[0][i] + ",";
		}
		toString += "]\n" + "{" + greniers[0] + "}" + "--------------{" + greniers[1] + "}\n   [";
		for (int j = 0; j < 6; j++) {
			toString += cellules[1][j] + ",";
		}
		toString += "]\n";
		return toString;
	}

	/**
	 * Cette méthode permet de simuler un coup de jeu d'Awale. Elle prend en
	 * paramètre le côté du joueur et la cellule (le trou) choisi par celui-ci. Elle
	 * utilise la classe Scanner pour saisir les variables et vérifie que la cellule
	 * choisie est valide. Elle gère également les cas de boucle et de capture de
	 * graines selon les règles du jeu.
	 * 
	 * @param cote    Le côté du joueur qui joue ce coup.
	 * @param cellule La cellule (trou) choisi par le joueur pour jouer ce coup.
	 */
	public void jouer(String cote, int cellule) {
		// La classe Scanner permet d'insérer les variables
		Scanner sc = new Scanner(System.in);
		// Tant que la cellule n'est pas entre 0 et 5, On redemande à l'utilisateur le
		// nombre
		while (cellule < 0 || cellule > 5) {
			System.out.println("Ce trou n'existe pas. Veuillez saisir un nombre entre 0 et 5");
			cellule = sc.nextInt();
		}

		// CoteInt permet de convertir la chaine C1 en integer grâce à un opérateur
		// ternaire
		int coteInt = (cote.equals("c1") ? 0 : 1);
		int nbGraines = cellules[coteInt][cellule];
		cellules[coteInt][cellule] = 0;

		int i = cellule;
		int coteAjout = coteInt;
		while (nbGraines > 0) {
			// vérifie si i = 5 pour changer le côté sur lequel on insère les graines
			if (i > 4) {
				i = 0;
				coteAjout = coteAjout == 1 ? 0 : 1;
			} else {
				i++;
			}

			// Si jamais il fait un tour complet il va sauter la case de départ
			if (!(coteAjout == coteInt && cellule == i)) {
				cellules[coteAjout][i]++;
				nbGraines--;
			}

		}

		// System.out.println(i);
		afficher();
		capturer(cote, (coteInt == 1 ? "c1" : "c2"), i);
	}

	/**
	 * Cette méthode permet d'afficher le plateau de jeu dans la console.
	 */
	public void afficher() {
		System.out.println(this.toString());
	}

	/**
	 * La méthode affamer permer de vérifier que le joueur ne va pas prendre toutes
	 * les graines du camp adverse;
	 * 
	 * @param ligne le côté où on doit vérifier s'il n'y a pas de coup affamant.
	 * @return true si le joueur risque de prendre toutes les graines, false sinon.
	 */
	public boolean affamer(int ligne) {
		boolean coupAffamant = false;
		for (int i = 5; i >= 0; i--) {
			if (cellules[ligne][i] == 2 || cellules[ligne][i] == 3 || cellules[ligne][i] == 0) {
				coupAffamant = true;
			}

			else {
				coupAffamant = false;
				return coupAffamant;
			}
		}
		return coupAffamant;
	}

	/**
	 * La méthode capturer permet de simuler les captures de graines selon les
	 * règles du jeu. Elle prend en paramètre le côté du joueur en cours, le côté de
	 * l’adversaire et la dernière cellule où il a déposé une graine. Elle est
	 * récursive pour prendre en compte une rafale de captures.
	 * 
	 * @param coteJoueur     le côté du joueur en cours
	 * @param coteAdversaire le côté de l'adversaire
	 * @param lastCellule    la dernière cellule où le joueur a déposé une graine
	 */
	public void capturer(String coteJoueur, String coteAdversaire, int lastCellule) {
		// cotePrendre doit être le côté inverse à celle du Joueur
		int cotePrendre = (coteJoueur == "c1" ? 1 : 0);

		// Verification si le joueur ne risque pas de prendre toutes les graines du camp
		// adverse.

		if (cellules[cotePrendre][lastCellule] == 2 || cellules[cotePrendre][lastCellule] == 3) {
			if (!affamer(cotePrendre)) {
				// Mettre les graines capturés dans le grenier approprié
				greniers[(coteJoueur == "c1" ? 0 : 1)] += cellules[cotePrendre][lastCellule];
				cellules[cotePrendre][lastCellule] = 0;

				System.out.println("--Capture--");
				afficher();

				if (lastCellule > 0) {
					capturer(coteJoueur, coteAdversaire, (lastCellule - 1));
				}
			} else {
				System.out.println("Vous ne pouvez pas jouer ce coup");
			}
		}
	}
}
