import javax.swing.*;

public class Square {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	private JButton button;
    private JFrame frame;
    private char img;
	private int closeMines;
	private boolean covered;
	private boolean flagged;
    private ImageIcon img2;
	private JLabel label;

    public Square()  {
        this.closeMines = 0;
		this.covered = true;
		this.img2 = new ImageIcon("gameImages\\filledSquare.png");
		this.flagged = false;
    	this.button = new JButton();
    	this.frame = new JFrame();
    }
    
    public int getCloseMines() {
		return closeMines;
	}
	public void setCloseMines(int closeMines) {
		this.closeMines = closeMines;
	}
	public boolean isCovered() {
		return covered;
	}
	public void setCovered(boolean covered) {
		this.covered = covered;
	}
	public boolean isFlagged() {
		return flagged;
	}
	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}
	public void setButton(JButton button){
		this.button = button;
	}
	public JButton getButton() {
		return button;
	}

	public String toString() {
		if(flagged && covered) {
			return ANSI_CYAN + "F" + ANSI_RESET + " ";
		} else if(covered) {
			return "■ ";
		} else if(closeMines > 3) {
			return ANSI_PURPLE + closeMines + ANSI_RESET + " ";
		} else if(closeMines > 2) {
			return ANSI_BLUE + closeMines + ANSI_RESET + " ";
		} else if(closeMines > 1) {
			return ANSI_GREEN + closeMines + ANSI_RESET + " ";
		} else if(closeMines > 0) {
			return ANSI_YELLOW + closeMines + ANSI_RESET + " ";
		} else if(closeMines > -1) {
			return "  ";
		} else {
			return ANSI_RED + "■" + ANSI_RESET + " ";
		}
	}
	public static void main(String[] args) {

	}
	public ImageIcon getImg(){
		if(flagged && covered) {
			return new ImageIcon("gameImages\\flag.png");
		} else if(covered) {
			return new ImageIcon("gameImages\\filledSquare.png");
		} else if(closeMines >= 8) {
			return new ImageIcon("gameImages\\num8Square.png");
		} else if(closeMines >= 7) {
			return new ImageIcon("gameImages\\num7Square.png");
		} else if(closeMines >= 6) {
			return new ImageIcon("gameImages\\num6Square.png");
		} else if(closeMines >= 5) {
			return new ImageIcon("gameImages\\num5Square.png");
		} else if(closeMines >= 4) {
			return new ImageIcon("gameImages\\num4Square.png");
		} else if(closeMines >= 3) {
			return new ImageIcon("gameImages\\num3Square.png");
		} else if(closeMines >= 2) {
			return new ImageIcon("gameImages\\num2Square.png");
		} else if(closeMines >= 1) {
			return new ImageIcon("gameImages\\num1Square.png");
		} else if(closeMines == 0) {
			return new ImageIcon("gameImages\\clearedSquare.png");
		} else {
			return new ImageIcon("gameImages\\mine.png");
		}
	}
	public void setImg(ImageIcon image){
		
			img2 = this.getImg();
			this.label.setIcon(image);
		
	}
	public JLabel getLabel(){
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
		
		label.setVisible(true);
	}
	
    
}