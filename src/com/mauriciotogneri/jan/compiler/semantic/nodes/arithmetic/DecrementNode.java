package com.mauriciotogneri.jan.compiler.semantic.nodes.arithmetic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.operations.UnaryNumericNode;
import com.mauriciotogneri.jan.kernel.Value;

public class DecrementNode extends UnaryNumericNode
{
	public DecrementNode(Token token)
	{
		super(token);
	}
	
	@Override
	public Value evaluate(BigDecimal operand)
	{
		return Value.numberValue(operand.subtract(BigDecimal.ONE));
	}
}