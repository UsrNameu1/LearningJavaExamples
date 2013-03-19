package com.tracecar;

import java.awt.Point;
import com.tracecar.window.LineDrawable;

public class Car {
	private static final int NORTH = 0;
	private static final int WEST  = 1;
	private static final int SOUTH = 2;
	private static final int EAST  = 3;
	
	private static final Point initPosition() { return new Point(400,400); }
	private Point currentPosition = new Point(400,400);
	private int direction = NORTH;
	
	private LineDrawable drawer;
	
	public Car(LineDrawable drawer){
		this.drawer = drawer;
	}
	
	public void go(){
		Point previousPosition = (Point) currentPosition.clone();
		switch (direction) {
		case NORTH:
			currentPosition.translate(0, -40);
			break;
		case WEST:
			currentPosition.translate(-40, 0);
			break;
		case SOUTH:
			currentPosition.translate(0, 40);
			break;
		case EAST:
			currentPosition.translate(40, 0);
			break;
		default:
			break;
		}
		drawer.drawLine(previousPosition, currentPosition);
	}
	
	public void left(){
		direction = (direction + 1) % 4;
	}
	
	public void right(){
		direction = (direction + 3) % 4;
	}
	
	public void init(){
		currentPosition = initPosition();
		direction = NORTH;
	}
		
}
