/**
 * 
 */
package com.footballradar.tasks.task2.service;

import java.util.Map;

import com.footballradar.tasks.technical.exception.TechnicalException;

/**
 * Generic interface concerning the different bets.
 * @author hloos
 */
public interface IBetService {

	String NAME = "BetServiceImpl";
	
	/**
	 * Calculates and displays the profit or loss we would have made for each team if we had<br />
	 * bet £10 with Bet365 on that team to win every game.
	 * @return a map containing the teams and the associated profit/loss
	 * @throws TechnicalException
	 */
	Map<String, Integer> calculateProfitFromAllWinBets() throws TechnicalException;
}
