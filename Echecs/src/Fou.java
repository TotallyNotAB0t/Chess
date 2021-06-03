public class Fou extends Piece{

	private Boolean couleur;

	public Fou(Boolean uneCouleur) {
		this.couleur = uneCouleur;
	}

	public Boolean getCouleur() {
		return couleur;
	}

	public String toString(){
		return "Fou";
	}

	public Boolean validerMouvement(Piece[][] plateau, int ligne, int colonne, int nouvelleLigne, int nouvelleColonne) {

		if(ligne == nouvelleLigne || colonne == nouvelleColonne){
			return false;
		}
		
		if(Math.abs(nouvelleLigne - ligne) != Math.abs(nouvelleColonne - colonne)){
			return false;
		}
		
		int decalageLigne, decalageColonne;
		
		if(ligne < nouvelleLigne){
			decalageLigne = 1;
		}else{
			decalageLigne = -1;
		}
		
		if(colonne < nouvelleColonne){
			decalageColonne = 1;
		}else{
			decalageColonne = -1;
		}
		
		int y = colonne + decalageColonne;
		for(int x = ligne + decalageLigne; x != nouvelleLigne; x += decalageLigne){
			
			if(plateau[x][y] != null){
				return false;
			}
			
			y += decalageColonne;
		}
		
		return true;
		
	}
}