import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class SwingTest extends JFrame implements MouseListener {
    JFrame frame;
    JButton button;
    public SwingTest() {
        this.frame = new JFrame("minesweeper");
        frame.addMouseListener(this);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        this.button = new JButton("click me");
        button.setEnabled(true);
        button.setBounds(0,0,50, 50);
        frame.add(button);
    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent event) {
        
    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseClicked(MouseEvent event) {
        button.setVisible(false);
    }

    @Override
    public void mouseExited(MouseEvent event){
        
    }
    public static void main(String[] args) {
        SwingTest minesweeper = new SwingTest();
    }
}
