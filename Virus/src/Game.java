import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    public static final int lineLength = 20, difficulty = 5; //TODO player and enemy speed relative to this
    public static final String TITLE = "Virus Alpha";
    public static final int WIDTH = 1200, HEIGHT = Math.round(WIDTH*9/16);

    private Thread thread;
    private boolean running = false;

    public static Handler handler = new Handler();

    public Game(){
        new Window(WIDTH, HEIGHT, TITLE, this);

        restart();
    }

    public static void win(){
        System.out.println("WIN");
        restart();
    }

    public static void lose(){
        System.out.println("LOSE");
        restart();
    }

    public static void restart(){
        handler.removeAll();
        handler.addObject(new Player(0, 0, ID.Player));
        handler.addObject(new Object(WIDTH - 110, HEIGHT - 140, ID.Object));
        handler.addObject(new Enemy(700, 100, ID.Enemy));
        handler.addObject(new Enemy(700, 500, ID.Enemy));
        handler.addObject(new Enemy(900, 400, ID.Enemy));
        handler.addObject(new Enemy(500, 600, ID.Enemy));
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if(running){
                try {
                    render();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();

    }

    private void render() throws IOException {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }
}
