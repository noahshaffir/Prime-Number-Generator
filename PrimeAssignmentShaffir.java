//Author: Noah Shaffir
//Purpose: To find all prime factors of an integer, with less than 19 digits.
//Date: October 24, 2019
import java.util.Scanner; //allows user to make inputs into the system with scanner utility
public class PrimeAssignmentShaffir {
    public static void main(String args[]){
        while(true){//makes it run forever
            boolean badData = true; //error handling boolean
            System.out.println("Please input an integer with 19 or less digits.");
            System.out.println("If you input a negative number, we will find its prime factors as though it is positive.");
            Scanner sc = new Scanner(System.in); //initializes scanner and makes a new input into the computer
            String userString = sc.nextLine(); //assigns the inputted value from the user into a String variable
            double userNum = 0;
            do{ //error handling doesn't stop
                try {
                    userNum = Math.abs(Long.parseLong(userString.trim()));//turns the user's String input into a long, which is a whole number data type, makes sure it is positive
                    badData = false;
                }//end of try
                catch (NumberFormatException nfe) { //deals with user entering bad data
                    System.out.println("This prime factor finder only finds the prime factors of 19 or less digit whole numbers, sorry!");
                    System.out.println("Please input an integer with 19 or less digits.");
                    System.out.println("If you input a negative number, we will find its prime factors as though it is positive.");
                    userString = sc.nextLine();
                }//end of catch
            }while (badData);//end of do - while
            double startTime = System.nanoTime();//starts the timer using the computers internal clock
            for (long counter = 2; counter <= Math.sqrt(userNum); counter++) { //begins counting which stops once it reaches square root of user's input, square root because no perfect squares are prime so extra efficient
                while (userNum % counter == 0) { //makes sure that the counter stops before getting bigger than the input
                    System.out.println(counter); //outputs the first output be the first prime factor, to which all others are multiplied equal the user's input
                    userNum = userNum / counter; //assigns the next output's value to be all prime factors after the first
                }//end of while
            }//end of for
            if (userNum > 2) {
                System.out.println((long)(userNum)); //outputs the next output
            }//end of if
            else if(userNum == 2) {
                System.out.println("2 only has itself as a prime factor."); //error handles when user inputs 2
            }//end of else if
            else if(userNum == 1){
                System.out.println("1 has no prime factors because it only has itself as a factor and 1 is not prime."); //error handles when user inputs 1
            }//end of else if
            else if(userNum == 0){
                System.out.println("0 has an infinite amount of prime factors."); //error handles when user inputs 0
            }//end of else if
            double endTime = System.nanoTime(); //ends the timer
            double totalTime = Math.abs(endTime - startTime); //finds for how long timer went on
            System.out.println("This process took approximately " + ((totalTime) / 1000000000) + " seconds to complete."); //displays how long timer went on
        }//end of while
    }//end of main
}//end of class