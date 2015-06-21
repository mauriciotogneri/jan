package com.mauriciotogneri.jan.kernel.nodes.arithmetic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.BinaryNumericNode;

import java.math.BigDecimal;

public class SubtractNode extends BinaryNumericNode
{
	public SubtractNode(Token token)
	{
		super(token);
	}
	
	@Override
	public Value evaluate(BigDecimal operand1, BigDecimal operand2)
	{
		return Value.asNumber(operand1.subtract(operand2));
	}
}