//FINAL
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Driver {

	public static void main(String[] args) {

		boolean []a = new boolean[10];//RESET POWERS
		OG.setPowers(a);
		Level[] levelArr = new Level[10];
		for (int i = 0; i < levelArr.length; i++)//Initialize and create levels
			levelArr[i] = new Level();
		ArrayList<Block> blocks = new ArrayList<Block>();
		blocks.add(new Brick(3, 309, 218));
		blocks.add(new Brick(4, 445, 218));
		blocks.add(new Brick(3, 581, 218));
		blocks.add(new Brick(2, 717, 218));
		blocks.add(new Brick(1, 853, 218));
		blocks.add(new Brick(1, 37, 218));
		blocks.add(new Brick(2, 173, 218));

		blocks.add(new Brick(2, 309, 162));
		blocks.add(new Brick(3, 445, 162));
		blocks.add(new Brick(2, 581, 162));
		blocks.add(new Brick(1, 717, 162));
		blocks.add(new Brick(1, 853, 162));
		blocks.add(new Brick(1, 37, 162));
		blocks.add(new Brick(1, 173, 162));

		blocks.add(new Brick(1, 309, 106));
		blocks.add(new Brick(2, 445, 106));
		blocks.add(new Brick(1, 581, 106));
		blocks.add(new Brick(1, 717, 106));
		blocks.add(new Brick(1, 853, 106));
		blocks.add(new Brick(1, 37, 106));
		blocks.add(new Brick(1, 173, 106));
		levelArr[0].setBlocks(blocks);
		
		//level two
	blocks=new ArrayList<Block>();
	blocks.add(new Brick(3, (31+960)/2-68, 29));
	blocks.add(new Brick(3, (31+960)/2-136, 29+56));
	blocks.add(new Brick(3, (31+960)/2,29+56));
	blocks.add(new Brick(2, (31+960)/2-68, 29+56*2));
	blocks.add(new Brick(3, (31+960)/2-136-68, 29+56*2));
	blocks.add(new Brick(3, (31+960)/2+68,29+56*2));
	blocks.add(new Brick(2,(31+960)/2-136, 29+56*3));
	blocks.add(new Brick(2, (31+960)/2,29+56*3));
	blocks.add(new Brick(3, (31+960)/2-136-136, 29+56*3));
	blocks.add(new Brick(3, (31+960)/2+136,29+56*3));
	blocks.add(new Brick(2, (31+960)/2-68, 29+56*4));
	blocks.add(new Brick(3, (31+960)/2-136-68, 29+56* 4));
	blocks.add(new Brick(3, (31+960)/2+68,29+56*4));
	blocks.add(new Brick(3, (31+960)/2-136, 29+56*5));
	blocks.add(new Brick(3, (31+960)/2,29+56*5));
	blocks.add(new Brick(3, (31+960)/2-68, 29+56*6));
	levelArr[1].setBlocks(blocks);
	
	//level three
	blocks=new ArrayList<Block>();
	blocks.add(new Brick(4, 35, 29));
	blocks.add(new Brick(4, 37, 29+56));
	blocks.add(new Brick(2, 37, 29+56*2));
	blocks.add(new Brick(2, 37, 29+56*3));
	blocks.add(new Brick(2, 37, 29+56*4));
	blocks.add(new Brick(4, 37, 29+56*5));
	blocks.add(new Brick(4, 37, 29+56*6));
	blocks.add(new Brick(4, (31+960)/2-68, 29));
	blocks.add(new Brick(4, (31+960)/2-68, 29+56));
	blocks.add(new Brick(2, (31+960)/2-68, 29+56*2));
	blocks.add(new Brick(2, (31+960)/2-68, 29+56*3));
	blocks.add(new Brick(2, (31+960)/2-68, 29+56*4));
	blocks.add(new Brick(4, (31+960)/2-68, 29+56*5));
	blocks.add(new Brick(4, (31+960)/2-68, 29+56*6));
	blocks.add(new Brick(4, 954-140, 29));
	blocks.add(new Brick(4,954-140, 29+56));
	blocks.add(new Brick(2, 954-140, 29+56*2));
	blocks.add(new Brick(2, 954-140, 29+56*3));
	blocks.add(new Brick(2, 954-140, 29+56*4));
	blocks.add(new Brick(4, 954-140, 29+56*5));
	blocks.add(new Brick(4, 954-140, 29+56*6));
	levelArr[2].setBlocks(blocks);
	
	//level four
	blocks=new ArrayList<Block>();
	blocks.add(new Brick(3, 87, 29));
	blocks.add(new Brick(3, 87+140, 29));
	blocks.add(new Brick(3, 87+280,29));
	blocks.add(new Brick(3, 87+420, 29));
	blocks.add(new Brick(3, 87+560, 29));
	blocks.add(new Brick(3, 87+700,29));
	blocks.add(new Brick(3, 87+136, 29+56));
	blocks.add(new Brick(3, 87+136*2,29+56));
	blocks.add(new Brick(3, 87+136*3, 29+56));
	blocks.add(new Brick(3, 87+136*4, 29 +56));
	blocks.add(new Brick(3, 87+136*2,29+112));
	blocks.add(new Brick(3, 87+136*3, 29+112));
	blocks.add(new ConcreteBlock( 37, 29+56*4));
	blocks.add(new ConcreteBlock( 37+136, 29+56*4));
	blocks.add(new ConcreteBlock( 954-272, 29+56*4));
	blocks.add(new ConcreteBlock(954-136,29+56*4));
	blocks.add(new ConcreteBlock( 87+136*2, 29+56*6));
	blocks.add(new ConcreteBlock(87+136*3,29+56*6));
	blocks.add(new ConcreteBlock( 87+136*4, 29+56*6));
	blocks.add(new ConcreteBlock( 87+136, 29 +56*6));
	levelArr[3].setBlocks(blocks);
	
	//level 5
	blocks=new ArrayList<Block>();
	blocks.add(new Brick(4,37, 29));
	blocks.add(new Brick(4,37+136, 29));
	blocks.add(new Brick(4,954-136, 29));
	blocks.add(new Brick(4,954-136*2, 29));
	blocks.add(new Brick(4,37, 29+56));
	blocks.add(new Brick(4,37+136, 29+56));
	blocks.add(new Brick(4,954-136, 29+56));
	blocks.add(new Brick(4,954-136*2, 29+56));
	blocks.add(new Brick(4,37, 29+56*5));
	blocks.add(new Brick(4,37+136, 29+56*5));
	blocks.add(new Brick(4,954-136, 29+56*5));
	blocks.add(new Brick(4,954-136*2, 29+56*5));
	blocks.add(new Brick(4,37, 29+56*6));
	blocks.add(new Brick(4,37+136, 29+56*6));
	blocks.add(new Brick(4,954-136, 29+56*6));
	blocks.add(new Brick(4,954-136*2, 29+56*6));
	blocks.add(new ConcreteBlock((31+960)/2-68, 29+56*3));
	levelArr[4].setBlocks(blocks);
	
	//level 6
	blocks=new ArrayList<Block>();
	blocks.add(new Brick(3,37+136, 29+56));
	blocks.add(new Brick(3,37+136, 29+56*2));
	blocks.add(new Brick(3,37+136, 29+56*3));
	blocks.add(new Brick(3,37+136, 29+56*4));
	blocks.add(new Brick(3,37+136, 29+56*5));
	blocks.add(new Brick(1,37+136*2, 29+56*3));
	blocks.add(new Brick(1,37+136*2, 29+56*4));
	blocks.add(new Brick(3,37+136*2, 29+56*5));
	blocks.add(new Brick(3,37+136*2, 29+56*6));
	blocks.add(new Brick(3,37+136*2, 29+56*7));
	blocks.add(new Brick(1,37+136*3, 29+56*3));
	blocks.add(new Brick(1,37+136*3, 29+56*4));
	blocks.add(new Brick(3,37+136*3, 29+56*5));
	blocks.add(new Brick(1,37+136*4, 29+56*3));
	blocks.add(new Brick(1,37+136*4, 29+56*4));
	blocks.add(new Brick(3,37+136*4, 29+56*5));
	blocks.add(new Brick(3,37+136*4, 29+56*6));
	blocks.add(new Brick(3,37+136*4, 29+56*7));
	blocks.add(new Brick(3,37+136*5, 29+56));
	blocks.add(new Brick(3,37+136*5, 29+56*2));
	blocks.add(new Brick(3,37+136*5, 29+56*3));
	blocks.add(new Brick(3,37+136*5, 29+56*4));
	blocks.add(new Brick(3,37+136*5, 29+56*5));
	levelArr[5].setBlocks(blocks);
	
	//level 7
	blocks=new ArrayList<Block>();
	blocks.add(new Brick(4,37+136, 29+56));
	blocks.add(new Brick(4,37+136, 29+56*2));
	blocks.add(new Brick(4,37+136, 29+56*3));
	blocks.add(new Brick(4,37+136, 29+56*4));
	blocks.add(new Brick(4,37+136, 29+56*5));
	blocks.add(new Brick(4,37+136*2, 29+56));
	blocks.add(new Brick(3,37+136*2, 29+56*2));
	blocks.add(new Brick(3,37+136*2, 29+56*3));
	blocks.add(new Brick(3,37+136*2, 29+56*4));
	blocks.add(new Brick(4,37+136*2, 29+56*5));
	blocks.add(new Brick(4,37+136*3, 29+56));
	blocks.add(new Brick(3,37+136*3, 29+56*2));
	blocks.add(new Brick(1,37+136*3, 29+56*3));
	blocks.add(new Brick(3,37+136*3, 29+56*4));
	blocks.add(new Brick(4,37+136*3, 29+56*5));
	blocks.add(new Brick(4,37+136*4, 29+56));
	blocks.add(new Brick(3,37+136*4, 29+56*2));
	blocks.add(new Brick(3,37+136*4, 29+56*3));
	blocks.add(new Brick(3,37+136*4, 29+56*4));
	blocks.add(new Brick(4,37+136*4, 29+56*5));
	blocks.add(new Brick(4,37+136*5, 29+56));
	blocks.add(new Brick(4,37+136*5, 29+56*2));
	blocks.add(new Brick(4,37+136*5, 29+56*3));
	blocks.add(new Brick(4,37+136*5, 29+56*4));
	blocks.add(new Brick(4,37+136*5, 29+56*5));
	levelArr[6].setBlocks(blocks);
	
	//level 8
	blocks=new ArrayList<Block>();
	blocks.add(new Brick(2,37, 29+56));
	blocks.add(new Brick(2,37+136, 29+56));
	blocks.add(new Brick(2,37+136*2, 29+56));
	blocks.add(new Brick(2,37+136*3, 29+56));
	blocks.add(new ConcreteBlock(37+136*4, 29+56));
	blocks.add(new Brick(3,954-136, 29+56*3));
	blocks.add(new Brick(3,954-136*2, 29+56*3));
	blocks.add(new Brick(3,954-136*3, 29+56*3));
	blocks.add(new Brick(3,954-136*4, 29+56*3));
	blocks.add(new ConcreteBlock(954-136*5, 29+56*3));
	blocks.add(new Brick(4,37, 29+56*5));
	blocks.add(new Brick(4,37+136, 29+56*5));
	blocks.add(new Brick(4,37+136*2, 29+56*5));
	blocks.add(new Brick(4,37+136*3, 29+56*5));
	blocks.add(new ConcreteBlock(37+136*4, 29+56*5));
	levelArr[7].setBlocks(blocks);
	
	//level 9
	blocks=new ArrayList<Block>();
	blocks.add(new ConcreteBlock(37, 29+56*7));
	blocks.add(new ConcreteBlock(37+136, 29+56*6));
	blocks.add(new ConcreteBlock(37+136*2, 29+56*5));
	blocks.add(new ConcreteBlock(954-136, 29+56*7));
	blocks.add(new ConcreteBlock(954-136*2, 29+56*6));
	blocks.add(new ConcreteBlock(954-136*3, 29+56*5));
	blocks.add(new Brick(3,37, 29+56*6));
	blocks.add(new Brick(3,37, 29+56*5));
	blocks.add(new Brick(3,37, 29+56*4));
	blocks.add(new Brick(3,37, 29+56*3));
	blocks.add(new ConcreteBlock(37+136, 29+56*6));
	blocks.add(new Brick(3,37+136, 29+56*5));
	blocks.add(new Brick(3,37+136, 29+56*4));
	blocks.add(new Brick(3,954-136, 29+56*6));
	blocks.add(new Brick(3,954-136, 29+56*5));
	blocks.add(new Brick(3,954-136, 29+56*4));
	blocks.add(new Brick(3,954-136, 29+56*3));
	blocks.add(new Brick(3,954-136*2, 29+56*5));
	blocks.add(new Brick(3,954-136*2, 29+56*4));
	levelArr[8].setBlocks(blocks);




		ArrayList<Block> blocks9 = new ArrayList<Block>();
		blocks9.add(new Brick(2, 173, 442));
		blocks9.add(new Brick(2, 445, 442));
		blocks9.add(new Brick(2, 717, 442));
		blocks9.add(new Brick(4, 37, 386));
		blocks9.add(new Brick(4, 309, 386));
		blocks9.add(new Brick(4, 581, 386));
		blocks9.add(new Brick(4, 856, 386));
		blocks9.add(new ConcreteBlock(717, 498));
		blocks9.add(new ConcreteBlock(445, 498));
		blocks9.add(new ConcreteBlock(173, 498));
		
		blocks9.add(new ConcreteBlock(581, 330));
		blocks9.add(new ConcreteBlock(445, 330));
		blocks9.add(new ConcreteBlock(717, 330));
		blocks9.add(new ConcreteBlock(309, 330));
		blocks9.add(new ConcreteBlock(173, 330));
		blocks9.add(new ConcreteBlock(173, 274));
		blocks9.add(new ConcreteBlock(717, 274));
		blocks9.add(new ConcreteBlock(717, 218));
		blocks9.add(new ConcreteBlock(173, 218));
		blocks9.add(new Brick(4, 309, 274));
		blocks9.add(new Brick(4, 445, 274));
		blocks9.add(new Brick(4, 581, 274));
		blocks9.add(new Brick(3, 309, 218));
		blocks9.add(new Brick(3, 445, 218));
		blocks9.add(new Brick(3, 581, 218));
		levelArr[8].setBlocks(blocks9);

		
		JFrame JFrame1 = new JFrame();
		ColorPanel.setArgs(args);//set colorpanel with args to call main to return to menu
		JButton start = new JButton("START");//
		JButton choose = new JButton("CHOOSE LEVEL");
		JButton key = new JButton("KEY");//Key of all powerups
		JFrame1.setTitle("Brick Breaker");
		JFrame1.setResizable(false);
		JFrame1.setSize(1000, 1000);
		JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorPanel c = new ColorPanel();
		c.setL(levelArr);//Give entire set of levels

		key.setBounds(0, 0, 150, 50);
		key.setBackground(new Color(19, 64, 21));
		key.setBorderPainted(false);
		key.setForeground(Color.yellow);
		key.setFont(new Font("Helvetica", Font.BOLD, 20));
		key.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				key.setFont(new Font("Helvetica", Font.BOLD, 22));
			}

			public void mouseExited(MouseEvent e) {
				key.setFont(new Font("Helvetica", Font.BOLD, 20));
			}
		});
		key.addActionListener(new ActionListener() {//IF press button

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame1.dispose();
				JFrame j1 = new JFrame();
				j1.setTitle("INDEX");
				j1.setResizable(false);
				j1.setSize(1325, 800);
				j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ColorPanel c1 = new ColorPanel();
				c1.setNumLives(3);

				j1.dispose();//get rid of old frame

				j1.getContentPane().add(c1);
				j1.setVisible(true);
				OG.setC(c1);
				c1.setFrame(j1);
				c1.setL(levelArr);
				c1.setChoice(4);//powerups key screen

			}
		});
		JFrame1.add(key);

		start.setBounds(100, 770, 300, 200);
		start.setBackground(new Color(19, 64, 21));
		start.setBorderPainted(false);
		start.setForeground(Color.yellow);
		start.setFont(new Font("Helvetica", Font.BOLD, 20));
		start.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				start.setFont(new Font("Helvetica", Font.BOLD, 50));
			}

			public void mouseExited(MouseEvent e) {
				start.setFont(new Font("Helvetica", Font.BOLD, 20));
			}
		});
		start.addActionListener(new ActionListener() {//IF press button

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame1.dispose();
				JFrame j1 = new JFrame();
				j1.setTitle("Brick Breaker");
				j1.setResizable(false);
				j1.setSize(1325, 800);
				j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ColorPanel c1 = new ColorPanel();
				c1.setNumLives(3);

				j1.dispose();//get rid of menu screen

				j1.getContentPane().add(c1);
				j1.setVisible(true);
				OG.setC(c1);//use to draw images on colorpanel for objects not extending JPanel
				c1.setFrame(j1);//to dispose after return to menu screen
				c1.setL(levelArr);
				c1.setChoice(1);//play level screen
			}
		});

		choose.setBounds(500, 770, 500, 200);
		choose.setBackground(new Color(19, 64, 21));
		choose.setBorderPainted(false);
		choose.setForeground(Color.yellow);
		choose.setFont(new Font("Helvetica", Font.BOLD, 20));
		choose.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				choose.setFont(new Font("Helvetica", Font.BOLD, 50));
			}

			public void mouseExited(MouseEvent e) {
				choose.setFont(new Font("Helvetica", Font.BOLD, 20));
			}
		});
		choose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {//IF press button, go to choose level screen
				JFrame j1 = new JFrame();
				j1.setTitle("Choose Level");
				j1.setResizable(false);
				j1.setSize(1200, 1000);
				j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ColorPanel c1 = new ColorPanel();
				c1.setChoice(2);//choose level screen

				int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };//Numbers to be drawn

				for (int i = 0; i < 9; i++) {//make buttons for each level
					JButton level1 = new JButton("" + arr[i]);
					level1.setBounds(100 * i + 50, 300, 100, 100);
					level1.setBackground(Color.gray);
					level1.setBorderPainted(false);
					level1.setForeground(Color.white);
					level1.setFont(new Font("Helvetica", Font.BOLD, 70));
					Level[] temp = { levelArr[arr[i] - 1] };//ONLY one level, selected level
					level1.addMouseListener(new MouseAdapter() {
						public void mouseEntered(MouseEvent e) {
							level1.setFont(new Font("Helvetica", Font.BOLD, 72));
						}

						public void mouseExited(MouseEvent e) {
							level1.setFont(new Font("Helvetica", Font.BOLD, 70));
						}
					});
					level1.addActionListener(new ActionListener() {//If press button, go to that level

						@Override
						public void actionPerformed(ActionEvent arg0) {
							JFrame j2 = new JFrame();
							j2.setTitle("Brick Breaker");
							j2.setResizable(false);
							j2.setSize(1325, 800);
							j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							ColorPanel c2 = new ColorPanel();
							j2.getContentPane().add(c2);
							c2.setNumLives(3);
							c2.setFrame(j2);//to dispose after returning to menu
							c2.setL(temp);
							c2.setChoice(1);//playLevel screen
							OG.setC(c2);//to access colorpanel by objects not extending JPanel to draw images
							j2.setVisible(true);
							j1.dispose();
							// DO GAME
							// main(args);

						}
					});

					j1.add(level1);

				}

				JButton fun = new JButton(":)");//Last level button
				fun.setBounds(100 * 9 + 50, 300, 100, 100);
				fun.setBackground(Color.gray);
				fun.setBorderPainted(false);
				fun.setForeground(Color.white);
				fun.setFont(new Font("Helvetica", Font.BOLD, 20));
				fun.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						fun.setFont(new Font("Helvetica", Font.BOLD, 50));
					}

					public void mouseExited(MouseEvent e) {
						fun.setFont(new Font("Helvetica", Font.BOLD, 20));
					}
				});
				fun.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {//If hit :), go to fun screen
						JFrame funFrame = new JFrame();
						funFrame.setTitle(":)");
						funFrame.setResizable(false);
						funFrame.setSize(1200, 1000);
						funFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						ColorPanel funPanel = new ColorPanel();
						funPanel.setChoice(3);

						String[] arr = { ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };//Looks cool

						for (int i = 0; i < arr.length; i++) {//each button for each powerup
							Integer I = i;//MUST use object to be accessed by actionPerformed
							JButton level1 = new JButton("" + arr[i]);
							level1.setBounds(100 * i + 50, 300, 120, 100);
							level1.setBorderPainted(false);
							level1.setBackground(Color.LIGHT_GRAY);
							level1.setForeground(Color.red);
							level1.setFont(new Font("Helvetica", Font.BOLD, 150));
							boolean[] temp = new boolean[10];
							level1.addMouseListener(new MouseAdapter() {
								public void mouseEntered(MouseEvent e) {
									level1.setFont(new Font("Helvetica", Font.BOLD, 200));
								}

								public void mouseExited(MouseEvent e) {
									level1.setFont(new Font("Helvetica", Font.BOLD, 150));
								}
							});
							level1.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {//If button is hit, corresponding powerup is activated
									temp[I] = true;
									OG.setPowers(temp);
								}
							});

							funFrame.add(level1);

						}

						JButton playButton = new JButton("PLAY");//After powerup is chosen, go to level
						playButton.setBounds(400, 600, 400, 100);
						playButton.setBackground(Color.LIGHT_GRAY);
						playButton.setBorderPainted(false);
						playButton.setForeground(Color.red);
						playButton.setFont(new Font("Helvetica", Font.BOLD, 70));
						Level[] temp = { levelArr[0] };//goes to the first level
						playButton.addMouseListener(new MouseAdapter() {
							public void mouseEntered(MouseEvent e) {
								playButton.setFont(new Font("Helvetica", Font.BOLD, 90));
							}

							public void mouseExited(MouseEvent e) {
								playButton.setFont(new Font("Helvetica", Font.BOLD, 70));
							}
						});
						playButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								JFrame j2 = new JFrame();
								j2.setTitle("Brick Breaker");
								j2.setResizable(false);
								j2.setSize(1325, 800);
								j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								ColorPanel c2 = new ColorPanel();
								j2.getContentPane().add(c2);
								c2.setNumLives(3);
								c2.setFrame(j2);//use to dispose to return to menu
								c2.setL(temp);
								c2.setChoice(1);//playLevel screen
								OG.setC(c2);//to access colorpanel by objects not extending JPanel to draw images
								j2.setVisible(true);
								funFrame.dispose();

							}
						});

						//add all buttons to frames
						funFrame.add(playButton);

						funFrame.getContentPane().add(funPanel);
						funFrame.setVisible(true);
						j1.dispose();

					}
				});
				j1.add(fun);

				j1.getContentPane().add(c1);
				j1.setVisible(true);
				JFrame1.dispose();

			}
		});

		JFrame1.add(choose);
		JFrame1.add(start);
		JFrame1.add(key);
		OG.setC(c);//to access colorpanel by objects not extending JPanel to draw images
		JFrame1.getContentPane().add(c);
		JFrame1.setVisible(true);

	}


}