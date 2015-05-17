package com.mauriciotogneri.jan.compiler.semantic.nodes.arithmetic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.operations.UnaryNumericNode;
import com.mauriciotogneri.jan.kernel.Value;

public class IncrementNode extends UnaryNumericNode
{
	public IncrementNode(Token token)
	{
		super(token);
	}
	
	@Override
	public Value evaluate(BigDecimal operand)
	{
		return Value.numberValue(operand.add(BigDecimal.ONE));
	}
}