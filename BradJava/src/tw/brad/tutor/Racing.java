package tw.brad.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	
	public Racing() {
		super("Racing");
		
		setLayout(new GridLayout(9,1));
		go = new JButton("Go!"); add(go);
		lanes = new JLabel[8];
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel(String.format("%d. ", (i+1)));
			add(lanes[i]);
		}
		
		setSize(1024, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initGame();
	}
	
	private void initGame() {
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
	}
	
	private void go() {
		cars = new Car[8];
		for (int i=0; i<cars.length; i++) {
			cars[i] = new Car(i);
		}
		for (int i=0; i<cars.length; i++) {
			cars[i].start();
		}
		
	}
	
	private class Car extends Thread {
		private int lane;
		private StringBuffer path;
		Car(int lane){
			this.lane = lane;
			path = new StringBuffer(String.format("%d. ", (lane+1)));
		}
		@Override
		public void run() {
			for (int i=0; i<100; i++) {
				path.append(">");
				lanes[lane].setText(path.toString());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public static void main(String[] args) {
		new Racing();
	}

}


