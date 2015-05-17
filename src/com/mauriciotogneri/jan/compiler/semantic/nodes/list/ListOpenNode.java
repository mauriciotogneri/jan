package com.mauriciotogneri.jan.compiler.semantic.nodes.list;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class ListOpenNode extends PrimitiveNode
{
	public ListOpenNode(Token token)
	{
		super(token, 0);
	}
}