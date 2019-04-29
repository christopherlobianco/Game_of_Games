import java.util.Random;

public class CoinToss{

private int choice;
private int flip;
public int totalGames;
public int totalWins;
private int maxRounds=10;	
private String[] faces={"h","t"};
public String directions="Welcome to Coin Toss";
private GetInput input= new GetInput();
private Random rand= new Random();

public CoinToss(){

}

public void launchGame(){
	System.out.println(directions);
	while(playGame()==1){
	}

}

public int playGame(){
	System.out.println("Let's play Coin Toss!");
	totalGames++;
	//get number of rounds
	int totalRounds=input.getOddInt(
		"Enter the number of rounds you'd like to play",
		1, //lowbound
		maxRounds); //highbound
	//get guesses
	int[] guesses=input.getInputList("enter your guesses for each round in a space seperated list", 
		"enter h for heads", 
		"enter t for tails", 
		'h', 
		't',
		totalRounds);
	//play rounds
	int round=0;
	int roundsWon=0;
	while(round<totalRounds && roundsWon<(totalRounds/2+1) ){
		//generate coin toss
		flip= rand.nextInt(2);
		//display flip result
		System.out.print("The coin landed on ");
		System.out.println(faces[flip]);
		//compare guess
		if(guesses[round]==flip){
			System.out.println("You Won this round!");
			roundsWon++;
		}
		else{
			System.out.println("You Lost this round");
		}
		round++;
		
	}

	//display game results
	System.out.println("End of Game.");
	if(roundsWon>(totalRounds/2)){
		System.out.println("You won the game.");
		totalWins++;
	}
	else{
		System.out.println("You lost the game.");
	}
	//ask to play again
	return input.getInt("Would you like to play again? \nEnter 1 to play Coin Toss again \nEnter 0 to return to main menu",0,1);

}




public static void main(String argv[]){
	CoinToss game= new CoinToss();
	game.launchGame();
	System.out.print("total wins ");
	System.out.println(game.totalWins);
	System.out.print("total games ");
	System.out.println(game.totalGames);
}
	

}
