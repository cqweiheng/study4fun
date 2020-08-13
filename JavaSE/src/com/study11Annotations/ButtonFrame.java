package com.study11Annotations;

import javax.swing.*;
import java.awt.*;

public class ButtonFrame extends JFrame {

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	private JPanel panel;
	private JButton yellowButton;
	private JButton blueButton;
	private JButton redButton;

	public ButtonFrame() throws HeadlessException {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		panel = new JPanel();
		add(panel);

		yellowButton = new JButton("Yellow");
		blueButton = new JButton("Blue");
		redButton = new JButton("Red");

		panel.add(yellowButton);
		panel.add(blueButton);
		panel.add(redButton);

		ActionListenerInstaller.processAnnotation(this);
	}

	@ActionListenerFor(source = "yellowButton")
	public void yellowBackgroud(){
		panel.setBackground(Color.YELLOW);
	}

	@ActionListenerFor(source = "blueButton")
	public void blueBackgroud(){
		panel.setBackground(Color.BLUE);
	}

	@ActionListenerFor(source = "redButton")
	public void redBackgroud(){
		panel.setBackground(Color.RED);
	}
}
