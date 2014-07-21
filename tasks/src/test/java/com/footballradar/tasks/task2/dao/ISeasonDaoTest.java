package com.footballradar.tasks.task2.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.footballradar.tasks.AbstractTest;
import com.footballradar.tasks.task2.model.GameData;
import com.footballradar.tasks.task2.model.TeamData;
import com.footballradar.tasks.technical.exception.TechnicalException;

public class ISeasonDaoTest extends AbstractTest {

	private ISeasonDao excelDao;
	@Before
	public void setUp() throws Exception {
		super.setUp();
		excelDao = (ISeasonDao) context.getBean(ISeasonDao.NAME);
	}

	@Test
	public void testGetTeamsSeasons() throws TechnicalException {
		Map<String, TeamData> result = excelDao.getTeamsSeasons();
		assertTrue(result != null);
		assertTrue(result.size() == 3);
		assertTrue(result.containsKey("Arsenal"));
		assertEquals(1, result.get("Arsenal").getHomeGames().size());
		GameData game = result.get("Arsenal").getHomeGames().get(0);
		assertEquals("Arsenal", game.getHomeOpponent());
		assertEquals("Wigan", game.getAwayOpponent());
		assertEquals(new Integer(0), game.getHomeOpponentScore());
		assertEquals(new Integer(2), game.getAwayOpponentScore());
		assertTrue(1.67 == game.getHomeWinBet());
		assertTrue(5.5 == game.getAwayWinBet());
		assertTrue(3.6 == game.getDrawBet());
		assertEquals(1, result.get("Arsenal").getAwayGames().size());
		assertTrue(result.containsKey("Wigan"));
		assertTrue(result.get("Wigan").getHomeGames().isEmpty());
		assertEquals(1, result.get("Wigan").getAwayGames().size());
		assertTrue(result.containsKey("Blackburn"));
		assertEquals(1, result.get("Blackburn").getHomeGames().size());
		assertTrue(result.get("Blackburn").getAwayGames().isEmpty());		
	}
}
