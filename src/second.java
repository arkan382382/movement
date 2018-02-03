import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class second extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);
    double x = 0, y = 0, velx = 0, vely = 0;

    public second(){
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(x,y,40,40));
    }

    public void actionPerformed(ActionEvent e){
        repaint();
        x += velx;
        y += vely;
        if(y == 0) vely = 1.5;
        if(y > 559) vely = -1.5;
        if(x == 0) velx = 1.5;
        if(x > 759) velx = -1.5;

    }

    public void up(){
        vely = -1.5;
        velx = 0;
    }
    public void down(){
        vely = 1.5;
        velx = 0;
    }
    public void left(){
        vely = 0;
        velx = -1.5;
    }
    public void right(){
        vely = 0;
        velx = 1.5;
    }
    public void up_and_left(){
        vely = -1.5;
        velx = -1.5;
    }

    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP){
            up();
        }
        if(code == KeyEvent.VK_DOWN){
            down();
        }
        if(code == KeyEvent.VK_LEFT){
            left();
        }
        if(code == KeyEvent.VK_RIGHT){
            right();
        }
        if(code == KeyEvent.VK_SPACE){
            up_and_left();
        }
    }

    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}

}
