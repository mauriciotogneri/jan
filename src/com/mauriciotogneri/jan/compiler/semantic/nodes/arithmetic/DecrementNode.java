package com.mauriciotogneri.jan.compiler.semantic.nodes.arithmetic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class DecrementNode extends PrimitiveNode
{
	public DecrementNode(Token token)
	{
		super(token, 1);
	}
}