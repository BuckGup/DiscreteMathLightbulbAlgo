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

        if (isOne(lightBulbArray)){
            lightSwitchState = true;

            System.out.println("The light bulb is on");
            return;
        }

        for(int l = 0; l <= (2^numSwitches) - 1; l++){

            System.out.println(Integer.toBinaryString(l));


        }


        //take the binary number and go across each string looking for 1. If you find one take that index and change it of the original switch array


        for (int i = 0; i < numSwitches; i++) {

            lightBulbArray[i] = 1 - lightBulbArray[i];
            if (bruteForce(lightBulbArray)) {
                lightSwitchState = true;
                return;
            }

        }

        returnOrginal(lightBulbArray); //returns array to original form

        for (int j = 1; j <= numSwitches; j++) {
            lightBulbArray[j] = 1 - lightBulbArray[j];
            if(bruteForce(lightBulbArray)){
                lightSwitchState = true;
                return;
            }

        }


    }

    private static boolean isOne(int[] lightBulbArray) {
        boolean lightSwitchState;
        boolean isOne = true;
        for(int i = 0; i < lightBulbArray.length; i++) {//checks to see if the switches are all on without flipping a switch
            if(lightBulbArray[i] != 1){
                isOne = false;
            }
        }
        return isOne;
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
