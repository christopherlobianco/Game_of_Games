import java.util.Random;

public class Thimble {

    private int guess;
    public int totalWins;
    public int totalGames;
    private int randcomp=1;
    private int bestoutof;
    private GetInput input = new GetInput();
    private Random rand = new Random();

    public Thimble(){

    }

    public void directions(){
        System.out.println("Directions here.");
    }

    public void launchGame(){
        directions();
        while(playGame()==1){}
    }

    public int playGame(){
        System.out.println("Guess which hand the Thimble is in!");
        bestoutof = input.getOddInt("Enter the best out of number of games you would like to play: ",1,1000);
        while(bestoutof>0){
            bestoutof--;
            totalGames++;
            guess = input.getBinaryInput("Pick which hand you think the thimble is in: ","'0' for Left", "'1' for Right",0,1);
            if (guess == rand.nextInt(randcomp)){
                System.out.println("You chose wisely!");
                totalWins++;
            }
            else {
                System.out.println("Wrong!");
            }
        }
        System.out.println("End of Game.");

        //ask to play again

        return input.getInt("Would you like to play again? \nEnter 1 to play Coin Toss again \nEnter 0 to return to main menu",0,1);
    }
}
