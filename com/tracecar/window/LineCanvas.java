package com.tracecar.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class LineCanvas extends Canvas implements LineDrawable{
	private static final long serialVersionUID = 1L;
	
	private Color color = Color.black;
	private int radius  = 5; 
	
	public LineCanvas(int width, int height){
		setSize(width, height);
		setBackground(Color.white);
	}
	
	@Override
	public void drawLine(Point from, Point to) {
		Graphics graphics = getGraphics();
		graphics.setColor(color);
		graphics.drawLine(from.x, from.y, to.x, to.y);
		graphics.fillOval(to.x - radius, to.y - radius, radius * 2, radius * 2);
	}

}
