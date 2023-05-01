package modele;

import controleur.Controle;
import outils.connexion.Connection;

import controleur.Global;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Gestion du jeu côté serveur
 *
 */
public class JeuServeur extends Jeu implements Global{

	/**
	 * Collection de murs
	 */
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>() ;
	/**
	 * Collection de joueurs
	 */
	private Hashtable<Connection, Joueur> lesJoueurs = new Hashtable<Connection, Joueur>() ;
	
	/**
	 * Constructeur
	 */
	public JeuServeur(Controle controle) {
		super.controle = controle;
	}
	
	@Override
	public void connexion(Connection connection) {
		lesJoueurs.put(connection, new Joueur());
	}

	@Override
	public void reception(Connection connection, Object info) {
		String[] chaine = info.toString().split(STRINGSEPARE);
		String ordre = chaine[0];
		switch(ordre) {
		case (PSEUDO) :
			String pseudo = chaine[1];
			int numPerso = Integer.parseInt(chaine[2]);
			this.lesJoueurs.get(connection).initPerso(pseudo, numPerso);
			break;
		}
	}
	
	
	@Override
	public void deconnexion() {
	}

	/**
	 * Envoi d'une information vers tous les clients
	 * fais appel plusieurs fois à l'envoi de la classe Jeu
	 */
	public void envoi() {
	}

	/**
	 * Génération des murs
	 */
	public void constructionMurs() {
	}
	
}
