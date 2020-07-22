import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class SimpleFrame here.
 *
 * @author Joe Thomas
 * @version March 2019
 */
public class ThePanels extends JFrame 

{
    private JFrame frame; // makes the initial JFrame.

    private JPanel panelA = new JPanel(); //creates a LJpanel.
    private JPanel panelB = new JPanel(); //creates a LJpanel.  
    private JPanel panelC = new JPanel();//creates a LJpanel.

    private JButton easyButton; //creates all Buttons.
    private JButton intermediateButton;
    private JButton difficultButton;
    private JButton playButton;
    private JButton exitButton;
    private JButton[][] grid; //names the grid of buttons

    private JLabel scoreLabel; //creates the score JLabel.
    private int Score = 0;

    private JLabel scoreTarget;
    private int winNum = 0; // this is the number that the game will use to destinguish if the player has won or not.

    private JLabel winMessage; //creates the win JLabel.

    private JLabel loseMessage; //creates the lose JLabel.

    private int newX = randomX(); // saves the randomX() generated number in "newX" so that can be called in other methods and refreshed.

    private int newY = randomY(); // saves the randomY() generated number in "newY"

    /** 
     * Constructer. sets the title of the JFrame.
     * sets the inital size of the JFrame when the user runs the programme (They can then enlarge the Frame to fill window).
     * Runs the makeFrame() method and sets it to visable.
     */
    public ThePanels()
    {
        super("Bomb Game");
        setSize(200,200);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());
        setVisible(true);
        makeFrame();
    }

    /** 
     * Responsable for the creasion of the JPanels and everything on it.
     * Allows for creation of elements such as JPanels, JFrames and JLables.
     * Sets the layouts, Fonts, placements of JButtons, Alignments, Creation of Grid and ActionListeners. 
     */
    public void makeFrame()
    {
        /** 
         * Adds the three panels to te JFrame.
         * Declares the individual Layout of the three panels.
         */
        add(panelA);
        add(panelB);
        add(panelC);
        panelA.setLayout(new BorderLayout());
        panelB.setLayout(new GridLayout(10,1));
        panelC.setLayout(new BorderLayout());

        /** 
         * Sets the overal font within the JFrame.
         * Allows for future declarations within JLables.
         */
        Font labelFont = new Font("Arial", Font.BOLD, 16);

        /** 
         * Initialises JButtons that were declared in the field.
         * Both the play button and exit button are implamented here.
         */
        playButton = new JButton("Play A Game");//creatation of the three buttons for panelB
        exitButton = new JButton("EXIT");

        /** 
         * The creation on an ActionListener event which creates a respons when the exit button.
         * Once ActionListener is executed the actionPerformed message is sent to all action listeners that are declared within the ActionEvent.
         * System.exit(0); is the code that reacts to the action. Closes the JFrame and ends the programme.
         */
        exitButton.addActionListener(new ActionListener() { //Allows the player to exit and close the program
                public void actionPerformed (ActionEvent e) {
                    System.exit(0);
                }
            });

        /** 
         * Initialises JButtons that were declared in the field.
         * The easyButton,intermediateButton and difficultButton are implamented here.
         * These Buttons are diplayed on panel C (far right panel).
         */
        easyButton = new JButton("Easy"); //creatation of the three buttons for panelC
        intermediateButton = new JButton("Intermediate");
        difficultButton = new JButton("Difficult");

        /** 
         * Sets the vertical status of panel C.
         * Allows the JButtons to be arranged in a vertical formation.
         */
        panelC.setLayout(new BoxLayout(panelC, BoxLayout.Y_AXIS));

        /** 
         * Sets the alignment of the panel to center.
         * Occurs in panel C.
         * The easyButton,intermediateButton and difficultButton are all centered within this decloration.
         */
        easyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        intermediateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        difficultButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        /** 
         * Initialises JLabels that were declared in the field.
         * Consists of the Score JLabel.
         * The creation of what will be displayed within the JLabel along with its font and color.
         * The Score variable is called within the string so the user has a live update of there current score.
         */
        scoreLabel = new JLabel("Score: " + Score);
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(labelFont);

        /** 
         * Initialises JLabels that were declared in the field.
         * Consists of the amount of tries the user has. This is displayed within a JLabel. 
         * The creation will be displayed within the JLabel along with its font and color.
         * The tries winNum is called within the string so the user can see how many attempts they have.
         */
        scoreTarget = new JLabel("Tries: " + winNum);
        scoreTarget.setForeground(Color.white);
        scoreTarget.setFont(labelFont);

        /** 
         * Initialises JLabels that were declared in the field.
         * Consists of the JLabel which is displayed if the user wins.
         * The creation will be displayed within the JLabel along with its font and color.
         */
        winMessage = new JLabel(); 
        winMessage.setForeground(Color.white);
        winMessage.setFont(labelFont);

        /** 
         * Initialises JLabels that were declared in the field.
         * Consists of the JLabel which is displayed if the user loses.
         * The creation will be displayed within the JLabel along with its font and color.
         */
        loseMessage = new JLabel(); 
        loseMessage.setForeground(Color.white);
        loseMessage.setFont(labelFont);

        /** 
         * Adding JButtons and JLabels to the designated JPanel.
         * This makes each element visible to the within the JFrame.
         * In this case the features are being added to panel B. 
         */
        panelB.add(playButton);//adding features to each panel. 
        panelB.add(exitButton);
        panelB.add(scoreLabel);
        panelB.add(scoreTarget);
        panelB.add(winMessage);
        panelB.add(loseMessage);

        /** 
         * Adding JButtons and JLabels to the designated JPanel.
         * This makes each element visible to the within the JFrame.
         * In this case the features are being added to panel C. 
         */
        panelC.add(easyButton);//adding features to each panel. 
        panelC.add(intermediateButton);
        panelC.add(difficultButton);

        /** 
         * Setting the colors of the individual panels.
         */
        panelA.setBackground(Color.RED); //Panel on the left.
        panelB.setBackground(Color.BLUE); //Panel on the in the middle.
        panelC.setBackground(Color.GREEN); //Panel on the in the right.

        /** 
         * Creating a grid by stating two x and y coordinates in an aray then adding to panel A.
         * The first loop takes the y coordinates, which are the indavidual buttons in the row, and repeativly iterates until all 5 buttons are created on the first row, then again for the second.
         * The second loop takes the x coordinates, which are the rows, and keeps adding rows until 2 rows are visable.
         * After takes two arrays which store indavidual int values which when put together makes a name for the buttons (within the range previously stated int values).
         * Then sets the background colors of the buttons to red and then adds them to the panel A.
         * Method also consists of 10 if statments which are within an actionListener, in response to the button being pressed the action listener will -
         * add 100 points to the score, sets the scoreLabel which will then be displayed and calles the gameWon() method which looks to see if the scores are equal.
         */
        panelA.setLayout(new GridLayout(2,5)); //set layout
        grid=new JButton[10][10]; //allocate the size of grid
        for(int y=0; y<5; y++){ //for loop, keeps adding till gets to 5 columns. 
            for(int x=0; x<2; x++){ //for loop, keeps adding till gets to 2 rows.
                grid[x][y]=new JButton(); //creates new button as the array consists of two int which make names buttons.  
                grid[x][y].setBackground(Color.RED);
                panelA.add(grid[x][y]); //adds button to grid.

                grid[x][y].addActionListener(new ActionListener() { // responsable for the score, adding to the score.
                        public void actionPerformed (ActionEvent a) {
                            Score = Score + 100;
                            scoreLabel.setText("Score: " + Score);
                            gameWon();

                            /** 
                             * Series of if statments which are a result of the ActionListener. One for each button.  
                             * When pressed will tern ther button yellow, so user knows they have clicked it. 
                             * Then disables the button so can't be clicked again. 
                             * This is the same for all of the if statments withint this method.
                             */
                            Object source = a.getSource();
                            if(source == grid[0][0]){ //specifying the spersific button so can provoke a response. 
                                grid[0][0].setBackground(Color.YELLOW);
                                grid[0][0].setEnabled(false); // disables the buttons (only allows 1 click).
                            }

                            if(source == grid[1][0]){
                                grid[1][0].setBackground(Color.YELLOW);
                                grid[1][0].setEnabled(false);
                            }

                            if(source == grid[0][1]){
                                grid[0][1].setBackground(Color.YELLOW);
                                grid[0][1].setEnabled(false);
                            }

                            if(source == grid[1][1]){
                                grid[1][1].setBackground(Color.YELLOW);
                                grid[1][1].setEnabled(false);
                            }

                            if(source == grid[0][2]){
                                grid[0][2].setBackground(Color.YELLOW);
                                grid[0][2].setEnabled(false);
                            }

                            if(source == grid[1][2]){
                                grid[1][2].setBackground(Color.YELLOW);
                                grid[1][2].setEnabled(false);
                            }

                            if(source == grid[0][3]){
                                grid[0][3].setBackground(Color.YELLOW);
                                grid[0][3].setEnabled(false);
                            }

                            if(source == grid[1][3]){
                                grid[1][3].setBackground(Color.YELLOW);
                                grid[1][3].setEnabled(false);
                            }

                            if(source == grid[0][4]){
                                grid[0][4].setBackground(Color.YELLOW);
                                grid[0][4].setEnabled(false);
                            }

                            if(source == grid[1][4]){
                                grid[1][4].setBackground(Color.YELLOW);
                                grid[1][4].setEnabled(false);
                            }

                            /**
                             * The Bomb.
                             * Takes the randomly generated numbers from the randomize classes at the end of the class
                             * Enters them into the array to make a name for the a button which then resembles a bomb.
                             * Once the "Bomb" has been triggered the loseMessage will be displayed ending the game. 
                             */                             
                            if(source == grid[newX][newY]){
                                loseMessage.setVisible(true);//sets the loseMessage to true so that the user can see they triggered the bomb.
                                winMessage.setVisible(false);//sets the winning message to false so the player can only see the loseMessage.     
                                scoreLabel.setVisible(false);//sets the scoreLabel message to false so the player can only see the loseMessage. 
                                scoreTarget.setVisible(false);//sets the scoreTarget message to false so the player can only see the loseMessage. 
                                Score = Score - 100; //deducts 100 points so that the player has the score they had before they clicked on the Bomb as clicking on the button gives 100 and we want the score before they clicked on the bomb.
                                loseMessage.setText("  You Lost! You got " + Score + " point!");// displays the losing message.
                            }

                        }
                    });
            }
        };

        /** 
         * The creation on an ActionListener event which creates a respons when the easy Button.
         * Once ActionListener is executed the actionPerformed message is sent to all action listeners that are declared within the ActionEvent.
         * The easy button is being assigned the in of 5 so that later it can be paired with the score in order to allow the game to know when the player has won.
         * Sets other buttons to false so the user cant click them until game is refreshed.
         */
        easyButton.addActionListener(new ActionListener() { 
                public void actionPerformed (ActionEvent b) {
                    winNum = winNum + 5 ;
                    scoreTarget.setText("Tries: " + winNum); //displays the number of tries the user has depending on the button they selcted.
                    easyButton.setEnabled(false);
                    intermediateButton.setEnabled(false);
                    difficultButton.setEnabled(false);
                }
            });

        /** 
         * The creation on an ActionListener event which creates a respons when the  intermediate Button.
         * Once ActionListener is executed the actionPerformed message is sent to all action listeners that are declared within the ActionEvent.
         * The easy button is being assigned the in of 7 so that later it can be paired with the score in order to allow the game to know when the player has won.
         * Sets other buttons to false so the user cant click them until game is refreshed.
         */
        intermediateButton.addActionListener(new ActionListener() { 
                public void actionPerformed (ActionEvent c) {
                    winNum = winNum + 7 ;
                    scoreTarget.setText("Tries: " + winNum); //displays the number of tries the user has depending on the button they selcted.
                    easyButton.setEnabled(false);
                    intermediateButton.setEnabled(false);
                    difficultButton.setEnabled(false);
                }
            });

        /** 
         * The creation on an ActionListener event which creates a respons when the difficult Button.
         * Once ActionListener is executed the actionPerformed message is sent to all action listeners that are declared within the ActionEvent.
         * The easy button is being assigned the in of 9 so that later it can be paired with the score in order to allow the game to know when the player has won.
         * Sets other buttons to false so the user cant click them until game is refreshed.
         */
        difficultButton.addActionListener(new ActionListener() { 
                public void actionPerformed (ActionEvent d) {
                    winNum = winNum + 9 ;
                    scoreTarget.setText("Tries: " + winNum); //displays the number of tries the user has depending on the button they selcted.
                    easyButton.setEnabled(false);
                    intermediateButton.setEnabled(false);
                    difficultButton.setEnabled(false);
                }
            });

        /** 
         * The creation on an ActionListener event which creates a respons when the play button.
         * Once ActionListener is executed the actionPerformed message is sent to all action listeners that are declared within the ActionEvent.
         * Resets all of the values so the user can replay a game without needing to reload the programme.
         * Makes elemens that are and arent relivent either visable or not.
         */
        playButton.addActionListener(new ActionListener() { 
                public void actionPerformed (ActionEvent e) {
                    for(int y=0; y<5; y++){ //for loop, keeps adding till gets to 5 columns. 
                        for(int x=0; x<2; x++){ //for loop, keeps adding till gets to 2 rows. 
                            grid[x][y].setBackground(Color.RED);
                            grid[x][y].setEnabled(true);
                        }
                    }

                    // acts as the reset button. 
                    // resets all of each element within the game. 
                    Score = 0;
                    scoreLabel.setText("Score: " + Score);

                    winNum = 0;
                    scoreTarget.setText("Tries: " + winNum);

                    scoreLabel.setVisible(true);
                    scoreTarget.setVisible(true);

                    winMessage.setVisible(false);
                    loseMessage.setVisible(false);

                    easyButton.setEnabled(true);
                    intermediateButton.setEnabled(true);
                    difficultButton.setEnabled(true);

                    newX = randomX();// Allows the user to reset the Bomb.
                    newY = randomY();// Draws new X and Y numbers from the randomize methos below.

                }
            });
    }

    /** 
     * Randomizes the coordinates for the X int.
     * This will then be used for the first number within the buttons names. 
     * Sets the range of the number it can generate, in this case its either 0 or 1.
     * @return the random number that was generated.
     */
    public int randomX()
    {
        //set range: Math.random*((max - min) + 1) + min)
        int randomNumber = (int)((Math.random() * ((1 - 0) + 1) + 0));
        return randomNumber;
    }

    /** 
     * Randomizes the coordinates for the Y int.
     * This will then be used for the second number within the buttons names. 
     * Sets the range of the number it can generate, in this case its includes 0 and 4.
     * @return the random number that was generated.
     */ 
    public int randomY()
    {
        //set range: Math.random*((max - min) + 1) + min)
        int randomNumber = (int)((Math.random() * ((4 - 0) + 1) + 0));
        return randomNumber;
    }

    /** 
     * Contains three if statments which determins the three difficulties.
     * Matches the score with the number of tries that the user gets.
     * Then displays the winning message paired with the players current points.
     * Also determins which lables are meant to be visable in panelB.
     */ 
    public void gameWon()
    {
        if (winNum == 5 && Score == 500){ //links the two int numbers together which allows the game to see if the player has won, then displays the win message.
            winMessage.setVisible(true);
            scoreLabel.setVisible(false);
            scoreTarget.setVisible(false);
            winMessage.setText("  You Win! You got " + Score + " point!");
        }

        if (winNum == 7 && Score == 700){ //links the two int numbers together which allows the game to see if the player has won, then displays the win message.
            winMessage.setVisible(true);
            scoreLabel.setVisible(false);
            scoreTarget.setVisible(false);
            winMessage.setText("  You Win! You got " + Score + " point!");
        }

        if (winNum == 9 && Score == 900){ //links the two int numbers together which allows the game to see if the player has won, then displays the win message.
            winMessage.setVisible(true);
            scoreLabel.setVisible(false);
            scoreTarget.setVisible(false);
            winMessage.setText("  You Win! You got " + Score + " point!");
        }
    }
}