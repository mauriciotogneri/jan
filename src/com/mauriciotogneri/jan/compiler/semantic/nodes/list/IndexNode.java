package com.mauriciotogneri.jan.compiler.semantic.nodes.list;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class IndexNode extends PrimitiveNode
{
	public IndexNode(Token token)
	{
		super(token, 2);
	}
}