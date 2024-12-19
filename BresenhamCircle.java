
import java.awt.Graphics;
import javax.swing.JFrame;

public class BresenhamCircle extends JFrame{
    private int xc,yc,r;

    public BresenhamCircle(int xc,int yc,int r){
        this.xc = xc;
        this.yc = yc;
        this.r = r;
    }

    public void paint(Graphics g){
        drawCircle(g,xc,yc,r);
    }

    private void drawCircle(Graphics g,int xc,int yc,int r){
        int x = 0,y = r;
        int d = 3 - 2*r;

        while(x<=y){
            plotPoints(g,xc,yc,x,y);

            if(d<=0){
                d = d + 4*x + 6;
            }else{
                d = d+ 4*(x-y) + 10;
                y--;
            }
            x++;

        }
    }

    private void plotPoints(Graphics g,int xc,int yc,int x,int y){
        g.fillOval(xc + x,yc + y, 2, 2);
    }

    public static void main(String args[]){
        BresenhamCircle frame = new BresenhamCircle(120,230,250);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setVisible(true);
    }
}