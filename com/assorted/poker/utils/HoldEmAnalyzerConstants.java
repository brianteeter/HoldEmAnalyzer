package com.assorted.poker.utils;

import java.awt.Font;

/**
 * This object contains constants used throughout the application, that we WANT
 * to have compiled into the code. Anything preference based is handled in the
 * HoldEmAnalyzerApplicationSettings object.
 * 
 * @author Brian Teeter
 * 
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
	public static final String APPLICATION_NAME = "Hold Em Assistant";

	public static final String APPLICATION_VERSION = "v2.1.0";

	public static final String APPLICATION_BUILD_DATE = "September 26, 2006";

	// Registered Owner Settings:
	public static final String REGISTERED_OWNER = "Brian Teeter";
	
	// Web URLs:
	public static final String WEB_REGISTRATION_URL = "http://www.HoldEmToolShed.com/site/staticpages/index.php?page=20060718072502210";
	public static final String WEB_UPDATES_URL = "http://holdemtoolshed.com/site/staticpages/index.php?page=20060714132115812";

	
	
}
