import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import java.awt.event.*;
import java.util.*;
public class ClickListener extends JFrame implements MouseListener {

    ImageIcon flagIcon;
    JButton button;
    JButton button2;
    JLabel label1;

    public ClickListener() {

        

        flagIcon = new ImageIcon("flag.png");
        
        label1 = new JLabel(flagIcon);

        button = new JButton();
        button.setBounds(200, 100, 100, 50);
        for(int i = 0; i<200;i+=20){
            for(int j = 0; j<200;j+=20){
                
            }
        }
        button2 = new JButton();
        button2.setBounds(100,200,100,50);
        button2.addMouseListener(this);
        this.addMouseListener(this);
        
        this.setLayout(null);
        this.setSize(100,100);
        
        label1.setBounds(100,100,100,100);
        this.add(button);
        this.add(button2);
        this.add(label1);
        this.setVisible(true);

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
