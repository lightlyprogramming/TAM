public class TAM {
    public static void main(String[] args){


        /* IMPORTANT NOTES:
         *  
         * grid.length = gridHeight
         *  grid[0].length = gridWidth
         *  meaning:
         *  gridHeight = number of rows
         *  gridWidth = number of columns
         *  putting stuff in the array according to a cartesian  coordinate plane has to be [y][x] aka row number and then column
         * 
         */
        // variables

        int gridHeight = 50; // grid height
        int gridWidth = 50; // grid width
       
        int bombs = (gridHeight * gridWidth)/10; // bomb number
        char bomb = '+'; // bomb char

        char flags = '#'; // flag char

        // creating grid

        char[][] grid = new char[gridHeight][gridWidth];

        format(); // format method

        populateGrid(gridHeight, gridWidth, grid); // populating empty grid 

        displayGrid(gridHeight, gridWidth, grid); // display grid

        populateBombs(bombs, bomb, gridHeight, gridWidth, grid);// adding bombs

        // spacer

        System.out.println("\n" + spacer(gridWidth));

        displayGrid(gridHeight, gridWidth, grid); // display grid

        format();

        numberGen(gridHeight, gridWidth, grid);

        // spacer

        System.out.println("\n" + spacer(gridWidth));

        displayGrid(gridHeight, gridWidth, grid); // display grid

        format();

        
    }


    // code to populate empty grid 
    public static void populateGrid(int tempGH, int tempGW, char[][] tempGrid){
        for(int i = 0; i < tempGH; i++){
            for(int l = 0; l < tempGW; l++){
                tempGrid[i][l] = '.';
            }
        }
    }
    
    // code to display grid - works with numbers less than 20
    public static void displayGrid(int tempGH, int tempGW, char[][] tempGrid){
        for(int i = 0; i < tempGH; i++){
            for(int l = 0; l < tempGW; l++){
                System.out.print(tempGrid[i][l]);
                System.out.print(" ");
            }
            System.out.print(i); // displays row number
            System.out.println("");
        } 


        // firstDigit = number/((int)(pow(10,(int)log(number))));
        //fix doesn't work; run to test
        // code to display column
        for(int i = 0; i < tempGW; i++){
            if(i < 10){
                System.out.print("0");
                System.out.print(" ");
            } else if(i >= 10 && i < 20){
                System.out.print("1");
                System.out.print(" ");
            } else if(i >= 20 && i < 30){
                System.out.print("2");
                System.out.print(" ");
            } else if(i >= 30 && i < 40){
                System.out.print("3");
                System.out.print(" ");
            } else if(i >= 40 && i < 50){
                System.out.print("4");
                System.out.print(" ");
            } else if(i >= 50 && i < 60){
                System.out.print("5");
                System.out.print(" ");
            }
        }

        System.out.println();

        for(int i = 0; i < tempGW; i++){
            System.out.print(i % 10);
            System.out.print(" ");
        }
    }

    // code to populate bombs
    public static void populateBombs(int bombs, char bomb, int tempGH, int tempGW, char[][] tempGrid){
        for(int i = 0; i < bombs; i++){
            int x = 0;
            int y = 0;
            x = (int) (Math.random() * tempGH);
            y = (int) (Math.random() * tempGW);
            tempGrid[x][y] = bomb;
        }
    }

    // number generation - needs work
    public static void numberGen(int tempGH, int tempGW, char[][] tempGrid){
        for(int i = 0; i < tempGH; i++){
            for(int l = 0; l < tempGW; l++){
                System.out.print(adjacent(i, l, tempGrid) + " ");
            }
            System.out.println();
        }
    }

    public static int adjacent(int x, int y , char[][] arr){
        int adj = 0;
        for (int dx = (x > 0 ? -1 : 0); dx < (x < arr.length ? 1 : 0); dx++)
        {
            for (int dy = (y > 0 ? -1 : 0); dy < (y < arr[0].length ? 1 : 0); dy++)
            {
                if (dx != 0 || dy != 0)
                {
                 if(arr[x + dx][y + dy] == '+'){
                    adj++; 
                 }
                }
            }
        }
        return adj;
       
    }
    // format method for aesthetics/visuals
    public static void format(){
        for(int i = 0; i <= 25; i++){
            System.out.println();
        }
    }

    public static String spacer(int w){
        String space = "";
        w *= 2;

        for(int i = 0; i <= w; i++){
            space += '-';
        }
        return space;
    }



}