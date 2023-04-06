package awale;

import java.util.Scanner;

/**
 * Classe principale pour la gestion de la logique de jeu de Awale. Elle
 * contient la méthode main qui permet de lancer le jeu, ainsi que les méthodes
 * FinduJeu et Victoire pour déterminer le gagnant et afficher les scores finaux
 * des joueurs.
 */
public class Jeu {

	/** Joueur 1 de la partie. */
	private static Joueur joueur1 = new Joueur();
	/** * Joueur 2 de la partie. */
	private static Joueur joueur2 = new Joueur();
	/** Plateau de jeu utilisé pour la partie */
	private static Plateau plateau = new Plateau();

	/**
	 * Méthode main qui permet de lancer le jeu. Elle utilise un plateau, deux
	 * joueurs et un Scanner pour prendre des entrées de l'utilisateur. Elle lance
	 * une boucle qui permet aux joueurs de jouer tour à tour jusqu'à ce qu'il n'y
	 * ait plus de graines sur l'un des côtés du plateau. Elle appelle ensuite les
	 * méthodes FinduJeu et Victoire pour déterminer le gagnant et afficher les
	 * scores finaux des joueurs.
	 * 
	 * @param args les arguments de la méthode main
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("****** AWALE GAME *****");
		System.out.println("Par Ousmane William KEBE et Moussa KANOUTE");
		System.out.println("Donner le nom du 1er Joueur");
		// Permet de saisir le nom du 1er joueur
		joueur1.setNom(scan.next());
		System.out.println("Donner le nom du 2nd Joueur");
		// Permet de saisir le nom du 2ème joueur
		joueur2.setNom(scan.next());

		joueur1.setCote("c1");
		joueur2.setCote("c2");

		// DEBUT DU JEU
		plateau.afficher();
		while (plateau.nbGraines("c1") > 0 && plateau.nbGraines("c2") > 0) {
			// plateau.afficher();
			// Tour du joueur 1
			System.out.println("Tour de " + joueur1.getNom() + ". Veuillez choisir une case");
			plateau.jouer("c1", scan.nextInt());
			// Miseàl à jour du grenier du joueur 2
			joueur1.setScore(plateau.greniers[0]);

			// plateau.afficher();

			// Tour du joueur 2
			System.out.println("Tour de " + joueur2.getNom() + ". Veuillez choisir une case");
			plateau.jouer("c2", scan.nextInt());
			// Mise à jour du grenier du joueur 2
			joueur2.setScore(plateau.greniers[1]);
		}

		finDuJeu();
		victoire();
	}

	/**
	 * Méthode Victoire qui détermine le gagnant de la partie en comparant les
	 * scores des deux joueurs et affiche un message de victoire pour le joueur
	 * gagnant.
	 */
	public static void finDuJeu() {
		if (plateau.nbGraines("c1") > plateau.nbGraines("c2")) {
			joueur1.setScore(joueur1.getScore() + plateau.nbGraines());
		} else if (plateau.nbGraines("c1") < plateau.nbGraines("c2")) {
			joueur2.setScore(joueur2.getScore() + plateau.nbGraines());
		}
		plateau.afficher();
	}

	/**
	 * Méthode Victoire qui est appelée à la fin du jeu. Elle détermine le gagnant
	 * en comparant les scores des joueurs et affiche le nom du gagnant. Elle
	 * affiche également les scores finaux des joueurs.
	 */
	public static void victoire() {
		// Détermine le gagnant et l'affiche
		if (joueur1.getScore() > joueur2.getScore()) {
			System.out.println(joueur1.getNom() + " a gagné !");
		} else if (joueur1.getScore() < joueur2.getScore()) {
			System.out.println(joueur2.getNom() + " a gagné !");
		} else {
			System.out.println("Match nul !");
		}

		// Affichage des scores
		System.out.println();
		System.out.println("---STATISTIQUES---");
		System.out.println("Joueur 1 : " + joueur1.getNom() + " | Score :" + joueur1.getScore());
		System.out.println("Joueur 2 : " + joueur2.getNom() + " | Score :" + joueur2.getScore());
	}

}
