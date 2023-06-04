/**
 * Elizabeth Oyebade
 * MET CS 622-O1
 * 5/17/2022
 * Assignment 1
 *
 * Kong Class - used to describe the actions of Donkey Kong (rolling down the barrels)
 */
public class Kong extends DonkeyKong {
    // constructor when donkey kong carries Peach (Princess) up the ladder in the beginning of the game
    public Kong() {
        System.out.println("Donkey Kong carries Peach up the ladder");
    }

    @Override
    public void manageAct(String act) {
        // using the switch statement to declare the actions(act) the characters are going to be doing
        switch (act) {
            case CharAct.HOPS_TO_THE_LEFT:
                System.out.println("Donkey Kong hops to the left");
                break;
            case CharAct.ROLLS_DOWN_BLUE_BARREL:
                System.out.println("Donkey Kong rolls down the blue barrel");
                break;
            case CharAct.ROLLS_DOWN_ORIGINAL_BARRELS:
                System.out.println("Donkey Kong rolls down the original barrel");
                break;
        }
    }
}