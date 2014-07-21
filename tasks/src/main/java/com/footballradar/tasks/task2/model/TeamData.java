/**
 * 
 */
package com.footballradar.tasks.task2.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

/**
 * Data of a team.
 * @author hloos
 */
@Named
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@ToString
@EqualsAndHashCode
public class TeamData {

	private List<GameData> homeGames;
	private List<GameData> awayGames;
	
	public List<GameData> getHomeGames() {
		if(homeGames == null) {
			homeGames = new ArrayList<>();
		}
		return homeGames;
	}
	
	public List<GameData> getAwayGames() {
		if(awayGames == null) {
			awayGames = new ArrayList<>();
		}
		return awayGames;
	}
	

	
	
}
