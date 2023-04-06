package awale;

/**
 * Classe Joueur qui contient les informations d'un joueur
 */
public class Joueur {
	/** Nom du joueur **/
	private String nom;
	/** Score du joueur **/
	private int score;
	/** Côté du joueur (c1 ou c2) **/
	private String cote;

	/**
	 * Constructeur sans paramètres qui initialise le nom et le coté avec la valeur
	 * ("NR") signifiant « Non Renseigné » et le score à zéro.
	 */
	public Joueur() {
		this.nom = "NR";
		this.cote = "NR";
		this.score = 0;
	}

	/**
	 * Constructeur qui prend en paramètre un nom et un côté et qui initialise les
	 * attributs nom et cote.
	 * 
	 * @param nom  le nom du joueur
	 * @param cote le côté du joueur (c1 ou c2)
	 */
	public Joueur(String nom, String cote) {
		this.nom = nom;
		if (cote == "c1" || cote == "c2") {
			this.cote = cote;
		}
	}

	/**
	 * Getter pour l'attribut nom
	 * 
	 * @return Nom du joueur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour l'attribut nom
	 * 
	 * @param nom Nouveau nom du joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour l'attribut score
	 * 
	 * @return Score du joueur
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Setter pour l'attribut score
	 * 
	 * @param score Nouveau score du joueur
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Getter pour l'attribut cote
	 * 
	 * @return Côté du joueur (c1 ou c2)
	 */
	public String getCote() {
		return cote;
	}

	/**
	 * Setter pour l'attribut cote
	 * 
	 * @param cote du Joueur
	 */
	public void setCote(String cote) {
		this.cote = cote;
	}

	/**
	 * Redéfinition de la méthode toString pour la classe Joueur.
	 * 
	 * @return Retourne une chaine de caractères décrivant l'objet Joueur.
	 */
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", score=" + score + ", cote=" + cote + "]";
	}

}
