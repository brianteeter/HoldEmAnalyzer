package com.assorted.poker.gui;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * This panel will contain the controls used to compare multiple hand ranges
 * and/or hands to see which is a favorite.
 * 
 * @author Brian Teeter
 * 
 */
public class JCompareHandRangesPanel extends JPanel
{

	// ============================================================
	// Declare the header fields :
	// ============================================================
	public JLabel playerCountLabel = null;

	public JComboBox playerCountComboBox = null;

	public JLabel blindsLabel = null;

	public JTextField smallBlindField = null;

	public JTextField bigBlindField = null;

	public JComboBox limitStructureSelection = null;

	// ============================================================
	// Player table header labels:
	// ============================================================
	public JLabel positionLabel = null;

	public JLabel playerStackSizeLabel = null;

	public JLabel playerBetSizeLabel = null;

	public JLabel handRangeLabel = null;

	public JLabel handEquityLabel = null;

	// ============================================================
	// Declare the position radio buttons:
	// ============================================================
	public JRadioButton[] position = null;

	// ============================================================
	// Declare the player name field labels :
	// ============================================================
	public JLabel[] playerLabels = null;

	// ============================================================
	// Declare the player name field labels :
	// ============================================================
	public JTextField[] playerStackSize = null;

	// ============================================================
	// Declare the player name field labels :
	// ============================================================
	public JTextField[] playerBetSize = null;

	// ============================================================
	// Declare the text fields for specifying hand ranges:
	// ============================================================
	public JTextField[] handRanges = null;

	// ============================================================
	// Declare the drop downs for preset hand ranges:
	// ============================================================
	public JComboBox[] handRangePresets = null;

	// ============================================================
	// Declare the win % text fields:
	// ============================================================
	public JTextField[] handRangeWinPct = null;

	// ============================================================
	// Player recommendation message area objects
	// ============================================================
	public JTextArea playerRecommendations = null;

