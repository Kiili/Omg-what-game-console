import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy extends GameObject{
    private BufferedImage img = null;

    public Enemy(int x, int y, ID id) {
        super(x, y, id);

        try { //TODO different colors for different viruses
            img = ImageIO.read(Game.class.getResourceAsStream("resources/virus_255.png"));
        } catch (IOException e) {
        }
    }

    @Override
    public void tick() {
        move();
    }

    public void render(Graphics g) { //110x50 img
        g.drawImage(img, this.x-55, this.y-25, null);
    }

    public void move() { //TODO search for nearest line & set movespeed relative to difficulty
        int nearX = 0, nearY = 0, nearD = Game.WIDTH+Game.HEIGHT;
        boolean mouse = false;

        for(int i = 0; i < Line.LineList.size(); i++){ //search for nearest start of a line
            int d = Collision.distance(x, y, Line.LineList.get(i).getX1(), Line.LineList.get(i).getY1());
            if(nearD > d){
                nearD = d;
                nearX = Line.LineList.get(i).getX1();
                nearY = Line.LineList.get(i).getY1();
            }
        }

        if(Mouse.hold && nearD > Game.lineLength/2 + 1){
            for(int i = 0; i < Game.handler.object.size(); i++){
                GameObject player = Game.handler.object.get(i);
                if(player.getId() == ID.Player){
                    nearX = player.getX();
                    nearY = player.getY();
                }
            }
            mouse = true;
        }


        double dx = Math.abs(nearX - x);
        double dy = Math.abs(nearY - y);
        double D = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        double speed;
        if(mouse){//TODO speed relative to difficulty
            speed = Math.pow(D, 1/2.0);
        }else{
            speed = Math.pow(D, 1/4.1);
        }
        double Sx = Math.ceil(dx/(dx+dy) * speed);
        double Sy = Math.ceil(dy/(dx+dy) * speed);

        switch (Player.quarter(nearX, nearY, x, y)){
            case 0:
                if(nearX == x && nearY == y){ //LOSE
                    Game.lose();
                }
                else if(nearX < x) {this.x -= Sx;}
                else if(nearX > x) {this.x += Sx;}
                else if(nearY < y) {this.y -= Sy;}
                else if(nearY > y) {this.y += Sy;}
                break;
            case 1:
                this.x += Sx;
                this.y -= Sy;
                break;
            case 2:
                this.x += Sx;
                this.y += Sy;
                break;
            case 3:
                this.x -= Sx;
                this.y += Sy;
                break;
            case 4:
                this.x -= Sx;
                this.y -= Sy;
                break;
        }
    }
}
