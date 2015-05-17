package com.mauriciotogneri.jan.kernel.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.BinaryBooleanNode;

public class AndNode extends BinaryBooleanNode
{
	public AndNode(Token token)
	{
		super(token);
	}
	
	@Override
	protected Value evaluate(Boolean operand1, Boolean operand2)
	{
		return Value.booleanValue(operand1 && operand2);
	}
}