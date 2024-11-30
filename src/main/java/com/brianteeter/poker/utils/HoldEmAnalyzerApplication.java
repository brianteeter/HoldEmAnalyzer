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

import com.brianteeter.poker.engine.HoldEmSimulationEngine;
import com.brianteeter.poker.gui.HoldEmAnalyzerFrame;
import com.brianteeter.poker.gui.JSplashScreen;
import com.brianteeter.poker.gui.JTrialExpiredScreen;
import com.brianteeter.poker.model.Card;
import com.brianteeter.poker.model.HoldEmAnalyzerApplicationSettings;
import com.brianteeter.poker.model.Suit;
import com.brianteeter.poker.results.HoldEmSimulationResults;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the main application class for the Hold Em Analyzer. It will be the
 * class executed to start the application. It will determine if we're running a
 * GUI session (probable) or if we are doing a console batch job.
 *
 * @author Brian Teeter
 */
public class HoldEmAnalyzerApplication
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ArrayList arguments = new ArrayList(Arrays.asList(args));
        boolean continueExecution = true;

        // =====================================================================
        // If this is the trial edition, check the application expiration date
        // to make sure we should start:
        // =====================================================================
        if (HoldEmAnalyzerConstants.APPLICATION_TRIAL)
        {
            if (ApplicationSecurityComponent.getTrialStartTimeMsec() <= 0)
            {
                ApplicationSecurityComponent.firstExecutionSetupTrial();
            }

            // =====================================================================
            // If we are running the trial, check to make sure that we have not
            // exceeded the trial period allowed:
            // =====================================================================
            long trialStop = ApplicationSecurityComponent.getTrialEndTimeMsec();

            // The trial end date has passed
            if (trialStop < System.currentTimeMillis())
            {
                JTrialExpiredScreen trialExpiredScreen = new JTrialExpiredScreen(
                        null, true);
                trialExpiredScreen.setVisible(true);

                // Pop a dialog indicating the trial has expired and quit:
                System.out.println("Trial Expired... " + trialStop + " :: "
                        + System.currentTimeMillis());

                continueExecution = false;
            }
        }

        // =====================================================================
        // If no arguments are passed in, assume a GUI session, so open and
        // display the GUI:
        // =====================================================================
        if ((continueExecution) && (arguments.size() == 0))
        {
            // =====================================================================
            // Show the splash window for 3 seconds and then display this
            // window:
            // =====================================================================
            JSplashScreen splashScreen = new JSplashScreen();
            splashScreen.setVisible(true);
            // splashScreen.setLocation();

            // =====================================================================
            // Pause for 7 seconds, close the splash screen and then show the
            // main window for the application:
            // =====================================================================
            try
            {
                Thread.sleep(4000);
            } catch (InterruptedException e)
            {
                System.out.println(e);
                e.printStackTrace();
            }

            // Close the splash screen
            splashScreen.setVisible(false);
            splashScreen = null;

            // Display the main window:
            HoldEmAnalyzerFrame frame = new HoldEmAnalyzerFrame();
            frame.setVisible(true);
        } else
        {
            // =====================================================================
            // Arguments were passed in, determine what it is we are
            // supposed to do, and do it.
            // =====================================================================
            HoldEmAnalyzerApplication app = new HoldEmAnalyzerApplication();
            app.processArguments(arguments);
        }
    }

    /**
     * Process the arguments that were passed in and do whatever is asked.
     * Allowed arguments are:
     */
    public void processArguments(ArrayList arguments)
    {
        boolean simulateAllStartingHands = false;
        boolean tabDelimitedOutput = false;
        boolean tabDelimitedOutputHeader = false;
        boolean simulateStartingHand = false;
        String holeCard1 = null;
        String holeCard2 = null;
        String boardCard1 = null;
        String boardCard2 = null;
        String boardCard3 = null;
        String boardCard4 = null;
        String boardCard5 = null;
        long iterations = 0;
        int playerCount = 0;

        // If there are no arguments, return, we cannot do anything.
        if ((arguments == null) || (arguments.size() <= 0))
        {
            this.printArguments();
            return;
        } else
        {
            // ---------------------------------------------------------
            // If we are handling a batch job, lets see parse out
            // the arguments we are working with:
            // ---------------------------------------------------------
            String nextArgument = null;

            while (arguments.size() > 0)
            {
                // --------------------------------------------------
                // Pop the next argument and see what it is:
                // --------------------------------------------------
                nextArgument = (String) arguments.get(0);

                if (nextArgument.equals("-bh"))
                {
                    simulateStartingHand = true;
                    arguments.remove(0);
                    continue;
                }

                // ------------------------------------------------------
                // If the next argument specifies plain text output
                // reflect that in the variables:
                // ------------------------------------------------------
                if (nextArgument.equals("-text"))
                {
                    tabDelimitedOutput = false;
                    arguments.remove(0);
                    continue;
                }

                // ------------------------------------------------------
                // If the next argument specifies tab delimited output
                // reflect that in the variables:
                // ------------------------------------------------------
                if (nextArgument.equals("-tabdelim"))
                {
                    tabDelimitedOutput = true;
                    arguments.remove(0);
                    continue;
                }

                // ------------------------------------------------------
                // If the next argument specifies tab delimited output
                // reflect that in the variables:
                // ------------------------------------------------------
                if (nextArgument.equals("-tabdelimheader"))
                {
                    tabDelimitedOutputHeader = true;
                    arguments.remove(0);
                    continue;
                }

                // ------------------------------------------------------
                // If the next argument specifies that we are running
                // all starting hands, not just one:
                // ------------------------------------------------------
                if (nextArgument.equals("-ash"))
                {
                    simulateAllStartingHands = true;
                    arguments.remove(0);
                    continue;
                }

                if (nextArgument.equals("-hc"))
                {
                    // Determine if there are 3 arguments to process, the
                    // -hc and the 2 cards:
                    if (arguments.size() >= 3)
                    {
                        // Remove the -hc argument:
                        arguments.remove(0);

                        // Get the hole cards, if they exist. If not,
                        // exit and print arguments:
                        holeCard1 = (String) arguments.get(0);
                        holeCard2 = (String) arguments.get(1);

                        // Remove the two hold card arguments:
                        arguments.remove(0);
                        arguments.remove(0);
                    } else
                    {
                        printArguments();
                        continue;
                    }

                    continue;
                }

                if (nextArgument.equals("-bc"))
                {
                    arguments.remove(0);

                    // Determine if there are 6 arguments to process, the
                    // -hc and the 2 cards:
                    if (arguments.size() >= 3)
                    {

                        // Get the flop board cards, if they exist. If not,
                        // exit and print arguments:
                        boardCard1 = (String) arguments.get(0);
                        boardCard2 = (String) arguments.get(1);
                        boardCard3 = (String) arguments.get(2);

                        arguments.remove(0);
                        arguments.remove(0);
                        arguments.remove(0);

                        // Get the turn and river board cards if they exist:
                        if (arguments.size() >= 1)
                        {
                            boardCard4 = (String) arguments.get(0);

                            // Make sure what we think is the 4th card is NOT
                            // another switch:
                            if (boardCard4.indexOf("-") >= 0)
                            {
                                boardCard4 = null;
                                continue;
                            } else
                            {
                                // boardCard4 is a card, so remove the argument:
                                arguments.remove(0);

                                boardCard5 = (String) arguments.get(0);

                                // Make sure what we think is the 5th card is
                                // NOT another switch:
                                if (boardCard5.indexOf("-") >= 0)
                                {
                                    boardCard5 = null;
                                    continue;
                                } else
                                {
                                    arguments.remove(0);
                                    continue;
                                }
                            }

                        } else
                        {
                            // If only the board exists through the turn get
                            // those:
                            if (arguments.size() >= 5)
                            {
                                boardCard5 = (String) arguments.get(4);
                                arguments.remove(0);
                                arguments.remove(0);
                                arguments.remove(0);
                                arguments.remove(0);
                                arguments.remove(0);
                            }
                        }

                    } else
                    {
                        printArguments();
                        return;
                    }

                    continue;
                }

                if (nextArgument.equals("-t"))
                {
                    // Determine if there are 2 arguments to process, the
                    // -n and the number of iterations:
                    if (arguments.size() >= 2)
                    {
                        // Remove the -n argument:
                        arguments.remove(0);

                        // Get the iterations:
                        iterations = Long.parseLong((String) arguments.get(0));
                        arguments.remove(0);
                    } else
                    {
                        printArguments();
                        return;
                    }

                    continue;
                }

                if (nextArgument.equals("-pc"))
                {
                    // Determine if there are 2 arguments to process, the
                    // -hc and the number of iterations:
                    if (arguments.size() >= 2)
                    {
                        // Remove the -n argument:
                        arguments.remove(0);

                        // Get the iterations:
                        playerCount = Integer.parseInt((String) arguments
                                .get(0));
                        arguments.remove(0);
                    } else
                    {
                        printArguments();
                        return;
                    }

                    continue;
                }

                // Default Action for Unknown Parameters:
                System.out.println("Unknown Argument: " + arguments);
            }

        }

        // Validate the parameters that were passed in:
        if ((playerCount < 2) || (playerCount > 10) || (iterations < 1)
                || (iterations > Integer.MAX_VALUE)
                || (!simulateStartingHand))
        {
            printArguments();
            return;
        }

        Card h1 = new Card(holeCard1);
        Card h2 = new Card(holeCard2);

        Card b1 = (boardCard1 != null) ? new Card(boardCard1) : null;
        Card b2 = (boardCard2 != null) ? new Card(boardCard2) : null;
        Card b3 = (boardCard3 != null) ? new Card(boardCard3) : null;
        Card b4 = (boardCard4 != null) ? new Card(boardCard4) : null;
        Card b5 = (boardCard5 != null) ? new Card(boardCard5) : null;

        // --------------------------------------------------------------
        // Run the test based on the user's selections:
        // --------------------------------------------------------------
        if (simulateAllStartingHands)
        {
            this.runAllStartingHandBatchSimulation(b1, b2, b3, b4, b5,
                    playerCount, iterations, tabDelimitedOutput,
                    tabDelimitedOutputHeader);
        } else
        {
            runBatchSimulationOneHand(h1, h2, b1, b2, b3, b4, b5, playerCount,
                    iterations, tabDelimitedOutput, tabDelimitedOutputHeader);
        }

    }

    /**
     * This method prints out to the command line the allowable arguments:
     */
    public void printArguments()
    {

        System.out.println("Usage: \n");
        System.out.println("java -jar HoldEmAnalyzer.jar <arguments>");
        System.out.println("\n");
        System.out.println("Arguments:");
        System.out
                .println("-bh           : Run a Batch Simulation on a specific hand and/or board");

        System.out.println("-hc <cards> : Specify hole cards (required)");

        System.out
                .println("-t <seconds>  : Specify number of seconds to run the test");

        System.out
                .println("-bc <cards>   : Specify board cards, must specify 3, 4 or 5");

        System.out
                .println("-pc <number>  : Specify number of players from 2 to 10");

        System.out
                .println("-text         : Print output in plain text (default)");

        System.out
                .println("-tabdelim         : Print output in tab delimited format, good for spreadsheeting");

        System.out
                .println("-tabdelimheader         : Prints the header row for a tab-delimited output");

        System.out.println("-ash         : Simulate for all starting hands");
    }

    /**
     * This method runs one test and outputs the output to STDOUT:
     */
    public void runBatchSimulationOneHand(Card hole1, Card hole2, Card board1,
                                          Card board2, Card board3, Card board4, Card board5,
                                          int playerCount, long runTimeSeconds, boolean tabDelimitedOutput,
                                          boolean tabDelimitedOutputHeader)
    {

        HoldEmAnalyzerApplicationSettings applicationSettingsObject = HoldEmAnalyzerApplicationSettings
                .getApplicationSettings();

        // --------------------------------------------------------------
        // Store the old iteration setting, so we can restore it:
        // --------------------------------------------------------------
        String oldIterationSetting = applicationSettingsObject
                .getSetting(HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH);

        // --------------------------------------------------------------
        // Save the length of time we want to run the test, so the
        // Simulation Engine runs for the proper length of time:
        // --------------------------------------------------------------
        applicationSettingsObject.setSetting(
                HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH, ""
                        + runTimeSeconds);

        applicationSettingsObject.saveSettings();

        // --------------------------------------------------------------
        // Now that we have our parameters, run the test specified:
        // --------------------------------------------------------------
        HoldEmSimulationEngine engine = new HoldEmSimulationEngine();
        engine.simulateHand(hole1, hole2, board1, board2, board3, board4,
                board5, playerCount);

        // --------------------------------------------------------------
        // Our test is complete, now print the output as specified:
        // --------------------------------------------------------------
        if (tabDelimitedOutput)
        {
            if (tabDelimitedOutputHeader)
            {
                System.out.println(engine.getResults().tabDelimHeaderString());
            }
            System.out.println(engine.getResults().toTabDelimString());
        } else
        {
            System.out.println(engine.getResults().toString());
        }

        // Restore the old iterations setting
        applicationSettingsObject.setSetting(
                HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH, oldIterationSetting);

        applicationSettingsObject.saveSettings();

    }

    /**
     * This method runs one test for every combination of starting hands, and
     * outputs the results to STDOUT:
     */
    public void runAllStartingHandBatchSimulation(Card board1, Card board2,
                                                  Card board3, Card board4, Card board5, int playerCount,
                                                  long runTimeSeconds, boolean tabDelimitedOutput,
                                                  boolean tabDelimitedOutputHeader)
    {

        HoldEmAnalyzerApplicationSettings applicationSettingsObject = HoldEmAnalyzerApplicationSettings
                .getApplicationSettings();

        // --------------------------------------------------------------
        // Store the old iteration setting, so we can restore it:
        // --------------------------------------------------------------
        String oldIterationSetting = applicationSettingsObject
                .getSetting(HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH);

        // --------------------------------------------------------------
        // Save the length of time we want to run the test, so the
        // Simulation Engine runs for the proper length of time:
        // --------------------------------------------------------------
        applicationSettingsObject.setSetting(
                HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH, ""
                        + runTimeSeconds);

        applicationSettingsObject.saveSettings();

        HoldEmSimulationEngine engine = new HoldEmSimulationEngine();

        // --------------------------------------------------------------
        // Print the tab delimited header, if we're doing that format:
        // --------------------------------------------------------------
        if (tabDelimitedOutput)
        {
            if (tabDelimitedOutputHeader)
            {
                System.out.println(new HoldEmSimulationResults()
                        .tabDelimHeaderString());
            }
        }

        Card hole1 = null;
        Card hole2 = null;

        // --------------------------------------------------------------
        // Step through each unique starting hand for the test. First
        // do the pocket pairs, suits are irrelivant so we always use
        // XdXs for the pairs:
        // --------------------------------------------------------------
        for (int i = 2; i <= Card.RANK_ACE; i++)
        {
            hole1 = new Card(i, new Suit(Suit.DIAMONDS));
            hole2 = new Card(i, new Suit(Suit.SPADES));

            engine.simulateHand(hole1, hole2, board1, board2, board3, board4,
                    board5, playerCount);

            if (tabDelimitedOutput)
            {
                System.out.println(hole1.toString() + hole2 + ":\t"
                        + engine.getResults().toTabDelimString());
            } else
            {
                System.out.println(hole1.toString() + hole2 + ":\n"
                        + engine.getResults().toString());
            }
        }

        // --------------------------------------------------------------
        // Step through the suited hands, since the suit isn't relevant
        // as long as its the same for both cards, we use spades:
        // --------------------------------------------------------------
        for (int i = Card.RANK_ACE; i >= 2; i--)
        {
            for (int j = i; j >= 2; j--)
            {
                // No hands with the same rank - that's a pocket pair, we
                // already did those:
                if (i != j)
                {
                    hole1 = new Card(i, new Suit(Suit.SPADES));
                    hole2 = new Card(j, new Suit(Suit.SPADES));

                    engine.simulateHand(hole1, hole2, board1, board2, board3,
                            board4, board5, playerCount);

                    if (tabDelimitedOutput)
                    {
                        System.out.println(hole1.toString() + hole2
                                + ":\t"
                                + engine.getResults().toTabDelimString());
                    } else
                    {
                        System.out.println(hole1.toString() + hole2
                                + ":\n" + engine.getResults().toString());
                    }
                }
            }
        }

        // --------------------------------------------------------------
        // Step through the unsuited hands:
        // --------------------------------------------------------------
        for (int i = Card.RANK_ACE; i >= 2; i--)
        {
            for (int j = i; j >= 2; j--)
            {
                // No hands with the same rank - that's a pocket pair, we
                // already did those:
                if (i != j)
                {
                    hole1 = new Card(i, new Suit(Suit.SPADES));
                    hole2 = new Card(j, new Suit(Suit.DIAMONDS));

                    engine.simulateHand(hole1, hole2, board1, board2, board3,
                            board4, board5, playerCount);

                    if (tabDelimitedOutput)
                    {
                        System.out.println(hole1.toString() + hole2
                                + ":\t"
                                + engine.getResults().toTabDelimString());
                    } else
                    {
                        System.out.println(hole1.toString() + hole2
                                + ":\n" + engine.getResults().toString());
                    }
                }
            }
        }

        // Restore the old iterations setting
        applicationSettingsObject.setSetting(
                HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH, oldIterationSetting);

        applicationSettingsObject.saveSettings();

    }
}
