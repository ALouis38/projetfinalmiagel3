package chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Client extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 475);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnFichier.add(mntmQuitter);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnvoyer.setBounds(469, 339, 117, 53);
		contentPane.add(btnEnvoyer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 310, 445, 107);
		contentPane.add(scrollPane);
		
		JTextArea txtrMessage = new JTextArea();
		txtrMessage.setLineWrap(true);
		scrollPane.setViewportView(txtrMessage);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 12, 574, 288);
		contentPane.add(scrollPane_1);
		
		JTextArea txtrVue = new JTextArea();
		txtrVue.setLineWrap(true);
		scrollPane_1.setViewportView(txtrVue);
	}
}
