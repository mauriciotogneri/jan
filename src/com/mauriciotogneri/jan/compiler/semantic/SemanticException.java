package com.mauriciotogneri.jan.compiler.semantic;

import com.mauriciotogneri.jan.compiler.lexical.Token;

public class SemanticException extends RuntimeException
{
	private static final long serialVersionUID = 8235362518654985229L;
	
	public SemanticException(String message, Token token)
	{
		super(message + " '" + token + "' at: [" + token.line + ", " + token.column + "]");
	}
	
	public SemanticException(String message)
	{
		super(message);
	}
}