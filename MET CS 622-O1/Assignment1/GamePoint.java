/**
 * Elizabeth Oyebade
 * MET CS 622-O1
 * 5/17/2022
 * Assignment 1
 *
 * This class represents the points of the game
 */

public class GamePoint {

    // level of the game
    private String gameLevel;
    // player score in the game
    private int playerScore;
    // the highest score
    private int highScore;

    /**
     * Showing the overloading method
     * @param gameLevel representing the levels of the game
     * @param playerScore representing the players (Mario) score in the game
     * @param highScore representing the current highest score shown in the game
     */
    public GamePoint(String gameLevel, int playerScore, int highScore) {
        this.gameLevel = gameLevel;
        this.playerScore = playerScore;
        this.highScore = highScore;
    }

    // using the getter method to return the values of the attributes
    // using the setter method to take the parameters and assign it to the attributes

    public String getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(String gameLevel) {
        this.gameLevel = gameLevel;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        // add  to update mario score
        this.playerScore = this.playerScore + playerScore;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    @Override
    public String toString() {
        return "Game Point[" + "Game Level: " + gameLevel
                + ", Player Score: " + playerScore + ", High Score: " + highScore
                + ']';
    }
}