package com.mauriciotogneri.jan.kernel.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.UnaryBooleanNode;

public class NegationNode extends UnaryBooleanNode
{
	public NegationNode(Token token)
	{
		super(token);
	}
	
	@Override
	protected Value evaluate(Boolean operand)
	{
		return Value.asBoolean(!operand);
	}
}