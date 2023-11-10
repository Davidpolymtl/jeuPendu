import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class InterfaceDeuxJoueur {

	private JFrame frame;
	private final JSeparator separator = new JSeparator();
	private final JLabel lblJeupendu = new JLabel("Le Jeu du Pendu");
	private final JLabel lblMotsADeviner = new JLabel("Entter le mots \u00E0 deviner :");
	private final JTextField txtMotADeviner = new JTextField();
	private final JLabel lblRessultatValidation = new JLabel("R\u00E9ssultat de la Validation ...");
	private final JButton btnValidation = new JButton("Validation");
	private final JLabel lblPendu = new JLabel("");
	private final JLabel lblMot = new JLabel("");
	private final JLabel lblLettreEssayer = new JLabel("Lettre \u00E0 essayer :");
	private final JLabel lblNbEssaie = new JLabel("Vous avez droit \u00E0 un total de 8 erreurs.\r\n");
	private final JTextField txtLettreEssayer = new JTextField();
	private final JButton btnEssayerLettre = new JButton("Essayer cette lettre");
	private final JLabel lblLettreDejaEssayees = new JLabel("Lettres d\u00E9j\u00E0 essay\u00E9es :");
	private final JLabel lblLettreEssayer_1 = new JLabel("");
	private final JSeparator separator_1 = new JSeparator();
	private final JLabel lblJoueur1 = new JLabel("Joueur #1:");
	private final JLabel lblJoueur2 = new JLabel("Joueur #2:");
	private final JButton btnRejouer = new JButton("Changer de r\u00F4le");
	private final JButton btnReinitialiser = new JButton("R\u00E9initialiser");
	private final JButton btnQuitter = new JButton("Quitter");

	Icon icon = new ImageIcon("pendu0.jpg");
	JeuDuPendu monJeuDuPendu = new JeuDuPendu();


	/**
	 * Create the application.
	 */
	public InterfaceDeuxJoueur() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		txtLettreEssayer.setBounds(161, 470, 43, 20);
		txtLettreEssayer.setColumns(10);
		txtMotADeviner.setBounds(10, 80, 302, 21);
		txtMotADeviner.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 155, 450, 10);
		
		frame.getContentPane().add(separator);
		lblJeupendu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJeupendu.setBounds(148, 11, 214, 38);
		
		frame.getContentPane().add(lblJeupendu);
		lblMotsADeviner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMotsADeviner.setBounds(10, 48, 149, 21);
		
		frame.getContentPane().add(lblMotsADeviner);
		
		frame.getContentPane().add(txtMotADeviner);
		lblRessultatValidation.setBounds(10, 119, 318, 25);
		
		frame.getContentPane().add(lblRessultatValidation);
		btnValidation.addActionListener(new BtnValidationActionListener());
		btnValidation.setBounds(322, 79, 115, 23);
		
		frame.getContentPane().add(btnValidation);
		lblPendu.setBounds(107, 155, 221, 246);
		lblPendu.setIcon(icon);
		
		frame.getContentPane().add(lblPendu);
		lblMot.setHorizontalAlignment(SwingConstants.CENTER);
		lblMot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMot.setForeground(Color.BLACK);
		lblMot.setBounds(79, 401, 266, 38);
		
		frame.getContentPane().add(lblMot);
		lblLettreEssayer.setBounds(34, 470, 108, 21);
		
		frame.getContentPane().add(lblLettreEssayer);
		lblNbEssaie.setBounds(94, 434, 318, 25);
		
		frame.getContentPane().add(lblNbEssaie);
		
		frame.getContentPane().add(txtLettreEssayer);
		btnEssayerLettre.addActionListener(new BtnEssayerLettreActionListener());
		btnEssayerLettre.setEnabled(false);
		btnEssayerLettre.setBounds(249, 469, 144, 23);
		
		frame.getContentPane().add(btnEssayerLettre);
		lblLettreDejaEssayees.setBounds(34, 502, 133, 21);
		
		frame.getContentPane().add(lblLettreDejaEssayees);
		lblLettreEssayer_1.setBounds(178, 498, 234, 25);
		
		frame.getContentPane().add(lblLettreEssayer_1);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 534, 450, 10);
		
		frame.getContentPane().add(separator_1);
		lblJoueur1.setBounds(10, 555, 149, 21);
		
		frame.getContentPane().add(lblJoueur1);
		lblJoueur2.setBounds(10, 587, 172, 25);
		
		frame.getContentPane().add(lblJoueur2);
		btnRejouer.addActionListener(new BtnRejouerActionListener());
		btnRejouer.setEnabled(false);
		btnRejouer.setBounds(223, 550, 200, 23);
		
		frame.getContentPane().add(btnRejouer);
		btnReinitialiser.addActionListener(new BtnReinitialiserActionListener());
		btnReinitialiser.setBounds(223, 588, 89, 23);
		
		frame.getContentPane().add(btnReinitialiser);
		btnQuitter.addActionListener(new BtnQuitterActionListener());
		btnQuitter.setBounds(334, 588, 89, 23);
		
		frame.getContentPane().add(btnQuitter);
	}
	private class BtnValidationActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String motsDeviner = txtMotADeviner.getText();
			monJeuDuPendu.setChaineCacheeDeuxJoueur(motsDeviner);
			
			if(motsDeviner.equals("") || monJeuDuPendu.alphabet()){
				lblRessultatValidation.setText("Vous devez entrer un mots SANS caractère comme ! $ @"
															+ " et autre");
				
			}
			else if(motsDeviner.length() < 4){
				lblRessultatValidation.setText("Vous devez entrer un mots avec plus de"
						+ " quatre lettre.");
			}
			else{
				lblRessultatValidation.setText("Votre mots a bien été enregistrée.");
				lblMot.setText(monJeuDuPendu.chaineVue());
				txtMotADeviner.setText("");
				btnValidation.setEnabled(false);
				btnEssayerLettre.setEnabled(true);
				txtMotADeviner.setEnabled(false);
			}
		}
	}
	private class BtnQuitterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(monJeuDuPendu.getNbPointJoueur1() == monJeuDuPendu.getNbPointJoueur2()){
				JOptionPane.showMessageDialog(null, "Merci d'avoir joué. Personne a gagner.");
			}
			else if(monJeuDuPendu.getNbPointJoueur1() < monJeuDuPendu.getNbPointJoueur2()){
				JOptionPane.showMessageDialog(null, "Merci d'avoir joué.\n"
									+ "Bravo joueur deux pour votre victoire.");
			}
			else{
				JOptionPane.showMessageDialog(null, "Merci d'avoir joué.\n"
						+ "Bravo joueur un pour votre victoire.");
			}
			System.exit(0);
		}
	}
	private class BtnEssayerLettreActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(txtLettreEssayer.getText().length() > 1 ||txtLettreEssayer.getText().length()==0){
				JOptionPane.showMessageDialog(null, "Vous devez entrer un lettre");
				return;
			}
			else{
				monJeuDuPendu.setLettre(txtLettreEssayer.getText());
			}
			
			 if(monJeuDuPendu.dejaEssaye()){
				JOptionPane.showMessageDialog(null, "Vous avez déjà entrer cette lettre");
				return;
			}
			 else{
				lblMot.setText(monJeuDuPendu.trouve());
				lblLettreEssayer_1.setText("" + monJeuDuPendu.getLettreEssayer());
				lblNbEssaie.setText("Il vous reste " + (8-monJeuDuPendu.getNombreErreurs()) + " faute avant la fin.");
				icon = new ImageIcon("pendu" + monJeuDuPendu.getNombreErreurs()+".jpg");
				lblPendu.setIcon(icon);
				
				if(monJeuDuPendu.gagne()){
				JOptionPane.showMessageDialog(null, "Bravo! Vous avez trouver le mots.");
				btnEssayerLettre.setEnabled(false);
				btnRejouer.setEnabled(true); 
				}
			else if(monJeuDuPendu.perdu()){
				JOptionPane.showMessageDialog(null, "Désolé, tous vos essaie sont épuisés..."
						+ "\nLe mot cherché était : " + monJeuDuPendu.getChaineCachee());
				btnEssayerLettre.setEnabled(false);
				btnRejouer.setEnabled(true);
				}
				lblJoueur1.setText("Joueur #1 : " + monJeuDuPendu.getNbPointJoueur1());
				lblJoueur2.setText("Joueur #2 : " + monJeuDuPendu.getNbPointJoueur2());
			}
		
		txtLettreEssayer.setText("");	
		}
	}
	private class BtnRejouerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			monJeuDuPendu.setChaineVue("");
			lblMot.setText("");
			monJeuDuPendu.setLettreEssayer("");
			monJeuDuPendu.setNbErreur(0);
			
			lblPendu.setIcon(icon = new ImageIcon("pendu0.jpg"));
			btnValidation.setEnabled(true);
			btnRejouer.setEnabled(false);
			txtMotADeviner.setEnabled(true);
			lblRessultatValidation.setText("Réssultat de la Validation ...");
			lblLettreEssayer_1.setText("");
			lblNbEssaie.setText("Il vous reste 8 faute avant la fin.");
		}
	}
	private class BtnReinitialiserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			monJeuDuPendu.setChaineVue("");
			lblMot.setText("");
			monJeuDuPendu.setLettreEssayer("");
			monJeuDuPendu.setNbErreur(0);
			monJeuDuPendu.setNombrePartie(0);
			monJeuDuPendu.setNombreGagner(0);
			monJeuDuPendu.setNbPointJoueur1(0);
			monJeuDuPendu.setNbPointJoueur2(0);
			
			lblRessultatValidation.setText("Réssultat de la Validation ...");
			txtMotADeviner.setEnabled(true);
			lblPendu.setIcon(icon = new ImageIcon("pendu0.jpg"));
			btnValidation.setEnabled(true);
			btnEssayerLettre.setEnabled(false);
			lblLettreEssayer_1.setText("");
			lblNbEssaie.setText("Il vous reste 8 faute avant la fin.");
			lblJoueur1.setText("Joueur #1 : ");
			lblJoueur2.setText("Joueur #2 : ");
		}
	}
}
