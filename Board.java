public class Board {

    private char grid[][];
    private int length;
    private int width;
    int bombs;
    char bomb = '#';
    char flags = '+';

    public Board(int x, int y){

        length = x;
        width = y;

        grid = new char[x][y];
    }

    public Board(int x, int y, int b){

        length = x;
        width = y;
        bombs = b;

        grid = new char[x][y];
    }

    private void populateGrid(){
        
    }

    public void displayGrid(){
        for(char[] x : grid){
            for(char y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

}
