//Ici, les méthodes (et la classe) sont abstraites car on a besoin de les utiliser dans les différentes classes.
public abstract class Piece {

	private Boolean couleur;

	public abstract Boolean validerMouvement(Piece[][] plateau, int ligne, int colonne, int nouvelleLigne, int nouvelleColonne);

	public abstract Boolean getCouleur();
	
}