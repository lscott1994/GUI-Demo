
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

public class ColorPanel extends JPanel {
	protected JRadioButton redRadio;
	protected JRadioButton yellowRadio;
	protected JRadioButton greenRadio;
	protected JRadioButton grayRadio;
	protected JRadioButton whiteRadio; 
	protected JButton bLeft, bRight;
	protected JPanel p1, p2, p3, getPan;
	protected JFrame window;
	protected JLabel javaText;
	protected int xCoord;
	
	
public void getColor(){
	int getPanH = 180;
	int panH = 60;
	int panW = 340;
	JLabel javaText = new JLabel("Welcome to Java");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel(new GridLayout(1, 340));
	JPanel p3 = new JPanel();
	JPanel getPan = new JPanel(new BorderLayout());
	getPan.setPreferredSize(new Dimension(panW, getPanH));
	p1.setPreferredSize(new Dimension(panW, panH));
	p2.setPreferredSize(new Dimension(panW, panH));
	p3.setPreferredSize(new Dimension(panW, panH));
	p2.setLayout(null);
	
	//center height of panel two (p1+p2 = 120, getPan = 180, 180-120 = 40, 40/3 = 20, center)
	int addH = (panH + panH);
	int getCentH = (getPanH - addH);
	int height = getCentH/3;
	
	//gets center width of panel two
	double toCenter = 360 - javaText.getPreferredSize().getWidth();
	double divideTwo = toCenter/2;
	int toInt = (int) divideTwo - 10;
	xCoord = toInt;
	
	//set coords of JLabel
	javaText.setBounds(xCoord, height, 340, 20);

	//add JLabel to panel two
	p2.add(javaText);

	
	//add panels two and three 
	add(p2);
	add(p3); 
	
	//add all panels to getPan 
	getPan.add(p1, BorderLayout.NORTH);
	getPan.add(p2, BorderLayout.CENTER);
	getPan.add(p3, BorderLayout.SOUTH);
	add(getPan);
    
	
	//create radio buttons
    redRadio = new JRadioButton("Red");
    redRadio.setMnemonic(KeyEvent.VK_R);

    yellowRadio = new JRadioButton("Yellow");
    yellowRadio.setMnemonic(KeyEvent.VK_Y);
    
    whiteRadio = new JRadioButton("White");
    whiteRadio.setMnemonic(KeyEvent.VK_W);
    
    grayRadio = new JRadioButton("Grey");
    grayRadio.setMnemonic(KeyEvent.VK_G);
    
    greenRadio = new JRadioButton("Green");
    greenRadio.setMnemonic(KeyEvent.VK_H);
    
    
    //create radio button group
    ButtonGroup c = new ButtonGroup();
    c.add(redRadio);
    c.add(yellowRadio);
    c.add(whiteRadio);
    c.add(grayRadio);
    c.add(greenRadio);

    //add buttons to panel one
    p1.add(redRadio);
    p1.add(yellowRadio);
    p1.add(whiteRadio);
    p1.add(grayRadio);
    p1.add(greenRadio);
   
    //add radio button traversal
    HashSet set = new HashSet (redRadio.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
    set.add(KeyStroke.getKeyStroke("RIGHT"));
    redRadio.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set);	    
    HashSet set2 = new HashSet (redRadio.getFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));
    set2.add(KeyStroke.getKeyStroke("LEFT"));
    redRadio.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, set2);
	    
    redRadio.setSelected(true);
    
    	//change background colors on JRadio click
    	redRadio.addActionListener(new ActionListener(){
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            if (redRadio.isSelected()) {
	             
	                p2.setBackground(Color.RED);
	            }
	           
	        }});
    
	    //set red radio button as default
	   
	    
	    yellowRadio.addActionListener(new ActionListener(){
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            if (yellowRadio.isSelected()) {
	             
	                p2.setBackground(Color.YELLOW);
	            }
	        }});
	    
	    whiteRadio.addActionListener(new ActionListener(){
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            if (whiteRadio.isSelected()) {
	             
	                p2.setBackground(Color.WHITE);
	            }
	        }});
	    
	    grayRadio.addActionListener(new ActionListener(){
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            if (grayRadio.isSelected()) {
	             
	                p2.setBackground(Color.GRAY);
	            }
	        }});
	    
	    greenRadio.addActionListener(new ActionListener(){
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            if (greenRadio.isSelected()) {
	             
	                p2.setBackground(Color.GREEN);
	            }
	        }});
	    
	    
	    //left JButton
	    JButton bLeft = new JButton("<=");
	    p3.add(bLeft);
	    bLeft.addActionListener(new ActionListener() {
	    	@Override
	         public void actionPerformed(ActionEvent evt) {
	    		 javaText.setBounds(xCoord  -= 10, height, 340, 20);
	           
	            getPan.repaint();
	            requestFocus();
	         }
	      });
		  
	    
	    //right JButton
		   JButton bRight = new JButton("=>");
		     p3.add(bRight);
		      bRight.addActionListener(new ActionListener() {
		     @Override
		    	  public void actionPerformed(ActionEvent evt) {
		    	 javaText.setBounds(xCoord  += 10, height, 340, 20);
		           
		            getPan.repaint();
		            requestFocus(); 
		         }
		      });
	  	 
}






}
