package controleur;

public interface Global {
	
	/**
	 * N� du port d'�coute du serveur
	 */
	int PORT = 6666;
	
	/**
	 * Numbre maximum de personnages
	 */
	int MAXPERSO = 3;
	/**
	 * Nombre minimum de personnges	
	 */
	int MINPERSO = 1;
	
	/**
	 * vie de d�part pour tous les joueurs
	 */
	int MAXVIE = 10 ;
	/**
	 * gain de points de vie lors d'une attaque
	 */
	int GAIN = 1 ; 
	/**
	 * perte de points de vie lors d'une attaque
	 */
	int PERTE = 2 ; 
	/**
	 * Caract�re de s�paration dans les chaines transf�r�es
	 */
	String STRINGSEPARE = "~";
	/**
	 * Message "connexion" envoy� par la classe Connection
	 */
	String CONNEXION = "connexion";
	/**
	 * Message "r�ception" envoy� par la classe Connection
	 */
	String RECEPTION = "r�ception";
	/**
	 * Message "d�connexion" envoy� par la classe Connection
	 */
	String DECONNEXION = "d�connexion";
	/**
	 * Message "pseudo" envoy� pour la cr�ation d'un joueur
	 */
	String PSEUDO = "pseudo";
	/**
	 * Caract�re de s�paration dans un chemin de fichiers
	 */
	String CHEMINSEPARATOR = "/";
	/**
	 * Chemin du dossier des images de fonds
	 */
	String CHEMINFONDS = "fonds"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier de l'image de la boule
	 */
	String CHEMINBOULES = "boules"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier de l'image du mur
	 */
	String CHEMINMURS = "murs"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier des images des personnages
	 */
	String CHEMINPERSONNAGES = "personnages"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier des sons
	 */
	String CHEMINSONS = "sons"+CHEMINSEPARATOR;
	/**
	 * Chemin de l'image de fond de la vue ChoixJoueur
	 */
	String FONDCHOIX = CHEMINFONDS+"fondchoix.jpg";
	/**
	 * Chemin de l'image de fond de la vue Arene
	 */
	String FONDARENE = CHEMINFONDS+"fondarene.jpg";
	/**
	 * Extension des fichiers des images des personnages
	 */
	String EXTFICHIERPERSO = ".gif";
	/**
	 * D�but du nom des images des personnages
	 */
	String PERSO = "perso";
	/**
	 * Chemin de l'image de la boule
	 */
	String BOULE = CHEMINBOULES+"boule.gif";
	/**
	 * Chemin de l'image du mur
	 */
	String MUR = CHEMINMURS+"mur.gif";
	/**
	 * �tat marche du personnage
	 */
	String MARCHE = "marche";
	/**
	 * �tat touch� du personnage
	 */
	String TOUCHE = "touche";
	/**
	 * �tat mort du personnage
	 */
	String MORT = "mort";
	/**
	 * Lageur de l'arene
	 */
	int LARGEURARENE = 800;	
	/**
	 * Hauteur de l'arene
	 */
	int HAUTEURARENE = 600;
	/**
	 * hauteur d'un mur
	 */
	int HAUTEURMUR = 35;
	/**
	 * largeur d'un mur
	 */
	int LARGEURMUR = 34;
	/**
	 * nombre de murs dans l'ar�ne
	 */
	int NBMURS = 20;
	/**
	 * hauteur du personnage
	 */
	int HAUTEURPERSO = 44;
	/**
	 * largeur du personnage
	 */
	int LARGEURPERSO = 39;
	/**
	 * hauteur du message
	 */
	int HAUTEURMESSAGE = 8;
	/**
	 * orientation du personnage vers la gauche
	 */
	int GAUCHE = 0;
	/**
	 * orientation du personnage vers la droite
	 */
	int DROITE = 1;
	/**
	 * Message "serveur" pour la cr�ation d'un serveur
	 */
	String SERVEUR = "serveur";
	/**
	 * ordre pour ajouter un mur dans l'ar�ne du serveur
	 */
	String AJOUTMUR = "ajout mur";
	/**
	 * ordre pour ajouter le panel des murs dans l'ar�ne du client
	 */
	String AJOUTPANELMURS = "ajout panel murs";
	/**
	 * ordre pour ajouter un jLabel dans l'ar�ne du serveur (joueur, message, boule)
	 */
	String AJOUTJLABELJEU = "ajout jLabel jeu";
	/**
	 * ordre pour modifier le panel du jeu dans l'ae�ne du client
	 */
	String MODIFPANELJEU = "modif panel jeu";
	/**
	 * ordre pour demander d'ajouter une phrase au tchat
	 */
	String TCHAT = "tchat";
	/**
	 * ordre pour ajouter une phrase dans l'ar�ne du serveur
	 */
	String AJOUTPHRASE = "ajout phrase";
	/**
	 * ordre pour modifier le contenu du tchat dans l'ar�ne du client
	 */
	String MODIFTCHAT = "modif tchat";


}
