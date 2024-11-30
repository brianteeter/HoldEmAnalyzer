package com.brianteeter.poker.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.brianteeter.poker.engine.HoldEmSimulationEngine;
import com.brianteeter.poker.model.Card;
import com.brianteeter.poker.results.HoldEmSimulationResults;
import com.brianteeter.poker.utils.HoldEmAnalyzerConstants;

public class HoldEmAnalyzerFrame extends JFrame implements ActionListener
{
	Font defaultFont = new Font("Verdana", Font.BOLD, 10);

	Font evenSpacedFont = new Font("Courier", Font.PLAIN, 11);

	// Declare the the menu objects for the application:
	JMenuBar menuBar = null;

	// Delcare the file menu objects
	JMenu fileMenu = null;

	JMenuItem exitMenuItem = null;

	// Delcare the Help menu objects
	JMenu helpMenu = null;

	JMenuItem aboutMenuItem = null;

	JMenuItem registerMenuItem = null;

	// Declare the Tabbed Panel objects:
	JPanel mainPanel = null;

	JTabbedPane tabbedPane = null;

	// Declare the first panel
	JPanel tab1Panel = null;

	JPanel tab1PanelTopSlice = null;

	JPanel tab1PanelTopLeftSlice = null;

	JPanel tab1PanelHoleCardSlice = null;

	JPanel tab1PanelFlopSlice = null;

	JPanel tab1PanelTurnCardSlice = null;

	JPanel tab1PanelRiverCardSlice = null;

	JPanel tab1PanelButtonSlice = null;

	GridLayout tab1PanelTopSliceLayout = null;

	JPanel tab1PanelMiddleSlice = null;

	JPanel tab1PanelBottomSlice = null;

	JLabel holeCardLabel = null;

	JCardButton holeCard1Button = null;

	JCardButton holeCard2Button = null;

	JLabel flopCardLabel = null;

	JCardButton flopCard1Button = null;

	JCardButton flopCard2Button = null;

	JCardButton flopCard3Button = null;

	JLabel turnCardLabel = null;

	JCardButton turnCardButton = null;

	JLabel riverCardLabel = null;

	JCardButton riverCardButton = null;

	JLabel playerCountLabel = null;

	JComboBox playerCountField = null;

	JButton runSimulationButton = null;

	JButton clearResultButton = null;

	JAllCardsPanel cardSelectionPanel = null;

	JPanel messagePanel = null;

	JLabel messageLabel = null;

	JTextArea messageField = null;

	JHandResultsGenericPanel resultsPanel = null;

	JPotOddsPanel potOddsPanel = null;

	JPanel resultsContainerPanel = new JPanel();

	private static final long serialVersionUID = 3982232838917125870L;

	public JPanel getResultsContainerPanel()
	{
		return resultsContainerPanel;
	}

	public void setResultsContainerPanel(JPanel resultsContainerPanel)
	{
		this.resultsContainerPanel = resultsContainerPanel;
	}

	public JHandResultsGenericPanel getResultsPanel()
	{
		return resultsPanel;
	}

	public void setResultsPanel(JHandResultsPanel resultsPanel)
	{
		this.resultsPanel = resultsPanel;
	}

	public JAllCardsPanel getCardSelectionPanel()
	{
		return cardSelectionPanel;
	}

	public void setCardSelectionPanel(JAllCardsPanel cardSelectionPanel)
	{
		this.cardSelectionPanel = cardSelectionPanel;
	}

	public JButton getClearResultButton()
	{
		return clearResultButton;
	}

	public void setClearResultButton(JButton clearResultButton)
	{
		this.clearResultButton = clearResultButton;
	}

	public JButton getRunSimulationButton()
	{
		return runSimulationButton;
	}

	public void setRunSimulationButton(JButton runSimulationButton)
	{
		this.runSimulationButton = runSimulationButton;
	}

	public JTextArea getMessageField()
	{
		return messageField;
	}

	public void setMessageField(JTextArea messageField)
	{
		this.messageField = messageField;
	}

	public JLabel getMessageLabel()
	{
		return messageLabel;
	}

	public void setMessageLabel(JLabel messageLabel)
	{
		this.messageLabel = messageLabel;
	}

	public static long getSerialVersionUID()
	{
		return serialVersionUID;
	}

	public JMenuItem getExitMenuItem()
	{
		return exitMenuItem;
	}

	public void setExitMenuItem(JMenuItem exitMenuItem)
	{
		this.exitMenuItem = exitMenuItem;
	}

	public JMenu getFileMenu()
	{
		return fileMenu;
	}

