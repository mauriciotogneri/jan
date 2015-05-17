package com.mauriciotogneri.jan.compiler.semantic.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class LessNode extends PrimitiveNode
{
	public LessNode(Token token)
	{
		super(token, 2);
	}
}