/**
 * Created by Gold on 10/5/19.
 */
import java.awt.Color;
import java.awt.Graphics;

public class Food {

    private int width, height;
    private int xCoor;
    private int yCoor;

    public Food(int xCoor, int yCoor, int tileSize) {

        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }

    public void tick() {

    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xCoor * width, yCoor * height, width, height);

    }

    public int getxCoor() {         //getters and setters to access private variables in Screen class
        return xCoor;
    }

    public void setxCoor(int a) {
        xCoor = a;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int a) {
        yCoor = a;
    }
}

