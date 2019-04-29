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
	int rounds=input.getOddInt(
		"Enter the number of rounds you'd like to play",
		1, //lowbound
		maxRounds); //highbound
	//get guesses
	int[] guesses=input.getInputList("enter your guesses for each round in a space seperated list", 
		"enter h for heads", 
		"enter t for tails", 
		'h', 
		't',
		rounds);
	//play rounds
	for(int i=0; i<rounds;i++){
		//generate coin toss
		flip= rand.nextInt(2)+1;
		//display result
		System.out.print("The coin landed on ");
		System.out.println(faces[flip]);
		//compare guess
		if(guesses[i]==flip){
			System.out.println("You Won!");
			totalWins++;
		}
		else{
			System.out.println("You Lost");
		}
		
	}
	System.out.println("End of Game.");
	//ask to play again
	return input.getInt("Would you like to play again? \nEnter 1 to play Coin Toss again \nEnter 0 to return to main menu",0,1);

}

	

}
