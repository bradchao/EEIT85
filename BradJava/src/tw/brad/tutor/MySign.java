package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.apis.MyPanelV2;

public class MySign extends JFrame{
	private MyPanelV2 myPanel;
	private JButton clear, undo, redo;
	
	public MySign() {
		super("Sign App");
		
		myPanel = new MyPanelV2();
		setLayout(new BorderLayout());
		add(myPanel, BorderLayout.CENTER);
		
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo);top.add(redo);
		add(top, BorderLayout.NORTH);
		
		setSize(800,  600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.redo();
			}
		});
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
