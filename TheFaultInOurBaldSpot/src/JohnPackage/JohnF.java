
/*
 * Written by Mr. van Straten
 * May 21, 2019
 * JFrameImages
 * This is a demo program for images and collision detection
 */
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JohnF extends javax.swing.JFrame {

    int mx, my;
    boolean boneSawClick = false;
    boolean sewNeedleClick = false;
    boolean cutClick = false;
    boolean cutClick2 = false;
    boolean cutClick3 = false;
    boolean cutClick4 = false;
    boolean cutClick5 = false;
    boolean cutClick6 = false;
    boolean boxEntered = false;
    boolean boxEntered6 = false;
    boolean boxEntered2 = false;
    boolean boxEntered3 = false;
    boolean boxEntered4 = false;
    boolean boxEntered5 = false;
    boolean sewClick = false;
    int healthValue = 100;
    int counter = 0;
    int gameCounter = 120;
    int leftCounter = 0;
    int rightCounter = 0;
    int score = 0;
    Tool needle, bonesaw;
    boolean sewBoxEntered = false;

    private void injured() {
        Timer injuredTimer = new Timer();
        TimerTask stopInjured = new TimerTask() {
            public void run() {
                hurt.setVisible(false);
            }

        };
        injuredTimer.schedule(stopInjured, 500);
        System.out.println("injured");
        if (bonesaw.isClicked == true) {
            healthValue = healthValue - bonesaw.getDamage();
        } else if (needle.isClicked == true) {
            healthValue = healthValue - needle.getDamage();
        }
        healthBar.setValue(healthValue);
        System.out.println(healthValue);
        if (healthBar.getValue() == 0) {
            endGame();
        }
        hurt.show();
    }

    private void endGame() {
        score = fact(healthBar.getValue() * gameCounter);
        System.out.println("Your score is: " + score);
        try {
            highScore();
        } catch (IOException e) {
        }
    }

    public static int fact(int n) {
        if ((n == 0) || (n == 1)) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    private void highScore() throws IOException {
        PrintWriter fileOut = new PrintWriter(new FileWriter("HighScores.txt", true));
        fileOut.println(score);
        fileOut.close();
    }

    private void success() {
        counter++;
        Timer cutTimer = new Timer();
        TimerTask stopCut = new TimerTask() {
            public void run() {
                cut.setVisible(false);
            }
        };
        cutTimer.schedule(stopCut, 500);
        cut.setVisible(true);
        if (counter == 6) {
            ribs.setVisible(false);
            sewBox.setVisible(true);
            SewBoxTimer();
        } else if (counter == 7) {
            endGame();
        }
    }

    public void gameCounter() {
        Timer gameTimer = new Timer();
        TimerTask stopGame = new TimerTask() {
            public void run() {
                time.setText(String.valueOf(gameCounter));
                gameCounter--;
                if (gameCounter == 0) {
                    endGame();
                }
            }
        };
        gameTimer.scheduleAtFixedRate(stopGame, 1000, 1000);
    }

    public void SewBoxTimer() {
        Timer heartTimer = new Timer();
        TimerTask moveBox = new TimerTask() {
            public void run() {
                leftCounter++;
                if (leftCounter <= 15) {
                    sewBox.setLocation(sewBox.getLocation().x - 1, sewBox.getLocation().y);
                } else if (leftCounter > 15 & leftCounter <= 45) {
                    sewBox.setLocation(sewBox.getLocation().x + 1, sewBox.getLocation().y);
                } else if (leftCounter >= 45 & leftCounter < 76) {
                    sewBox.setLocation(sewBox.getLocation().x - 1, sewBox.getLocation().y);
                } else if (leftCounter > 75) {
                    leftCounter = 15;
                }
            }
        };
        heartTimer.scheduleAtFixedRate(moveBox, 50, 50);
    }

    public JohnF() {
        initComponents();
        healthBar.setValue(100);
        int health = 100;
        //Initialize the label with the scaled image icon
        myInitComponents(background);
        hurt.hide();
        sewBox.setVisible(false);
        cut.setVisible(false);
        gameCounter();

        ribs.setVisible(false);
        SewBoxTimer();
        sewBox.setVisible(true);
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
        healthBar.setBounds(20, 10, 148, 14);

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cutBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cutBoxMouseExited(evt);
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
        sewNeedleLabel.setBounds(970, 580, 100, 15);

        boneSawLabel.setForeground(new java.awt.Color(255, 0, 51));
        boneSawLabel.setText("BONE SAW");
        getContentPane().add(boneSawLabel);
        boneSawLabel.setBounds(5, 580, 70, 15);

        background.setText("background");
        getContentPane().add(background);
        background.setBounds(0, 0, 1080, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //check if a collision between images is occurring
    private boolean checkCollision(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

//check if temporary rectangle intersect with wallLabel        
        if (rect.intersects(time.getBounds())) {
            return true;
        } else {
            return false;
        }
    }

    //checks which key is pressed and moves image if no collision is detected
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //prints KeyCode for the key pressed
        // System.out.println(evt.getKeyCode());

        //up key pressed
        if (evt.getKeyCode() == 32) {
            if (bonesaw.isClicked == true) {
                bonesaw.isClicked = false;
                bonesaw.toolLabel.setLocation(10, 430);
            } else if (needle.isClicked == true) {
                needle.isClicked = false;
                needle.toolLabel.setLocation(980, 430);
            }
        }

    }//GEN-LAST:event_formKeyPressed

    private void moveTool() {
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();
        if (bonesaw.getClicked() == true) {
            bonesaw.getLabel().setLocation((mx - 32), (my - 30));
        } else if (needle.getClicked() == true) {
            needle.getLabel().setLocation((mx - 45), (my - 30));
        }
    }


    private void boneSawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boneSawMouseClicked
//        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
//                new ImageIcon("JSumBoneSaw.png").getImage(),
//                new Point(0, 0), "custom cursor"));
        bonesaw.isClicked = true;
//        int counter = 0;
//        counter++;
    }//GEN-LAST:event_boneSawMouseClicked

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
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();

        System.out.println(mx + ", " + my);


    }//GEN-LAST:event_formMouseClicked

    private void cutBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBoxMouseExited
        System.out.println("Exited");
        if (cutClick == true & bonesaw.isClicked == true) {
            injured();
        }
    }//GEN-LAST:event_cutBoxMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();
        if (bonesaw.isClicked == true) {
            if (mx > 433 & mx < 449 & my < 340 & my > 320) {
                cutClick = true;
                System.out.println("cutClick is: " + cutClick);
            } else if (mx > 414 & mx < 426 & my < 470 & my > 453) {
                cutClick2 = true;
                 System.out.println("cutClick2 is: " + cutClick2);
            } else if (mx > 465 & mx < 477 & my < 597 & my > 580) {
                cutClick3 = true;
            } else if (mx > 665 & mx < 677 & my < 340 & my > 322) {
                cutClick4 = true;
                System.out.println("hello");
            } else if (mx > 676 & mx < 688 & my < 468 & my > 452) {
                cutClick5 = true;
            } else if (mx > 646 & mx < 658 & my < 600 & my > 585) {
                cutClick6 = true;
            } else {
                injured();
            }
        } else if (needle.isClicked == true) {
            System.out.println("PLeaseee");
            if (mx > 594 & mx < 630 & my < 429 & my > 410) {
                sewClick = true;
                System.out.println("Reconginzed");
            } else {
                System.out.println("PLeaseee");
                injured();
            }
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        mx = (int) MouseInfo.getPointerInfo().getLocation().getX();
        my = (int) MouseInfo.getPointerInfo().getLocation().getY();
        if (cutClick == true & boxEntered == true) {
            if (mx > 433 & mx < 449 & my > 410 & my < 430) {
                System.out.println("Awesome");
                success();
                cutBox.setVisible(false);
                cutClick = false;
            } else {
                injured();
                System.out.println("hello");
                boxEntered = false;
                cutClick = false;
                System.out.println(cutClick);
            }
            cutClick = false;
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
        System.out.println("Exited");
        if (cutClick2 == true & bonesaw.isClicked == true) {
            injured();
        }
    }//GEN-LAST:event_cutBox2MouseExited

    private void cutBox3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox3MouseExited
        System.out.println("Exited");
        if (cutClick3 == true & bonesaw.isClicked == true) {
            injured();
        }
    }//GEN-LAST:event_cutBox3MouseExited

    private void cutBox4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox4MouseExited
        System.out.println("Exited");
        if (cutClick4 == true & bonesaw.isClicked == true) {
            injured();
        }
    }//GEN-LAST:event_cutBox4MouseExited

    private void cutBox5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox5MouseExited
        System.out.println("Exited");
        if (cutClick5 == true & bonesaw.isClicked == true) {
            injured();
        }
    }//GEN-LAST:event_cutBox5MouseExited

    private void cutBox6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutBox6MouseExited
        System.out.println("Exited");
        if (cutClick6 == true & bonesaw.isClicked == true) {
            injured();
        }
    }//GEN-LAST:event_cutBox6MouseExited

    private void sewNeedleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewNeedleMouseClicked
        needle.setClicked(true);
    }//GEN-LAST:event_sewNeedleMouseClicked

    private void sewNeedleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewNeedleMouseDragged
        moveTool();
    }//GEN-LAST:event_sewNeedleMouseDragged

    private void sewNeedleMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewNeedleMouseMoved
        moveTool();
    }//GEN-LAST:event_sewNeedleMouseMoved

    private void sewBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewBoxMouseExited
        if (sewClick == true && needle.isClicked == true) {
            injured();
        }
    }//GEN-LAST:event_sewBoxMouseExited

    private void sewBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewBoxMouseEntered
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

    /**
     * Creates new form NewJFrame
     */
//Initializes the labels with their images
    public void myInitComponents(javax.swing.JLabel jLabel1) {
        //Initialize a Buffered Image
        BufferedImage img = null;

        //same as above, but in a condensed version
        try {

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

            sewNeedle.setIcon(new ImageIcon((ImageIO.read(new File("SewNeedle.png"))).getScaledInstance(sewNeedle.getWidth(), sewNeedle.getHeight(), Image.SCALE_SMOOTH)));

            needle = new Tool(sewNeedle, 3);
            bonesaw = new Tool(boneSaw, 6);
            boneSaw.setIcon(new ImageIcon((ImageIO.read(new File("JSumBoneSaw.png"))).getScaledInstance(boneSaw.getWidth(), boneSaw.getHeight(), Image.SCALE_SMOOTH)));

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
    private javax.swing.JLabel ribs;
    private javax.swing.JLabel sewBox;
    private javax.swing.JLabel sewNeedle;
    private javax.swing.JLabel sewNeedleLabel;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
