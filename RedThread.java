import java.util.LinkedList;
import java.util.Random;

public class RedThread {

    private int num;
    private int numToPick;
    public int totalWins;
    public int totalGames;
    private GetInput input = new GetInput();
    LinkedList<Integer> bagOfThread = new LinkedList<Integer>;
    private Random rand = new Random();

    public RedThread(){

    }

    public void directions(){
        System.out.println("Directions here.");
    }
    public LinkedList getBag(LinkedList list){
        int numCol = 19;
        for(int i=0; i<numCol;i++){
            list.add(rand.nextInt(5));
        }
        list.add(6);
        return list;
    }

    public void launchGame(){
        directions();
        while(playGame()==1){}
    }

    public int playGame(){
        System.out.println("Try to pick out the Red Thread first!");
        numToPick = input.getInt("Enter how many Threads you'd like to pick at once: ",1,20);
        bagOfThread = getBag(bagOfThread);
        while(bagOfThread.size()>=numToPick){
            if(input.clickToContinue() == true){
                int counter = numToPick;
                int track = counter;
                int thread;
                for(int i=0; i<counter;i++) {
                    thread = bagOfThread.remove(rand.nextInt(track));
                    track--;
                    if(thread == 6){
                        totalWins++;
                        System.out.println("You Win!");
                    }
                }
            }

        }
        System.out.println("End of Game.");

        //ask to play again

        return input.getInt("Would you like to play again? \nEnter 1 to play Coin Toss again \nEnter 0 to return to main menu",0,1);
    }

}
