package com.mauriciotogneri.jan.kernel.nodes.logic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.BinaryNumericNode;

public class LessNode extends BinaryNumericNode
{
	public LessNode(Token token)
	{
		super(token);
	}
	
	@Override
	protected Value evaluate(BigDecimal operand1, BigDecimal operand2)
	{
		return Value.asBoolean(operand1.compareTo(operand2) < 0);
	}
}