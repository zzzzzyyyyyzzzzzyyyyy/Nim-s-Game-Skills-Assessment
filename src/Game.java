import java.util.Scanner;
public class Game {
    private int pieces;
    private Player play1;
    private Player play2;
    private Player currentPlayer;
    private Scanner read = new Scanner(System.in);

    //Sets up the game with a random amount of pieces between 10 and 50
    //Sets up the players so they can be accessed
    public Game(Player play1, Player play2){
        pieces = (int)(Math.random()*40+10);//To Do: Grab a random value between 10 and 50
        this.play1 = play1;
        this.play2 = play2;
    }

    //Allows a player to take a specific amount of pieces.
    //Adds the amount of pieces taken to the user's score.
    public int takePiece(){
        System.out.println("There are "+ pieces+" remaining!");
        int take = 0;
       //TO DO: Grab the user amount of pieces and repeat if it not allowed.
        while (!isLegal(take)){
            System.out.println("\nHow many pieces would you like to take? You may only take half or less than half of the number of pieces.");
            try{
                take = Integer.parseInt(read.nextLine());
            }
            catch(Exception e){
                take = 0;
            }
        }
        //TO DO: Adjust the pieces
        pieces -= take;

        System.out.println("There are "+ pieces+" remaining!");
        System.out.println("-----------------------");
        return take;
    }

    
    //**TO DO**//
    public Player getNextPlayer(){
    //Changes which players turn it is and returns the current player.
        if(currentPlayer == play1){
            currentPlayer = play2;
        }
        else{
            currentPlayer = play1;
        }
        return currentPlayer;
    }

    //Checks whether or not the user's requested move is allowed or not.
    public boolean isLegal(int x){

        //TO DO
        if(x == 1 && pieces == 1){
            return true;
        }
        if(x > Math.floor(pieces/2)){
            return false;
        }
        if(x <= 0){
            return false;
        }    

        return true;// Change appropriately
    }


    //DO NOT CHANGE
    public boolean isComplete(){
        if (pieces == 0){ return true;}
        return false;
    }

    //DO NOT CHANGE
    public void setFirstPlayer(Player p){
        currentPlayer = p;
    }

    public Player getFirstPlayer(){
        return currentPlayer;
    }
}
