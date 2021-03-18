import java.util.LinkedList;

public class Collision {

    public static void check(LinkedList<GameObject> object){
        for(int i = 0; i < object.size(); i++){ //check for player
            if(object.get(i).getId() == ID.Player){ //object.get(i) == player
                for(int j = 0; j < object.size(); j++) {
                    if(object.get(j).getId() == ID.Enemy){ // object.get(j) == all enemies
                        if(distance(object.get(i).getX(),
                                object.get(i).getY(),
                                object.get(j).getX(),
                                object.get(j).getY()) <= 50) {

                            Game.lose();
                        }
                    }
                    if(object.get(j).getId() == ID.Object){ // object.get(j) == all Objects(finish)
                        if(distance(object.get(i).getX(),
                                object.get(i).getY(),
                                object.get(j).getX(),
                                object.get(j).getY()) <= 60){ //if player within finish range
                            Game.win();
                        };
                    }
                }
            }
        }
    }

    public static int distance(int x, int y, int x1, int y1){
        int dx = x1 - x;
        int dy = y1 - y;
        return (int) Math.round(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }
}
