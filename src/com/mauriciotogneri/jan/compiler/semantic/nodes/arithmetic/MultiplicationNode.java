package com.mauriciotogneri.jan.compiler.semantic.nodes.arithmetic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class MultiplicationNode extends PrimitiveNode
{
	public MultiplicationNode(Token token)
	{
		super(token, 2);
	}
}