import java.awt.*;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import javax.swing.JTable;
import javax.swing.*;


public class lightbulb extends JFrame {

    public static void main(String[] args) {



        Random rand = new Random();
        boolean lightSwitchState = false;
        Scanner userIn = new Scanner(System.in);
        System.out.println("How many switches would you like?");
        int numSwitches = userIn.nextInt();
        int[] lightBulbArray = new int[numSwitches];
        String lightBulbArrayString;
        char[] lightBulbCharArray;
        int lightBulbNum;
        int[] binaryArray = new int[numSwitches];
        char[] binaryChars;
        char[] lightBulbCharGrayCompare;


        int counter = 0;

        lightBulbNum = rand.nextInt((int) Math.pow(2, numSwitches));
        lightBulbArrayString = Integer.toBinaryString(lightBulbNum);
        lightBulbCharArray = lightBulbArrayString.toCharArray();

        char[] reverseLightBulbCharArray = new char[lightBulbCharArray.length];

        if (lightBulbCharArray.length < numSwitches) {

            char[] lightBulbCharArrayExtended = {0, 0, 0, 0, 0, 0, 0, 0, 0};

            for (int m = 0; m < numSwitches; m++) {
                lightBulbCharArrayExtended[m] = 0;
            }

            System.out.println("The Stuff below");
            //System.out.println(lightBulbCharArrayExtended);

            for (int c = numSwitches - 1, d = 0; c <= d; c--, d++) {
                lightBulbCharArrayExtended[c] = lightBulbCharArray[d];
            }

            System.out.println(lightBulbCharArrayExtended);

//            int howMany = numSwitches - lightBulbCharArray.length;
//            counter = lightBulbCharArray.length + 1;
//
//            if (lightBulbCharArray.length == 0) {
//                counter = lightBulbCharArray.length;
//                for (int i = 0; i < howMany; i++) {
//                    lightBulbArray[counter] = 0;
//                    counter++;
//                }
//            } else {
//                for (int i = 0; i < howMany; i++) {
//                    lightBulbCharArray[counter] = 0;
//                    counter++;
//                }
//            }

//            int i = lightBulbCharArray.length - 1, v = 0;
//            while (i >= 0) {
//                reverseLightBulbCharArray[v] = lightBulbCharArray[i];
//                i--;
//                v++;
//            }
        } else {
            for (int k = 0; k < lightBulbCharArray.length; k++)
                reverseLightBulbCharArray[k] = lightBulbCharArray[k];
        }


        char[] lightBulbCharGray = binaryToGray(reverseLightBulbCharArray);

        System.out.println("\nStart of sequence");
        System.out.println(reverseLightBulbCharArray);
        System.out.println("^^^^reverse lightbulb array");
        System.out.println(lightBulbNum);
        System.out.println("^^^^Random start value");
        System.out.println(lightBulbCharGray);
        System.out.println("^^GRAY CODE");


        for (int j = 0; j < Math.pow(2, numSwitches) - 1; j++) {


            if (lightBulbNum > Math.pow(2, numSwitches)) {
                lightBulbNum = 0;
            }

            lightBulbNum++;

            lightBulbArrayString = Integer.toBinaryString(lightBulbNum);
            lightBulbCharArray = lightBulbArrayString.toCharArray();


            //need to


            lightBulbCharGrayCompare = binaryToGray(lightBulbCharArray);

            //System.out.println("Light bulb char array");
            System.out.println(lightBulbCharArray);

//            if(isOne(lightBulbCharArray)){
//                System.out.println("The lightbulb is on");
//                System.out.println("It took " + j + " tries");
//                return;
//            }

            for (int k = 0; k <= numSwitches; k++) {

                if (lightBulbCharGray[k] != lightBulbCharGrayCompare[k]) {

                    if (lightBulbCharArray[k] == '1') {

                        lightBulbCharArray[k] = '0';
                    } else {
                        lightBulbCharArray[k] = '1';
                    }

                    if (isOne(lightBulbCharArray)) {
                        System.out.println("The lightbulb is on");
                        return;

                    }
                }
            }

            lightBulbCharGray = lightBulbCharGrayCompare;
        }


//        while (counter != numSwitches) { //fills the array with random values
//            lightBulbArray[counter] = rand.nextInt(2);
//            counter++;
//        }

//
//        for (int i = 0; i < lightBulbArray.length; i++) {
//            System.out.print(lightBulbArray[i]);
//        }
//
////        if (isOne(lightBulbArray)) {
////            lightSwitchState = true;
////            System.out.println("The light bulb is on");
////            System.out.println("It took zero tries!");
////            return;
////        }
//
//        for (int i = 0; i < lightBulbArray.length; i++) {//make a copy of the array
//            binaryArray[i] = lightBulbArray[i];
//        }
//


        //make a copy of the lightbulb array and keep adding one and compare the gray code from the previous to current to see what changed
        //then whatever had changed flip that in the lighbulb array and test to see if all are 1


//        for (int j = 0; j < Math.pow(2, numSwitches); j++) {
//
//            String binaryString = Integer.toBinaryString(j); //converts the num of switches to binary
//            binaryChars = binaryString.toCharArray(); //converts String to char array for use in loop later
//            // reverseArray(lightBulbArray, binaryChars.length);
//
//            //System.out.println(binaryChars);
//
//            binaryToGray(binaryChars);
//            //System.out.println("Binary to Gray");
//            //System.out.println(binaryToGray(binaryChars));
//
//                for (int p = binaryChars.length - 1; p >= 0; p--) {
//
//                    if (binaryChars[p] == 49) {
//
//                        lightBulbArray[p] = 1 - lightBulbArray[p];//flips the switch in the original array
//
//                        if (isOne(lightBulbArray)) {
//                            lightSwitchState = true;
//                            System.out.println("The light bulb is on");
//                            System.out.println("It took " + j + " tries"); //use Grays code for the position of the number flipped
//                            return;
//                        }
//
//                    }
//                }
//            }


    }

