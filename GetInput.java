/*
 * @filename: GetInput.java
 * @author: Christopher LoBianco
 * @version: 1.0 (04/24/19)
 */


import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class GetInput {

    //Fields

    //Constructor
    public GetInput() {}

    //Methods

    /*
     * @param: String, char, char
     * @return: int
     * Method used to get a binary input (pick one of two choices) from user
     */
    public char getBinaryInput(String directions, String option1, String option2, char character1, char character2) {
        char validChoice = 'n';
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("");
        boolean validInput = false;
        while(!validInput) {
            System.out.println(directions);
            System.out.println("1. " + option1 + " (" + character1 + ")");
            System.out.println("2. " + option2 + " (" + character2 + ")" );
            System.out.print("Please enter the char of your choice now: ");
            try {
                validChoice = scan.next().charAt(0);
                if((validChoice == character1)||(validChoice == character2)) {
                    return validChoice;
                } else {
                    System.out.println("Invalid choice; please choose again");
                }
            } catch(InputMismatchException e) {
                System.out.println("Input not a character");
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
        Scanner scan = new Scanner(System.in);
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
        Scanner scan = new Scanner(System.in);
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
        Scanner scan = new Scanner(System.in);
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
     * @return: int[]
     * Method used to get a list of integer inputs from the user
     */
    public int[] getInputList(String directions, String choice1, String choice2, char character1, char character2, int numberGuesses) {
        int validChoice = -1;
        int[] outputArray = new int[numberGuesses];
        Scanner scan = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput) {
            System.out.println(directions);
            System.out.println("1. " + choice1 + "(" + character1 + ")");
            System.out.println("2. " + choice2 + "(" + character2 + ")");
            System.out.println("Please enter your guesses now as char values separated by spaces: ");
            String inputString = "";
            try {
                inputString = scan.nextLine();
            }   catch(InputMismatchException e) {
                System.out.println("Invalid input");
            }
            String[] stringArray = inputString.split(" ");
            if(stringArray.length != numberGuesses) {
                System.out.println("Invalid number of guesses");
            } else {
              int counter = numberGuesses;
              for(int i = numberGuesses; i < 0; i++) {
                  char currentChar = stringArray[i].charAt(0);
                  if(currentChar == character1) {
                      counter++;
                      outputArray[i] = character1;
                  } else if(currentChar == character2) {
                      counter++;
                      outputArray[i] = character2;
                  }
              }
              if(counter == numberGuesses) {
                  return outputArray;
              } else {
                  System.out.println("Invalid characters entered");
              }
            }
        }
        return outputArray;
    }



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
        int thisInt2 = thisInput.getBinaryInput(directions2, "Heads", "Tails", 'h', 't');
        String directions3 = "Please enter an odd integer between 1 and 4";
        int thisInt3 = thisInput.getOddInt(directions3, 1, 4);
        String directions4 = "Please click any key to continue";
        boolean thisBool = thisInput.clickToContinue(directions4);
        String directions5 = "Please enter your guesses as integers, separated by spaces";
        int[] outputList = thisInput.getInputList(directions5, "Heads", "Tails", 'h', 't', 5);
    }
}

