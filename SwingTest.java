import javax.swing.*;
import java.awt.*;
public class SwingTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("minesweeper");
        frame.setSize(1000, 800);
        frame.setVisible(true);
        JButton button = new JButton("click me");
        frame.add(button);
        button.setSize(100, 100);
        
    }
}
