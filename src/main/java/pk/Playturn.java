package pk;
import Cardstuff.CardDeck;


public class Playturn {
    Scoring score_manager = new Scoring();
    Strategy strategy_Manager = new Strategy();

    Dice dice_manager = new Dice();
    CardDeck cardDeck = new CardDeck();

    public void turn_random_strat(Player player) {          // this is the method for running one turn
        dice_manager.rollALL(player);                       // turn starts by rolling all 8 dice
        dice_manager.tracker(player);
        String topcard = cardDeck.drawCard();
        if (cardDeck.drawCard().equals("Sea Battle")){
            //keep on looping until the player gets 3 skulls or more sabers than required
            while((!(score_manager.threeSkulls(player)))&& (player.tracking.get(Faces.SABER))< cardDeck.getSabers_top()){
                dice_manager.reRollSome(strategy_Manager.initialStrategyNumber(player),player);   // smarter reroll for combo player and random reroll for random player
                dice_manager.tracker(player);                                                   // update face tracking   //dice.tracker gets the configuration of the dice so it tells the computer in a hashmap if I have 2 gold 3 monkey etc...
            }
            if(((player.tracking.get(Faces.SABER)) >= cardDeck.getSabers_top()) && (!(score_manager.threeSkulls(player)))){  // if number of sabers is achieved and I don't have 3 or more skulls
                player.addScore(-1*cardDeck.getValue_top());      // add the reward
                return;
            }
            else{
                player.addScore(cardDeck.getValue_top());    // subtract the cost
                return;
            }
        }
        while (!(score_manager.threeSkulls(player))) {                 // keep on playing while skulls received method returns false    (this method checks for 3 skulls and returns true if 3 skulls are found)
            dice_manager.tracker(player);                                        //dice.tracker gets the configuration of the dice so it tells the computer in a hashmap if I have 2 gold 3 monkey etc...
            if (strategy_Manager.initialStrategyReroll()) {                         // initial strategy to reroll or not to reroll
                dice_manager.reRollSome(strategy_Manager.initialStrategyNumber(player),player);   // if reroll is allowed how many dice should I reroll
            }
            else{                                                          // if no reroll then break and end turn
                break;
            }
        }
        dice_manager.tracker(player);
        if(!(score_manager.threeSkulls(player))){                      // if less than three skulls
            if(topcard.equals("Monkey Business")){              // if monkey business card is present
                score_manager.handleMonkeyBusiness(player);
            }
            score_manager.handleGold(player);                          // Add points of (gold and diamond) to score
            score_manager.handleCombos(player);                        // Add points of combos
        }
    }

    public void turn_combo_strat(Player player) {
        dice_manager.rollALL(player);
        dice_manager.tracker(player);
        String topcard = cardDeck.drawCard();
        if (topcard.equals("Sea Battle")){
            //keep on looping until the player gets 3 skulls or more sabers than required
            while((!(score_manager.threeSkulls(player)))&& (player.tracking.get(Faces.SABER))< cardDeck.getSabers_top()){
                dice_manager.reRollForMoreSabers(player);   // smarter reroll for combo player and random reroll for random player
                dice_manager.tracker(player);
            }
            if(((player.tracking.get(Faces.SABER)) >= cardDeck.getSabers_top()) && (!(score_manager.threeSkulls(player)))){  // if number of sabers is achieved and I don't have 3 or more skulls
                player.addScore(-1*cardDeck.getValue_top());      // add the reward
                return;
            }
            else{
                player.addScore(cardDeck.getValue_top());    // subtract the cost
                return;
            }
        }
        while (!(score_manager.threeSkulls(player))) {
            dice_manager.tracker(player);
            if (strategy_Manager.comboStrategyReroll(player)) {         // to reroll or not using combo strategy odds
                dice_manager.rerollSomeSmart(strategy_Manager.comboStrategyNumber(player),player);    // using combo strategy to choose amount of dice to reroll
            }
            else{                   // if player doesn't reroll then break and start calculatig score
                break;
            }
        }
        dice_manager.tracker(player);
        if(!(score_manager.threeSkulls(player))){
            if(topcard.equals("Monkey Business")){              // if monkey business card is present
                score_manager.handleMonkeyBusiness(player);
            }
            score_manager.handleGold(player);
            score_manager.handleCombos(player);
        }
    }
}
