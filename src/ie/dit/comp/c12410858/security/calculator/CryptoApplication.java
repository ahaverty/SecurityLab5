package ie.dit.comp.c12410858.security.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CryptoApplication {

	private static String appTitle = "Lab 5 Number Generator";

	private JFrame frame;
	private JTextField numberOutput1;
	private JTextField numberOutput2;
	private JTextField textPrime1;
	private JTextField textPrime2;
	private JTextField textFieldNextPrimeInput;
	private JTextField textFieldNextPrimeOutput;
	private JButton btnGenerateNumber1;
	private JButton btnGenerateNumber2;
	private JLabel lblPrimeError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Set the Look and Feel to that of system
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (Exception ignore) {
					}
					CryptoApplication window = new CryptoApplication();
					window.frame.setVisible(true);
					window.frame.setTitle(appTitle);
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
		frame.setBounds(100, 100, 582, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT);
		panel.setLayout(fl_panel);

		JLabel lblHeader1 = DefaultComponentFactory.getInstance().createTitle("Number Generators & Prime Tester");
		lblHeader1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeader1.setForeground(Color.DARK_GRAY);
		panel.add(lblHeader1);

		JPanel panelGenerate1 = new JPanel();
		panel.add(panelGenerate1);

		JLabel algorithmLabel1 = new JLabel("Mersenne Twister");

		btnGenerateNumber1 = new JButton("Generate number");
		btnGenerateNumber1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setGeneratedNumberAndPrime(e);
			}
		});

		numberOutput1 = new JTextField();
		numberOutput1.setEditable(false);
		numberOutput1.setColumns(15);

		JLabel lblPrime = new JLabel("Prime:");

		textPrime1 = new JTextField();
		textPrime1.setEditable(false);
		textPrime1.setText("");
		textPrime1.setColumns(10);
		panelGenerate1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelGenerate1.add(algorithmLabel1);
		panelGenerate1.add(btnGenerateNumber1);
		panelGenerate1.add(numberOutput1);
		panelGenerate1.add(lblPrime);
		panelGenerate1.add(textPrime1);

		JPanel panelGenerate2 = new JPanel();
		panel.add(panelGenerate2);
		panelGenerate2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel algorithmLabel2 = new JLabel("Blum Blum Shub");
		panelGenerate2.add(algorithmLabel2);

		btnGenerateNumber2 = new JButton("Generate number");
		btnGenerateNumber2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setGeneratedNumberAndPrime(e);
			}
		});
		panelGenerate2.add(btnGenerateNumber2);

		numberOutput2 = new JTextField();
		numberOutput2.setEditable(false);
		numberOutput2.setColumns(15);
		panelGenerate2.add(numberOutput2);

		JLabel label_1 = new JLabel("Prime:");
		panelGenerate2.add(label_1);

		textPrime2 = new JTextField();
		textPrime2.setText("");
		textPrime2.setEditable(false);
		textPrime2.setColumns(10);
		panelGenerate2.add(textPrime2);

		JLabel lblHeader2 = DefaultComponentFactory.getInstance().createTitle("Large Prime Number List Generator");
		lblHeader2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeader2.setForeground(Color.DARK_GRAY);
		panel.add(lblHeader2);

		JPanel panelList = new JPanel();
		panel.add(panelList);

		JScrollPane scrollPane = new JScrollPane();
		panelList.add(scrollPane);

		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(10);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JButton btnGenerateList = new JButton("Generate list");
		panelList.add(btnGenerateList);

		JLabel lblUsing = new JLabel(" using ");
		panelList.add(lblUsing);

		JComboBox comboListAlgorithm = new JComboBox();
		comboListAlgorithm.setToolTipText("Select the algorithm to use when generating the list.");
		panelList.add(comboListAlgorithm);

		JLabel lblHeader3 = DefaultComponentFactory.getInstance().createTitle("Next Prime Generator");
		lblHeader3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeader3.setForeground(Color.DARK_GRAY);
		panel.add(lblHeader3);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);

		JLabel lblNextPrimeNumber = new JLabel("Next Prime Number");
		panel_4.add(lblNextPrimeNumber);

		textFieldNextPrimeInput = new JTextField();
		textFieldNextPrimeInput.setToolTipText("Enter a number between 1 - 2147483647");
		textFieldNextPrimeInput.setColumns(15);
		panel_4.add(textFieldNextPrimeInput);

		JButton btnGenerateNextPrime = new JButton("Generate next prime number");
		btnGenerateNextPrime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean invalidInput = false;
				long inputLong = 0;
				String inputNextPrimeText = textFieldNextPrimeInput.getText();

				try {
					inputLong = Long.parseLong(inputNextPrimeText);
					System.out.println("Parsed as " + inputLong);
				} catch (Exception ne) {
					invalidInput = true;
					System.out.println("Invalid input detected for:" + inputNextPrimeText);
				}

				if (invalidInput == false) {
					lblPrimeError.setVisible(false);
					long nextPrime = PsuedoRandomUtility.generateNextPrimeNumber(inputLong);
					textFieldNextPrimeOutput.setText(Long.toString(nextPrime));
				} else {
					lblPrimeError.setVisible(true);
				}

			}
		});
		panel_4.add(btnGenerateNextPrime);

		textFieldNextPrimeOutput = new JTextField();
		textFieldNextPrimeOutput.setEditable(false);
		panel_4.add(textFieldNextPrimeOutput);
		textFieldNextPrimeOutput.setColumns(15);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.RED);
		panel.add(panel_1);
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.CENTER, 120, 5);
		panel_1.setLayout(fl_panel_1);

		lblPrimeError = new JLabel("Error! must be a number in the range 0 - 2147483647");
		lblPrimeError.setForeground(Color.RED);
		panel_1.add(lblPrimeError);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Assignment Details  ");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewJgoodiesTitle.setForeground(Color.DARK_GRAY);
		panel.add(lblNewJgoodiesTitle);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JTextPane textPane = new JTextPane();
		panel_2.add(textPane);
		textPane.setText("Advanced Security Lab 5\r\n18/11/2015\r\n\r\nAlan Haverty\r\nC12410858\r\nDT211C4");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
	}

	public void setGeneratedNumberAndPrime(ActionEvent e) {
		if (e.getSource() == btnGenerateNumber1) {
			long generatedLong = PsuedoRandomUtility.generateNumberUsingMersenneTwister();
			numberOutput1.setText(Long.toString(generatedLong));
			textPrime1.setText(Boolean.toString(PsuedoRandomUtility.isPrime(generatedLong)));
		}
		if (e.getSource() == btnGenerateNumber2) {
			long generatedLong = PsuedoRandomUtility.generateNumberUsingBlumBlumShub(); // TODO
																						// fixup
																						// blum
																						// blum
																						// algorithm
																						// or
																						// replace
																						// with
																						// a
																						// different
																						// one..
			numberOutput2.setText(Long.toString(generatedLong));
			textPrime2.setText(Boolean.toString(PsuedoRandomUtility.isPrime(generatedLong)));
		}
	}

}
