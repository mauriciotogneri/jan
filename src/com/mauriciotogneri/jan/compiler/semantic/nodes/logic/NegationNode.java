package com.mauriciotogneri.jan.compiler.semantic.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class NegationNode extends PrimitiveNode
{
	public NegationNode(Token token)
	{
		super(token, 1);
	}
}