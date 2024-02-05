package pk;

public class Scoring {

    // function to add 100 score for every gold or diamond
    protected void handleGold(Player player) {
        for (int i = 0; i < player.array_of_faces.length; i++) {
            if (player.array_of_faces[i].equals(Faces.GOLD) || player.array_of_faces[i].equals(Faces.DIAMOND)) {
                player.addScore(100);
            }
        }
    }

    protected boolean threeSkulls(Player player){
            if(player.skulls_received() >= 3){                  // if 3 or more skulls optained
                return true;
            }
            return false;
    }

    protected void handleCombos(Player player){         //COMBO scoring system
        int sum = 0;
        for(Integer x : player.tracking.values()){
            switch (x) {
                case 3:
                    sum+= 100;
                    break;
                case 4:
                    sum+= 200;
                    break;
                case 5:
                    sum+= 500;
                    break;
                case 6:
                    sum+= 1000;
                    break;
                case 7:
                    sum+= 2000;
                    break;
                case 8:
                    sum+= 4000;
                    break;
            }
        }
        player.addScore(sum);
    }

    protected void handleMonkeyBusiness(Player player){         //COMBO scoring system
        int sum = 0;
        int counter = 0;
        for(int i=0; i < 8; i++){
            if(player.array_of_faces[i].equals(Faces.PARROT) || player.array_of_faces[i].equals(Faces.MONKEY)){
                counter++;
            }
        }
            switch (counter) {
                case 3:
                    sum+= 100;
                    break;
                case 4:
                    sum+= 200;
                    break;
                case 5:
                    sum+= 500;
                    break;
                case 6:
                    sum+= 1000;
                    break;
                case 7:
                    sum+= 2000;
                    break;
                case 8:
                    sum+= 4000;
                    break;
            }
        player.addScore(sum);
    }
}
