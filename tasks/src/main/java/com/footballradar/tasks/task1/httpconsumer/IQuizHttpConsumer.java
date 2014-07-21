package com.footballradar.tasks.task1.httpconsumer;

import com.footballradar.tasks.technical.exception.TechnicalException;

/**
 * Generic interface representing a http call.
 * @author hloos
 */
public interface IQuizHttpConsumer {

	String NAME = "QuizHttpConsumerImpl";
	
	
	/**
	 * Access to a ressource and return it in a String format.
	 * @param the url to call
	 * @return the ressource in a String format
	 * @throws TechnicalException 
	 */
	String getHttpRessource(String url) throws TechnicalException ;
}
