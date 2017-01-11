/*	Lindsay Scott
 * 	November 6th 2016
 * 	GUI Demo Program
 * 
 * 	This program will demonstrate the many
 * 	abilities of Java.Swing and Java.Awt
 *  such as JRadio, JButton, JLabel, etc. while
 *  also implementing GUI containers such as
 *  JFrame and JPanel.
 * 
 * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MessagePanel extends JPanel {

	//create main window
   public static void main(String[] args) {
      JFrame window = new JFrame("GUIDemo");
      MessagePanel content = new MessagePanel();
      window.setContentPane(content);
      window.pack();
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setVisible(true);
   }
 
   public MessagePanel() {
	   
	   //set window size
	   setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	   setPreferredSize(new Dimension(360, 240));
	   
	   //add panels to window
	   JLabel chooseColor = new JLabel("Select Message Panel Background");
	   JPanel colorPrompt = new JPanel(new BorderLayout());
	   colorPrompt.setBounds(5, 5, 200, 15);
	   this.add(colorPrompt);
	   colorPrompt.add(chooseColor);
	   ColorPanel colorP = new ColorPanel();
	   colorP.getColor();
	   this.add(colorP);  	   
   }

} 