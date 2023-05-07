package modele;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connection;
import javax.swing.JPanel;

/**
 * Gestion du jeu c�t� client
 *
 */
public class JeuClient extends Jeu implements Global{
	
	private Connection connection;
	private Boolean mursOk = false;
	
	/**
	 * Controleur
	 */
	public JeuClient(Controle controle) {
		super.controle = controle;
	}
	
	@Override
	public void connexion(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void reception(Connection connection, Object info) {
		if(info instanceof JPanel) {
			if(!this.mursOk) {
				// arriv�e du panel des murs
				this.controle.evenementJeuClient(AJOUTPANELMURS, info);
				this.mursOk = true;
			} else {
				// arriv�e du panel de jeu
				this.controle.evenementJeuClient(MODIFPANELJEU, info);
			}
		} else if(info instanceof String) {
			this.controle.evenementJeuClient(MODIFTCHAT, info);
		}
	}
	
	@Override
	public void deconnexion() {
	}

	/**
	 * Envoi d'une information vers le serveur
	 * fais appel une fois � l'envoi dans la classe Jeu
	 */
	public void envoi(String chaine) {
		super.envoi(this.connection, chaine);
	}

}
