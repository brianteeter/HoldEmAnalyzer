package com.brianteeter.poker.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.brianteeter.poker.utils.ApplicationSecurityComponent;
import com.brianteeter.poker.utils.BrowserControl;
import com.brianteeter.poker.utils.HoldEmAnalyzerConstants;

/**
 * This window is displayed to Trial users on an irregular basis, to encourage
 * that they register their software. The longer they've used it, the more often
 * it will appear.
 * 
 * @author Brian Teeter
 * 
 */
public class JNagScreen extends JDialog implements ActionListener
{

	Font headerFont = HoldEmAnalyzerConstants.HEADER_FONT;

	Font defaultBoldFont = HoldEmAnalyzerConstants.DEFAULT_BOLD_FONT;

	Font defaultFont = HoldEmAnalyzerConstants.DEFAULT_FONT;

	JLabel headerText = null;

	JLabel line1Text = null;

	JLabel line2Text = null;

	JLabel line3Text = null;

	JLabel line4Text = null;

	JButton closeButton = null;

	JButton registerButton = null;

	/**
	 * Constructor that creates and lays out the window.
	 * 
	 */
	public JNagScreen(Frame owner, boolean modal)
	{
		super(owner, modal);

		// =========================================================
		// Window sizing and initialization:
		// =========================================================
		this.setSize(420, 250);
		this.setLayout(null);

		// Close the application on the close of the window:
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// Prevent users from closing the window without clicking the
		// correct button:
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				// setLabel("Thwarted user attempt to close window.");
			}
		});

		// =========================================================
		// Get the System Toolkit to get the Screen Dimensions:
		// =========================================================
		Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		this.setLocation(((screenSize.width - 420) / 2),
				((screenSize.height - 250) / 2));

		this.setTitle(HoldEmAnalyzerConstants.APPLICATION_NAME + " "
				+ HoldEmAnalyzerConstants.APPLICATION_VERSION);

		// =========================================================
		// Initialize the header text
		// =========================================================
		headerText = new JLabel("Please Register Today!");
		headerText.setFont(headerFont);
		headerText.setSize(400, 30);
		headerText.setLocation(10, 10);
		this.add(headerText);

		// =========================================================
		// Create the request for registration text:
		// =========================================================
		line1Text = new JLabel("This is the free trial of the "
				+ HoldEmAnalyzerConstants.APPLICATION_NAME + ".  This trial");
		line1Text.setFont(this.defaultFont);
		line1Text.setSize(400, 30);
		line1Text.setLocation(10, 50);
		this.add(line1Text);

		// =========================================================
		// Create the request for registration text:
		// =========================================================
		String expireString = ApplicationSecurityComponent.getTrialExpirationDate();
		line2Text = new JLabel("expires on: " + expireString);
		line2Text.setFont(this.defaultFont);
		line2Text.setSize(400, 30);
		line2Text.setLocation(10, 65);
		this.add(line2Text);

		// =========================================================
		// Create line 3 text:
		// =========================================================
		line3Text = new JLabel("To continue using the "
				+ HoldEmAnalyzerConstants.APPLICATION_NAME
				+ " after the ");
		line3Text.setFont(this.defaultFont);
		line3Text.setSize(400, 30);
		line3Text.setLocation(10, 90);
		this.add(line3Text);

		// =========================================================
		// Create line 4 text:
		// =========================================================
		line4Text = new JLabel("trial, purchase the full version.");
		line4Text.setFont(this.defaultFont);
		line4Text.setSize(400, 30);
		line4Text.setLocation(10, 105);
		this.add(line4Text);

		closeButton = new JButton("Close Window");
		closeButton.setSize(140, 20);
		closeButton.setLocation(255, 150);
		closeButton.addActionListener(this);
		this.add(closeButton);

		registerButton = new JButton("Purchase Full Version");
		registerButton.setSize(200, 20);
		registerButton.setLocation(25, 150);
		registerButton.addActionListener(this);
		this.add(registerButton);

	}

	/**
	 * Handles actions on the screen, for registered opponents.
	 */
	public void actionPerformed(ActionEvent e)
	{
		// If the user clicked the close button then do so:
		if (e.getSource() == closeButton)
		{
			this.setVisible(false);
			this.dispose();
		}

		// If the user clicked the register button, open a browser and
		// take them to the registration page:
		if (e.getSource() == registerButton)
		{
			BrowserControl
					.displayURL(HoldEmAnalyzerConstants.WEB_REGISTRATION_URL);
		}
	}
}
