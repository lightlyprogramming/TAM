public class IntPair{
  
    private int x;
    private int y;
    private boolean visited = false;
    
    public IntPair(int xx, int yy){
      x = xx;
      y = yy;
    }
    
    public IntPair(){
      x = 0;
      y = 0;
    }
    
    public int getX(){
      return x;
    }
    
    public int getY(){
      return y;
    }

    public void setVisited(boolean x){
        visited = x;
    }

    public boolean getVisited(){
        return visited;
    }

    public String toString(){
        return y  + ", " + x;
        // y = column
        // x == row
        
    }
  }