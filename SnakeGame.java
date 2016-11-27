import javax.swing.*;

public class SnakeGame extends JFrame
{
    private final int MAX_NUM_SEGMENTS = 3600; // Sets the maximum number of entities on the screen, [ (GAME_HEIGHT * GAME_WIDTH) / POW(2, ENTITY_SIZE) ]
    private final int ENTITY_SIZE = 10;   // Sets the length of one side of the snake segemnts and the "apple"
    
    private int snakeX[] = new int[MAX_NUM_SEGMENTS]; //  Defines an array for the X location of the maximum number of entities on the screen
    private int snakeY[] = new int[MAX_NUM_SEGMENTS]; //  Defines an array for the Y location of the maximum number of entities on the screen 
    
    private int gameSpeed = 120;  // Sets the default time in between each timer tick, affecting game speed, delay will slowly decrement, making game faster 
    private final int MAX_SPEED = 30; // Sets the smallest delay of time allowed by the game, affecting max speed
    
    private int appleX; // Defines the x position of the current apple on the screen
    private int appleY; // Defines the y position of the current apple on the screen
    
    private int nextIncrease = 10; // Defines the starting number of segments at which the speed increases
    private int increaseAmount = 5; //  Defines the amount segments required for subsequent speed increase after starting segment 
    
    protected void startGame(int numSegments)
    {
        //sets the starting x positions of the snake, at 250 and every 10 after in pixels
        // sets the starting y postition of the entire snake in pixels
        
    }

    public int getGameSpeed()
    {
        return gameSpeed;
    }
    
    public void createApple()
    // generates the random position of the apple, and sets it to the members
    {
              
    }
    
    public int getEntitySize()
    // returns the pixel size of entity
    {
        return ENTITY_SIZE;
    }
    
    public int getSnakeX(int x)
    //passed an array index, returns the x position of that segment
    {
        return snakeX[x];
    }
    
    public int getSnakeY(int y)
    //passed an array index, returns the y position of that segment
    {
        return snakeY[y];
    }
    
    public int getAppleX()
    // returns the x position of the apple
    {
        return appleX;
    }
    
    public int getAppleY()
    // returns the y position of the apple
    {
        return appleY;
    }
    
    protected void moveSnake(int numSegments, boolean north, boolean east, boolean west, Timer timer) 
    {

        for (int i = numSegments; i > 0; i--) 
        // moves each segment to the position in front of it
        {
            snakeX[i] = snakeX[(i - 1)];
            snakeY[i] = snakeY[(i - 1)];
        }
        
        if(gameSpeed > MAX_SPEED && numSegments == nextIncrease)
        // if the number of segments equals the next increase, increase game speed
        {
            nextIncrease += increaseAmount;            
            gameSpeed -= 10;            
            timer.setDelay(gameSpeed);
        }

        // following if else if sets the next head location depending on direction
        
        if (west) 
        {
            snakeX[0] -= ENTITY_SIZE;
        }
        else if (east) 
        {
            snakeX[0] += ENTITY_SIZE;
        }
        else if (north) 
        {
            snakeY[0] -= ENTITY_SIZE;
        }
        else
        {
            snakeY[0] += ENTITY_SIZE;
        }
    }
}
