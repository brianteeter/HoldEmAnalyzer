package com.brianteeter.poker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.brianteeter.poker.model.HoldEmAnalyzerApplicationSettings;

/**
 * This panel is used by the user to specify preferences in the application.
 * 
 * @author Brian Teeter
 * 
 */
public class JPreferencesPanel extends JPanel implements ActionListener,
		ChangeListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// This object contains the application settings:
	HoldEmAnalyzerApplicationSettings applicationSettingsObject = null;

	public JLabel simulationPrecisionLabel = null;

	public JSlider simulationPrecisionSlider = null;

	public JTextField simulationPrecisionValue = null;

	public JButton applySettingsButton = null;

	/**
	 * Default Constructor that places the controls on the panel.
	 * 
	 */
	public JPreferencesPanel()
	{
		// =======================================================
		// Get the application settings object reference:
		// =======================================================
		applicationSettingsObject = HoldEmAnalyzerApplicationSettings
				.getApplicationSettings();

		// =======================================================
		// Configure the overall layout/size of the panel:
		// =======================================================
		this.setLayout(null);
		this.setSize(800, 400);

		// =======================================================
		// Add the Simulation Precision Sliders
		// =======================================================
		simulationPrecisionLabel = new JLabel(
				"Simulation Think Time (seconds):");
		simulationPrecisionLabel.setSize(250, 20);
		simulationPrecisionLabel.setLocation(15, 20);
		this.add(simulationPrecisionLabel);

		// =======================================================
		// If this is the Trial Edition, only allow Simulation
		// Depth of 1-2 seconds:
		// =======================================================
		simulationPrecisionSlider = new JSlider(1, 100);
		simulationPrecisionSlider.setMajorTickSpacing(10);
		
		simulationPrecisionSlider.setSize(350, 60);
		simulationPrecisionSlider.setLocation(10, 50);
		simulationPrecisionSlider.setPaintLabels(true);
		simulationPrecisionSlider.setPaintTicks(true);
		simulationPrecisionSlider.addChangeListener(this);

		this.add(simulationPrecisionSlider);

		simulationPrecisionValue = new JTextField("");
		simulationPrecisionValue.setSize(50, 20);
		simulationPrecisionValue.setLocation(370, 70);
		this.add(simulationPrecisionValue);

		// Load the Simulation Depth Preference and add it into the slider:
		String simDepth = applicationSettingsObject
				.getSetting(HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH);

		if (simDepth != null)
		{
			simulationPrecisionSlider.setValue(Integer.parseInt(simDepth));
			simulationPrecisionValue.setText("" + Integer.parseInt(simDepth));
		}
		
		// Add the "Apply Settings" Button:
		applySettingsButton = new JButton("Apply Settings");
		applySettingsButton.setSize(120, 20);
		applySettingsButton.setLocation(10, 350);
		applySettingsButton.addActionListener(this);
		this.add(applySettingsButton);

	}

	/**
	 * This method will handle when the user clicks the Apply Settings button.
	 */
	public void actionPerformed(ActionEvent e)
	{
		// -------------------------------------------------------------
		// If the user clicked Apply Settings, do so, and save them:
		// -------------------------------------------------------------
		if (e.getSource() == applySettingsButton)
		{
			applicationSettingsObject.setSetting(
					HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH, ""
							+ simulationPrecisionSlider.getValue());

			applicationSettingsObject.saveSettings();

		}
	}

	/**
	 * Handle any change events that occur for components on the panel.
	 * 
	 * @param e
	 */
	public void stateChanged(ChangeEvent e)
	{

		// -------------------------------------------------------------
		// If the changed the simulation precision slider, put the
		// value in the textbox next to it
		// -------------------------------------------------------------
		if ((e.getSource() == simulationPrecisionSlider)
				&& (simulationPrecisionSlider != null)
				&& (simulationPrecisionValue != null))
		{
			simulationPrecisionValue.setText(""
					+ simulationPrecisionSlider.getValue());
		}

	}

}
