package com.mauriciotogneri.jan.kernel.nodes.operations;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

public abstract class BinaryNode extends PrimitiveNode
{
	public BinaryNode(Token token)
	{
		super(token, 2);
	}
	
	@Override
	public Value evaluate(Context context)
	{
		Value operand1 = get(0, context);
		Value operand2 = get(1, context);
		
		if (operand1.isBoolean() && operand2.isBoolean())
		{
			Boolean value1 = operand1.getBoolean();
			Boolean value2 = operand2.getBoolean();
			
			return evaluate(value1, value2);
		}
		else if (operand1.isNumber() && operand2.isNumber())
		{
			BigDecimal value1 = operand1.getNumber();
			BigDecimal value2 = operand2.getNumber();
			
			return evaluate(value1, value2);
		}
		else if (operand1.isString() && operand2.isString())
		{
			String value1 = operand1.getString();
			String value2 = operand2.getString();
			
			return evaluate(value1, value2);
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + this.token.lexeme + "' at: [" + this.token.line + ", " + this.token.column + "]");
	}
	
	protected abstract Value evaluate(BigDecimal operand1, BigDecimal operand2);
	
	protected abstract Value evaluate(Boolean operand1, Boolean operand2);
	
	protected abstract Value evaluate(String operand1, String operand2);
}