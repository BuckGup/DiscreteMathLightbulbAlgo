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
        int[] binaryArray = new int[numSwitches];
        String initialize = "" //need loop here to intilize it with zeros
        char[] binaryChars;

        int counter = 0;

        while (counter != numSwitches) {
            lightBulbArray[counter] = rand.nextInt(2);
            counter++;
        }


        for(int i = 0; i < lightBulbArray.length; i++){

            System.out.println(lightBulbArray[i]);

        }


        if (isOne(lightBulbArray)) {
            lightSwitchState = true;
            System.out.println("The light bulb is on");
            System.out.println("It took zero tries!");
            return;
        }

        System.out.println("Start of sequence");
        for (int j = 0; j < Math.pow(2, numSwitches); j++) {

            String binaryString = Integer.toBinaryString(j); //converts the num of switches to binary
            binaryChars = binaryString.toCharArray(); //converts String to char array for use in loop later

            if(binaryChars[j] == 49) {
                lightBulbArray[j] = 1 - lightBulbArray[j];

                System.out.println(lightBulbArray[j]);

                if(isOne(lightBulbArray)){
                    lightSwitchState = true;
                    System.out.println("The light bulb is on");
                    return;
                }

            }
        }


    }

    private static boolean isOne(int[] lightBulbArray) {
        boolean lightSwitchState;
        boolean isOne = true;
        for (int i = 0; i < lightBulbArray.length; i++) {//checks to see if the switches are all on without flipping a switch
            if (lightBulbArray[i] != 1) {
                isOne = false;
            }
        }
        return isOne;
    }


}
