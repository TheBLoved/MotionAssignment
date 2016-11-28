import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
        
       
public class SnakeClient extends SnakeGame implements ActionListener
{
    private static final int GAME_HEIGHT = 600;  // Sets the height of the game field in pixels
    private static final int GAME_WIDTH = 600;   // Sets the width of the game field in pixels    
       
       
    private static int numSegments;  // Counts the number of current segments on the snake;
    
    private boolean north = false;
    private boolean south = false; // Defines the 4 directions the snake can move
    private boolean west = true;   // Sets west (left) as the starting direction
    private boolean east = false; 
    
    private boolean alive = true; // Creates a bool that signifies that the player lost when false
    
    
    
    private Timer timer;
    
    public SnakeClient()
    {
        addKeyListener(new TAdapter()); // adds the ability to check for keypress
        setBackground(Color.BLACK);     // Sets games background color
        setFocusable(true);

        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        
        numSegments = 4; // defines the starting size of a snake in the game
        
        startGame(numSegments);
        
        createApple(); // calls snakeGame to make the first apple
        
        timer = new Timer(getGameSpeed(), this); //creates the game timer
        timer.start();
        
    }
    public static int getNumSegments(){
        return numSegments;
    }
    @Override
    public void paint(Graphics g)
    {
        requestFocus(); //from timer notes, put in as it was exampled
        
        if(alive) // checks to see if the player lost
        {            
            g.setColor(Color.RED);            
            g.fillOval(getAppleX(), getAppleY(), getEntitySize(), getEntitySize()); //draws the "apple" on the screen
            
            for (int i = 0; i <= numSegments; i++)
            {
                if (i == 0)
                {
                    g.setColor(Color.GREEN);  // sets the color of the head to green                 
                }
                else if (i == numSegments)
                {
                    g.setColor(Color.BLACK);
                }
                else 
                {
                    g.setColor(Color.WHITE); // sets the color the body to white
                }
                
                g.fillRect(getSnakeX(i), getSnakeY(i), getEntitySize(), getEntitySize());
            }                        
        }
        else
        {     
            String lossMessage = "Game Over | Score: " + numSegments; // The message displayed on losing the game
            Font message = new Font("Ariel", Font.BOLD, 20); // Creates the font for the loss message
            FontMetrics metric = getFontMetrics(message); // https://docs.oracle.com/javase/7/docs/api/java/awt/class-use/FontMetrics.html describes font metric for finding middle of screen with this font
            g.setColor(Color.RED); // sets the color of the loss message
            g.drawString(lossMessage, (GAME_WIDTH - metric.stringWidth(lossMessage)) / 2, GAME_HEIGHT / 2); // proceeds to write to center of screen                   
        }
        
    }
    
    
    private void collisionDetection()
    {
        if ((getSnakeX(0) == getAppleX()) && (getSnakeY(0) == getAppleY())) 
        //  checks if snake head hit apple
        {
            numSegments++; // add another segment to the snake
            createApple(); // calls function to make a new apple
        }
        
        for (int i = numSegments; i > 0; i--) 
        // loops checks for head colliding with any body of snake, if so, alive is set to false
        {
            if ((i > 4) && (getSnakeX(0) == getSnakeX(i)) && (getSnakeY(0) == getSnakeY(i))) 
            {
                alive = false;
            }
        }
        
        if ( getSnakeX(0) < 0 || getSnakeX(0) >= GAME_WIDTH || getSnakeY(0) < 0 || getSnakeY(0) >= GAME_HEIGHT )
        // checks to see if snake went off board, if so, sets alive to false
        {
            alive = false;
        }
        
        if(!alive)
        {
            timer.stop();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (alive) 
        // checks to see if player has lost yet, if not, checks for collisions, then moves snake
        {          
            collisionDetection();
            moveSnake(numSegments, north, east, west, timer); // must come after collision check in cases where apple is collided and segment should be added
        }

        repaint();
    }

    
    private class TAdapter extends KeyAdapter
    // http://zetcode.com/tutorials/javagamestutorial/movingsprites/ using keys to dictate movement
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
           int keyPress = e.getKeyCode();
           
           if (keyPress == KeyEvent.VK_UP && !south)
           // once up key is pressed, checks to see if going south, to avoid 180 turn, then proceeds
           {
               north = true;
               east = false;
               west = false;
           }
           
           if (keyPress == KeyEvent.VK_DOWN && !north)
           // once down key is pressed, checks to see if going north, to avoid 180 turn, then proceeds
           {
               south = true;
               east = false;
               west = false;
           }
           
           if (keyPress == KeyEvent.VK_LEFT && !east)
           // once left key is pressed, checks to see if going east, to avoid 180 turn, then proceeds
           {
               west = true;
               north = false;
               south = false;
           }
           
           if (keyPress == KeyEvent.VK_RIGHT && !west)
           // once right key is pressed, checks to see if going west, to avoid 180 turn, then proceeds
           {
               east = true;
               north = false;
               south = false;
           }
        }
    }
    
    public static void main(String[] args) 
    {
      SnakeClient prog = new SnakeClient();
      prog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      prog.setSize(GAME_WIDTH, GAME_HEIGHT);
      prog.setVisible(true);
    }

}
