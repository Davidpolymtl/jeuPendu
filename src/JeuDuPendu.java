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
	//Cette m�thode re�ois un lettre de l'interface //
	//et la place dans attirbut lettre de la classe//
	public void setLettre(String lettre){
		this.lettre = lettre;
	}
	//Cette m�thode permet de choisir un mot, lorsque la //
	// personne joue seul, dans le tableau et le met dans chaineCachee//
	public void setChaineCachee(){
		this.chaineCachee = listeMots[(int) Math.floor(Math.random()* listeMots.length)];
	}
	//Cette m�thode permet, lorsqu'on joue � deux, de mettre//
	//le mot choisie dans chaineCachee//
	public void setChaineCacheeDeuxJoueur(String chaineCachee){
		this.chaineCachee = chaineCachee;
	}
	//Cette m�thode permet d'obtenir le mot dans chaineCachee//
	//pour donner la bonne r�ponse � l'utilisateur.//
	public String getChaineCachee(){
		return chaineCachee;
	}
	//Cette m�thode permet de changer la valeur du//
	//nombre de parties gagn�es lorsque le joueur veux//
	//r�initialiser ces statistique.//
	public void setNombreGagner(int nombreGagner){
		this.nombreGagner=nombreGagner;
	}
	//Cette m�thode permet d'obtenir la valeur du//
	//nombre de parties gagn�es.//
	public int getNombreGagner(){
		return nombreGagner;
	}
	//Cette m�thode permet de changer la valeur du//
	//nombre de parties lorsque le joueur veux//
	//r�initialiser ces statistique.//
	public void setNombrePartie(int nombrePartie){
		this.nombrePartie = nombrePartie;
	}
	//Cette m�thode permet d'obtenir la valeur du//
	//nombre de parties gagn�es.//
	public int getNombrePartie(){
		return nombrePartie;
	}
	//Cette m�thode permet de changer le//
	//nombre d'erreurs lorsque le joueur veux//
	//jouer sa prochaine partie.//
	public void setNbErreur(int nbErreurs){
		this.nbErreurs = nbErreurs;
	}
	//Cette m�thode permet d'obtenir le//
	//nombre d'Erreurs effectu�.//
	public int getNombreErreurs(){
		return nbErreurs;
	}
	//Cette m�thode permet de mettre la chaineVue vide//
	//dans le but d'initialiser d'y mettre le prochain mot.//
	public void setChaineVue(String chaineVue){
		this.chaineVue=chaineVue;
	}
	//Cette m�thode permet d'obtenir le mot dans chaineVue//
	//pour montrer la possition des lettres du mots.//
	public String getChaineVue(){
		return chaineVue;
	}
	//Cette m�thode permet de mettre la String lettreEssayer//
	//vide pour la prochaine partie.//
	public void setLettreEssayer(String lettreEssayer){
		this.lettreEssayer = lettreEssayer;
	}
	//Cette m�thode permet d'obtenir les lettre essayer//
	public String getLettreEssayer(){
		return lettreEssayer;
	}
	//Cette m�thode permet de changer la valeur du//
	//nombre de point du joueur 1 lorsque les//
	//joueurs veulent r�initialiser ces statistique.//
	public void setNbPointJoueur1(int nbPointJoueur1){
		this.nbPointJoueur1 = nbPointJoueur1;
	}
	//Cette m�thode permet d'obtenir le //
	//nombre de point su joueur 1.//
	public int getNbPointJoueur1(){
		return nbPointJoueur1;
	}
	//Cette m�thode permet de changer la valeur du//
	//nombre de point du joueur 2 lorsque les//
	//joueurs veulent r�initialiser ces statistique.//
	public void setNbPointJoueur2(int nbPointJoueur2){
		this.nbPointJoueur2 = nbPointJoueur2;
	}
	//Cette m�thode permet d'obtenir le//
	//nombre de Point du Joueur 2.//
	public int getNbPointJoueur2(){
		return nbPointJoueur2;
	}
	//Cette m�thode permet de v�rifier si//
	//le joueur a d�j� essay� sa lettre.//
	public boolean dejaEssaye(){
		if(lettreEssayer.indexOf(lettre)==-1){
			return false;
		}
		else{
			return true;
		}
	}
	//Cette m�thode permet de cr�er la chaineVue//
	//qui montre au joueur le nombre de lettres.//
	public String chaineVue(){
		for(int i=0; i<chaineCachee.length();i++){
			chaineVue+="*";
		}
		return chaineVue;
	}
	//Cette m�thode permet de changer la chaineVue//
	//pour montrer au joueur ou se trouve les //
	//essay�.//
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
	//Cette m�thode permet de v�rifier si le//
	//joueur a gagn�.//
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
	//Cette m�thode permet de v�rifier si le//
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
	//Cette m�thode permet d'obtenir le //
	//pourcentage de r�ussite.//
	public double Pourcentage(){
		if(nombreGagner==0){
			pourcentageReussie = 0.0;
		}
		else{
			pourcentageReussie = nombreGagner * 100 / nombrePartie;
		}
		return pourcentageReussie;
	}
	//Cette m�thode permet de v�rifier que les//
	//joueurs n'utilisent pas des carat�res comme//
	// @, �, /, 1, 2 et autres.//V�rification mal fait modification grace � une variable boolean//
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
