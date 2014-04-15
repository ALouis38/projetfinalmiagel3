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
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class box extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		lblNomDuProjet.setForeground(Color.GRAY);
		lblNomDuProjet.setBounds(12, 71, 105, 15);
		getContentPane().add(lblNomDuProjet);
		
		textField = new JTextField();
		textField.setBounds(120, 67, 160, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPathSave = new JLabel("Path Save:");
		lblPathSave.setForeground(Color.GRAY);
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
		
		JLabel lblNombreDeClient = new JLabel("Nombre de client:");
		lblNombreDeClient.setForeground(Color.GRAY);
		lblNombreDeClient.setBounds(12, 128, 125, 15);
		getContentPane().add(lblNombreDeClient);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 126, 142, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 164, 3, 3);
		getContentPane().add(scrollPane);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(328, 164, 84, 15);
		getContentPane().add(btnValider);
		
		JLabel lblKernel = new JLabel("Kernel");
		lblKernel.setBounds(12, 44, 51, 15);
		getContentPane().add(lblKernel);
		
		JLabel lblModules = new JLabel("Modules");
		lblModules.setBounds(12, 179, 70, 15);
		getContentPane().add(lblModules);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(292, 97, 19, 15);
		getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(8, 204, 129, 21);
		getContentPane().add(menuBar);
		
		JList list = new JList();
		list.setBounds(79, 213, 1, 1);
		getContentPane().add(list);
	}
}
