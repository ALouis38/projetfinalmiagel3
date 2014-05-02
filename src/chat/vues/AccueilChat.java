package chat.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccueilChat extends JFrame {

	private JPanel contentPane;
	private final JLabel lblPseudo = new JLabel("Pseudo");
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public AccueilChat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblPseudo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPseudo.setBounds(10, 11, 70, 31);
		contentPane.add(lblPseudo);
		
		textField = new JTextField();
		textField.setBounds(90, 16, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPortClient = new JLabel("Port Client");
		lblPortClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPortClient.setBounds(10, 53, 70, 31);
		contentPane.add(lblPortClient);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 58, 156, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNConnection = new JButton("Connection");
		btnNConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNConnection.setBounds(157, 89, 89, 23);
		contentPane.add(btnNConnection);
	}
}
