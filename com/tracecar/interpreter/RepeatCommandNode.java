package com.tracecar.interpreter;

// <repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode extends Node {
	private int number;
	private Node commandListNode;
	
	@Override
	public void parse(Context context) throws ParseException {
		context.skipToken("repeat");
		number = context.currentNumber();
		context.nextToken();
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}
	
	@Override
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < number; i++) {
			buffer.append(commandListNode);
		}
		buffer.substring(0, buffer.length()-1);
		return buffer.toString();
	}

}
