import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoixUnDeuxJoueur {

	private JFrame frmChoixUnOu;
	private final JLabel lblJeuDuPendu = new JLabel("Jeu du pendu");
	private final JLabel lblUnJoueur = new JLabel("Un Joueur");
	private final JLabel lblDeuxJoueur = new JLabel("Deux joueurs");
	private final JButton btnJouer = new JButton("Jouer");
	private final JButton btnJouer1 = new JButton("Jouer");
	private final JButton btnQuitter = new JButton("Quitter");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixUnDeuxJoueur window = new ChoixUnDeuxJoueur();
					window.frmChoixUnOu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChoixUnDeuxJoueur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChoixUnOu = new JFrame();
		frmChoixUnOu.setTitle("Choix un ou deux joueur\r\n");
		frmChoixUnOu.setBounds(100, 100, 450, 300);
		frmChoixUnOu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChoixUnOu.getContentPane().setLayout(null);
		lblJeuDuPendu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJeuDuPendu.setBounds(159, 11, 122, 57);
		
		frmChoixUnOu.getContentPane().add(lblJeuDuPendu);
		lblUnJoueur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnJoueur.setBounds(36, 90, 122, 36);
		
		frmChoixUnOu.getContentPane().add(lblUnJoueur);
		lblDeuxJoueur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeuxJoueur.setBounds(268, 89, 133, 39);
		
		frmChoixUnOu.getContentPane().add(lblDeuxJoueur);
		btnJouer.addActionListener(new BtnJouerActionListener());
		btnJouer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJouer.setBounds(30, 137, 89, 23);
		
		frmChoixUnOu.getContentPane().add(btnJouer);
		btnJouer1.addActionListener(new BtnJouer1ActionListener());
		btnJouer1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJouer1.setBounds(278, 139, 89, 23);
		
		frmChoixUnOu.getContentPane().add(btnJouer1);
		btnQuitter.addActionListener(new BtnQuitterActionListener());
		btnQuitter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuitter.setBounds(137, 199, 89, 23);
		
		frmChoixUnOu.getContentPane().add(btnQuitter);
	}
	private class BtnQuitterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	private class BtnJouerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			InterfaceUnJoueur window = new InterfaceUnJoueur();
			frmChoixUnOu.setVisible(false);
		}
	}
	private class BtnJouer1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			InterfaceDeuxJoueur window = new InterfaceDeuxJoueur();
			frmChoixUnOu.setVisible(false);
		}
	}
}
