package com.assorted.poker.engine;

import java.util.ArrayList;
import java.util.Collections;

import com.assorted.poker.model.Card;
import com.assorted.poker.model.HoldEmAnalyzerApplicationSettings;
import com.assorted.poker.model.HoldEmDealer;
import com.assorted.poker.model.HoldEmHand;
import com.assorted.poker.model.HoldEmPlayer;
import com.assorted.poker.model.StandardDeck;
import com.assorted.poker.model.Suit;
import com.assorted.poker.results.HoldEmSimulationResults;

/**
 * This class is a simulator that determines the outcomes for a certain set of
 * hole cards in a Hold Em game, at different stages of the game.
 * 
 * @author Brian Teeter
 * 
 */
public class HoldEmSimulationEngine
{

	// Get the Application Settings object:
	HoldEmAnalyzerApplicationSettings applicationSetings = HoldEmAnalyzerApplicationSettings
			.getApplicationSettings();

	HoldEmSimulationResults results = null;

	/**
	 * This function calculates and returns the odds of win/lose with the
	 * specified hole cards.
	 */
	public void simulateHand(Card holeCard1, Card holeCard2, Card flopCard1,
			Card flopCard2, Card flopCard3, Card turnCard, Card riverCard,
			int playerCount)
	{

		// ====================================================================
		// Make sure we have the information we need to run the simluation:
		// ====================================================================
		if ((holeCard1 == null) || (holeCard2 == null) || (playerCount <= 1)
				|| (playerCount > 10))
		{
			System.out
					.println("ERROR: Missing one or more of the input cards for the simulation.");
			return;
		}

		results = new HoldEmSimulationResults();

		// ====================================================================
		// Use the user's specified simulation depth time:
		// ====================================================================
		String simulationDepth = applicationSetings
				.getSetting(HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH);

		long iterations = 2000;

		// If we have a simulationDepth specified, use it, otherwise don't.
		try
		{
			if (simulationDepth != null)
			{
				iterations = Integer.parseInt(simulationDepth) * 1000;
			}
		}
		catch (Exception e)
		{
			iterations = 2000;
		}

		iterations += System.currentTimeMillis();

		// Create the hand we are testing:
		HoldEmHand testHand = null;

		// Create the hand object references for determining who won:
		HoldEmHand winner = null;
		HoldEmHand secondPlace = null;

		// ====================================================================
		// Create he deck we will use:
		// ====================================================================
		StandardDeck deck = new StandardDeck();
		boolean clonedHand = false;

		// ====================================================================
		// Iterate through this test the number of times specified:
		// ====================================================================
		while (iterations >= System.currentTimeMillis())
		{
			// Create the hand we are testing:
			testHand = new HoldEmHand(holeCard1, holeCard2);

			// ====================================================================
			// Create deck and remove the cards we are testing:
			// ====================================================================
			deck.freshDeck();
			deck.removeCard(holeCard1);
			deck.removeCard(holeCard2);

			// ====================================================================
			// If a flop has occured, put it into the cards for the players:
			// ====================================================================
			if ((flopCard1 != null) && (flopCard2 != null)
					&& (flopCard3 != null))
			{
				testHand.setFlop1(flopCard1);
				testHand.setFlop2(flopCard2);
				testHand.setFlop3(flopCard3);

				deck.removeCard(flopCard1);
				deck.removeCard(flopCard2);
				deck.removeCard(flopCard3);
			}

			// ====================================================================
			// If a turn has occured, put it into the cards for the players:
			// ====================================================================
			if ((turnCard != null))
			{
				testHand.setTurn(turnCard);
				deck.removeCard(turnCard);
			}

			// ====================================================================
			// If a river has occured, put it into the cards for the players:
			// ====================================================================
			if ((riverCard != null))
			{
				testHand.setRiver(riverCard);
				deck.removeCard(riverCard);
			}

			// Shuffle the remaining cards:
			deck.shuffle();

			// ====================================================================
			// Clone a copy of the hand and place it into the results. This is
			// so we know what the hand is for results gathering:
			// ====================================================================
			if (clonedHand == false)
			{
				results.setTheHand((HoldEmHand) testHand.clone());
				clonedHand = true;
			}

			// ====================================================================
			// Add the remaining hands into the hand array object:
			// ====================================================================
			ArrayList handsInPlay = new ArrayList();
			HoldEmHand nextHand = null;

			// Add our test hand to the hands in play:
			handsInPlay.add(testHand);

			for (int j = 0; (j < playerCount - 1); j++)
			{
				nextHand = new HoldEmHand(deck.pullCard(), deck.pullCard());

				if ((flopCard1 != null) && (flopCard2 != null)
						&& (flopCard3 != null))
				{
					nextHand.setFlop1(flopCard1);
					nextHand.setFlop2(flopCard2);
					nextHand.setFlop3(flopCard3);
				}
				if ((turnCard != null))
				{
					nextHand.setTurn(turnCard);
				}
				if ((riverCard != null))
				{
					testHand.setRiver(riverCard);
				}

				handsInPlay.add(nextHand);
			}

			// ====================================================================
			// Now deal the rest of the hand, and rank the hands a the end:
			// ====================================================================
			if ((flopCard1 == null) || (flopCard2 == null)
					|| (flopCard3 == null))
			{
				Card flop1 = deck.pullCard();
				Card flop2 = deck.pullCard();
				Card flop3 = deck.pullCard();

				// Put the flop in each hand:
				for (int j = 0; j < handsInPlay.size(); j++)
				{
					nextHand = (HoldEmHand) handsInPlay.get(j);
					nextHand.setFlop1(flop1);
					nextHand.setFlop2(flop2);
					nextHand.setFlop3(flop3);
				}
			}
			if ((turnCard == null))
			{
				Card turn = deck.pullCard();

				// Put the flop in each hand:
				for (int j = 0; j < handsInPlay.size(); j++)
				{
					nextHand = (HoldEmHand) handsInPlay.get(j);
					nextHand.setTurn(turn);
				}
			}
			if ((riverCard == null))
			{
				Card river = deck.pullCard();

				// Put the flop in each hand:
				for (int j = 0; j < handsInPlay.size(); j++)
				{
					nextHand = (HoldEmHand) handsInPlay.get(j);
					nextHand.setRiver(river);
				}
			}

			// Get all of the hands and determine the winning hand:
			Collections.sort(handsInPlay);

			// -------------------------------------------------------
			// Did our test player win?:
			// -------------------------------------------------------
			winner = (HoldEmHand) handsInPlay.get(handsInPlay.size() - 1);
			secondPlace = (HoldEmHand) handsInPlay.get(handsInPlay.size() - 2);

			if (winner == testHand)
			{
				// -------------------------------------------------------
				// Determine if this hand won outright or if it split:
				// -------------------------------------------------------
				if (winner.getMadeHand().equals(secondPlace.getMadeHand()))
				{
					results.insertSplitResult(testHand);
				}
				else
				{
					// -------------------------------------------------------
					// Our test player won outright, so record that in the
					// results object:
					// -------------------------------------------------------
					results.insertWinResult(testHand);

				}
			}
			else
			{
				// -------------------------------------------------------
				// Our test player's hand lost. Record the results:
				// -------------------------------------------------------
				results.insertLoseResult(testHand);
			}
		}
	}

