/**
 * 
 */
package com.footballradar.tasks.task2.dao;

import java.util.Map;

import com.footballradar.tasks.task2.model.TeamData;
import com.footballradar.tasks.technical.exception.TechnicalException;

/**
 * Access to the data persistence.
 * @author hloos
 */
public interface ISeasonDao {

	String NAME = "ExcelDataDaoImpl";
	
	/**
	 * Get the data of the season of all the teams.
	 * @return a map with the team as a key and its games as value
	 * @throws TechnicalException
	 */
	Map<String, TeamData> getTeamsSeasons() throws TechnicalException;
}
