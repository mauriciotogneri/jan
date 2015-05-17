package com.mauriciotogneri.jan.compiler.semantic.nodes;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.Node;

public class ParameterNode extends Node
{
	public final int index;
	
	public ParameterNode(Token token, int index)
	{
		super(token);
		
		this.index = index;
	}
}