package generationmodule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VuePrincipale {

	private JFrame frmProbeGnrateur;
	private JTextField textFieldNm;
	private JTextField textFieldChemin;
	private JTextField textFieldSignature;
	private Generateur gen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VuePrincipale window = new VuePrincipale();
					window.frmProbeGnrateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VuePrincipale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProbeGnrateur = new JFrame();
		frmProbeGnrateur.setTitle("Probe - Générateur de modules");
		frmProbeGnrateur.setBounds(100, 100, 450, 338);
		frmProbeGnrateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProbeGnrateur.getContentPane().setLayout(null);
		
		JLabel lblNomDuModule = new JLabel("Nom du module");
		lblNomDuModule.setBounds(22, 64, 109, 15);
		frmProbeGnrateur.getContentPane().add(lblNomDuModule);
		
		textFieldNm = new JTextField();
		textFieldNm.setBounds(167, 62, 114, 19);
		frmProbeGnrateur.getContentPane().add(textFieldNm);
		textFieldNm.setColumns(10);
		
		JLabel lblCheminDuProjet = new JLabel("Chemin du projet");
		lblCheminDuProjet.setBounds(22, 37, 127, 15);
		frmProbeGnrateur.getContentPane().add(lblCheminDuProjet);
		
		textFieldChemin = new JTextField();
		textFieldChemin.setBounds(167, 35, 114, 19);
		frmProbeGnrateur.getContentPane().add(textFieldChemin);
		textFieldChemin.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 138, 424, 2);
		frmProbeGnrateur.getContentPane().add(separator);
		
		JButton btnGnrer = new JButton("Générer");
		btnGnrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gen = new Generateur(textFieldNm.getText(), textFieldChemin.getText());
				textFieldChemin.setEditable(false);
				textFieldNm.setEditable(false);
				//btnGnrer.setEnabled(false);
			}
		});
		btnGnrer.setBounds(319, 101, 117, 25);
		frmProbeGnrateur.getContentPane().add(btnGnrer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProbeGnrateur.dispose();
			}
		});
		btnAnnuler.setBounds(190, 101, 117, 25);
		frmProbeGnrateur.getContentPane().add(btnAnnuler);
		
		JLabel lblAjouterDesFonctions = new JLabel("Ajouter des fonctions");
		lblAjouterDesFonctions.setBounds(22, 152, 160, 15);
		frmProbeGnrateur.getContentPane().add(lblAjouterDesFonctions);
		
		JLabel lblSignatureDeLa = new JLabel("Signature de la fonciton (ex : public void exemple(int ex) )");
		lblSignatureDeLa.setBounds(22, 179, 414, 15);
		frmProbeGnrateur.getContentPane().add(lblSignatureDeLa);
		
		textFieldSignature = new JTextField();
		textFieldSignature.setBounds(22, 206, 414, 19);
		frmProbeGnrateur.getContentPane().add(textFieldSignature);
		textFieldSignature.setColumns(10);
		
		JLabel lblTypeDeRetour = new JLabel("Type de retour");
		lblTypeDeRetour.setBounds(22, 237, 109, 15);
		frmProbeGnrateur.getContentPane().add(lblTypeDeRetour);
		
		JComboBox comboBoxRetour = new JComboBox();
		comboBoxRetour.setBounds(149, 232, 158, 24);
		frmProbeGnrateur.getContentPane().add(comboBoxRetour);
		
		JButton btnTerminer = new JButton("Terminer");
		btnTerminer.setBounds(319, 267, 117, 25);
		frmProbeGnrateur.getContentPane().add(btnTerminer);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(190, 268, 117, 25);
		frmProbeGnrateur.getContentPane().add(btnAjouter);
		
		JLabel lblCrationDuModule = new JLabel("Création du module");
		lblCrationDuModule.setBounds(22, 12, 139, 15);
		frmProbeGnrateur.getContentPane().add(lblCrationDuModule);
	}
}
