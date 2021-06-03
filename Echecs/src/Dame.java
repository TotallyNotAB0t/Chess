public class Dame extends Piece{

	private Boolean couleur;

	public Dame(Boolean uneCouleur) {
		this.couleur = uneCouleur;
	}

	public Boolean getCouleur() {
		return couleur;
	}

	public String toString(){
		return "Dam";
	}

	public Boolean validerMouvement(Piece[][] plateau, int ligne, int colonne, int nouvelleLigne, int nouvelleColonne) {

		return new Tour(couleur).validerMouvement(plateau, ligne, colonne, nouvelleLigne, nouvelleColonne) || new Fou(couleur).validerMouvement(plateau, ligne, colonne, nouvelleLigne, nouvelleColonne);
	}
}