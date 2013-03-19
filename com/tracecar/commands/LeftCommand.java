package com.tracecar.commands;

import com.tracecar.Car;

public class LeftCommand implements Command {
	
	@Override
	public void execute(Car car) {
		car.left();
	}

}
