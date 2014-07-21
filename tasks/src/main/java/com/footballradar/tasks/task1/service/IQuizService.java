package com.footballradar.tasks.task1.service;

import com.footballradar.tasks.technical.exception.FunctionalException;
import com.footballradar.tasks.technical.exception.TechnicalException;

/**
 * Generic interface representing a Quiz.
 * @author hloos
 */
public interface IQuizService {

	String NAME_QUIZTEAM = "FootballTeamQuizService";
	
	
	/**
	 * Solve the FootballRadar problem and send back the solution in a String format.
	 * @return the solution
	 * @throws TechnicalException 
	 */
	String solveFootballQuizProblem() throws TechnicalException, FunctionalException ;
}
