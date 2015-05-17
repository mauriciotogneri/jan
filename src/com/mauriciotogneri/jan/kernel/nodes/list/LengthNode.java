package com.mauriciotogneri.jan.kernel.nodes.list;

import java.math.BigDecimal;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Node;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

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
			List<Node> value = operand.getList();
			
			return Value.numberValue(BigDecimal.valueOf(value.size()));
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + this.token.lexeme + "' at: [" + this.token.line + ", " + this.token.column + "]");
	}
}