import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends GameObject{
    private BufferedImage img = null;
    private double rot = 0;
    private int lastX = 0, lastY = 0;


    public Player(int x, int y, ID id){
        super(x, y, id);
        try {
            img = ImageIO.read(this.getClass().getResourceAsStream("resources/usb.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        Move();
        Drawline();
    }

    public void Drawline() { //if player within fixed distance of previous line, make new
        if(Collision.distance(lastX, lastY, x, y) > Game.lineLength){
            Line.LineList.add(new Line(lastX, lastY, x, y, ID.Line));
            Game.handler.addObject(Line.LineList.get(Line.LineList.size()-1));

            //check if line can be cut
            overlap();

            lastX = x;
            lastY = y;
        }
    }

    public void render(Graphics g){
        AffineTransform tx = AffineTransform.getRotateInstance(rot, img.getWidth()/2, img.getHeight()/2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);


        g.drawImage(op.filter(img, null), this.x-img.getWidth()/2, this.y-img.getHeight()/2, null);
    }

    public void Move(){

        double dx = Math.abs(Mouse.X - x);
        double dy = Math.abs(Mouse.Y - y);
        double D = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        double speed = Math.pow(D, 1/2.0); //TODO speed relative to difficulty
        double Sx = Math.ceil(dx/(dx+dy) * speed);
        double Sy = Math.ceil(dy/(dx+dy) * speed);

        switch (quarter(Mouse.X, Mouse.Y, x, y)){
            case 0:
                if(Mouse.X == x && Mouse.Y == y){}
                else if(Mouse.X < x) {this.x -= Sx; rot = Math.PI*3/2;}
                else if(Mouse.X > x) {this.x += Sx; rot = Math.toRadians(90.0);}
                else if(Mouse.Y < y) {this.y -= Sy; rot = Math.PI * 2;}
                else if(Mouse.Y > y) {this.y += Sy; rot = Math.PI;}
                break;
            case 1:
                this.x += Sx;
                this.y -= Sy;
                rot = Math.PI/2 - Math.atan(dy/dx);
                break;
            case 2:
                this.x += Sx;
                this.y += Sy;
                rot = Math.PI/2 + Math.atan(dy/dx);
                break;
            case 3:
                this.x -= Sx;
                this.y += Sy;
                rot = Math.PI*1.5 - Math.atan(dy/dx);
                break;
            case 4:
                this.x -= Sx;
                this.y -= Sy;
                rot = Math.PI*1.5 + Math.atan(dy/dx);
                break;
        }
    }

    public static int quarter(int x1, int y1, int x2, int y2){
        if(x1 > x2 && y1 < y2) {return 1;}
        if(x1 > x2 && y1 > y2) {return 2;}
        if(x1 < x2 && y1 > y2) {return 3;}
        if(x1 < x2 && y1 < y2) {return 4;} else {return 0;}
    }

    public void overlap(){
        for(int i = 0; i < Line.LineList.size()-2; i++){ //cycle through to find if any lines intersect with newest one

            Line line = Line.LineList.get(i);
            int x1 = line.getX1();
            int y1 = line.getY1();
            int x2 = line.getX2();
            int y2 = line.getY2();

            //                       LINES
            //                Line(x1, y1, x2, y2)
            //                Player(x, y, lastX, lastY)

            if(doIntersect(x1, y1, x2, y2, x, y, lastX, lastY)){  //if lines intersect
                for(int j = i; j < Line.LineList.size()-2;){

                    //Remove previous lines until interception
                    Game.handler.removeObject(Line.LineList.get(i+1));
                    Line.LineList.remove(i+1);
                }

                //Get intersection point
                Point intersect = lineLineIntersection(x1, y1, x2, y2, x, y, lastX, lastY);

                //Modify lines to start/end at intersection point
                Game.handler.removeObject(Line.LineList.get(i));
                Line.LineList.get(i).setX2(intersect.x);
                Line.LineList.get(i).setY2(intersect.y);
                Game.handler.addObject(Line.LineList.get(i));

                Game.handler.removeObject(Line.LineList.get(i+1));
                Line.LineList.get(i+1).setX1(intersect.x);
                Line.LineList.get(i+1).setY1(intersect.y);
                Game.handler.addObject(Line.LineList.get(i+1));


            }
        }
    }

    static boolean onSegment(Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
            return true;

        return false;
    }

    static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0; // colinear

        return (val > 0)? 1: 2; // clock or counterclock wise
    }

    static boolean doIntersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // Find the four orientations needed for general and
        // special cases

        Point p1 = new Point(x1, y1);
        Point q1 = new Point(x2, y2);
        Point p2 = new Point(x3, y3);
        Point q2 = new Point(x4, y4);

        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4)
            return true;

        // Special Cases
        // p1, q1 and p2 are colinear and p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;

        // p1, q1 and q2 are colinear and q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;

        // p2, q2 and p1 are colinear and p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;

        // p2, q2 and q1 are colinear and q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false; // Doesn't fall in any of the above cases
    }

    static Point lineLineIntersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        Point A = new Point(x1, y1);
        Point B = new Point(x2, y2);
        Point C = new Point(x3, y3);
        Point D = new Point(x4, y4);

        // Line AB represented as a1x + b1y = c1
        double a1 = B.y - A.y;
        double b1 = A.x - B.x;
        double c1 = a1*(A.x) + b1*(A.y);

        // Line CD represented as a2x + b2y = c2
        double a2 = D.y - C.y;
        double b2 = C.x - D.x;
        double c2 = a2*(C.x)+ b2*(C.y);

        double determinant = a1*b2 - a2*b1;

        if (determinant == 0) {
            // The lines are parallel
            return new Point(0, 0);
        }
        else {
            int x = (int) Math.round((b2*c1 - b1*c2)/determinant);
            int y = (int) Math.round((a1*c2 - a2*c1)/determinant);
            return new Point(x, y);
        }
    }
}

class Point {
    int  x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}