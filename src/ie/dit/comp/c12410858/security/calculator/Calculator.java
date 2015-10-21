package ie.dit.comp.c12410858.security.calculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * GUI Calculator using simple operations +, -, *, /
 * @author Alan
 *
 */
public class Calculator extends JFrame {

	private static final long serialVersionUID = 7301428483702583079L;

	//Enum for the operators used in the calculator
	enum Operator {
		Add("+"), Subtract("-"), Multiply("*"), Divide("/"), Equal("=");

		private String text;

		private Operator(String text) {
			this.text = text;
		}

		/**
		 * Get an enum instance by matching a string to an enum
		 * @param text
		 * @return
		 */
		public static Operator fromString(String text) {
			if (text != null) {
				for (Operator o : Operator.values()) {
					if (text.equalsIgnoreCase(o.text)) {
						return o;
					}
				}
			}
			return null;
		}
	}

	private final String appTitle = "Advanced Security Calculator";

	private static final Font BIGGER_FONT = new Font("monspaced", Font.PLAIN, 20);
	private JTextField displayField;

	private boolean firstDigit = true;
	private Operator previousOp = Operator.Equal;
	private ArithmeticLogic logic = new ArithmeticLogic();

	public static void main(String[] args) {
		// Set the Look and Feel to that of system
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignore) {
		}

		// Create the window.
		Calculator window = new Calculator();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public Calculator() {
		
		//Setup the display field used for displaying the digits and totals
		displayField = new JTextField("0", 12);
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		displayField.setFont(BIGGER_FONT);

		//Setup the clear button used for resetting the calculator
		JButton clearButton = new JButton("Clear");
		clearButton.setFont(BIGGER_FONT);
		clearButton.addActionListener(new ClearListener());

		ActionListener numListener = new NumListener();

		//Setup the digit buttons and panel
		String[] buttonLabels = { "7", "8", "9", "4", "5", "6", "1", "2", "3", null, "0", null };
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 3, 2, 2));

		for (String label : buttonLabels) {
			JButton button = new JButton();
			if (label != null) {
				button.setText(label);
				button.addActionListener(numListener);
				button.setFont(BIGGER_FONT);
			} else {
				button.setEnabled(false);
			}
			buttonPanel.add(button);
		}

		ActionListener opListener = new OpListener();

		//Setup the operator buttons and panel
		JPanel operatorPanel = new JPanel();
		operatorPanel.setLayout(new GridLayout(5, 1, 2, 2));
		String[] operatorLabels = { "+", "-", "*", "/", "=" };
		for (String label : operatorLabels) {
			JButton button = new JButton(label);
			button.addActionListener(opListener);
			button.setFont(BIGGER_FONT);
			operatorPanel.add(button);
		}

		JPanel clearPanel = new JPanel();
		clearPanel.setLayout(new FlowLayout());
		clearPanel.add(clearButton);

		//Setup the gui
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout(5, 5));
		content.add(displayField, BorderLayout.NORTH);
		content.add(buttonPanel, BorderLayout.CENTER);
		content.add(operatorPanel, BorderLayout.EAST);
		content.add(clearPanel, BorderLayout.SOUTH);

		content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		this.setContentPane(content);
		this.pack();
		this.setTitle(appTitle);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Clear function for setting the text field to 0, setting the last known
	 * operator and clearing the logic instance
	 */
	private void actionClear() {
		firstDigit = true; // Expecting number, not op.
		displayField.setText("0");
		previousOp = Operator.Equal;
		logic.clear();
	}

	/**
	 * Action Listener for the operator buttons
	 * 
	 * @author Alan
	 *
	 */
	class OpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				// Get the current total from the text field
				Double displayDigit = Double.valueOf(displayField.getText());

				switch (previousOp) {
				case Equal:
					logic.setTotal(displayDigit);
					break;
				case Add:
					logic.add(displayDigit);
					break;
				case Subtract:
					logic.subtract(displayDigit);
					break;
				case Multiply:
					logic.multiply(displayDigit);
					break;
				case Divide:
					logic.divide(displayDigit);
					break;
				default:
					break;
				}

				firstDigit = true;
				displayField.setText(logic.getTotalAsString());

			} catch (NumberFormatException ex) {
				actionClear();
				displayField.setText("Error");
			}

			// Marshal an enum from the text from the button press
			previousOp = Operator.fromString(e.getActionCommand());

		}
	}

	/**
	 * Action Listener for the numeric buttons
	 * 
	 * @author Alan
	 *
	 */
	class NumListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String digit = e.getActionCommand(); // Get text from button
			if (firstDigit) {
				// This is the first digit, clear field and set with digit
				displayField.setText(digit);
				firstDigit = false;
			} else {
				// Add this digit to the end of the display field/append to
				// previous digit
				displayField.setText(displayField.getText() + digit);
			}
		}
	}

	/**
	 * Action Listener for the clear button
	 * 
	 * @author Alan
	 */
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actionClear();
		}
	}
}