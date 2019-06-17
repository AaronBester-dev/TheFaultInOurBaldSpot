package Brayden;

/*
 * Written by Brayden McQueen
 *Started: May 21, 2019
 *Finished; June 17, 2019
 * Brayden's Game
 * Game that makes the user feed poor homless people and do it fast!
 */
//imports
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
import Brayden.EndBrayden;
import Brayden.EndBraydenBad;
//delcaring variables
public class Brayden1 extends javax.swing.JFrame {
public int score = 0;
public int counter = 150;
public int counterO = 15;
public int counterT = 20;
public int counterTh = 25;
public int counterF = 30;
public int counterFi = 35;
public int counterS = 40;
public int counterC = 4;
public int counterC2 = 4;
public int counterC3 = 4;
public character me;// = new character();
public Pot potOne = new Pot();
public Pot potTwo = new Pot();
public Pot potThree = new Pot();
//makes array of soups
soup soupBoy[] = new soup[6];
//This makes all of the timers used in the game
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            counter--;
            timerBoy.setText(String.valueOf(counter));
            if (counter == 0) {
                if(score>120){
     EndBrayden braydenObject = new EndBrayden();
     braydenObject.setVisible(true);
                }else{
     EndBraydenBad braydenBObject = new EndBraydenBad();
     braydenBObject.setVisible(true);   
                }
            }
        }
    };
    Timer timerO = new Timer();
    TimerTask taskO = new TimerTask() {
        public void run() {

            counterO--;

            if (counterO == 0) {
                soupBoy[0] = new soup();
                try {
                    orderOne.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[0].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                counterO = 15;
            }

        }
    };
    Timer timerT = new Timer();
    TimerTask taskT = new TimerTask() {
        public void run() {
            counterT--;

            if (counterT == 0) {
                soupBoy[1] = new soup();
                try {
                    orderTwo.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[1].getPhotoCode()))).getScaledInstance(orderTwo.getWidth(), orderTwo.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                counterT = 15;
            }

        }
    };
    Timer timerTh = new Timer();
    TimerTask taskTh = new TimerTask() {
        public void run() {
            counterTh--;

            if (counterTh == 0) {
                soupBoy[2] = new soup();
                try {
                    orderThree.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[2].getPhotoCode()))).getScaledInstance(orderThree.getWidth(), orderThree.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                counterTh = 15;
            }

        }
    };
    Timer timerF = new Timer();
    TimerTask taskF = new TimerTask() {
        public void run() {
            counterF--;

            if (counterF == 0) {
                soupBoy[3] = new soup();
                try {
                    orderFour.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[3].getPhotoCode()))).getScaledInstance(orderFour.getWidth(), orderFour.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                counterF = 15;
            }

        }
    };
    Timer timerFi = new Timer();
    TimerTask taskFi = new TimerTask() {
        public void run() {
            counterFi--;

            if (counterFi == 0) {
                soupBoy[4] = new soup();
                try {
                    orderFive.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[4].getPhotoCode()))).getScaledInstance(orderFive.getWidth(), orderFive.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                counterFi = 15;
            }

        }
    };
    Timer timerS = new Timer();
    TimerTask taskS = new TimerTask() {
        public void run() {
            counterS--;

            if (counterS == 0) {
                soupBoy[5] = new soup();
                try {
                    orderSix.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[5].getPhotoCode()))).getScaledInstance(orderSix.getWidth(), orderSix.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                counterS = 15;
            }

        }
    };
    Timer timerCook = new Timer();
    TimerTask taskC = new TimerTask() {

        public void run() {
            counterC--;

            if (counterC == 0) {
             //   System.out.println("boob");
                if (potOne.getMushroom()) {
                    potOne.setMushroom(false);
                    potOne.setMushroomS(true);

                    try {
                        potV.setIcon(new ImageIcon((ImageIO.read(new File("mushroomSoup.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (potOne.getPotato()) {
                    potOne.setPotato(false);
                    potOne.setPotatoS(true);

                    try {
                        potV.setIcon(new ImageIcon((ImageIO.read(new File("potatoSoup.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (potOne.getTomato()) {
                    potOne.setTomato(false);
                    potOne.setTomatoS(true);

                    try {
                        potV.setIcon(new ImageIcon((ImageIO.read(new File("tomatoSoup.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }
    };
    Timer timerCook2 = new Timer();
    TimerTask taskC2 = new TimerTask() {

        public void run() {
            counterC2--;

            if (counterC2 == 0) {
               // System.out.println("boob");
                if (potTwo.getMushroom()) {
                    potTwo.setMushroom(false);
                    potTwo.setMushroomS(true);

                    try {
                        potV1.setIcon(new ImageIcon((ImageIO.read(new File("mushroomSoup.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (potTwo.getPotato()) {
                    potTwo.setPotato(false);
                    potTwo.setPotatoS(true);

                    try {
                        potV1.setIcon(new ImageIcon((ImageIO.read(new File("potatoSoup.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (potTwo.getTomato()) {
                    potTwo.setTomato(false);
                    potTwo.setTomatoS(true);

                    try {
                        potV1.setIcon(new ImageIcon((ImageIO.read(new File("tomatoSoup.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }
    };
    Timer timerCook3 = new Timer();
    TimerTask taskC3 = new TimerTask() {

        public void run() {
            counterC3--;

            if (counterC3 == 0) {
              //  System.out.println("boob");
                if (potThree.getMushroom()) {
                //    System.out.println("boob");
                    potThree.setMushroom(false);
                    potThree.setMushroomS(true);

                    try {
                        potV2.setIcon(new ImageIcon((ImageIO.read(new File("mushroomSoup.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (potThree.getPotato()) {
               //     System.out.println("boob");
                    potThree.setPotato(false);
                    potThree.setPotatoS(true);

                    try {
                        potV2.setIcon(new ImageIcon((ImageIO.read(new File("potatoSoup.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (potOne.getTomato()) {
                    potThree.setTomato(false);
                    potThree.setTomatoS(true);

                    try {
                        potV2.setIcon(new ImageIcon((ImageIO.read(new File("tomatoSoup.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scoreV = new javax.swing.JLabel();
        potV2 = new javax.swing.JLabel();
        potV1 = new javax.swing.JLabel();
        potV = new javax.swing.JLabel();
        itemV = new javax.swing.JLabel();
        timerBoy1 = new javax.swing.JLabel();
        orderOne = new javax.swing.JLabel();
        orderTwo = new javax.swing.JLabel();
        orderThree = new javax.swing.JLabel();
        orderFour = new javax.swing.JLabel();
        orderFive = new javax.swing.JLabel();
        orderSix = new javax.swing.JLabel();
        timerBoy = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        wallLabel = new javax.swing.JLabel();
        wallLabel1 = new javax.swing.JLabel();
        pot = new javax.swing.JLabel();
        potato = new javax.swing.JLabel();
        tomato = new javax.swing.JLabel();
        bar = new javax.swing.JLabel();
        dryRack = new javax.swing.JLabel();
        onion = new javax.swing.JLabel();
        pot1 = new javax.swing.JLabel();
        pot2 = new javax.swing.JLabel();
        table = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 178, 59));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setForeground(new java.awt.Color(102, 0, 0));
        setName("mainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1080, 880));
        setSize(new java.awt.Dimension(1080, 720));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        scoreV.setBackground(new java.awt.Color(255, 51, 51));
        scoreV.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        scoreV.setForeground(new java.awt.Color(255, 0, 51));
        scoreV.setText("0");
        getContentPane().add(scoreV);
        scoreV.setBounds(410, 10, 70, 70);

        potV2.setText("V");
        getContentPane().add(potV2);
        potV2.setBounds(470, 120, 30, 30);

        potV1.setText("V");
        getContentPane().add(potV1);
        potV1.setBounds(330, 120, 30, 30);

        potV.setText("V");
        getContentPane().add(potV);
        potV.setBounds(180, 120, 30, 30);

        itemV.setBackground(new java.awt.Color(255, 51, 51));
        itemV.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        itemV.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(itemV);
        itemV.setBounds(310, 10, 70, 70);

        timerBoy1.setBackground(new java.awt.Color(255, 51, 51));
        timerBoy1.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        timerBoy1.setForeground(new java.awt.Color(255, 0, 51));
        timerBoy1.setText("15");
        getContentPane().add(timerBoy1);
        timerBoy1.setBounds(530, 10, 70, 70);

        orderOne.setText("orderOne");
        getContentPane().add(orderOne);
        orderOne.setBounds(540, 10, 60, 60);
        orderOne.getAccessibleContext().setAccessibleName("order1");

        orderTwo.setText("orderTwo");
        getContentPane().add(orderTwo);
        orderTwo.setBounds(650, 10, 60, 60);

        orderThree.setText("orderThree");
        getContentPane().add(orderThree);
        orderThree.setBounds(730, 10, 60, 60);

        orderFour.setText("orderFour");
        getContentPane().add(orderFour);
        orderFour.setBounds(830, 10, 60, 60);

        orderFive.setText("orderFive");
        getContentPane().add(orderFive);
        orderFive.setBounds(920, 10, 60, 60);

        orderSix.setText("orderSix");
        getContentPane().add(orderSix);
        orderSix.setBounds(1010, 10, 60, 60);

        timerBoy.setBackground(new java.awt.Color(255, 51, 51));
        timerBoy.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        timerBoy.setForeground(new java.awt.Color(255, 0, 51));
        timerBoy.setText("120");
        getContentPane().add(timerBoy);
        timerBoy.setBounds(100, 10, 70, 70);

        user.setText("User");
        getContentPane().add(user);
        user.setBounds(10, 371, 102, 127);

        wallLabel.setText("wall1");
        getContentPane().add(wallLabel);
        wallLabel.setBounds(0, 836, 1080, 22);
        wallLabel.getAccessibleContext().setAccessibleName("wallLabel");
        wallLabel.getAccessibleContext().setAccessibleDescription("");

        wallLabel1.setText("wall2");
        getContentPane().add(wallLabel1);
        wallLabel1.setBounds(0, 86, 1080, 22);

        pot.setText("Pot1");
        getContentPane().add(pot);
        pot.setBounds(160, 120, 60, 60);

        potato.setText("Potato");
        getContentPane().add(potato);
        potato.setBounds(130, 760, 60, 60);

        tomato.setText("Tomato");
        getContentPane().add(tomato);
        tomato.setBounds(290, 760, 60, 60);

        bar.setText("jLabel1");
        getContentPane().add(bar);
        bar.setBounds(0, 0, 1080, 85);

        dryRack.setText("DishRack");
        getContentPane().add(dryRack);
        dryRack.setBounds(1000, 250, 60, 60);

        onion.setText("onion");
        getContentPane().add(onion);
        onion.setBounds(470, 760, 60, 60);

        pot1.setText("Pot2");
        getContentPane().add(pot1);
        pot1.setBounds(290, 120, 60, 60);

        pot2.setText("Pot3");
        getContentPane().add(pot2);
        pot2.setBounds(430, 120, 60, 60);

        table.setText("table");
        getContentPane().add(table);
        table.setBounds(265, 347, 540, 175);

        background.setText("jLabel1");
        getContentPane().add(background);
        background.setBounds(0, 0, 1080, 860);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //check if a collision between the user and objects is occurring
    private boolean checkCollision(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

        //creates an array to tell the collision what the user cant run into    
        javax.swing.JLabel blocks[] = new javax.swing.JLabel[3];
        blocks[0] = wallLabel;
        blocks[1] = wallLabel1;
        blocks[2] = table;
//cheacks the collision and returns true or false
        for (javax.swing.JLabel item : blocks) {
            if (rect.intersects(item.getBounds())) {
                return true;
            }
        }
        return false;
    }

//checks if user is near the potato box and gives them one
    private boolean checkCollisionPotato(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//sets the users potato inventory to true and changes image on the item veiw
        if (rect.intersects(potato.getBounds())) {
            me.setMushroom(false);
            me.setPotato(true);
            me.setTomato(false);
            me.setMushroomS(false);
            me.setPotatoS(false);
            me.setTomatoS(false);
            try {
                itemV.setIcon(new ImageIcon((ImageIO.read(new File("potatoBox.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }

//checks if user is near the tomato box and gives them one
    private boolean checkCollisionTomato(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//sets the users tomato inventory to true and changes image on the item veiw
        if (rect.intersects(tomato.getBounds())) {
            me.setMushroom(false);
            me.setPotato(false);
            me.setTomato(true);
            me.setMushroomS(false);
            me.setPotatoS(false);
            me.setTomatoS(false);
            try {
                itemV.setIcon(new ImageIcon((ImageIO.read(new File("tomatoBox.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }

//checks if user is near the mushroom box and gives them one
    private boolean checkCollisionMushroom(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//sets the users mushroom inventory to true and changes image on the item veiw
        if (rect.intersects(onion.getBounds())) {
            me.setMushroom(true);
            me.setPotato(false);
//            me.setTomato(false);
            me.setMushroomS(false);
            me.setPotatoS(false);
            me.setTomatoS(false);
            try {
                itemV.setIcon(new ImageIcon((ImageIO.read(new File("mushroomBox.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }
       
//checks if user is near dish rack
    private boolean checkCollisionDish(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//this looks at the soupBoy array and checks each order and then what the user is trying to give. If the user is giving a correct order it gives 10 points
        if (rect.intersects(dryRack.getBounds())) {
for(int i= 0;i<soupBoy.length;i++){
//                System.out.println("SOUP!!");
//                System.out.println(item.getPotato());
//                System.out.println(item.getTomato());
//                System.out.println(item.getMushroom());

   
              
                      

                if (soupBoy[i].getPotato()) {
                    if (me.getPotatoS()) {
                        score = score + 10;
                        scoreV.setText(String.valueOf(score));
                                                soupBoy[i] = new soup();
                    }
                if (soupBoy[i].getTomato()) {
                    if (me.getTomatoS()) {
                        score = score + 10;
                        scoreV.setText(String.valueOf(score));
                        soupBoy[i] = new soup();
  
                    }
                }
                if (soupBoy[i].getMushroom()) {
                    if (me.getMushroomS()) {
                        score = score + 10;
                        scoreV.setText(String.valueOf(score));
                        soupBoy[i] = new soup();
                        
                    }
                }
                    
                }
}
                        
                     
                    
         
            try {
                orderOne.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[0].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                orderTwo.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[1].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                orderThree.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[2].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                orderFour.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[3].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                orderFive.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[4].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                orderSix.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[5].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
            me.setMushroom(false);
            me.setPotato(false);
            me.setTomato(false);
            me.setMushroomS(false);
            me.setPotatoS(false);
            me.setTomatoS(false);
            try {
                itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }
    
//check if user is near potOne
    private boolean checkCollisionPot(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//checks if the pot has a soup ready for the user
        if (rect.intersects(pot.getBounds())) {


            return true;
        }
        return false;
    }

//check if user is near potTwo
    private boolean checkCollisionPot1(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

        if (rect.intersects(pot1.getBounds())) {

            return true;
        }
        return false;
    }

//check if user is near potThree
    private boolean checkCollisionPot2(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

        if (rect.intersects(pot2.getBounds())) {

            return true;
        }
        return false;
    }
    ;

    private void cooker1(){
counterC = 3;
       // timerCook.scheduleAtFixedRate(taskC, 1000, 1000);
            }
    
    private void cooker2(){
counterC2 = 3;
        //timerCook2.scheduleAtFixedRate(taskC2, 1000, 1000);
            }
    
    private void cooker3(){
counterC3 = 3;
      //  timerCook3.scheduleAtFixedRate(taskC3, 1000, 1000);
            }
//generates each soup and starts their timer
    private void arrayMaker() {

        soupBoy[0] = new soup();

        timerO.scheduleAtFixedRate(taskO, 1000, 1000);

        soupBoy[1] = new soup();
        timerT.scheduleAtFixedRate(taskT, 1000, 1000);

        soupBoy[2] = new soup();
        timerTh.scheduleAtFixedRate(taskTh, 1000, 1000);

        soupBoy[3] = new soup();
        timerF.scheduleAtFixedRate(taskF, 1000, 1000);

        soupBoy[4] = new soup();
        timerFi.scheduleAtFixedRate(taskFi, 1000, 1000);

        soupBoy[5] = new soup();
        timerS.scheduleAtFixedRate(taskS, 1000, 1000);
    }

    //checks which key is pressed
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //prints KeyCode for the key pressed
        //System.out.println(evt.getKeyCode());

        //up key pressed (w)
        if (evt.getKeyCode() == 87) {
            if (!checkCollision(user, 0, -30)) {
                user.setLocation(user.getLocation().x, user.getLocation().y - 30);
            }
        }
        //down key pressed(s)
        if (evt.getKeyCode() == 83) {
            if (!checkCollision(user, 0, 30)) {
                user.setLocation(user.getLocation().x, user.getLocation().y + 30);
            }
        }
        //left key pressed(a)
        if (evt.getKeyCode() == 65) {
            if (!checkCollision(user, -30, 0)) {
                user.setLocation(user.getLocation().x - 30, user.getLocation().y);
            }
        }
        //right key pressed(d)
        if (evt.getKeyCode() == 68) {
            if (!checkCollision(user, 10, 0)) {
                user.setLocation(user.getLocation().x + 30, user.getLocation().y);
            }
        }
        
        
        if (evt.getKeyCode() == 69) {
         if (checkCollisionPotato(user, 10, 0)) {
          //   System.out.println("work");
            }
         if (checkCollisionTomato(user, 10, 0)) {
        //     System.out.println("work");
            }
         if (checkCollisionMushroom(user, 10, 0)) {
        //     System.out.println("work");
            }
         if (checkCollisionPot(user, 10, 0)) {
            if (potOne.getTomatoS()) {
                potOne.setTomatoS(false);
                me.setMushroom(false);
                me.setPotato(false);
                me.setTomato(false);
                me.setMushroomS(false);
                me.setPotatoS(false);
                me.setTomatoS(true);
                try {
                    potV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("tomatoSoup.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (potOne.getPotatoS()) {
                potOne.setPotatoS(false);
                me.setMushroom(false);
                me.setPotato(false);
                me.setTomato(false);
                me.setMushroomS(false);
                me.setPotatoS(true);
                me.setTomatoS(false);
                try {
                    potV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("potatoSoup.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (potOne.getMushroomS()) {
                potOne.setMushroomS(false);
                me.setMushroom(false);
                me.setPotato(false);
                me.setTomato(false);
                me.setMushroomS(true);
                me.setPotatoS(false);
                me.setTomatoS(false);
                try {
                    potV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("mushrromSoup.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//checks if the user is trying to give the pot something
            if (me.getTomato()) {
                potOne.setTomato(true);
                potOne.setMushroom(false);
                potOne.setPotato(false);
                me.setTomato(false);
                
                try {
                    potV.setIcon(new ImageIcon((ImageIO.read(new File("tomatoBox.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                cooker1();
            }

            if (me.getMushroom()) {
                potOne.setTomato(false);
                potOne.setMushroom(true);
                potOne.setPotato(false);
                me.setMushroom(false);
                cooker1();
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    potV.setIcon(new ImageIcon((ImageIO.read(new File("mushroomBox.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (me.getPotato()) {
                potOne.setTomato(false);
                potOne.setMushroom(false);
                potOne.setPotato(true);
                me.setPotato(false);
                cooker1();
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    potV.setIcon(new ImageIcon((ImageIO.read(new File("potatoBox.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
         if (checkCollisionPot1(user, 10, 0)) {
            if (potTwo.getTomatoS()) {
                potTwo.setTomatoS(false);
                me.setMushroom(false);
                me.setPotato(false);
                me.setTomato(false);
                me.setMushroomS(false);
                me.setPotatoS(false);
                me.setTomatoS(true);
                try {
                    potV1.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("tomatoSoup.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (potTwo.getPotatoS()) {
                potTwo.setPotatoS(false);
                me.setMushroom(false);
                me.setPotato(false);
                me.setTomato(false);
                me.setMushroomS(false);
                me.setPotatoS(true);
                me.setTomatoS(false);
                try {
                    potV1.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("potatoSoup.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (potTwo.getMushroomS()) {
                potTwo.setMushroomS(false);
                me.setMushroom(false);
                me.setPotato(false);
                me.setTomato(false);
                me.setMushroomS(true);
                me.setPotatoS(false);
                me.setTomatoS(false);
                try {
                    potV1.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("mushrromSoup.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (me.getTomato()) {
                potTwo.setTomato(true);
                potTwo.setMushroom(false);
                potTwo.setPotato(false);
                me.setTomato(false);
                try {
                    potV1.setIcon(new ImageIcon((ImageIO.read(new File("tomatoBox.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                cooker2();
            }
            if (me.getMushroom()) {
                potTwo.setTomato(false);
                potTwo.setMushroom(true);
                potTwo.setPotato(false);
                me.setMushroom(false);
                cooker2();
                try {
                    potV1.setIcon(new ImageIcon((ImageIO.read(new File("mushroomBox.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (me.getPotato()) {
                potTwo.setTomato(false);
                potTwo.setMushroom(false);
                potTwo.setPotato(true);
                me.setPotato(false);
                cooker2();
                try {
                    potV1.setIcon(new ImageIcon((ImageIO.read(new File("potatoBox.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            }
         if (checkCollisionPot2(user, 10, 0)) {
            if (potThree.getTomatoS()) {
                potThree.setTomatoS(false);
                me.setMushroom(false);
                me.setPotato(false);
                me.setTomato(false);
                me.setMushroomS(false);
                me.setPotatoS(false);
                me.setTomatoS(true);
                try {
                    potV2.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("tomatoSoup.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (potThree.getPotatoS()) {
                potThree.setPotatoS(false);
                me.setMushroom(false);
                me.setPotato(false);
                me.setTomato(false);
                me.setMushroomS(false);
                me.setPotatoS(true);
                me.setTomatoS(false);
                try {
                    potV2.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("potatoSoup.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (potThree.getMushroomS()) {
                potThree.setMushroomS(false);
                me.setMushroom(false);
                me.setPotato(false);
                me.setTomato(false);
                me.setMushroomS(true);
                me.setPotatoS(false);
                me.setTomatoS(false);
                try {
                    potV2.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("mushrromSoup.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (me.getTomato()) {
                potThree.setTomato(true);
                potThree.setMushroom(false);
                potThree.setPotato(false);
                me.setTomato(false);
                try {
                    potV2.setIcon(new ImageIcon((ImageIO.read(new File("tomatoBox.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                cooker3();
            }
            if (me.getMushroom()) {
                potThree.setTomato(false);
                potThree.setMushroom(true);
                potThree.setPotato(false);
                me.setMushroom(false);
                cooker3();
                try {
                    potV2.setIcon(new ImageIcon((ImageIO.read(new File("mushroomBox.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (me.getPotato()) {
                potThree.setTomato(false);
                potThree.setMushroom(false);
                potThree.setPotato(true);
                me.setPotato(false);
                cooker3();
                try {
                    potV2.setIcon(new ImageIcon((ImageIO.read(new File("potatoBox.png"))).getScaledInstance(potV.getWidth(), potV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    itemV.setIcon(new ImageIcon((ImageIO.read(new File("clear.png"))).getScaledInstance(itemV.getWidth(), itemV.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            }
         if(checkCollisionDish(user,10,0)){

         }
//                   System.out.println(me.getMushroom()); 
//                    System.out.println(me.getPotato());
//                              System.out.println(me.getTomato());
//                                        System.out.println(me.getMushroomS());
//                     System.out.println(me.getPotatoS());
//                              System.out.println(me.getTomatoS());
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * Creates new form NewJFrame
     */
    public Brayden1() {
        initComponents();
        //Initialize the label with the scaled image icon
        myInitComponents(user);
    }

    //Initializes the labels with their images
    public void myInitComponents(javax.swing.JLabel jLabel1) {
        //Initialize a Buffered Image
        BufferedImage img = null;
        //starts timer
        timer.scheduleAtFixedRate(task, 1000, 1000 );
//        timerO.scheduleAtFixedRate(taskO, 1000, 1000);
        //Set the jLables' icon to the image it needs
        try {
            user.setIcon(new ImageIcon((ImageIO.read(new File("braydenNude.png"))).getScaledInstance(user.getWidth(), user.getHeight(), Image.SCALE_SMOOTH)));
         
            wallLabel.setIcon(new ImageIcon((ImageIO.read(new File("red.jpg"))).getScaledInstance(wallLabel.getWidth(), wallLabel.getHeight(), Image.SCALE_SMOOTH)));

            wallLabel1.setIcon(new ImageIcon((ImageIO.read(new File("red.jpg"))).getScaledInstance(wallLabel1.getWidth(), wallLabel1.getHeight(), Image.SCALE_SMOOTH)));

            pot1.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot1.getWidth(), pot1.getHeight(), Image.SCALE_SMOOTH)));

            pot2.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot2.getWidth(), pot2.getHeight(), Image.SCALE_SMOOTH)));

            pot.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot.getWidth(), pot.getHeight(), Image.SCALE_SMOOTH)));

            table.setIcon(new ImageIcon((ImageIO.read(new File("tab.png"))).getScaledInstance(table.getWidth(), table.getHeight(), Image.SCALE_SMOOTH)));

            bar.setIcon(new ImageIcon((ImageIO.read(new File("bar.png"))).getScaledInstance(bar.getWidth(), bar.getHeight(), Image.SCALE_SMOOTH)));

            potato.setIcon(new ImageIcon((ImageIO.read(new File("potatoBox.png"))).getScaledInstance(potato.getWidth(), potato.getHeight(), Image.SCALE_SMOOTH)));

            tomato.setIcon(new ImageIcon((ImageIO.read(new File("tomatoBox.png"))).getScaledInstance(tomato.getWidth(), tomato.getHeight(), Image.SCALE_SMOOTH)));

            onion.setIcon(new ImageIcon((ImageIO.read(new File("mushroomBox.png"))).getScaledInstance(onion.getWidth(), onion.getHeight(), Image.SCALE_SMOOTH)));

            background.setIcon(new ImageIcon((ImageIO.read(new File("floor.png"))).getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));

            dryRack.setIcon(new ImageIcon((ImageIO.read(new File("dish.png"))).getScaledInstance(dryRack.getWidth(), dryRack.getHeight(), Image.SCALE_SMOOTH)));
             arrayMaker();
         orderOne.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[0].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
         
         orderTwo.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[1].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
         
         orderThree.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[2].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
         
         orderFour.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[3].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
         
         orderFive.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[4].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
         
         orderSix.setIcon(new ImageIcon((ImageIO.read(new File(soupBoy[5].getPhotoCode()))).getScaledInstance(orderOne.getWidth(), orderOne.getHeight(), Image.SCALE_SMOOTH)));
                  
         timerBoy1.setIcon(new ImageIcon((ImageIO.read(new File("redBoy.png"))).getScaledInstance(orderOne.getWidth(), 1 , Image.SCALE_SMOOTH)));
         
         scoreV.setText(String.valueOf(score));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        timerCook.scheduleAtFixedRate(taskC, 1000, 1000);
        timerCook2.scheduleAtFixedRate(taskC2, 1000, 1000);
        timerCook3.scheduleAtFixedRate(taskC3, 1000, 1000);

        me = new character();
         me.setPotato(false);
 me.setTomato(false);
 me.setMushroom(false);
         me.setPotatoS(false);
 me.setTomatoS(false);
 me.setMushroomS(false);
// mushroomI = false;
// potatoS = false;
// tomatoS = false;
// mushroomS = false; 
//        System.out.println("INITIALIZED");
//        System.out.println(me.getMushroom());
//        System.out.println(me.getPotato());
//        System.out.println(me.getTomato());
//        System.out.println(me.getMushroomS());
//        System.out.println(me.getPotatoS());
//        System.out.println(me.getTomatoS());
        
        
    }

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
            java.util.logging.Logger.getLogger(Brayden1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Brayden1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Brayden1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Brayden1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Brayden1().setVisible(true);
            }
        });
    }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel bar;
    private javax.swing.JLabel dryRack;
    private javax.swing.JLabel itemV;
    private javax.swing.JLabel onion;
    private javax.swing.JLabel orderFive;
    private javax.swing.JLabel orderFour;
    private javax.swing.JLabel orderOne;
    private javax.swing.JLabel orderSix;
    private javax.swing.JLabel orderThree;
    private javax.swing.JLabel orderTwo;
    private javax.swing.JLabel pot;
    private javax.swing.JLabel pot1;
    private javax.swing.JLabel pot2;
    private javax.swing.JLabel potV;
    private javax.swing.JLabel potV1;
    private javax.swing.JLabel potV2;
    private javax.swing.JLabel potato;
    private javax.swing.JLabel scoreV;
    private javax.swing.JLabel table;
    private javax.swing.JLabel timerBoy;
    private javax.swing.JLabel timerBoy1;
    private javax.swing.JLabel tomato;
    private javax.swing.JLabel user;
    private javax.swing.JLabel wallLabel;
    private javax.swing.JLabel wallLabel1;
    // End of variables declaration//GEN-END:variables
}
