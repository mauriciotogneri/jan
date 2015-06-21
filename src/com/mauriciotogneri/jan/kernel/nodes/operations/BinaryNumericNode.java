package com.mauriciotogneri.jan.kernel.nodes.operations;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

import java.math.BigDecimal;

public abstract class BinaryNumericNode extends PrimitiveNode
{
	protected BinaryNumericNode(Token token)
	{
		super(token, 2);
	}
	
	@Override
	public Value evaluate(Context context)
	{
		Value operand1 = get(0, context);
		Value operand2 = get(1, context);
		
		if (operand1.isNumber() && operand2.isNumber())
		{
			BigDecimal value1 = operand1.getNumber();
			BigDecimal value2 = operand2.getNumber();
			
			return evaluate(value1, value2);
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + token.lexeme + "' at: [" + token.line + ", " + token.column + "]");
	}
	
	protected abstract Value evaluate(BigDecimal operand1, BigDecimal operand2);
}