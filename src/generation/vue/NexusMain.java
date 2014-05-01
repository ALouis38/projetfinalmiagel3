package generation.vue;

import generationmodule.VuePrincipale;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import config.Configuratione;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

public class NexusMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NexusMain frame = new NexusMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NexusMain() {
		setTitle("Nexus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
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
				
				//awt desktop - ouverture d'un fichier PDF avec le lecteur de PDF par défault - Multiplateforme
				try {
					Configuratione conf = new Configuratione();
					File pdfFile = new File(conf.getHome() +"/help.pdf");
					if (pdfFile.exists()) {
			 
						if (Desktop.isDesktopSupported()) {
							Desktop.getDesktop().open(pdfFile);
						} else {
							System.out.println("Awt Desktop is not supported!");
						}
			 
					} else {
						System.out.println("File is not exists!");
					}
			 
					System.out.println("Done");
			 
				  } catch (Exception ex) {
					ex.printStackTrace();
				  }
			}
		});
		mnAide.add(mntmManuelDaide);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNouveauProjet = new JButton("Nouveau Projet");
		btnNouveauProjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nexus nx = new Nexus();
				nx.setVisible(true);
			}
		});
		btnNouveauProjet.setBounds(28, 89, 158, 75);
		contentPane.add(btnNouveauProjet);
		
		JButton btnNouveauModule = new JButton("Nouveau Module");
		btnNouveauModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VuePrincipale vp = new VuePrincipale();
				vp.getFrmProbeGnrateur().setVisible(true);
			}
		});
		btnNouveauModule.setBounds(247, 89, 167, 75);
		contentPane.add(btnNouveauModule);
	}
}
