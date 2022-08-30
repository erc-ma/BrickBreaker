import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColorPanel extends JPanel implements ActionListener, KeyListener {
	private Graphics g;//Used for methods that can't access g
	private int choice;//determine which path the paintComponent takes
	private int numLives;
	private static String[] args;//Used for calling main after level beat or lost
	private JFrame frame;//Used to dispose frame after win/loss
	private int startNum;//Keeps track of level in level[]l
	private Level[] l;//Arr of levels
	private boolean start;//Used to determine if hit spacebar and update level
	private int velLine;//for calculating aiming line
	private int velX;//for calculating aiming line
	private int a = 2;//determine win/loss
	private int ballX;//temp x to set ballx
	private int ballY;//temp x to set ballx
	private boolean active;//if keyboard listener is activated or not
	private Timer t = new Timer(5, this);//For key listener

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static String[] getArgs() {
		return args;
	}

	public static void setArgs(String[] args) {
		ColorPanel.args = args;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public ColorPanel() {// new
		super();
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

	}

	public ColorPanel(Bar b) {// new
		super();
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void setChoice(int c) {
		choice = c;
	}

	public Level[] getL() {// get and set for Level and numLives newE
		return l;
	}

	public void setL(Level[] l) {
		this.l = l;
	}

	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}

	public void paintComponent(Graphics g) {// The class auto-calls this method continuously
		super.paintComponent(g);
		this.g = g;
		if (choice == 0) {//Menu
			setBackground(new Color(19, 64, 21));

			BufferedImage img = null;
			try {// take title jpeg and paint it
				img = ImageIO.read(new File("BrickBreakerTitle2.jpg"));
			} catch (IOException exc) {
				// TODO: Handle exception.
			}
			g.drawImage(img, 0, 0, this);
			// Buttons and choices, if(button input) paintSurvival() or paintChoose()
		} else if (choice == 1) {
			active = true;
			paintGame(l[startNum], numLives);//Start/continue level

		} else if (choice == 2) {//Draw ChooseLevel screen
			active = false;
			paintChoose();

		} else if (choice == -1) {// win
			active = false;
			paintWin();

		} else if (choice == 3) {// fun
			active = false;
			paintFun();

		} else if (choice == 4) {//Draw Powerup key screen
			active = false;
			drawIndex();

		} else {// lose
			active = false;
			paintLose();

		}
	}


	public void paintFun() {//Draw :) screen
		g.setColor(Color.red);
		g.setFont(new Font("Helvetica", Font.BOLD, 76));
		g.drawString("Powerups", 100, 100);
		setBackground(Color.LIGHT_GRAY);

		g.setFont(new Font("Helvetica", Font.BOLD, 30));
		g.drawString("Select a powerup", 100, 200);
		g.setColor(Color.red);
		getG().fillOval(100, 420, 20, 20);
		g.setColor(Color.orange);
		getG().fillOval(200, 420, 20, 20);
		g.setColor(Color.yellow);
		getG().fillOval(300, 420, 20, 20);
		g.setColor(Color.green);
		getG().fillOval(400, 420, 20, 20);
		g.setColor(Color.blue);
		getG().fillOval(500, 420, 20, 20);
		g.setColor(Color.cyan);
		getG().fillOval(600, 420, 20, 20);
		g.setColor(Color.MAGENTA);
		getG().fillOval(700, 420, 20, 20);
		g.setColor(Color.pink);
		getG().fillOval(800, 420, 20, 20);
		g.setColor(Color.white);
		getG().fillOval(900, 420, 20, 20);
		g.setColor(Color.DARK_GRAY);
		getG().fillOval(1000, 420, 20, 20);

	}

	public void drawIndex() {//Draw powerups key screen
		setBackground(Color.LIGHT_GRAY);
		g.setColor(Color.RED);
		g.setFont(new Font("Helvetica", Font.BOLD, 76));
		g.drawString("INDEX", 100, 100);
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		g.setColor(Color.red);
		getG().fillOval(100, 150, 20, 20);
		g.drawString("Bar goes in opposite direction", 125, 167);
		g.setColor(Color.orange);
		getG().fillOval(100, 200, 20, 20);
		g.drawString("Bar will become long", 125, 217);
		g.setColor(Color.yellow);
		getG().fillOval(100, 250, 20, 20);
		g.drawString("Number of balls will increase", 125, 267);
		g.setColor(Color.green);
		getG().fillOval(100, 300, 20, 20);
		g.drawString("Ball will have double power", 125, 317);
		g.setColor(Color.blue);
		getG().fillOval(100, 350, 20, 20);
		g.drawString("Ball will slow down", 125, 367);
		g.setColor(Color.cyan);
		getG().fillOval(100, 400, 20, 20);
		g.drawString("Ball will speed up", 125, 417);
		g.setColor(Color.MAGENTA);
		getG().fillOval(100, 450, 20, 20);
		g.drawString("Bar will shoot lasers with space bar", 125, 467);
		g.setColor(Color.pink);
		getG().fillOval(100, 500, 20, 20);
		g.drawString("Bottom of screen will be lined with concrete blocks", 125, 517);
		g.setColor(Color.white);
		getG().fillOval(100, 550, 20, 20);
		g.drawString("Lives will increase by one", 125, 567);
		g.setColor(Color.DARK_GRAY);
		getG().fillOval(100, 600, 20, 20);
		g.drawString("Bar will catch the ball, release with space bar", 125, 617);

		g.drawString("Click Screen go back", 500, 700);
		JButton menu = new JButton();
		menu.setBounds(100, 770, 300, 200);
		menu.setBackground(Color.black);
		menu.setBorderPainted(false);
		menu.setForeground(Color.red);
		menu.setFont(new Font("Helvetica", Font.BOLD, 20));

		menu.addMouseListener(new MouseAdapter() {//Button to go back to menu
			public void mouseEntered(MouseEvent e) {
				menu.setFont(new Font("Helvetica", Font.BOLD, 50));
			}

			public void mouseExited(MouseEvent e) {
				menu.setFont(new Font("Helvetica", Font.BOLD, 20));
			}
		});
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();//Dispose current frame
				Driver.main(args);//Call main again
			}
		});
		frame.add(menu);
	}

	public void paintGame(Level l, int numLives) {//Draw game
		OG.setG(g);
		l.setNumLives(numLives);
		paintStructure();// Paint background of game

		a = l.playLevel(this);
		if (a == 1) {//beat stage
			startNum++;
			start=false;

			if (startNum >= this.l.length) {//win

				JFrame j = new JFrame();
				j.setTitle("Brick Breaker");
				j.setResizable(false);
				j.setSize(1325, 800);
				j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ColorPanel c = new ColorPanel();
				c.setActive(false);
				j.getContentPane().add(c);
				c.setChoice(-1);//to paint win screen
				c.setFrame(j);
				frame.dispose();//get rid of current frame for win screen
				j.setVisible(true);
			}

			else
				repaint();

		} else if (a == -1) {//lost
			JFrame j = new JFrame();
			j.setTitle("Brick Breaker");
			j.setResizable(false);
			j.setSize(1325, 800);
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ColorPanel c = new ColorPanel();
			c.setActive(false);
			j.getContentPane().add(c);
			c.setChoice(-2);//to paint lose screen
			c.setFrame(j);
			frame.dispose();//get rid of current frame for lose screen
			j.setVisible(true);

		} else {//a==0, continue game
			this.l[startNum].getBar().paintBar();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {// change speed of balls
				e.printStackTrace();
			}
			repaint();
		}
	}

	public void paintWin() {
		setBackground(Color.black);
		g.setColor(Color.red);
		BufferedImage im = null;
		try {
			im = ImageIO.read(new File("bbyouwin.jpg"));// Load and draw game background
		} catch (IOException exc) {
			// TODO: Handle exception.
		}
		g.drawImage(im, 200, 0, this);
		g.setFont(new Font("Helvetica", Font.BOLD, 50));
		g.drawString("Click Screen go to Menu", 375, 700);
		
		JButton menu = new JButton();//Button to go to menu
		menu.setBounds(100, 770, 300, 200);
		menu.setBackground(Color.black);
		menu.setBorderPainted(false);
		menu.setForeground(Color.red);
		menu.setFont(new Font("Helvetica", Font.BOLD, 20));
		menu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				menu.setFont(new Font("Helvetica", Font.BOLD, 50));
			}

			public void mouseExited(MouseEvent e) {
				menu.setFont(new Font("Helvetica", Font.BOLD, 20));
			}
		});
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();//get rid of current frame
				Driver.main(args);//call Driver
			}
		});
		frame.add(menu);

	}

	public void paintLose() {
		setBackground(Color.black);
		g.setColor(Color.red);
		g.setFont(new Font("Helvetica", Font.BOLD, 180));
		g.drawString("GAME OVER", 100, 200);
		g.setFont(new Font("Helvetica", Font.BOLD, 50));
		g.drawString("Click Screen go to Menu", 375, 700);
		JButton menu = new JButton();
		menu.setBounds(100, 770, 300, 200);
		menu.setBackground(Color.black);
		menu.setBorderPainted(false);
		menu.setForeground(Color.red);
		menu.setFont(new Font("Helvetica", Font.BOLD, 20));

		menu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				menu.setFont(new Font("Helvetica", Font.BOLD, 50));
			}

			public void mouseExited(MouseEvent e) {
				menu.setFont(new Font("Helvetica", Font.BOLD, 20));
			}
		});
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();//get rid of current frame
				Driver.main(args);//call Driver
			}
		});
		frame.add(menu);
	}

	public void paintChoose() {//Choose level screen
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(new Font("Helvetica", Font.BOLD, 76));
		g.drawString("Levels", 100, 100);
		setBackground(Color.gray);
	}

	public void paintStructure() {//Paints side, walls, background, everything but the objects
		setBackground(new Color(175, 175, 175));
		BufferedImage im = null;
		try {
			im = ImageIO.read(new File("bbsidecolor.jpg"));// Load and draw game background
		} catch (IOException exc) {
			// TODO: Handle exception.
		}
		for (int i = 0; i < 100; i++)
			g.drawImage(im, 1024, 1000 - i * 42, this);

		try {
			im = ImageIO.read(new File("bbscore.jpg"));// Load and draw game background
		} catch (IOException exc) {
			// TODO: Handle exception.
		}
		g.drawImage(im, 1021, 0, this);
		try {
			im = ImageIO.read(new File("bblives.jpg"));// Load and draw game background
		} catch (IOException exc) {
			// TODO: Handle exception.
		}
		g.drawImage(im, 1105, 65, this);
		g.setColor(new Color(65, 65, 70));
		g.fillRect(1100, 125, 150, 70);

		try {
			im = ImageIO.read(new File("brickbreakerBackground2.jpg"));// Load and draw game background
		} catch (IOException exc) {
			// TODO: Handle exception.
		}
		g.drawImage(im, 0, 0, this);

		g.setColor(new Color(224, 224, 224));
		g.fillRect(31, 25, 960, 737);// Draw over bricks, ball, and bar in the image for clean start

		if (numLives >= 3)//Different colors correspond to lives
			g.setColor(Color.green);
		if (numLives == 2)
			g.setColor(Color.orange);
		if (numLives == 1)
			g.setColor(Color.red);
		g.setFont(new Font("Helvetica", Font.BOLD, 80));
		g.drawString(numLives + "", 1150, 190);

		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Helvetica", Font.BOLD, 40));
		if (!(l.length <= 1)) {
			g.drawString("Level", 1100, 280);
			g.drawString(startNum + 1 + "", 1250, 280);//Only draw is user clicked Start, else, draw nothing
		}
		
		boolean isTrue=true;//True if user has a powerup
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		if (OG.getPowers()[0]) {
			g.setColor(Color.RED);
			g.drawString( "Opposite Bar", 1080, 350);
		}
		else if (OG.getPowers()[1]) {
			g.setColor(Color.ORANGE);
			g.drawString( "Long Bar", 1080, 350);
		}
		else if (OG.getPowers()[2]) {
			g.setColor(Color.YELLOW);
			g.drawString( "Balls++", 1080, 350);
		}
		else if (OG.getPowers()[3]) {
			g.setColor(Color.GREEN);
			g.drawString( "Power x 2", 1080, 350);
		}
		else if (OG.getPowers()[4]) {
			g.setColor(Color.BLUE);
			g.drawString( "Slow Ball", 1080, 350);
		}
		else if (OG.getPowers()[5]) {
			g.setColor(Color.CYAN);
			g.drawString( "Fast Ball", 1080, 350);
		}
		else if (OG.getPowers()[6]) {
			g.setColor(Color.MAGENTA);
			g.drawString( "Shoot Lasers", 1080, 350);
		}
		else if (OG.getPowers()[7]) {
			g.setColor(Color.PINK);
			g.drawString( "Concrete Bottom", 1080, 350);
		}
		else if (OG.getPowers()[8]) {
			g.setColor(Color.WHITE);
			g.drawString( "Lives++", 1080, 350);
		}
		else if (OG.getPowers()[9]) {
			g.setColor(Color.DARK_GRAY);
			g.drawString( "Catch Ball", 1080, 350);
		}
		else
			isTrue=false;
		if(isTrue) {//If user has powerup, draw powerup on the side to remind user
			g.setFont(new Font("Helvetica", Font.BOLD, 40));
			g.drawString( "Powerup:", 1080, 325);
			g.fillOval(1270, 300, 30, 30);
		}
		
		JButton menu = new JButton();//Button to go back to menu during the game
		menu.setBounds(100, 770, 300, 200);
		menu.setBackground(Color.black);
		menu.setBorderPainted(false);
		menu.setForeground(Color.red);
		menu.setFont(new Font("Helvetica", Font.BOLD, 10));
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		g.setColor(Color.black);
		g.drawString("Click Screen go to Menu", 1070, 750);
		menu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				menu.setFont(new Font("Helvetica", Font.BOLD, 10));
			}

			public void mouseExited(MouseEvent e) {
				menu.setFont(new Font("Helvetica", Font.BOLD, 20));
			}
		});
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();//Dispose current frame
				Driver.main(args);//Call main to go to menu and reset levels
			}
		});
		frame.add(menu);

	}

	public void actionPerformed(ActionEvent e) {//Auto-calls this method constantly
		if (active&&!(startNum>=l.length)) {//Takes place during a playLevel AND has not won yet
			if (a != 2) {
				if (start)//If hit spacebar already, move bar with velX
					l[startNum].getBar().setX(l[startNum].getBar().getX() + velX);
				else {//Not hit spacebar yet, move aimer line with velLine
					l[startNum].setLineX(l[startNum].getLineX() + velLine);
				}
			}
		}
		
	}


	public void left() {//Left arrow key
		if (start) {//Hit spacebar
			if (l[startNum].getBar().getX() > 31)//Bar in bounds
				velX = -15;//bar dX left
			else
				velX = 0;//not in bounds, don't move
		} else {//Not yet hit spacebar
			if (OG.getPowers()[0] == true) {//If opposite bar
				if (l[startNum].getLineX() < l[startNum].getB1().getX() + 70) {//If Line is in bounds
					velLine = 2;//Update velLine to move line in actionPerformed
				} else {//Not in bounds
					velLine = 0;//Line no move
				}
			} else {//If not opposite bar Powerup
				if (l[startNum].getLineX() > l[startNum].getB1().getX() - 70) {//Line in bounds
					velLine = -2;//Update velLine to move line in actionPerformed
				} else {//Noy in bounds
					velLine = 0;//Line no move
				}
			}
		}

	}

	public void right() {//Right arrow key
		if (start) {//Hit spacebar
			if (l[startNum].getBar().getX() + l[startNum].getBar().getLength() < 960)//Bar in bounds
				velX = 15;//Update velX to move bar in actionPerformed
			else//Bar not in bounds
				velX = 0;
		} else {//Not yet hit spacebar
			if (OG.getPowers()[0] == true) {//Opposite bar powerup active
				if (l[startNum].getLineX() > l[startNum].getB1().getX() - 70) {//Line in bounds
					velLine = -2;//Update velLine to move line in actionPerformed
				} else {
					velLine = 0;
				}
			} else {//opposite powerup not active
				if (l[startNum].getLineX() < l[startNum].getB1().getX() + 70) {//Line in bounds
					velLine = 2;//Update velLine to move line in actionPerformed
				} else {
					velLine = 0;
				}
			}
		}

		
	}

	public void keyPressed(KeyEvent e) {
		if (active) {
			int code = e.getKeyCode();
			if (code == KeyEvent.VK_LEFT) {//hit left key
				if (l[startNum].getBar().getPowers()[0])//IF opposite powerup active
					right();
				else
					left();
			}
			if (code == KeyEvent.VK_RIGHT) {//hit right key
				if (l[startNum].getBar().getPowers()[0])//IF opposite powerup active
					left();
				else
					right();
			}
			if (code == KeyEvent.VK_SPACE) {
				if (start == false) {//Not yet hit spacebar to release ball
					ballX = (int) ((l[startNum].getLineX() - l[startNum].getB1().getX()) / 10);//dX updated as line moves 
					ballY = 3;//keep dY constant
					l[startNum].getB().add(new Ball(l[startNum].getB1().getX(), 730, ballX, -ballY));//add ball to the level
					start = true;//prevent coming back here after hitting spacebar
					l[startNum].setReset(false);//Level will release ball and play the game
				} else if (l[startNum].getBar().getPowers()[6])//hit spacebar to release bar, but has laser powerup to shoot lasers
					l[startNum].setShot(true);
			}
		}
	}

	public void keyTyped(KeyEvent e) {//required, unused method
	}

	public void keyReleased(KeyEvent e) {//If not press key, bar and line don't move
		velX = 0;
		velLine = 0;

	}
}
