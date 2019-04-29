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
public class GuessTheNumber{
  
    GetInput input= new GetInput();
   
    private int score=0;//averall score
    private int playerscore=0; //score for each guess
    private int compscore=0;
    private int rounds=0;//number of rounds played
    
    private int lowerBound; 
    private int upperBound;
    private int numGuesses;//number of guesses 
    
    private int[] guesses; //array with the guesses
    
    //Constructor
    public GuessTheNumber(){
     //directions
     System.out.println("Welcome to Guess The Number!");
     System.out.println("To play input a lower bound and an upper bound. ");
     System.out.println("Then enter the number of guesses you want to have");
     System.out.println("You will then input your integer guesses separated by a spaces");
     System.out.println(" ");
     
     lowerBound=getIntInput("lowerBound"); 
     upperBound=getIntInput("upperBound");
     numGuesses=getIntInput("numGuesses");  
     
    
    }
   
    /*
     * calls playGame and checks who won and updates the score     
     */ 
    public void launchGame(){     
      playGame();//loop through the array of guesses        
           
    }
    
    /*
     * checks if user guessed correctly 
     * @return:   int indicating who won
     */
    public int playGame(){
       getIntInput("guesses");
       Random r= new Random();
       int n=0;
       while(n<numGuesses){
         int guess=r.nextInt(((upperBound-lowerBound)+1)+lowerBound);
         System.out.println("Guessed: "+guesses[n]);
         System.out.println("Computer Number: "+guess);
         //correct guess
         if(guesses[n]==guess){
           
           playerscore++;
           if(playerscore>=((numGuesses/2)+1)){
             playerscore=0;
             compscore=0;
             score++;
             rounds++;
             System.out.println("You won this round");
             int replay=getIntInput("replay"); 
             if(replay==1){  
               lowerBound=getIntInput("lowerBound"); 
               upperBound=getIntInput("upperBound");
               numGuesses=getIntInput("numGuesses");
               launchGame();
               }
               else return 0;
           }
         }
         
         else{
           compscore++;        
           if (compscore>=((numGuesses/2)+1)){
              playerscore=0;
              compscore=0;
              rounds++;
             System.out.println("You lost this round"); 
             int replay=getIntInput("replay"); 
             if(replay==1){  
               lowerBound=getIntInput("lowerBound"); 
               upperBound=getIntInput("upperBound");
               numGuesses=getIntInput("numGuesses");
               launchGame();
             }
             else return 0;
           }
         }
         n++;
       }
       return 0;
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
        while((numGuesses<=0)||((numGuesses%2)==0)){
             numGuesses=input.getOddInt("Error, re-enter number of Guesses: ",lower,upper);
        }
        return numGuesses;
      }
      
      else if(var.equals("guesses")){
        int start=0;
        guesses=new int[numGuesses];
        System.arraycopy(input.getArrayInt("Enter your guesses ", lowerBound, upperBound),start, guesses,start,numGuesses-1);        
        while((numGuesses==0)||(guesses.length>numGuesses)||(numGuesses<guesses.length))
           System.arraycopy(input.getArrayInt("Error: re-enter your guesses ", lowerBound, upperBound),start, guesses,start,numGuesses-1);
        return 0;
      }
      else if(var.equals("replay")){
         String directions="Would you like to play again? ";
          String optionone="Enter 1 to play Guess the Number again, ";
          String optiontwo="Enter 0 to return to main menu";
        int toreturn=input.getBinaryInput(directions,optionone, optiontwo);
        while((toreturn<0)||(toreturn>1))       
          toreturn=input.getBinaryInput(directions,optionone,optiontwo);
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
