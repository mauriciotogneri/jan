package com.mauriciotogneri.jan.compiler.semantic.nodes;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.Node;

public abstract class OperatorNode extends Node
{
	public final int numberOfOperands;
	
	public OperatorNode(Token token, int numberOfOperands)
	{
		super(token);
		
		this.numberOfOperands = numberOfOperands;
	}
}