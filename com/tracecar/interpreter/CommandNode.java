package com.tracecar.interpreter;

// <command> ::= <repeat command> | <primitive command>
public class CommandNode extends Node {
	private Node node;

	@Override
	public void parse(Context context) throws ParseException {
		node = context.currentToken().equals("repeat")?
				new RepeatCommandNode() : new PrimitiveCommandNode();
		node.parse(context);
	}
	
	@Override
	public String toString(){
		return node.toString();
	}
}
