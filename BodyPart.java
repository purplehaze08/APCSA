/**
 * Created by Gold on 10/5/19.
 */

import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {
    private int xCoor, yCoor, width, height;

    public BodyPart(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;


    }

    public void tick() {  //for updating

    }

    public void draw(Graphics g) {   //for drawing

        g.setColor(Color.BLACK);
        g.fillRect(xCoor * width, yCoor * height, width , height); //makes rect that is tileSize x tileSize.
        g.setColor(Color.GREEN); 								   //Coor is * width since it represents grid coordinate not pixels
        g.fillRect(xCoor*width + 2, yCoor*height + 2, width - 3, height - 3); //makes smaller green rect on the black
        //+2 so the rect is placed under black outline

    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

}
