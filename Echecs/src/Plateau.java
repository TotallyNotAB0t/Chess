public class Plateau {

	//Création d'un tableau vide de longueur 8 x largueur 8
    public Piece[][] plateau = new Piece[8][8];

    //Création du plateau
    public Plateau(){
        this.initialiser();
    }

    private void initialiser(){

        // Placement des pions blancs
        for(int x=0; x<8; x++){
            plateau[1][x] = new Pion(true);
        }

        // Placement des pions noirs
        for(int z=0; z<8; z++){
            plateau[6][z] = new Pion(false);
        }

        //Placement des Tours
        plateau[0][0] = new Tour(true);
        plateau[7][7] = new Tour(false);
        plateau[0][7] = new Tour(true);
        plateau[7][0] = new Tour(false);

        //Placement des Fous
        plateau[0][2] = new Fou(true);
        plateau[7][2] = new Fou(false);
        plateau[0][5] = new Fou(true);
        plateau[7][5] = new Fou(false);

        //Placement des Cavaliers
        plateau[0][1] = new Cavalier(true);
        plateau[7][6] = new Cavalier(false);
        plateau[0][6] = new Cavalier(true);
        plateau[7][1] = new Cavalier(false);

        //Placement des Rois
        plateau[0][4] = new Roi(true);
        plateau[7][4] = new Roi(false);

        //Placement des Dames
        plateau[0][3] = new Dame(true);
        plateau[7][3] = new Dame(false);

    }

    //Affichage du plateau et des pieces
    public String toString(){
        String string = "";
        int fileCount = 0;
        for(Piece[] pieces: plateau){
            int rankCount = 0;
            for(Piece piece: pieces){
                if(piece==null){
                	string += " . ";
                }else{
                    string += piece;
                }
                string += "  ";
                rankCount++;
            }
            fileCount++;
            string += "\n";
        }

        String ligne = "\n";

        //Séparation de chaque ligne grace à .split
        String[] separation = string.split("\n");
        for(int x = separation.length-1; x >= 0; x--){
            ligne += x + 1 + " " + separation[x] + "\n";
        }
        ligne += "   A    B    C    D    E    F    G    H \n";

        return ligne;
    }

    	//Converti notre entrée String en int. Si la lettre rentrée est en dehors de la liste prédefinie, on retourne 8 ce qui provoque une erreur.
        public static int charToInt(char ch){
        switch(ch){
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
            default: return 8;
        }
    }

    	//On découpe l'entrée de l'utilisateur et on en fait un tableau
        public static int[] creationMouvement(String mouvement){
        int[] retournerMouvement = new int[4];

        String[] split = mouvement.split(" ");
        retournerMouvement[0] = Integer.parseInt(mouvement.charAt(1) + "") - 1;
        retournerMouvement[1] = charToInt(split[0].charAt(0));
        retournerMouvement[2] = Integer.parseInt(split[1].charAt(1) + "") - 1;
        retournerMouvement[3] = charToInt(split[1].charAt(0));

        return retournerMouvement;
    }

    //Maintenant, on déplace le pion sur le plateau
    public boolean applicationMouvement(String mouvement, boolean couleur) {
    	int[] listeMouvement = creationMouvement(mouvement);

       	//Erreur si jamais le mouvement est vide
       	if(plateau[listeMouvement[0]][listeMouvement[1]] == null){
       	    System.out.println("Votre case de depart est vide.");
       	    return false;
       	}

       	//Erreur si jamais la pièce n'est pas de la même couleur que le joueur
       	if(!plateau[listeMouvement[0]][listeMouvement[1]].getCouleur() == couleur){
       	    System.out.println("La piece n'est pas la votre !");
       	    return false;
       	}

       	//Erreur si jamais la case d'arrivée est possède un pion de la même couleur que la case de départ
       	if(plateau[listeMouvement[2]][listeMouvement[3]] != null){
       	    if(plateau[listeMouvement[2]][listeMouvement[3]].getCouleur() == couleur){
       	    	System.out.println("N'attaquez pas vos propres pions !");
       	    	return false;
       	    }
       	}

       	//On valide le mouvement
       	if(plateau[listeMouvement[0]][listeMouvement[1]].validerMouvement(plateau, listeMouvement[0], listeMouvement[1], listeMouvement[2], listeMouvement[3])) {

       		plateau[listeMouvement[2]][listeMouvement[3]] = plateau[listeMouvement[0]][listeMouvement[1]];
			plateau[listeMouvement[0]][listeMouvement[1]] = null;

		} else {
			System.out.println("Mouvement non valide !");
			return false;
		}

		return true;
	}
}