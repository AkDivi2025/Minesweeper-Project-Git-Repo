import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class ClickListener extends JFrame implements MouseListener {
    JButton button;
    JButton button2;
    public ClickListener() {

        button = new JButton();
        button.setBounds(200, 100, 100, 50);
        button.addMouseListener(this);
        button2 = new JButton();
        button2.setBounds(100,200,100,50);
        button2.addMouseListener(this);
        
        this.setLayout(null);
        this.setSize(100,100);
        this.setVisible(true);
        this.add(button);
        this.add(button2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            System.out.println("x is " + e.getX());
            System.out.println("y is " + e.getY());     
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        ClickListener minesweeper = new ClickListener();
    }
}
