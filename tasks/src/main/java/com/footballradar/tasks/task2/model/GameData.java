/**
 * 
 */
package com.footballradar.tasks.task2.model;

import javax.inject.Named;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

/**
 * Data of a game.
 * @author hloos
 */
@ToString
@EqualsAndHashCode
public class GameData {
	
	@Getter private final String homeOpponent;
	@Getter private final String awayOpponent;
	@Getter private final Integer homeOpponentScore;
	@Getter private final Integer awayOpponentScore;
	@Getter private final double homeWinBet;
	@Getter private final double drawBet;
	@Getter private final double awayWinBet;
	
	@Getter private final double winningBet;
	@Getter private final boolean isDraw;
	@Getter private final String winningTeam;
	
	/**
	 * Constructor.
	 */
	private GameData(GameDataBuilder builder) {
		this.homeOpponent = builder.homeOpponent;
		this.awayOpponent = builder.awayOpponent;
		this.homeOpponentScore = builder.homeOpponentScore; 
		this.awayOpponentScore = builder.awayOpponentScore;
		this.homeWinBet = builder.homeWinBet;
		this.drawBet = builder.drawBet;
		this.awayWinBet = builder.awayWinBet;	
		this.winningBet = builder.getWinningBet();
		this.isDraw = builder.isDraw();
		this.winningTeam = builder.getWinningTeam();
	}
	
	@Named
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public static class GameDataBuilder {
		
		private String homeOpponent;
		private String awayOpponent;
		private Integer homeOpponentScore;
		private Integer awayOpponentScore;
		private double homeWinBet;
		private double drawBet;
		private double awayWinBet;
		private double winningBet;
		private String winningTeam;
		
		public GameDataBuilder(){}

		/**
		 * @param homeOpponent the homeOpponent to set
		 */
		public GameDataBuilder setHomeOpponent(String homeOpponent) {
			this.homeOpponent = homeOpponent;
			return this;
		}

		/**
		 * @param awayOpponent the awayOpponent to set
		 */
		public GameDataBuilder setAwayOpponent(String awayOpponent) {
			this.awayOpponent = awayOpponent;
			return this;
		}

		/**
		 * @param homeOpponentScore the homeOpponentScore to set
		 */
		public GameDataBuilder setHomeOpponentScore(Integer homeOpponentScore) {
			this.homeOpponentScore = homeOpponentScore;
			return this;
		}

		/**
		 * @param awayOpponentScore the awayOpponentScore to set
		 */
		public GameDataBuilder setAwayOpponentScore(Integer awayOpponentScore) {
			this.awayOpponentScore = awayOpponentScore;
			return this;
		}

		/**
		 * @param homeWinBet the homeWinBet to set
		 */
		public GameDataBuilder setHomeWinBet(double homeWinBet) {
			this.homeWinBet = homeWinBet;
			return this;
		}

		/**
		 * @param drawBet the drawBet to set
		 */
		public GameDataBuilder setDrawBet(double drawBet) {
			this.drawBet = drawBet;
			return this;
		}

		/**
		 * @param awayWinBet the awayWinBet to set
		 */
		public GameDataBuilder setAwayWinBet(double awayWinBet) {
			this.awayWinBet = awayWinBet;
			return this;
		}
		
		/**
		 * @return the winningBet
		 */
		public double getWinningBet() {
			if(homeOpponentScore > awayOpponentScore) {
				winningBet = homeWinBet;
			} else if(awayOpponentScore > homeOpponentScore) {
				winningBet = awayWinBet;
			} else {
				winningBet = drawBet;
			}
			return winningBet;
		}

		/**
		 * @return the isDraw
		 */
		public boolean isDraw() {
			return homeOpponentScore == awayOpponentScore;
		}

		/**
		 * @return the winningTeam
		 */
		public String getWinningTeam() {
			if(homeOpponentScore > awayOpponentScore) {
				winningTeam = homeOpponent;
			} else if(awayOpponentScore > homeOpponentScore) {
				winningTeam = awayOpponent;
			}
			return winningTeam;
		}

		/**
		 * Build the final instance of the Game Data.
		 * @return the instance
		 */
		public GameData buildGameData(){
			return new GameData(this);
		}
	}
}
