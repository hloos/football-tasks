/**
 * 
 */
package com.footballradar.tasks.task2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;

import lombok.extern.slf4j.Slf4j;

import com.footballradar.tasks.task2.dao.ISeasonDao;
import com.footballradar.tasks.task2.model.GameData;
import com.footballradar.tasks.task2.model.TeamData;
import com.footballradar.tasks.technical.ContextFactory;
import com.footballradar.tasks.technical.exception.TechnicalException;
import com.footballradar.tasks.technical.properties.ParameterEnum;

/**
 * Service to calculate a specific bet.
 * @author hloos
 */
@Named(IBetService.NAME)
@Slf4j
public class BetServiceImpl implements IBetService {
	
	@Inject
	private ISeasonDao dataDao;
	
	/**
	 * Calculates and displays the profit or loss we would have made for each team if we had<br />
	 * bet £10 with Bet365 on that team to win every game.
	 * @return a map containing the teams and the associated profit/loss
	 * @throws TechnicalException
	 */
	public Map<String, Integer> calculateProfitFromAllWinBets() throws TechnicalException {
		Map<String, Integer> profitBetByTeamMap = new HashMap<>();
		Map<String, TeamData> seasonData = dataDao.getTeamsSeasons();
		
		TeamData teamData;
		for(String teamName : seasonData.keySet()) {
			teamData = seasonData.get(teamName);
			
			int profit = calculateProfit(teamName, teamData.getHomeGames());
			profit += calculateProfit(teamName, teamData.getAwayGames());
			
			profitBetByTeamMap.put(teamName, profit);
			log.trace("{} {}", teamName, profit);
		}
		
		return profitBetByTeamMap;
	}

	/**
	 * Calculate the profit for each game. 
	 * @param teamName
	 * @param homeGames
	 * @return the profit
	 */
	private int calculateProfit(String teamName,
			List<GameData> games) {
		int profit = 0;
		int valueBet = Integer.valueOf(ContextFactory.getMessage(ParameterEnum.BET_SEASON_VALUE));
		
		for(GameData game : games) {
			if(game.isDraw()) {
				profit -= valueBet;
			} else if(StringUtils.isNotBlank(game.getWinningTeam()) 
					&& game.getWinningTeam().equals(teamName)){
				profit += valueBet * game.getWinningBet() - valueBet;
			} else {
				profit -= valueBet;
			}
		}
		
		return profit;
	}

}
