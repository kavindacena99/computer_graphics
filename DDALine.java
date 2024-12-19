import java.awt.*;
import javax.swing.*;

public class DDALine extends JFrame {

    private int x1, y1, x2, y2;

    /*
     * public DDALine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
     */

    public DDALine(){
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DDALine");
        setVisible(true);
    }

    public void paint(Graphics g) {
        drawLine(g, 100, 100,300, 100);
        drawLine(g, 100, 100, 100, 200);
        drawLine(g, 300, 100, 300, 200);
        drawLine(g,300,200,100,200);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

       
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

     
        float xIncrement = dx / (float) steps;
        float yIncrement = dy / (float) steps;

        
        float x = x1, y = y1;

        for (int i = 0; i <= steps; i++) {
           
            g.fillOval(Math.round(x), Math.round(y), 2, 2);

           
            x += xIncrement;
            y += yIncrement;
        }
    }

    public static void main(String[] args) {
        DDALine frame = new DDALine();
    }
}