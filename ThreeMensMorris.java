
//Project 6
//Afreen Hameed  
//CS113H
/*Project Info
    This code was used to create a UI to play the ancient game Three Men's Morris
*/




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import java.awt.Color;

public class ThreeMensMorris extends JFrame {

    private class GameButton extends JButton {
    	byte value=0;
		/*
		 0:nothing
		 1:red
		 2:blue
		 */

        private GameButton(int id) {

            this.id = id;
            
            
            setOpaque(true);
            setFont(new Font(getFont().getClass().getName(), Font.LAYOUT_NO_LIMIT_CONTEXT, 100));
            
        }

        private int id;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThreeMensMorris();
            }
        });
    }

    private ThreeMensMorris() {
        super("Three Men's Morris");
        launch();
    }

    private boolean checkWin() {

        return board[0] == player && board[2] == player && board[4] == player ||
                board[10] == player && board[12] == player && board[14] == player ||
                board[20] == player && board[22] == player && board[24] == player ||
                board[0] == player && board[10] == player && board[20] == player ||
                board[2] == player && board[12] == player && board[22] == player ||
                board[4] == player && board[14] == player && board[24] == player ||
                board[0] == player && board[12] == player && board[24] == player ||
                board[4] == player && board[12] == player && board[20] == player;
    }
    private JMenu createGameJMenu() {

        JMenu m = new JMenu("Game");

        m.setMnemonic(KeyEvent.VK_G);

        m.add(createGameNewJMenuItem());
        m.addSeparator();
        m.add(createGameQuitJMenuItem());

        return m;
    }

    private JMenuItem createGameNewJMenuItem() {

        JMenuItem mi = new JMenuItem("New");

        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performNewAction();
            }
        });

        mi.setMnemonic(KeyEvent.VK_N);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));

        return mi;
    }

    private JMenuItem createGameQuitJMenuItem() {

        JMenuItem mi = new JMenuItem("Quit");

        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performQuitAction();
            }
        });

        mi.setMnemonic(KeyEvent.VK_Q);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));

        return mi;
    }

    private JMenu createHelpJMenu() {

        JMenu m = new JMenu("Help");

        m.setMnemonic(KeyEvent.VK_H);

        m.add(createHelpAboutJMenuItem());

        return m;
    }

    private JMenuItem createHelpAboutJMenuItem() {

        JMenuItem mi = new JMenuItem("About");

        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performAboutAction();
            }
        });

        mi.setMnemonic(KeyEvent.VK_A);

        return mi;
    }

    private JMenuBar createJMenuBar() {

        JMenuBar mb = new JMenuBar();

        mb.add(createGameJMenu());
        mb.add(createHelpJMenu());

        return mb;
    }

    private void launch() {

        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width  = Toolkit.getDefaultToolkit().getScreenSize().width ;

        setBounds(width / 2 - 300, height / 2 - 300, 600, 600);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setJMenuBar(createJMenuBar());
        setLayout(new GridLayout(5, 5));
        setResizable(false);
        

        for (int i = 0; i < 25; ++i) {
            add(grid[i] = new GameButton(i));
            
            grid[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    performGameAction((GameButton)ae.getSource());
                }
            });
            grid[i].setEnabled(false);
            
        }
        
        grid[1].setText("-");
        grid[3].setText("-");
        grid[11].setText("-");
        grid[13].setText("-");
        grid[21].setText("-");
        grid[23].setText("-");
        grid[5].setText("|");
        grid[15].setText("|");
        grid[7].setText("|");
        grid[17].setText("|");
        grid[9].setText("|");
        grid[19].setText("|");
        grid[6].setText("\\");
        grid[18].setText("\\");
        grid[8].setText("/");
        grid[16].setText("/");
        grid[0].setEnabled(true);
        grid[2].setEnabled(true);
        grid[4].setEnabled(true);
        grid[10].setEnabled(true);
        grid[12].setEnabled(true);
        grid[14].setEnabled(true);
        grid[20].setEnabled(true);
        grid[22].setEnabled(true);
        grid[24].setEnabled(true);
        

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                performQuitAction();
            }
        });

        setVisible(true);
    }

    private void performAboutAction() {

        JOptionPane.showMessageDialog(this, "Three Men's Morris\nAuthor: Afreen Hameed\nVersion: ?\nDate: 16-MARCH-2017", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    private void performGameAction(GameButton gb) {
    	
    	if(count>=6){
    		if(allowance==0 && board[gb.id] ==player){
    			board[gb.id] =0;
    			gb.value=0;
    			gb.setBackground(new JButton().getBackground());
    			allowance++;
    			tempid=gb.id;
   
    			
    		}
    		else if(allowance==1 && gb.value==0 && Math.abs(gb.id-tempid)!=4 &&  Math.abs(gb.id-tempid)<13  ){
    			
    			gb.setBackground(player == 1 ? Color.red : Color.blue);
                gb.value=(byte)(player == 1 ? 1 :2);
                board[gb.id] = player;
                allowance++;
                if (checkWin()) {
            	
                    for (GameButton b : grid) {
                        b.setEnabled(false);
                    }
                    int choice = JOptionPane.showConfirmDialog(this, "Player " + (player == 1 ? "Red" : "Blue") + " wins! Play again?", "Play again? (Y/N)", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (choice == JOptionPane.YES_OPTION) {
                    	performNewAction();  
                        return;
                    }
                    else{System.exit(0);}
        		
        	    }
                player=-player;
                
    		}
    		else if(allowance==2 && board[gb.id] ==player){
    			board[gb.id] =0;
    			gb.value=0;
    			gb.setBackground(new JButton().getBackground());
    			allowance=1;
    			tempid=gb.id;
    			
    			
    		}
    		
    	}

        if (gb.value==0 && count<6) {
            gb.setBackground(player == 1 ? Color.red : Color.blue);
            gb.value=(byte)(player == 1 ? 1 :2);
            board[gb.id] = player;
            count++;
            
            if (checkWin()) {
                for (GameButton b : grid) {
                    b.setEnabled(false);
                }
                int choice = JOptionPane.showConfirmDialog(this, "Player " + (player == 1 ? "Red" : "Blue") + " wins! Play again?", "Play again? (Y/N)", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                	performNewAction();  
                    return;
                }
                else{System.exit(0);}
            }
            player = -player;
        }
    }

    private void performNewAction() {

        player = 1;
        board = new int[25];
        count=0;
        allowance=0;

        for (GameButton gb : grid) {
            gb.value=0;
            gb.setBackground(new JButton().getBackground());    
        }
        grid[1].setText("-");
        grid[3].setText("-");
        grid[11].setText("-");
        grid[13].setText("-");
        grid[21].setText("-");
        grid[23].setText("-");
        grid[5].setText("|");
        grid[15].setText("|");
        grid[7].setText("|");
        grid[17].setText("|");
        grid[9].setText("|");
        grid[19].setText("|");
        grid[6].setText("\\");
        grid[18].setText("\\");
        grid[8].setText("/");
        grid[16].setText("/");
        grid[0].setEnabled(true);
        grid[2].setEnabled(true);
        grid[4].setEnabled(true);
        grid[10].setEnabled(true);
        grid[12].setEnabled(true);
        grid[14].setEnabled(true);
        grid[20].setEnabled(true);
        grid[22].setEnabled(true);
        grid[24].setEnabled(true);
    }

    private void performQuitAction() {

        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Quit (Y/N)", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private GameButton[] grid = new GameButton[25];
    private int[] board = new int[25];
    private int player = 1;
    private int count=0;
    private int allowance=0;
    private int tempid;
}
