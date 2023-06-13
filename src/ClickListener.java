import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import java.awt.event.*;
import java.util.*;
public class ClickListener extends JFrame implements MouseListener {

    private ImageIcon flagIcon;
    private ImageIcon mineIcon;
    private JButton button;
    private JButton button2;
    private JLabel label1;
    private MouseEvent click;
    private int[] coords = {-1, -1};

    public ClickListener() {
        this.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
        coords[0] = e.getX()/25;
        coords[1] = e.getY()/25;

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
    public int[] getCoords(){
        return coords;
        
    }
    public void setCoords(int num){
        coords[0]=num;
        coords[1]=num;
    }
    public MouseEvent getClick(){
        return click;
    }
}
