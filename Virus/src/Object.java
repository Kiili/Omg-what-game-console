import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Object extends GameObject {

    private BufferedImage img, img1 = null;

    public Object(int x, int y, ID id){
        super(x, y, id);

        try { //TODO different colors for different viruses
            img = ImageIO.read(Game.class.getResourceAsStream("resources/laptop.png"));
            img1 = ImageIO.read(Game.class.getResourceAsStream("resources/laptop1.png"));
        } catch (IOException e) {
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) { //179x163 imgs

        if(System.currentTimeMillis() % 2000 > 1000){ //cycle "insert usb" image every 1second
            g.drawImage(img, x - 178/2, y - 162/2, null);
        }else{
            g.drawImage(img1, x - 178/2, y - 162/2, null);
        }


    }

}
