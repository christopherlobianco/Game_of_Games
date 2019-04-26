import java.util.Random;

public class EvenOdd{

private int guess;
private int userThrow;
private int compThrow;
public int totalGames;
public int totalWins;	
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

		//get user choice
		System.out.println("Let's play Even or Odd");
		totalGames++;
		guess = input.getBinaryInput("Enter your guess. ","0 for even","1 for odd" );
		//get user throw
		userThrow= input.getInt("Enter number to throw", 0,5);
		compThrow=rand.nextInt(6);
		//show result
		System.out.print("the computer threw a ");
		System.out.println(compThrow);
		if ((userThrow+compThrow)%2 == 0 ){
			System.out.print("the sum is even.");
		}
		else{System.out.print("the sum is odd.");}
		//show winner
		if ((userThrow+compThrow)%2 == guess ){
			System.out.println("YOU WON");
			totalWins++;
		}
		else{
			System.out.println("YOU LOST");
		}
		//ask to play again
		return input.getBinaryInput("Would you like to play again?","Enter 1 to play Even or Odd again", "Enter 0 to return to main menu");

	}

}
