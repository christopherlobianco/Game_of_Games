/*
 * @filename: GetInput.java
 * @author: Christopher LoBianco
 * @version: 1.0 (04/24/19)
 */

import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class GetInput {

    //Fields
    private Scanner scan;

    //Constructor
    public GetInput() {
        this.scan = new Scanner(System.in);
    }

    //Methods

    /*
     * @param: String, String, String
     * @return: int
     * Method used to get a binary input (pick one of two choices) from user
     */
    public int getBinaryInput(String directions, String option1, String option2) {
        int validChoice = 0;
        boolean validInput = false;
        while(!validInput) {
            System.out.println(directions);
            System.out.println("1. " + option1);
            System.out.println("2. " + option2);
            System.out.print("Please make a choice now: ");
            try {
                validChoice = scan.nextInt();
                if((validChoice == 1)||(validChoice == 2)) {
                    return validChoice;
                } else {
                    System.out.println("Invalid choice; please choose again");
                }
            } catch(InputMismatchException e) {
                System.out.println("Input not an integer");
            }
            scan.nextLine();
        }
        return validChoice;
    }

    /*
     * @param: String, int, int
     * @return: int
     * Method used to get an integer value input from the user
     */
    public int getInt(String directions, int lowBound, int highBound) {
        int validInt = -1;
        boolean validInput = false;
        while(!validInput) {
            System.out.print(directions + ": ");
            try {
                validInt = scan.nextInt();
                if((validInt < lowBound)||(validInt > highBound)) {
                    System.out.println("Input outside specified bounds.");
                } else {
                    return validInt;
                }
            } catch(InputMismatchException e) {
                System.out.println("Input not an integer");
            }
            scan.nextLine();
        }
        return validInt;
    }


    /*
     * @param: String, int, int
     * @return: int
     * Method used to get an odd integer value input from the user
     */
    public int getOddInt(String directions, int lowBound, int highBound) {
        int validInt = -1;
        boolean validInput = false;
        while(!validInput) {
            System.out.print(directions + ": ");
            try {
                validInt = scan.nextInt();
                if((validInt < lowBound)||(validInt > highBound)) {
                    System.out.println("Input outside specified bounds.");
                } else {
                    if(validInt%2 != 0) {
                        return validInt;
                    } else {
                        System.out.println("Input is not odd.");
                    }
                }
            } catch(InputMismatchException e) {
                System.out.println("Input not an integer");
            }
            scan.nextLine();
        }
        return validInt;
    }

    /*
     * @param: String, String
     * @return: boolean
     */
    public boolean clickToContinue(String directions) {
        boolean returnValue = false;
        while(!returnValue) {
            System.out.print(directions + ": ");
            try {
                String inputString = scan.next();
                returnValue = true;
            } catch(InputMismatchException e) {
              System.out.println("Invalid input");
            }
        }
        return returnValue;
    }

    /*
     * @param: String, int, int, int
     * @return: List<Integer>
     * Method used to get a list of integer inputs from the user
     */

    /*
    public LinkedList<Integer> getIntegerList(String directions, int numberGuesss, int lowBound, int highBound) {
        LinkedList<Integer> outputList = new LinkedList<Integer>();
        boolean validInput = false;
        while(!validInput) {
            System.out.println(directions + ": ");
            try {
              while(scan.hasNextInt()) {
                  outputList.add(scan.nextInt());
                  if(outputList.size() == numberGuesss) {
                      return outputList;
                  }
              }
            } catch(InputMismatchException e) {
                System.out.println("Input is not integer.");
            }
        }
        return outputList;
    }
    */

    /*
     * @param: None
     * @return: None
     * Main Method
     */
    public static void main(String args[]) {
        GetInput thisInput = new GetInput();
        String directions = "Please enter an integer between 1 and 10";
        int thisInt = thisInput.getInt(directions, 1, 10);
        String directions2 = "Please choose heads or tails";
        int thisInt2 = thisInput.getBinaryInput(directions2, "Heads", "Tails");
        String directions3 = "Please enter an odd integer between 1 and 4";
        int thisInt3 = thisInput.getOddInt(directions3, 1, 4);
        String directions4 = "Please click any key to continue";
        boolean thisBool = thisInput.clickToContinue(directions4);
        //String directions5 = "Please enter your guesses as integers, separated by spaces";
        //LinkedList<Integer> outputList = thisInput.getIntegerList(directions5, 10,0, 100000);
    }
}

