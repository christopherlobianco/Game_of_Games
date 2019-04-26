import java.util.Random;

public class CoinToss{

private int choice;
private long flip;
public int totalGames;
public int totalWins;	
public String directions="Let's play coin toss";
private GetInput input= new GetInput();
private Random rand= new Random()

	public CoinToss(){

	}

	public void launchGame(){
		System.out.println(directions);
		while(playGame()==1){ }

	}

	public int playGame(){

		//get user choice
		totalGames++;
		choice = input.getBinaryInput("Enter your choice for the coin flip. ","0 for heads","1 for tails" );
		//flip coin
		flip=rand.nextInt(2);
		System.out.print("Coin landed on ");

		if (flip ==0 ){System.out.println("heads.");}
		else{System.out.println("tails.");}
		//check guess
		if(flip==choice){
			System.out.println("YOU WON");
			totalWins++;
		}
		else{
			System.out.println("YOU LOST");
		}
		//ask to play again
		return input.getBinaryInput("Would you like to play again?","Enter 1 to play Coin Toss again", "Enter 0 to return to main menu");

	}

}
