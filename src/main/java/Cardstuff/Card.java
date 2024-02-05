package Cardstuff;

public class Card {
    final String face;
    final int sabers;

    final int cost;
    protected Card(String face, int amount_of_sabers, int value){
        this.face = face;
        this.sabers = amount_of_sabers;
        this.cost = value;
    }

    protected String getFace(){
        return this.face;
    }
}