	public void setFileMenu(JMenu fileMenu)
	{
		this.fileMenu = fileMenu;
	}

	public JCardButton getFlopCard1Button()
	{
		return flopCard1Button;
	}

	public void setFlopCard1Button(JCardButton flopCard1Button)
	{
		this.flopCard1Button = flopCard1Button;
	}

	public JCardButton getFlopCard2Button()
	{
		return flopCard2Button;
	}

	public void setFlopCard2Button(JCardButton flopCard2Button)
	{
		this.flopCard2Button = flopCard2Button;
	}

	public JCardButton getFlopCard3Button()
	{
		return flopCard3Button;
	}

	public void setFlopCard3Button(JCardButton flopCard3Button)
	{
		this.flopCard3Button = flopCard3Button;
	}

	public JLabel getFlopCardLabel()
	{
		return flopCardLabel;
	}

	public void setFlopCardLabel(JLabel flopCardLabel)
	{
		this.flopCardLabel = flopCardLabel;
	}

	public JCardButton getHoleCard1Button()
	{
		return holeCard1Button;
	}

	public void setHoleCard1Button(JCardButton holeCard1Button)
	{
		this.holeCard1Button = holeCard1Button;
	}

	public JCardButton getHoleCard2Button()
	{
		return holeCard2Button;
	}

	public void setHoleCard2Button(JCardButton holeCard2Button)
	{
		this.holeCard2Button = holeCard2Button;
	}

	public JLabel getHoleCardLabel()
	{
		return holeCardLabel;
	}

	public void setHoleCardLabel(JLabel holeCardLabel)
	{
		this.holeCardLabel = holeCardLabel;
	}

	public JPanel getMainPanel()
	{
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel)
	{
		this.mainPanel = mainPanel;
	}

	public void setMenuBar(JMenuBar menuBar)
	{
		this.menuBar = menuBar;
	}

	public JCardButton getRiverCardButton()
	{
		return riverCardButton;
	}

	public void setRiverCardButton(JCardButton riverCardButton)
	{
		this.riverCardButton = riverCardButton;
	}

	public JLabel getRiverCardLabel()
	{
		return riverCardLabel;
	}

	public void setRiverCardLabel(JLabel riverCardLabel)
	{
		this.riverCardLabel = riverCardLabel;
	}

	public JPanel getTab1Panel()
	{
		return tab1Panel;
	}

	public void setTab1Panel(JPanel tab1Panel)
	{
		this.tab1Panel = tab1Panel;
	}

	public JPanel getTab1PanelBottomSlice()
	{
		return tab1PanelBottomSlice;
	}

	public void setTab1PanelBottomSlice(JPanel tab1PanelBottomSlice)
	{
		this.tab1PanelBottomSlice = tab1PanelBottomSlice;
	}

	public JPanel getTab1PanelMiddleSlice()
	{
		return tab1PanelMiddleSlice;
	}

	public void setTab1PanelMiddleSlice(JPanel tab1PanelMiddleSlice)
	{
		this.tab1PanelMiddleSlice = tab1PanelMiddleSlice;
	}

	public JPanel getTab1PanelTopSlice()
	{
		return tab1PanelTopSlice;
	}

	public void setTab1PanelTopSlice(JPanel tab1PanelTopSlice)
	{
		this.tab1PanelTopSlice = tab1PanelTopSlice;
	}

	public GridLayout getTab1PanelTopSliceLayout()
	{
		return tab1PanelTopSliceLayout;
	}

	public void setTab1PanelTopSliceLayout(GridLayout tab1PanelTopSliceLayout)
	{
		this.tab1PanelTopSliceLayout = tab1PanelTopSliceLayout;
	}

	public JTabbedPane getTabbedPane()
	{
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane)
	{
		this.tabbedPane = tabbedPane;
	}

	public JCardButton getTurnCardButton()
	{
		return turnCardButton;
	}

	public void setTurnCardButton(JCardButton turnCardButton)
	{
		this.turnCardButton = turnCardButton;
	}

	public JLabel getTurnCardLabel()
	{
		return turnCardLabel;
	}

	public void setTurnCardLabel(JLabel turnCardLabel)
	{
		this.turnCardLabel = turnCardLabel;
	}

	/**
	 * This method initializes the Menu bar for the application
	 * 
	 */
	public void initMenus()
	{
		// Create the menu and add it to the app:
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");

		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(this);
		fileMenu.add(exitMenuItem);

		// Delcare the Help menu objects
		helpMenu = new JMenu("Help");

		aboutMenuItem = new JMenuItem("About this Application ...");
		aboutMenuItem.addActionListener(this);
		helpMenu.add(aboutMenuItem);

		registerMenuItem = new JMenuItem("Register the "
				+ HoldEmAnalyzerConstants.APPLICATION_NAME + " ...");
		registerMenuItem.addActionListener(this);
		helpMenu.add(registerMenuItem);

		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		// Add the menu to the application frame:
		this.setJMenuBar(menuBar);
	}

