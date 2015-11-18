package ie.dit.comp.c12410858.security.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.Font;

public class CryptoApplication {

	private JFrame frame;
	private JTextField txtPrimeChecker;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CryptoApplication window = new CryptoApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CryptoApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblNumberGenerators = DefaultComponentFactory.getInstance().createTitle("Number Generators & Prime Tester");
		lblNumberGenerators.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumberGenerators.setForeground(Color.DARK_GRAY);
		panel.add(lblNumberGenerators);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1);
		
		JLabel lblAlgorithmLabel = new JLabel("Mersenne Twister");
		panel_1.add(lblAlgorithmLabel);
		
		JButton btnGenerateNumber = new JButton("Generate number");
		panel_1.add(btnGenerateNumber);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_1.add(textField);
		textField.setColumns(15);
		
		JLabel lblPrime = new JLabel("Prime:");
		panel_1.add(lblPrime);
		
		txtPrimeChecker = new JTextField();
		txtPrimeChecker.setEditable(false);
		panel_1.add(txtPrimeChecker);
		txtPrimeChecker.setText("");
		txtPrimeChecker.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setHgap(10);
		panel.add(panel_2);
		
		JLabel lblBlumBlumShub = new JLabel("Blum Blum Shub");
		panel_2.add(lblBlumBlumShub);
		
		JButton button = new JButton("Generate number");
		panel_2.add(button);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(15);
		panel_2.add(textField_1);
		
		JLabel label_1 = new JLabel("Prime:");
		panel_2.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel lblLargePrimeNumber = DefaultComponentFactory.getInstance().createTitle("Large Prime Number List Generator");
		lblLargePrimeNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLargePrimeNumber.setForeground(Color.DARK_GRAY);
		panel.add(lblLargePrimeNumber);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblLargePrime = new JLabel("10 Large Prime Numbers:");
		panel_3.add(lblLargePrime);
		
		JButton btnGenerateList = new JButton("Generate list");
		panel_3.add(btnGenerateList);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(10);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNextPrimeGenerator = DefaultComponentFactory.getInstance().createTitle("Next Prime Generator");
		lblNextPrimeGenerator.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNextPrimeGenerator.setForeground(Color.DARK_GRAY);
		panel.add(lblNextPrimeGenerator);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblNextPrimeNumber = new JLabel("Next Prime Number");
		panel_4.add(lblNextPrimeNumber);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Enter a number");
		textField_3.setColumns(15);
		panel_4.add(textField_3);
		
		JButton btnGenerateNextPrime = new JButton("Generate next prime number");
		panel_4.add(btnGenerateNextPrime);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		panel_4.add(textField_4);
		textField_4.setColumns(15);
	}

}
