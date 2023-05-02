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
		//JLabel lblMur = new JLabel();
		//posX = new Random().nextInt(800-35+1);
		//posY = new Random().nextInt(600-35+1);
		//lblMur.setBounds(posX, posY, COTEMUR, COTEMUR);
		//URL resource = getClass().getClassLoader().getResource(MUR);
		//lblMur.setIcon(new ImageIcon(resource));		
		
		// calcul position aléatoire du mur
		posX = (int) Math.round(Math.random() * (LARGEURARENE - LARGEURMUR)) ;
		posY = (int) Math.round(Math.random() * (HAUTEURARENE - HAUTEURMUR)) ;
		// création du jLabel pour ce mur
		jLabel = new JLabel();
		// caractéristiques du mur (position, image)
		jLabel.setBounds(posX, posY, LARGEURMUR, HAUTEURMUR);
		URL resource = getClass().getClassLoader().getResource(MUR);
		jLabel.setIcon(new ImageIcon(resource));
	}
	
}
