package com.tracecar.commands;

public abstract class CommandFactory {

	public final void create(String commandName){
		Command p = createCommand(commandName);
		registerCommand(p);
	}
	protected abstract Command createCommand(String owner);
	protected abstract void registerCommand(Command product);
}
