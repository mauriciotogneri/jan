package com.mauriciotogneri.jan.compiler.semantic.nodes.conditional;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class IfNode extends PrimitiveNode
{
	public IfNode(Token token)
	{
		super(token, 2);
	}
}