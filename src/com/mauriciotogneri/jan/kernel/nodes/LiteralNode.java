package com.mauriciotogneri.jan.kernel.nodes;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Node;
import com.mauriciotogneri.jan.kernel.Value;

public class LiteralNode extends Node
{
	private final Value value;
	
	public LiteralNode(Token token)
	{
		super(token);
		
		if ((token.type == Token.Type.INTEGER) || (token.type == Token.Type.FLOAT))
		{
			this.value = Value.asNumber(new BigDecimal(token.lexeme));
		}
		else if (token.type == Token.Type.STRING)
		{
			this.value = Value.asString(token.lexeme);
		}
		else if (token.type == Token.Type.BOOLEAN)
		{
			this.value = Value.asBoolean(Boolean.valueOf(token.lexeme.equals(".")));
		}
		else
		{
			this.value = null;
		}
	}
	
	@Override
	public Value evaluate(Context context)
	{
		return this.value;
	}
}