package com.tracecar.window;

import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import com.tracecar.Car;
import com.tracecar.commands.PrimitiveCommandFactory;
import com.tracecar.interpreter.Interpreter;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//View
	private TextField programTextField = new TextField();
	private LineCanvas canvas = new LineCanvas(800, 800);
	
	//Model
	private Car car = new Car(canvas);
	private PrimitiveCommandFactory factory = new PrimitiveCommandFactory();
	
	public MainWindow (String title){
		super(title);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		programTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == '\n') returnKeyReleased();
				super.keyReleased(e);
			}
		});
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(programTextField);
		mainBox.add(canvas);
		getContentPane().add(mainBox);
		
		pack();
		setVisible(true);
	}
	
	private void returnKeyReleased(){
		canvas.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		car.init();
		
		//regenerate commands
		factory.clearCommands();
		for (String command : 
			Interpreter.interpretedCommandList(programTextField.getText())) {
			factory.create(command);
		}
		factory.sendCommandsToCar(car);
	}
	
}
