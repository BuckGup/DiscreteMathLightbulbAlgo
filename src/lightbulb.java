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
        char[] binaryChars;

        int counter = 0;

        while (counter != numSwitches) {
            lightBulbArray[counter] = rand.nextInt(2);
            counter++;
        }


        for (int i = 0; i < lightBulbArray.length; i++) {
            System.out.print(lightBulbArray[i]);
        }


        if (isOne(lightBulbArray)) {
            lightSwitchState = true;
            System.out.println("The light bulb is on");
            System.out.println("It took zero tries!");
            return;
        }

        System.out.println("\nStart of sequence");

        for (int j = 0; j < Math.pow(2, numSwitches); j++) {

            String binaryString = Integer.toBinaryString(j); //converts the num of switches to binary
            binaryChars = binaryString.toCharArray(); //converts String to char array for use in loop later
           // reverseArray(lightBulbArray, binaryChars.length);
            System.out.println(binaryChars);

            //for (int p = 0; p < binaryChars.length; p++) {
            for (int p = binaryChars.length - 1; p >= 0; p--) {

                if (binaryChars[p] == 49) {

                    lightBulbArray[p] = 1 - lightBulbArray[p];//flips the switch in the original array

                    if (isOne(lightBulbArray)) {
                        lightSwitchState = true;
                        System.out.println("The light bulb is on");
                        System.out.println("It took " + j + " tries"); //use Grays code for the position of the number flipped
                        return;
                    }

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


    static void reverseArray(int a[], int n) {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

    }

}
