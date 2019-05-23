/**
 * Created by Gold on 10/5/19.
 */
import java.awt.GridLayout;
import javax.swing.*;


public class Frame extends JFrame{

    public Frame() {
        super("Snake");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();

    }

    public void init() {
        setLayout(new GridLayout(1,1,0,0));

        Screen s = new Screen();
        add(s);
        pack(); //causes window to fit all components perfectly, can change window size
        setLocationRelativeTo(null);  //centers the gui on the screen
        setVisible(true);

    }

    public static void main(String[] args) {
        new Frame();
    }

}
