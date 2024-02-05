package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Game {
    private static final Logger logger = LogManager.getLogger(Game.class);
    public static boolean totrace;

    public static void playGame(Player player1, Player player2){
        while(player1.getScore() < 6000 && player2.getScore() < 6000){              // loop keeps on running as long as both players are below 6000
            player1.playturn();                                   // calling turn method which controls which strategy to use
            player2.playturn();
            tracer(totrace,Arrays.toString(player1.array_of_faces));
            tracer(totrace,Arrays.toString(player2.array_of_faces));
            tracer(totrace,"Player ONE score: " + player1.getScore());
            tracer(totrace,"Player TWO score: " + player2.getScore());
            if(player2.getScore() >= 6000 && player1.getScore() < 6000){                // if player 2 reaches 6000 before player 1, then player 1 will have one more turn as per rules
                player1.playturn();
                tracer(totrace, "Player ONE score: " + player1.getScore());
                break;                                                                  // player one plays turn then look breaks
            }
            tracer(totrace, "Player ONE score: " + player1.getScore());
            tracer(totrace,"Player TWO score: " + player2.getScore());
        }
        tracer(totrace, "Player ONE FINAL score: " + player1.getScore());
        tracer(totrace,"Player TWO FINAL score: " + player2.getScore());

        if(player1.getScore() > player2.getScore()){            // if player 1 > player 2
            tracer(totrace, "Player 1 won this game");
            player1.incrementWins();
        }
        else if (player2.getScore() > player1.getScore()){          // if player 2 > player 1          // tie is possible (some games end as ties thats why the % doesn't always add up to 100%)
            tracer(totrace, "Player 2 won this game");
            player2.incrementWins();
        }
        player1.resetScore();
        player2.resetScore();
        tracer(totrace ,"Player 1 wins " + player1.getWins());
        tracer(totrace , "Player 2 wins " + player2.getWins());
    }

    // game testing with on debugmode ---give me a good grade if you notice the 'overwatch' reference :)
    private static void tracer(boolean totrace, String phrase){
        if(totrace){
            logger.info(phrase);
        }
    }
}
