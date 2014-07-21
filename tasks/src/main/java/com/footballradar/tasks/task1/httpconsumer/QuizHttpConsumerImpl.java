/**
 * 
 */
package com.footballradar.tasks.task1.httpconsumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Named;

import org.apache.commons.lang.StringUtils;

import lombok.extern.slf4j.Slf4j;

import com.footballradar.tasks.technical.exception.TechnicalException;

/**
 * Module of a http connection. 
 * @author hloos
 */
@Slf4j
@Named(IQuizHttpConsumer.NAME)
public class QuizHttpConsumerImpl implements IQuizHttpConsumer {

	private final String USER_AGENT = "Mozilla/5.0";
	
	/**
	 * Access to a ressource and return it in a String format.
	 * @return the ressource in a String format
	 * @throws TechnicalException 
	 */
	public String getHttpRessource(String url) throws TechnicalException {
		if(StringUtils.isBlank(url)) 
			throw new IllegalArgumentException();
		
		try {
			URL obj = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", USER_AGENT);
			
			connection.connect();
			
			int responseCode = connection.getResponseCode();
			log.debug("\nSending 'GET' request to URL : " + url);
			log.debug("Response Code : " + responseCode);
			
			InputStream input = connection.getInputStream();
			
			return formatProblemResponse(input);
		} catch (IOException e) {
			throw new TechnicalException(e);
		}
	}
	
	/**
	 * Format the response in a String.
	 * @param inputStream
	 * @return the String
	 * @throws IOException 
	 */
	private String formatProblemResponse(InputStream inputStream) throws IOException {
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(inputStream));
		String inputLine;
		StringBuilder response = new StringBuilder();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
}
