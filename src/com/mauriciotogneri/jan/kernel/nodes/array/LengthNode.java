package com.mauriciotogneri.jan.kernel.nodes.array;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

import java.math.BigDecimal;
import java.util.List;

public class LengthNode extends PrimitiveNode
{
	public LengthNode(Token token)
	{
		super(token, 1);
	}
	
	@Override
	public Value evaluate(Context context)
	{
		Value operand = get(0, context);
		
		if (operand.isList())
		{
			List<Value> value = operand.getList();
			
			return Value.asNumber(BigDecimal.valueOf(value.size()));
		}
		else if (operand.isString())
		{
			String value = operand.getString();
			
			return Value.asNumber(BigDecimal.valueOf(value.length()));
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + token.lexeme + "' at: [" + token.line + ", " + token.column + "]");
	}
}