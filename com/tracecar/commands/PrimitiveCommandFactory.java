package com.tracecar.commands;

import com.tracecar.Car;

public class PrimitiveCommandFactory extends CommandFactory {
	private MacroCommand commands = new MacroCommand();

	@Override
	protected Command createCommand(String commandName) {
		
		if (commandName.equals("go")) {
			return new GoCommand();
		}
		else if(commandName.equals("right")){
			return new RightCommand();
		}
		else if (commandName.equals("left")){
			return new LeftCommand();
		}
		return null;
	}

	@Override
	protected void registerCommand(Command cmd) {
		commands.append(cmd);
	}
	
	public void sendCommandsToCar(Car car){
		commands.execute(car);
	}
	
	public void clearCommands(){
		commands.clear();
	}

}
