package vue;

import java.awt.event.MouseAdapter;

import controleur.Controle;
import java.awt.event.MouseEvent;
import java.net.URL;

import controleur.Global;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.SwingConstants;

/**
 * Frame du choix du joueur
 * @author emds
 *
 */
public class ChoixJoueur extends JFrame implements Global{

	/**
	 * Panel général
	 */
	private JPanel contentPane;
	/**
	 * Zone de saisie du pseudo
	 */
	private JLabel lblPersonnage;
	
	private JTextField txtPseudo;
	
	private Controle controle;
	
	private int numPerso;
	


	/**
	 * Clic sur la flèche "précédent" pour afficher le personnage précédent
	 */
	private void lblPrecedent_clic() {
		System.out.println("Clic sur precedent");
		numPerso--;		
		if(numPerso < MINPERSO) {
			numPerso = 3;
		}
		affichePerso();
	}
	
	/**
	 * Clic sur la flèche "suivant" pour afficher le personnage suivant
	 */
	private void lblSuivant_clic() {
		System.out.println("Clic sur suivant");
		numPerso++;		
		if(numPerso > MAXPERSO) {
			numPerso = 1;
		}
		affichePerso();
	}
	
	/**
	 * Clic sur GO pour envoyer les informations
	 */
	private void lblGo_clic() {
		if(this.txtPseudo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "La saisie du pseudo est obligatoire");
			txtPseudo.requestFocus();
		}
		else {
			controle.evenementChoixJoueur(this.txtPseudo.getText(), numPerso);
		}
		
	}
	
	
	/**
	 * Affiche les personnage selon leur numéro
	 */
	public void affichePerso() {
		String cheminPerso = CHEMINPERSONNAGES+PERSO+this.numPerso+MARCHE+1+"d"+1+EXTFICHIERPERSO;
		URL resourcePerso = getClass().getClassLoader().getResource(cheminPerso);
		lblPersonnage.setIcon(new ImageIcon(resourcePerso));
	}
	
	/**
	 * Change l'apparence du curseur en "apparence par défault"
	 */
	public void sourisNormale() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	/**
	 * Change l'apparence du curseur en "doigt qui pointe"
	 */
	public void sourisDoigt() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * Create the frame.
	 */
	public ChoixJoueur(Controle controle) {
		
		this.controle = controle;
		
		// Dimension de la frame en fonction de son contenu
		this.getContentPane().setPreferredSize(new Dimension(400, 275));
	    this.pack();
	    // interdiction de changer la taille
		this.setResizable(false);
		 
		setTitle("Choice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(142, 113, 120, 121);
		contentPane.add(lblPersonnage);
		
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblPrecedent_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(142, 245, 120, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		lblGo.setBounds(311, 202, 65, 61);
		contentPane.add(lblGo);
		lblSuivant.setBounds(301, 145, 25, 46);
		contentPane.add(lblSuivant);
		lblPrecedent.setBounds(65, 146, 31, 45);
		contentPane.add(lblPrecedent);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		URL resource = getClass().getClassLoader().getResource(FONDCHOIX);
		lblFond.setIcon(new ImageIcon(resource));		
		contentPane.add(lblFond);
		
		
		
		// initialisation du numéro de personnage
		numPerso = 1;
		affichePerso();
		
		// positionnement sur la zone de saisie
		txtPseudo.requestFocus();
		
	}
}
