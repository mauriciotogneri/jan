package com.mauriciotogneri.jan.compiler.semantic.nodes;

import java.math.BigDecimal;
import java.util.List;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.Node;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;

public class LiteralNode extends Node
{
	private final Value value;
	
	public LiteralNode(Token token)
	{
		super(token);
		
		if ((token.type == Token.Type.INTEGER) || (token.type == Token.Type.FLOAT))
		{
			this.value = Value.numberValue(new BigDecimal(token.lexeme));
		}
		else if (token.type == Token.Type.STRING)
		{
			this.value = Value.stringValue(token.lexeme);
		}
		else if (token.type == Token.Type.BOOLEAN)
		{
			this.value = Value.booleanValue(Boolean.valueOf(token.lexeme.equals(".")));
		}
		else
		{
			this.value = null;
		}
	}
	
	public LiteralNode(Token token, List<Node> value)
	{
		super(token);
		
		this.value = Value.listValue(value);
	}
	
	@Override
	public Value evaluate(ProgramDefinition program, Context context)
	{
		return this.value;
	}
}