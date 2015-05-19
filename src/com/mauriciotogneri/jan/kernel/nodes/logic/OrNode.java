package com.mauriciotogneri.jan.kernel.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.BinaryBooleanNode;

public class OrNode extends BinaryBooleanNode
{
	public OrNode(Token token)
	{
		super(token);
	}
	
	@Override
	protected Value evaluate(Boolean operand1, Boolean operand2)
	{
		return Value.asBoolean(operand1 || operand2);
	}
}