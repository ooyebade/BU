/**
 * Elizabeth Oyebade
 * MET CS 622-O1
 * 5/17/2022
 * Assignment 1
 *
 * Mario Class - used to describe the actions of Mario
 */

public class Mario extends DonkeyKong {
    // instant variables representing Mario
    private int lives = 3; // the amount of lives
    // private int points; // points earned
    private boolean climbing; // is Mario climbing
    private boolean jumping; // is Mario jumping
    private boolean died; // mario died
    private boolean hammerAvailability; // is the hammer showing

    // constructor to call to manage the act method
    //      when Mario starts moving in the right direction when the game begins
    public Mario() {
        // showing the direction in which Mario do when the game begins (right)
        manageAct(CharAct.RIGHT_DIRECTION);
        // showing other directions available for mario
        manageAct(CharAct.LEFT_DIRECTION);
    }

    // using the getter method to return the values of the attributes
    // using the setter method to take the parameters and assign it to the attributes

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isClimbing() {
        return climbing;
    }

    public void setClimbing(boolean climbing) {
        this.climbing = climbing;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isDied() {
        return died;
    }

    public void setDied(boolean died) {
        this.died = died;
    }

    public boolean isHammerAvailability() {
        return hammerAvailability;
    }

    public void setHammerAvailability(boolean hammerAvailability) {
        this.hammerAvailability = hammerAvailability;
    }

    /**
     * Representing mario's steps
     *
     * @param marioGameSteps representing the steps mario is taking
     * @param marioGameMovement representing the next steps mario will take
     */
    public void manageAct(String marioGameSteps, String marioGameMovement) {
        if(marioGameSteps.equals(CharAct.MARIO_JUMP) && marioGameMovement.equals(CharAct.MARIO_GRABS_HAMMER)) {
            System.out.println("Mario jumps to grabs the hammer");
        }
        else if(marioGameSteps.equals(CharAct.MARIO_MOVES_RIGHT) && marioGameMovement.equals(CharAct.MARIO_CLIMB)) {
            System.out.println("Mario is moving to the right and climbing the ladder");
        }
        else if(marioGameSteps.equals(CharAct.MARIO_USES_HAMMER) && marioGameMovement.equals(CharAct.MARIO_HIT_BARREL)) {
            System.out.println("Marios uses the hammer and hit the barrels");
        }
    }

    @Override
    public void manageAct(String act) {

        // using the switch statement to declare the actions(act) the characters are going to be doing
        switch (act) {
            case CharAct.MARIO_MOVES_RIGHT:
                System.out.println("Mario moves to the right");
                break;
            case CharAct.MARIO_CLIMB:
                System.out.println("Mario climbs the ladder");
                break;
            case CharAct.MARIO_JUMP:
                System.out.println("Mario jumps");
                break;
            case CharAct.MARIO_USES_HAMMER:
                System.out.println("Mario uses the hammer");
                break;
            case CharAct.MARIO_HIT_BARREL:
                System.out.println("Mario hits the barrel");
                break;
        }

    }
}