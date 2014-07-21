/**
 * 
 */
package com.footballradar.tasks.technical.properties;

/**
 * Parameters to configure the application.
 * @author hloos
 */
public enum ParameterEnum implements IProperties {
	
	QUIZ_TEAM("quiz.footballradar.url"),
	QUIZ_RESULT_TEAM("quiz.footballradarresult.url"),
	
	EXCEL_SEASON_FILE("season.bet.excelfile"),
	BET_SEASON_VALUE("season.bet.value");
	
	private String key;
	
	/** Constructor. */
	private ParameterEnum(String key) {
		this.key = key;
	}
	
	/**
	 * @return the value of the note
	 */
	public String getKey() {
		return key;
	}
}
