public class Board {

    private char grid[][];
    private int numGrid[][];
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
        numGrid = new int[x][y];
        numberGen();
    }

    public Board(int x, int y, int b){

        length = x;
        width = y;
        bombs = b;

        grid = new char[x][y];
        populateGrid();
        populateBombs(b);
        numGrid = new int[x][y];
        numberGen();
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
                System.out.print(y + "  ");
            }
            System.out.print("|  " + i + "\n");
            i++;
        }

        System.out.print(spacer(length) + "\n");

        // first digit: l/((int)(Math.pow(10, (int) Math.log10(l)))), doesn't work if 0
        for(int l = 0; l < grid[0].length; l++){
            if(l < 10){
                System.out.print("0  ");
            } else{
                System.out.print(l/((int)(Math.pow(10, (int) Math.log10(l)))) + "  ");
                
            }
        }
        System.out.println();
        for(int l = 0; l < grid[0].length; l++){
            System.out.print(l % 10 + "  ");
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

    public void displayNumGrid(){
        System.out.println();
        int i = 0;

        for(int[] x : numGrid){
            for(int y : x){
                System.out.print(y + "  ");
            }
            System.out.print("|  " + i + "\n");
            i++;
        }

        System.out.print(spacer(length) + "\n");

        // first digit: l/((int)(Math.pow(10, (int) Math.log10(l)))), doesn't work if 0
        for(int l = 0; l < grid[0].length; l++){
            if(l < 10){
                System.out.print("0  ");
            } else{
                System.out.print(l/((int)(Math.pow(10, (int) Math.log10(l)))) + "  ");
                
            }
        }
        System.out.println();
        for(int l = 0; l < grid[0].length; l++){
            System.out.print(l % 10 + "  ");
        }
    }

    public void populateBombs(int bombs){
        for(int i = 0; i < bombs; i++){
            int x = (int) (Math.random() * length);
            int y = (int) (Math.random() * width);
            grid[x][y] = BOMB;
        }
    }

    private void numberGen(){
        for(int i = 0; i < length; i++){
            for(int l = 0; l < width; l++){
                int adjacent = 0;
                for(int di = (i > 0 ? -1 : 0); di <= (i < length - 1 ? 1 : 0); ++di){
                    for(int dl = (l > 0 ? -1 : 0); dl <= (l < width - 1 ? 1 : 0); ++dl){
                        if(di != 0 || dl != 0){
                            if(grid[i + di][l + dl] == BOMB){
                                adjacent++;
                            }
                        }
                    }
                }
                /*
                if(grid[i][l] == BOMB){
                    numGrid[i][l] = -1;
                } else {
                    numGrid[i][l] = adjacent;
                }
                */
                numGrid[i][l] = adjacent;
                

            }
        }

        // generates numbers based on num of adjacent bombs so x and y +- 1

        // if bomb is clicked on, ends game

        // check 8 adjacent tiles
        // if x or y == 0 or width/length - 1 then don't check +- 1 in that direciton
    }

    public void format(int x){
        for(int i = 0; i < x; i++){
            System.out.println();
        }
    }

    private String spacer(int x){
        String space = "";
        x *= 3;

        for(int i = 0; i < x; i++){
            space += "_";
        }
        return space;
    }
    

}