	/**
	 * Constructor
	 * 
	 */
	public HoldEmAnalyzerFrame()
	{
		// Size the Window appropriately:
		this.setSize(800, 650);

		// Set the window title:
		String windowTitle = HoldEmAnalyzerConstants.APPLICATION_NAME + " "
				+ HoldEmAnalyzerConstants.APPLICATION_VERSION;

		if (HoldEmAnalyzerConstants.APPLICATION_TRIAL == true)
		{
			windowTitle += " TRIAL VERSION";
		}
		this.setTitle(windowTitle);

		// Get the System Toolkit to get the Screen Dimensions:
		Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		// Center the window on the screen:
		this.setLocation(((screenSize.width - 800) / 2),
				((screenSize.height - 500) / 2));

		// Set the icon for the application:
		this.setIconImage(new ImageIcon("icon.gif").getImage());

		
		// Initialize Menus
		initMenus();

		// Close the application on the close of the window:
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Create the main panel for the window:
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.setContentPane(mainPanel);

		// Create the Tabbed Pane and add it to the main Panel:
		tabbedPane = new JTabbedPane();
		mainPanel.add(tabbedPane, BorderLayout.CENTER);

		// Initialize the Add the Hand Analysis panel:
		initHandAnalysisPanel();
		tabbedPane.add("Analyze Hands", tab1Panel);

		// Create a 2nd Panel:
		tabbedPane.add("Compare Hands", new JCompareHandsPanel());

		// Create the 3rd Panel:
		// tabbedPane.add("Compare Hand Ranges", new JCompareHandRangesPanel());

		// Create the Preferences Panel:
		tabbedPane.add("Application Preferences", new JPreferencesPanel());

	}