	/**
	 * Default Constructor
	 */
	public JCompareHandRangesPanel()
	{
		this.setLayout(null);
		this.setSize(800, 400);

		// ======================================================================
		// Create the Player Count Label and Drop Down:
		// ======================================================================
		playerCountLabel = new JLabel("Players:");
		playerCountLabel.setSize(70, 20);
		playerCountLabel.setLocation(10, 20);
		this.add(playerCountLabel);

		playerCountComboBox = new JComboBox();
		playerCountComboBox.addItem("2");
		playerCountComboBox.addItem("3");
		playerCountComboBox.addItem("4");
		playerCountComboBox.addItem("5");
		playerCountComboBox.addItem("6");
		playerCountComboBox.addItem("7");
		playerCountComboBox.addItem("8");
		playerCountComboBox.addItem("9");
		playerCountComboBox.addItem("10");
		playerCountComboBox.setSize(50, 20);
		playerCountComboBox.setLocation(80, 20);
		this.add(playerCountComboBox);

		// ======================================================================
		// Create the Blinds Label and Entry Fields:
		// ======================================================================
		blindsLabel = new JLabel("Structure:");
		blindsLabel.setSize(70, 20);
		blindsLabel.setLocation(150, 20);
		this.add(blindsLabel);

		smallBlindField = new JTextField("");
		smallBlindField.setSize(50, 20);
		smallBlindField.setLocation(230, 20);
		this.add(smallBlindField);

		bigBlindField = new JTextField("");
		bigBlindField.setSize(50, 20);
		bigBlindField.setLocation(285, 20);
		this.add(bigBlindField);

		limitStructureSelection = new JComboBox();
		limitStructureSelection.addItem("Limit");
		limitStructureSelection.addItem("Pot Limit");
		limitStructureSelection.addItem("No Limit");
		limitStructureSelection.setSize(100, 20);
		limitStructureSelection.setLocation(340, 20);
		this.add(limitStructureSelection);

		// ======================================================================
		// Create the Table of Player's Header Labels:
		// ======================================================================
		positionLabel = new JLabel("Position:");
		positionLabel.setSize(60, 20);
		positionLabel.setLocation(10, 70);
		this.add(positionLabel);

		playerStackSizeLabel = new JLabel("Stack Size:");
		playerStackSizeLabel.setSize(80, 20);
		playerStackSizeLabel.setLocation(150, 70);
		this.add(playerStackSizeLabel);

		playerBetSizeLabel = new JLabel("Bet Size:");
		playerBetSizeLabel.setSize(60, 20);
		playerBetSizeLabel.setLocation(230, 70);
		this.add(playerBetSizeLabel);

		handRangeLabel = new JLabel("Hand Range:");
		handRangeLabel.setSize(80, 20);
		handRangeLabel.setLocation(290, 70);
		this.add(handRangeLabel);

		handEquityLabel = new JLabel("Win %:");
		handEquityLabel.setSize(50, 20);
		handEquityLabel.setLocation(570, 70);
		this.add(handEquityLabel);

		// ======================================================================
		// Initialize the screen component arrays:
		// ======================================================================
		position = new JRadioButton[10];
		playerLabels = new JLabel[10];
		playerStackSize = new JTextField[10];
		playerBetSize = new JTextField[10];
		handRanges = new JTextField[10];
		handRangePresets = new JComboBox[10];
		handRangeWinPct = new JTextField[10];

		// ======================================================================
		// Programatically create and add the fields to the screen:
		// ======================================================================
		for (int playerNumber = 0; playerNumber < 10; playerNumber++)
		{
			int locationY = 70 + ((playerNumber + 1) * 30);

			// Create the Position Radio Button:
			position[playerNumber] = new JRadioButton();
			position[playerNumber].setSize(60, 20);
			position[playerNumber].setLocation(10, locationY);

			// Determine the text for this position Button:
			switch (playerNumber)
			{
			case 0:
			{
				position[playerNumber].setText("BB");
				break;
			}
			case 1:
			{
				position[playerNumber].setText("SB");
				break;
			}
			case 2:
			{
				position[playerNumber].setText("BTN");
				break;
			}
			default:
			{
				position[playerNumber].setText("CO+" + (playerNumber - 2));
				break;
			}
			}

			this.add(position[playerNumber]);

			// ======================================================================
			// Create the Player Label, size and add it:
			// ======================================================================
			playerLabels[playerNumber] = new JLabel("Player "
					+ (playerNumber + 1) + ":");
			playerLabels[playerNumber].setSize(60, 20);
			playerLabels[playerNumber].setLocation(80, locationY);
			this.add(playerLabels[playerNumber]);

			// Create the Player Stack Field, size and add it:
			playerStackSize[playerNumber] = new JTextField();
			playerStackSize[playerNumber].setSize(70, 20);
			playerStackSize[playerNumber].setLocation(150, locationY);
			this.add(playerStackSize[playerNumber]);

			// Create the Player Bet Field, size and add it:
			playerBetSize[playerNumber] = new JTextField();
			playerBetSize[playerNumber].setSize(50, 20);
			playerBetSize[playerNumber].setLocation(230, locationY);
			this.add(playerBetSize[playerNumber]);

			// Create the Player Hand Range Field, size and add it:
			handRanges[playerNumber] = new JTextField();
			handRanges[playerNumber].setSize(140, 20);
			handRanges[playerNumber].setLocation(290, locationY);
			this.add(handRanges[playerNumber]);

			// Create the Player Hand Range Preset Drop Down Field, size and add
			// it:
			handRangePresets[playerNumber] = new JComboBox();
			populatePresetRangeComboBox(handRangePresets[playerNumber]);
			handRangePresets[playerNumber].setSize(120, 20);
			handRangePresets[playerNumber].setLocation(440, locationY);
			this.add(handRangePresets[playerNumber]);

			// Create the Win % Fields, size and add it:
			handRangeWinPct[playerNumber] = new JTextField();
			handRangeWinPct[playerNumber].setSize(50, 20);
			handRangeWinPct[playerNumber].setLocation(570, locationY);
			this.add(handRangeWinPct[playerNumber]);

		}

		// Create, size and add the player recommendation message box:
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(null);
		messagePanel.setSize(210,300);
		messagePanel.setLocation(630,100);
		
		playerRecommendations = new JTextArea(""); 
		playerRecommendations.setSize(190,270);
		playerRecommendations.setLocation(10,20);
		messagePanel.add(playerRecommendations);
		messagePanel.setBorder(new TitledBorder("Messages"));
		this.add(messagePanel);

	}

	/**
	 * This function populates the hand range drop downs with their preset
	 * values.
	 * 
	 * @param rangeBox
	 */
	public void populatePresetRangeComboBox(JComboBox rangeBox)
	{
		if (rangeBox != null)
		{
			rangeBox.addItem(" ");
			rangeBox.addItem("Any Two Cards (100%)");
			rangeBox.addItem("Maniac (50%)");
			rangeBox.addItem("Loose (40%)");
			rangeBox.addItem("Semi-Loose (30%)");
			rangeBox.addItem("Tight (20%)");
			rangeBox.addItem("Rock (10%)");
		}

	}

}
