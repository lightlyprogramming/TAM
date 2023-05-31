public class Board {

    private char grid[][];
    private int length;
    private int width;
    int bombs;
    final char BOMB = '#';
    final char FLAG = '+';

    public Board(int x, int y){

        length = x;
        width = y;

        grid = new char[x][y];
        populateGrid();
    }

    public Board(int x, int y, int b){

        length = x;
        width = y;
        bombs = b;

        grid = new char[x][y];
        populateGrid();
        populateBombs(b);
    }

    private void populateGrid(){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                grid[i][j] = '.';
            }
        }
    }

    public void displayGrid(){
        System.out.println();
        int i = 0;

        for(char[] x : grid){
            for(char y : x){
                System.out.print(y + " ");
            }
            System.out.print(i + "\n");
            i++;
        }

        // first digit: l/((int)(Math.pow(10, (int) Math.log10(l)))), doesn't work if 0
        for(int l = 0; l < grid[0].length; l++){
            if(l < 10){
                System.out.print("0 ");
            } else{
                System.out.print(l/((int)(Math.pow(10, (int) Math.log10(l)))) + " ");
                
            }
        }
        System.out.println();
        for(int l = 0; l < grid[0].length; l++){
            System.out.print(l % 10 + " ");
        }

        // other idea to make fool proof:
        /*
         * basically take length of longest number
         * anything with less length add enough 0s to equal length
         * go row by row printing 
         * use 2d arrays?
         * int temp = grid[0][width-1];
         * int numLength = (int) (Math.log10(temp) + 1);
         * int arr[][] = new int[grid[0].length][grid[0][width-1].length]
         * or
         * int arr[][] = new int[width][numLength];
         * then add each digit of each number to each row
         * like 0 row is first digit
         * firstDigit method?
         * but wouldn't work because you'd need a lot of digits if you get ridiculuousyl long numbers
         * 
         */

         
    }

    public void populateBombs(int bombs){
        int x, y = 0;
        for(int i = 0; i < bombs; i++){
            x = (int) (Math.random() * length);
            y = (int) (Math.random() * width);
            grid[x][y] = BOMB;
        }
    }

    private void numberGen(){
        for(int i = 1; i < length; i++){
            for(int l = 1; l < width; l++){
                
            }
        }

        // generates numbers based on num of adjacent bombs so x and y +- 1

        // if bomb is clicked on, ends game

        // check 8 adjacent tiles
        // if x or y == 0 or width/length - 1 then don't check +- 1 in that direciton
    }

    

}