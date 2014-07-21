/**
 * 
 */
package com.footballradar.tasks.task1.service;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.extern.slf4j.Slf4j;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.footballradar.tasks.task1.httpconsumer.IQuizHttpConsumer;
import com.footballradar.tasks.technical.ContextFactory;
import com.footballradar.tasks.technical.exception.FunctionalException;
import com.footballradar.tasks.technical.exception.TechnicalException;
import com.footballradar.tasks.technical.properties.ParameterEnum;

/**
 * Implementation of the resolution of a FootballRadarQuiz (task1).
 * @author hloos
 */
@Slf4j
@Named(IQuizService.NAME_QUIZTEAM)
public class FootballTeamQuizService implements IQuizService {

	@Inject
	private IQuizHttpConsumer quizHttpConsumer;

	/**
	 * Solve the FootballRadar problem and send back the solution in a String format.
	 * @return the solution
	 * @throws TechnicalException 
	 * @throws FunctionalException 
	 */
	@Override
	public String solveFootballQuizProblem() throws TechnicalException, FunctionalException {
		String problem = quizHttpConsumer.getHttpRessource(
				ContextFactory.getMessage(ParameterEnum.QUIZ_TEAM));
		
		String urlToCallToGetFinalResult = findTheAnswerUrl(problem);
		
		return quizHttpConsumer.getHttpRessource(urlToCallToGetFinalResult);
	}

	/**
	 * 
	 * @param problem
	 * @return
	 * @throws FunctionalException 
	 */
	private String findTheAnswerUrl(String problem) throws FunctionalException {
		String[] elements = problem.split("\\{");
		String expression = null;
		
		if(elements.length <= 1) {
			throw new FunctionalException("FootballRadarAlgorithm");
		} else {
			expression = elements[1].split("\\}")[0];
			log.debug("FootballRadar expression to evaluate : {}", expression);
		}
		
		DoubleEvaluator evaluator = new DoubleEvaluator();
	    Double result = evaluator.evaluate(expression);
		
		return ContextFactory.getMessage(ParameterEnum.QUIZ_RESULT_TEAM, result);
	}
}
