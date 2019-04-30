import java.util.concurrent.ThreadLocalRandom;

public class ThimbleTest {

    private int guess;
    public int totalWins;
    public int totalGames;
    private int randcomp=2;
    private int bestoutof;
    private GetInput input = new GetInput();

    public ThimbleTest(){
    }

    public void directions(){
        System.out.println("Welcome to Find the Thimble! To play, you will" +
                " choose the 'Best out of Number'. You will have to guess the" +
                " correct hand more than half of that number.");
    }

    public void launchGame(){
        directions();
        while(playGame()==1){}
    }

    public int playGame(){
        System.out.println("Guess which hand the Thimble is in!");
        bestoutof = input.getOddInt("Please choose the 'Best out of Number (this number should be an odd" +
                " number and not negative)",1,1000);
        int totalGuesses = bestoutof;
        totalGames++;
        int numberWon = 0;
        while(bestoutof>0){
            bestoutof--;
            int computer = ThreadLocalRandom.current().nextInt(1,3);
            System.out.println("{The computer will pick: "+ computer + "}");
            guess = input.getBinaryInput("To choose a hand, input: ","'1' for Left", "'2' for Right",'1','2');
            if (guess == computer){
                System.out.println("You chose wisely!");
                numberWon++;
            }
            else {
                System.out.println("Wrong!");
            }
        }
        if(numberWon > (totalGuesses-numberWon)) {
            totalWins++;
            System.out.println("You have won this game of Find the Thimble");
        } else {
            System.out.println("You have lost this game of Find the Thimble");
        }
        System.out.println("End of Game.");

        //ask to play again

        return input.getInt("Would you like to play again? \nEnter 1 to play Find the Thimble again \nEnter 0 to return to main menu",0,1);
    }

//    public static void main(String args[]) {
//        Thimble thim = new Thimble();
//        thim.launchGame();
//    }
}
