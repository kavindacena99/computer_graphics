import java.awt.*;
import javax.swing.*;

public class Robo extends JFrame {

    private int x, y;

    public Robo(){
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DDALine");
        setVisible(true);
    }

    public void paint(Graphics g) {
        drawRect(g, 100,100 ,200 ,100 );
        drawRect(g, 240,200 ,20 ,100 );

    }

    private void drawRect(Graphics g,int x,int y,int w,int h){
        drawLine(g,x,y,x+w,y);
        drawLine(g,x,y,x,y+h);
        drawLine(g,x,y+h,x+w,y+h);
        drawLine(g,x+w,y,x+w,y+h);
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
        Robo frame = new Robo();
    }
}