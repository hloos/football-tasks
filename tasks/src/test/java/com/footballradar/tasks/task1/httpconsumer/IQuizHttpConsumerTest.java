package com.footballradar.tasks.task1.httpconsumer;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.footballradar.tasks.AbstractTest;
import com.footballradar.tasks.task1.LocalServer;
import com.footballradar.tasks.technical.exception.TechnicalException;

public class IQuizHttpConsumerTest extends AbstractTest {

	private IQuizHttpConsumer quizConsumer;
	private static LocalServer server = new LocalServer();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		server.start();
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		quizConsumer = (IQuizHttpConsumer) context.getBean(IQuizHttpConsumer.NAME);
	}

	@Test
	public void testGetHttpPage() throws TechnicalException {
		String urlValid = context.getMessage("quiz.footballradar.url", null, Locale.getDefault());
		String problem = quizConsumer.getHttpRessource(urlValid);
		assertEquals("<h1>Who is Football Radar's favourite football team</h1><br/><br/>Find the answer here: http://www.footballradar.com/quiz/answer/{8 * 41 + 11}", 
				problem);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetHttpPage_nullParam() throws TechnicalException {
		quizConsumer.getHttpRessource(null);
	}
	
	@Test(expected = TechnicalException.class)
	public void testGetHttpPage_malformedUrl() throws TechnicalException {
		String malFormedUrl = context.getMessage("quiz.malformed.url", null, Locale.getDefault());
		quizConsumer.getHttpRessource(malFormedUrl);
	}

}
