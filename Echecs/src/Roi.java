public class Roi extends Piece{

	private Boolean couleur;

	public Roi(Boolean uneCouleur) {
		this.couleur = uneCouleur;
	}

	public Boolean getCouleur() {
		return couleur;
	}

	public String toString(){
		return "Roi";
	}

	public Boolean validerMouvement(Piece[][] plateau, int ligne, int colonne, int nouvelleLigne, int nouvelleColonne) {
		
		if(Math.abs(nouvelleLigne - ligne) > 1 || Math.abs(nouvelleColonne - colonne) > 1){
			
			if(nouvelleColonne - colonne == 2 && ligne == nouvelleLigne){

				if(plateau[nouvelleLigne][colonne + 1] != null || plateau[nouvelleLigne][colonne + 2] != null){
					return false;
				}
				
			}else if(colonne - nouvelleColonne == 3 && ligne == nouvelleLigne){
				if(plateau[nouvelleLigne][colonne - 1] != null || plateau[nouvelleLigne][colonne - 2] != null || plateau[nouvelleLigne][colonne - 3] != null){
					return false;
				}
				
			}else{
				return false;
			}
		}
		return true;
	}
}