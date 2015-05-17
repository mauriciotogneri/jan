package com.mauriciotogneri.jan.compiler.semantic.nodes.arithmetic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class IncrementNode extends PrimitiveNode
{
	public IncrementNode(Token token)
	{
		super(token, 1);
	}
}