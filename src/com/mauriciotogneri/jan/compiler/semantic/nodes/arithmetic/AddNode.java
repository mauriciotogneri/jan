package com.mauriciotogneri.jan.compiler.semantic.nodes.arithmetic;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.operations.BinaryNumericNode;
import com.mauriciotogneri.jan.kernel.Value;

public class AddNode extends BinaryNumericNode
{
	public AddNode(Token token)
	{
		super(token);
	}
	
	@Override
	public Value evaluate(BigDecimal operand1, BigDecimal operand2)
	{
		return Value.numberValue(operand1.add(operand2));
	}
}