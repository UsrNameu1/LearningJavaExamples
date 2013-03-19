package com.tracecar.commands;

import java.util.Stack;
import java.util.Iterator;

import com.tracecar.Car;

public class MacroCommand implements Command {
	private Stack<Command> commands = new Stack<Command>();

	@Override
	public void execute(Car car) {
		Iterator<Command> it = commands.iterator();
		while (it.hasNext()) {
			it.next().execute(car);
		}
	}
	public void append(Command cmd) {
		if (cmd != this) {
			commands.push(cmd);
		}
	}
	public void clear() {
		commands.clear();
	}
}
