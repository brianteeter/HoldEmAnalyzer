package com.brianteeter.poker.model;

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

import java.util.ArrayList;

/**
 * This class represents a "Dealer" for a Hold Em Game.
 *
 * @author Brian Teeter
 */
public class HoldEmDealer
{
    StandardDeck deck = null;

    ArrayList players = null;

    ArrayList flop = null;

    Card turn = null;

    Card river = null;

    public ArrayList getFlop()
    {
        return flop;
    }

    /**
     * Whenever the flop is set, set the player's flop in their hand as well
     *
     * @param flop
     */
    public void setFlop(ArrayList flop)
    {
        this.flop = flop;

        // Set the flop in the player's hands, if we can:
        if ((this.players != null) && (flop != null) && (flop.size() == 3))
        {
            HoldEmPlayer player = null;

            for (int i = 0; players.size() > i; i++)
            {
                player = (HoldEmPlayer) players.get(i);
                player.getHand().setFlop1((Card) flop.get(0));
                player.getHand().setFlop2((Card) flop.get(1));
                player.getHand().setFlop3((Card) flop.get(2));

            }
        }
    }

    public Card getRiver()
    {
        return river;
    }

    public void setRiver(Card river)
    {
        this.river = river;

        // Set the river in the player's hands, if we can:
        if ((this.players != null) && (river != null))
        {
            HoldEmPlayer player = null;

            for (int i = 0; players.size() > i; i++)
            {
                player = (HoldEmPlayer) players.get(i);
                player.getHand().setRiver(river);
            }
        }
    }

    public Card getTurn()
    {
        return turn;
    }

    /**
     * Set the turn in the dealer, and the player's hands, if applicable:
     *
     * @param turn
     */
    public void setTurn(Card turn)
    {
        this.turn = turn;

        // Set the turn in the player's hands, if we can:
        if ((this.players != null) && (turn != null))
        {
            HoldEmPlayer player = null;

            for (int i = 0; players.size() > i; i++)
            {
                player = (HoldEmPlayer) players.get(i);
                player.getHand().setTurn(turn);
            }
        }
    }

    public StandardDeck getDeck()
    {
        return deck;
    }

    public void setDeck(StandardDeck deck)
    {
        this.deck = deck;
    }

    public ArrayList getPlayers()
    {
        return players;
    }

    public void setPlayers(ArrayList players)
    {
        this.players = players;
    }

    /**
     * This function adds a player into the Dealer's game:
     */
    public void addPlayer(HoldEmPlayer player)
    {
        if (player != null && players.size() <= 10)
        {
            getPlayers().add(player);
        } else
        {
            System.out.println("ERROR: Unable to add player: " + player);
        }
    }

    /**
     * This function removes a player from the Dealer's game:
     */
    public void removePlayer(HoldEmPlayer player)
    {
        if (player != null && players.size() > 1)
        {
            getPlayers().remove(player);
        } else
        {
            System.out.println("ERROR: Unable to remove player: " + player);
        }
    }

    /**
     * This function deals a hand to the players in the Dealer's players
     * ArrayList.:
     */
    public void dealNewHand()
    {
        if ((players == null) || (players.size() < 1))
        {
            System.out.println("ERROR: Unable to deal hand, no players.");
            return;
        }

        // Shuffle the new deck for this hand:
        // getDeck().freshDeck();
        getDeck().shuffle();

        // Create all the player's hand objects:
        ArrayList newHands = new ArrayList(players.size());
        for (int i = 0; i < players.size(); i++)
        {
            newHands.add(new HoldEmHand());
        }

        // Deal the 1st hole card to each player:
        Card nextCard = null;
        HoldEmHand currentHand = null;
        HoldEmPlayer currentPlayer = null;

        for (int i = 0; i < (players.size()); i++)
        {
            nextCard = getDeck().pullCard();
            currentHand = (HoldEmHand) newHands.get(i);
            currentHand.setHole1(nextCard);
        }

        // Deal the 2nd hole card to each player:
        for (int i = 0; i < (players.size()); i++)
        {
            nextCard = getDeck().pullCard();
            currentHand = (HoldEmHand) newHands.get(i);
            currentHand.setHole2(nextCard);
        }

        // Set the player's hands accordingly:
        for (int i = 0; i < (players.size()); i++)
        {
            currentPlayer = (HoldEmPlayer) players.get(i);
            currentPlayer.setHand((HoldEmHand) newHands.get(i));
        }

    }

