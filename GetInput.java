/*
 * @filename: GetInput.java
 * @author: Christopher LoBianco
 * @version: 1.0 (04/24/19)
 */


import java.util.Arrays;
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
    public int getBinaryInput(String directions, String option1, String option2, char character1, char character2) {
        char validChoice;
        Scanner scan = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput) {                                                        //While input is invalid
            System.out.println(directions);                                         //Print directions
            System.out.println("1. " + option1 + " (" + character1 + ")");
            System.out.println("2. " + option2 + " (" + character2 + ")" );
            System.out.print("Please enter the char of your choice now: ");
            try {
                String inputString  = scan.next().toLowerCase();                    //Get input from scanner
                if(inputString.length() != 1) {                                     //If input not one char
                    System.out.println("Invalid input; please choose again");       //Print error message
                } else {                                                            //If input is one character
                    validChoice = inputString.charAt(0);                            //Get character value
                    if(validChoice == character1) {                                 //If input char = option1
                        return 1;                                                   //Return 1
                    } else if(validChoice == character2) {                          //If input char = option2
                        return 2;                                                   //Return 2
                    } else {                                                        //If input not option
                        System.out.println("Invalid choice; please choose again");  //Print error
                    }
                }
            } catch(InputMismatchException e) {
                System.out.println("Input not a character");
            }
            scan.nextLine();
        }
        return 0;
    }

    /*
     * @param: String, int, int
     * @return: int
     * Method used to get an integer value input from the user, where bounds are inclusive
     */
    public int getInt(String directions, int lowBound, int highBound) {
        int validInt = -1;
        boolean validInput = false;
        Scanner scan = new Scanner(System.in);
        while(!validInput) {                                                            //While input is invalid
            System.out.print(directions);
            try {
                validInt = scan.nextInt();                                              //Get input from scanner
                if((validInt < lowBound)||(validInt > highBound)) {                     //If int is outside bounds
                    System.out.println("Input outside specified bounds.");              //Print error
                } else {                                                                //If int is valid
                    return validInt;                                                    //Return int
                }
            } catch(InputMismatchException e) {                                         //If input is not int
                System.out.println("Input not an integer");                             //Print error
            }
            scan.nextLine();                                                            //Advance scanner to next line
        }
        return validInt;
    }


    /*
     * @param: String, int, int
     * @return: int
     * Method used to get an odd integer value input from the user, where bounds are inclusive
     */
    public int getOddInt(String directions, int lowBound, int highBound) {
        int validInt = -1;
        boolean validInput = false;
        Scanner scan = new Scanner(System.in);
        while(!validInput) {                                                            //While input is invalid
            System.out.print(directions);
            try {
                validInt = scan.nextInt();                                              //Get input from scanner
                if((validInt < lowBound)||(validInt > highBound)) {                     //If int is outside bounds
                    System.out.println("Input outside specified bounds.");              //Print error
                } else {                                                                //If int is inside bounds
                    if(validInt%2 != 0) {                                               //If int is odd
                        return validInt;                                                //Return int
                    } else {                                                            //If int is even
                        System.out.println("Input is not odd.");                        //Print error
                    }
                }
            } catch(InputMismatchException e) {                                         //If input is not an int
                System.out.println("Input not an integer");                             //Print error message
            }
            scan.nextLine();                                                            //Advance scanner to next line
        }
        return validInt;
    }

    /*
     * @param: String, String
     * @return: boolean
     * This method is used to get any keyboard input from the user
     */
    public boolean clickToContinue(String directions) {
        boolean returnValue = false;
        Scanner scan = new Scanner(System.in);
        while(!returnValue) {                               //While no value is entered
            System.out.print(directions + ": ");            //Print directions
            try {
                String inputString = scan.next();           //Get input from scanner
                returnValue = true;                         //Value has been entered = true
            } catch(InputMismatchException e) {             //If input does not match
              System.out.println("Invalid input");          //Print error
            }
        }
        return returnValue;
    }

    /*
     * @param: String, int, int, int
     * @return: int[]
     * Method used to get a list of binary inputs from the user
     */
    public int[] getInputList(String directions, String choice1, String choice2, char character1, char character2, int numberGuesses) {
        int validChoice = -1;
        int[] outputArray = new int[numberGuesses];
        Scanner scan = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput) {                                                    //While input is invalid
            System.out.println(directions);                                     //Print directions
            System.out.println("1. " + choice1 + "(" + character1 + ")");
            System.out.println("2. " + choice2 + "(" + character2 + ")");
            String inputString = "";
            try {
                inputString = scan.nextLine().toLowerCase();                    //Get input from scanner
            }   catch(InputMismatchException e) {                               //If input is not valid
                System.out.println("Invalid input");                            //Print error message
            }
            String[] stringArray = inputString.split(" ");                //Break string at blanks
            if(stringArray.length != numberGuesses) {                           //If number char inputs > # guesses
                System.out.println("Invalid number of guesses");                //Print error message
            } else {                                                            //If # char inputs is correct
              int counter = 0;                                                  //Initialize counter of valid inputs
              for(int i = 0; i < numberGuesses; i++) {                          //For each input char
                  char currentChar = stringArray[i].charAt(0);                  //Get char from array
                  if(currentChar == character1) {                               //If current char = option1
                      counter++;                                                //Advance counter of # valid inputs
                      outputArray[i] = 1;                                       //Add int to output array
                  } else if(currentChar == character2) {                        //If current char = option2
                      counter++;                                                //Advance counter of # valid inputs
                      outputArray[i] = 2;                                       //Add int to output array
                  }
              }
              if(counter == numberGuesses) {                                    //If all inputs are valid
                  return outputArray;                                           //Return output array
              } else {                                                          //If some inputs are invalid
                  System.out.println("Invalid characters entered");             //Print error message
              }
            }
        }
        return outputArray;
    }

    /*
     * @param: String, int, int
     * @return: int[]
     * This method is used to get a list of integer values
     */
    public int[] getArrayInt(String directions, int lowerBound, int upperBound, int numberGuesses) {
        System.out.println(directions);
        int[] outputArray = new int[numberGuesses];
        Scanner scan = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput) {                                                             //While input is invalid
            LinkedList<Integer> existingValues = new LinkedList<Integer>();                    //Create list of entered values
            System.out.println("Please enter int values separated by spaces");           //Print directions
            String inputString = "";
            try {
              inputString = scan.nextLine();                                             //Get input from scanner
            } catch(InputMismatchException e) {                                          //If input invalid
                System.out.println("Invalid values entered");                            //Print error
            }
            String[] stringArray = inputString.split(" ");                        //Split input at blanks
            if(stringArray.length != numberGuesses) {                                   //If #input > # guesses
                System.out.println("Invalid number of guesses");                        //Print error
            }
            else {                                                                     //If # inputs valid
              int counter = 0;                                                        //Initialize counter for # valid
              boolean duplicateValues = false;                                        //Duplicate values = false
              for(int i = 0; i < numberGuesses; i++) {                                //For each input
                  try {
                      int currentInt = Integer.parseInt(stringArray[i]);              //Parse to int value
                      if((currentInt <= upperBound)&& (currentInt >= lowerBound)) {   //If within range
                          if(!existingValues.contains(currentInt)) {                  //If not previously entered
                              outputArray[i] = currentInt;                            //Add to output array
                              existingValues.add(currentInt);                         //Add to list of inputted values
                              counter++;                                              //Update # valid counter
                          } else {                                                    //If duplicate values
                              duplicateValues = true;                                 //Duplicate values = true
                          }
                      }
                  } catch(NumberFormatException e) {                                  //If not int input
                      i = numberGuesses;                                              //Stop checking validity
                  }
              }
              if(counter == numberGuesses) {                                          //If all inputs valid
                  return outputArray;                                                 //Return output array
              } else {                                                                //If invalid input
                  if(duplicateValues) {                                               //If dupliate values present
                      System.out.println("You have entered duplicate values");        //Print error message
                  } else {                                                            //If invalid input
                      System.out.println("Invalid values entered");                   //Print error message
                  }
              }
            }
        }
        return outputArray;
    }

    /*
     * @param: None
     * @return: None
     * Main Method to test various methods of GetInput
     */
    public static void main(String args[]) {
        GetInput thisInput = new GetInput();
        String directions = "Please enter an integer between 1 and 10";
        int thisInt = thisInput.getInt(directions, 1, 10);
        System.out.println("getInt output: " + thisInt);

        String directions2 = "Please choose heads or tails";
        int thisInt2 = thisInput.getBinaryInput(directions2, "Heads", "Tails", 'h', 't');
        System.out.println("getBinaryInput output: " + thisInt2);

        String directions3 = "Please enter an odd integer between 1 and 4";
        int thisInt3 = thisInput.getOddInt(directions3, 1, 4);
        System.out.println("getOddInt output: " + thisInt3);

        String directions4 = "Please click any key to continue";
        boolean thisBool = thisInput.clickToContinue(directions4);
        String directions5 = "Please enter your guesses as characters, separated by spaces";
        int[] outputList = thisInput.getInputList(directions5, "Heads", "Tails", 'h', 't', 5);
        System.out.println("getInputList output: " + Arrays.toString(outputList));

        String direction6 = "Please enter your guesses as integers, separated by spaces";
        int[] outputArray = thisInput.getArrayInt(direction6, 1,10,5);
        System.out.println("getArrayInt output:" + Arrays.toString(outputArray));
    }
}

