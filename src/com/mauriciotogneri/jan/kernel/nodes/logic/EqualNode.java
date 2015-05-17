package com.mauriciotogneri.jan.kernel.nodes.logic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.BinaryNode;

public class EqualNode extends BinaryNode
{
	public EqualNode(Token token)
	{
		super(token);
	}
	
	@Override
	protected Value evaluate(BigDecimal operand1, BigDecimal operand2)
	{
		return Value.booleanValue(operand1.compareTo(operand2) == 0);
	}
	
	@Override
	protected Value evaluate(Boolean operand1, Boolean operand2)
	{
		return Value.booleanValue(operand1.booleanValue() == operand2.booleanValue());
	}
}