package com.mauriciotogneri.jan.compiler.semantic.nodes;

import com.mauriciotogneri.jan.compiler.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class FunctionNode extends OperatorNode
{
	private final FunctionDefinition function;
	
	public FunctionNode(Token token, FunctionDefinition function)
	{
		super(token, function.getNumberOfParameters());
		
		this.function = function;
	}
}