package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.GiftTable;

public class MyGift extends JFrame{
	private GiftTable giftTable;
	
	
	public MyGift() {
		super("伴手禮");
		
		giftTable = new GiftTable();
		setLayout(new BorderLayout());
		add(giftTable, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyGift();
	}

}
