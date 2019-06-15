package AaronPackage;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class AaronForm extends javax.swing.JFrame {
int movementSpeed = 1;
    boolean jumping = false;
    boolean movingRight = false;
    boolean movingLeft = false;
    int jumpTimer = 0;
    int numberOfObjects = 0;
    MegaAaron playerCharacter;
    ArrayList<JLabel> staplebullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> guardbullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> fatbullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> spikelist = new ArrayList<JLabel>(0);
    ArrayList<JLabel> floorlist = new ArrayList<JLabel>(0);
    ArrayList<String> blockType = new ArrayList<String>(0);
    ArrayList<String> blockX = new ArrayList<String>(0);
    ArrayList<String> blockY = new ArrayList<String>(0);
    String[][] objectsArray = new String[3][10];
    ArrayList<JLabel> activeFloor = new ArrayList<JLabel>(0);
    ArrayList<JLabel> activeSpike = new ArrayList<JLabel>(0);
    ArrayList<JLabel> activeDoor = new ArrayList<JLabel>(0);
    static ArrayList<EnemyClass> securityGuardStats = new ArrayList<EnemyClass>(0);
    static ArrayList<EnemyClass> officeWorkerStats = new ArrayList<EnemyClass>(0);
    static ArrayList<EnemyClass> fatOfficeWorkerStats = new ArrayList<EnemyClass>(0);
 
    Timer aaronGameTimer = new Timer();
    Timer aaronJumpTimer = new Timer();

    TimerTask bulletMovement = new TimerTask() {
        public void run() {

            try {

                for (JLabel item : staplebullets) {
                    item.setLocation(item.getLocation().x + 20, item.getLocation().y);

                    if (bulletCollisionEnemies(item, +20, 0) == true) {
                        remove(item);
                        staplebullets.remove(item);
                    }
                        if (item.getLocation().x > 1080) {
                           remove(item);
                            staplebullets.remove(item);
                        }
                    
                }
            } catch (Exception e) {
            }
        }
    };

    TimerTask officeWorkerMovement = new TimerTask() {
        public void run() {
            for (EnemyClass item : officeWorkerStats) {
                item.getLabel().setLocation(item.getLabel().getLocation().x - 10, (item.getLabel().getLocation().y));

                if (bulletCollisionPlayer(item.getLabel(), -10, 0) == true) {
                    remove(item.getLabel());
                    officeWorkerStats.remove(item);
                }
            }

        }

    };

    TimerTask moveRight = new TimerTask(){
       public void run(){
          if(movingRight){
                if (!checkCollision(player, -movementSpeed, 0)) {
          
           for (JLabel item : activeFloor) {
            item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

        }
        for (JLabel item : activeSpike) {
            item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

        }

        for (JLabel item : activeDoor) {
            item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

        }
          for (JLabel item : guardbullets) {
            item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

        }
         for (JLabel item : fatbullets) {
            item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

        }

        for (EnemyClass item : fatOfficeWorkerStats) {
            item.getLabel().setLocation(item.getLabel().getLocation().x - movementSpeed, item.getLabel().getLocation().y);

        }
        for (EnemyClass item : officeWorkerStats) {
            item.getLabel().setLocation(item.getLabel().getLocation().x - movementSpeed, item.getLabel().getLocation().y);

        }
        for (EnemyClass item : securityGuardStats) {
            item.getLabel().setLocation(item.getLabel().getLocation().x - movementSpeed, item.getLabel().getLocation().y);

        }
        }
          }
       }
    };
    
    TimerTask moveLeft = new TimerTask(){
       public void run(){
           if(movingLeft){
                if (!checkCollision(player, +movementSpeed, 0)) {
             for (JLabel item : activeFloor) {
            item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

        }
        for (JLabel item : activeSpike) {
            item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

        }
        for (JLabel item : activeDoor) {
            item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

        }
        for (JLabel item : guardbullets) {
            item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

        }
         for (JLabel item : fatbullets) {
            item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

        }
        for (EnemyClass item : fatOfficeWorkerStats) {
            item.getLabel().setLocation(item.getLabel().getLocation().x + movementSpeed, item.getLabel().getLocation().y);

        }
        for (EnemyClass item : officeWorkerStats) {
            item.getLabel().setLocation(item.getLabel().getLocation().x + movementSpeed, item.getLabel().getLocation().y);

        }
        for (EnemyClass item : securityGuardStats) {
            item.getLabel().setLocation(item.getLabel().getLocation().x + movementSpeed, item.getLabel().getLocation().y);

        }
           }
           }
       }
    };
    
    
    TimerTask securityGuardMovement = new TimerTask() {
        public void run() {
            try{
          
            for (EnemyClass item : securityGuardStats) {

                item.getLabel().setLocation(item.getLabel().getLocation().x, (item.getLabel().getLocation().y + 10));
                item.getLabel().setLocation(item.getLabel().getLocation().x, (item.getLabel().getLocation().y - 10));
                if (bulletCollisionPlayer(item.getLabel(), -10, 0) == true) {
                    remove(item.getLabel());
                    securityGuardStats.remove(item);
                }
            }
      
            }catch(Exception e){
                
            }
        }

    };

    TimerTask gravity = new TimerTask() {
        public void run() {
 

            if ((!checkCollision(player, 0, +10) && (jumping == false))) {

                player.setLocation(player.getLocation().x, player.getLocation().y + 10);

            }

        }
    };

    TimerTask jumpGravity = new TimerTask() {
        public void run() {
            System.out.println("Running jumpy " + jumping);
            if (jumping) {
                jumpTimer++;
                if (jumpTimer <= 22) {
                    player.setLocation(player.getLocation().x, player.getLocation().y - 10);
                } else if (jumpTimer > 22) {
          
                        jumpTimer = 0;
                        jumping = false;
                        System.out.println("Stop Running jumpy");
             
                }
            }
        }
    };
    
    TimerTask createEnemyBullets = new TimerTask() {
        public void run() {
            securityGuardBullets();
            fatOfficeWorkerBullets();
        }
    };
    TimerTask guardBulletMovement = new TimerTask() {
        public void run() {
                try{
            for (JLabel item : guardbullets) {
                item.setLocation(item.getLocation().x - 20, item.getLocation().y);
                if (bulletCollisionPlayer(item, -20, 0) == true) {
                    takeDamage();
        
                    guardbullets.remove(item);
                    remove(item);
           
                }
                 if (item.getLocation().x > 1080 &&(item.getLocation().x<0)) {
                           remove(item);
                            guardbullets.remove(item);
                        }
                
            }
                }catch(Exception e){} 
        }
    };
    TimerTask fatBulletMovement = new TimerTask() {
        public void run() {
try{
            for (JLabel item : fatbullets) {

                item.setLocation(item.getLocation().x - 5, item.getLocation().y);
                if (bulletCollisionPlayer(item, -5, 0) == true) {
                    takeDamage();
                       fatbullets.remove(item);
                    remove(item);
  
                }
                 if (item.getLocation().x > 1080 &&(item.getLocation().x<0)) {
                           remove(item);
                            fatbullets.remove(item);
                        }
            }

        }catch(Exception e){
            
        }
        }
    };

//  
    private boolean checkCollision(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

//check if temporary rectangle intersect with wallLabel        
        if (rect.intersects(bottomFloor.getBounds())) {
            return true;
        } else {

            for (JLabel item : activeFloor) {

                if (rect.intersects(item.getBounds())) {
                    return true;
                }
            }
            for (JLabel item : activeSpike) {

                if (rect.intersects(item.getBounds())) {
                    takeDamage();
                    return true;
                }
            }
            for (JLabel item : activeDoor) {
                if (rect.intersects(item.getBounds())) {
                    AaronWinScreen winScreen = new AaronWinScreen();
                    winScreen.setVisible(true);
                    this.setVisible(false);
                }
            }
            return false;
        }
    }

    public AaronForm() throws IOException {
        initComponents();

        myInitComponents();
    }
//       public static boolean passageSearch(ArrayList numPsalms, String psalmNumber) {
//        //For statement checks each item in the number psalm array
//        for (k = 0; k < numPsalms.size(); k++) {
//            //If statement checks if the item in the numPsalms array is equal to the number given by the user then returns true 
//            if (numPsalms.get(k).equals(psalmNumber)) {
//                return true;
//            }
//        }
//        //Returns false if the user doesnt input a correct psalm number
//        return false;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bottomFloor = new javax.swing.JLabel();
        player = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1080, 617));
        setSize(new java.awt.Dimension(1080, 617));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(AaronForm.class);
        bottomFloor.setText(resourceMap.getString("bottomFloor.text")); // NOI18N
        bottomFloor.setName("bottomFloor"); // NOI18N
        getContentPane().add(bottomFloor);
        bottomFloor.setBounds(0, 542, 1420, 70);

        player.setText(resourceMap.getString("player.text")); // NOI18N
        player.setName("player"); // NOI18N
        getContentPane().add(player);
        player.setBounds(240, 340, 115, 198);

        jProgressBar1.setName("jProgressBar1"); // NOI18N
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(50, 40, 146, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents
// public boolean checkGround(javax.swing.JLabel _lbl, int _x, int _y){
//    //creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
////also same width and height as original
//        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//
////check if temporary rectangle intersect with wallLabel        
//        if (rect.intersects(bottomFloor.getBounds())) {
//            return true;
//        } else {
//            return false;
//        }
//}

    public void myInitComponents() throws IOException {
      
  try {
 AudioInputStream audio = AudioSystem.getAudioInputStream(new File("AaronLevelMusic.wav"));
         // Get a sound clip resource.
         Clip clip1 = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip1.open(audio);
         clip1.start();
             } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }catch (LineUnavailableException e) {
         e.printStackTrace();
      }
            catch(Exception e){
                System.out.println(e);
            }          

//Initialize a Buffered Image
        BufferedImage img = null;
        //set the Buffered Image to the picture file

//        same as above, but in a condensed version
        try {

            bottomFloor.setIcon(new ImageIcon((ImageIO.read(new File("AaronFloor.png"))).getScaledInstance(bottomFloor.getWidth(), bottomFloor.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            readLevelFile();
        } catch (IOException ex) {
            Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        playerSpawner();
        jProgressBar1.setMaximum(playerCharacter.getHealth());
        jProgressBar1.setValue(playerCharacter.getHealth());
        fillUpArray();
        spikeSpawner();
        floorSpawner();
        securityGuardSpawner();
        officeWorkerSpawner();
        fatAlbertSpawner();
        exitSpawner();

        aaronGameTimer.scheduleAtFixedRate(bulletMovement, 100, 10);
        aaronJumpTimer.scheduleAtFixedRate(jumpGravity, 20, 25);
          aaronGameTimer.scheduleAtFixedRate(gravity, 20, 25);
           aaronGameTimer.scheduleAtFixedRate(moveRight, 2, 2);
           aaronGameTimer.scheduleAtFixedRate(moveLeft, 2, 2);
    }


    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode() == 90) {
            if (!checkCollision(player, 0, -100) && (checkCollision(player, 0, +10))) {

                jumping = true;
              
            }
        }

        //left key pressed
        if (evt.getKeyCode() == 37) {
//           
             movingLeft = true;
              System.out.println("moving Left" + movingLeft);
//            
        }
        //right key pressed
        if (evt.getKeyCode() == 39) {
//          
movingRight = true;
  System.out.println("moving Left" + movingRight);
               
//           
        }


    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == 88) {
if(staplebullets.size()<3){
            bullet();

             try {
         // Open an audio input stream.
        // URL url = this.getClass().getClassLoader().getResource("PewPew.wav");
         
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("AaronShoot.wav"));
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }catch (LineUnavailableException e) {
         e.printStackTrace();
      }
            catch(Exception e){
                System.out.println(e);
            }            

        }
        }
          if (evt.getKeyCode() == 37) {
            if (!checkCollision(player, 0, 0)) {
             movingLeft = false;
              System.out.println("stopped moving Left" + movingLeft);
            }
        }
        //right key pressed
        if (evt.getKeyCode() == 39) {
            if (!checkCollision(player, 0, 0)) {
movingRight = false;
                  System.out.println("stopped moving right" + movingRight);
            }
        }
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new AaronForm().setVisible(true);
//    readLevelFile(block1);
                } catch (IOException ex) {
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void bullet() {
        JLabel bullet1 = new JLabel();

        System.out.println("Label Created");
        getContentPane().add(bullet1);
        bullet1.setBounds(player.getX() + player.getWidth() + 10, player.getY(), 50, 100);

        System.out.println("Bounds Set");
        try {
            bullet1.setIcon(new ImageIcon((ImageIO.read(new File("StapleBullet.png"))).getScaledInstance(bullet1.getWidth(), bullet1.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println("NO IMAGE");
            Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  setComponentZOrder(bullet1, 0);
        System.out.println("Try performed");
        staplebullets.add(bullet1);

    }

    public void readLevelFile() throws IOException {
        //Initilizises a string varibable that stores the line the program is currently reading
        String myLine = null;
        String blockAdd = myLine;

        BufferedReader readFile = new BufferedReader(new FileReader("AaronLevelFile.txt"));
        //Do statement ensures that the program only stops reading the file when it reaches a blank line
        do {
            //Stores the line that the program is currently looking at as the variable myLine
            myLine = readFile.readLine();
            if (myLine == null) {
                break;
            }

//If statement ensures that if the line the program is currently looking at is null then the program removes the null from the array list and breaks out of the loop
//TYPE 
            int index = myLine.indexOf(",");
            numberOfObjects++;
            blockAdd = myLine.substring(0, index);
            System.out.println("BLOCK" + blockAdd);
            blockType.add(blockAdd);

            myLine = myLine.substring(index + 1, myLine.length());
            System.out.println("NEW line " + myLine);

            //X- VALUE
            index = myLine.indexOf(",");
            blockAdd = myLine.substring(0, index);
            System.out.println(blockAdd);
            blockX.add(blockAdd);
            myLine = myLine.substring(index + 1, myLine.length());

            //Y=VALUE
            blockAdd = myLine;
            System.out.println(blockAdd);

            blockY.add(blockAdd);

        } while (true);
//Closez the file to ensure there is no complications
        readFile.close();

    }

    public void fillUpArray() {

        for (int i = 0; i < numberOfObjects; i++) {
            objectsArray[0][i] = blockType.get(i);
            System.out.println(objectsArray[0][i]);
            objectsArray[1][i] = blockX.get(i);
            System.out.println(objectsArray[1][i]);
            objectsArray[2][i] = blockY.get(i);
            System.out.println(objectsArray[2][i]);
        }

    }

    public void takeDamage() {
        System.out.println("OUCH");
        playerCharacter.setHealth(playerCharacter.getHealth() - 1);

        jProgressBar1.setValue(playerCharacter.getHealth() - 1);

        if (playerCharacter.getHealth() == 0) {

        }

    }

    public void playerSpawner() throws IOException {
        playerCharacter = new MegaAaron();
        playerCharacter.setLabel(player);
        player.setIcon(new ImageIcon((ImageIO.read(new File("MegaAaron.png"))).getScaledInstance(player.getWidth(), player.getHeight(), Image.SCALE_SMOOTH)));
    }

    public void floorSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {
            // System.out.println(i);
            if (objectsArray[0][i].equals("floor")) {

                JLabel floor1 = new JLabel();

                System.out.println("Label Created");
                getContentPane().add(floor1);
                floor1.setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 50, 50);

                System.out.println("Bounds Set");
                try {
                    floor1.setIcon(new ImageIcon((ImageIO.read(new File("AaronFloor.png"))).getScaledInstance(floor1.getWidth(), floor1.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                //  setComponentZOrder(bullet1, 0);
                System.out.println("Try performed");
                activeFloor.add(floor1);
            }

        }

    }

    public void spikeSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {
            // System.out.println(i);
            if (objectsArray[0][i].equals("spike")) {

                JLabel spike2 = new JLabel();

                System.out.println("Label Created");
                getContentPane().add(spike2);
                spike2.setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 50, 50);

                System.out.println("Bounds Set");
                try {
                    spike2.setIcon(new ImageIcon((ImageIO.read(new File("AaronSpikes.png"))).getScaledInstance(spike2.getWidth(), spike2.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                //  setComponentZOrder(bullet1, 0);
                System.out.println("Try performed");
                activeSpike.add(spike2);
            }

        }
    }

    public void exitSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {
            // System.out.println(i);
            if (objectsArray[0][i].equals("door")) {

                System.out.println("door Coming");
                JLabel door = new JLabel();
                getContentPane().add(door);
                door.setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 100, 250);

                System.out.println("Bounds Set");
                try {
                    door.setIcon(new ImageIcon((ImageIO.read(new File("Door.png"))).getScaledInstance(door.getWidth(), door.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                //  setComponentZOrder(bullet1, 0);
                System.out.println("Try performed");
                activeDoor.add(door);

            }

        }
    }

    public void securityGuardSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {
            // System.out.println(i);
            if (objectsArray[0][i].equals("guard")) {

                System.out.println("IMP Coming");
                SecurityGuard guard = new SecurityGuard();
                securityGuardStats.add(guard);
                JLabel label = new JLabel();
                guard.setLabel(label);
                getContentPane().add(guard.getLabel());
                guard.getLabel().setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 100, 250);
                try {
                    guard.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("AaronSecurityGuard.png"))).getScaledInstance(guard.getLabel().getWidth(), guard.getLabel().getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);

                }
                aaronGameTimer.scheduleAtFixedRate(createEnemyBullets, 100, 2000);
                aaronGameTimer.scheduleAtFixedRate(guardBulletMovement, 100, 100);
                aaronGameTimer.scheduleAtFixedRate(securityGuardMovement, 100, 1000);
            }

        }
    }

    public void officeWorkerSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {
            // System.out.println(i);
            if (objectsArray[0][i].equals("worker")) {

                System.out.println("Worker Coming");
                OfficeWorker worker = new OfficeWorker();
                officeWorkerStats.add(worker);
                JLabel label = new JLabel();
                worker.setLabel(label);
                getContentPane().add(worker.getLabel());
                worker.getLabel().setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 100, 200);
                try {
                    worker.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("officeWorker.png"))).getScaledInstance(worker.getLabel().getWidth(), worker.getLabel().getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                aaronGameTimer.scheduleAtFixedRate(officeWorkerMovement, 100, 10);
            }

        }
    }

    public void fatAlbertSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {
            // System.out.println(i);
            if (objectsArray[0][i].equals("fat")) {

                System.out.println("FAT Coming");
                FatOfficeWorker fat = new FatOfficeWorker();
                fatOfficeWorkerStats.add(fat);
                JLabel label = new JLabel();
                fat.setLabel(label);
                getContentPane().add(fat.getLabel());
                fat.getLabel().setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 100, 250);
                try {
                    fat.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("aaronFatAlbert.png"))).getScaledInstance(fat.getLabel().getWidth(), fat.getLabel().getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                aaronGameTimer.scheduleAtFixedRate(createEnemyBullets, 100, 1000);
                aaronGameTimer.scheduleAtFixedRate(fatBulletMovement, 100, 100);
            }

        }
    }

    public void securityGuardBullets() {

        for (EnemyClass item : securityGuardStats) {

            JLabel guardbullet = new JLabel();

            System.out.println("Label Created");
            getContentPane().add(guardbullet);
            guardbullet.setBounds(item.getLabel().getLocation().x, item.getLabel().getLocation().y+100, 50, 50);

            System.out.println("Bounds Set");
            try {
                guardbullet.setIcon(new ImageIcon((ImageIO.read(new File("SecurityGuardBullet.png"))).getScaledInstance(guardbullet.getWidth(), guardbullet.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println("NO IMAGE");
                Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            //  setComponentZOrder(bullet1, 0);
            System.out.println("Try performed");
            guardbullets.add(guardbullet);
        }
    }

    public void fatOfficeWorkerBullets() {
        for (EnemyClass item : fatOfficeWorkerStats) {

            JLabel fatbullet = new JLabel();

            System.out.println("Label Created");
            getContentPane().add(fatbullet);
            fatbullet.setBounds(item.getLabel().getLocation().x, item.getLabel().getLocation().y+100, 50, 50);

            System.out.println("Bounds Set");
            try {
                fatbullet.setIcon(new ImageIcon((ImageIO.read(new File("AaronHamburger.png"))).getScaledInstance(fatbullet.getWidth(), fatbullet.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println("NO IMAGE");
                Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            //  setComponentZOrder(bullet1, 0);
            System.out.println("Try performed");
            fatbullets.add(fatbullet);
        }
    }

    public boolean bulletCollisionEnemies(javax.swing.JLabel _lbl, int _x, int _y) {

        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

        for (EnemyClass item : officeWorkerStats) {
            if (rect.intersects(item.getLabel().getBounds())) {
                item.setHealth(item.getHealth() - 1);
                //  System.out.println("Enenmy Hit" + item.getHealth());
                if (item.getHealth() == 0) {
                    officeWorkerStats.remove(item);
                    getContentPane().remove(item.getLabel());
                    repaint();
                }
                return true;
            }
        }
        for (EnemyClass item : fatOfficeWorkerStats) {
            if (rect.intersects(item.getLabel().getBounds())) {
                item.setHealth(item.getHealth() - 1);
                //  System.out.println("Enenmy Hit" + item.getHealth());
                if (item.getHealth() == 0) {
                    fatOfficeWorkerStats.remove(item);
                    getContentPane().remove(item.getLabel());
                    repaint();
                }
                return true;
            }
        }
        for (EnemyClass item : securityGuardStats) {
            if (rect.intersects(item.getLabel().getBounds())) {
                item.setHealth(item.getHealth() - 1);
                //   System.out.println("Enenmy Hit" + item.getHealth());
                if (item.getHealth() == 0) {
                    securityGuardStats.remove(item);
                    getContentPane().remove(item.getLabel());
                    repaint();
                }
                return true;
            }
        }
        return false;

    }

    public boolean bulletCollisionPlayer(javax.swing.JLabel _lbl, int _x, int _y) {

        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

        if (rect.intersects(playerCharacter.getLabel().getBounds())) {

            return true;
        }

        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel bottomFloor;
    javax.swing.ButtonGroup buttonGroup1;
    javax.swing.JProgressBar jProgressBar1;
    javax.swing.JLabel player;
    // End of variables declaration//GEN-END:variables

}
