import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Line extends GameObject{

    public static ArrayList<Line> LineList = new ArrayList<Line>();

    public Line(int x1, int y1, int x2, int y2, ID id) {
        super(x1, y1, x2, y2, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) throws IOException {
        g.setColor(new Color(255, 0, 0, 50));
        g.drawLine(x1, y1, x2, y2);
    }
}
