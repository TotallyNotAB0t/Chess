import java.util.Scanner;

public class Joueur {

	private String nomJoueur;
	private Boolean couleurJoueur;

	public Joueur() {

	}

	public void setNom() {
		Scanner scanner = new Scanner(System.in);
		this.nomJoueur = scanner.nextLine();
	}

	public void setCouleur(Boolean uneCouleur) {
		this.couleurJoueur = uneCouleur;
	}

	public String getNom() {
		return nomJoueur;
	}

	public Boolean getCouleur() {
		return couleurJoueur;
	}
}