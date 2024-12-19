
import java.awt.Graphics;
import javax.swing.JFrame;

public class MidpointCircle extends JFrame{
    private int xc,yc,r;

    /*
     * public MidpointCircle(int xc,int yc,int r){
        this.xc = xc;
        this.yc = yc;
        this.r = r;
    }
     */

    public MidpointCircle(){
        setSize(800,800);
        setTitle("Midpoint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g){
        drawCircle(g,200,200,100);
        drawCircle(g,200,200, 50);
    }

    private void drawCircle(Graphics g,int xc,int yc,int r){
        int x = 0,y = r;
        int d = 1-r;

        while(x<=y){
            plotPoints(g,xc,yc,x,y);

            if(d<=0){
                d = d + 2*x + 3;
            }else{
                d = d+ 2*(x-y) + 5;
                y--;
            }
            x++;

        }
    }

    private void plotPoints(Graphics g,int xc,int yc,int x,int y){
        g.fillOval(xc + x,yc + y, 2, 2);
        g.fillOval(xc + x,yc - y, 2, 2);
        g.fillOval(xc - x,yc + y, 2, 2);
        g.fillOval(xc - x,yc - y, 2, 2);
        g.fillOval(xc + y,yc + x, 2, 2);
        g.fillOval(xc + y,yc - x, 2, 2);
        g.fillOval(xc - y,yc + x, 2, 2);
        g.fillOval(xc - y,yc - x, 2, 2);
    }

    public static void main(String args[]){
        MidpointCircle frame = new MidpointCircle();

        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(800,800);
        //frame.setVisible(true);
    }
}