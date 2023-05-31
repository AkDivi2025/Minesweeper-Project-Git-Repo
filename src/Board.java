import javax.swing.*;
import java.util.*;

public class Board {
    private Square[][] grid;
    private int rows;
    private int cols;
    private int numMines;
    private JFrame frame;
    

    public Board(int rows, int cols) {
        frame = new JFrame();
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
    }
    public Square getSquare(int row, int col) {
        return grid[row][col];
    }
    public void uncoverSpace(int row, int col) {
        if(grid[row][col].isCovered()) {
            grid[row][col].setCovered(false);
        } else {
            return;
        }
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if((row+i > -1 && row+i < rows)&&(col+j > -1 && col+j < cols)) {
                    if(grid[row+i][col+j].getCloseMines() == 0) {
                        uncoverSpace(row + i, col + j);
                    } else {
                        grid[row+i][col+j].setCovered(false);
                    }
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
        frame.setSize(rows*10,cols*10);
        frame.setVisible(true);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                grid[i][j].setLabel(new JLabel(grid[i][j].getImg()));
                frame.add(grid[i][j].getLabel());
                grid[i][j].getLabel().setBounds(i*10,j*10,10,10);
                grid[i][j].getLabel().setVisible(true);
                
            } 
                
            }
            
        }
    
    public void generateBoard(int userX,int userY){
      	Random rand = new Random();
      	while(numMines>0){
        	for(int i = 0; i < rows; i++){
    			for(int j = 0; j < cols; j++){
                    if(!((i>=userX-2&&i<=userX+2)&&(j>=userY-2&&j<=userY+2))){
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

    public static void main(String[] args) {
        
    }
}