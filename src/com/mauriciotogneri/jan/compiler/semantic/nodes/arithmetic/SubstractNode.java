package com.mauriciotogneri.jan.compiler.semantic.nodes.arithmetic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.operations.BinaryNumericNode;
import com.mauriciotogneri.jan.kernel.Value;

public class SubstractNode extends BinaryNumericNode
{
	public SubstractNode(Token token)
	{
		super(token);
	}
	
	@Override
	public Value evaluate(BigDecimal operand1, BigDecimal operand2)
	{
		return Value.numberValue(operand1.subtract(operand2));
	}
}