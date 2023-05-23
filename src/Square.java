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

	JButton button;
    JFrame frame;
    char img;
	private int closeMines;
	private boolean covered;
	private boolean flagged;
    
    public Square() {
        this.closeMines = 0;
		this.covered = true;
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

	public String toString() {
		if(flagged && covered) {
			return ANSI_CYAN + "F" + ANSI_RESET;
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
    
}