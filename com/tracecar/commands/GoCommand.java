package com.tracecar.commands;

import com.tracecar.Car;

public class GoCommand implements Command {
	
	@Override
	public void execute(Car car) {
		car.go();
	}

}
