import java.awt.*;
import javax.swing.*;

public class Bresenham extends JFrame{
    private int x1,x2,y1,y2;

    public Bresenham(int x1,int y1,int x2,int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void paint(Graphics g){
        drawLine(g,x1,y1,x2,y2);
    }

    private void drawLine(Graphics g,int x1,int y1,int x2,int y2){
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1: -1;
        int sy = y1 < y2 ? 1: -1;

        boolean steep = dy > dx;

        if(steep){
            int temp = dx;
            dx = dy;
            dy = temp;
        }

        int p = 2*dy - dx;
        int x = x1, y = y1;

        for(int i=0;i<=dx;i++){
            if(steep){
                g.fillOval(y,x,2,2);
            }else{
                g.fillOval(x,y,2,2);
            }

            if(p>0){
                y+=sy;
                p-=2*dx;
            }
            p += 2*dy;
            x +=sx;
        }
    }

    public static void main(String args[]){
        int x1 = 100, y1 = 100;
        int x2 = 600, y2 = 400;

        Bresenham frame = new Bresenham(x1,y1,x2,y2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800,800);
        frame.setVisible(true);
    }
}