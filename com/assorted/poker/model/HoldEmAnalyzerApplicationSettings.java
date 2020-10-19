package com.assorted.poker.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Singleton object that contains the application settings for the
 * HoldEmAnalyzer.
 * 
 * @author Brian Teeter
 * 
 */
public class HoldEmAnalyzerApplicationSettings
{
	// Singleton Object Reference:
	private static HoldEmAnalyzerApplicationSettings ref;

	// Object to store application preferences:
	private Properties applicationSettings = new Properties();

	// File name for property storage:
	public final static String PROPERTY_STORAGE_LOCATION = "\\HoldEmAnalyzer.properties";

	// File name for property storage:
	public final static String TRIAL_START_MSEC = "TS-MS";

	// Static String's used to store/get application preferences:
	public final static String SIMULATION_DEPTH = "SIMULATION_DEPTH";

	/**
	 * Default Constructor, never called by other objects.
	 */
	private HoldEmAnalyzerApplicationSettings()
	{
		// Load the stored settings:
		loadSettings();
	}

	/**
	 * This method gets a reference to this object:
	 * 
	 * @return
	 */
	public static HoldEmAnalyzerApplicationSettings getApplicationSettings()
	{
		if (ref == null)
		{
			// it's ok, we can call this constructor
			ref = new HoldEmAnalyzerApplicationSettings();
		}

		return ref;
	}

	/**
	 * Implemented to ensure that we maintain Singleton-ness.
	 */
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
		// that'll teach 'em
	}

	/**
	 * This method is used to return an object that contains the setting for the
	 * requested setting.
	 * 
	 * @param settingName
	 * @return
	 */
	public String getSetting(String settingName)
	{
		String result = "";

		result = applicationSettings.getProperty(settingName);

		return result;
	}

	/**
	 * This method is used to store an object that contains the setting for the
	 * requested setting.
	 * 
	 * @param settingName
	 * @return
	 */
	public void setSetting(String settingName, String actualSetting)
	{
		applicationSettings.setProperty(settingName, actualSetting);
	}

	/**
	 * This method is used to save the application settings.
	 * 
	 * @param settingName
	 * @return
	 */
	public void saveSettings()
	{

		FileOutputStream output;
		try
		{
			output = new FileOutputStream(PROPERTY_STORAGE_LOCATION);
			applicationSettings
					.store(output, (new java.util.Date()).toString());
			output.flush();
			output.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to save the application settings.
	 * 
	 * @param settingName
	 * @return
	 */
	public void loadSettings()
	{
		try
		{
			FileInputStream fin = new FileInputStream(PROPERTY_STORAGE_LOCATION);
			applicationSettings.load(fin);
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}
