package pk;
import java.util.Arrays;
import java.util.Random;

public class Dice {

    protected Faces Dice() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];

    }

    protected void rollALL(Player player){           // reroll all dice
        for(int i = 0; i < 8; i++){
            player.array_of_faces[i] =  player.array_of_dice[i].Dice();
        }
    }

    protected void reRollSome(int again, Player player){                                // rerolling the dice for random strategy
        if(again <= 8-player.skulls_received()) {                                       //number of rerolls has to consider skulls
            for (int i = 0; i < 8; i++) {
                if ( (again > 0) && !(player.array_of_faces[i].equals(Faces.SKULL))) {  // if (again>0) and (not a skull)
                    player.array_of_faces[i] = player.array_of_dice[i].Dice();
                    again -= 1;                                                         //decrement with each iteration
                }
            }
        }
    }
    protected void rerollSomeSmart(int again, Player player){               // rerolling the dice while keeping the golds and diamonds (for combo strategy)
            for (int i = 0; i < 8; i++){
                if ( (again > 0) && !(player.array_of_faces[i].equals(Faces.SKULL)) && !(player.array_of_faces[i].equals(Faces.GOLD))
                        && !(player.array_of_faces[i].equals(Faces.DIAMOND)) && !(player.array_of_faces[i].equals(player.getMax_face()))) {    // if (again>0) and (not a skull) and (not a gold) and (not a diamond)and (not the most recurring face)
                    player.array_of_faces[i] = player.array_of_dice[i].Dice();
                    again -= 1;                                                     //decrement with each iteration
                }
            }
    }

    protected void reRollForMoreSabers(Player player){                                // rerolling the dice for random strategy
            for (int i = 0; i < 8; i++) {
                //reroll everything that is not a skull or a saber
                if ( (!(player.array_of_faces[i].equals(Faces.SKULL)))&& (!(player.array_of_faces[i].equals(Faces.SABER)))) {
                    player.array_of_faces[i] = player.array_of_dice[i].Dice();
                }
            }
        }

    protected void tracker(Player player){                                     // function to track faces
        player.tracking.clear();
        player.tracking.put(Faces.GOLD, 0);                                   //initializing all to zero because I want this function to not save previous results
        player.tracking.put(Faces.MONKEY, 0);
        player.tracking.put(Faces.DIAMOND, 0);
        player.tracking.put(Faces.SABER, 0);
        player.tracking.put(Faces.PARROT, 0);
        for ( Faces x : player.array_of_faces){                                // just increment to the faces
            player.tracking.compute(x, (key, val) -> (val==null) ? 1 : val+1);
        } player.finding_max_value();    // update the value that stores the most recurring face
    }

}
