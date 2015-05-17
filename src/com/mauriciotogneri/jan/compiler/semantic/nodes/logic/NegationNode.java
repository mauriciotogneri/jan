package com.mauriciotogneri.jan.compiler.semantic.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.operations.UnaryBooleanNode;
import com.mauriciotogneri.jan.kernel.Value;

public class NegationNode extends UnaryBooleanNode
{
	public NegationNode(Token token)
	{
		super(token);
	}
	
	@Override
	protected Value evaluate(Boolean operand)
	{
		return Value.booleanValue(!operand);
	}
}