package com.mauriciotogneri.jan.compiler.semantic.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class AndNode extends PrimitiveNode
{
	public AndNode(Token token)
	{
		super(token, 2);
	}
}