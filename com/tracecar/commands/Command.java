package com.tracecar.commands;

import com.tracecar.Car;

public abstract interface Command {
	public abstract void execute(Car car);
}
