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

import javax.swing.border.AbstractBorder;
import java.awt.*;

/**
 * This class is used for the JCardButton class to create a rounded border for the card.
 *
 * @author Brian Teeter
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
