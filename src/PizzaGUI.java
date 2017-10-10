import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * COSC 210 Assignment9 PizzaGUI.java
 * 
 * this class is the GUI for a Pizza application
 * for Pizzazz Pizza
 * 
 * @author Nathaniel Churchill
 *
 */

public class PizzaGUI extends JFrame {

	// north components
	private JPanel northPanel;
	private JLabel topLabel;

	// west componenets
	private JPanel westPanel;
	private JLabel sizeLabel;
	private static final String[] radioButtonNames = { "Medium", "Large",
			"X-Large" };
	private JRadioButton[] radioButtons = new JRadioButton[radioButtonNames.length];

	// center components
	private JPanel centerPanel;
	private JLabel toppingsLabel;
	private JCheckBox pepperoni;
	private JCheckBox sausage;
	private JCheckBox mushrooms;
	private JCheckBox onions;

	// east components
	private JPanel eastPanel;
	private JLabel crustLabel;
	private JComboBox crustBox;
	private static final String[] boxNames = { "Thin", "Original",
			"Deep Dish" };
	private static final double[] crustCost = { 0, 0, 2.00 };

	// south components
	private JPanel southPanel;
	private JButton submitButton;
	private JLabel totalLabel;
	private JTextField totalField;

	public PizzaGUI() {
		// name the window
		super("PizzaGUI");
		// set the layout
		setLayout(new BorderLayout(5, 5));
		// North
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		topLabel = new JLabel("Pizzazz Pizza");
		topLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		topLabel.setForeground(Color.BLUE);
		northPanel.add(topLabel);
		add(northPanel, BorderLayout.NORTH);

		// west side
		westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(5, 1, 3, 3));
		westPanel.setBackground(Color.GREEN);
		sizeLabel = new JLabel("Size", JLabel.CENTER);
		// making the radio buttons
		for (int counter = 0; counter < radioButtonNames.length; counter++) {
			radioButtons[counter] = new JRadioButton(radioButtonNames[counter]);
			radioButtons[counter].setBackground(Color.GREEN);
		}
		ButtonGroup pizzaSizeGroup = new ButtonGroup();
		// adding the radio buttons to the button group
		for (int i = 0; i < radioButtons.length; i++) {
			pizzaSizeGroup.add(radioButtons[i]);
		}
		// adding buttons to the panel
		westPanel.add(sizeLabel);
		westPanel.add(radioButtons[0]);
		westPanel.add(radioButtons[1]);
		westPanel.add(radioButtons[2]);

		add(westPanel, BorderLayout.WEST);

		// center
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 1, 3, 3));
		centerPanel.setBackground(Color.CYAN);
		toppingsLabel = new JLabel("Toppings", JLabel.CENTER);
		pepperoni = new JCheckBox("Pepperoni");
		pepperoni.setBackground(Color.CYAN);
		pepperoni.setHorizontalAlignment(JCheckBox.CENTER);
		sausage = new JCheckBox("Sausage");
		sausage.setBackground(Color.CYAN);
		sausage.setHorizontalAlignment(JCheckBox.CENTER);
		mushrooms = new JCheckBox("Mushrooms");
		mushrooms.setBackground(Color.CYAN);
		mushrooms.setHorizontalAlignment(JCheckBox.CENTER);
		onions = new JCheckBox("Onions");
		onions.setBackground(Color.CYAN);
		onions.setHorizontalAlignment(JCheckBox.CENTER);

		centerPanel.add(toppingsLabel, SwingConstants.CENTER);
		centerPanel.add(pepperoni);
		centerPanel.add(sausage);
		centerPanel.add(mushrooms);
		centerPanel.add(onions);

		add(centerPanel, BorderLayout.CENTER);

		// east
		eastPanel = new JPanel();
		eastPanel.setBackground(Color.RED);
		eastPanel.setLayout(new GridLayout(5, 1, 3, 3));
		crustLabel = new JLabel("Crust", JLabel.CENTER);
		crustBox = new JComboBox(boxNames);
		crustBox.setBackground(Color.RED);
		eastPanel.add(crustLabel);
		eastPanel.add(crustBox);
		add(eastPanel, BorderLayout.EAST);

		// south
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 3, 15, 15));
		totalLabel = new JLabel("Total", SwingConstants.RIGHT);
		totalField = new JTextField(20);
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new ButtonHandler());
		southPanel.add(submitButton);
		southPanel.add(totalLabel);
		southPanel.add(totalField);

		add(southPanel, BorderLayout.SOUTH);
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			final double MEDIUM = 7.95;
			final double LARGE = 9.95;
			final double XLARGE = 12.95;
			// size
			double total = 0;
			if (radioButtons[0].isSelected()) {
				total += MEDIUM;
			} else if (radioButtons[1].isSelected()) {
				total += LARGE;
			} else if (radioButtons[2].isSelected()) {
				total += XLARGE;
			}

			// toppings
			if (pepperoni.isSelected()) {
				total += 1.25;
			}
			if (sausage.isSelected()) {
				total += 1.25;
			}
			if (mushrooms.isSelected()) {
				total += 1.25;
			}
			if (onions.isSelected()) {
				total += 1.25;
			}

			// crust
			total += crustCost[crustBox.getSelectedIndex()];
			// setting the text field
			totalField.setText(String.format("$%.2f", total));

		}

	}

}
