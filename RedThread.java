import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class RedThread {

    private int numToPick;
    public int totalWins;
    public int totalGames;
    public boolean turn;
    public boolean endGame = false;
    private GetInput input = new GetInput();
    LinkedList<Integer> bagOfThread = new LinkedList<Integer>();
    private Random rand = new Random();

    public RedThread(){

    }

    public void directions(){
        System.out.println("Welcome to Find the Red Thread!");
        System.out.println("You'll be pulling a number of spools of thread from a " +
                "basket of 20 spools in the hopes that you pull out the red one!");
    }
    public LinkedList getBag(LinkedList list){
        int numCol = 19;
        for(int i=0; i<numCol;i++){
            list.add(rand.nextInt(5));
        }
        list.add(6);
        return list;
    }

    private void showBag(LinkedList list){
        Iterator itlist = list.listIterator();
        System.out.println("What's in the bag: ");
        // print list with descending order
        while (itlist.hasNext()) {
            System.out.println(itlist.next());
        }
    }

    private boolean pickSpools(LinkedList list, int num,boolean turn){
        if((turn==false)||(input.clickToContinue("Click to pick spool") == true)){
            int counter = numToPick;
            int track = counter;
            int thread;
            if (turn == false){System.out.println("Computer is Picking...");}
            for(int i=0; i<counter;i++) {
                if (track>=list.size()){
                    return true;
                }
                else {
                    thread = bagOfThread.remove(rand.nextInt(track));
                    System.out.println(track + " " + thread);
                    track--;
                    if (thread == 6) {
                        return true;
                    }
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
        numToPick = input.getInt("Please Choose a number for each pull, " +
                "but make sure it's not more than 10",1,10);
        bagOfThread = getBag(bagOfThread);
        //showBag(bagOfThread);
        while((endGame==false)&&!bagOfThread.isEmpty()){
            turn=true;
            boolean result = pickSpools(bagOfThread,numToPick,turn);
            //showBag(bagOfThread);
            if(result==true){
                totalWins++;
                System.out.println("You got the Red Thread! You win this game!");
                endGame = true;
            }
            else{
                System.out.println("You didn't pick it!");
                turn=false;
                result = pickSpools(bagOfThread,numToPick,turn);
                //showBag(bagOfThread);
                if(result==true){
                    System.out.println("The computer picked it first! You lose this game.");
                    endGame = true;
                }
                else{
                    System.out.println("The computer didn't pick it!");
                }
            }
        }

        System.out.println("End of Game.");

        //ask to play again

        return input.getInt("Would you like to play again? \nEnter 1 to play Coin Toss again \nEnter 0 to return to main menu",0,1);
    }

//    public static void main(String args[]) {
//        RedThread RT = new RedThread();
//        RT.launchGame();
//    }

}
