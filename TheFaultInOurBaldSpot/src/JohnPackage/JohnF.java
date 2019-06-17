//Program title: The FaultInOurBaldSpot 
//Author: John Diemert
//Date: june 17th, 2019
//Program Description: surgeon simulator game 

package JohnPackage;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JohnF extends javax.swing.JFrame {
    //delcaring varibles 
    //mx and my are varibles which store the mouses location
    int mx, my;
    //boolean to see if the bone saw tool has been clicked
    boolean boneSawClick = false;
    //boolean to see if the sewing needle tool has been clicked
    boolean sewNeedleClick = false;
    //following booleans determine if the user has started cutting a box
    boolean cutClick = false;
    boolean cutClick2 = false;
    boolean cutClick3 = false;
    boolean cutClick4 = false;
    boolean cutClick5 = false;
    boolean cutClick6 = false;
    boolean sewClick = false;
    //following booleans determine if the user entered the box during the cut 
    boolean boxEntered = false;
    boolean boxEntered6 = false;
    boolean boxEntered2 = false;
    boolean boxEntered3 = false;
    boolean boxEntered4 = false;
    boolean boxEntered5 = false;
    boolean sewBoxEntered = false;
    //mr v's health
    int healthValue = 100;
    //counter which determines how many times the player makes a sucsessful cut 
    int counter = 0;
    //counter which keeps track of how much time the suer has to complete the game
    int gameCounter = 120;
    //this counter keeps track of how much time the user has left to complete the game
    int leftCounter = 0;
    //score
    int score = 0;
    //tools avaible which are part of a class
    Tool needle, bonesaw;
    
    //function which is called whenever mr.V loses heath
    private void injured() {
        //starts timer task
        Timer injuredTimer = new Timer();
        TimerTask stopInjured = new TimerTask() {
            //what happens when the timer stops
            public void run() {
                //blood image goes away
                hurt.setVisible(false);
                //mr V normal face becomes visible
                mrV.setVisible(true);
            }

        };
        injuredTimer.schedule(stopInjured, 500);
        //if the bonesaw is equipped take a certain amout of damage off
        if (bonesaw.isClicked == true) {
            healthValue = healthValue - bonesaw.getDamage();
        //if the needle is equipped take a certain amout of damage off
        } else if (needle.isClicked == true) {
            healthValue = healthValue - needle.getDamage();
        }
        //substracts damaged from the health bar
        healthBar.setValue(healthValue);
        //checks to see if the health bar is 0
        if (healthBar.getValue() == 0) {
            //if it does, end the game by calling the endgame function
            endGame();
        }
        //when the timer runs intinally the blood appears and mr.V's normal face dissappers to show his bad one
        hurt.show();
        mrV.setVisible(false);
        //calls the scream audio file
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("AHHH2.wav"));
            // Get a sound clip resource.
            Clip clip1 = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip1.open(audio);
            //starts short clip
            clip1.start();
            //catches the many errors which can occur
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    //edngame function
    private void endGame() {
        //uses formula to caluculate the players score
        score = healthBar.getValue() * gameCounter;
        //try to catch IOExceptions as im going to call a function which writes data
        try {
            //calls fucntion to write data into an external file
            highScore();
        } catch (IOException e) {
        }
    }
    //function which writes scoreto en external file
    private void highScore() throws IOException {
        //locates file to put scores in
        PrintWriter fileOut = new PrintWriter(new FileWriter("HighScores.txt", true));
        //adds score to it
        fileOut.println(score);
        //closes file
        fileOut.close();
        //if the score is greater than 0 call the win game frame 
        if (score > 0) {
             //closes form
            this.dispose();
            //calls the win frame
            scoreFrame johnObject = new scoreFrame();
            johnObject.setVisible(true);
        //if the score is zero meaning they bleed out ot time runs out call the lose game frame
        } else {
            lost johnObject = new lost();
            johnObject.setVisible(true);
            //closes form
            this.dispose();
        }
    }
    //funtion that is called every time the player sucsesffuly cuts a box
    private void success() {
        //adds to counter
        counter++;
        //creates timer
        Timer cutTimer = new Timer();
        TimerTask stopCut = new TimerTask() {
            //when the timer is up hide the sissors
            public void run() {
                cut.setVisible(false);
            }
        };
        cutTimer.schedule(stopCut, 500);
        //shows the sissors to indicate the task was sucsessfull
        cut.setVisible(true);
        //if the counter equal's 6 we know the ribs must be cut
        if (counter == 6) {
            //if that occurs hide the ribs and show the heart
            ribs.setVisible(false);
            sewBox.setVisible(true);
            //calls function which starts timer as the cutbox on the heart moves
            SewBoxTimer();
        //if the counter equals 7 the heart must be sewed up and the game is over
        } else if (counter == 7) {
            //calls endgame fuction
            endGame();
        }
    }
    //gamecounter. Runs the big timer which is how much time they have to complete the game
    public void gameCounter() {
        //creates timer
        Timer gameTimer = new Timer();
        TimerTask stopGame = new TimerTask() {
            //when the timer stops lower the gamecounter, set that equal to the time label, ehack to see if the timer is 0 (when the game ends)
            public void run() {
                time.setText(String.valueOf(gameCounter));
                gameCounter--;
                if (gameCounter == 0) {
                    //calls endgame function if timer is 0 - runs out 
                    endGame();
                }
            }
        };
        //timer is scheduled to go down at a constant rate
        gameTimer.scheduleAtFixedRate(stopGame, 1000, 1000);
    }
    //timer which moves the box on the heart 
    public void SewBoxTimer() {
        //creates timer
        Timer heartTimer = new Timer();
        TimerTask moveBox = new TimerTask() {
            public void run() {
                //counter increases each time the timer runs
                leftCounter++;
                //if the counter is less than 15 move the box to the left 15 spaces
                if (leftCounter <= 15) {
                    sewBox.setLocation(sewBox.getLocation().x - 1, sewBox.getLocation().y);
                //greater than 15 move the box to the right 30 spaces
                } else if (leftCounter > 15 & leftCounter <= 45) {
                    sewBox.setLocation(sewBox.getLocation().x + 1, sewBox.getLocation().y);
                //left again 30 spaces (differnt values from the fist one which is why it's needed)
                } else if (leftCounter >= 45 & leftCounter < 76) {
                    sewBox.setLocation(sewBox.getLocation().x - 1, sewBox.getLocation().y);
                 //resets counter at 15 so this process starts over 
                } else if (leftCounter > 75) {
                    leftCounter = 15;
                }
            }
        };
        heartTimer.scheduleAtFixedRate(moveBox, 50, 50);
    }
    //when the form opens
    public JohnF() {
        //initualizes componets
        initComponents();
        //sets health bar to 100
        healthBar.setValue(100);
        //Initialize the label with the scaled image icon
        myInitComponents(background);
        //hides certain images as they shouldn't be shown yet
        hurt.setVisible(false);
        sewBox.setVisible(false);
        cut.setVisible(false);
        //starts game counter
        gameCounter();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        healthBar = new javax.swing.JProgressBar();
        cutBox = new javax.swing.JLabel();
        hurt = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        cutBox2 = new javax.swing.JLabel();
        cutBox3 = new javax.swing.JLabel();
        cutBox4 = new javax.swing.JLabel();
        cutBox5 = new javax.swing.JLabel();
        cutBox6 = new javax.swing.JLabel();
        sewBox = new javax.swing.JLabel();
        sewNeedle = new javax.swing.JLabel();
        boneSaw = new javax.swing.JLabel();
        ribs = new javax.swing.JLabel();
        badHeart = new javax.swing.JLabel();
        cut = new javax.swing.JLabel();
        sewNeedleLabel = new javax.swing.JLabel();
        boneSawLabel = new javax.swing.JLabel();
        mrV = new javax.swing.JLabel();
        mrVHurt = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setName("mainFrame"); // NOI18N
        setSize(new java.awt.Dimension(1080, 720));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(healthBar);
        healthBar.setBounds(20, 10, 146, 14);

        cutBox.setText("cutBox");
        cutBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cutBoxMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cutBoxMouseMoved(evt);
            }
        });
        cutBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cutBoxFocusLost(evt);
            }
        });
        cutBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cutBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cutBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cutBoxMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cutBoxMousePressed(evt);
            }
        });
        getContentPane().add(cutBox);
        cutBox.setBounds(430, 310, 10, 70);

        hurt.setText("hurt");
        getContentPane().add(hurt);
        hurt.setBounds(20, 80, 120, 130);

        time.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        time.setForeground(new java.awt.Color(204, 0, 0));
        time.setText("120");
        getContentPane().add(time);
        time.setBounds(920, 10, 140, 60);
        time.getAccessibleContext().setAccessibleName("wallLabel");
        time.getAccessibleContext().setAccessibleDescription("");

        cutBox2.setText("cutBox2");
        cutBox2.setMaximumSize(new java.awt.Dimension(40, 16));
        cutBox2.setMinimumSize(new java.awt.Dimension(40, 16));
        cutBox2.setPreferredSize(new java.awt.Dimension(40, 16));
        cutBox2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cutBox2MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cutBox2MouseMoved(evt);
            }
        });
        cutBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cutBox2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cutBox2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cutBox2MousePressed(evt);
            }
        });
        getContentPane().add(cutBox2);
        cutBox2.setBounds(410, 440, 10, 80);

        cutBox3.setText("jLabel1");
        cutBox3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cutBox3MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cutBox3MouseMoved(evt);
            }
        });
        cutBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cutBox3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cutBox3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cutBox3MousePressed(evt);
            }
        });
        getContentPane().add(cutBox3);
        cutBox3.setBounds(460, 570, 10, 90);

        cutBox4.setText("cutBox4");
        cutBox4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cutBox4MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cutBox4MouseMoved(evt);
            }
        });
        cutBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cutBox4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cutBox4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cutBox4MousePressed(evt);
            }
        });
        getContentPane().add(cutBox4);
        cutBox4.setBounds(660, 310, 10, 70);

        cutBox5.setText("cutBox5");
        cutBox5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cutBox5MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cutBox5MouseMoved(evt);
            }
        });
        cutBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cutBox5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cutBox5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cutBox5MousePressed(evt);
            }
        });
        getContentPane().add(cutBox5);
        cutBox5.setBounds(670, 440, 10, 80);

        cutBox6.setText("CutBox6");
        cutBox6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cutBox6MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cutBox6MouseMoved(evt);
            }
        });
        cutBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cutBox6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cutBox6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cutBox6MousePressed(evt);
            }
        });
        getContentPane().add(cutBox6);
        cutBox6.setBounds(640, 570, 10, 90);

        sewBox.setText("sewBox");
        sewBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sewBoxMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sewBoxMouseMoved(evt);
            }
        });
        sewBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sewBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sewBoxMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sewBoxMousePressed(evt);
            }
        });
        getContentPane().add(sewBox);
        sewBox.setBounds(600, 400, 10, 90);

        sewNeedle.setText("SewNeedle ");
        sewNeedle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sewNeedleMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sewNeedleMouseMoved(evt);
            }
        });
        sewNeedle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sewNeedleMouseClicked(evt);
            }
        });
        getContentPane().add(sewNeedle);
        sewNeedle.setBounds(980, 430, 80, 140);

        boneSaw.setText("boneSaw");
        boneSaw.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                boneSawMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                boneSawMouseMoved(evt);
            }
        });
        boneSaw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boneSawMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boneSawMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boneSawMouseReleased(evt);
            }
        });
        getContentPane().add(boneSaw);
        boneSaw.setBounds(10, 430, 50, 150);

        ribs.setText("Ribs");
        getContentPane().add(ribs);
        ribs.setBounds(350, 270, 410, 400);

        badHeart.setText("badHeart");
        getContentPane().add(badHeart);
        badHeart.setBounds(550, 390, 110, 110);

        cut.setText("cut");
        getContentPane().add(cut);
        cut.setBounds(160, 90, 110, 110);

        sewNeedleLabel.setForeground(new java.awt.Color(255, 0, 51));
        sewNeedleLabel.setText("SEWING NEEDLE");
        getContentPane().add(sewNeedleLabel);
        sewNeedleLabel.setBounds(970, 580, 100, 14);

        boneSawLabel.setForeground(new java.awt.Color(255, 0, 51));
        boneSawLabel.setText("BONE SAW");
        getContentPane().add(boneSawLabel);
        boneSawLabel.setBounds(5, 580, 70, 14);

        mrV.setText("mrV good");
        getContentPane().add(mrV);
        mrV.setBounds(480, 20, 180, 190);

        mrVHurt.setText("mrVbad");
        mrVHurt.setMaximumSize(new java.awt.Dimension(45, 14));
        mrVHurt.setMinimumSize(new java.awt.Dimension(45, 14));
        mrVHurt.setPreferredSize(new java.awt.Dimension(45, 14));
        getContentPane().add(mrVHurt);
        mrVHurt.setBounds(480, 20, 180, 190);

        background.setText("background");
        getContentPane().add(background);
        background.setBounds(0, 0, 1080, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //is key is pressed
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //prints KeyCode for the key pressed
        // System.out.println(evt.getKeyCode());

        //spacebar key pressed
        if (evt.getKeyCode() == 32) {
            //if the bonesaw is clicked unclick is and return it to its original location
            if (bonesaw.isClicked == true) {
                bonesaw.isClicked = false;
                bonesaw.toolLabel.setLocation(10, 430);
            //if the needle is clicked unclick it and return it to its original location
            } else if (needle.isClicked == true) {
                needle.isClicked = false;
                needle.toolLabel.setLocation(980, 430);
            }
        }

    }//GEN-LAST:event_formKeyPressed
    //makes it so the image follows the cursor
    private void moveTool() {
        //gets mouse cordinates
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();
        //if bonesaw is clicked than set the bonesaw image location to just below the mouse
        if (bonesaw.getClicked() == true) {
            bonesaw.getLabel().setLocation((mx - 32), (my - 30));
        //if needle is clicked than set the needle image location to just below the mouse
        } else if (needle.getClicked() == true) {
            needle.getLabel().setLocation((mx - 45), (my - 30));
        }
    }


    private void boneSawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boneSawMouseClicked
        //using the tool class is setss the isclicked proptert to true when you click it
        //the other tools must not be clicked and that is what the if statmetent is for
        System.out.println(needle.isClicked);
        if (needle.isClicked == false) {
             bonesaw.isClicked = true;
        }
    }//GEN-LAST:event_boneSawMouseClicked
    //folloing events move image with the mouse overthe form or bonesaw image whenever the mouse is moved 
    private void boneSawMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boneSawMouseMoved
        moveTool();
    }//GEN-LAST:event_boneSawMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        moveTool();
    }//GEN-LAST:event_formMouseMoved

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        moveTool();
    }//GEN-LAST:event_formMouseDragged

    private void boneSawMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boneSawMouseDragged
        moveTool();
    }//GEN-LAST:event_boneSawMouseDragged
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked
    //if the first cutbox is exited
    private void cutBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBoxMouseExited
        //if the user has a tool equiped and they exit the box, call the injured function
        if (cutClick == true & bonesaw.isClicked == true) {
            //if they exit it from the bottom don't call the injured function
            if (mx > 433 & mx < 449 & my > 400 & my < 430) {
            } else {
                injured();
            }
        }
    }//GEN-LAST:event_cutBoxMouseExited
    //action event if they press the form
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        //gets the mouse coordinates
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();
        //if the bonesaw is eqiped
        if (bonesaw.isClicked == true) {
            //check to see if the user has clicked above a cutbox
            if (mx > 433 & mx < 449 & my < 340 & my > 320) {
                //if they do make cutClick = true which esstianly tells the program the've started a cut
                cutClick = true;
            } else if (mx > 414 & mx < 426 & my < 470 & my > 453) {
                cutClick2 = true;
            } else if (mx > 465 & mx < 477 & my < 597 & my > 580) {
                cutClick3 = true;
            } else if (mx > 665 & mx < 677 & my < 340 & my > 322) {
                cutClick4 = true;
            } else if (mx > 676 & mx < 688 & my < 468 & my > 452) {
                cutClick5 = true;
            } else if (mx > 646 & mx < 658 & my < 600 & my > 585) {
                cutClick6 = true;
                //if they don't. Call injured function
            } else {
                injured();
            }
        //if the needle is clicked
        } else if (needle.isClicked == true) {
            //check to see where the click
            if (mx > 594 & mx < 630 & my < 429 & my > 410) {
                //if its above the right cutbox,start cut (sewClick = true)
                sewClick = true;
            } else {
                //if it isn't, injured
                injured();
            }
        }
    }//GEN-LAST:event_formMousePressed
    //action event when they release the mouse
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        //gets mouse coordinates
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();
        //if the cut is started and the corressponign box has been entered
        if (cutClick == true & boxEntered == true) {
            //checks coordinates
            if (mx > 433 & mx < 449 & my > 410 & my < 430) {
                //if they realse in the right spot call the sucsess fuction
                success();
                //hide cut box
                cutBox.setVisible(false);
                //if they don'r release in the right spot
            } else {
                //call injured function
                injured();
                //set the cut and boxentered booleans to false
                boxEntered = false;
            }
            //sets cutClick = false so they have to start cut over again
            cutClick = false;
        //following ifs the same as previous if with differnet boxes and differert coordinates
        } else if (cutClick2 == true & boxEntered2 == true) {
            System.out.println("cutClick 2 is:" + cutClick2);
            if (mx > 414 & mx < 426 & my > 550 & my < 567) {
                System.out.println("Awesome");
                success();
                cutBox2.setVisible(false);
            } else {
                injured();
                boxEntered2 = false;
                cutClick2 = false;
            }
            cutClick2 = false;
        } else if (cutClick3 == true & boxEntered3 == true) {
            System.out.println("cutClick 3 is:" + cutClick3);
            if (mx > 464 & mx < 478 & my > 691 & my < 701) {
                System.out.println("Awesome");
                success();
                cutBox3.setVisible(false);
            } else {
                injured();
                boxEntered3 = false;
                cutClick3 = false;
            }
            cutClick3 = false;
        } else if (cutClick4 == true & boxEntered4 == true) {
            System.out.println("cutClick 4 is:" + cutClick4);
            if (mx > 665 & mx < 678 & my > 411 & my < 424) {
                System.out.println("Awesome");
                success();
                cutBox4.setVisible(false);
            } else {
                injured();
                boxEntered4 = false;
                cutClick4 = false;
            }
            cutClick4 = false;
        } else if (cutClick5 == true & boxEntered5 == true) {
            System.out.println("cutClick 5 is:" + cutClick5);
            if (mx > 677 & mx < 690 & my > 552 & my < 561) {
                System.out.println("Awesome");
                success();
                cutBox5.setVisible(false);
            } else {
                injured();
                boxEntered5 = false;
                cutClick5 = false;
            }
            cutClick5 = false;
        } else if (cutClick6 == true & boxEntered6 == true) {
            System.out.println("cutClick 6 is:" + cutClick6);
            if (mx > 646 & mx < 658 & my > 690 & my < 704) {
                System.out.println("Awesome");
                success();
                cutBox6.setVisible(false);
            } else {
                injured();
                boxEntered6 = false;
                cutClick6 = false;
            }
            cutClick6 = false;
        } else if (sewClick == true & sewBoxEntered == true) {
            if (mx > 594 & mx < 630 & my > 522 & my < 538) {
                System.out.println("Awesome");
                success();
                sewBox.setVisible(false);
            } else {
                injured();
                sewClick = false;
            }
            sewClick = false;
            //else if the player never enters the box
            //resets everything so they have to go throught the box
        } else {
            cutClick = false;
            cutClick2 = false;
            cutClick3 = false;
            cutClick4 = false;
            cutClick5 = false;
            cutClick6 = false;
            sewClick = false;
        }
    }//GEN-LAST:event_formMouseReleased

    private void boneSawMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boneSawMousePressed

    }//GEN-LAST:event_boneSawMousePressed

    private void boneSawMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boneSawMouseReleased

    }//GEN-LAST:event_boneSawMouseReleased

    private void cutBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cutBoxFocusLost

    }//GEN-LAST:event_cutBoxFocusLost
        //following events call the move tool function so the tool can move over the cut boxes
    private void cutBoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBoxMouseMoved
        moveTool();
    }//GEN-LAST:event_cutBoxMouseMoved

    private void cutBoxMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBoxMouseDragged
        moveTool();
    }//GEN-LAST:event_cutBoxMouseDragged

    private void cutBox2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox2MouseMoved
        moveTool();
    }//GEN-LAST:event_cutBox2MouseMoved

    private void cutBox2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox2MouseDragged
        moveTool();
    }//GEN-LAST:event_cutBox2MouseDragged

    private void cutBox3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox3MouseMoved
        moveTool();
    }//GEN-LAST:event_cutBox3MouseMoved

    private void cutBox3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox3MouseDragged
        moveTool();
    }//GEN-LAST:event_cutBox3MouseDragged

    private void cutBox4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox4MouseDragged
        moveTool();
    }//GEN-LAST:event_cutBox4MouseDragged

    private void cutBox4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox4MouseMoved
        moveTool();
    }//GEN-LAST:event_cutBox4MouseMoved

    private void cutBox5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox5MouseDragged
        moveTool();
    }//GEN-LAST:event_cutBox5MouseDragged

    private void cutBox5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox5MouseMoved
        moveTool();
    }//GEN-LAST:event_cutBox5MouseMoved

    private void cutBox6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox6MouseDragged
        moveTool();
    }//GEN-LAST:event_cutBox6MouseDragged

    private void cutBox6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox6MouseMoved
        moveTool();
    }//GEN-LAST:event_cutBox6MouseMoved

    private void cutBox2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox2MouseExited
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();

        if (cutClick2 == true & bonesaw.isClicked == true) {
            if (mx > 414 & mx < 426 & my > 550 & my < 567) {
            } else {
                injured();
            }
        }
    }//GEN-LAST:event_cutBox2MouseExited

    private void cutBox3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox3MouseExited
        //gets mouse coordinates 
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();
        //if the user has a tool equiped and they exit the box, call the injured function
        if (cutClick3 == true & bonesaw.isClicked == true) {
            //if they exit it from the bottom don't call the injured function
            if (mx > 464 & mx < 478 & my > 681 & my < 701) {
            } else {
                injured();
            }
        }
    }//GEN-LAST:event_cutBox3MouseExited
    //following events same as previous event jsut with differnt coordaintes and boxes 
    private void cutBox4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox4MouseExited
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();

        System.out.println("Exited");
        if (cutClick4 == true & bonesaw.isClicked == true) {
            if (mx > 665 & mx < 678 & my > 401 & my < 424) {
            } else {
                injured();
            }
        }
    }//GEN-LAST:event_cutBox4MouseExited

    private void cutBox5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox5MouseExited
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();

        if (cutClick5 == true & bonesaw.isClicked == true) {
            if (mx > 677 & mx < 690 & my > 542 & my < 561) {
            } else {
                injured();
            }
        }
    }//GEN-LAST:event_cutBox5MouseExited

    private void cutBox6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox6MouseExited
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();

        if (cutClick6 == true & bonesaw.isClicked == true) {
            if (mx > 646 & mx < 658 & my > 690 & my < 704) {
            } else {
                injured();
            }
        }
    }//GEN-LAST:event_cutBox6MouseExited
    //event if the needle is clicked
    private void sewNeedleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewNeedleMouseClicked
        //if to ensure no other tools are clicked
        if (bonesaw.isClicked == false) {
            needle.setClicked(true);
        } 
    }//GEN-LAST:event_sewNeedleMouseClicked
        //makes it so you ca drag the tool over the sewBox
    private void sewNeedleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewNeedleMouseDragged
        moveTool();
    }//GEN-LAST:event_sewNeedleMouseDragged
        //makes it so you ca move the tool over the sewBox
    private void sewNeedleMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewNeedleMouseMoved
        moveTool();
    }//GEN-LAST:event_sewNeedleMouseMoved
        //evet if the sewBox is exited
    private void sewBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewBoxMouseExited
        //gets mouse coordinates
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();
        //if the cut is started adn the needle is equiped 
        if (sewClick == true && needle.isClicked == true) {
            //if it is existed from the bottom
            if (mx > 594 & mx < 630 & my > 502 & my < 538) {
                //if it's not existed from the bottom
            } else {
                //calls injured fucntion 
                injured();
            }
        }
    }//GEN-LAST:event_sewBoxMouseExited
    //following events check to see if the player has dragged the mouse through a cutbox when cutting
    private void sewBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewBoxMouseEntered
        //for this to occur a tool must be equiped and the cut started
        if (needle.isClicked == true && sewClick == true) {
            sewBoxEntered = true;
        }
    }//GEN-LAST:event_sewBoxMouseEntered

    private void cutBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBoxMouseEntered
        if (bonesaw.isClicked == true && cutClick == true) {
            boxEntered = true;
            System.out.println("boxEntered is: " + boxEntered);
        }
    }//GEN-LAST:event_cutBoxMouseEntered

    private void cutBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox2MouseEntered
        if (bonesaw.isClicked == true && cutClick2 == true) {
            boxEntered2 = true;
            System.out.println("boxEntered2 is: " + boxEntered2);
        }
    }//GEN-LAST:event_cutBox2MouseEntered

    private void cutBox3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox3MouseEntered
        if (bonesaw.isClicked == true && cutClick3 == true) {
            boxEntered3 = true;
        }
    }//GEN-LAST:event_cutBox3MouseEntered

    private void cutBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox4MouseEntered
        if (bonesaw.isClicked == true && cutClick4 == true) {
            boxEntered4 = true;
        }
    }//GEN-LAST:event_cutBox4MouseEntered

    private void cutBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox5MouseEntered
        if (bonesaw.isClicked == true && cutClick5 == true) {
            boxEntered5 = true;
        }
    }//GEN-LAST:event_cutBox5MouseEntered

    private void cutBox6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox6MouseEntered
        if (bonesaw.isClicked == true && cutClick6 == true) {
            boxEntered6 = true;
        }
    }//GEN-LAST:event_cutBox6MouseEntered

    private void sewBoxMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewBoxMouseDragged
        moveTool();
    }//GEN-LAST:event_sewBoxMouseDragged

    private void sewBoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewBoxMouseMoved
        moveTool();
    }//GEN-LAST:event_sewBoxMouseMoved

    private void cutBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBoxMouseClicked

    }//GEN-LAST:event_cutBoxMouseClicked
    //injured mrV when the following images are clicked
    private void cutBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBoxMousePressed
        injured();
    }//GEN-LAST:event_cutBoxMousePressed

    private void cutBox2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox2MousePressed
        injured();
    }//GEN-LAST:event_cutBox2MousePressed

    private void cutBox3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox3MousePressed
        injured();
    }//GEN-LAST:event_cutBox3MousePressed

    private void cutBox4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox4MousePressed
        injured();
    }//GEN-LAST:event_cutBox4MousePressed

    private void cutBox5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox5MousePressed
        injured();
    }//GEN-LAST:event_cutBox5MousePressed

    private void cutBox6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox6MousePressed
        injured();
    }//GEN-LAST:event_cutBox6MousePressed

    private void sewBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewBoxMousePressed
        injured();
    }//GEN-LAST:event_sewBoxMousePressed

    /**
     * Creates new form NewJFrame
     */
   //Initializes the labels with their images
    public void myInitComponents(javax.swing.JLabel jLabel1) {
        //Initialize a Buffered Image
        BufferedImage img = null;
        //catched IOException
        try {
            //initilizes images
            background.setIcon(new ImageIcon((ImageIO.read(new File("JSumBackground.png"))).getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));
            ribs.setIcon(new ImageIcon((ImageIO.read(new File("JSumRibs.png"))).getScaledInstance(ribs.getWidth(), ribs.getHeight(), Image.SCALE_SMOOTH)));
            cutBox.setIcon(new ImageIcon((ImageIO.read(new File("cutBox.png"))).getScaledInstance(cutBox.getWidth(), cutBox.getHeight(), Image.SCALE_SMOOTH)));
            cutBox2.setIcon(new ImageIcon((ImageIO.read(new File("cutBox.png"))).getScaledInstance(cutBox2.getWidth(), cutBox2.getHeight(), Image.SCALE_SMOOTH)));
            cutBox3.setIcon(new ImageIcon((ImageIO.read(new File("cutBox.png"))).getScaledInstance(cutBox3.getWidth(), cutBox3.getHeight(), Image.SCALE_SMOOTH)));
            cutBox4.setIcon(new ImageIcon((ImageIO.read(new File("cutBox.png"))).getScaledInstance(cutBox4.getWidth(), cutBox4.getHeight(), Image.SCALE_SMOOTH)));
            cutBox5.setIcon(new ImageIcon((ImageIO.read(new File("cutBox.png"))).getScaledInstance(cutBox5.getWidth(), cutBox5.getHeight(), Image.SCALE_SMOOTH)));
            cutBox6.setIcon(new ImageIcon((ImageIO.read(new File("cutBox.png"))).getScaledInstance(cutBox6.getWidth(), cutBox6.getHeight(), Image.SCALE_SMOOTH)));
            hurt.setIcon(new ImageIcon((ImageIO.read(new File("blood.png"))).getScaledInstance(hurt.getWidth(), hurt.getHeight(), Image.SCALE_SMOOTH)));
            cut.setIcon(new ImageIcon((ImageIO.read(new File("scissors.png"))).getScaledInstance(cut.getWidth(), cut.getHeight(), Image.SCALE_SMOOTH)));
            badHeart.setIcon(new ImageIcon((ImageIO.read(new File("badHeart.png"))).getScaledInstance(badHeart.getWidth(), badHeart.getHeight(), Image.SCALE_SMOOTH)));
            sewBox.setIcon(new ImageIcon((ImageIO.read(new File("cutBox.png"))).getScaledInstance(sewBox.getWidth(), sewBox.getHeight(), Image.SCALE_SMOOTH)));
            mrVHurt.setIcon(new ImageIcon((ImageIO.read(new File("mrVbad.jpg"))).getScaledInstance(mrVHurt.getWidth(), mrVHurt.getHeight(), Image.SCALE_SMOOTH)));
            mrV.setIcon(new ImageIcon((ImageIO.read(new File("mrVnormal.jpg"))).getScaledInstance(mrV.getWidth(), mrV.getHeight(), Image.SCALE_SMOOTH)));
            sewNeedle.setIcon(new ImageIcon((ImageIO.read(new File("sewNeedle.png"))).getScaledInstance(sewNeedle.getWidth(), sewNeedle.getHeight(), Image.SCALE_SMOOTH)));
            boneSaw.setIcon(new ImageIcon((ImageIO.read(new File("JSumBoneSaw.png"))).getScaledInstance(boneSaw.getWidth(), boneSaw.getHeight(), Image.SCALE_SMOOTH)));
            //initilizes tools
            needle = new Tool(sewNeedle, 6);
            bonesaw = new Tool(boneSaw, 12);
        } catch (IOException ex) {
            Logger.getLogger(JohnF.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JohnF.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JohnF.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JohnF.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JohnF.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JohnF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel badHeart;
    private javax.swing.JLabel boneSaw;
    private javax.swing.JLabel boneSawLabel;
    private javax.swing.JLabel cut;
    private javax.swing.JLabel cutBox;
    private javax.swing.JLabel cutBox2;
    private javax.swing.JLabel cutBox3;
    private javax.swing.JLabel cutBox4;
    private javax.swing.JLabel cutBox5;
    private javax.swing.JLabel cutBox6;
    private javax.swing.JProgressBar healthBar;
    private javax.swing.JLabel hurt;
    private javax.swing.JLabel mrV;
    private javax.swing.JLabel mrVHurt;
    private javax.swing.JLabel ribs;
    private javax.swing.JLabel sewBox;
    private javax.swing.JLabel sewNeedle;
    private javax.swing.JLabel sewNeedleLabel;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
