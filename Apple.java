//Willis Hershey
import java.util.Random;
public class Apple{
    private int x; //x coordinate of the apple
    private int y; //y coordinate of the apple
    private Random r=new Random(); //produces random values for our coordinates
    public Apple(){
        reset(); //creates an instance of the Apple class and sets x and y values
    }
    public void reset(){ //sets x and y coordinates such that x%10=0, y%10=0, and is not in the same place as the snake
        do{
            x=(r.nextInt(60))*10;
            y=(r.nextInt(60))*10;
        }while(SnakeGame.isOccupied(x,y));
    }
    public int getX(){ //returns x value of apple
        return x;
    }
    public int getY(){ //returns y value of apple
        return y;
    }
}