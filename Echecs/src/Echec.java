import java.util.Scanner;

public class Echec {

	public static void main(String[] args) {

		Plateau plateau = new Plateau();

		//Demande et sauvegarde des noms
		System.out.println("\nJoueur blanc, veuillez entrer un nom :");
		Joueur joueurBlanc = new Joueur();
		joueurBlanc.setCouleur(true);
		joueurBlanc.setNom();

		System.out.println("\nJoueur noir, veuillez entrer un nom :");
		Joueur joueurNoir = new Joueur();
		joueurNoir.setCouleur(false);
		joueurNoir.setNom();
		boolean boucle = true;

		//Boucle principale
		while(true) {

			//Affichage du plateau
			System.out.println(plateau);

			//Début de la partie, tour du joueur blanc
			System.out.println(joueurBlanc.getNom() + ", a votre tour de jouer.\n");
			Scanner scanner = new Scanner(System.in);
			String mouvementTampon = scanner.nextLine();

			//Utilisation de .contains() car un test d'égalité == ne marche pas.
			if(mouvementTampon.contains("abandonner")) {
				System.out.println("Le joueur " + joueurBlanc.getNom() + " a abandonne la partie ! " + joueurNoir.getNom() + " gagne !");
				break;
			}

			//Tant que le coup n'a pas été validé, on recommence le tour.
			while (!plateau.applicationMouvement(mouvementTampon, joueurBlanc.getCouleur())) {
				System.out.println("Veuillez rejouer, " + joueurBlanc.getNom()+ "\n");
				if(plateau.applicationMouvement(scanner.nextLine(), joueurBlanc.getCouleur())) {
					break;
				}
			}

			System.out.println(plateau);
			System.out.println(joueurBlanc.getNom() + " a joue " + mouvementTampon +".");
			
			//Tour du joueur noir
			System.out.println(joueurNoir.getNom() + ", a votre tour de jouer.\n");
			String mouvementTampon2 = scanner.nextLine();

			if(mouvementTampon2.contains("abandonner")) {
				System.out.println("Le joueur " + joueurNoir.getNom() + " a abandonne la partie ! " + joueurBlanc.getNom() + " gagne !");
				break;
			}

			while (!plateau.applicationMouvement(mouvementTampon2, joueurNoir.getCouleur())) {
				System.out.println("Veuillez rejouer, " + joueurNoir.getNom()+ "\n");
				if(plateau.applicationMouvement(scanner.nextLine(), joueurNoir.getCouleur())) {
					break;
				}
			}

			plateau.applicationMouvement(mouvementTampon2, joueurNoir.getCouleur());

			System.out.println(plateau);
			System.out.println(joueurNoir.getNom() + " a joue " + mouvementTampon2 +".");

			//Je n'ai pas reussi à trouver comment finir la partie...
			boolean finDePartie = true;
			if(!(finDePartie)) {
				break;
			}
		}
	}
}