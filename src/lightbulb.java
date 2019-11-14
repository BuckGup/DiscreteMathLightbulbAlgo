import java.util.Scanner;
import java.util.Random;


public class lightbulb {


    public static void main(String[] args) {

        Random rand = new Random();
        boolean lightSwitchState = false;
        Scanner userIn = new Scanner(System.in);
        System.out.println("How many switches would you like?");
        int numSwitches = userIn.nextInt();
        int[] lightBulbArray = new int[numSwitches];

        int counter = 0;

        while (counter != numSwitches) {

            lightBulbArray[counter] = rand.nextInt(2);
            counter++;
        }

//        for(int i = 0; i < lightBulbArray.length; i++){
//
//            System.out.println(lightBulbArray[i]);
//
//        }

        if (bruteForce(lightBulbArray)) { //checks to see if the switches are all on without flipping a switch
            lightSwitchState = true;
        }

        for (int i = 0; i <= numSwitches; i++) {

            lightBulbArray[i] = 1 - lightBulbArray[i];
            if (bruteForce(lightBulbArray)) {
                lightSwitchState = true;
                return;
            }

        }

        returnOrginal(lightBulbArray); //returns array to orginal form

        for (int j = 1; j <= numSwitches; j++) {


        }


    }


    public static boolean bruteForce(int[] input) {

        //Cover the edge cases that the input array is null or has one element.
        if (input == null || input.length == 1)
            return true; //Returning true for null is debatable, but I leave that to you.

        int compare = input[0]; //Compare to the first element of the input array.

        //Check from the second element through the end of the input array.
        for (int i = 1; i < input.length; i++) {
            if (input[i] != compare)
                return false;
        }

        return true;

    }

    public static void returnOrginal(int[] input) {

        for (int i = 0; i <= input.length; i++) {
            input[i] = 1 - i;
        }

    }


}
