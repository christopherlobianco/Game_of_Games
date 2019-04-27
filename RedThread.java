import java.util.LinkedList;
import java.util.Random;

public class RedThread {

    private int numToPick;
    public int totalWins;
    public int totalGames;
    public boolean turn;
    private GetInput input = new GetInput();
    LinkedList<Integer> bagOfThread = new LinkedList<Integer>;
    private Random rand = new Random();

    public RedThread(){

    }

    public void directions(){
        System.out.println("Welcome to Find the Red Thread!");
        System.out.println("You'll be pulling a number of spools of thread from a basket of 20 spools in the hopes that you pull out the red one!");
    }
    public LinkedList getBag(LinkedList list){
        int numCol = 19;
        for(int i=0; i<numCol;i++){
            list.add(rand.nextInt(5));
        }
        list.add(6);
        return list;
    }

    private boolean pickSpools(LinkedList list, int num,boolean turn){
        if((input.clickToContinue("Click to pick spool.") == true)||(turn==false)){
            int counter = numToPick;
            int track = counter;
            int thread;
            for(int i=0; i<counter;i++) {
                thread = bagOfThread.remove(rand.nextInt(track));
                track--;
                if (thread == 6) {
                    return true;
                }
            }
        }
        return false;
    }

    public void launchGame(){
        directions();
        while(playGame()==1){}
    }

    public int playGame(){
        totalGames++;
        numToPick = input.getInt("Please Choose a number for each pull, but make sure it's not more than 10: ",1,10);
        bagOfThread = getBag(bagOfThread);
        while(!bagOfThread.isEmpty()){
            turn=true;
            boolean result = pickSpools(bagOfThread,numToPick,turn);
            if(result==true){
                totalWins++;
                System.out.println("You got the Red Thread!");
            }
            else{
                turn=false;
                result = pickSpools(bagOfThread,numToPick,turn);
                if(result==true){
                    System.out.println("The computer picked it first!");
                }
            }
        }

        System.out.println("End of Game.");

        //ask to play again

        return input.getInt("Would you like to play again? \nEnter 1 to play Coin Toss again \nEnter 0 to return to main menu",0,1);
    }

}
