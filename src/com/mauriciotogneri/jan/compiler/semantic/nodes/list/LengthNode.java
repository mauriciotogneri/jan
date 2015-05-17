package com.mauriciotogneri.jan.compiler.semantic.nodes.list;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class LengthNode extends PrimitiveNode
{
	public LengthNode(Token token)
	{
		super(token, 1);
	}
}