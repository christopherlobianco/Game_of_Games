import java.util.Random;

public class EvenOdd{

private int guess;
private int userThrow;
private int compThrow;
public int totalGames;
public int totalWins;	
private int maxRounds=10;
private int lowThrow=1;
private int highThrow=5;
public String directions="Welcome to Even or Odd";
private GetInput input= new GetInput();
private Random rand= new Random();

public EvenOdd(){

}

public void launchGame(){
	System.out.println(directions);
	while(playGame()==1){ }

}

public int playGame(){
	//returns 1 if user would like to play again, 0 if not
	System.out.println("Let's play Even or Odd!");
	totalGames++;
	//get number of rounds
	int bestof=input.getInt(
		"Enter the number of rounds you'd like to play",
		1,
		maxRounds);
	//get guesses
	int[] guesses=input.getInputList("enter your guesses for each round in a space seperated list", 
		"enter e for even", 
		"enter o odd", 
		'o', 
		'e', 
		bestof);
	//play rounds
	for(int i=0; i<bestof;i++){
		//get user throw
		compThrow=rand.nextInt(highThrow)+1;
		System.out.print("The computer threw a ");
		System.out.println(compThrow);
		int userThrow= input.getInt(
			"Enter the number to throw.",
			lowThrow,
			highThrow);
		//generate computer throw
				//compare guess
		if(guesses[i]%2==(compThrow+userThrow)%2){
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
