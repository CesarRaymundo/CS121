import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Font;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a [put your description here]
 *
 * @author BSU CS 121 Instructors
 * @author [put your name here]
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	private final ImageIcon OBJECT_ICON = new ImageIcon("ObjectIcon3.png");
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.
	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;
	private int xOffset2 = 90;
	private int xOffset3 = 0;
	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;
	private int stepSize2 = 3;
	
	
	//private final Color BACKGROUND_COLOR =(Color.BLACK);

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		
		
		//Setting Background color
		Color skyBlue= new Color(135,206,235);
		Color boiseGreen= new Color(34,139,34);
		g.setColor(boiseGreen);
		g.fillRect(0,0,width,height);
		g.setColor(Color.BLUE);
		g.fillRect(0,0,width,height/2);
		
		//Sidewalk
		int sidewalkWidth= width*1/5;
		Color sidewGrey = new Color(220,220,220);
		g.setColor(sidewGrey);
		g.fillRect(width*3/7,0,sidewalkWidth,height);
		g.setColor(Color.BLACK);
		g.drawRect(width*3/7,0,sidewalkWidth,height);
		
		//Sky Blue
		g.setColor(skyBlue);
		g.fillRect(0,0,width,height*4/13);
		
		//Buildings 
		int buildH= height*2/13;
		Color buildingGrey=new Color(169,169,169);
		g.setColor(buildingGrey);
		g.fillRect(width*1/3,buildH, width/12, buildH);
		g.fillRect(width*1/12,buildH, width/9, buildH);
		g.fillRect(width/4,buildH/4, width/9, buildH*7/4);
		g.fillRect(width*1/24,buildH/4, width/12, buildH*7/4);
		g.fillRect(width/-50,buildH/-4, width/10, buildH*9/4);
		g.fillRect(width*1/6,buildH/2, width/9, buildH*3/2);
		g.fillRect(width*13/20,buildH*3/2, width/2, buildH/2);
		g.fillRect(width*16/25,buildH/2, width/9, buildH*3/2);
		g.fillRect(width*17/20,buildH, width/9, buildH);
		g.fillRect(width*3/4,buildH/-4, width/8, buildH*9/4);
	
		
		//Sun
		int startAngle = 30;
		int endAngle= 290;
		g.setColor(Color.YELLOW);
		g.fillArc(width*19/20,height/-10,width/6, height/6,startAngle,endAngle);

		//Road
		g.setColor(Color.BLACK);
		g.fillRect(0,height/3,width,height*3/10);
		g.setColor(sidewGrey);
		g.drawRect(0,height/3,width,height*3/10);
		
		//Road lines 
		int lineW= width;
		int lineH = height / 3;
		int line2H= lineH*7/5;
		g.setColor(Color.YELLOW);
		g.fillRect(0,lineH*7/5,lineW,lineH/9);
		g.setColor(Color.BLACK);
		g.fillRect(width*1/4,line2H,lineW/6,lineH/9);
		g.fillRect(width*3/4,line2H,lineW/6,lineH/9);
		
		
		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;
		xOffset2 = (xOffset2 - stepSize) % width;
		xOffset3 = (xOffset3 + stepSize2) % width;
		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen
		
		//Pac-Man
		int pacH = height/4;
		int pacW = width /2;
		int pacStartangle = 225;
		int pacEndangle = 270; 
		g.setColor(Color.YELLOW);
		g.fillArc(xOffset2+pacW*7/4,pacH*5/4,pacW/4,pacH/2,pacStartangle,pacEndangle);
		
		//UFO
		int objectY = height/3;
		int shipW= height/3;
		int shipH= shipW/2;
		g.drawImage(OBJECT_ICON.getImage(),xOffset3,objectY/-9,shipW,shipH, null);
		
		// This draws a green square. Replace it with your own object.
		int squareSide = height / 5;
		int squareY = height / 2 - squareSide / 2;
		
		//Smoke Stack
		Color carSilver= new Color(192,192,192);
		g.setColor(carSilver);
		g.fillRect(xOffset+squareSide*1/2,squareY*7/10,squareSide/5,squareSide);
		g.setColor(Color.BLACK);
		g.drawRect(xOffset+squareSide*1/2,squareY*7/10,squareSide/5,squareSide);
		
		
		//Body of Truck 
		Color boiseOrange= new Color(255,140,0);
		g.setColor(boiseOrange);
		g.fillRect(xOffset, squareY, squareSide*2, squareSide/2);
		g.fillRect(xOffset+squareSide*3/4,squareY*3/4,squareSide*3/4,squareSide/2);
		g.setColor(Color.BLACK);
		g.drawRect(xOffset+squareSide*3/4,squareY*3/4,squareSide*3/4,squareSide/2);
		g.drawRect(xOffset, squareY, squareSide*2, squareSide/2);
		
		
		//Window of Truck 
		int squareH=squareSide/2;
		int squareW=squareSide*3/4;
		g.setColor(Color.WHITE);
		g.fillRect(xOffset+squareSide*8/9,squareY*4/5,squareW*3/4,squareH*4/5);
		g.setColor(Color.BLACK);
		g.drawRect(xOffset+squareSide*8/9,squareY*4/5,squareW*3/4,squareH*4/5);
		
		//Drawing wheels 
		g.setColor(Color.BLUE);
		g.fillOval(xOffset, squareY+squareSide/2,squareSide/2,squareSide/2);
		g.fillOval(xOffset+squareSide*2/4, squareY+squareSide/2, squareSide/2, squareSide/2);
		g.fillOval(xOffset+squareSide*3/2,squareY+squareSide/2, squareSide/2, squareSide/2);
		g.setColor(Color.WHITE);
		g.drawOval(xOffset, squareY+squareSide/2,squareSide/2,squareSide/2);
		g.drawOval(xOffset+squareSide*2/4, squareY+squareSide/2, squareSide/2, squareSide/2);
		g.drawOval(xOffset+squareSide*3/2,squareY+squareSide/2, squareSide/2, squareSide/2);
		
		//Character 
		int charH= height*3/4;
		int charW= width/2;
		int charBodheight= width*1/10; 
		int charBodwidth= charBodheight/2;
		int charLegArmWidth= charBodwidth/2;
		
		//Body
		g.setColor(Color.BLUE);
		g.fillRect(charW,charH-charBodheight*2/3,charBodwidth,charBodheight);
		
		//Legs
		g.setColor(Color.BLACK);
		g.fillRect(charW,charH+charBodheight/6,charLegArmWidth,charBodheight*17/20);
		g.fillRect(charW+charLegArmWidth, charH+charBodheight/6, charLegArmWidth,charBodheight*17/20);
		
		//Arms
		g.setColor(boiseOrange);
		g.fillRect(charW-charLegArmWidth,charH-charLegArmWidth*27/10,charLegArmWidth,charBodheight*2/3);
		g.fillRect(charW+charBodwidth,charH-charLegArmWidth*27/10,charLegArmWidth,charBodheight*2/3);
		
		//Head
		Color hairBrown = new Color(160,82,45);
		g.setColor(hairBrown);
		g.fillOval(charW,charH-charBodwidth-charBodheight*2/3,charBodwidth,charBodwidth);
		
		//Outline of Character 
		g.setColor(Color.BLACK);
		g.drawRect(charW,charH-charBodheight*2/3,charBodwidth,charBodheight);
		g.drawRect(charW,charH+charBodheight/6,charLegArmWidth,charBodheight*17/20);
		g.drawRect(charW+charLegArmWidth, charH+charBodheight/6, charLegArmWidth,charBodheight*17/20);
		g.drawRect(charW-charLegArmWidth,charH-charLegArmWidth*27/10,charLegArmWidth,charBodheight*2/3);
		g.drawRect(charW+charBodwidth,charH-charLegArmWidth*27/10,charLegArmWidth,charBodheight*2/3);
		g.drawOval(charW,charH-charBodwidth-charBodheight*2/3,charBodwidth,charBodwidth);
		
		//Quote
		g.setColor(Color.WHITE);
		int wordX= width*13/20;
		int wordY= height *7/10;		
		String text = "What is Going On?";
		g.setFont(new Font("Arial",Font.BOLD,16));
		g.drawString(text,wordX,wordY);
	
		
		
		
		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}