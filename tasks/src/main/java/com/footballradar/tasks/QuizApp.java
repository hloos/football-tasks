/**
 * 
 */
package com.footballradar.tasks;

import com.footballradar.tasks.task1.service.IQuizService;
import com.footballradar.tasks.task2.service.IBetService;
import com.footballradar.tasks.technical.ContextFactory;
import com.footballradar.tasks.technical.exception.FunctionalException;
import com.footballradar.tasks.technical.exception.TechnicalException;

/**
 * @author hloos
 */
public class QuizApp {

	private static IQuizService quizService;
	private static IBetService betService;

	/**
	 * @param args
	 * @throws TechnicalException
	 * @throws FunctionalException
	 */
	public static void main(String[] args) throws TechnicalException,
			FunctionalException {
		
		//task1
		performFootballRadarQuiz();
		
		//task2
		performBetAverageCalculation();
	}

	/**
	 * Solve the footballRadar url problem.
	 * @throws TechnicalException
	 * @throws FunctionalException
	 */
	private static void performFootballRadarQuiz() throws TechnicalException, FunctionalException {
		quizService = ContextFactory.getBean(IQuizService.NAME_QUIZTEAM);

		long currentTime = System.nanoTime();
		String solution = quizService.solveFootballQuizProblem();
		long time = System.nanoTime() - currentTime;

		System.out.println("Time in nano: " + time);
		System.out.println("Result of the resolution of the problem: "
				+ solution);
	}
	
	/**
	 * Calculates and displays the profit or loss I would have made for each team if I had<br />
	 * bet £10 with Bet365 on that team to win every game.
	 * @throws TechnicalException 
	 */
	private static void performBetAverageCalculation() throws TechnicalException {
		betService = ContextFactory.getBean(IBetService.NAME);
		
		betService.calculateProfitFromAllWinBets().forEach(
				(teamName, profit) -> System.out.println(
						"Team name: "+ teamName + " and profit: "+ profit));
	}
}
