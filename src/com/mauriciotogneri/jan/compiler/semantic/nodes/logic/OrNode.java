package com.mauriciotogneri.jan.compiler.semantic.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.operations.BinaryBooleanNode;
import com.mauriciotogneri.jan.kernel.Value;

public class OrNode extends BinaryBooleanNode
{
	public OrNode(Token token)
	{
		super(token);
	}
	
	@Override
	protected Value evaluate(Boolean operand1, Boolean operand2)
	{
		return Value.booleanValue(operand1 || operand2);
	}
}