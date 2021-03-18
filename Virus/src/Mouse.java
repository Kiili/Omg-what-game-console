import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener, MouseListener{

    public static int X, Y;
    public static boolean hold = false;

    public void mouseDragged(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
    }

    public void mousePressed(MouseEvent e) {
        hold = true;
    }

    public void mouseReleased(MouseEvent e) {
        hold = false;
    }

    public void mouseClicked(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {

    }
}
