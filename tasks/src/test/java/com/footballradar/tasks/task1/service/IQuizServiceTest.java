package com.footballradar.tasks.task1.service;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.footballradar.tasks.AbstractTest;
import com.footballradar.tasks.task1.httpconsumer.IQuizHttpConsumer;
import com.footballradar.tasks.technical.exception.FunctionalException;
import com.footballradar.tasks.technical.exception.TechnicalException;

public class IQuizServiceTest extends AbstractTest {

	@InjectMocks 
	private FootballTeamQuizService quizService;
	
	@Mock 
	private IQuizHttpConsumer quizHttpConsumer;

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testSolveFootballQuizProblem() throws TechnicalException, FunctionalException {
		String urlValid = context.getMessage("quiz.footballradar.url", null,  Locale.getDefault());
		String urlResult = "http://www.footballradar.com/quiz/answer/339";
		String expectedResult = "FCGB";
		
		Mockito.stub(this.quizHttpConsumer.getHttpRessource(urlValid))
				.toReturn("<h1>Who is Football Radar's favourite football team</h1><br/><br/>Find the answer here: http://www.footballradar.com/quiz/answer/{8 * 41 + 11}");
		
		Mockito.stub(this.quizHttpConsumer.getHttpRessource(urlResult))
		.toReturn(expectedResult);
		
		String result = quizService.solveFootballQuizProblem();
		assertEquals(expectedResult, result);
	}
	
	@Test(expected = FunctionalException.class)
	public void testSolveFootballQuizProblem_UrlProblemInvalid() throws TechnicalException, FunctionalException {
		String urlValid = context.getMessage("quiz.footballradar.url", null,  Locale.getDefault());
		String urlResult = "http://www.footballradar.com/quiz/answer/339";
		String expectedResult = "FCGB";
		
		Mockito.stub(this.quizHttpConsumer.getHttpRessource(urlValid))
		.toReturn("<h1>Who is Football Radar's favourite football team</h1><br/><br/>Find the answer here: http://www.footballradar.com/quiz/answer/8 * 41 + 11}");
		
		Mockito.stub(this.quizHttpConsumer.getHttpRessource(urlResult))
		.toReturn(expectedResult);
		
		String result = quizService.solveFootballQuizProblem();
		assertEquals(expectedResult, result);
	}
}
