package pk;
import java.util.Random;

public class Strategy {
    Random random = new Random();
    protected boolean initialStrategyReroll(){         // Initial strategy to reroll or not to reroll
        int x = random.nextInt(100)+1;         // "+1" so that zero isn't considered
        if(x <= 50){                                 // 50% chance of rerolling
            return true;
        }
        return false;
    }

    protected int initialStrategyNumber(Player player){              //picking the number of dice to reroll
        int lowerBound = 2;
        int upperBound = 8 - player.skulls_received();
        int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound + 1 ;
        return randomNumber;
    }


    protected boolean comboStrategyReroll(Player player){                // Combo strategy to reroll or not to reroll
        int percentage = 60;                                            // 60% chance of reroll if no combos exists
        int x = random.nextInt(100)+1;

        switch (player.getMax_value()) {
            case 3:
                percentage = 35;          // if a combo of 3 exists 35% chance of reroll
                break;
            case 4:
                percentage = 25;          // if a combo of 4 exists 25% chance of reroll
                break;
            case 5:
                percentage = 10;          // if a combo of 5 exists 10% chance of reroll
                break;
            case 6:
                percentage = 3;           // if a combo of 6 exists 3% chance of reroll
                break;
            case 7:
                percentage = 1;           // if a combo of 7 exists 1% chance of reroll
                break;
            case 8:
                percentage = 0;           // if a combo of 8 exists 0% chance of reroll
                break;
        }
        if(x <= percentage){              // checks random integer between 1-100
            return true;
        }
        else {
            return false;
        }
    }

    protected int comboStrategyNumber(Player player){              //picking the number of dice to reroll for combo strategy
        int upperBound = 0;
        int lowerBound = 2;
        if(!(player.getMax_face().equals(Faces.GOLD)) && !(player.getMax_face().equals(Faces.DIAMOND)) ) {          // if most recurring face is not gold or diamond
            upperBound = 8 - player.skulls_received() - player.tracking.get(Faces.GOLD) - player.tracking.get(Faces.DIAMOND) - player.getMax_value();
        }
        else{
            upperBound = 8 - player.skulls_received() - player.tracking.get(Faces.GOLD) - player.tracking.get(Faces.DIAMOND);       // if most recurring face is gold or diamond (so that I do not subtract twice)
        }
        int x = upperBound - lowerBound;
        if(x<1){              // random number has to be between positive
            x = 1;
        }

        int randomNumber = random.nextInt(x) + lowerBound + 1 ;   // random number between 2 and 8 - golds, diamonds, and most reoccuring face
        return randomNumber;
    }


}
