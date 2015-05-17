package com.mauriciotogneri.jan.compiler.semantic.nodes.arithmetic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;

public class PowerNode extends PrimitiveNode
{
	public PowerNode(Token token)
	{
		super(token, 2);
	}
}