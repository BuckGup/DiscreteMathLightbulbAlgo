import java.util.Scanner;
import java.util.Random;


public class lightbulb {


    public static void main(String[] args){

        Random rand = new Random();
        Scanner userIn = new Scanner(System.in);
        System.out.println("How many switches would you like?");
        int numSwitches = userIn.nextInt();
        int[] lightBulbArray = new int[numSwitches];


        int counter = 0;

        while(counter != numSwitches){

            lightBulbArray[counter] = rand.nextInt(2);
            counter++;
        }

       /* for(int i = 0; i < lightBulbArray.length; i++){

            System.out.println(lightBulbArray[i]);

        }*/


    }









}
