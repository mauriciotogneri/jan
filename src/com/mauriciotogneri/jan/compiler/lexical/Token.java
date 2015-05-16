package com.mauriciotogneri.jan.compiler.lexical;

public class Token
{
	public final String lexeme;
	public final Type type;
	public final int line;
	public final int column;
	
	public static enum Type
	{
		// general
		SYMBOL, //
		IMPORT, //
		COMMENT, //
		
		// delimiters
		SPACE, //
		TAB, //
		NEW_LINE, //
		
		// literals
		INTEGER, //
		FLOAT, //
		STRING, //
		BOOLEAN, //
		
		// arithmetic
		ARITHMETIC_ADD, //
		ARITHMETIC_SUBSTRACT, //
		ARITHMETIC_MULTIPLICATION, //
		ARITHMETIC_DIVISION, //
		ARITHMETIC_POWER, //
		ARITHMETIC_MODULE, //
		ARITHMETIC_INCREMENT, //
		ARITHMETIC_DECREMENT, //
		
		// logic
		LOGIC_EQUAL, //
		LOGIC_NOT_EQUAL, //
		LOGIC_GREATER, //
		LOGIC_GREATER_EQUAL, //
		LOGIC_LESS, //
		LOGIC_LESS_EQUAL, //
		LOGIC_AND, //
		LOGIC_OR, //
		LOGIC_NEGATION, //
		
		// conditional
		CONDITIONAL_IF, //
		
		// arrays
		ARRAY_INDEX, //
		ARRAY_OPEN, //
		ARRAY_CLOSE, //
	}
	
	public Token(String lexeme, Type type, int line, int column)
	{
		this.lexeme = lexeme;
		this.type = type;
		this.line = line;
		this.column = column;
	}
	
	@Override
	public String toString()
	{
		return this.type.toString() + ":\t" + this.lexeme;
	}
}