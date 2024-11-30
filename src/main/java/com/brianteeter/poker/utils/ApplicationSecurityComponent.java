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

import com.brianteeter.poker.model.HoldEmAnalyzerApplicationSettings;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;

/**
 * This object is used to manage the implications of the trial and/or other
 * limitations/security needed in the application. This class is typically used
 * in a static way.
 *
 * @author Brian Teeter
 */
public class ApplicationSecurityComponent
{

    /**
     * Gets the start time of the trial in msec and returns it as a long.
     *
     * @return
     */
    public static long getTrialStartTimeMsec()
    {
        HoldEmAnalyzerApplicationSettings settings = HoldEmAnalyzerApplicationSettings
                .getApplicationSettings();

        settings.loadSettings();

        String trialStartMilliSecond = settings
                .getSetting(HoldEmAnalyzerApplicationSettings.TRIAL_START_MSEC);

        long trialStartMsec = 0;

        // ======================================================================
        // If there is no trial time in the settings, return 0, other wise
        // return the trial time:
        // ======================================================================
        if ((trialStartMilliSecond != null)
                && (trialStartMilliSecond.length() > 1))
        {
            trialStartMsec = Long.parseLong(trialStartMilliSecond);
        }

        return trialStartMsec;
    }

    /**
     * Gets the start time of the trial in msec and returns it as a long.
     *
     * @return
     */
    public static long getTrialEndTimeMsec()
    {

        long trialStartMsec = getTrialStartTimeMsec();
        long trialEndMsec = 0;

        // ==========================================================================
        // If there is no setting for the start date, we have a problem. Return
        // 0 if the start is not present, or the end msec if it is:
        // ==========================================================================
        trialEndMsec = trialStartMsec
                + HoldEmAnalyzerConstants.APPLICATION_TRIAL_MSEC_LENGTH;

        return trialEndMsec;
    }

    /**
     * This method is executed the first time the user starts the trial. It
     * saves the start date, and puts some security numbers into the settings
     * file to prevent tampering.
     *
     * @return
     */
    public static void firstExecutionSetupTrial()
    {
        System.out.println("Security: First Execution of Trial Application...");

        HoldEmAnalyzerApplicationSettings settings = HoldEmAnalyzerApplicationSettings
                .getApplicationSettings();

        settings.setSetting(HoldEmAnalyzerApplicationSettings.TRIAL_START_MSEC,
                "" + System.currentTimeMillis());

        settings.saveSettings();
    }

    /**
     * If this is the trial version, get the string date
     *
     * @return
     */
    public static String getTrialExpirationDate()
    {
        String result = "";

        // Get the trial expiration date:
        long trialStop = getTrialEndTimeMsec();

        // Format it, and return it:
        Date expireDate = new Date(trialStop);
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.LONG);

        result = formatter.format(expireDate);

        return result;

    }

    /**
     * Get the date that the JAR file changed to see if it jives with the trial
     * expiration date.
     *
     * @return
     */
    public static Date getJarChangedDate()
    {
        Date changedDate = null;

        File jarFile = new File("HoldEmAnalyzer.jar");

        // ======================================================================
        // If the JAR file exists, we're running a deployed version, so check
        // the file changed date:
        // ======================================================================
        if (jarFile.exists())
        {
            changedDate = new Date(jarFile.lastModified());
        }
        return changedDate;

    }
}
