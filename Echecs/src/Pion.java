public class Pion extends Piece{

	private Boolean couleur;

	public Pion(Boolean uneCouleur) {
		this.couleur = uneCouleur;
	}

	public Boolean getCouleur() {
		return couleur;
	}

	public String toString(){
		return "Pio";
	}

	public Boolean validerMouvement(Piece[][] plateau, int ligne, int colonne, int nouvelleLigne, int nouvelleColonne) {

        if(couleur){
            if(ligne > nouvelleLigne){
                return false;
            }
        }else{
            if(nouvelleLigne > ligne){
                return false;
            }
        }

        if(colonne == nouvelleColonne){

            if(couleur){
                if(plateau[ligne + 1][colonne] != null){
                    return false;
                }
            }else{
                if(plateau[ligne - 1][colonne] != null){
                    return false;
                }
            }

            if(Math.abs(nouvelleLigne - ligne) > 2){
                return false;
            }else if(Math.abs(nouvelleLigne - ligne) == 2){

                if(couleur){
                    if(plateau[ligne + 2][colonne] != null){
                        return false;
                    }
                }else{
                    if(plateau[ligne - 2][colonne] != null){
                        return false;
                    }
                }
            }
        }else{

            if(Math.abs(nouvelleColonne - colonne) != 1 || Math.abs(nouvelleLigne - ligne) != 1){
                return false;
            }

            if(plateau[nouvelleLigne][nouvelleColonne] == null){
                return false;
            }
        }

        return true;
    }
}