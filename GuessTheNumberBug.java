import java.util.*;
/*
 * A class for the game Guess the Number 
 * It implements the class getInput to get input
 * 
 * @author Mehluko Myanga
 * @version 1.1 04/27/19
 * @see GetInput
 * @see util.scanner
 */
public class GuessTheNumberBug{
  
   GetInput input= new GetInput();
   
    private int score=0;//averall score
    private int playerscore=0; //score for each guess
    private int rounds=0;//number of rounds played
    
    private int lowerBound=getIntInput("lowerBound"); 
    private int upperBound=getIntInput("upperBound");
    private int numGuesses=getIntInput("numGuesses");//number of guesses 
    
    private int[] guesses; //array with the guesses
    
    //Constructor
    public GuessTheNumberBug(){
      int tepm=getIntInput("guesses");
    
    }
   
    /*
     * calls playGuess and checks who won and updates the score
     * @return: int indicating whether to replay Guess the number
     */ 
    public int launch(){
      
      System.out.println("Welcome to Guess The Number!");
      System.out.println("To play input a lower bound and an upper bound. ");
      System.out.println("Then enter the number of guesses you want to have");
      System.out.println("You will then input your integer guesses separated by a spaces");
      System.out.println(" ");
      
      rounds++;
      int n=0; //num rounds played
      int compscore=0;
      while(n<numGuesses){
        System.out.println("player guessed: "+guesses[n]);
        if(playGuess(guesses[n])==1){//see input class
          playerscore++;
          if(playerscore>=((numGuesses/2)+1)){
             score++;
             System.out.println("You won this round");
             break;
          }
             
          else if (compscore>=((numGuesses/2)+1)){
            System.out.println("You lost this round"); 
            break;
          }
        }
        else{
          compscore++;
          if(playerscore>=((numGuesses/2)+1)){
             System.out.println("You won this round");
             break;
          }
          else if (compscore>=((numGuesses/2)+1)){
            System.out.println("You lost this round");
            break;
          }
        }
        n++;
      }
      return getIntInput("replay");
      
    }
    
    /*
     * checks if user guessed correctly 
     * @param: g, accepting the guess
     * @return:   int indicating who won
     */
    public int playGuess(int g){
       Random r= new Random();
       int guess=r.nextInt(((upperBound-lowerBound)+1)+lowerBound);
      System.out.println("computer number: "+guess);
      if(g==guess){
         int win=1;
         return win;}
      else{
        int lose=1;
         return lose;
      }
    }

    /*
     * gets input from the class getInput
     * @param: var, accepting the input message/directions
     * @return:   int, representing the int input specified by the user
     */ 
    public int getIntInput(String var){
      int lower=0;
      int upper=1000;
      if(var.equals("lowerBound")){
        lowerBound=input.getInt("Enter lower bound: ", lower, upper);
        return lowerBound;
      }
      else if(var.equals("upperBound")){
        upperBound=input.getInt("Enter upper bound: ",lower, upper);
        return upperBound;
      }
      else if(var.equals("numGuesses")){        
        numGuesses=input.getOddInt("Enter number of Guesses: ",lower,upper);        
        
        return numGuesses;
      }
      
      else if(var.equals("guesses")){
        int start=0;
        guesses=new int[numGuesses];
        System.arraycopy(input.getArrayInt("Enter your guesses", lowerBound, upperBound),start, guesses,start,numGuesses-1);       
        return 0;
      }
      else if(var.equals("replay")){
         String directions="Would you like to play again? ";
         String optionone="Enter 1 to play Guess the Number again, ";
         String optiontwo="Enter 0 to return to main menu";
        int toreturn=input.getBinaryInput(directions,optionone, optiontwo);        
        return toreturn;
      }
      return 0;
    }
    
    /*
     * to access the score
     * @return current score for Guesses the number
     */
    public int getScore(){
      return score;

    }

    /*
     * current number of rounds played
     * @return to access the number of rounds
     */
    public int getNumRounds(){
      return rounds;

    }
    
}