package pk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Player extends Playturn implements Turn {

   final protected String strategy;
    private int score, wins;
    public Player(String strategy){
        this.strategy = strategy;
    }
    protected Dice[] array_of_dice = {new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice()};
    public Faces[] array_of_faces = new Faces[8];


    protected HashMap<Faces, Integer> tracking = new HashMap<>();     // this hashmap is used to track the faces in each roll
    private int max_value;         // this value stores the most recurring face in the dice
    private Faces max_face;       // this holds the most reoccurring face
    protected void finding_max_value(){                 // this function finds the most reoc
        max_value = 0;
        for(Integer i : this.tracking.values()){      // using a for each loop to iterate through the hashmap values
            if(i > max_value){                          // finding the max
                max_value = i;
            }
        }
        for(Entry<Faces, Integer> entry: tracking.entrySet()) {    // iterate through the loop and get most recurring face
            if(entry.getValue() == max_value) {
                max_face = entry.getKey();
                break;
            }
        }
    }

    protected int getMax_value(){
        return max_value;
    }

    protected Faces getMax_face(){
        return max_face;
    }

    public int getWins(){
        return this.wins;
    }

    protected void incrementWins(){
        this.wins += 1;
    }

    protected void resetScore() {
        this.score = 0;
    }

    protected void addScore(int addition){
        score += addition;
    }

    public int getScore() {
        return this.score;
    }

    protected int skulls_received(){
        int skullies = 0;
        for(int i = 0; i < this.array_of_dice.length; i++){
            if(this.array_of_faces[i].equals(Faces.SKULL)){
                skullies += 1;
            }
        }
        return skullies;
    }
    @Override
    public void playturn() {                        // to define which play a turn to use
        if(this.strategy.equals("random")){
            super.turn_random_strat(this);
        }
        else if(this.strategy.equals("combo")){
            super.turn_combo_strat(this);
        }
    }
}
