package com.brianteeter.poker.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.brianteeter.poker.model.Card;
import com.brianteeter.poker.utils.ApplicationSecurityComponent;
import com.brianteeter.poker.utils.BrowserControl;
import com.brianteeter.poker.utils.HoldEmAnalyzerConstants;

/**
 * This window is displayed for a few seconds when the application opens.
 * 
 * @author Brian Teeter
 * 
 */
public class JSplashScreen extends JFrame implements ActionListener
{
	Font headerFont = new Font("Verdana", Font.BOLD, 20);

	Font sloganFont = new Font("Verdana", Font.ITALIC, 12);

	Font largeBoldFont = new Font("Verdana", Font.BOLD, 16);

	Font defaultBoldFont = new Font("Verdana", Font.BOLD, 12);

	Font tinyItalicsFont = new Font("Verdana", Font.ITALIC, 10);

	Font defaultFont = new Font("Verdana", Font.PLAIN, 12);

	public JLabel headerText = null;

	public JLabel sloganText = null;

	public JLabel registeredOwnerText = null;

	public JLabel trialExpirationText = null;

	public JLabel copyrightText = null;

	public JLabel buildText = null;

	public JLabel releaseText = null;

	public JLabel websiteText = null;

	public JLabel jFreeChartAttributionText = null;

	public JCardButton button1 = null;

	public JCardButton button2 = null;

	public JCardButton button3 = null;

	public JCardButton button4 = null;

	public JCardButton button5 = null;

	public JButton checkUpdatesButton = null;

	// public JLabel headerText = null;

	/**
	 * Default Constructor
	 */
	public JSplashScreen()
	{
		// =========================================================
		// Window sizing and initialization:
		// =========================================================
		this.setSize(420, 300);
		this.setLayout(null);
		this.setIconImage(new ImageIcon("icon.gif").getImage());

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
		headerText = new JLabel(HoldEmAnalyzerConstants.APPLICATION_NAME);
		headerText.setFont(headerFont);
		headerText.setSize(400, 30);
		headerText.setLocation(10, 10);
		this.add(headerText);

		// =========================================================
		// Create the Card Buttons and add them to the page:
		// =========================================================
		button1 = new JCardButton(new Card("As"));
		button1.setSize(17, 34);
		button1.setLocation(300, 10);
		this.add(button1);

		button2 = new JCardButton(new Card("Ks"));
		button2.setSize(17, 34);
		button2.setLocation(322, 10);
		this.add(button2);

		button3 = new JCardButton(new Card("Qs"));
		button3.setSize(17, 34);
		button3.setLocation(344, 10);
		this.add(button3);

		button4 = new JCardButton(new Card("Js"));
		button4.setSize(17, 34);
		button4.setLocation(366, 10);
		this.add(button4);

		button5 = new JCardButton(new Card("Ts"));
		button5.setSize(17, 34);
		button5.setLocation(388, 10);
		this.add(button5);

		// =========================================================
		// Initialize the Slogan text:
		// =========================================================
		sloganText = new JLabel(
				"The Ultimate Tool for Hold Em Analysis, Simulation and Advice...");
		sloganText.setFont(sloganFont);
		sloganText.setSize(400, 20);
		sloganText.setLocation(10, 50);
		this.add(sloganText);

		// =========================================================
		// Initialize the Registered Owner text:
		// =========================================================
		registeredOwnerText = new JLabel("Registered To: "
				+ HoldEmAnalyzerConstants.REGISTERED_OWNER);

		registeredOwnerText.setFont(defaultBoldFont);
		registeredOwnerText.setSize(400, 20);
		registeredOwnerText.setLocation(10, 75);
		this.add(registeredOwnerText);

		// =========================================================
		// Initialize the Trial Expiration Text, if we're in the
		// trial version:
		// =========================================================
		if (HoldEmAnalyzerConstants.APPLICATION_TRIAL)
		{
			trialExpirationText = new JLabel("Trial Expires: "
					+ ApplicationSecurityComponent.getTrialExpirationDate());

			trialExpirationText.setFont(defaultBoldFont);
			trialExpirationText.setSize(400, 20);
			trialExpirationText.setLocation(10, 90);
			this.add(trialExpirationText);
		}

		// =========================================================
		// Initialize the Web URL text
		// =========================================================
		websiteText = new JLabel("http://www.BrianTeeter.com/");
		websiteText.setFont(largeBoldFont);
		websiteText.setSize(400, 20);
		websiteText.setLocation(10, 145);
		this.add(websiteText);

		// =========================================================
		// Initialize the Build text
		// =========================================================
		buildText = new JLabel("Version: "
				+ HoldEmAnalyzerConstants.APPLICATION_VERSION + " -- "
				+ HoldEmAnalyzerConstants.APPLICATION_BUILD_DATE);

		buildText.setFont(defaultFont);
		buildText.setSize(400, 20);
		buildText.setLocation(10, 165);
		this.add(buildText);

		// =========================================================
		// Initialize the Copyright text
		// =========================================================
		copyrightText = new JLabel(
				"Copyright (c) 2006-2024, Brian Teeter <brian@brianteeter.com>");

		copyrightText.setFont(defaultFont);
		copyrightText.setSize(400, 20);
		copyrightText.setLocation(10, 180);
		this.add(copyrightText);
		
		// =========================================================
		// Initialize the Web URL text
		// =========================================================
		checkUpdatesButton = new JButton("Check for Updates");
		checkUpdatesButton.setSize(200, 20);
		checkUpdatesButton.setLocation(100, 210);
		checkUpdatesButton.addActionListener(this);
		this.add(checkUpdatesButton);

		// =========================================================
		// Initialize the Attribution Texts:
		// =========================================================
		jFreeChartAttributionText = new JLabel(
				"Uses JFreeChart 1.0.2 available at http://jfree.org/jfreechart/");

		jFreeChartAttributionText.setFont(tinyItalicsFont);
		jFreeChartAttributionText.setSize(400, 20);
		jFreeChartAttributionText.setLocation(10, 245);
		this.add(jFreeChartAttributionText);

		

	}

	/**
	 * Handles actions on the screen, for registered opponents.
	 */
	public void actionPerformed(ActionEvent e)
	{
		// If the user clicked the register button, open a browser and
		// take them to the registration page:
		if (e.getSource() == checkUpdatesButton)
		{
			BrowserControl
					.displayURL(HoldEmAnalyzerConstants.WEB_UPDATES_URL);
		}
	}
}
