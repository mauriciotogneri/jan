package com.mauriciotogneri.jan.kernel.nodes.arithmetic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.BinaryNumericNode;

public class PowerNode extends BinaryNumericNode
{
	public PowerNode(Token token)
	{
		super(token);
	}
	
	@Override
	public Value evaluate(BigDecimal operand1, BigDecimal operand2)
	{
		return Value.asNumber(operand1.pow(operand2.intValue()));
	}
}