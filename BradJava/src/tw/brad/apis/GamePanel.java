package tw.brad.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private BufferedImage ballImg;
	private int ballX, ballY, ballW, ballH;
	private Timer timer;
	
	public GamePanel() {
		setBackground(Color.YELLOW);
		try {
			ballImg = ImageIO.read(new File("dir1/ball0.png"));
			ballW = ballImg.getWidth();
			ballH = ballImg.getHeight();
		} catch (IOException e) {
			
		}
		addMouseListener(new MyListener());
		timer = new Timer();
		timer.schedule(new BallTask(), 1*1000, 30);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(ballImg, ballX, ballY, null);
		
	}
	
	private class BallTask extends TimerTask {
		@Override
		public void run() {
			ballX += 4;
			ballY += 4;
			repaint();
		}
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ballX = e.getX() - (int)(ballW / 2.0);
			ballY = e.getY() - (int)(ballH / 2.0);
			repaint();
		}
	}
	
	

}
