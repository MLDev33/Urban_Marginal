package modele;

import controleur.Global;
import java.util.Random;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * Gestion des murs
 *
 */
public class Mur extends Objet implements Global{
		
	/**
	 * Constructeur
	 */
	public Mur() {
		// calcul position al�atoire du mur
		posX = (int) Math.round(Math.random() * (LARGEURARENE - LARGEURMUR)) ;
		posY = (int) Math.round(Math.random() * (HAUTEURARENE - HAUTEURMUR)) ;
		// cr�ation du jLabel pour ce mur
		jLabel = new JLabel();
		// caract�ristiques du mur (position, image)
		jLabel.setBounds(posX, posY, LARGEURMUR, HAUTEURMUR);
		URL resource = getClass().getClassLoader().getResource(MUR);
		jLabel.setIcon(new ImageIcon(resource));
	}
	
}
