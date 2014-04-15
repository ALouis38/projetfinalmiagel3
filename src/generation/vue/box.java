package generation.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

public class box extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					box frame = new box();
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
	public box() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNexusX = new JLabel("NEXUS X");
		lblNexusX.setBounds(182, 0, 70, 15);
		getContentPane().add(lblNexusX);
		
		JLabel lblNomDuProjet = new JLabel("Nom du projet:");
		lblNomDuProjet.setBounds(12, 71, 105, 15);
		getContentPane().add(lblNomDuProjet);
		
		textField = new JTextField();
		textField.setBounds(120, 67, 160, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPathSave = new JLabel("Path Save:");
		lblPathSave.setBounds(12, 97, 105, 15);
		getContentPane().add(lblPathSave);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 95, 160, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		Component glue = Box.createGlue();
		glue.setBounds(201, 42, 1, 1);
		getContentPane().add(glue);
		
		Component glue_1 = Box.createGlue();
		glue_1.setBounds(201, 71, 1, 1);
		getContentPane().add(glue_1);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(293, 97, 117, 15);
		getContentPane().add(btnBrowse);
	}
}
