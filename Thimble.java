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
        System.out.println("Welcome to Find the Thimble! To play, you will" +
                " choose the 'Best out of Number'. You will hae to guess the" +
                " correct hand more than half of that number.");
    }

    public void launchGame(){
        directions();
        while(playGame()==1){}
    }

    public int playGame(){
        System.out.println("Guess which hand the Thimble is in!");
        bestoutof = input.getOddInt("Please choose the 'Best out of Number (this number should be an odd" +
                " number and not negative): ",1,1000);
        totalGames++;
        while(bestoutof>0){
            bestoutof--;
            guess = input.getBinaryInput("To choose a hand, input: ","'1' for Left", "'2' for Right",1,2);
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
