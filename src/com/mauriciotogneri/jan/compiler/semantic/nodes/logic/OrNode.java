package com.mauriciotogneri.jan.compiler.semantic.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class OrNode extends PrimitiveNode
{
	public OrNode(Token token)
	{
		super(token, 2);
	}
}