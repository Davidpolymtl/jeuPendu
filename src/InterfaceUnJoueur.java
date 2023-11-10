import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceUnJoueur {

	private JFrame frame;
	private final JLabel lblJeuPendu = new JLabel("Le Jeu du pendu");
	private final JLabel lblImagePendu = new JLabel("");
	private final JLabel lblLeMots = new JLabel("");
	private final JLabel lblLettreEssayer = new JLabel("Lettre \u00E0 essayer :");
	private final JTextField txtLettreEssayer = new JTextField();
	private final JButton btnEssayerlettre = new JButton("Essayer cette lettre");
	private final JLabel lblLettreDejaEssayees = new JLabel("Lettres d\u00E9j\u00E0 essay\u00E9es :\r\n");
	private final JLabel lblLettreDejaEssayees1 = new JLabel("");
	private final JLabel lblStatistique = new JLabel("Statistique :");
	private final JLabel lblNbPartie = new JLabel("Nombre de parties jou\u00E9es :");
	private final JLabel lblNbGagner = new JLabel("Nombre de parties gagn\u00E9es :");
	private final JButton btnQuitter = new JButton("Quitter");
	private final JButton btnProchainePartie = new JButton("Prochaine partie");
	private final JButton btnReinitialiser = new JButton("R\u00E9initialiser");
	private final JLabel lblPourcentageReussite = new JLabel("Pourcentage de r\u00E9ussite :");
	
	Icon icon = new ImageIcon("pendu0.jpg");
	JeuDuPendu monJeuDuPendu = new JeuDuPendu();

	private final JLabel lblNbErreur = new JLabel("Vous avez droit \u00E0 un total de 8 erreurs.");


	/**
	 * Create the application.
	 */
	public InterfaceUnJoueur() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		monJeuDuPendu.setChaineCachee();
		monJeuDuPendu.chaineVue();

		txtLettreEssayer.setBounds(190, 390, 48, 33);
		txtLettreEssayer.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblJeuPendu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJeuPendu.setBounds(197, 11, 147, 59);
		
		frame.getContentPane().add(lblJeuPendu);
		lblImagePendu.setBounds(107, 82, 320, 227);
		lblImagePendu.setIcon(icon);
		
		frame.getContentPane().add(lblImagePendu);
		lblLeMots.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeMots.setBounds(202, 320, 199, 28);
		lblLeMots.setText(monJeuDuPendu.getChaineVue());
		
		frame.getContentPane().add(lblLeMots);
		lblLettreEssayer.setBounds(53, 390, 127, 33);
		
		frame.getContentPane().add(lblLettreEssayer);
		
		frame.getContentPane().add(txtLettreEssayer);
		btnEssayerlettre.addActionListener(new BtnEssayerlettreActionListener());
		btnEssayerlettre.setBounds(248, 390, 153, 33);
		
		frame.getContentPane().add(btnEssayerlettre);
		lblLettreDejaEssayees.setBounds(23, 424, 147, 28);
		
		frame.getContentPane().add(lblLettreDejaEssayees);
		lblLettreDejaEssayees1.setBounds(160, 424, 326, 28);
		
		frame.getContentPane().add(lblLettreDejaEssayees1);
		lblStatistique.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatistique.setBounds(10, 463, 104, 28);
		
		frame.getContentPane().add(lblStatistique);
		lblNbPartie.setBounds(10, 545, 182, 28);
		
		frame.getContentPane().add(lblNbPartie);
		lblNbGagner.setBounds(10, 502, 182, 32);
		
		frame.getContentPane().add(lblNbGagner);
		btnQuitter.addActionListener(new BtnQuitterActionListener());
		btnQuitter.setBounds(438, 548, 111, 23);
		
		frame.getContentPane().add(btnQuitter);
		btnProchainePartie.addActionListener(new BtnProchainePartieActionListener());
		btnProchainePartie.setEnabled(false);
		btnProchainePartie.setBounds(438, 475, 111, 23);
		
		frame.getContentPane().add(btnProchainePartie);
		btnReinitialiser.addActionListener(new BtnReinitialiserActionListener());
		btnReinitialiser.setBounds(438, 514, 111, 27);
		
		frame.getContentPane().add(btnReinitialiser);
		lblPourcentageReussite.setBounds(203, 545, 208, 28);
		
		frame.getContentPane().add(lblPourcentageReussite);
		lblNbErreur.setBounds(149, 359, 223, 28);
		
		frame.getContentPane().add(lblNbErreur);
	}
	private class BtnQuitterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "Merci d'avoir joué. Votre pourcentage est "+
												String.format("%3.2f",monJeuDuPendu.Pourcentage())+"%");
			System.exit(0);
		}
	}
	private class BtnEssayerlettreActionListener implements ActionListener {
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
				lblLeMots.setText(monJeuDuPendu.trouve());
				lblLettreDejaEssayees1.setText(monJeuDuPendu.getLettreEssayer());
				lblNbErreur.setText("Il vous reste " + (8-monJeuDuPendu.getNombreErreurs()) + " faute avant la fin.");
				icon = new ImageIcon("pendu" + monJeuDuPendu.getNombreErreurs()+".jpg");
				lblImagePendu.setIcon(icon);
				
				if(monJeuDuPendu.gagne()){
				JOptionPane.showMessageDialog(null, "Bravo! Vous avez trouver le mots.");
				btnEssayerlettre.setEnabled(false);
				btnProchainePartie.setEnabled(true); 
			lblNbGagner.setText("Nombre de partie gagner : " + monJeuDuPendu.getNombreGagner());
			 lblNbPartie.setText("Nombre de partie jouer : " + monJeuDuPendu.getNombrePartie());
			 lblPourcentageReussite.setText("Pourcentage de reussite : " + String.format("%3.2f",monJeuDuPendu.Pourcentage())+"%");
			}
			else if(monJeuDuPendu.perdu()){
				JOptionPane.showMessageDialog(null, "Désolé, tous vos essaie sont épuisés..."
						+ "\nLe mot cherché était : " + monJeuDuPendu.getChaineCachee());
				btnEssayerlettre.setEnabled(false);
				btnProchainePartie.setEnabled(true);
				lblNbGagner.setText("Nombre de partie gagner : " + monJeuDuPendu.getNombreGagner());
				 lblNbPartie.setText("Nombre de partie jouer : " + monJeuDuPendu.getNombrePartie());
				 lblPourcentageReussite.setText("Pourcentage de réussite : " + String.format("%5.2f%%", monJeuDuPendu.Pourcentage()));
			}
			
		}
		txtLettreEssayer.setText("");	
	}
}
	private class BtnProchainePartieActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			monJeuDuPendu.setChaineCachee();
			monJeuDuPendu.setChaineVue("");
			monJeuDuPendu.chaineVue();
			lblLeMots.setText(monJeuDuPendu.getChaineVue());
			monJeuDuPendu.setLettreEssayer("");
			monJeuDuPendu.setNbErreur(0);
			
			lblImagePendu.setIcon(icon = new ImageIcon("pendu0.jpg"));
			btnEssayerlettre.setEnabled(true);
			btnProchainePartie.setEnabled(false);
			lblLettreDejaEssayees1.setText("");
			lblNbErreur.setText("Il vous reste 8 faute avant la fin.");
		}
	}
	private class BtnReinitialiserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			monJeuDuPendu.setChaineCachee();
			monJeuDuPendu.setChaineVue("");
			monJeuDuPendu.chaineVue();
			lblLeMots.setText(monJeuDuPendu.getChaineVue());
			monJeuDuPendu.setLettreEssayer("");
			monJeuDuPendu.setNbErreur(0);
			monJeuDuPendu.setNombrePartie(0);
			monJeuDuPendu.setNombreGagner(0);
			
			lblImagePendu.setIcon(icon = new ImageIcon("pendu0.jpg"));
			btnEssayerlettre.setEnabled(true);
			btnProchainePartie.setEnabled(false);
			lblLettreDejaEssayees1.setText("");
			lblNbErreur.setText("Il vous reste 8 faute avant la fin.");
			lblNbGagner.setText("Nombre de partie gagner : ");
			lblNbPartie.setText("Nombre de partie jouer : ");
			lblPourcentageReussite.setText("Pourcentage de Réussite : ");
		}
	}
	}

