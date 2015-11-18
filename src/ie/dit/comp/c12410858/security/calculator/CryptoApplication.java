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
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.Font;

public class CryptoApplication {

	private JFrame frame;
	private JTextField txtPrime1;
	private JTextField numberOutput1;
	private JTextField numberOutput2;
	private JTextField textPrime2;
	private JTextField textFieldNextPrimeInput;
	private JTextField textFieldNextPrimeOutput;

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
		
		JLabel lblHeader1 = DefaultComponentFactory.getInstance().createTitle("Number Generators & Prime Tester");
		lblHeader1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeader1.setForeground(Color.DARK_GRAY);
		panel.add(lblHeader1);
		
		JPanel panelGenerate1 = new JPanel();
		FlowLayout fl_panelGenerate1 = (FlowLayout) panelGenerate1.getLayout();
		fl_panelGenerate1.setHgap(10);
		fl_panelGenerate1.setAlignment(FlowLayout.LEFT);
		panel.add(panelGenerate1);
		
		JLabel algorithmLabel1 = new JLabel("Mersenne Twister");
		panelGenerate1.add(algorithmLabel1);
		
		JButton btnGenerateNumber1 = new JButton("Generate number");
		panelGenerate1.add(btnGenerateNumber1);
		
		numberOutput1 = new JTextField();
		numberOutput1.setEditable(false);
		panelGenerate1.add(numberOutput1);
		numberOutput1.setColumns(15);
		
		JLabel lblPrime = new JLabel("Prime:");
		panelGenerate1.add(lblPrime);
		
		txtPrime1 = new JTextField();
		txtPrime1.setEditable(false);
		panelGenerate1.add(txtPrime1);
		txtPrime1.setText("");
		txtPrime1.setColumns(10);
		
		JPanel panelGenerate2 = new JPanel();
		FlowLayout fl_panelGenerate2 = (FlowLayout) panelGenerate2.getLayout();
		fl_panelGenerate2.setAlignment(FlowLayout.LEFT);
		fl_panelGenerate2.setHgap(10);
		panel.add(panelGenerate2);
		
		JLabel algorithmLabel2 = new JLabel("Blum Blum Shub");
		panelGenerate2.add(algorithmLabel2);
		
		JButton btnGenerateNumber2 = new JButton("Generate number");
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
		
		JLabel lblListLabel = new JLabel("10 Large Prime Numbers:");
		panelList.add(lblListLabel);
		
		JButton btnGenerateList = new JButton("Generate list");
		panelList.add(btnGenerateList);
		
		JScrollPane scrollPane = new JScrollPane();
		panelList.add(scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(10);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblHeader3 = DefaultComponentFactory.getInstance().createTitle("Next Prime Generator");
		lblHeader3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeader3.setForeground(Color.DARK_GRAY);
		panel.add(lblHeader3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblNextPrimeNumber = new JLabel("Next Prime Number");
		panel_4.add(lblNextPrimeNumber);
		
		textFieldNextPrimeInput = new JTextField();
		textFieldNextPrimeInput.setToolTipText("Enter a number");
		textFieldNextPrimeInput.setColumns(15);
		panel_4.add(textFieldNextPrimeInput);
		
		JButton btnGenerateNextPrime = new JButton("Generate next prime number");
		panel_4.add(btnGenerateNextPrime);
		
		textFieldNextPrimeOutput = new JTextField();
		textFieldNextPrimeOutput.setEditable(false);
		panel_4.add(textFieldNextPrimeOutput);
		textFieldNextPrimeOutput.setColumns(15);
	}

}
