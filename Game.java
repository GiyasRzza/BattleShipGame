package MatrixHome.BattleShipGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener,ActionListener{
    Timer timer = new Timer(2, this);
  //  Timer timerTwo = new Timer(5,this);
    private int passingTime = 0;
    private int bulletAmount = 0;
    private BufferedImage image;
    private BufferedImage imagePanel;
    private BufferedImage myShipImg;
    private BufferedImage fireImg;
     private BufferedImage fireMirrorImg;
    private List<Fire> fires = new ArrayList<Fire>();
    private List<FireAuto> autoFires = new ArrayList<FireAuto>();
    private int fireGoY = 3;
    private int fireGoX=2;
    private int topX = 0;
    private int topGoX=2;
    private int myShipX=0;
    private int goShipX=12;
    private String message;
     public boolean isControl(){
            for (Fire fire : fires) {
            if(new Rectangle(fire.getX(),fire.getY(),10,20).intersects(new Rectangle(topX,0,image.getWidth()/10,image.getHeight()/10))){
        
                return true;
            }
            }
           return false;
      
    }

    public Game() {
         
        try {
            image =ImageIO.read(new FileImageInputStream(new File("picture//Enemy ship.png")));
            imagePanel=ImageIO.read(new FileImageInputStream(new File("picture//Ocean.jpg")));
            myShipImg=ImageIO.read(new FileImageInputStream(new File("picture//MyShip.png")));
            
            
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       timer.start();
    }
    
   
    
   
    @Override
    public void paint(Graphics g) {
        super.paint(g);
         passingTime+=5;
        g.drawImage(imagePanel,0,0,920,700,this);
        g.setColor(Color.red);
        
          g.drawImage(image,topX,0,image.getWidth()/10,image.getHeight()/10,this);
        
        g.drawImage(myShipImg,myShipX,590,myShipImg.getWidth()/10,myShipImg.getHeight()/10,this);
        
        for (Fire fire : fires) {
            if(fire.getY()<0){
                    fires.remove(fire);
            
            }
        }

          g.setColor(Color.red);
        for (Fire fire : fires) {
         g.fillRect(fire.getX(), fire.getY(), 10, 20);
        } 
        
        if(isControl()){
                timer.stop();
                message="Tebrikler Qazandiniz!!\n"
                        + "Mermilerin sayı: "+bulletAmount+"\n"
                        + "Oyunama Vaxtınız: "+passingTime/100.0+"sn";
                JOptionPane.showMessageDialog(this, message);
                System.exit(0);
                
        }
       
        
    }

    @Override
    public void repaint() {
        super.repaint(); 
      

    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
   }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int c = e.getKeyCode();
        if(c==KeyEvent.VK_LEFT){
            if(myShipX<=0){
            myShipX=0;
             }
            else{
                myShipX-=goShipX;
            }
            
        }else if(c==KeyEvent.VK_RIGHT){
            if(myShipX>=800){
            myShipX=800;
            }
            else{
                myShipX+=goShipX;
                
                
            }
        }
        else if(c==KeyEvent.VK_SPACE){
            fires.add(new Fire(myShipX+20,590));
            bulletAmount++;
          
            
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
            
            for (Fire fire : fires) {
                fire.setY(fire.getY()-fireGoY);
            }
            
            topX+=topGoX;
            if(topX>800){
                topGoX=-topGoX;
            }
            if(topX<=0){
                topGoX=-topGoX;
                
            }
            repaint();
        }
    
    
        
    }
    
       

