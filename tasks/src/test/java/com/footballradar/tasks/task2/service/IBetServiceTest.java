package com.footballradar.tasks.task2.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.footballradar.tasks.AbstractTest;
import com.footballradar.tasks.task2.dao.ISeasonDao;
import com.footballradar.tasks.task2.model.GameData;
import com.footballradar.tasks.task2.model.GameData.GameDataBuilder;
import com.footballradar.tasks.task2.model.TeamData;
import com.footballradar.tasks.technical.ContextFactory;
import com.footballradar.tasks.technical.exception.TechnicalException;

public class IBetServiceTest extends AbstractTest {

	@InjectMocks 
	private BetServiceImpl betService;
	
	@Mock 
	private ISeasonDao excelDao;
	
	private Map<String, TeamData> daoResult;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		daoResult = buildResult();
	}

	private Map<String, TeamData> buildResult() {
		TeamData teamDataArsenal = new TeamData();
		GameData gameH = ContextFactory.getBean(GameDataBuilder.class).
				setHomeOpponent("Arsenal").
				setAwayOpponent("Liverpool").
				setHomeOpponentScore(new Integer(3)).
				setAwayOpponentScore(new Integer(1)).
				setHomeWinBet(2.1d).
				setDrawBet(1.9d).
				setAwayWinBet(2.4d).
				buildGameData();
		GameData gameA = ContextFactory.getBean(GameDataBuilder.class).
				setHomeOpponent("Manchester City").
				setAwayOpponent("Arsenal").
				setHomeOpponentScore(new Integer(2)).
				setAwayOpponentScore(new Integer(2)).
				setHomeWinBet(2.1d).
				setDrawBet(1.9d).
				setAwayWinBet(2.4d).
				buildGameData();
		teamDataArsenal.getHomeGames().add(gameH);
		teamDataArsenal.getAwayGames().add(gameA);
		
		Map<String, TeamData> map = new HashMap<>();
		map.put("Arsenal", teamDataArsenal);
		return map;
	}

	@Test
	public void testCalculateProfitFromAllWinBets() throws TechnicalException {
		Mockito.stub(this.excelDao.getTeamsSeasons())
		.toReturn(daoResult);
		
		Map<String, Integer>result = betService.calculateProfitFromAllWinBets();
		
		assertTrue(result != null);
		assertEquals(1, result.size());
		assertTrue(result.containsKey("Arsenal"));
		assertEquals(new Integer(1), result.get("Arsenal"));
	}

}
