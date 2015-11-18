package ie.dit.comp.c12410858.security.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.BorderLayout;

public class CryptoApplication {

	private static String appTitle = "Lab 5 Number Generator";
	private String generatePreMessage = "Generate list";
	private String generateDuringMessage = "Generating list...";

	private JFrame frame;
	private JTextField numberOutput1;
	private JTextField numberOutput2;
	private JTextField textPrime1;
	private JTextField textPrime2;
	private JTextField textFieldNextPrimeInput;
	private JTextField textFieldNextPrimeOutput;
	private JButton btnGenerateNumber1;
	private JButton btnGenerateNumber2;
	JButton btnGenerateList;
	private JList<Long> list;

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
		frame.setBounds(100, 100, 649, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		JLabel lblHeader1 = DefaultComponentFactory.getInstance().createTitle("Number Generators & Prime Tester");
		lblHeader1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblHeader1.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblHeader1);
		lblHeader1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeader1.setForeground(Color.DARK_GRAY);

		JPanel panelGenerate1 = new JPanel();
		frame.getContentPane().add(panelGenerate1);

		JLabel algorithmLabel1 = new JLabel("Mersenne Twister");
		algorithmLabel1.setHorizontalAlignment(SwingConstants.CENTER);

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
		lblPrime.setHorizontalAlignment(SwingConstants.RIGHT);

		textPrime1 = new JTextField();
		textPrime1.setEditable(false);
		textPrime1.setText("");
		textPrime1.setColumns(10);
		panelGenerate1.setLayout(new GridLayout(0, 5, 0, 0));
		panelGenerate1.add(algorithmLabel1);
		panelGenerate1.add(btnGenerateNumber1);
		panelGenerate1.add(numberOutput1);
		panelGenerate1.add(lblPrime);
		panelGenerate1.add(textPrime1);

		JPanel panelGenerate2 = new JPanel();
		frame.getContentPane().add(panelGenerate2);
		panelGenerate2.setLayout(new GridLayout(0, 5, 0, 0));

		JLabel algorithmLabel2 = new JLabel("Blum Blum Shub");
		algorithmLabel2.setHorizontalAlignment(SwingConstants.CENTER);
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
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGenerate2.add(label_1);

		textPrime2 = new JTextField();
		textPrime2.setText("");
		textPrime2.setEditable(false);
		textPrime2.setColumns(10);
		panelGenerate2.add(textPrime2);

		JLabel lblHeader2 = DefaultComponentFactory.getInstance().createTitle("Large Prime Number List Generator");
		lblHeader2.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblHeader2);
		lblHeader2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeader2.setForeground(Color.DARK_GRAY);

		JPanel panelList = new JPanel();
		frame.getContentPane().add(panelList);
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panelList.add(scrollPane);

		Algorithm[] algorithms = Algorithm.values();
		String[] algorithmNames = new String[algorithms.length];
		
		for(int i=0; i < algorithms.length; i++){
			algorithmNames[i] = algorithms[i].getText();
		}

		DefaultComboBoxModel<String> algorithmModel = new DefaultComboBoxModel<String>(algorithmNames);
		
		JComboBox comboListAlgorithm = new JComboBox(algorithmModel);
		comboListAlgorithm.setToolTipText("Select the algorithm to use when generating the list.");

		list = new JList<Long>();
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(10);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		btnGenerateList = new JButton(generatePreMessage);
		btnGenerateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String currentlySelected = comboListAlgorithm.getSelectedItem().toString();
				int amountToGenerate = 10;
				Algorithm algorithm = Algorithm.fromString(currentlySelected);

				if (algorithm != null) {

					createListOfPrimes(amountToGenerate, algorithm);
				}

			}
		});
		panelList.add(btnGenerateList);

		JLabel lblUsing = new JLabel(" using ");
		panelList.add(lblUsing);

		panelList.add(comboListAlgorithm);

		JLabel lblHeader3 = DefaultComponentFactory.getInstance().createTitle("Next Prime Generator");
		lblHeader3.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblHeader3);
		lblHeader3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeader3.setForeground(Color.DARK_GRAY);

		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

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
					long nextPrime = PsuedoRandomUtility.generateNextPrimeNumber(inputLong);
					textFieldNextPrimeOutput.setText(Long.toString(nextPrime));
				} else {
					textFieldNextPrimeOutput.setText("Invalid input! Must be a number");
				}

			}
		});
		panel_4.add(btnGenerateNextPrime);

		textFieldNextPrimeOutput = new JTextField();
		textFieldNextPrimeOutput.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNextPrimeOutput.setEditable(false);
		panel_4.add(textFieldNextPrimeOutput);
		textFieldNextPrimeOutput.setColumns(15);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Assignment Details  ");
		lblNewJgoodiesTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewJgoodiesTitle.setForeground(Color.DARK_GRAY);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JTextPane textPane = new JTextPane();
		panel_2.add(textPane);
		textPane.setText("Advanced Security Lab 5\r\n18/11/2015\r\n\r\nAlan Haverty\r\nC12410858\r\nDT211C4");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 10));

