package com.brianteeter.poker.gui;

/*-
 * #%L
 * HoldEmAnalyzer
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2004 - 2024 Brian Teeter
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.brianteeter.poker.utils.BrowserControl;
import com.brianteeter.poker.utils.HoldEmAnalyzerConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This window is displayed to Trial users after the registration has expired.
 *
 * @author Brian Teeter
 */
public class JTrialExpiredScreen extends JDialog implements ActionListener
{

    Font headerFont = HoldEmAnalyzerConstants.HEADER_FONT;

    Font defaultBoldFont = HoldEmAnalyzerConstants.DEFAULT_BOLD_FONT;

    Font defaultFont = HoldEmAnalyzerConstants.DEFAULT_FONT;

    JLabel headerText = null;

    JTextArea bodyText = null;

    JButton closeButton = null;

    JButton registerButton = null;

    /**
     * Constructor that creates and lays out the window.
     */
    public JTrialExpiredScreen(Frame owner, boolean modal)
    {

        // =========================================================
        // Window sizing and initialization:
        // =========================================================
        this.setSize(450, 300);
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
        this.setLocation(((screenSize.width - 450) / 2),
                ((screenSize.height - 300) / 2));

        this.setTitle(HoldEmAnalyzerConstants.APPLICATION_NAME + " "
                + HoldEmAnalyzerConstants.APPLICATION_VERSION);

        // =========================================================
        // Initialize the header text
        // =========================================================
        headerText = new JLabel("Trial Period Expired");
        headerText.setFont(headerFont);
        headerText.setSize(430, 30);
        headerText.setLocation(10, 10);
        this.add(headerText);

        // =========================================================
        // Create the request for registration text:
        // =========================================================
        bodyText = new JTextArea("Your Free Trial of the "
                + HoldEmAnalyzerConstants.APPLICATION_NAME
                + " has expired. \n\nTo continue taking advantage of all the "
                + HoldEmAnalyzerConstants.APPLICATION_NAME
                + " has to offer, please purchase the full version using"
                + " the button below to visit our web site: \n\n"
                + "http://www.BrianTeeter.com/ \n\nThank you for your support!");

        bodyText.setWrapStyleWord(true);
        bodyText.setLineWrap(true);
        bodyText.setFont(this.defaultFont);
        bodyText.setSize(430, 150);
        bodyText.setLocation(10, 50);
        this.add(bodyText);

        closeButton = new JButton("Close Window");
        closeButton.setSize(140, 20);
        closeButton.setLocation(255, 220);
        closeButton.addActionListener(this);
        this.add(closeButton);

        registerButton = new JButton("Purchase Full Version");
        registerButton.setSize(200, 20);
        registerButton.setLocation(25, 220);
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
