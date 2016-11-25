public class Block{
    int x;
    int y;
    public Block(){
        ;
    }
    public Block(int a,int b){
        x=a;
        y=b;
    }
    public void setX(int in){
        x=in;
    }
    public void setY(int in){
        y=in;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int[] getCoordinates(){
        int[] out={x,y};
        return out;
    }
}
