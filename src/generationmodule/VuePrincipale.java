package generationmodule;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import config.Configuratione;

public class VuePrincipale {

	private JFrame frmProbeGnrateur;
	private JTextField textFieldNm;
	private JTextField textFieldChemin;
	private JTextField textFieldSignature;
	private Generateur gen;

	public static void main(String[] args) {
		VuePrincipale v = new VuePrincipale();
	}

	public JFrame getFrmProbeGnrateur() {
		return frmProbeGnrateur;
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
		frmProbeGnrateur.setBounds(100, 100, 450, 369);
		frmProbeGnrateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProbeGnrateur.getContentPane().setLayout(null);
		
		JLabel lblNomDuModule = new JLabel("Nom du module");
		lblNomDuModule.setBounds(22, 78, 109, 15);
		frmProbeGnrateur.getContentPane().add(lblNomDuModule);
		
		textFieldNm = new JTextField();
		textFieldNm.setBounds(167, 76, 114, 19);
		frmProbeGnrateur.getContentPane().add(textFieldNm);
		textFieldNm.setColumns(10);
		
		JLabel lblCheminDuProjet = new JLabel("Chemin du projet");
		lblCheminDuProjet.setBounds(22, 51, 127, 15);
		frmProbeGnrateur.getContentPane().add(lblCheminDuProjet);
		
		textFieldChemin = new JTextField();
		textFieldChemin.setBounds(167, 49, 114, 19);
		frmProbeGnrateur.getContentPane().add(textFieldChemin);
		textFieldChemin.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 168, 424, 2);
		frmProbeGnrateur.getContentPane().add(separator);
		
		final JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProbeGnrateur.dispose();
			}
		});	
		
		final JButton btnTerminer = new JButton("Terminer");
		btnTerminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gen.fermerLesFichiers();
				frmProbeGnrateur.dispose();
			}
		});
		btnTerminer.setEnabled(false);
		btnTerminer.setBounds(319, 281, 117, 25);
		frmProbeGnrateur.getContentPane().add(btnTerminer);
		
		final JButton btnParcourir = new JButton("...");
		btnParcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destin;
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = chooser.showOpenDialog(frmProbeGnrateur);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	destin = chooser.getSelectedFile().getAbsoluteFile().toString();
			    	textFieldChemin.setText(destin);
			}
		}});
		btnParcourir.setBounds(293, 46, 28, 25);
		frmProbeGnrateur.getContentPane().add(btnParcourir);
		
		final JComboBox comboBoxRetour = new JComboBox();
		comboBoxRetour.setEditable(true);
		comboBoxRetour.setEnabled(false);
		comboBoxRetour.setBounds(22, 248, 158, 24);
		comboBoxRetour.addItem("int");
		comboBoxRetour.addItem("float");
		comboBoxRetour.addItem("double");
		comboBoxRetour.addItem("char");
		comboBoxRetour.addItem("byte");
		comboBoxRetour.addItem("short");
		comboBoxRetour.addItem("long");
		comboBoxRetour.addItem("boolean");
		comboBoxRetour.addItem("void");
		frmProbeGnrateur.getContentPane().add(comboBoxRetour);
		
		final JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setEnabled(false);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gen.ajouterFonction(textFieldSignature.getText(), (String) comboBoxRetour.getSelectedItem());
				textFieldSignature.setText("");
				comboBoxRetour.setSelectedIndex(0);
			}
		});
		btnAjouter.setBounds(190, 282, 117, 25);
		frmProbeGnrateur.getContentPane().add(btnAjouter);
		
		textFieldSignature = new JTextField();
		textFieldSignature.setEditable(false);
		textFieldSignature.setBounds(190, 250, 246, 19);
		frmProbeGnrateur.getContentPane().add(textFieldSignature);
		textFieldSignature.setColumns(10);
		
		final JButton btnGnrer = new JButton("Générer");
		btnGnrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gen = new Generateur(textFieldNm.getText(), textFieldChemin.getText());
				textFieldChemin.setEditable(false);
				textFieldNm.setEditable(false);
				btnGnrer.setEnabled(false);
				btnAnnuler.setEnabled(false);
				btnTerminer.setEnabled(true);
				btnParcourir.setEnabled(false);
				btnAjouter.setEnabled(true);
				textFieldSignature.setEditable(true);
				textFieldNm.setEditable(false);
				textFieldChemin.setEditable(false);
				comboBoxRetour.setEnabled(true);
			}
		});
		btnGnrer.setBounds(319, 115, 117, 25);
		frmProbeGnrateur.getContentPane().add(btnGnrer);
		
		btnAnnuler.setBounds(190, 115, 117, 25);
		frmProbeGnrateur.getContentPane().add(btnAnnuler);
		
		JLabel lblAjouterDesFonctions = new JLabel("Ajouter des fonctions");
		lblAjouterDesFonctions.setBounds(20, 194, 160, 15);
		frmProbeGnrateur.getContentPane().add(lblAjouterDesFonctions);
		
		JLabel lblSignatureDeLa = new JLabel("Signature de la fonction");
		lblSignatureDeLa.setBounds(192, 223, 186, 15);
		frmProbeGnrateur.getContentPane().add(lblSignatureDeLa);
		
		JLabel lblTypeDeRetour = new JLabel("Type de retour");
		lblTypeDeRetour.setBounds(22, 221, 109, 15);
		frmProbeGnrateur.getContentPane().add(lblTypeDeRetour);
		
		JLabel lblCrationDuModule = new JLabel("Création du module");
		lblCrationDuModule.setBounds(22, 26, 139, 15);
		frmProbeGnrateur.getContentPane().add(lblCrationDuModule);

		JMenuBar menuBar = new JMenuBar();
		frmProbeGnrateur.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProbeGnrateur.dispose();
			}
		});
		mnFichier.add(mntmQuitter);
		
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		
		JMenuItem mntmManuelDaide = new JMenuItem("Manuel d'aide");
		mntmManuelDaide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuratione conf = new Configuratione();
				String cmd = "okular "+ conf.getHome() +"/help.pdf";
				Runtime runtime = Runtime.getRuntime();
	            Process process = null;
	            try {
					process = runtime.exec(cmd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnAide.add(mntmManuelDaide);
		
		frmProbeGnrateur.setVisible(true);
	}
}
