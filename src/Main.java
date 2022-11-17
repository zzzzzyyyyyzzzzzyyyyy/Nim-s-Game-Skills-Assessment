import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);

        //Asks the user to input thier name for the player
        System.out.println("What is player1's name?: ");
        //TO DO: Create Player 1
        String name = read.nextLine();
        Player play1 = new Player(name);
        //Asks the user to input their name for the player.
        System.out.println("What is player2's name?: ");
        //TO DO: Create Player 2
        name = read.nextLine();
        Player play2 = new Player(name);

        String again = "Literally any string";
        Player currentPlayer;
        
        //Runs the game
        while (!again.equals("q")){
            //Generates the game
            //TO DO: Create "game"
            Game Game = new Game(play1, play2);
            //TO DO: Set the a random player as the current player
            int num = (int)(Math.random()*2);
            if(num == 0){
                Game.setFirstPlayer(play1);
            }
            else if(num == 1){
                Game.setFirstPlayer(play2);
            }

            currentPlayer = Game.getFirstPlayer();
            
            //This is the loop in which the game will be played
            while(!Game.isComplete()){
                //TO DO
                System.out.println("It is " + String.valueOf(currentPlayer.getName()) + "'s turn.");
                //int takes = Game.takePiece();
                int takes = Game.takePiece();
                currentPlayer = Game.getNextPlayer();
                if(currentPlayer == play1){
                    play1.adjustScore(takes);
                }
                else{
                    play2.adjustScore(takes);
                }
                
                if(Game.isComplete() == true){
                    break;
                }
            }
            System.out.println(currentPlayer.getName()+ " Won!!");
            System.out.println(play1.getName() +" had removed "+ play1.getScore()+" pieces!");
            System.out.println(play2.getName() +" had removed "+ play2.getScore()+" pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = read.nextLine();
        }
        System.out.println("Thank you for playing!");
    }
}
