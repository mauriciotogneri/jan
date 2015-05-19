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
		return Value.asBoolean(operand1.compareTo(operand2) == 0);
	}
	
	@Override
	protected Value evaluate(Boolean operand1, Boolean operand2)
	{
		return Value.asBoolean(operand1.booleanValue() == operand2.booleanValue());
	}
	
	@Override
	protected Value evaluate(String operand1, String operand2)
	{
		return Value.asBoolean(operand1.equals(operand2));
	}
}