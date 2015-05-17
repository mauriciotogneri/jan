package com.mauriciotogneri.jan.compiler.semantic.nodes.logic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.operations.BinaryNumericNode;
import com.mauriciotogneri.jan.kernel.Value;

public class LessNode extends BinaryNumericNode
{
	public LessNode(Token token)
	{
		super(token);
	}
	
	@Override
	protected Value evaluate(BigDecimal operand1, BigDecimal operand2)
	{
		return Value.booleanValue(operand1.compareTo(operand2) < 0);
	}
}