    private static boolean isOne(char[] lightBulbArray) {
        boolean lightSwitchState;
        boolean isOne = true;
        for (int i = 0; i < lightBulbArray.length; i++) {//checks to see if the switches are all on without flipping a switch
            if (lightBulbArray[i] != '1') {
                isOne = false;
            }
        }
        return isOne;
    }

    public static char[] binaryToGray(char[] binary) {

        //System.out.println("This is binary");
//        for(int j = 0; j < binary.length -1; j++){
//            System.out.println(binary[j]);
//        }
        char gray[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gray[0] = binary[0];
        char a;
        char b;
        int c;
        for (int i = 0; i < binary.length - 1; i++) {
            a = binary[i];
            b = binary[i + 1];

            //System.out.println("A: " + Character.getNumericValue(a) + "\n");
            //System.out.println("B: " + Character.getNumericValue(b) + "\n");

            c = (Character.getNumericValue(b)) ^ (Character.getNumericValue(a));
            //System.out.println((char)c + 48);
            gray[i + 1] = (char) (c + 48);
        }

        return gray;
    }

    public static void printReverse(char[] letters, int size) {

        for (int i = letters.length - 1; i >= 0; i--) {
            System.out.print(letters[i]);
        }
    }


    static void reverseArray(int a[], int n) {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

    }

//    public static JTable createTable() {
//        JPanel panel;
//        panel = new JPanel(new FlowLayout());
//        ImageIcon ourFaces = new ImageIcon("IHaveCocaineInMyeyesSmol.jpg");
//        JLabel loadingIcon = new JLabel(ourFaces);
//        String[] columnNames = {"First Name", "Last Name"};
//        Object[][] data = {{"Kathy", "Smith"}, {"John", "Doe"}};
//        JTable table = new JTable(data, columnNames);
//        panel.add(loadingIcon);
//        loadingIcon.setVisible(true);
//        table.setFillsViewportHeight(true);
//
//        return table;
//    }


}
