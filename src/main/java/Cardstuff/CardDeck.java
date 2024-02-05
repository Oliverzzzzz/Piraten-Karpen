package Cardstuff;
import Cardstuff.Card;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {

    private Stack<Card> deck = new Stack<>();
    private int sabers_top;
    private int value_top;

    protected void fillDeck(){                             // fill the deck
        if (deck.empty()){                              // fill the deck only when empty
            for(int i = 0; i < 2; i++){                 // 6 sea battles        2 of each kind
                deck.push(new Card("Sea Battle", 2,-300));
                deck.push(new Card("Sea Battle",3,-500));
                deck.push(new Card("Sea Battle",4,-1000));
            }
            for(int r = 0; r < 4; r++){
                deck.push(new Card("Monkey Business", 0 , 0));
            }
            for(int x = 0; x < 25; x++){
                deck.push(new Card("nop",0,0));
            }
            Collections.shuffle(deck);                  // shuffle the deck
        }
    }

    public String drawCard(){
        this.fillDeck();                                // to make sure deck is not empty
        Card card = deck.peek();                        // get the top card
        String element = card.getFace();
        sabers_top = card.sabers;
        value_top = card.cost;
        deck.pop();                                     // remove the top card after seeing the element.
        return element;
    }

    public int getSabers_top(){
        return sabers_top;
    }

    public int getValue_top(){
        return value_top;
    }
}
