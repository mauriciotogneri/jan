package com.mauriciotogneri.jan.kernel.nodes.arithmetic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.UnaryNumericNode;

public class DecrementNode extends UnaryNumericNode
{
	public DecrementNode(Token token)
	{
		super(token);
	}
	
	@Override
	public Value evaluate(BigDecimal operand)
	{
		return Value.asNumber(operand.subtract(BigDecimal.ONE));
	}
}