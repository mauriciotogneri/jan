package com.mauriciotogneri.jan.compiler.syntactic;

import com.mauriciotogneri.jan.compiler.lexical.Token;

public class SyntacticException extends RuntimeException
{
	private static final long serialVersionUID = -4336303078381836231L;
	
	public SyntacticException(String message, Token token)
	{
		super(message + " => '" + token + "' at: [" + token.line + ", " + token.column + "]");
	}
	
	public SyntacticException(String message, int line, int column)
	{
		super(message + " at: [" + line + ", " + column + "]");
	}
	
	public SyntacticException(Token token)
	{
		super("Invalid token '" + token + "' at: [" + token.line + ", " + token.column + "]");
	}
}