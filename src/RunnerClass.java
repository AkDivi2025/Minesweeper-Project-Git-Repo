//changed name of uncoverSquare method to uncoverSpace
//fixed uncoverSpace method to stop uncovering mines
//changed displayBoard method to make rows and columns easier to see


import java.util.Scanner;

public class RunnerClass {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Square currentSquare;
        String userIn;
        int userX, userY;

        
        System.out.println("Welcome to Minesweeper!");
        console.nextLine();

        System.out.println("type \' f\' after your move to flag a square");
        console.nextLine();

        System.out.println("What difficulty do you want to play:");
        String diff = console.nextLine();
        Board b1 = new Board(diff);

        
        b1.displayBoard();
        /*System.out.println("enter your move (row,col):");
        userIn = console.nextLine();
        if(userIn.equals("stop")) {
            console.close();
            return;
        }
        userX = Integer.parseInt(userIn.substring(0, userIn.indexOf(",")));
        userY = Integer.parseInt(userIn.substring(userIn.indexOf(",")+1, userIn.indexOf(" ")));*/
        
        

        b1.displayBoard();
        b1.displayBoardSwing();
        
        //SET UP CLICKLISTENER
        ClickListener listen = new ClickListener();
        b1.addMouse(listen);
        while(listen.getCoords()[0] == 0){
            System.out.println("a");
            
        }
        
        int[] coords = listen.getCoords();
        userX = coords[0];
        userY = coords[1];
        System.out.println(coords[0]+" "+coords[1]);
        
        
        
        
        /*while(true){
            System.out.println("enter your move (row,col):");
            userIn = console.nextLine();
            if(userIn.equals("stop")) {
                break;
            }
            userX = Integer.parseInt(userIn.substring(0, userIn.indexOf(",")));
            userY = Integer.parseInt(userIn.substring(userIn.indexOf(",")+1, userIn.indexOf(" ")));


            
            currentSquare = b1.getSquare(userX, userY);
            if(userIn.charAt(userIn.length()-1) == 'f') {
                currentSquare.setFlagged(!currentSquare.isFlagged());
            } else if(currentSquare.getCloseMines() == -1) {
                currentSquare.setCovered(false);
                b1.displayBoard();
                System.out.println("Game Over :(");
                break;
            } else if(currentSquare.getCloseMines() == 0) {
                b1.uncoverSpace(userX, userY);
            } else {
                currentSquare.setCovered(false);
            }

            b1.displayBoard();
        }*/
        
        
        
    }
    
}