	/**
	 * This overloaded method, calls the other method with no board cards
	 * 
	 * @return Arraylist with results objects for the passed in hands in order
	 *         specified
	 */
	public ArrayList simulateHandsHeadsUp(HoldEmHand hand1, HoldEmHand hand2,
			HoldEmHand hand3, HoldEmHand hand4)
	{
		return this.simulateHandsHeadsUp(hand1, hand2, hand3, hand4, null,
				null, null, null, null);
	}

	/**
	 * This function calculates and returns the odds of win/lose for each of the
	 * passed in hands, in a pre-flop all in situation
	 * 
	 * @return Arraylist with results objects for the passed in hands in order
	 *         specified
	 */
	public ArrayList simulateHandsHeadsUp(HoldEmHand hand1, HoldEmHand hand2,
			HoldEmHand hand3, HoldEmHand hand4, Card flopCard1, Card flopCard2,
			Card flopCard3, Card turnCard, Card riverCard)
	{
		ArrayList resultObjects = new ArrayList();

		// ====================================================================
		// Make sure we have the information we need to run the simluation:
		// ====================================================================
		if ((hand2 == null) && (hand3 == null) && (hand4 == null))
		{
			System.out.println("ERROR: We need at least 2 hands to compare.");
			return null;
		}

		HoldEmDealer dealer = new HoldEmDealer();
		HoldEmSimulationResults resultsHand1 = new HoldEmSimulationResults();
		HoldEmSimulationResults resultsHand2 = new HoldEmSimulationResults();
		HoldEmSimulationResults resultsHand3 = new HoldEmSimulationResults();
		HoldEmSimulationResults resultsHand4 = new HoldEmSimulationResults();
		HoldEmPlayer testPlayer1 = new HoldEmPlayer();
		HoldEmPlayer testPlayer2 = new HoldEmPlayer();
		HoldEmPlayer testPlayer3 = new HoldEmPlayer();
		HoldEmPlayer testPlayer4 = new HoldEmPlayer();

		// ====================================================================
		// Use the user's specified simulation depth time:
		// ====================================================================
		String simulationDepth = applicationSetings
				.getSetting(HoldEmAnalyzerApplicationSettings.SIMULATION_DEPTH);

		long iterations = 2000;

		// If we have a simulationDepth specified, use it, otherwise don't.
		try
		{
			if (simulationDepth != null)
			{
				iterations = Integer.parseInt(simulationDepth) * 1000;
			}
		}
		catch (Exception e)
		{
			iterations = 2000;
		}

		iterations += System.currentTimeMillis();

		// ====================================================================
		// Iterate through this test the number of times specified, unless
		// we're on the river - if so, only 1 iteration is needed:
		// ====================================================================
		do
		{
			// ====================================================================
			// Create the players with the hands we are testing:
			// ====================================================================
			testPlayer1.setHand(hand1);

			testPlayer2.setHand(hand2);

			if (hand3 != null)
			{
				testPlayer3.setHand(hand3);
			}

			if (hand4 != null)
			{
				testPlayer4.setHand(hand4);
			}

			// ====================================================================
			// Create deck and remove the cards we are testing:
			// ====================================================================
			StandardDeck deck = new StandardDeck();
			deck.removeCard(hand1.getHole1());
			deck.removeCard(hand1.getHole2());

			deck.removeCard(hand2.getHole1());
			deck.removeCard(hand2.getHole2());

			if (hand3 != null)
			{
				deck.removeCard(hand3.getHole1());
				deck.removeCard(hand3.getHole2());
			}

			if (hand4 != null)
			{
				deck.removeCard(hand4.getHole1());
				deck.removeCard(hand4.getHole2());
			}

			// Shuffle the remaining cards:
			deck.shuffle();

			// Set the dealer's deck to be the one we just created:
			dealer.setDeck(deck);

			// Clear the dealer's player list:
			dealer.setPlayers(new ArrayList(10));

			// Deal the Hole Cards to the players we added:
			// Add the test player to the dealer:
			dealer.addPlayer(testPlayer1);
			dealer.addPlayer(testPlayer2);

			if (hand3 != null)
			{
				dealer.addPlayer(testPlayer3);
			}

			if (hand4 != null)
			{
				dealer.addPlayer(testPlayer4);
			}

			// ====================================================================
			// Now deal the flop, or set it if it was passed in:
			// ====================================================================
			if ((flopCard1 == null) || (flopCard2 == null)
					|| (flopCard3 == null))
			{
				dealer.dealFlop();
			}
			else
			{
				// The flop was passed in, set it in the dealer/players:
				ArrayList theFlop = new ArrayList(3);
				theFlop.add(flopCard1);
				theFlop.add(flopCard2);
				theFlop.add(flopCard3);

				dealer.setFlop(theFlop);
			}

			// ====================================================================
			// Now deal the turn, or set it if it was passed in:
			// ====================================================================
			if (turnCard == null)
			{
				dealer.dealTurn();
			}
			else
			{
				// The turn was passed in, set it in the dealer/players:
				dealer.setTurn(turnCard);
			}

			// ====================================================================
			// Now deal the river, or set it if it was passed in:
			// ====================================================================
			if (riverCard == null)
			{
				dealer.dealRiver();
			}
			else
			{
				// The river was passed in, set it in the dealer/players:
				dealer.setRiver(riverCard);
			}

			// Get all of the hands and determine the winning hand:
			ArrayList allHands = dealer.getAllHands();
			Collections.sort(allHands);

			// ====================================================================
			// If we have a split, skip the sections checking for a winning
			// hand:
			// ====================================================================
			boolean splitHand = false;

			// -------------------------------------------------------
			// Do we have a split w/all hands?
			// -------------------------------------------------------
			if ((hand3 != null)
					&& (hand4 != null)
					&& (allHands.get(allHands.size() - 1).equals(allHands
							.get(allHands.size() - 2)))
					&& (allHands.get(allHands.size() - 2).equals(allHands
							.get(allHands.size() - 3)))
					&& (allHands.get(allHands.size() - 3).equals(allHands
							.get(allHands.size() - 4))))
			{
				resultsHand1.insertSplitResult(testPlayer1.getHand());
				resultsHand2.insertSplitResult(testPlayer2.getHand());
				resultsHand3.insertSplitResult(testPlayer3.getHand());
				resultsHand4.insertSplitResult(testPlayer4.getHand());

				// Mark the hand as a split:
				splitHand = true;
			}
			else
			{
				// -------------------------------------------------------
				// Do we have a split w/3 hands?
				// -------------------------------------------------------
				if ((hand3 != null)
						&& (allHands.get(allHands.size() - 1).equals(allHands
								.get(allHands.size() - 2)))
						&& (allHands.get(allHands.size() - 2).equals(allHands
								.get(allHands.size() - 3))))
				{
					resultsHand1.insertSplitResult(testPlayer1.getHand());
					resultsHand2.insertSplitResult(testPlayer2.getHand());
					resultsHand3.insertSplitResult(testPlayer3.getHand());

					// Mark the hand as a split:
					splitHand = true;
				}
				else
				{
					// -------------------------------------------------------
					// Do we have a split w/2 hands?
					// -------------------------------------------------------
					if ((allHands.get(allHands.size() - 1).equals(allHands
							.get(allHands.size() - 2))))
					{
						resultsHand1.insertSplitResult(testPlayer1.getHand());
						resultsHand2.insertSplitResult(testPlayer2.getHand());

						// Mark the hand as a split:
						splitHand = true;
					}
				}
			}

			// -------------------------------------------------------
			// If a split didn't happen check for an outright winner:
			// -------------------------------------------------------
			if (splitHand != true)
			{

				// -------------------------------------------------------
				// Did Player 1's hand win?:
				// -------------------------------------------------------
				if (allHands.get(allHands.size() - 1).equals(
						testPlayer1.getHand()))
				{
					resultsHand1.insertWinResult(testPlayer1.getHand());
					resultsHand2.insertLoseResult(testPlayer2.getHand());

					if (hand3 != null)
					{
						resultsHand3.insertLoseResult(testPlayer3.getHand());

					}
					if (hand4 != null)
					{
						resultsHand4.insertLoseResult(testPlayer4.getHand());

					}
				}
				else
				{
					// -------------------------------------------------------
					// Did Player 2's hand win?:
					// -------------------------------------------------------
					if (allHands.get(allHands.size() - 1).equals(
							testPlayer2.getHand()))
					{
						resultsHand2.insertWinResult(testPlayer2.getHand());
						resultsHand1.insertLoseResult(testPlayer1.getHand());

						if (hand3 != null)
						{
							resultsHand3
									.insertLoseResult(testPlayer3.getHand());

						}
						if (hand4 != null)
						{
							resultsHand4
									.insertLoseResult(testPlayer4.getHand());

						}
					}
					else
					{
						// -------------------------------------------------------
						// Did Player 3's hand win?:
						// -------------------------------------------------------
						if ((hand3 != null)
								&& (allHands.get(allHands.size() - 1)
										.equals(testPlayer3.getHand())))
						{
							resultsHand3.insertWinResult(testPlayer3.getHand());

							resultsHand1
									.insertLoseResult(testPlayer1.getHand());
							resultsHand2
									.insertLoseResult(testPlayer2.getHand());

							if (hand4 != null)
							{
								resultsHand4.insertLoseResult(testPlayer4
										.getHand());

							}
						}
						else
						{
							if (hand4 != null)
							{
								// -------------------------------------------------------
								// Player 4 must have won then eh?:
								// -------------------------------------------------------
								resultsHand4.insertWinResult(testPlayer4
										.getHand());
								resultsHand1.insertLoseResult(testPlayer1
										.getHand());
								resultsHand2.insertLoseResult(testPlayer2
										.getHand());
								resultsHand3.insertLoseResult(testPlayer2
										.getHand());
							}
						}
					}
				}
			}
		}
		while ((iterations >= System.currentTimeMillis())
				&& (riverCard == null));

		// Assemble our return objects and return them:
		resultObjects.add(resultsHand1);
		resultObjects.add(resultsHand2);

		if (hand3 != null)
		{
			resultObjects.add(resultsHand3);
		}

		if (hand4 != null)
		{
			resultObjects.add(resultsHand4);
		}

		return resultObjects;
	}

	public HoldEmSimulationResults getResults()
	{
		return results;
	}

	public void setResults(HoldEmSimulationResults results)
	{
		this.results = results;
	}

	/**
	 * Test the engine class out.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Card card1 = new Card(Card.RANK_ACE, new Suit(Suit.SPADES));
		Card card2 = new Card(Card.RANK_ACE, new Suit(Suit.CLUBS));
		Card card3 = new Card(2, new Suit(Suit.HEARTS));
		Card card4 = new Card(5, new Suit(Suit.DIAMONDS));
		Card card5 = new Card(9, new Suit(Suit.CLUBS));

		HoldEmSimulationEngine engine = new HoldEmSimulationEngine();
		engine.simulateHand(card1, card2, null, null, null, null, null, 9);

		System.out.println("Result: " + engine.getResults());
		System.out.println("\n\n\n");

		engine.simulateHand(card1, card2, card3, card4, card5, null, null, 9);

		System.out.println("Result: " + engine.getResults());

	}
}
