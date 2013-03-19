package com.tracecar.commands;

import com.tracecar.Car;

public class RightCommand implements Command {

	@Override
	public void execute(Car car) {
		car.right();
	}

}
