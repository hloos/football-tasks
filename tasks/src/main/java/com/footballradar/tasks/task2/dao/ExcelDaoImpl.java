/**
 * 
 */
package com.footballradar.tasks.task2.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import lombok.extern.slf4j.Slf4j;

import com.footballradar.tasks.task2.model.GameData;
import com.footballradar.tasks.task2.model.GameData.GameDataBuilder;
import com.footballradar.tasks.task2.model.TeamData;
import com.footballradar.tasks.technical.ContextFactory;
import com.footballradar.tasks.technical.exception.TechnicalException;
import com.footballradar.tasks.technical.properties.ParameterEnum;

/**
 * Extract data from an excel file.
 * @author hloos
 */
@Named(ISeasonDao.NAME)
@Slf4j
public class ExcelDaoImpl implements ISeasonDao {

	@Override
	public Map<String, TeamData> getTeamsSeasons() throws TechnicalException {
		Map<String, TeamData> gamesSeasonMap = new HashMap<>();
		InputStream csvFile = 
				this.getClass().getResourceAsStream(
						ContextFactory.getMessage(ParameterEnum.EXCEL_SEASON_FILE));
		
		String line;
		String cvsSplitBy = ",";
		String[] games = null;
	 
		try (BufferedReader br = new BufferedReader(new InputStreamReader(csvFile));){
			//first line is useless because it just contains titles
			line = br.readLine();
			
			while ((line = br.readLine()) != null) {
				games = line.split(cvsSplitBy);
				addGameToMap(gamesSeasonMap, games);
			}
	 
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new TechnicalException(e);
		}

		return gamesSeasonMap;
	}

	/**
	 * Complete the map result with the data.
	 * @param gamesSeasonMap
	 * @param sheet
	 * @param index of the row
	 */
	private void addGameToMap(Map<String, TeamData> gamesSeasonMap,
			String[] games) {
		
		GameData game = ContextFactory.getBean(GameDataBuilder.class).
				setHomeOpponent(games[2]).
				setAwayOpponent(games[3]).
				setHomeOpponentScore(Integer.valueOf(games[4])).
				setAwayOpponentScore(Integer.valueOf(games[5])).
				setHomeWinBet(Double.valueOf(games[23])).
				setDrawBet(Double.valueOf(games[24])).
				setAwayWinBet(Double.valueOf(games[25])).
				buildGameData();
		
		//data for the home team
		if(gamesSeasonMap.containsKey(game.getHomeOpponent())) {
			gamesSeasonMap.get(game.getHomeOpponent()).getHomeGames().add(game);
		} else {
			TeamData teamData = ContextFactory.getBean(TeamData.class);
			teamData.getHomeGames().add(game);
			gamesSeasonMap.put(game.getHomeOpponent(), teamData);
		}

		//data for the away team
		if(gamesSeasonMap.containsKey(game.getAwayOpponent())) {
			gamesSeasonMap.get(game.getAwayOpponent()).getAwayGames().add(game);
		} else {
			TeamData teamData = ContextFactory.getBean(TeamData.class);
			teamData.getAwayGames().add(game);
			gamesSeasonMap.put(game.getAwayOpponent(), teamData);
		}
	}
}
