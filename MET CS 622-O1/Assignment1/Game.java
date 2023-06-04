/**
 * Elizabeth Oyebade
 * MET CS 622-O1
 * 5/17/2022
 * Assignment 1
 *
 * This class represents the Donkey Kong game itself.
 */

public class Game {

    public static void main(String[] args) {
        System.out.println("Welcome to Donkey Kong!");
        System.out.println("Start Game");

        // creating a new kong instance
        Kong kong = new Kong();
        // creating new princess instance
        Princess princess = new Princess();
        // princess peach calling for mario helps
        princess.manageAct(CharAct.PRINCESS_CALLING_FOR_HELP);
        // Donkey Kong rolling down the blue barrel first
        kong.manageAct(CharAct.ROLLS_DOWN_BLUE_BARREL);
        System.out.println("Blue barrel rolls down then the oil barrel lighting a fire ball");
        // Donkey Kong rolling down the original barrels next
        kong.manageAct(CharAct.ROLLS_DOWN_ORIGINAL_BARRELS);

        // creating a new barrel instance
        Barrel barrel = new Barrel();
        barrel.setFalling(true);
        barrel.setExploding(true);
        barrel.setRollingDown(true);
        barrel.setTouchingLadder(true);
        barrel.setPointsAwarded(true);
        if (barrel.isFalling() && barrel.isExploding() && barrel.isRollingDown() &&
                barrel.isPointsAwarded() && barrel.isTouchingLadder())
        {
            System.out.print(true + "\n");
        }
        else {
            return;
        }

        // creating a new game point instance
        GamePoint point = new GamePoint("Level 1", 0, 0);

        // creating a new mario instance
        Mario mario = new Mario();
        // set the lives of mario
        mario.setLives(3);
        // mario moves to the right and climbs the ladder
        mario.manageAct(CharAct.MARIO_MOVES_RIGHT, CharAct.MARIO_CLIMB);
        System.out.println();
        // then mario turns to the left direction
        mario.manageAct(CharAct.LEFT_DIRECTION);
        System.out.println("Mario turns left after climbing the ladder");
        // mario jump and grabs the hammer
        mario.manageAct(CharAct.MARIO_JUMP, CharAct.MARIO_GRABS_HAMMER);
        // mario jumps over one barrel and use the hammer to hit the next barrel
        System.out.println("Mario jumps over one barrel and hits the next barrel");
        // setting mario score after previous action
        point.setPlayerScore(400);
        // is mario climbing the ladder
        mario.setClimbing(true);
        // is mario jumping
        mario.setJumping(true);
        // donkey kong start rolling down more barrels
        kong.manageAct(CharAct.ROLLS_DOWN_ORIGINAL_BARRELS);
        if(mario.isJumping() && mario.isClimbing()) {
            mario.manageAct(CharAct.MARIO_JUMP, CharAct.MARIO_CLIMB);
        }
        mario.manageAct(CharAct.MARIO_JUMP);
        System.out.println("...over barrel");
        point.setPlayerScore(100);
        // see if hammers are available
        mario.setHammerAvailability(true);
        // if hammers are available
        if(mario.isHammerAvailability()) {
            // mario jumps and grabs the hammer
            mario.manageAct(CharAct.MARIO_JUMP, CharAct.MARIO_GRABS_HAMMER);
        }
        point.setPlayerScore(300);
        mario.manageAct(CharAct.MARIO_HIT_BY_BARREL);
        System.out.println("Mario is hit by the barrel");
        // mario dies
        mario.setDied(true);
        // if mario died, then game over
        if(mario.isDied()) {
            System.out.println("Game Over");
        }
        // shows how many lives mario has left
        mario.setLives(2);
        if(mario.getLives() == 2) {
            System.out.println(mario.getLives() + " lives left");
        }
        // reset the game
        System.out.println("Reset Game");
        kong.manageAct(CharAct.DONKEY_KONG_CLIMBS_THE_LADDER);
        // creating new princess instance
        // princess peach calling for mario helps
        princess.manageAct(CharAct.PRINCESS_CALLING_FOR_HELP);
        kong.manageAct(CharAct.ROLLS_DOWN_BLUE_BARREL);
        // blue barrel rolls down the ladder into the oil barrel
        System.out.println("Blue barrel rolls down then the oil barrel lights up the fire ball");
        // Donkey Kong rolling down the original barrels next
        kong.manageAct(CharAct.ROLLS_DOWN_ORIGINAL_BARRELS);
        mario.manageAct(CharAct.MARIO_MOVES_RIGHT, CharAct.MARIO_CLIMB);
        mario.manageAct(CharAct.MARIO_JUMP, CharAct.MARIO_HIT_BARREL);
        System.out.println("Mario jumps over one barrel and hits the next barrel");
        point.setPlayerScore(400);
        mario.manageAct(CharAct.MARIO_HIT_BY_BARREL);
        System.out.println("Mario is hit by the barrel");
        // mario is died
        mario.setDied(true);
        if(mario.isDied()) {
            // game over
            System.out.println("Game Over\n");
            // game level
            point.setGameLevel("" + point.getGameLevel());
            System.out.println("Game Level: " + point.getGameLevel());
            // final score
            System.out.println("Final Score: " + point.getPlayerScore());
            //high score
            point.setHighScore(point.getHighScore());
            System.out.println("High Score: " + (point.getHighScore() + point.getPlayerScore()));
        }
    }
}