	/**
	 * This method initializes the Hand Analysis panel GUI
	 * 
	 */
	public void initHandAnalysisPanel()
	{
		// Create the first panel and populate it with its objects:
		tab1Panel = new JPanel();
		tab1Panel.setLayout(null);

		// Create the top bit of the Analysis panel
		tab1PanelTopSlice = new JPanel();

		tab1PanelTopSlice.setLayout(null); // (new
		// FlowLayout(FlowLayout.LEFT));
		tab1PanelTopSlice.setSize(775, 550);
		tab1PanelTopSlice.setBorder(new TitledBorder("Simulation Setup"));

		tab1PanelTopLeftSlice = new JPanel();
		tab1PanelTopLeftSlice.setLayout(new GridLayout(4, 2, 1, 1));
		tab1PanelTopLeftSlice.setBorder(new TitledBorder("Current Hand"));

		holeCardLabel = new JLabel("Hole Cards:");
		tab1PanelTopLeftSlice.add(holeCardLabel);

		tab1PanelHoleCardSlice = new JPanel();
		tab1PanelHoleCardSlice.setLayout(new FlowLayout(FlowLayout.LEFT));
		holeCard1Button = new JCardButton();
		holeCard2Button = new JCardButton();
		tab1PanelHoleCardSlice.add(holeCard1Button);
		tab1PanelHoleCardSlice.add(holeCard2Button);
		tab1PanelTopLeftSlice.add(tab1PanelHoleCardSlice);

		flopCardLabel = new JLabel("Board :");
		tab1PanelTopLeftSlice.add(flopCardLabel);

		flopCard1Button = new JCardButton();
		flopCard2Button = new JCardButton();
		flopCard3Button = new JCardButton();
		turnCardButton = new JCardButton();
		riverCardButton = new JCardButton();

		tab1PanelFlopSlice = new JPanel();
		tab1PanelFlopSlice.setLayout(new FlowLayout(FlowLayout.LEFT));
		tab1PanelFlopSlice.add(flopCard1Button);
		tab1PanelFlopSlice.add(flopCard2Button);
		tab1PanelFlopSlice.add(flopCard3Button);
		tab1PanelFlopSlice.add(turnCardButton);
		tab1PanelFlopSlice.add(riverCardButton);
		tab1PanelTopLeftSlice.add(tab1PanelFlopSlice);

		playerCountLabel = new JLabel("Players:");
		tab1PanelTopLeftSlice.add(playerCountLabel);

		playerCountField = new JComboBox();
		JPanel playerCountFieldPanel = new JPanel();
		playerCountFieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		playerCountField.addItem(new Integer(2));
		playerCountField.addItem(new Integer(3));
		playerCountField.addItem(new Integer(4));
		playerCountField.addItem(new Integer(5));
		playerCountField.addItem(new Integer(6));
		playerCountField.addItem(new Integer(7));
		playerCountField.addItem(new Integer(8));
		playerCountField.addItem(new Integer(9));
		playerCountField.addItem(new Integer(10));
		playerCountFieldPanel.add(playerCountField);
		tab1PanelTopLeftSlice.add(playerCountFieldPanel);

		runSimulationButton = new JButton("Run Simulation");
		JPanel runSimulationButtonPanel = new JPanel();
		runSimulationButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		runSimulationButton.addActionListener(this);
		runSimulationButtonPanel.add(runSimulationButton);
		tab1PanelTopLeftSlice.add(runSimulationButtonPanel);

		clearResultButton = new JButton("Clear");
		JPanel clearSimulationButtonPanel = new JPanel();
		clearSimulationButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		clearResultButton.addActionListener(this);
		clearSimulationButtonPanel.add(clearResultButton);
		tab1PanelTopLeftSlice.add(clearSimulationButtonPanel);

		// Try to set the location to the exact spot we are looking for:
		tab1PanelTopLeftSlice.setLocation(10, 20);
		tab1PanelTopLeftSlice.setSize(260, 200);

		// Add the slice to the top panel slice:
		tab1PanelTopSlice.add(tab1PanelTopLeftSlice);

		cardSelectionPanel = new JAllCardsPanel();
		cardSelectionPanel.setSize(260, 170);
		cardSelectionPanel.setLocation(10, 220);

		tab1PanelTopSlice.add(cardSelectionPanel);

		// Set this frame as the listener for the Card Panel:
		cardSelectionPanel.setCardButtonActionListener(this);

		// Create a panel to put in the results:
		resultsPanel = new JHandResultsPieChartPanel();
		resultsContainerPanel = new JPanel();
		resultsContainerPanel.add(resultsPanel);
		BoxLayout resultsContainerPanelBoxLayout = new BoxLayout(
				resultsContainerPanel, BoxLayout.Y_AXIS);
		resultsContainerPanel.setLayout(resultsContainerPanelBoxLayout);
		resultsContainerPanel.setSize(475, 500);
		resultsContainerPanel.setLocation(270, 20);

		tab1PanelTopSlice.add(resultsContainerPanel);

		// Create the Pot Odds panel and add it to the bottom:
		potOddsPanel = new JPotOddsPanel();
		resultsContainerPanel.add(potOddsPanel);

		// Add our panels to the Tab 1 Panel:
		tab1Panel.add(tab1PanelTopSlice);
		tab1Panel.setSize(775, 550);

		// Create the message panel and add it too:
		messagePanel = new JPanel();
	}

