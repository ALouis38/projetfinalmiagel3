package generation.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.security.auth.login.Configuration;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JList;

import config.Configuratione;
import generation.controleur.Generateur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Nexus extends JFrame {
	private JTextField textFieldNomProjet;
	private JTextField textFieldDestination;
	
	private Generateur g = new Generateur();
	private String destination;


	/**
	 * Create the frame.
	 */
	public Nexus() {
		setTitle("Nexus - Generation de projet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 521);
		getContentPane().setLayout(null);
		
		JLabel lblNomDuProjet = new JLabel("Nom du projet:");
		lblNomDuProjet.setForeground(Color.GRAY);
		lblNomDuProjet.setBounds(12, 42, 105, 15);
		getContentPane().add(lblNomDuProjet);
		
		textFieldNomProjet = new JTextField();
		textFieldNomProjet.setBounds(135, 40, 160, 19);
		getContentPane().add(textFieldNomProjet);
		textFieldNomProjet.setColumns(10);
		
		JLabel lblPathSave = new JLabel("Destination : ");
		lblPathSave.setForeground(Color.GRAY);
		lblPathSave.setBounds(12, 69, 105, 15);
		getContentPane().add(lblPathSave);
		
		textFieldDestination = new JTextField();
		textFieldDestination.setBounds(135, 67, 160, 19);
		getContentPane().add(textFieldDestination);
		textFieldDestination.setColumns(10);
		
		Component glue = Box.createGlue();
		glue.setBounds(201, 42, 1, 1);
		getContentPane().add(glue);
		
		Component glue_1 = Box.createGlue();
		glue_1.setBounds(201, 71, 1, 1);
		getContentPane().add(glue_1);
		
		
		
		JLabel lblKernel = new JLabel("Core");
		lblKernel.setBounds(12, 12, 51, 15);
		getContentPane().add(lblKernel);
		
		JLabel lblModules = new JLabel("Modules");
		lblModules.setBounds(12, 98, 70, 15);
		getContentPane().add(lblModules);
		
		JButton btnParcourir = new JButton("New button");
		btnParcourir.addActionListener(new ActionListener() {
			/**
			 * choix du dossier destination dans l'arborescence du système
			 */
			public void actionPerformed(ActionEvent e) {
				String destin;
				
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = chooser.showOpenDialog(getParent());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	destin = chooser.getSelectedFile().getAbsoluteFile().toString();
			    	textFieldDestination.setText(destin);
			    }
			}
		});
		btnParcourir.setBounds(305, 69, 19, 15);
		getContentPane().add(btnParcourir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 125, 378, 291);
		getContentPane().add(scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		final JList listModule = new JList();
		scrollPane.setViewportView(listModule);
		listModule.setModel(listModel);
		
		ArrayList<String> liste;
		liste = g.listeModule();
		
		for(int prostagma = 0; prostagma<g.listeModule().size(); prostagma++){
			listModel.addElement(g.listeModule().get(prostagma));
		}
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			/**
			 * sur click du bouton valider
			 */
			public void actionPerformed(ActionEvent e) {
				//recuperer la liste des modules
				Object[] moduleSelect = listModule.getSelectedValues();
				ArrayList<String> moduleSelect2 = new ArrayList<String>();
				for(int i = 0; i<moduleSelect.length; i++){
					moduleSelect2.add(moduleSelect[i].toString());
				}
				
				//recuperer la destination
				destination = textFieldDestination.getText();
				
				//recuperer les attributs String ou int
				String nomProjet = textFieldNomProjet.getText();
				
				//appel de la méthode du controleur
				g.genererServeur(moduleSelect2, nomProjet, destination);
				g.genererClients(moduleSelect2, nomProjet, destination);
				
				//pop up de confirmation
				JOptionPane d = new JOptionPane();
				Component laFrame = null;
				int messageType = 0;
				int optionType = 0;
				d.showMessageDialog(laFrame, "Le projet a bien été généré !", "Confirmation", messageType);
				dispose();
			}
		});
		btnValider.setBounds(409, 434, 84, 29);
		getContentPane().add(btnValider);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
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
	}
}
