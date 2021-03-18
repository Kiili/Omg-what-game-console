import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        Collision.check(object);
        for (int i = 0; i < object.size(); i++){
            object.get(i).tick();
        }
    }

    public void render(Graphics g) throws IOException {
        for (int i = 0; i < object.size(); i++){
            object.get(i).render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public void removeAll(){
        object.removeAll(object);
    }
}
