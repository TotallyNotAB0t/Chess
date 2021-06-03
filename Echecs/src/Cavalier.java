public class Cavalier extends Piece{

	private Boolean couleur;

	public Cavalier(Boolean uneCouleur) {
		this.couleur = uneCouleur;
	}

	public Boolean getCouleur() {
		return couleur;
	}

	public String toString(){
		return "Cav";
	}

	public Boolean validerMouvement(Piece[][] plateau, int ligne, int colonne, int nouvelleLigne, int nouvelleColonne) {
		
		if(Math.abs(nouvelleLigne - ligne) == 2 && Math.abs(nouvelleColonne - colonne) == 1){
			return true;
		}
		
		if(Math.abs(nouvelleLigne - ligne) == 1 && Math.abs(nouvelleColonne - colonne) == 2){
			return true;
		}
		
		return false;
	}

}