//		Algorithm[] algorithms = Algorithm.values();
//		String[] algorithmNames = new String[algorithms.length];
//
//		for (int i = 0; i < algorithms.length; i++) {
//			algorithmNames[i] = algorithms[i].getText();
//		}
//
//		DefaultComboBoxModel<String> algorithmModel = new DefaultComboBoxModel<String>(algorithmNames);
	}

	/**
	 * Generate a random number and update the corresponding output text field
	 * 
	 * @param e
	 */
	private void setGeneratedNumberAndPrime(ActionEvent e) {
		if (e.getSource() == btnGenerateNumber1) {
			long generatedLong = PsuedoRandomUtility.generateNumberUsingMersenneTwister();
			numberOutput1.setText(Long.toString(generatedLong));
			textPrime1.setText(Boolean.toString(PsuedoRandomUtility.isPrime(generatedLong)));
		}
		if (e.getSource() == btnGenerateNumber2) {
			long generatedLong = PsuedoRandomUtility.generateNumberUsingBlumBlumShub();
			// TODO fixup blum blum algorithm or replace with a different one..
			numberOutput2.setText(Long.toString(generatedLong));
			textPrime2.setText(Boolean.toString(PsuedoRandomUtility.isPrime(generatedLong)));
		}
	}

	/**
	 * Algorithm enum for the various types of algorithms
	 * 
	 * @author Alan
	 *
	 */
	public enum Algorithm {
		BLUM_BLUM_SHUB("Blum Blum Shub"), MERSENNE_TWISTER("Mersenne Twister");
		private String text;

		Algorithm(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}

		public static Algorithm fromString(String text) {
			if (text != null) {
				for (Algorithm b : Algorithm.values()) {
					if (text.equalsIgnoreCase(b.text)) {
						return b;
					}
				}
			}
			return null;
		}
	}

	/**
	 * Generate a prime number using a specified algorithm
	 * 
	 * @param algorithm
	 * @return A long prime number
	 */
	private long generatePrimeUsingAlgorithm(Algorithm algorithm) {
		if (algorithm == Algorithm.BLUM_BLUM_SHUB) {
			long randomNumber;
			do {
				randomNumber = PsuedoRandomUtility.generateNumberUsingBlumBlumShub();
			} while (PsuedoRandomUtility.isPrime(randomNumber) == false);
			return randomNumber;
		} else if (algorithm == Algorithm.MERSENNE_TWISTER) {
			long randomNumber;
			do {
				randomNumber = PsuedoRandomUtility.generateNumberUsingMersenneTwister();
			} while (PsuedoRandomUtility.isPrime(randomNumber) == false);
			return randomNumber;
		} else {
			return 0;
		}
	}

	/**
	 * Background task for generating prime numbers and updating the list and
	 * buttons
	 * 
	 * @param amountToGenerate
	 * @param algorithm
	 * @author Alan
	 */
	private void createListOfPrimes(int amountToGenerate, Algorithm algorithm) {
		SwingWorker<Boolean, Long[]> worker = new SwingWorker<Boolean, Long[]>() {
			@Override
			protected Boolean doInBackground() throws Exception {

				btnGenerateList.setEnabled(false);
				btnGenerateList.setText(generateDuringMessage);

				Long[] primes = new Long[amountToGenerate];

				for (int i = 0; i < amountToGenerate; i++) {
					primes[i] = generatePrimeUsingAlgorithm(algorithm);
					publish(primes);
				}
				return true;
			}

			protected void done() {
				System.out.println("Completed creating list of primes.");
				btnGenerateList.setEnabled(true);
				btnGenerateList.setText(generatePreMessage);
			}

			@Override
			protected void process(List<Long[]> chunks) {
				Long[] mostRecentValue = chunks.get(chunks.size() - 1);
				list.setListData(mostRecentValue);
			}

		};

		worker.execute();
	}

}
