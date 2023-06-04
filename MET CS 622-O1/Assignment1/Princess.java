/**
 * Elizabeth Oyebade
 * MET CS 622-O1
 * 5/17/2022
 * Assignment 1
 *
 * Princess class - used to show the princess situation
 */

public class Princess extends DonkeyKong {

    @Override
    public void manageAct(String act) {

        // using the switch statement to declare the actions(act) the characters are going to be doing
        switch (act) {
            case CharAct.PRINCESS_CALLING_FOR_HELP:
                System.out.println("Princess Peach calling for help");
                break;
        }
    }
}