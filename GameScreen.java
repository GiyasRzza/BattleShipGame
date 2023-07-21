
package MatrixHome.BattleShipGame;

import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class GameScreen extends JFrame{

    public GameScreen(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        try {
            GameScreen gameScreen = new GameScreen("Battle Ship");
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            gameScreen.setSize(900,680);
            gameScreen.setResizable(false);
            gameScreen.setFocusable(false);
            gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            Game game = new Game();
            game.requestFocus();
            game.addKeyListener(game);
            game.setFocusable(true);
            game.setFocusTraversalKeysEnabled(false);
            gameScreen.add(game);
            gameScreen.setVisible(true); 
            
     
      
        
            
 } catch (ClassNotFoundException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