	/**
	 * Run the class to test/use it.
	 * 
	 * @param args
	 */
public static void main(String[] args)
	{
	
		// =====================================================================
		// Show the splash window for 3 seconds and then display this window:
		// =====================================================================
		JSplashScreen splashScreen = new JSplashScreen();
		splashScreen.setVisible(true);
		// splashScreen.setLocation();

		// =====================================================================
		// Pause for 7 seconds, close the splash screen and then show the main
		// window for the application:
		// =====================================================================
		try
		{
		Thread.sleep(4000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}

		// Close the splash screen
		splashScreen.setVisible(false);
		splashScreen = null;

		// Display the main window:
		HoldEmAnalyzerFrame frame = new HoldEmAnalyzerFrame();
		frame.setVisible(true);

	}
	/**
	 * Handler method to handle action messages sent by objects on this frame.
	 */
	public void actionPerformed(ActionEvent arg0)
	{
		// If the action is a JCardButton action, see where we need to put the
		// next card:
		if (arg0.getSource().getClass().toString().indexOf(
				"com.brianteeter.poker.gui.JCardButton") > 0)
		{
			JCardButton cardButton = (JCardButton) arg0.getSource();

			// Only hide the clicked on Card, if we don't already have
			// all the cards for the hand:
			if (this.getRiverCardButton().getCard() == null)
			{
				cardButton.setVisible(false);
			}

			if (this.getHoleCard1Button().getCard() == null)
			{
				Card newCard = new Card(arg0.getActionCommand());
				this.getHoleCard1Button().setCard(newCard);

			}
			else
			{
				if (this.getHoleCard2Button().getCard() == null)
				{
					Card newCard = new Card(arg0.getActionCommand());
					this.getHoleCard2Button().setCard(newCard);
				}
				else
				{

					if (this.getFlopCard1Button().getCard() == null)
					{
						Card newCard = new Card(arg0.getActionCommand());
						this.getFlopCard1Button().setCard(newCard);
					}
					else
					{
						if (this.getFlopCard2Button().getCard() == null)
						{
							Card newCard = new Card(arg0.getActionCommand());
							this.getFlopCard2Button().setCard(newCard);
						}
						else
						{
							if (this.getFlopCard3Button().getCard() == null)
							{
								Card newCard = new Card(arg0.getActionCommand());
								this.getFlopCard3Button().setCard(newCard);
							}
							else
							{
								if (this.getTurnCardButton().getCard() == null)
								{
									Card newCard = new Card(arg0
											.getActionCommand());
									this.getTurnCardButton().setCard(newCard);
								}
								else
								{
									if (this.getRiverCardButton().getCard() == null)
									{
										Card newCard = new Card(arg0
												.getActionCommand());
										this.getRiverCardButton().setCard(
												newCard);
									}
								}
							}
						}
					}
				}
			}
		}

		// If the user wants to run the simulation, then lets run it:
		if (arg0.getSource() == this.runSimulationButton)
		{

			// Get the Player Count for the emulation:
			Integer playerCountInteger = (Integer) playerCountField
					.getSelectedItem();
			int playerCount = playerCountInteger.intValue();

			if (playerCount < 2)
			{
				playerCount = 2;
			}

			HoldEmSimulationEngine engine = new HoldEmSimulationEngine();

			if ((this.getHoleCard1Button().getCard() == null)
					|| (this.getHoleCard2Button().getCard() == null))
			{
				this.getMessageField().setText("Result: No Cards to Test.");

			}
			else
			{
				// Run Simulation on the cards selected:
				engine.simulateHand(this.getHoleCard1Button().getCard(), this
						.getHoleCard2Button().getCard(), this
						.getFlopCard1Button().getCard(), this
						.getFlopCard2Button().getCard(), this
						.getFlopCard3Button().getCard(), this
						.getTurnCardButton().getCard(), this
						.getRiverCardButton().getCard(), playerCount);

				// Show the results of the current simulation:
				this.getResultsPanel().setResults(engine.getResults());

				// Show the new pot odds based on the current situation:
				this.getPotOddsPanel().updateOdds(engine.getResults());

			}

			// ----------------------------------------------------------------
			// If this is the trial version, occasionally open up
			// the Nag Screen:
			// ----------------------------------------------------------------
			if (HoldEmAnalyzerConstants.APPLICATION_TRIAL == true)
			{
				Random random = new Random();

				if (random.nextInt(5) <= 0)
				{
					JNagScreen nagScreen = new JNagScreen(this, true);
					nagScreen.setVisible(true);
				}
			}
		}

		// If the user wants to clear the board, do so:
		if (arg0.getSource() == this.clearResultButton)
		{
			// Re-show all of the buttons on the card selector:
			this.getCardSelectionPanel().setAllVisible();

			this.getHoleCard1Button().setCard(null);
			this.getHoleCard2Button().setCard(null);
			this.getFlopCard1Button().setCard(null);
			this.getFlopCard2Button().setCard(null);
			this.getFlopCard3Button().setCard(null);
			this.getTurnCardButton().setCard(null);
			this.getRiverCardButton().setCard(null);
			// this.getMessageField().setText("");

			// Clear the Results object as well:
			this.getResultsPanel().setResults(new HoldEmSimulationResults());

			this.getPotOddsPanel().potOddsField.setText("");

		}

		// If the user is quitting then, quit:
		if (arg0.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}

		// If the user clicked the "About the Application" Menu Item:
		if (arg0.getSource() == this.aboutMenuItem)
		{
			JSplashScreen aboutWindow = new JSplashScreen();
			aboutWindow.setVisible(true);
		}

		// If the user clicked the "Register Now" Menu Item:
		if (arg0.getSource() == this.registerMenuItem)
		{
			JNagScreen nagWindow = new JNagScreen(this, true);
			nagWindow.setVisible(true);
		}
	}

	public JPanel getMessagePanel()
	{
		return messagePanel;
	}

	public void setMessagePanel(JPanel messagePanel)
	{
		this.messagePanel = messagePanel;
	}

	public JPotOddsPanel getPotOddsPanel()
	{
		return potOddsPanel;
	}

	public void setPotOddsPanel(JPotOddsPanel potOddsPanel)
	{
		this.potOddsPanel = potOddsPanel;
	}

}