    /**
     * This function deals the flop to the players in the Dealer's players
     * ArrayList:
     */
    public void dealFlop()
    {
        if ((players == null) || (players.size() < 1))
        {
            System.out.println("ERROR: Unable to deal hand, no players.");
            return;
        }

        // Deal the three flop cards:
        Card flop1 = getDeck().pullCard();
        Card flop2 = getDeck().pullCard();
        Card flop3 = getDeck().pullCard();

        HoldEmHand currentHand = null;
        HoldEmPlayer currentPlayer = null;

        for (int i = 0; i < (players.size()); i++)
        {
            currentPlayer = (HoldEmPlayer) players.get(i);
            currentHand = currentPlayer.getHand();
            currentHand.setFlop1(flop1);
            currentHand.setFlop2(flop2);
            currentHand.setFlop3(flop3);
        }

        // Rank all player hands at this stage:
        this.rankPlayerHands();

        // Set the member variable with the flop cards we just dealt:
        ArrayList flopList = new ArrayList();
        flopList.add(flop1);
        flopList.add(flop2);
        flopList.add(flop3);
        this.setFlop(flopList);

    }

    /**
     * This function deals the turn to the players in the Dealer's players
     * ArrayList:
     */
    public void dealTurn()
    {
        if ((players == null) || (players.size() < 1))
        {
            System.out.println("ERROR: Unable to deal hand, no players.");
            return;
        }

        // Deal the three flop cards:
        Card turn = getDeck().pullCard();

        HoldEmHand currentHand = null;
        HoldEmPlayer currentPlayer = null;

        for (int i = 0; i < (players.size()); i++)
        {
            currentPlayer = (HoldEmPlayer) players.get(i);
            currentHand = currentPlayer.getHand();
            currentHand.setTurn(turn);
        }
        // Rank all player hands at this stage:
        // this.rankPlayerHands();

        // Store the turn in the member variable:
        this.setTurn(turn);
    }

    /**
     * This function deals the turn to the players in the Dealer's players
     * ArrayList:
     */
    public void dealRiver()
    {
        if ((players == null) || (players.size() < 1))
        {
            System.out.println("ERROR: Unable to deal hand, no players.");
            return;
        }

        // Deal the three flop cards:
        Card river = getDeck().pullCard();

        HoldEmHand currentHand = null;
        HoldEmPlayer currentPlayer = null;

        for (int i = 0; i < (players.size()); i++)
        {
            currentPlayer = (HoldEmPlayer) players.get(i);
            currentHand = currentPlayer.getHand();
            currentHand.setRiver(river);
        }
        // Rank all player hands at this stage:
        this.rankPlayerHands();

        // Store the turn in the member variable:
        this.setRiver(river);
    }

    /**
     * This function ranks all the players hands. ArrayList:
     */
    public void rankPlayerHands()
    {
        if ((players == null) || (players.size() < 1))
        {
            System.out.println("ERROR: Unable to rank hands, no players.");
            return;
        }

        HoldEmHand currentHand = null;
        HoldEmPlayer currentPlayer = null;

        for (int i = 0; i < (players.size()); i++)
        {
            currentPlayer = (HoldEmPlayer) players.get(i);
            currentHand = currentPlayer.getHand();
            currentHand.rankHand();
        }
    }

    /**
     * This function ranks all the players hands. ArrayList:
     */
    public ArrayList getAllHands()
    {
        ArrayList allPlayerHands = null;

        if ((players == null) || (players.size() < 1))
        {
            System.out.println("ERROR: Unable to return hands - no players.");

            return allPlayerHands;
        } else
        {
            allPlayerHands = new ArrayList();

            // Get all of the player hands:
            HoldEmPlayer currentPlayer = null;

            for (int i = 0; i < (players.size()); i++)
            {
                currentPlayer = (HoldEmPlayer) players.get(i);
                allPlayerHands.add(currentPlayer.getHand());
            }
        }

        // Return the hands we have:
        return allPlayerHands;
    }

    /**
     * Default Dealer Constructor
     */
    public HoldEmDealer()
    {
        setDeck(new StandardDeck());
        getDeck().shuffle();

        players = new ArrayList();
    }

    /**
     * Prints the HoldEmDealer in a nice way:
     */
    public String toString()
    {
        String result = "";
        result += "Players: " + players + "\n";
        result += "Flop: " + flop + "\n";
        result += "Turn: " + turn + "\n";
        result += "River: " + river + "\n";
        result += "Deck: " + deck;
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        HoldEmDealer theDealer = new HoldEmDealer();

        // Add 3 players:
        theDealer.addPlayer(new HoldEmPlayer(100));
        theDealer.addPlayer(new HoldEmPlayer(75));
        theDealer.addPlayer(new HoldEmPlayer(125));

        // Deal the cards!
        theDealer.dealNewHand();
        theDealer.dealFlop();
        theDealer.dealTurn();
        theDealer.dealRiver();

        System.out.println("HoldEmDealer is: " + theDealer);

    }

}
