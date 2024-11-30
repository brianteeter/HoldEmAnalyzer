package com.brianteeter.poker.gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;

/**
 * This class is used for the JCardButton class to create a rounded border for the card.
 * 
 * @author Brian Teeter
 *
 */
class JRoundedButtonBorder extends AbstractBorder
{
	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height)
	{
		// g.setColor(c.getForeground());
		g.drawRoundRect(x, y, width, height, 4, 4);

	}

	public Insets getBorderInsets()
	{
		return new Insets(0, 0, 0, 0);
	}

}
