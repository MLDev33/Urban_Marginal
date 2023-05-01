package controleur;

import vue.EntreeJeu;

import modele.Jeu;
import modele.JeuServeur;
import modele.JeuClient;

import vue.Arene;
import vue.ChoixJoueur;
import outils.connexion.AsyncResponse;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;

/**
 * Contrôleur et point d'entrée de l'applicaton
 * 
 * @author emds
 *
 */
public class Controle implements AsyncResponse {

	// propiétés
	
	/**
	 * frame EntreeJeu
	 */
	private EntreeJeu frmEntreeJeu;
	/**
	 * frame Arene
	 */
	private Arene frmArene;
	/**
	 * frame ChoixJoueur
	 */
	private ChoixJoueur frmChoixJoueur;
	
	private ServeurSocket serverSocket;
	
	private ClientSocket clientSocket;
	
	private String typeJeu;
	/**
	 * N° du port d'écoute du serveur
	 */
	private static int PORT = 6666;
	
	private Jeu leJeu;

	/**
	 * Méthode de démarrage
	 * 
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		new Controle();
	}

	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		this.frmEntreeJeu.setVisible(true);
	}
	
	/**
	 * Demande provenant de la vue EntreeJeu
	 * @param info information à traiter
	 */
	public void evenementEntreeJeu(String info) {
		if (info.equals("serveur")) {
			leJeu = new JeuServeur(this);
			this.serverSocket = new ServeurSocket(this, PORT);
			this.frmEntreeJeu.dispose();
			this.frmArene = new Arene(this);
			this.frmArene.setVisible(true);
		} else {
			leJeu = new JeuClient(this);
			this.clientSocket = new ClientSocket(this, info, PORT);
			this.frmEntreeJeu.dispose();
		}
	}

	
	/**
	 * Informations provenant de la vue ChoixJoueur
	 * @param pseudo le pseudo du joueur
	 * @param numPerso le numéro du personnage choisi par le joueur
	 */
	public void evenementChoixJoueur(String pseudo, int numPerso) {
		this.frmChoixJoueur.dispose();
		this.frmArene.setVisible(true);
		String chaine = "pseudo" + "~" + pseudo  + "~" + Integer.toString(numPerso);
		((JeuClient)leJeu).envoi(chaine);
	}
	
	
	public void envoi(Connection uneConnection, Object unObject) {
		uneConnection.envoi(unObject);
	}
	
	
	
	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch (ordre) {
		case "connexion":
			if (leJeu instanceof JeuClient) {
				this.frmEntreeJeu.dispose();
				this.frmArene = new Arene(this);
				this.frmChoixJoueur = new ChoixJoueur(this);
				this.frmChoixJoueur.setVisible(true);
				leJeu.connexion(connection);
			} else {
				leJeu.connexion(connection);
			}
			break;
		case "réception":
			leJeu.reception(connection, info);

			break;
		case "déconnexion":

			break;
		}

	}

}
