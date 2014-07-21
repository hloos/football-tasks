package com.footballradar.tasks.task1;

import static spark.Spark.setPort;
import static spark.Spark.get;

/**
 * Simulation of a remote http server.
 * @author hloos
 *
 */
public class LocalServer {

	public void start(){
		setPort(8082);
	    initializeRoutes();
	}

	private void initializeRoutes() {
		get("/quiz/", 
				(req, res) -> "<h1>Who is Football Radar's favourite football team</h1><br/><br/>Find the answer here: http://www.footballradar.com/quiz/answer/{8 * 41 + 11}");
		get("/answer/339", (req, res) -> "FCGB");
	}
}
