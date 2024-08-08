package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.apis.MyPanelV2;

public class MySign extends JFrame{
	private MyPanelV2 myPanel;
	private JButton clear, undo, redo, color, saveObj, loadObj;
	
	public MySign() {
		super("Sign App");
		
		myPanel = new MyPanelV2();
		setLayout(new BorderLayout());
		add(myPanel, BorderLayout.CENTER);
		
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		saveObj = new JButton("Save Object");
		loadObj = new JButton("Load Object");
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo);top.add(redo);
		top.add(color); top.add(saveObj); top.add(loadObj);
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
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		saveObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}
		});
		loadObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObject();
			}
		});
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(null, "Change Color", myPanel.getColor());
		if (newColor != null) {
			myPanel.setColor(newColor);
		}
	}
	
	private void saveObject() {
		
	}
	private void loadObject() {
		
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
