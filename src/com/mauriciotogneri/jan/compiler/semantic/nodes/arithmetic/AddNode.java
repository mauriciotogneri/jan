package com.mauriciotogneri.jan.compiler.semantic.nodes.arithmetic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class AddNode extends PrimitiveNode
{
	public AddNode(Token token)
	{
		super(token, 2);
	}
}