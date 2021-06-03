public class Tour extends Piece{

	private Boolean couleur;

	public Tour(Boolean uneCouleur) {
		this.couleur = uneCouleur;
	}

	public Boolean getCouleur() {
		return couleur;
	}

	public String toString(){
		return "Tou";
	}

	public Boolean validerMouvement(Piece[][] plateau, int ligne, int colonne, int nouvelleLigne, int nouvelleColonne) {

		if(ligne != nouvelleLigne && colonne != nouvelleColonne){

			return false;
		}
		
		int decalage;
		
		if(ligne != nouvelleLigne){
			if(ligne < nouvelleLigne){
				decalage = 1;
			}else{
				decalage = -1;
			}
			
			for(int x = ligne + decalage; x != nouvelleLigne; x += decalage){

				if(plateau[x][colonne] != null){

					return false;
				}
			}
		}
	
		if(colonne != nouvelleColonne){
			if(colonne < nouvelleColonne){
				decalage = 1;
			}else{
				decalage = -1;
			}
			
			for(int x = colonne + decalage; x != nouvelleColonne; x += decalage){

				if(plateau[ligne][x] != null){

					return false;
				}
			}
		}
		
		return true;
	}

}