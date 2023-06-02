import java.util.Scanner;

public class TAMV2 {
    public static void main(String[] args){
        boolean playGame = true;
        Scanner scan = new Scanner(System.in);
        int a, b, c = 0;

        while(playGame){
            System.out.println("Welcome to Minesweeper!");
            System.out.println("Input the width (0 - 100) of your board: ");
            a = scan.nextInt();
            System.out.println("Input the height of your board: ");
            b = scan.nextInt();
            System.out.println("Input the number of bombs (Optional, enter 0 to skip...): ");
            c = scan.nextInt();

            Board game = new Board(b, a, c);

            game.displayGrid();
            game.format(5);
            game.displayNumGrid();

            promptEnterKey();

            System.out.println("Input x-coordinate: ");
            a = scan.nextInt();
            System.out.println("Input y-coordinate: ");
            b = scan.nextInt();

            game.adjZeroes(b, a, 0);

            game.displayMarkedGrid();

            
        }   
        
        // Board board = new Board(16, 16, 39);
        // board.displayGrid();
        // board.format(10);
        // board.displayNumGrid();
        // board.format(1);
        // System.out.println("Input x-coordinate: ");
        //  a = scan.nextInt();
        // System.out.println("Input y-coordinate: ");
        //  b = scan.nextInt();

        // System.out.println(board.adjacentZeroes(new IntPair(b, a)));
    }

    public static void promptEnterKey(){
        System.out.println("\nPress \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
     }
}


/*
 * 
 * for(int di = (i > 0 ? -1 : 0); di <= (i < length - 1 ? 1 : 0); ++di){
                    for(int dl = (l > 0 ? -1 : 0); dl <= (l < width - 1 ? 1 : 0); ++dl){
                        if(di != 0 || dl != 0){
                            if(grid[i + di][l + dl] == BOMB){
                                adjacent++;
                            }
                        }
                    }
                }
 */

