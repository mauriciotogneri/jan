package com.mauriciotogneri.jan.compiler.semantic.nodes;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.Node;
import com.mauriciotogneri.jan.kernel.symbols.Operand.Type;

public class LiteralNode extends Node
{
	public final Type type;
	private final Object value;
	
	public LiteralNode(Token token)
	{
		super(token);
		
		if ((token.type == Token.Type.INTEGER) || (token.type == Token.Type.FLOAT))
		{
			this.type = Type.NUMBER;
			this.value = new BigDecimal(token.lexeme);
		}
		else if (token.type == Token.Type.STRING)
		{
			this.type = Type.STRING;
			this.value = token.lexeme;
		}
		else if (token.type == Token.Type.BOOLEAN)
		{
			this.type = Type.BOOLEAN;
			this.value = Boolean.valueOf(token.lexeme.equals("."));
		}
		else
		{
			this.type = null;
			this.value = null;
		}
	}
	
	public LiteralNode(Token token, Object value)
	{
		super(token);
		
		this.type = Type.LIST;
		this.value = value;
	}
}