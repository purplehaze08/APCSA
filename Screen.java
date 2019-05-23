/**
 * Created by Gold on 10/5/19.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; //"Listens" to keyboard
import java.util.ArrayList;

public class Screen extends JPanel implements Runnable{

    static final int WIDTH = 800; //final means variable cannot change after initializing
    static final int HEIGHT = 800;
    boolean running = false;
    Thread thread;

    private BodyPart b; //object body part
    private ArrayList<BodyPart> snake; //arraylist of bodyparts, since we need to modify array size

    private Food food;
    private ArrayList<Food> foods;

    private int xCoor = 10;   //head of the snake
    private int yCoor = 10;   //number is 10 to represent coordinate on grid, not pixel

    private int size = 5; //size of snake

    private boolean right = true, left = false, up = false, down = false;  //direction booleans tells snake where to move
    private int ticks = 0;

    private Key key;

    public Screen() {
        setFocusable(true);  //not sure what it does but it focuses on one JPanel component.
        key = new Key();
        addKeyListener(key); //adds Key object as listener
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        snake = new ArrayList<BodyPart>();
        foods = new ArrayList<Food>();

        startGame();
    }

    public void tick() {
        if(snake.size() == 0) { //starts off with 1 pixel of snake
            b = new BodyPart(xCoor, yCoor, 10);  //init bodyparts, which is 10x10 pixel
            snake.add(b); //adds b to the list
        }

        if(foods.size() == 0) {

            food = new Food((int)(Math.random()*80), (int)(Math.random()*80), 10);  //creates food in random location
            foods.add(food);
        }

        for(int i = 0; i < foods.size(); i++) {
            if(foods.get(i).getxCoor() == xCoor && foods.get(i).getyCoor() == yCoor) {
                foods.remove(i);
                size++;
                i--;
            }
        }


        ticks++; //this is to keep track of ticks
        if(ticks > 250000) { //the 250000 dictates game speed, direction code is executed every 250000 ticks
            if(right) xCoor++;  //if user is pressing on the direction, xCoor + 1
            if(left) xCoor --;
            if(up) yCoor --;
            if(down) yCoor ++;

            ticks = 0;

            if(xCoor > 79) {
                xCoor = 0;
            }

            if(xCoor < 0) {
                xCoor = WIDTH/10;
            }

            if(yCoor > 79) {
                yCoor = 0;
            }

            if(yCoor < 0) {
                yCoor = HEIGHT/10;
            }

            for(int i=0; i<foods.size(); i++) {
                if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {  //checks for overlap
                    if(i != snake.size() - 1) {  //checks for the head
                        stop();
                    }
                }
            }

            b = new BodyPart(xCoor, yCoor, 10);  //every 250000 ticks, another bodypart is added with new xyCoor
            snake.add(b);


            if(snake.size() > size) {
                snake.remove(0); //if snake array is bigger than size of snake, then remove the first bodypart made.

            }
        }
    }

    public void paint(Graphics g) {  //make a grid
        g.clearRect(0, 0, WIDTH, HEIGHT); //clears the grid before adding gridlines and everything

        g.setColor(Color.BLACK);
        for(int i = 0; i < WIDTH/10; i++) {   //since tileSize will be 10, we want every 10th pixel to be a line for grid
            g.drawLine(i * 10, 0, i * 10, HEIGHT); //i*10 since we are drawing a line every 10 pixels
        }

        for(int i = 0; i < HEIGHT/10; i++) {
            g.drawLine(0, i * 10, WIDTH, i * 10); //now we are drawing the horizontal grid lines
        }

        for(int i = 0; i < snake.size(); i++) {

            snake.get(i).draw(g); //snake.get(i) gets the bodypart from list and draw(g) calls the draw method in BodyPart

        }

        for(int i = 0; i < foods.size(); i++) {
            foods.get(0).draw(g);
        }

    }

    public void startGame() {
        running = true;
        thread = new Thread(this, "Game Loop");  //another thread constructor where its (Runnable, String name)
        thread.start();

    }

    public void stop() {
        running = false;
        try {
            thread.join();  //waits for thread to die
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void run() {
        while(running) {
            tick();  //what happens every tick
            repaint();  //repaints snake game
        }
    }

    private class Key implements KeyListener {  //this is an inner class

        public void keyPressed(KeyEvent e) {  //similar to actionEvent
            int key = e.getKeyCode();  //e is the keyPressed, whose KeyCode is stored as key

            if(key == KeyEvent.VK_RIGHT && !left) {  // !left is to make sure snake doesn't eat itself by turning 180
                right = true;
                up = false;
                down = false;
            }

            if(key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }

            if(key == KeyEvent.VK_UP && !down) {
                up = true;
                left = false;
                right = false;
            }

            if(key == KeyEvent.VK_DOWN && !up) {
                down = true;
                left = false;
                right = false;
            }
        }

        public void keyReleased(KeyEvent arg0) {

        }

        public void keyTyped(KeyEvent arg0) {   //used when you want to know when user presses any particular key

        }
    }
}
