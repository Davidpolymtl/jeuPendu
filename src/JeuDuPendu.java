public class JeuDuPendu {
	private String lettreAlphabet[] = {"a" , "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			"m", "n", "o", "p", "q", "r", "s", "t", "u", "v","w","x", "y", "z"};
	private String listeMots[] = {"Rouge","Penser","Mots","Devoir","Interface","Joueur","Plagiat",
									"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche","Novembre",
									"Semaine","Pourquoi","Magie","Erreurs","Poste","Gagner", "Manger","Bonjour",
									"Suivant", "Bleu", "Orange", "notes", "Borner", "Liste", "Belle", "facil", "aimer"};
	private String chaineCachee = "";
	private String chaineVue = "";
	private String lettreEssayer = "";
	private int nbErreurs = 0;
	private final int MAX_ERREURS = 8;
	private int nombreGagner = 0;
	private int nombrePartie = 0;
	private double pourcentageReussie = 0.0;
	private String lettre;
	private int nbPointJoueur1 = 0;
	private int nbPointJoueur2 = 0;
	
	
	public JeuDuPendu(){
	}
	//Cette méthode reçois un lettre de l'interface //
	//et la place dans attirbut lettre de la classe//
	public void setLettre(String lettre){
		this.lettre = lettre;
	}
	//Cette méthode permet de choisir un mot, lorsque la //
	// personne joue seul, dans le tableau et le met dans chaineCachee//
	public void setChaineCachee(){
		this.chaineCachee = listeMots[(int) Math.floor(Math.random()* listeMots.length)];
	}
	//Cette méthode permet, lorsqu'on joue à deux, de mettre//
	//le mot choisie dans chaineCachee//
	public void setChaineCacheeDeuxJoueur(String chaineCachee){
		this.chaineCachee = chaineCachee;
	}
	//Cette méthode permet d'obtenir le mot dans chaineCachee//
	//pour donner la bonne réponse à l'utilisateur.//
	public String getChaineCachee(){
		return chaineCachee;
	}
	//Cette méthode permet de changer la valeur du//
	//nombre de parties gagnées lorsque le joueur veux//
	//réinitialiser ces statistique.//
	public void setNombreGagner(int nombreGagner){
		this.nombreGagner=nombreGagner;
	}
	//Cette méthode permet d'obtenir la valeur du//
	//nombre de parties gagnées.//
	public int getNombreGagner(){
		return nombreGagner;
	}
	//Cette méthode permet de changer la valeur du//
	//nombre de parties lorsque le joueur veux//
	//réinitialiser ces statistique.//
	public void setNombrePartie(int nombrePartie){
		this.nombrePartie = nombrePartie;
	}
	//Cette méthode permet d'obtenir la valeur du//
	//nombre de parties gagnées.//
	public int getNombrePartie(){
		return nombrePartie;
	}
	//Cette méthode permet de changer le//
	//nombre d'erreurs lorsque le joueur veux//
	//jouer sa prochaine partie.//
	public void setNbErreur(int nbErreurs){
		this.nbErreurs = nbErreurs;
	}
	//Cette méthode permet d'obtenir le//
	//nombre d'Erreurs effectué.//
	public int getNombreErreurs(){
		return nbErreurs;
	}
	//Cette méthode permet de mettre la chaineVue vide//
	//dans le but d'initialiser d'y mettre le prochain mot.//
	public void setChaineVue(String chaineVue){
		this.chaineVue=chaineVue;
	}
	//Cette méthode permet d'obtenir le mot dans chaineVue//
	//pour montrer la possition des lettres du mots.//
	public String getChaineVue(){
		return chaineVue;
	}
	//Cette méthode permet de mettre la String lettreEssayer//
	//vide pour la prochaine partie.//
	public void setLettreEssayer(String lettreEssayer){
		this.lettreEssayer = lettreEssayer;
	}
	//Cette méthode permet d'obtenir les lettre essayer//
	public String getLettreEssayer(){
		return lettreEssayer;
	}
	//Cette méthode permet de changer la valeur du//
	//nombre de point du joueur 1 lorsque les//
	//joueurs veulent réinitialiser ces statistique.//
	public void setNbPointJoueur1(int nbPointJoueur1){
		this.nbPointJoueur1 = nbPointJoueur1;
	}
	//Cette méthode permet d'obtenir le //
	//nombre de point su joueur 1.//
	public int getNbPointJoueur1(){
		return nbPointJoueur1;
	}
	//Cette méthode permet de changer la valeur du//
	//nombre de point du joueur 2 lorsque les//
	//joueurs veulent réinitialiser ces statistique.//
	public void setNbPointJoueur2(int nbPointJoueur2){
		this.nbPointJoueur2 = nbPointJoueur2;
	}
	//Cette méthode permet d'obtenir le//
	//nombre de Point du Joueur 2.//
	public int getNbPointJoueur2(){
		return nbPointJoueur2;
	}
	//Cette méthode permet de vérifier si//
	//le joueur a déjà essayé sa lettre.//
	public boolean dejaEssaye(){
		if(lettreEssayer.indexOf(lettre)==-1){
			return false;
		}
		else{
			return true;
		}
	}
	//Cette méthode permet de créer la chaineVue//
	//qui montre au joueur le nombre de lettres.//
	public String chaineVue(){
		for(int i=0; i<chaineCachee.length();i++){
			chaineVue+="*";
		}
		return chaineVue;
	}
	//Cette méthode permet de changer la chaineVue//
	//pour montrer au joueur ou se trouve les //
	//essayé.//
	public String trouve(){
		
		lettreEssayer += lettre;
		for (int i = 0; i < chaineCachee.length();i++ ){
			if(chaineCachee.substring(i,i+1).equalsIgnoreCase(lettre)){
				chaineVue = chaineVue.substring(0,i) + lettre + chaineVue.substring(i+1);
			}
		}
		
		if(chaineCachee.toLowerCase().indexOf(lettre.toLowerCase())==-1){
			nbErreurs++;
		}
	return chaineVue;
	}
	//Cette méthode permet de vérifier si le//
	//joueur a gagné.//
	public boolean gagne(){
		if(chaineCachee.equalsIgnoreCase(chaineVue)){
			nombreGagner++;
			nombrePartie++;
			if(nombrePartie%2 == 0){
				nbPointJoueur1++;
			}
			else{
				nbPointJoueur2++;
			}
		return true;
	}
	else{
		return false;
		
		}
	}
	//Cette méthode permet de vérifier si le//
	//joueur a perdu.//
	public boolean perdu(){
		if(nbErreurs < MAX_ERREURS){
			return false;
		}
		else{
			nombrePartie++;
			if(nombrePartie%2 == 0){
				nbPointJoueur2++;
			}
			else{
				nbPointJoueur1++;
			}
			return true;
		}
	}
	//Cette méthode permet d'obtenir le //
	//pourcentage de réussite.//
	public double Pourcentage(){
		if(nombreGagner==0){
			pourcentageReussie = 0.0;
		}
		else{
			pourcentageReussie = nombreGagner * 100 / nombrePartie;
		}
		return pourcentageReussie;
	}
	//Cette méthode permet de vérifier que les//
	//joueurs n'utilisent pas des caratères comme//
	// @, £, /, 1, 2 et autres.//Vérification mal fait modification grace à une variable boolean//
	public boolean alphabet(){
		
		boolean alphabet = false;
		
		for(int i = 0; i < chaineCachee.length()&& !alphabet; i++){
			for(int j=0; j < lettreAlphabet.length;j++){
					if(chaineCachee.substring(i,i+1).equalsIgnoreCase(lettreAlphabet[j])){
						j=27;
					}
					else if(j==25){
						alphabet = true;
					}
				}	
			}
		return alphabet;
		
	}
	
}
