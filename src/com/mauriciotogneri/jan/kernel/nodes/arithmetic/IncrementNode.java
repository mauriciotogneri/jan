package com.mauriciotogneri.jan.kernel.nodes.arithmetic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.UnaryNumericNode;

public class IncrementNode extends UnaryNumericNode
{
	public IncrementNode(Token token)
	{
		super(token);
	}
	
	@Override
	public Value evaluate(BigDecimal operand)
	{
		return Value.asNumber(operand.add(BigDecimal.ONE));
	}
}