package com.mauriciotogneri.jan.compiler.lexical;

public class Token
{
	public final String lexeme;
	public final Type type;
	public final int line;
	public final int column;
	
	public static enum Type
	{
		SYMBOL,
		
		// arithmetic
		ARITHMETIC_ADD, //
		ARITHMETIC_SUBSTRACT
	}
	
	public Token(String lexeme, Type type, int line, int column)
	{
		this.lexeme = lexeme;
		this.type = type;
		this.line = line;
		this.column = column;
	}
}