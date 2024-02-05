import pk.Player;
import pk.Game;

public class PiratenKarpen {

    public static void main(String[] args) {
        int num_of_games = 45;
        System.out.println("Welcome to Piraten Karpen Simulator!");
        Player first_player;
        Player second_player;
        try{
            first_player = new Player(args[0]);
            second_player = new Player(args[1]);
        }catch(Exception e){
            first_player = new Player("combo");
            second_player = new Player("random");
        }
        if(System.getProperties().containsKey("TRACE")){                                     // check if you want to run it in trace mode
            for(int i = 0; i < num_of_games; i++) {
                Game.totrace = true;
                Game.playGame(first_player, second_player);
            }
        }
        else {
            for (int i = 0; i < 42; i++) {
                Game.totrace = false;
                Game.playGame(first_player, second_player);
            }
        }
        float playerA_wins = (float)(first_player.getWins()/(num_of_games*1.0) )*100;      // calculate percentage wins
        float playerB_wins = (float)(second_player.getWins()/(num_of_games*1.0) )*100;
        System.out.printf("Player 1 wins: %.2f%% games \n", playerA_wins);         // display percentage wins
        System.out.printf("Player 2 wins: %.2f%% games \n", playerB_wins);
        System.out.println("If the % dont add up the rest are ties");
        System.out.println("--------------END--------------");

    }

}

