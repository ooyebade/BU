/**
 * Elizabeth Oyebade
 * MET CS 622-O1
 * 5/17/2022
 * Assignment 1
 *
 * Barrel Class -  Used to describe the barrels act seen in the game
 *
 */
public class Barrel extends DonkeyKong{
    // checking to see if the barrels are falling
    private boolean falling;
    // whether the barrels are rolling down
    private boolean rollingDown;
    // whether points was awarded to the barrels
    private boolean pointsAwarded;
    // are the barrels exploding
    private boolean exploding;
    private boolean touchingLadder; // are the barrels touching the ladders

    // constructor when donkey kong begins rolling down the barrels in the game
    public Barrel() {
        System.out.println("Donkey Kong starts rolling down the barrels");
    }

    // using the getter method to return the values of the attributes
    // using the setter method to take the parameters and assign it to the attributes

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    @Override
    public void manageAct(String act) {
        switch (act) {
            case CharAct.BLUE_BARREL:
                System.out.println("Roll down blue bar");
                break;
            case CharAct.ORIGINAL_BARRELS:
                System.out.println("Roll down original barrel");
                break;
        }
    }

    public boolean isRollingDown() {
        return rollingDown;
    }

    public void setRollingDown(boolean rollingDown) {
        this.rollingDown = rollingDown;
    }

    public boolean isPointsAwarded() {
        return pointsAwarded;
    }

    public void setPointsAwarded(boolean pointsAwarded) {
        this.pointsAwarded = pointsAwarded;
    }

    public boolean isExploding() {
        return exploding;
    }

    public void setExploding(boolean exploding) {
        this.exploding = exploding;
    }

    public boolean isTouchingLadder() {
        return touchingLadder;
    }

    public void setTouchingLadder(boolean touchingLadder) {
        this.touchingLadder = touchingLadder;
    }
}