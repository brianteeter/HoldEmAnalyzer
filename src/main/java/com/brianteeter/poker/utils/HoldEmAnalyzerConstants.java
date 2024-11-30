package com.brianteeter.poker.utils;

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

import java.awt.*;

/**
 * This object contains constants used throughout the application, that we WANT
 * to have compiled into the code. Anything preference based is handled in the
 * HoldEmAnalyzerApplicationSettings object.
 *
 * @author Brian Teeter
 */
public class HoldEmAnalyzerConstants
{
    public static final Font HEADER_FONT = new Font("Verdana", Font.BOLD, 20);

    public static final Font SLOGAN_FONT = new Font("Verdana", Font.ITALIC, 12);

    public static final Font DEFAULT_BOLD_FONT = new Font("Verdana", Font.BOLD, 12);

    public static final Font DEFAULT_FONT = new Font("Verdana", Font.PLAIN, 12);


    // Application Trial Settings:
    public static final boolean APPLICATION_TRIAL = false;

    public static final long APPLICATION_TRIAL_MSEC_LENGTH = 1296000000L; // 15 Days

    public static final long APPLICATION_TRIAL_GRACE_PERIOD_MSEC_LENGTH = 43200000L; // 12 Hrs


    // Application Settings:
    public static final String APPLICATION_NAME = "Hold Em Analyzer";

    public static final String APPLICATION_VERSION = "v2.1.1";

    public static final String APPLICATION_BUILD_DATE = "November 30, 2024";

    // Registered Owner Settings:
    public static final String REGISTERED_OWNER = "Brian Teeter";

    // Web URLs:
    public static final String WEB_REGISTRATION_URL = "http://www.brianteeter.com";
    public static final String WEB_UPDATES_URL = "http://www.brianteeter.com";


}
