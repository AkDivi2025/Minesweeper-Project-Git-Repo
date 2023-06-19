import javax.swing.*;
import java.util.*;

public class Board  {
    private Square[][] grid;
    private int rows;
    private int cols;
    private int numMines;
    private JFrame frame;
    private int numUncovered = 0;
    

    public Board(int rows, int cols) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid = new Square[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                grid[i][j] = new Square();
            }
        }
        this.rows = rows;
        this.cols = cols;
        this.numMines = 40;
    }
    public Board(String difficulty){
        if(difficulty.equals("easy")){
            rows=8;
            cols=10;
            this.numMines=15;
        }else if(difficulty.equals("medium")) {
            rows=14;
            cols=18;
            this.numMines=40;
        } else if(difficulty.equals("hard")) {
            rows=20;
            cols=30;
            this.numMines=70;
        }
        grid=new Square[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                grid[i][j] = new Square();
            }
        }
        frame = new JFrame();
    }
    public Square getSquare(int row, int col) {
        return grid[row][col];
    }
    public Square[][] getGrid() {
        return grid;
    }
    public void uncoverSpace(int row, int col) {
        //row/=25;
        //col/=25;
        if(grid[row][col].getCloseMines() == -1) {
            grid[row][col].setCovered(false);
            grid[row][col].setImg(grid[row][col].getImg());
        }
        if(grid[row][col].isCovered()) {
            grid[row][col].setCovered(false);
            numUncovered++;
        } else {
            return;
        }
        if(grid[row][col].getCloseMines()>0){
            grid[row][col].setCovered(false);
            numUncovered++;
            grid[row][col].setImg(grid[row][col].getImg());
            return;
        }
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if((row+i > -1 && row+i < rows)&&(col+j > -1 && col+j < cols)) {
                    if(grid[row+i][col+j].getCloseMines() == 0) {
                        uncoverSpace(row + i, col + j);
                        numUncovered++;
                    } else {
                        grid[row+i][col+j].setCovered(false);
                        numUncovered++;
                    }
                    grid[row+i][col+j].setImg(grid[row+i][col+j].getImg());

                }
            }
        }
    }

    public void displayBoard() {
        if(cols > 9){
        System.out.print("   ");
        for(int i = 0; i < cols; i++) {
            if(i/10%10 == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i/10%10+" ");
            }
        }
        System.out.println();
        }

        System.out.print("   ");
        for(int i = 0; i < cols; i++) {
            System.out.print(i%10+" ");
        }
        System.out.println();

        for(int i = 0; i < rows; i++) {
            System.out.print(i + " ");
            if(i < 10) {
                System.out.print(" ");
            }
            for(int j = 0; j < cols; j++) {
                System.out.print(grid[i][j]);
            }
			System.out.println();
        }

        System.out.println();
    }
    public void displayBoardSwing(){
        frame.setSize((rows)*26, (cols)*27);
        frame.setResizable(false);
        
        
        frame.setTitle("Minesweeper");
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                grid[i][j].setLabel(new JLabel(grid[i][j].getImg()));
                
                grid[i][j].getLabel().setBounds(i*25,j*25,25,25);
                frame.add(grid[i][j].getLabel());
                grid[i][j].getLabel().setVisible(true);
                
            } 
                
        }
        JLabel squarething = new JLabel(new ImageIcon("gameImages\\filledSquare.png"));
        squarething.setBounds(14*25+200,18*25+100,25,25);
        frame.add(squarething);
        squarething.setVisible(true);
        frame.setVisible(true);
    }
    
    public void generateMines(int userX,int userY){
      	Random rand = new Random();
      	while(numMines>0){
        	for(int i = 0; i < rows; i++){
    			for(int j = 0; j < cols; j++){
                    if(!((i>=(userX)-2&&i<=(userX)+2)&&(j>=(userY)-2&&j<=(userY)+2))){
            		    int decider = rand.nextInt(10);
            		    if(decider==0&&grid[i][j].getCloseMines()!=-1){
                		    grid[i][j].setCloseMines(-1);
                            numMines--;
              		    }
                    }
            	}
        	}
    	}
    }
    public void generateNums(){
        Square[][] temp = new Square[rows+2][cols+2];
        for(int i = 1; i<temp.length-1;i++){
            for(int j = 1; j<temp[0].length-1;j++){
                temp[i][j]=grid[i-1][j-1];
            }
        }
        for(int i = 1; i<temp.length-1;i++){
            for(int j = 1; j<temp[0].length-1;j++){
                if(grid[i-1][j-1].getCloseMines()!=-1){
                    int num = 0;
                    for(int k=i-1;k<i+2;k++){
                        for(int l=j-1;l<j+2;l++){
                            if(temp[k][l]!=null){
                                if(temp[k][l].getCloseMines()==-1){
                                    num++;
                                }
                            }
                            
                        }
                    }
                
                    grid[i-1][j-1].setCloseMines(num);
                }
            }
        }
    }
    public void addMouse(ClickListener listen){
        frame.addMouseListener(listen);
    }

    public static void main(String[] args) {
        
    }
    public int getUncovered(){
        return numUncovered;
    }
    public int getMines(){
        return numMines;
    }
    public int numSquares(){
        return grid.length*grid[0].length;
    }
}